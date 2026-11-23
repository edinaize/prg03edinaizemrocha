/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.artista.dao;

import br.com.ifba.artista.entity.Artista;
import br.com.ifba.infrastructure.dao.GenericDao;
import br.com.ifba.infrastructure.exception.DaoException;
import br.com.ifba.obra.entity.CategoriaObra;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author edina
 */
public class ArtistaDao extends GenericDao<Artista> implements ArtistaIDao{
    
    public ArtistaDao() {
        super(Artista.class);
    }

    @Override
    public List<Artista> search(String nome, CategoriaObra categoria) {
        EntityManager em = createEntityManager();
        String termo = nome == null ? "" : nome.trim();

        try {
            StringBuilder jpql = new StringBuilder(
                    "SELECT a FROM Artista a WHERE LOWER(a.nome) LIKE LOWER(:nome)");

            // Só artistas que possuem alguma obra na categoria escolhida
            if (categoria != null) {
                jpql.append(" AND EXISTS (SELECT o.id FROM Obra o "
                        + "WHERE o.artista = a AND o.categoria = :categoria)");
            }
            jpql.append(" ORDER BY a.nome");

            TypedQuery<Artista> consulta = em.createQuery(jpql.toString(), Artista.class)
                    .setParameter("nome", "%" + termo + "%");

            if (categoria != null) {
                consulta.setParameter("categoria", categoria);
            }

            return consulta.getResultList();
        } catch (RuntimeException e) {
            throw new DaoException("Erro ao pesquisar artistas.", e);
        } finally {
            em.close();
        }
    }

}
