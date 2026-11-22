/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.obra.controller;

import br.com.ifba.obra.entity.CategoriaObra;
import br.com.ifba.obra.entity.Obra;
import br.com.ifba.obra.service.ObraIService;
import br.com.ifba.obra.service.ObraService;
import java.util.List;

/**
 *
 * @author edina
 */
public class ObraController implements ObraIController {
    private final ObraIService service = new ObraService();

    @Override
    public void save(Obra obra) {
        service.save(obra);
    }

    @Override
    public Obra update(Obra obra) {
        return service.update(obra);
    }

    @Override
    public void delete(Long id) {
        service.delete(id);
    }

    @Override
    public Obra findById(Long id) {
        return service.findById(id);
    }

    @Override
    public List<Obra> findAll() {
        return service.findAll();
    }

    @Override
    public List<Obra> pesquisar(String termo, CategoriaObra categoria) {
        return service.pesquisar(termo, categoria);
    }
}
