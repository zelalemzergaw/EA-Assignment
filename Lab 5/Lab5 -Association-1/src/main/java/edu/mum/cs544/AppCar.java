package edu.mum.cs544;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AppCar {

	private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("edu.mum.cs544");
        		
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();


        Owner owner1 = new Owner("zelalem zergaw","123 westroad fairfield");

        Owner owner2 = new Owner("Jeab Eric","1000 n west ave fairfield");

        // Create new instance of Car and set values in it
        Car car1 = new Car("BMW", "SDA231", 30221.00);
        // save the car
         car1.setOwner(owner1);
        em.persist(car1);
        Car car2 = new Car("honda", "2008", 25000.00);
        // save the car
        car2.setOwner(owner2);
        em.persist(car2);
        Car car3 = new Car("toyota", "2012", 15895.00);
        // save the car
        car3.setOwner(owner2);
        em.persist(car3);
        // Create new instance of Car and set values in it
        Car car4 = new Car("Mercedes", "HOO100", 4088.00);
        // save the car
        car4.setOwner(owner2);
        em.persist(car4);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        // retieve all cars
        TypedQuery<Car> query = em.createQuery("from Car", Car.class);
        List<Car> carList = query.getResultList();
        for (Car car : carList) {
            System.out.println("brand= " + car.getBrand() + ", year= "
                    + car.getYear() + ", price= " + car.getPrice());
        }
        em.getTransaction().commit();
        em.close();

//        em = emf.createEntityManager();
//        em.getTransaction().begin();
//
//        // Create new instance of owner and set values in it
//        Owner owner1 = new Owner("Thomas","Smith");
//        em.persist(owner1);
//        Owner owner2 = new Owner("Dave","Alex");
//        em.persist(owner2);
//
//        TypedQuery<Owner> query1 = em.createQuery("from Owner", Owner.class);
//        List<Owner> ownerList = query1.getResultList();
//        for (Owner owner : ownerList) {
//            System.out.println("name= " + owner.getName() + ", address= " + owner.getAddress());
//        }
//        em.getTransaction().commit();
//        em.close();
    }
}

