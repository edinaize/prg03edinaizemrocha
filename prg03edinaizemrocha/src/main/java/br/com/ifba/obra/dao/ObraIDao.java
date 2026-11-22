/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.obra.dao;

import br.com.ifba.infrastructure.dao.GenericIDao;
import br.com.ifba.obra.entity.CategoriaObra;
import br.com.ifba.obra.entity.Obra;
import java.util.List;

/**
 *
 * @author edina
 */
public interface ObraIDao extends GenericIDao<Obra> {
    // Busca por parte do título ou do nome do artista e por categoria.
    List<Obra> pesquisar(String termo, CategoriaObra categoria);   
}
