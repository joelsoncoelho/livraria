package com.exemplo.projeto.ejbs.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.exemplo.projeto.ejbs.model.Livro;

@Stateless
public class LivroDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void salva(Livro livro) {
		entityManager.persist(livro);
	}

	   public List<Livro> todosLivros() {
	   	        return entityManager.createQuery("select l from Livro l", Livro.class)
	                .getResultList();
	    }

	public List<Livro> livrosPeloNome(String nome) {
				
		TypedQuery<Livro> query = entityManager.createQuery("select l from Livro l where l.titulo like :pTitulo", Livro.class )
                .setParameter("pTitulo", "%" + nome + "%");;
		return query.getResultList();
	}
}
