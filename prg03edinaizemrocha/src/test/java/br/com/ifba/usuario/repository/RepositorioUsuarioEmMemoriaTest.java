/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.repository;

import br.com.ifba.usuario.entity.Usuario;
import br.com.ifba.usuario.exception.UsuarioNaoEncontradoException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 *
 * @author edina
 */
public class RepositorioUsuarioEmMemoriaTest {
    @Test
    void deveLancarExcecaoQuandoUsuarioNaoExistir() {
        RepositorioUsuarioEmMemoria repositorio = new RepositorioUsuarioEmMemoria();

        assertThrows(UsuarioNaoEncontradoException.class,() -> repositorio.buscarPorLoginComVarredura("inexistente"));
      }

    @Test
    void naoDeveLancarExcecaoQuandoUsuarioExistir() {
        RepositorioUsuarioEmMemoria repositorio =
                new RepositorioUsuarioEmMemoria();

        Usuario usuario = new Usuario("Usuario Teste", "12345678901", "teste", "senha123");

         repositorio.cadastrar(usuario);

        assertDoesNotThrow(() -> repositorio.buscarPorLoginComVarredura("teste"));

        assertEquals("teste",repositorio.buscarPorLoginComVarredura("teste").getLogin());
    } 
}