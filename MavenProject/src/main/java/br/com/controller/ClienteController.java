package br.com.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.bean.Cliente;
import br.com.dao.ClienteDao;

@ManagedBean
public class ClienteController {
	
	private Cliente cliente;
	private ClienteDao cliente_dao;
	private DataModel model;
	
	public ClienteController(){
		this.cliente = new Cliente();
		this.cliente_dao = new ClienteDao();
	}
	
	public String salvar(){
		this.cliente_dao.salvar(cliente);
		this.limparFormulario();
		return "salvo";
	}
	
	public String deletar(Cliente cliente){
		this.cliente_dao.deletar(cliente);
		System.out.println("passei");
		return "deletado";
	}
	
	public DataModel listar(){
		this.model = new ListDataModel(this.cliente_dao.listar());
		return model;
	}
	public String alterar(){
		this.cliente_dao.deletar(cliente);
		return "alterado";
	}
	
	public void limparFormulario(){
		this.cliente = new Cliente();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
