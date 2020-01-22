package by.epam.javatr.markevich.finances.controller.command.impl;

import by.epam.javatr.markevich.finances.bean.Transaction;
import by.epam.javatr.markevich.finances.controller.command.Command;
import by.epam.javatr.markevich.finances.service.TransactionLogService;
import by.epam.javatr.markevich.finances.service.exception.ServiceException;
import by.epam.javatr.markevich.finances.service.factory.ServiceFactory;

import java.math.BigDecimal;

public class CalculateBalance implements Command {
    @Override
    public String execute(String request) {
        ServiceFactory factory = ServiceFactory.getInstance();
        TransactionLogService service = factory.getTransactionLogServiceImpl();
        BigDecimal total;
        try {
            total = service.getCurrentBalance();
        } catch (ServiceException e) {
            return e.getMessage();
        }
        return total.toString();
    }
}
