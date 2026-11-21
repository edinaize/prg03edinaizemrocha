/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.com.ifba.obra.entity;

/**
 *
 * @author edina
 */
public enum CategoriaObra {
    PINTURA("Pintura"),
    ESCULTURA("Escultura"),
    FOTOGRAFIA("Fotografia"),
    ILUSTRACAO("Ilustração");

    private final String descricao;

    CategoriaObra(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
