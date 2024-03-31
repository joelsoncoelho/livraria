package com.exemplo.projeto.ejbs.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.exemplo.projeto.ejbs.dao.AutorDao;
import com.exemplo.projeto.ejbs.exceptions.LivrariaException;
import com.exemplo.projeto.ejbs.model.Autor;

@Stateless
public class AutorService {
	
	@Inject
	private AutorDao autorDao;
	
	public void adiciona(Autor autor) {
		//regra de negócio
		try {
			autorDao.salva(autor);			
		} catch (Exception e) {
			//uma regra de negócio deu errado
			throw new LivrariaException();
		}		
	}

	public List<Autor> todosAutores() {
		return autorDao.todosAutores();
	}
}
