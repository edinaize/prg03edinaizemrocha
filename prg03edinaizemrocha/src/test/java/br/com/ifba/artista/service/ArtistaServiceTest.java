/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.artista.service;

import br.com.ifba.artista.dao.FakeArtistaDao;
import br.com.ifba.artista.entity.Artista;
import br.com.ifba.usuario.dao.FakeUsuarioDao;
import br.com.ifba.usuario.exception.UsuarioInvalidoException;
import br.com.ifba.usuario.service.UsuarioService;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 *
 * @author edina
 */
public class ArtistaServiceTest {
    private FakeArtistaDao dao;
    private ArtistaIService service;

    @BeforeEach
    void preparar() {
        dao = new FakeArtistaDao();
        service = new ArtistaService(dao, new UsuarioService(new FakeUsuarioDao()));
    }

    private Artista artistaValido() {
        Artista a = new Artista("Ariana", "ariana", "123456");
        a.setDataNascimento("01/01/1990");
        a.setTelefone("71988888888");
        a.setEmail("ariana@email.com");
        a.setEstilo("Realismo");
        return a;
    }

    @Test
    void salvaArtistaValido() {
        service.save(artistaValido());

        assertEquals(1, dao.findAll().size());
    }

    @Test
    void naoSalvaSemEstilo() {
        Artista a = artistaValido();
        a.setEstilo("  ");

        assertThrows(UsuarioInvalidoException.class, () -> service.save(a));
        assertTrue(dao.findAll().isEmpty());
    }

    @Test
    void naoSalvaComEstiloNulo() {
        Artista a = artistaValido();
        a.setEstilo(null);

        assertThrows(UsuarioInvalidoException.class, () -> service.save(a));
    }

    @Test
    void aplicaTambemAsRegrasDeUsuario() {
        Artista a = artistaValido();
        a.setSenha("123");

        assertThrows(UsuarioInvalidoException.class, () -> service.save(a));
        assertTrue(dao.findAll().isEmpty());
    }

    @Test
    void updateSemEstiloNaoAtualiza() {
        Artista a = artistaValido();
        service.save(a);
        a.setEstilo("");

        assertThrows(UsuarioInvalidoException.class, () -> service.update(a));
    }
}
