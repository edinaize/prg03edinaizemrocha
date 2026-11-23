/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.com.ifba.usuario.entity;

/**
 *
 * @author edina
 */
public enum TipoPerfil {
    USUARIO("Usuário", "Espectador"),
    ARTISTA("Artista", "Artista");

    private final String descricao;
    private final String rotuloTela;
    
    TipoPerfil(String descricao, String rotuloTela) {
        this.descricao = descricao;
        this.rotuloTela = rotuloTela;
    }

    public String getDescricao() {
        return descricao;
    }
    
    // Texto exibido no combo da tela de cadastro
    public String getRotuloTela() {
        return rotuloTela;
    }

    public static TipoPerfil porRotuloTela(String rotulo) {
        for (TipoPerfil tipo : values()) {
            if (tipo.rotuloTela.equals(rotulo)) {
                return tipo;
            }
        }
        return USUARIO;
    }
}
