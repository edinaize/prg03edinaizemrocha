/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.artista.controller;

import br.com.ifba.artista.entity.Artista;
import br.com.ifba.artista.service.ArtistaIService;
import br.com.ifba.artista.service.ArtistaService;
import br.com.ifba.obra.entity.CategoriaObra;
import java.util.List;

/**
 *
 * @author edina
 */
public class ArtistaController implements ArtistaIController {
    private final ArtistaIService service = new ArtistaService();

    @Override
    public void save(Artista artista) {
        service.save(artista);
    }

    @Override
    public Artista update(Artista artista) {
        return service.update(artista);
    }

    @Override
    public void delete(Long id) {
        service.delete(id);
    }

    @Override
    public Artista findById(Long id) {
        return service.findById(id);
    }

    @Override
    public List<Artista> findAll() {
        return service.findAll();
    }

    @Override
    public List<Artista> pesquisar(String nome, CategoriaObra categoria) {
        return service.pesquisar(nome, categoria);
    }
    
}
