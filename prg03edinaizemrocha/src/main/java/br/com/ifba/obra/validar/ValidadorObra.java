/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.obra.validar;

import java.io.File;

/**
 *
 * @author edina
 */
public class ValidadorObra {
    // Verifica se o caminho aponta para um arquivo de imagem existente
    public static boolean imagemValida(String caminho) {
        if (caminho == null || caminho.trim().isEmpty()) {
            return false;
        }

        String minusculo = caminho.toLowerCase();
        boolean extensaoValida = minusculo.endsWith(".png")
                || minusculo.endsWith(".jpg")
                || minusculo.endsWith(".jpeg")
                || minusculo.endsWith(".gif");

        return extensaoValida && new File(caminho).isFile();
    }

    // Verifica se a descrição cabe na coluna do banco
    public static boolean descricaoValida(String descricao) {
        return descricao == null || descricao.length() <= 1000;
    }
}
