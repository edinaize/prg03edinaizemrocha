/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.artista.entity;

import br.com.ifba.obra.entity.Obra;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
}
