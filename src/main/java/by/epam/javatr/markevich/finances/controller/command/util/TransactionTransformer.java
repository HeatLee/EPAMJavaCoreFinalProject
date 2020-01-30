package by.epam.javatr.markevich.finances.controller.command.util;

import by.epam.javatr.markevich.finances.bean.*;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionTransformer {
    private static final String SEPARATOR = " ";
    private static final String INVALID_PARAMETER_VALUE_RESPONSE = "Invalid transmitted parameter value";
    private static final String DATE_FORMAT = "dd-mm-yyyy hh:mm:ss";

    public static Transaction create(String newTransactionName, String newSum, String newType) {
        Date date = new Date();
        BigDecimal sum;
        newType = newType.toUpperCase();
        Transaction transaction;
        try {
            sum = BigDecimal.valueOf(Double.parseDouble(newSum));
            if (isTransactionType(ExpenseType.values(), newType)) {
                ExpenseType type = ExpenseType.valueOf(newType);
                transaction = new Expense(newTransactionName, date, sum, type);
            } else if (isTransactionType(IncomeType.values(), newType)) {
                IncomeType type = IncomeType.valueOf(newType);
                transaction = new Income(newTransactionName, date, sum, type);
            } else {
                throw new IllegalArgumentException(INVALID_PARAMETER_VALUE_RESPONSE);
            }
        } catch (IllegalArgumentException e) {
            return null;
        }
        return transaction;
    }

    public static Transaction create(int id, String newTransactionName, String newSum, String newType) {
        Transaction transaction = create(newTransactionName, newSum, newType);
        if (transaction != null) {
            transaction.setId(id);
        }
        return transaction;
    }

    private static boolean isTransactionType(Enum<?>[] types, String type) {
        for (Enum<?> t : types) {
            if (type.equals(t.toString())) {
                return true;
            }
        }
        return false;
    }

    public static String transactionToPrintableString(Transaction transaction) {
        return transaction.getId() + SEPARATOR + transaction.getName() + SEPARATOR +
                transaction.getSum() + SEPARATOR +
                new SimpleDateFormat(DATE_FORMAT).format(transaction.getDate()) + SEPARATOR +
                transaction.getType();
    }
}
