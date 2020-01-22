package by.epam.javatr.markevich.finances.controller.command.impl;

import by.epam.javatr.markevich.finances.bean.Transaction;
import by.epam.javatr.markevich.finances.controller.command.Command;
import by.epam.javatr.markevich.finances.controller.command.util.TransactionTransformer;
import by.epam.javatr.markevich.finances.service.TransactionLogService;
import by.epam.javatr.markevich.finances.service.exception.ServiceException;
import by.epam.javatr.markevich.finances.service.factory.ServiceFactory;

import java.text.SimpleDateFormat;

public class ViewTransactionLog implements Command {
    private static final String EMPTY_STRING = "";
    private static final String NEW_LINE = "\n";
    @Override
    public String execute(String request) {
        ServiceFactory factory = ServiceFactory.getInstance();
        TransactionLogService service = factory.getTransactionLogServiceImpl();
        StringBuilder response = new StringBuilder(EMPTY_STRING);
        Transaction[] transactions;
        try {
             transactions = service.getAll();
        } catch (ServiceException e) {
            return e.getMessage();
        }
        for (Transaction transaction : transactions) {
            response.append(TransactionTransformer.transactionToPrintableString(transaction)).
                    append(NEW_LINE);
        }
        return response.toString();
    }
}
