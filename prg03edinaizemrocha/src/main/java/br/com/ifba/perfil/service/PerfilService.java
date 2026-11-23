/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.perfil.service;

import br.com.ifba.perfil.dao.PerfilIDao;
import br.com.ifba.perfil.entity.Perfil;
import java.util.List;

/**
 *
 * @author edina
 */
public class PerfilService implements PerfilIService {
    private final PerfilIDao dao;
    
    public PerfilService(PerfilIDao dao) {
        this.dao = dao;
    }

    @Override
    public void save(Perfil perfil) {
        dao.save(perfil);
    }

    @Override
    public Perfil update(Perfil perfil) {
        return dao.update(perfil);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public Perfil findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<Perfil> findAll() {
        return dao.findAll();
    }

    @Override
    public Perfil findByUsuarioId(long usuarioId) {
        return dao.findByUsuarioId(usuarioId);
    }

    @Override
    public List<Perfil> buscarPorNomeUsuario(String nome) {
        return dao.findByNomeUsuario(nome);
    }
}
