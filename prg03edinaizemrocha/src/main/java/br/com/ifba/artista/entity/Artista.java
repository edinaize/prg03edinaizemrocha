/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.artista.entity;

import br.com.ifba.obra.entity.Obra;
import br.com.ifba.usuario.entity.Usuario;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author edina
 */
public class Artista extends Usuario {
    
    // Dados específicos do artista
    private String biografia;
    private String estilo;
    private String localizacao;
 
    // Lista de obras do artista
    private final List<Obra> obras = new ArrayList<>();
 
    // Construtor
    public Artista() {
    }
 
    // Construtor com dados principais
    public Artista(String nome, String cpf, String login, String senha) {
        super(nome, cpf, login, senha);
    }
 
    // Getters e setters dos atributos
    public String getBiografia() {
        return biografia;
    }
 
    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
 
    public String getEstilo() {
        return estilo;
    }
 
    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }
 
    public String getLocalizacao() {
        return localizacao;
    }
 
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
 
    // Adiciona uma obra à lista
    public void adicionarObra(Obra obra) {
        if (obra != null) {
            this.obras.add(obra);
        }
    }
 
    // Retorna a lista de obras somente para leitura
    public List<Obra> getObras() {
        return Collections.unmodifiableList(obras);
    }
    
    // Sobrescreve a descrição do perfil para o artista
    @Override
    public String descreverPerfil(){
        return "Artista: " + getNome() + " (" + estilo +")";
    }
}
