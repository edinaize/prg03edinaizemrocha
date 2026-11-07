/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.dao;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import br.com.ifba.infrastructure.exception.DaoException;
import br.com.ifba.infrastructure.util.JPAUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author edina
 * @param <Entity>
 */
public class GenericDao<Entity extends PersistenceEntity> implements GenericIDao<Entity> {
    private final Class<Entity> tipo;

    // O tipo da entidade chega pelo construtor
    public GenericDao(Class<Entity> tipo) {
        this.tipo = tipo;
    }

    // Único ponto que cria EntityManager
    protected EntityManager criarEntityManager() {
        return JPAUtil.getEntityManager();
    }

    protected Class<Entity> getTipo() {
        return tipo;
    }

    // Desfaz a transação se ela ainda estiver aberta
    protected void reverter(EntityManager em) {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void save(Entity entity) {
        EntityManager em = criarEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            reverter(em);
            throw new DaoException("Erro ao salvar " + tipo.getSimpleName() + ".", e);
        } finally {
            em.close();
        }
    }

    @Override
    public Entity update(Entity entity) {
        EntityManager em = criarEntityManager();
        try {
            em.getTransaction().begin();
            Entity atualizada = em.merge(entity);
            em.getTransaction().commit();
            return atualizada;
        } catch (RuntimeException e) {
            reverter(em);
            throw new DaoException("Erro ao atualizar " + tipo.getSimpleName() + ".", e);
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(Long id) {
        EntityManager em = criarEntityManager();
        try {
            em.getTransaction().begin();
            Entity existente = em.find(tipo, id);
            if (existente == null) {
                throw new IllegalArgumentException(tipo.getSimpleName() + " não encontrado(a).");
            }
            em.remove(existente);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            reverter(em);
            throw new DaoException("Erro ao excluir " + tipo.getSimpleName() + ".", e);
        } finally {
            em.close();
        }
    }

    @Override
    public Entity findById(Long id) {
        EntityManager em = criarEntityManager();
        try {
            return em.find(tipo, id);
        } catch (RuntimeException e) {
            throw new DaoException("Erro ao buscar " + tipo.getSimpleName() + " por id.", e);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Entity> findAll() {
        EntityManager em = criarEntityManager();
        try {
            return em.createQuery(
                    "SELECT e FROM " + tipo.getSimpleName() + " e", tipo)
                    .getResultList();
        } catch (RuntimeException e) {
            throw new DaoException("Erro ao listar " + tipo.getSimpleName() + ".", e);
        } finally {
            em.close();
        }
    }
}
