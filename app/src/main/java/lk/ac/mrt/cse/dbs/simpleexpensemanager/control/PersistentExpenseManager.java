package lk.ac.mrt.cse.dbs.simpleexpensemanager.control;


import lk.ac.mrt.cse.dbs.simpleexpensemanager.ContextProvider;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.AccountDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.TransactionDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.impl.PersistentAccountDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.impl.PersistentTransactionDAO;

/**
 * Created by Ravidu Lashan on 03/12/2015.
 */
public class PersistentExpenseManager extends ExpenseManager {
    public PersistentExpenseManager() {
        setup();
    }

    @Override
    public void setup() {
        // Updated setup implementation to fit the data access from Database
        TransactionDAO persistantTransactionDAO = new PersistentTransactionDAO(ContextProvider.getCustomAppContext());
        setTransactionsDAO(persistantTransactionDAO);

        AccountDAO persistentAccountDAO = new PersistentAccountDAO(ContextProvider.getCustomAppContext());
        setAccountsDAO(persistentAccountDAO);

    }
}
