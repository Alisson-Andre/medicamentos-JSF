package br.com.medicamentos.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("medicamentos");

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
}
