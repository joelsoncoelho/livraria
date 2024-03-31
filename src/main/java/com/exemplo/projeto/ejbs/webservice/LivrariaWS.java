package com.exemplo.projeto.ejbs.webservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.exemplo.projeto.ejbs.dao.LivroDao;
import com.exemplo.projeto.ejbs.model.Livro;

@WebService
@Stateless
public class LivrariaWS {

	    @Inject
	    LivroDao dao;

	    @WebResult(name="livros")
	    public List<Livro> getLivrosPeloNome(@WebParam(name="titulo") String nome) {

	        System.out.println("LivrariaWS: procurando pelo nome " + nome);
	        return dao.livrosPeloNome(nome);
	    }    
	
}
