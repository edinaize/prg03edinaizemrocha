/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.entity;

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
}
