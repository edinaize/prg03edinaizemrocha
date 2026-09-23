/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.obra.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author edina
 */
public class ObraTest {
    
    @Test
    public void deveCriarObraComStatusRascunho() {
        Obra obra = new Obra(1, "Obra Teste");

        assertEquals(StatusObra.RASCUNHO, obra.getStatus());
    }
}
