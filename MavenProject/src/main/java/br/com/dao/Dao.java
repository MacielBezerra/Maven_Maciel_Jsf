package br.com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Dao {
	
	private EntityManagerFactory factory;
	
	public Dao(){
		this.factory = Persistence.createEntityManagerFactory("sistemas");
	}

	public EntityManager getFactory() {
		return factory.createEntityManager();
	}
	

}
