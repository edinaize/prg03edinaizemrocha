/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.obra.controller;

import br.com.ifba.obra.entity.CategoriaObra;
import br.com.ifba.obra.entity.Obra;
import java.util.List;

/**
 *
 * @author edina
 */
public interface ObraIController {
    void save(Obra obra);
    Obra update(Obra obra);
    void delete(Long id);
    Obra findById(Long id);
    List<Obra> findAll();
    List<Obra> pesquisar(String termo, CategoriaObra categoria);
}
