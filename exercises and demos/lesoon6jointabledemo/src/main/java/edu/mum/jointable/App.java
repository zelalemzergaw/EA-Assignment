package edu.mum.jointable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class App {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs544");

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Account account1 = new CheckingAccount(1001L, 2000, 200.00);
		Account account2 = new SavingsAccount(1002L, 3000, 300.00);

		em.persist(account1);
		em.persist(account2);

		em.getTransaction().commit();

		em.getTransaction().begin();
		TypedQuery<Account> query = em.createQuery("from Account", Account.class);
		List<Account> accounts = query.getResultList();
		System.out.println(accounts);

		em.getTransaction().commit();
		emf.close();
	}

}
