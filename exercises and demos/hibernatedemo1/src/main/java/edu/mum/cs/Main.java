package edu.mum.cs;

import edu.mum.cs.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("edu.mum.cs");
        EntityManager em= factory.createEntityManager();
       EntityTransaction tr=em.getTransaction();
       tr.begin();
        Person per= new Person(1L,"zelalem","zergaw");
        em.persist(per);
        tr.commit();
        em.close();



    }
}
