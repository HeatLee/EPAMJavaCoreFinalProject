package by.epam.javatr.markevich.finances.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Expense extends Transaction implements Serializable {
    private static final ExpenseType DEFAULT_TYPE = ExpenseType.EXPENSES;

    public Expense() {
        this.transactionId = ++amount;
        this.name = DEFAULT_NAME;
        this.date = new Date();
        this.sum = DEFAULT_SUM;
        this.type = DEFAULT_TYPE;
    }

    public Expense(String name, BigDecimal sum, ExpenseType type) {
        this.transactionId = ++amount;
        this.name = name;
        this.sum = sum;
        this.type = type;
        this.date = new Date();
    }

    public Expense(String name, Date date, BigDecimal sum, ExpenseType type) {
        this(name, sum, type);
        this.date = date;
    }

    public Expense(int id, String name, Date date, BigDecimal sum, ExpenseType type) {
        this.transactionId = createGlobalId(id);
        this.name = name;
        this.sum = sum;
        this.type = type;
        this.date = date;
    }
}
