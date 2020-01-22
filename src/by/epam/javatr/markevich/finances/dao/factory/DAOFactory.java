package by.epam.javatr.markevich.finances.dao.factory;

import by.epam.javatr.markevich.finances.dao.TransactionDAO;
import by.epam.javatr.markevich.finances.dao.impl.FileTransactionDAOImpl;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final TransactionDAO fileTransactionDAOImpl = new FileTransactionDAOImpl();

    private DAOFactory(){}

    public static DAOFactory getInstance() {
        return instance;
    }

    public TransactionDAO getTransactionDAOImpl() {
        return fileTransactionDAOImpl;
    }
}
