package by.epam.javatr.markevich.finances.service.factory;

import by.epam.javatr.markevich.finances.service.TransactionLogService;
import by.epam.javatr.markevich.finances.service.impl.TransactionLogServiceImpl;

public final class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private final TransactionLogService transactionLogServiceImpl = new TransactionLogServiceImpl();

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        return instance;
    }

    public TransactionLogService getTransactionLogServiceImpl() {
        return transactionLogServiceImpl;
    }
}

