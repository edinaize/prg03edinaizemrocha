/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.perfil.validar;

import java.io.File;

/**
 *
 * @author edina
 */
public class ValidadorPerfil {
    // INDISPONÍVEL
    public static boolean fotoValida(String caminho) {
        if (caminho == null || caminho.trim().isEmpty()) {
            return true;
        }

        String minusculo = caminho.toLowerCase();
        boolean extensaoValida = minusculo.endsWith(".png")
                || minusculo.endsWith(".jpg")
                || minusculo.endsWith(".jpeg")
                || minusculo.endsWith(".gif");

        return extensaoValida && new File(caminho).isFile();
    }

    // Verifica se a biografia cabe na coluna do banco
    public static boolean biografiaValida(String biografia) {
        return biografia == null || biografia.length() <= 1000;
    }
}
