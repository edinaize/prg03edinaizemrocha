/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.entity;

import br.com.ifba.perfil.entity.Perfil;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author edina
 */
public class UsuarioTest {
    @Test
    void autenticar_credenciaisCorretas_retornaTrue() {
        Usuario usuario = new Usuario("Edinaize", "52998224725", "edinaize", "senha123");
 
        assertTrue(usuario.autenticar("edinaize", "senha123"));
    }
 
    @Test
    void autenticar_senhaIncorreta_retornaFalse() {
        Usuario usuario = new Usuario("Edinaize", "52998224725", "edinaize", "senha123");
 
        assertFalse(usuario.autenticar("edinaize", "senhaErrada"));
    }
    
    @Test
    public void deveRetornarPerfilRelacionado() {
        Usuario usuario = new Usuario();
        Perfil perfil = new Perfil();

        usuario.setPerfil(perfil);

        assertSame(perfil, usuario.getPerfil());
    }
    
    // Testa a descrição padrão do Usuario
    @Test
    void descreverPerfil_retornaDescricaoDoUsuario() {
        Usuario usuario = new Usuario( "Carla", "12345678900", "carla", "senha123");

        assertEquals("Usuario: Carla", usuario.descreverPerfil());
    }
    
    @Test
    void usuariosComMesmoLogin_saoConsideradosIguaisNaLista() {
        Usuario usuario1 = new Usuario("Ana", "11111111111", "ana", "123456");
        Usuario usuario2 = new Usuario("Bruno", "22222222222", "ana", "654321");

        java.util.List<Usuario> usuarios = new java.util.ArrayList<>();

        usuarios.add(usuario1);

        assertTrue(usuarios.contains(usuario2));
    }
}
