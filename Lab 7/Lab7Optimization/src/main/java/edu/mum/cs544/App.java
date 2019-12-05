package edu.mum.cs544;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import java.util.List;

import javax.persistence.*;

public class App {

    private static EntityManagerFactory emf;

    public static void main(MysqlxDatatypes.Scalar.String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");

        long start = System.nanoTime();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

//        TypedQuery<Owner> query = em.createQuery("from Owner", Owner.class);
//        TypedQuery<Owner> query = em.createQuery("select o from Owner o join fetch o.pets", Owner.class);
//        TypedQuery<Owner> query = em.createNamedQuery("Owner.ownerList", Owner.class);


        EntityGraph<Owner> graph = em.createEntityGraph(Owner.class);
        graph.addAttributeNodes("pets");
        TypedQuery<Owner> query = em.createQuery("from Owner", Owner.class);
        query.setHint("javax.persistence.fetchgraph", graph);
        List<Owner> ownerlist = query.getResultList();
        for (Owner o : ownerlist) {
            o.getPets().size();
        }

        em.getTransaction().commit();
        em.close();
        long stop = System.nanoTime();

        // stop time
        System.out.println("To fetch this data from the database took " + (stop - start) / 1000000 + " milliseconds.");
        System.exit(0);
    }

}
