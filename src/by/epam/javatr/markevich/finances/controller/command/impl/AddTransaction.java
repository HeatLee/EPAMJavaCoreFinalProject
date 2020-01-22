package by.epam.javatr.markevich.finances.controller.command.impl;

import by.epam.javatr.markevich.finances.bean.Transaction;
import by.epam.javatr.markevich.finances.controller.command.Command;
import by.epam.javatr.markevich.finances.controller.command.util.TransactionTransformer;
import by.epam.javatr.markevich.finances.service.TransactionLogService;
import by.epam.javatr.markevich.finances.service.exception.ServiceException;
import by.epam.javatr.markevich.finances.service.factory.ServiceFactory;

public class AddTransaction implements Command {
    private static final String SUCCESS = "Entry has been added.";
    @Override
    public String execute(String request) {
        String response;
        String[] requestData = request.split(REGEX);
        if (requestData.length != 3) {
            return  INVALID_PARAMETERS_AMOUNT_RESPONSE;
        }
        Transaction transaction = TransactionTransformer.create(requestData[0], requestData[1], requestData[2]);
        if (transaction == null) {
            return INVALID_PARAMETER_VALUE_RESPONSE;
        }
        ServiceFactory factory = ServiceFactory.getInstance();
        TransactionLogService service = factory.getTransactionLogServiceImpl();
        try {
            service.add(transaction);
            response = SUCCESS;
        } catch (ServiceException e) {
            return e.getMessage();
        }
        return response;
    }
}
