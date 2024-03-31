package com.exemplo.projeto.ejbs.dao;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.exemplo.projeto.ejbs.model.Usuario;

@Stateless
public class UsuarioDao {

	@PersistenceContext
	private EntityManager entityManager;

    public Usuario buscaPeloLogin(String login) {

        Usuario usuario = (Usuario) entityManager.createQuery("select u from Usuario u where u.login=:pLogin")
                .setParameter("pLogin", login).getSingleResult();
        return usuario;
    }

}
