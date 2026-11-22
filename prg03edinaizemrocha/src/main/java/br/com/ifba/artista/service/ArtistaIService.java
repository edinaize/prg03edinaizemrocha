/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.artista.service;

import br.com.ifba.artista.entity.Artista;
import br.com.ifba.obra.entity.CategoriaObra;
import java.util.List;

/**
 *
 * @author edina
 */
public interface ArtistaIService {
    void save(Artista artista);
    Artista update(Artista artista);
    void delete(Long id);
    Artista findById(Long id);
    List<Artista> findAll();
    List<Artista> pesquisar(String nome, CategoriaObra categoria);
}
