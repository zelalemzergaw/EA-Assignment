package edu.mum.dao.impl;

 

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.UserDao;
import edu.mum.domain.User;


@SuppressWarnings("unchecked")
@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao  {

	public User findByEmail(String email) {

		Query query = entityManager.createQuery("select u from Users u  where u.email =:email");
		return (User) query.setParameter("email", email).getSingleResult();
			     

	}


 }