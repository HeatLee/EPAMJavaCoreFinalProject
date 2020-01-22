package by.epam.javatr.markevich.finances.dao;

import by.epam.javatr.markevich.finances.bean.Transaction;
import by.epam.javatr.markevich.finances.dao.exception.DAOException;

public interface TransactionDAO {

    void add(Transaction transaction) throws DAOException;

    void update(long id, Transaction transaction) throws DAOException;

    Transaction get(long id) throws DAOException;

    Transaction[] getAll() throws DAOException;

    void delete(int id) throws DAOException;

}
