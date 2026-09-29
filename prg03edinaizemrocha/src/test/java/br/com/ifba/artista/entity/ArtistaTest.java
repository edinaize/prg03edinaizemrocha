/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.artista.entity;

import br.com.ifba.login.view.TelaLogin;
import br.com.ifba.obra.entity.Obra;
import br.com.ifba.usuario.entity.Usuario;
import br.com.ifba.usuario.interfaces.Autenticavel;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
    /*    @Test
    void artista_autenticar_usaMetodoHerdadoDeUsuario_retornaTrue() {
    Artista artista = new Artista("Ariana", "52998224725", "ariana_artista", "senha123");
    
    assertTrue(artista.autenticar("ariana_artista", "senha123"));
    }
    
    // Testa o método herdado com senha incorreta
    @Test
    void artista_autenticar_usaMetodoHerdadoDeUsuario_retornaFalse() {
    Artista artista = new Artista("Ariana", "52998224725", "ariana_artista", "senha123");
    
    assertFalse(artista.autenticar("ariana_artista", "senhaErrada"));
    }*/

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
    
    @Test
    void artista_autenticar_comPerfilCompleto_retornaTrue() {
        Artista artista = new Artista("Bruno", "11144477735", "bruno_artista", "senha123");

        artista.setEstilo("Impressionismo");

        assertTrue(artista.autenticar("bruno_artista", "senha123"));
    }

    @Test
    void artista_autenticar_semEstilo_retornaFalse() {
        Artista artista = new Artista("Bruno", "11144477735", "bruno_artista", "senha123");

        assertFalse(artista.autenticar("bruno_artista", "senha123"));
    }

    @Test
    void mesmasCredenciais_usuarioEArtista_produzemResultadosDiferentes() {
        Usuario usuario = new Usuario("Ana", "52998224725", "ana", "senha123");

        Artista artista = new Artista("Ana", "52998224725", "ana", "senha123");

        assertNotEquals(usuario.autenticar("ana", "senha123"), artista.autenticar("ana", "senha123"));
    }
    
    @Test
    void processar_comUsuario_retornaTrue() {
        Autenticavel pessoa = new Usuario("Ana", "52998224725", "ana", "senha123");

        assertTrue(TelaLogin.processar(pessoa, "ana", "senha123"));
    }

    @Test
    void processar_comArtista_retornaTrue() {
        Artista artista = new Artista("Bruno", "11144477735", "bruno_artista", "senha123");

        artista.setEstilo("Surrealismo");

        Autenticavel pessoa = artista;

        assertTrue(TelaLogin.processar(pessoa, "bruno_artista", "senha123"));
    }

    @Test
    void processar_comArtistaSemEstilo_retornaFalse() {
        Autenticavel pessoa = new Artista(
                "Bruno", "11144477735", "bruno_artista", "senha123");

        assertFalse( TelaLogin.processar(pessoa, "bruno_artista", "senha123"));
    }
}
