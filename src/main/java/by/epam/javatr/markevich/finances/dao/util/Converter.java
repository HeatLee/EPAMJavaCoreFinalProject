package by.epam.javatr.markevich.finances.dao.util;

import by.epam.javatr.markevich.finances.bean.*;
import by.epam.javatr.markevich.finances.dao.exception.InvalidFieldException;
import by.epam.javatr.markevich.finances.dao.exception.InvalidParameterException;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Converter {
    private static final String DATE_FORMAT = "dd-mm-yyyy hh:mm:ss";
    private static final String SEPARATOR = "|";
    private static final String REGEX = "\\|";
    private static final int VALID_LENGTH = 6;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
    private static final String EXPENSE_TYPENAME = "Expense";
    private static final String INCOME_TYPENAME = "Income";

    public static String convertToString(Transaction transaction) throws InvalidParameterException, InvalidFieldException {
        if (transaction == null) {
            throw new InvalidParameterException("Incoming parameter has empty address");
        }
        if (transaction.getDate() == null || transaction.getName() == null
                || transaction.getSum() == null || transaction.getType() == null) {
            throw new InvalidFieldException("Invalid field value");
        }
        return pars(transaction);
    }

    public static Transaction parseToObject(String data)
            throws InvalidParameterException, InvalidFieldException {
        if (data == null) {
            throw new InvalidParameterException("Incoming parameter has empty address");
        }
        String[] fields = data.split(REGEX);
        if (fields.length != VALID_LENGTH) {
            throw new InvalidParameterException("Invalid amount of fields in entry");
        }
        try {
            return createObject(fields);
        } catch (ParseException e) {
            throw new InvalidFieldException("Invalid date format in data source", e);
        } catch (IllegalArgumentException e) {
            throw new InvalidFieldException("Invalid field value in data source", e);
        }
    }

    private static Transaction createObject(String[] fields) throws InvalidParameterException, ParseException{
        Transaction transaction;
        if (fields[0].equals(EXPENSE_TYPENAME)) {
            transaction = new Expense(Integer.parseInt(fields[1]), fields[2], dateFormat.parse(fields[3]),
                    new BigDecimal(fields[4]), ExpenseType.valueOf(fields[5]));
        } else if (fields[0].equals(INCOME_TYPENAME)) {
            transaction = new Income(Integer.parseInt(fields[1]), fields[2], dateFormat.parse(fields[3]),
                    new BigDecimal(fields[4]), IncomeType.valueOf(fields[5]));
        } else {
            throw new InvalidParameterException("Invalid key field value in data source");
        }
        return transaction;
    }

    private static String pars(Transaction transaction) {
        return transaction.getClass().getSimpleName() + SEPARATOR +
                transaction.getId() + SEPARATOR +
                transaction.getName() + SEPARATOR +
                dateFormat.format(transaction.getDate()) + SEPARATOR +
                transaction.getSum() + SEPARATOR +
                transaction.getType();
    }
}
