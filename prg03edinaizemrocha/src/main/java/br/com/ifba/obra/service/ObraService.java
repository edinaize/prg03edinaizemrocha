/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.obra.service;

import br.com.ifba.obra.dao.ObraDao;
import br.com.ifba.obra.dao.ObraIDao;
import br.com.ifba.obra.entity.CategoriaObra;
import br.com.ifba.obra.entity.Obra;
import java.util.List;

/**
 *
 * @author edina
 */
public class ObraService implements ObraIService {
    private final ObraIDao dao = new ObraDao();

    @Override
    public void save(Obra obra) {
        dao.save(obra);
    }

    @Override
    public Obra update(Obra obra) {
        return dao.update(obra);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public Obra findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<Obra> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Obra> pesquisar(String termo, CategoriaObra categoria) {
        return dao.pesquisar(termo, categoria);
    }
}
