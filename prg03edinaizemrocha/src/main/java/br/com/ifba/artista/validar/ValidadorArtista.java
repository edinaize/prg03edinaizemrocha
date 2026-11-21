/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.artista.validar;

/**
 *
 * @author edina
 */
public class ValidadorArtista {
    
    // Verifica se o estilo artístico foi informado
    public static boolean estiloValido(String estilo) {
        return estilo != null && !estilo.trim().isEmpty();
    }
}
