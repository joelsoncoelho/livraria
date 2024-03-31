package com.exemplo.projeto.ejbs.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.exemplo.projeto.ejbs.model.Autor;
import com.exemplo.projeto.ejbs.service.AutorService;
	
@Named
@RequestScoped
public class AutorBean {
	
	private Autor autor = new Autor();
	
	@Inject
	private AutorService autorService;// = new AutorDao();
	
	public Autor getAutor() {
		return autor;
	}
	
	public void cadastra() {
		this.autorService.adiciona(autor);
		this.autor = new Autor();
	}
	
	public List<Autor> getAutores() {	
		return this.autorService.todosAutores();
	}
}
