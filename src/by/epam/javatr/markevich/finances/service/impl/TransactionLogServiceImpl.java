package by.epam.javatr.markevich.finances.service.impl;

import by.epam.javatr.markevich.finances.bean.IncomeType;
import by.epam.javatr.markevich.finances.bean.Transaction;
import by.epam.javatr.markevich.finances.dao.TransactionDAO;
import by.epam.javatr.markevich.finances.dao.exception.DAOException;
import by.epam.javatr.markevich.finances.dao.factory.DAOFactory;
import by.epam.javatr.markevich.finances.service.TransactionLogService;
import by.epam.javatr.markevich.finances.service.exception.ServiceException;
import by.epam.javatr.markevich.finances.service.validation.Validator;

import java.math.BigDecimal;

public class TransactionLogServiceImpl implements TransactionLogService {

    private DAOFactory daoFactory = DAOFactory.getInstance();
    private TransactionDAO transactionDAO = daoFactory.getTransactionDAOImpl();

    @Override
    public boolean add(Transaction transaction) throws ServiceException {
        Validator.validate(transaction);
        try {
            transactionDAO.add(transaction);
        } catch (DAOException e) {
            throw new ServiceException("Failed to add entry", e);
        }
        return true;
    }

    @Override
    public void update(int id, Transaction transaction) throws ServiceException {
        Validator.validate(transaction);
        try {
            transactionDAO.update(id, transaction);
        } catch (DAOException e) {
            throw new ServiceException("Updating has been interrupted", e);
        }
    }

    @Override
    public Transaction get(int id) throws ServiceException {
        Validator.validate(id);
        try {
            return transactionDAO.get(id);
        } catch (DAOException e) {
            throw new ServiceException("Failed to get entry", e);
        }
    }

    @Override
    public Transaction[] getAll() throws ServiceException {
        return getAllFromDAO();
    }

    @Override
    public BigDecimal getCurrentBalance() throws ServiceException {
        Transaction[] transactions = getAllFromDAO();
        BigDecimal balance = new BigDecimal(0);
        for (Transaction transaction : transactions) {
            Validator.validate(transaction);
            balance = balance.add(calculateActualTransactionSum(transaction));
        }
        return balance;
    }

    private BigDecimal calculateActualTransactionSum(Transaction transaction) {
        BigDecimal actualTransactionSum;
        if (transaction.getType().getClass() == IncomeType.class) {
            actualTransactionSum = transaction.getSum();
        } else {
            actualTransactionSum = transaction.getSum().negate();
        }
        return actualTransactionSum;
    }

    @Override
    public void delete(int id) throws ServiceException {
        Validator.validate(id);
        try {
            transactionDAO.delete(id);
        } catch (DAOException e) {
            throw new ServiceException("Deleting has been interrupted.", e);
        }
    }

    private Transaction[] getAllFromDAO() throws ServiceException{
        try {
            return transactionDAO.getAll();
        } catch (DAOException e) {
            throw new ServiceException("Failed to get entries", e);
        }
    }
}
