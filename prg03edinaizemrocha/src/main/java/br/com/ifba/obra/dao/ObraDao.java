/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.obra.dao;

import br.com.ifba.infrastructure.dao.GenericDao;
import br.com.ifba.infrastructure.exception.DaoException;
import br.com.ifba.obra.entity.CategoriaObra;
import br.com.ifba.obra.entity.Obra;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author edina
 */
public class ObraDao extends GenericDao<Obra> implements ObraIDao {
    public ObraDao() {
        super(Obra.class);
    }

    @Override
    public List<Obra> pesquisar(String termo, CategoriaObra categoria) {
        EntityManager em = criarEntityManager();
        String busca = termo == null ? "" : termo.trim();

        try {
            StringBuilder jpql = new StringBuilder(
                    "SELECT o FROM Obra o "
                    + "WHERE (LOWER(o.titulo) LIKE LOWER(:termo) "
                    + "OR LOWER(o.artista.nome) LIKE LOWER(:termo))");

            if (categoria != null) {
                jpql.append(" AND o.categoria = :categoria");
            }
            jpql.append(" ORDER BY o.dataPublicacao DESC, o.id DESC");

            TypedQuery<Obra> consulta = em.createQuery(jpql.toString(), Obra.class)
                    .setParameter("termo", "%" + busca + "%");

            if (categoria != null) {
                consulta.setParameter("categoria", categoria);
            }

            return consulta.getResultList();
        } catch (RuntimeException e) {
            throw new DaoException("Erro ao pesquisar obras.", e);
        } finally {
            em.close();
        }
    }  
}
