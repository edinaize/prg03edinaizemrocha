/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.repository;

import br.com.ifba.usuario.entity.Usuario;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author edina
 */
public class RepositorioUsuarioEmMemoriaTest {
        @Test
    void cadastrar_umUsuario_apareceEmListarTodos() {
        RepositorioUsuarioEmMemoria repositorio = new RepositorioUsuarioEmMemoria();
        Usuario usuario = new Usuario("Ari", "11144477735", "ana", "senha123");
 
        repositorio.cadastrar(usuario);
 
        assertTrue(repositorio.listarTodos().contains(usuario));
    }
 
    @Test
    void cadastrar_doisUsuarios_buscarPorLoginDevolveOCerto() {
        RepositorioUsuarioEmMemoria repositorio = new RepositorioUsuarioEmMemoria();
        Usuario ari = new Usuario("Ari", "11144477735", "ari", "senha123");
        Usuario bruno = new Usuario("Bruno", "52998224725", "bruno", "senha456");
 
        repositorio.cadastrar(ari);
        repositorio.cadastrar(bruno);
 
        assertSame(bruno, repositorio.buscarPorLogin("bruno"));
    }
 
    @Test
    void buscarPorLogin_loginQueNaoExiste_retornaNull() {
        RepositorioUsuarioEmMemoria repositorio = new RepositorioUsuarioEmMemoria();
 
        assertNull(repositorio.buscarPorLogin("naoexiste"));
    }
 
    @Test
    void cadastrar_loginDuplicado_lancaExcecao() {
        RepositorioUsuarioEmMemoria repositorio = new RepositorioUsuarioEmMemoria();
        Usuario ari = new Usuario("Ari", "11144477735", "ari", "senha123");
        Usuario outraPessoaMesmoLogin = new Usuario("Ari Grande", "52998224725", "ari", "outraSenha");
 
        repositorio.cadastrar(ari);
 
        assertThrows(IllegalArgumentException.class, () -> repositorio.cadastrar(outraPessoaMesmoLogin));
    }
 
    // Prova o equals: dois objetos diferentes com o mesmo login são "iguais" para a lista.
    @Test
    void doisUsuariosComMesmoLogin_saoIguaisParaALista() {
        Usuario ari1 = new Usuario("Ari", "11144477735", "ana", "senha123");
        Usuario ari2 = new Usuario("Ari Diferente", "99999999999", "ana", "outraSenha");
 
        List<Usuario> lista = new ArrayList<>();
        lista.add(ari1);
 
        assertTrue(lista.contains(ari2));
    }
}
