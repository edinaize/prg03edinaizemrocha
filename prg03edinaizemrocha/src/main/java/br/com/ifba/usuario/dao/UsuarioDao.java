/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.dao;

import br.com.ifba.infrastructure.dao.GenericDao;
import br.com.ifba.infrastructure.exception.DaoException;
import br.com.ifba.usuario.entity.Usuario;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author edina
 */
public class UsuarioDao extends GenericDao<Usuario> implements UsuarioIDao {
    public UsuarioDao() {
        super(Usuario.class);
    }

    @Override
    public Usuario findByLogin(String login) {
        EntityManager em = criarEntityManager();

        try {
            List<Usuario> usuarios = em.createQuery(
                    "SELECT u FROM Usuario u WHERE u.login = :login",
                    Usuario.class)
                    .setParameter("login", login)
                    .getResultList();

            return usuarios.isEmpty() ? null : usuarios.get(0);
        } catch (RuntimeException e) {
            throw new DaoException("Erro ao buscar usuário por login.", e);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Usuario> buscarPorNome(String nome) {
        EntityManager em = criarEntityManager();
        String termo = nome == null ? "" : nome.trim();

        try {
            return em.createQuery(
                    "SELECT u FROM Usuario u "
                    + "WHERE LOWER(u.nome) LIKE LOWER(:nome) "
                    + "ORDER BY u.nome",
                    Usuario.class)
                    .setParameter("nome", "%" + termo + "%")
                    .getResultList();
        } catch (RuntimeException e) {
            throw new DaoException("Erro ao buscar usuários por nome.", e);
        } finally {
            em.close();
        }
    }
}
