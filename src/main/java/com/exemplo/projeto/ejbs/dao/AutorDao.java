package com.exemplo.projeto.ejbs.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.exemplo.projeto.ejbs.model.Autor;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER) // opcional
//@TransactionManagement(TransactionManagementType.BEAN) // Para o EJB Container aceitar o gerenciamento da transação programaticamente, é preciso reconfigurar para BEAN
//Interceptors({LogInterceptador.class})
public class AutorDao {

	@PersistenceContext
	private EntityManager entityManager;

	//@Inject
	//private UserTransaction tx;

	/*
	 * @PostConstruct void aposCriacao() {
	 * System.out.println("Autor Dao foi criado!"); }
	 */
	

	/* @TransactionAttribute(TransactionAttributeType.MANDATORY) 
	 * // Obrigatorio implementar o abrir e fechar transação no service */
	
	 /* @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW) 
	/* O  REQUIRES_NEW indica que sempre deve ter uma nova transação rodando. Caso já
	 exista, a transação atual será suspensa para abrir uma nova. Caso não tenha
	 nenhuma rodando, será criada uma nova transação */
	@TransactionAttribute(TransactionAttributeType.REQUIRED) // opcional
	public void salva(Autor autor) {
		System.out.println("Salvando o autor " +autor.getNome());
		entityManager.persist(autor);
		
		System.out.println("Salvou o autor " +autor.getNome());
		
		//chamada ao service externo que gera um erro
		//throw new RuntimeException("Servico externo deu erro!");
	}

	/*
	public void salva(Autor autor) {

		// ...
		try {
			tx.begin();
			entityManager.persist(autor);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ...
	}
	*/

	public List<Autor> todosAutores() {
		return entityManager.createQuery("select a from Autor a", Autor.class).getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		return entityManager.find(Autor.class, autorId);
	}

}
