package by.epam.javatr.markevich.finances.service.validation;

import by.epam.javatr.markevich.finances.bean.Transaction;
import by.epam.javatr.markevich.finances.service.exception.ServiceException;

import java.math.BigDecimal;
import java.util.Date;

public class Validator {

    private static final double EPS = 0.0001;

    public static void validate(Transaction transaction) throws ServiceException {
        checkNull(transaction);
        validate(transaction.getId());
        validate(transaction.getSum());
        validate(transaction.getDate());
        validate(transaction.getName());
        validate(transaction.getType());
    }

    private static void checkNull(Transaction transaction) throws ServiceException{
        if (transaction == null) {
            throw new ServiceException("Transaction is null");
        }
    }

    private static void validate(BigDecimal amount) throws ServiceException{
        if (amount.doubleValue() - 0 < EPS) {
            throw new ServiceException("Invalid transaction amount");
        }
    }

    private static void validate(Date date) throws ServiceException{
        if (date.after(new Date())) {
            throw new ServiceException("Invalid transaction date");
        }
    }

    private static void validate(String title) throws ServiceException{
        if (title == null) {
            throw new ServiceException("Invalid transaction title");
        }
    }

    private static void validate(Enum<?> type) throws ServiceException{
        if (type == null) {
            throw new ServiceException("Transaction type is null");
        }
    }

    public static void validate(int id) throws ServiceException{
        if (id < 0) {
            throw new ServiceException("Transaction id is invalid");
        }
    }
}
