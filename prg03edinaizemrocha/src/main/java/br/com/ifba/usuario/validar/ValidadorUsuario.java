package br.com.ifba.usuario.validar;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author edina
 */
public class ValidadorUsuario {
    // Verifica se o texto comtém alguma palavra proibida
    public static boolean contemPalavraProibida(String texto){
        String[] palavrasProibidas = {"adimin", "teste", "root", "senha123"};
        
        for(String palavra : palavrasProibidas) {
            if (texto.toLowerCase().contains(palavra)) {
                return true;
            }
        }
        return false;
    }
}
