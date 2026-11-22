/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.service;

import br.com.ifba.usuario.dao.FakeUsuarioDao;
import br.com.ifba.usuario.entity.Usuario;
import br.com.ifba.usuario.exception.UsuarioInvalidoException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 *
 * @author edina
 */
public class UsuarioServiceTest {
    private FakeUsuarioDao dao;
    private UsuarioIService service;

    @BeforeEach
    void preparar() {
        dao = new FakeUsuarioDao();
        service = new UsuarioService(dao);
    }

    private Usuario usuarioValido() {
        Usuario u = new Usuario("Maria", "maria", "123456");
        u.setDataNascimento("01/01/2000");
        u.setTelefone("71999999999");
        u.setEmail("maria@email.com");
        return u;
    }

    @Test
    void salvaUsuarioValido() {
        service.save(usuarioValido());

        assertEquals(1, dao.findAll().size());
    }

    @Test
    void naoSalvaComCampoObrigatorioVazio() {
        Usuario u = usuarioValido();
        u.setNome("  ");

        assertThrows(UsuarioInvalidoException.class, () -> service.save(u));
        assertTrue(dao.findAll().isEmpty());
    }

    @Test
    void naoSalvaComEmailNulo() {
        Usuario u = usuarioValido();
        u.setEmail(null);

        assertThrows(UsuarioInvalidoException.class, () -> service.save(u));
        assertTrue(dao.findAll().isEmpty());
    }

    @Test
    void naoSalvaComSenhaCurta() {
        Usuario u = usuarioValido();
        u.setSenha("12345");

        assertThrows(UsuarioInvalidoException.class, () -> service.save(u));
        assertTrue(dao.findAll().isEmpty());
    }

    @Test
    void naoSalvaComLoginComPalavraProibida() {
        Usuario u = usuarioValido();
        u.setLogin("admin01");

        assertThrows(UsuarioInvalidoException.class, () -> service.save(u));
        assertTrue(dao.findAll().isEmpty());
    }

    @Test
    void updateTambemValida() {
        Usuario u = usuarioValido();
        service.save(u);
        u.setSenha("123");

        assertThrows(UsuarioInvalidoException.class, () -> service.update(u));
    }

    @Test
    void updateAtualizaUsuarioValido() {
        Usuario u = usuarioValido();
        service.save(u);
        u.setNome("Maria Silva");

        service.update(u);

        assertEquals("Maria Silva", dao.findById(u.getId()).getNome());
    }
}
