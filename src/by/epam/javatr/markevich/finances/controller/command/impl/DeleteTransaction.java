package by.epam.javatr.markevich.finances.controller.command.impl;

import by.epam.javatr.markevich.finances.controller.command.Command;
import by.epam.javatr.markevich.finances.service.TransactionLogService;
import by.epam.javatr.markevich.finances.service.exception.ServiceException;
import by.epam.javatr.markevich.finances.service.factory.ServiceFactory;

public class DeleteTransaction implements Command {
    private static final String SUCCESS = "Entry has been deleted";

    @Override
    public String execute(String request) {
        int id;
        try {
            id = Integer.parseInt(request);
        } catch (NumberFormatException e) {
            return INVALID_PARAMETER_VALUE_RESPONSE;
        }
        ServiceFactory factory = ServiceFactory.getInstance();
        TransactionLogService service = factory.getTransactionLogServiceImpl();
        try {
            service.delete(id);
            return SUCCESS;
        } catch (ServiceException e) {
            return e.getMessage();
        }
    }
}
