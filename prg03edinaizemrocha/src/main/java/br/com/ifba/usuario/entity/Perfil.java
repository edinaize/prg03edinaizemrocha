/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.entity;

/**
 *
 * @author edina
 */
public class Perfil {
    
    // Atributos que representam os dados do perfil
    private int id;
    private String foto;
    private String descricao;
    private int qtdSeguidores;
    private int qtdSeguindo;
    private String biografia;

    public Perfil() {
    }
    
    // Getters e setters dos atributos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtdSeguidores() {
        return qtdSeguidores;
    }

    public void setQtdSeguidores(int qtdSeguidores) {
        this.qtdSeguidores = qtdSeguidores;
    }

    public int getQtdSeguindo() {
        return qtdSeguindo;
    }

    public void setQtdSeguindo(int qtdSeguindo) {
        this.qtdSeguindo = qtdSeguindo;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
    
    
}
