/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.obra.entity;

import br.com.ifba.artista.entity.Artista;
import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
/**
 *
 * @author edina
 */
@Entity
@Table(name = "obras")
public class Obra extends PersistenceEntity{
    
    // Caminho da imagem da obra, as telas ainda não usam)
    @Column(length = 500)
    private String imagem;
    
    @Column(nullable = false)
    private String titulo;
    
    @Column(length = 1000)
    private String descricao;
    
    @Column(length = 100)
    private String tecnica;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private CategoriaObra categoria;

    @Column(name = "data_publicacao")
    private LocalDate dataPublicacao;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatusObra status;
    
    // Somente artistas publicam obras
    @ManyToOne(optional = false)
    @JoinColumn(name = "artista_id", nullable = false)
    private Artista artista;
    
    public Obra() {
    }
 
    public Obra(int idObra, String titulo) {
        this.titulo = titulo;
        this.status = StatusObra.RASCUNHO;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public StatusObra getStatus() {
        return status;
    }

    public void setStatus(StatusObra status) {
        this.status = status;
    }

    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

    public CategoriaObra getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaObra categoria) {
        this.categoria = categoria;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    } 
}
