/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.artista.service;

import br.com.ifba.artista.dao.ArtistaDao;
import br.com.ifba.artista.dao.ArtistaIDao;
import br.com.ifba.artista.entity.Artista;
import br.com.ifba.obra.entity.CategoriaObra;
import java.util.List;

/**
 *
 * @author edina
 */
public class ArtistaService implements ArtistaIService {
    private final ArtistaIDao dao = new ArtistaDao();

    @Override
    public void save(Artista artista) {
        dao.save(artista);
    }

    @Override
    public Artista update(Artista artista) {
        return dao.update(artista);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public Artista findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<Artista> findAll() {
        return dao.findAll();  
    }

    @Override
    public List<Artista> pesquisar(String nome, CategoriaObra categoria) {
        return dao.pesquisar(nome, categoria);
    }
    
}
