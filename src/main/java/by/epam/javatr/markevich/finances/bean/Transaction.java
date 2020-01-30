package by.epam.javatr.markevich.finances.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public abstract class Transaction implements Serializable {
    private static final int HASH_PRIME = 31;
    protected static final String DEFAULT_NAME = "";
    protected static final BigDecimal DEFAULT_SUM = new BigDecimal(0);

    protected static int amount;

    protected int transactionId;
    protected String name;
    protected Date date;
    protected BigDecimal sum;
    protected Enum<?> type;

    public int getId() {
        return transactionId;
    }

    public void setId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public Enum<?> getType() {
        return type;
    }

    public void setType(Enum<?> type) {
        this.type = type;
    }

    protected int createGlobalId(int id) {
        if (id > amount) {
            amount = id;
            return id;
        }
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        if (transactionId != that.transactionId) {
            return false;
        }
        if (sum == null) {
            if (that.sum != null) {
                return false;
            }
        } else {
            if (!sum.equals(that.sum)) {
                return false;
            }
        }
        if (name == null) {
            if (that.name != null) {
                return false;
            }
        } else {
            if (!name.equals(that.name)) {
                return false;
            }
        }
        if (date == null) {
            if (that.date != null) {
                return false;
            }
        } else {
            if (!date.equals(that.date)) {
                return false;
            }
        }
        if (type == null) {
            if (that.type != null) {
                return false;
            }
        } else {
            if (!type.equals(that.type)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = hash * HASH_PRIME + transactionId;
        hash = hash * HASH_PRIME + sum.hashCode();
        hash = hash * HASH_PRIME + name.hashCode();
        hash = hash * HASH_PRIME + date.hashCode();
        hash = hash * HASH_PRIME + type.hashCode();
        return hash;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +"{" +
                "transactionId=" + transactionId +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", sum=" + sum +
                ", type=" + type +
                '}';
    }
}
