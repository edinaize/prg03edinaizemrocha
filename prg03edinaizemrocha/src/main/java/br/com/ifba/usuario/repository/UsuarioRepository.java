/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.repository;

import br.com.ifba.infrastructure.util.JPAUtil;
import br.com.ifba.usuario.entity.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

/**
 *
 * @author edina
 */
public class UsuarioRepository {
    
    // Cadastra um novo usuário
    public void cadastrar(Usuario u) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transacao = em.getTransaction();

        try {
            transacao.begin();
            em.persist(u);
            transacao.commit();
        } catch (RuntimeException e) {
            if (transacao.isActive()) {
                transacao.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    // Busca um usuário pelo ID
    public Usuario buscarPorId(long id) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }
    // Lista todos os usuários em ordem alfabética
    public List<Usuario> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            return em.createQuery("SELECT u FROM Usuario u ORDER BY u.nome",Usuario.class).getResultList();
        } finally {
            em.close();
        }
    }

    // Atualiza os dados de um usuário
    public void atualizar(Usuario u) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transacao = em.getTransaction();

        try {
            transacao.begin();
            em.merge(u);
            transacao.commit();
        } catch (RuntimeException e) {
            if (transacao.isActive()) {
                transacao.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    // Exclui um usuário pelo ID
    public void excluir(long id) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transacao = em.getTransaction();

        try {
            transacao.begin();

            Usuario u = em.find(Usuario.class, id);
            // Verifica se o usuário existe
            if (u == null) {
                throw new IllegalArgumentException("Usuário não encontrado.");
            }

            em.remove(u);
            transacao.commit();
        } catch (RuntimeException e) {
            if (transacao.isActive()) {
                transacao.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }
}
