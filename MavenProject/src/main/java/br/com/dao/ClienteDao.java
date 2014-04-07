package br.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.bean.Cliente;

public class ClienteDao extends Dao{
	
	
	public void salvar(Cliente cliente){
		EntityManager manager = getFactory();
		try {
			manager.getTransaction().begin();
			manager.persist(cliente);
			manager.getTransaction().commit();
			manager.close();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		}
	}
	
	public List listar(){
		EntityManager manager = getFactory();
		try {
			Query query = manager.createQuery("select object(c) from Cliente as c");
			return query.getResultList();
		} finally{
			manager.close();
		}
	}
	
	public void deletar(Cliente cliente){
		EntityManager manager = getFactory();
		try {
			manager.getTransaction().begin();
			cliente = manager.merge(cliente);
			System.out.println("oi");
			manager.remove(cliente);
			manager.getTransaction().commit();
			manager.close();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		}
	}
	public void editar(Cliente cliente){
		EntityManager manager = getFactory();
		try {
			manager.getTransaction().begin();
			cliente = (Cliente)manager.merge(cliente); 
			manager.getTransaction().commit();
			manager.close();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		}
	}
}
