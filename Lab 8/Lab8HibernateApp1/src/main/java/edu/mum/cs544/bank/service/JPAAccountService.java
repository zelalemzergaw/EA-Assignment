package edu.mum.cs544.bank.service;

import edu.mum.cs544.bank.EntityManagerHelper;
import edu.mum.cs544.bank.dao.AccountDAO;
import edu.mum.cs544.bank.dao.IAccountDAO;
import edu.mum.cs544.bank.dao.JPAAccountDao;
import edu.mum.cs544.bank.domain.Account;
import edu.mum.cs544.bank.domain.Customer;
import edu.mum.cs544.bank.logging.ILogger;
import edu.mum.cs544.bank.logging.Logger;

import javax.persistence.EntityManager;
import java.util.Collection;

public class JPAAccountService implements IAccountService {

    private IAccountDAO accountDAO;
    private ICurrencyConverter currencyConverter;
    private ILogger logger;

    public JPAAccountService() {
        accountDAO = new JPAAccountDao();
        currencyConverter = new CurrencyConverter();
        logger = new Logger();
    }

    public Account createAccount(long accountNumber, String customerName) {
        EntityManager em = EntityManagerHelper.getCurrent();
        em.getTransaction().begin();
        Account account = new Account(accountNumber);
        Customer customer = new Customer(customerName);
        account.setCustomer(customer);
        accountDAO.saveAccount(account);
        em.getTransaction().commit();
        logger.log("createAccount with parameters accountNumber= " + accountNumber + " , customerName= " + customerName);
        return account;
    }

    public void deposit(long accountNumber, double amount) {
        EntityManager em = EntityManagerHelper.getCurrent();
        em.getTransaction().begin();
        Account account = accountDAO.loadAccount(accountNumber);
        account.deposit(amount);
        accountDAO.updateAccount(account);
        em.getTransaction().commit();
        logger.log("deposit with parameters accountNumber= " + accountNumber + " , amount= " + amount);
    }

    public Account getAccount(long accountNumber) {
        EntityManager em = EntityManagerHelper.getCurrent();
        em.getTransaction().begin();
        Account account = accountDAO.loadAccount(accountNumber);
        em.getTransaction().commit();
        return account;
    }

    public Collection<Account> getAllAccounts() {
        EntityManager em = EntityManagerHelper.getCurrent();
        em.getTransaction().begin();
        Collection<Account> accounts = accountDAO.getAccounts();
        em.getTransaction().commit();
        return accounts;
    }

    public void withdraw(long accountNumber, double amount) {
        EntityManager em = EntityManagerHelper.getCurrent();
        em.getTransaction().begin();
        Account account = accountDAO.loadAccount(accountNumber);
        account.withdraw(amount);
        accountDAO.updateAccount(account);
        em.getTransaction().commit();
        logger.log("withdraw with parameters accountNumber= " + accountNumber + " , amount= " + amount);
    }

    public void depositEuros(long accountNumber, double amount) {
        EntityManager em = EntityManagerHelper.getCurrent();
        em.getTransaction().begin();
        Account account = accountDAO.loadAccount(accountNumber);
        double amountDollars = currencyConverter.euroToDollars(amount);
        account.deposit(amountDollars);
        accountDAO.updateAccount(account);
        em.getTransaction().commit();
        logger.log("depositEuros with parameters accountNumber= " + accountNumber + " , amount= " + amount);
    }

    public void withdrawEuros(long accountNumber, double amount) {
        EntityManager em = EntityManagerHelper.getCurrent();
        em.getTransaction().begin();
        Account account = accountDAO.loadAccount(accountNumber);
        double amountDollars = currencyConverter.euroToDollars(amount);
        account.withdraw(amountDollars);
        accountDAO.updateAccount(account);
        em.getTransaction().commit();
        logger.log("withdrawEuros with parameters accountNumber= " + accountNumber + " , amount= " + amount);
    }

    public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
        EntityManager em = EntityManagerHelper.getCurrent();
        em.getTransaction().begin();
        Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
        Account toAccount = accountDAO.loadAccount(toAccountNumber);
        fromAccount.transferFunds(toAccount, amount, description);
        accountDAO.updateAccount(fromAccount);
        accountDAO.updateAccount(toAccount);
        em.getTransaction().commit();
        logger.log("transferFunds with parameters fromAccountNumber= " + fromAccountNumber + " , toAccountNumber= " + toAccountNumber + " , amount= " + amount + " , description= " + description);
    }
}
