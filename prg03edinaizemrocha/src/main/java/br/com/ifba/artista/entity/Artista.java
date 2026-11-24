/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.artista.entity;

import br.com.ifba.obra.entity.Obra;
import br.com.ifba.usuario.entity.TipoPerfil;
import br.com.ifba.usuario.entity.Usuario;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author edina
 */
@Entity
@Table(name = "artistas")
@PrimaryKeyJoinColumn(name = "id")
public class Artista extends Usuario {
    
    // Dados específicos do artista
    @Column(length = 1000)
    private String biografia;
    @Column(nullable = false)
    private String estilo;
    private String localizacao;
 
    // Lista de obras do artista
    @OneToMany(mappedBy = "artista", cascade = CascadeType.REMOVE)
    private final List<Obra> obras = new ArrayList<>();
 
    // Construtor
    public Artista() {
        setTipoPerfil(TipoPerfil.ARTISTA);
    }
    // Construtor com dados principais
    public Artista(String nome, String login, String senha) {
        super(nome, login, senha);
        setTipoPerfil(TipoPerfil.ARTISTA);
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
