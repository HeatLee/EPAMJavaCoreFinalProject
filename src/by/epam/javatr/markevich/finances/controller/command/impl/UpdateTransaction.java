package by.epam.javatr.markevich.finances.controller.command.impl;

import by.epam.javatr.markevich.finances.bean.Transaction;
import by.epam.javatr.markevich.finances.controller.command.Command;
import by.epam.javatr.markevich.finances.controller.command.util.TransactionTransformer;
import by.epam.javatr.markevich.finances.service.TransactionLogService;
import by.epam.javatr.markevich.finances.service.exception.ServiceException;
import by.epam.javatr.markevich.finances.service.factory.ServiceFactory;

public class UpdateTransaction implements Command {
    private static final String SUCCESS = "Entry has been added.";
    @Override
    public String execute(String request) {
        String[] requestData = request.split(REGEX);
        if (requestData.length != 4) {
            return INVALID_PARAMETERS_AMOUNT_RESPONSE;
        }
        int insertId;
        try {
            insertId = Integer.parseInt(requestData[0]);
        } catch (NumberFormatException e) {
            return INVALID_PARAMETER_VALUE_RESPONSE;
        }
        Transaction newTransaction = TransactionTransformer.create(insertId, requestData[1], requestData[2],
                requestData[3]);
        if (newTransaction == null) {
            return INVALID_PARAMETER_VALUE_RESPONSE;
        }
        ServiceFactory factory = ServiceFactory.getInstance();
        TransactionLogService service = factory.getTransactionLogServiceImpl();
        String response;
        try {
            service.update(insertId, newTransaction);
            response = SUCCESS;
        } catch (ServiceException e) {
            return e.getMessage();
        }
        return response;
    }
}
