package by.epam.javatr.markevich.finances.service;

import by.epam.javatr.markevich.finances.bean.Transaction;
import by.epam.javatr.markevich.finances.service.exception.ServiceException;

import java.math.BigDecimal;

public interface TransactionLogService {

    boolean add(Transaction transaction) throws ServiceException;

    void update(int id, Transaction transaction) throws ServiceException;

    Transaction get(int id) throws ServiceException;

    Transaction[] getAll() throws ServiceException;

    BigDecimal getCurrentBalance() throws ServiceException;

    void delete(int id) throws ServiceException;

}
