package by.epam.javatr.markevich.finances.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Income extends Transaction implements Serializable{
    private static final IncomeType DEFAULT_TYPE = IncomeType.OTHER;

    public Income() {
        this.transactionId = ++amount;
        this.name = DEFAULT_NAME;
        this.date = new Date();
        this.sum = DEFAULT_SUM;
        this.type = DEFAULT_TYPE;
    }

    public Income(String name, BigDecimal sum, IncomeType type) {
        this.transactionId = ++amount;
        this.name = name;
        this.sum = sum;
        this.type = type;
        this.date = new Date();
    }

    public Income(String name, Date date, BigDecimal sum, IncomeType type) {
        this(name, sum, type);
        this.date = date;
    }

    public Income(int id, String name, Date date, BigDecimal sum, IncomeType type) {
        this.transactionId = createGlobalId(id);
        this.name = name;
        this.sum = sum;
        this.type = type;
        this.date = date;
    }
}
