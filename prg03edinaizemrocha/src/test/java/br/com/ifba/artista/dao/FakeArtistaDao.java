/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.artista.dao;

import br.com.ifba.artista.entity.Artista;
import br.com.ifba.obra.entity.CategoriaObra;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author edina
 */
public class FakeArtistaDao implements ArtistaIDao {
    private final List<Artista> artistas = new ArrayList<>();
    private long proximoId = 1;

    @Override
    public void save(Artista artista) {
        artista.setId(proximoId++);
        artistas.add(artista);
    }

    @Override
    public Artista update(Artista artista) {
        for (int i = 0; i < artistas.size(); i++) {
            if (artistas.get(i).getId() == artista.getId()) {
                artistas.set(i, artista);
                return artista;
            }
        }
        return artista;
    }

    @Override
    public void delete(Long id) {
        artistas.removeIf(a -> a.getId() == id);
    }

    @Override
    public Artista findById(Long id) {
        return artistas.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Artista> findAll() {
        return new ArrayList<>(artistas);
    }

    // A categoria depende das obras do artista, então o fake filtra só pelo nome
    @Override
    public List<Artista> pesquisar(String nome, CategoriaObra categoria) {
        String termo = nome == null ? "" : nome.trim().toLowerCase();
        return artistas.stream()
                .filter(a -> a.getNome().toLowerCase().contains(termo))
                .toList();
    }
}
