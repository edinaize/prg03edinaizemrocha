/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.perfil.dao;

import br.com.ifba.infrastructure.dao.GenericDao;
import br.com.ifba.infrastructure.exception.DaoException;
import br.com.ifba.perfil.entity.Perfil;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author edina
 */
public class PerfilDao extends GenericDao<Perfil> implements PerfilIDao {
    public PerfilDao() {
        super(Perfil.class);
    }

    @Override
    public Perfil findByUsuarioId(long usuarioId) {
        EntityManager em = createEntityManager();

        try {
            List<Perfil> perfis = em.createQuery(
                    "SELECT p FROM Perfil p WHERE p.usuario.id = :id",
                    Perfil.class)
                    .setParameter("id", usuarioId)
                    .getResultList();

            return perfis.isEmpty() ? null : perfis.get(0);
        } catch (RuntimeException e) {
            throw new DaoException("Erro ao buscar perfil por usuário.", e);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Perfil> findByNomeUsuario(String nome) {
        EntityManager em = createEntityManager();
        String termo = nome == null ? "" : nome.trim();

        try {
            return em.createQuery(
                    "SELECT p FROM Perfil p "
                    + "WHERE LOWER(p.usuario.nome) LIKE LOWER(:nome) "
                    + "ORDER BY p.usuario.nome",
                    Perfil.class)
                    .setParameter("nome", "%" + termo + "%")
                    .getResultList();
        } catch (RuntimeException e) {
            throw new DaoException("Erro ao buscar perfis por nome.", e);
        } finally {
            em.close();
        }
    }
}
