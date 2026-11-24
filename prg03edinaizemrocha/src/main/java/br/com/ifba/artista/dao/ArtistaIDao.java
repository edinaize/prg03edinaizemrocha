/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.artista.dao;

import br.com.ifba.artista.entity.Artista;
import br.com.ifba.infrastructure.dao.GenericIDao;
import br.com.ifba.obra.entity.CategoriaObra;
import java.util.List;

/**
 *
 * @author edina
 */
public interface ArtistaIDao extends GenericIDao<Artista> {
    // Busca por parte do nome e, opcionalmente, por categoria de obra
    List<Artista> search(String nome, CategoriaObra categoria);
    
}
