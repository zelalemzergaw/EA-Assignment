package edu.mum.main;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.mum.domain.User;
import edu.mum.service.UserService;

import javax.naming.Context;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

  public static void main(String[] args) {
        ApplicationContext ctx;
      //System.out.println("1234566666");
      ctx = new ClassPathXmlApplicationContext("context/applicationContext.xml");
      UserService userService = (UserService) ctx.getBean("userServiceImpl");
      //System.out.println("1234566666");
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("jDoe@gmail.com");
        user.setAdmin(true);
        user.setVersion(123456);
        user.setRating(5);
        userService.save(user);
        User us= userService.findByEmail("jDoe@gmail.com");
      System.out.println("******* User **********");
      System.out.println("11111");
      System.out.println("User Name : "+ us.getFirstName() + " " +us.getLastName() );
      us.setFirstName("Smith");
      User u =userService.update(us);
      System.out.println("22222");
      System.out.println("******* User **********");
      System.out.println("User Name : "+ u.getFirstName() + " " +u.getLastName() );
       // userService.flush();
      userService.clear();



  }
  
 }