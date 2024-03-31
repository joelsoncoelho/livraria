package com.exemplo.projeto.ejbs.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.exemplo.projeto.ejbs.dao.AutorDao;
import com.exemplo.projeto.ejbs.dao.LivroDao;
import com.exemplo.projeto.ejbs.model.Autor;
import com.exemplo.projeto.ejbs.model.Livro;

@Named
@RequestScoped
public class LivroBean {
	
	private Livro livro = new Livro();
	private Integer autorId;
	
	@Inject
	private LivroDao livroDao; // = new LivroDao();

	@Inject
	private AutorDao autorDao; // = new AutorDao();

	public void cadastra() {
		
		Autor autor = this.autorDao.buscaPelaId(this.autorId);
		this.livro.setAutor(autor);
		
		this.livroDao.salva(livro);
		
		this.livro = new Livro();
	}

	public List<Autor> getAutores() {
		return autorDao.todosAutores();
	}
	
	public Livro getLivro() {
		return livro;
	}
	
	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}
	
	public Integer getAutorId() {
		return autorId;
	}
	
	public List<Livro> getLivros() {
		return this.livroDao.todosLivros();
	}
}
