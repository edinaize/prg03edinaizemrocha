/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.artista.entity;

import br.com.ifba.artista.validar.ValidadorArtista;
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
    
    @Test
    void artista_descreverPerfil_retornaDescricaoPropria() {
        Artista artista = new Artista("Ariana", "ariana_artista", "senha123");
        artista.setEstilo("Impressionismo");

        assertEquals("Artista: Ariana (Impressionismo)", artista.descreverPerfil());
    }

    // Testa a sobrescrita usando polimorfismo
    @Test
    void artistaTratadoComoUsuario_usaMetodoDaFilha() {
        Usuario usuario = new Artista("Ariana", "ariana_artista", "senha123");

        assertTrue(usuario.descreverPerfil().startsWith("Artista:"));
    }
    
    @Test
    void artista_autenticar_comPerfilCompleto_retornaTrue() {
        Artista artista = new Artista("Bruno", "bruno_artista", "senha123");

        artista.setEstilo("Impressionismo");

        assertTrue(artista.autenticar("bruno_artista", "senha123"));
    }
    
    @Test
    void processar_comUsuario_retornaTrue() {
        Autenticavel pessoa = new Usuario("Ana", "ana", "senha123");

        assertTrue(TelaLogin.processar(pessoa, "ana", "senha123"));
    }

    @Test
    void processar_comArtista_retornaTrue() {
        Artista artista = new Artista("Bruno", "bruno_artista", "senha123");

        artista.setEstilo("Surrealismo");

        Autenticavel pessoa = artista;

        assertTrue(TelaLogin.processar(pessoa, "bruno_artista", "senha123"));
    }

    @Test
    void estiloValido_comTexto_retornaTrue() {
        assertTrue(ValidadorArtista.estiloValido("Impressionismo"));
    }

    @Test
    void estiloValido_nulo_retornaFalse() {
        assertFalse(ValidadorArtista.estiloValido(null));
    }

    @Test
    void estiloValido_soEspacos_retornaFalse() {
        assertFalse(ValidadorArtista.estiloValido("   "));
    }
}
