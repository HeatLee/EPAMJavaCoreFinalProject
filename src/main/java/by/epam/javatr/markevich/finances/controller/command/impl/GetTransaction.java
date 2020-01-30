package by.epam.javatr.markevich.finances.controller.command.impl;

import by.epam.javatr.markevich.finances.controller.command.Command;
import by.epam.javatr.markevich.finances.controller.command.util.TransactionTransformer;
import by.epam.javatr.markevich.finances.service.TransactionLogService;
import by.epam.javatr.markevich.finances.service.exception.ServiceException;
import by.epam.javatr.markevich.finances.service.factory.ServiceFactory;

public class GetTransaction implements Command {

    @Override
    public String execute(String request) {
        int transactionId;
        try {
            transactionId = Integer.parseInt(request);
        } catch (NumberFormatException e) {
            return INVALID_PARAMETER_VALUE_RESPONSE;
        }
        ServiceFactory factory = ServiceFactory.getInstance();
        TransactionLogService service = factory.getTransactionLogServiceImpl();
        String response;
        try {
            response = TransactionTransformer.transactionToPrintableString(service.get(transactionId));
        } catch (ServiceException e) {
            return e.getMessage();
        }
        return response;
    }
}
