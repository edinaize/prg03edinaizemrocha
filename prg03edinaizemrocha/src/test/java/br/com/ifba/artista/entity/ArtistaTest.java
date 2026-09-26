/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.artista.entity;

import br.com.ifba.obra.entity.Obra;
import br.com.ifba.usuario.entity.Usuario;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author edina
 */
public class ArtistaTest {

    @Test
    public void deveAdicionarObraNaLista() {
        Artista artista = new Artista();
        Obra obra = new Obra(1, "Obra Teste");

        artista.adicionarObra(obra);

        assertEquals(1, artista.getObras().size());
    }
    
    // Testa o método herdado de Usuario
    @Test
    void artista_autenticar_usaMetodoHerdadoDeUsuario_retornaTrue() {
        Artista artista = new Artista("Ariana", "52998224725", "ariana_artista", "senha123");

        assertTrue(artista.autenticar("ariana_artista", "senha123"));
    }

    // Testa o método herdado com senha incorreta
    @Test
    void artista_autenticar_usaMetodoHerdadoDeUsuario_retornaFalse() {
        Artista artista = new Artista("Ariana", "52998224725", "ariana_artista", "senha123");

        assertFalse(artista.autenticar("ariana_artista", "senhaErrada"));
    }

    // Testa o método sobrescrito por Artista
    @Test
    void artista_descreverPerfil_retornaDescricaoPropria() {
        Artista artista = new Artista("Ariana", "52998224725", "ariana_artista", "senha123");
        artista.setEstilo("Impressionismo");

        assertEquals("Artista: Ariana (Impressionismo)", artista.descreverPerfil());
    }

    // Testa a sobrescrita usando polimorfismo
    @Test
    void artistaTratadoComoUsuario_usaMetodoDaFilha() {
        Usuario usuario = new Artista("Ariana", "52998224725", "ariana_artista", "senha123");

        assertTrue(usuario.descreverPerfil().startsWith("Artista:"));
    }
}
