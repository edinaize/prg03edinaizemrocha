/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.dao;

import br.com.ifba.infrastructure.exception.DaoException;
import br.com.ifba.usuario.entity.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author edina
 */
public class GenericDaoTest {
    private EntityManagerFalso falso;
    private GenericDao<Usuario> dao;
    private Usuario usuario;

    @BeforeEach
    void preparar() {
        falso = new EntityManagerFalso();
        usuario = new Usuario("Ana", "12345678901", "ana", "123456");

        // DAO que usa o EntityManager falso em vez do banco
        dao = new GenericDao<>(Usuario.class) {
            @Override
            protected EntityManager criarEntityManager() {
                return falso.criar();
            }
        };
    }

    @Test
    void saveDeveLancarDaoExceptionFazerRollbackEFechar() {
        DaoException e = assertThrows(DaoException.class, () -> dao.save(usuario));

        // A causa original é preservada
        assertInstanceOf(PersistenceException.class, e.getCause());
        assertTrue(falso.rollbackChamado, "deveria ter feito rollback");
        assertTrue(falso.fechado, "deveria ter fechado o EntityManager");
    }

    @Test
    void updateDeveLancarDaoExceptionFazerRollbackEFechar() {
        assertThrows(DaoException.class, () -> dao.update(usuario));

        assertTrue(falso.rollbackChamado);
        assertTrue(falso.fechado);
    }

    @Test
    void deleteDeveLancarDaoExceptionFazerRollbackEFechar() {
        assertThrows(DaoException.class, () -> dao.delete(1L));

        assertTrue(falso.rollbackChamado);
        assertTrue(falso.fechado);
    }

    @Test
    void findByIdDeveLancarDaoExceptionEFechar() {
        assertThrows(DaoException.class, () -> dao.findById(1L));

        assertTrue(falso.fechado);
    }

    @Test
    void findAllDeveLancarDaoExceptionEFechar() {
        assertThrows(DaoException.class, () -> dao.findAll());

        assertTrue(falso.fechado);
    }
}
