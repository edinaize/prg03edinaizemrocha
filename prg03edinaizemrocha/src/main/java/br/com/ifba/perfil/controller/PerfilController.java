/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.perfil.controller;

import br.com.ifba.perfil.entity.Perfil;
import br.com.ifba.perfil.service.PerfilIService;
import java.util.List;

/**
 *
 * @author edina
 */
public class PerfilController implements PerfilIController {
    private final PerfilIService service;
    
    public PerfilController(PerfilIService service) {
        this.service = service;
    }
    @Override
    public void save(Perfil perfil) {
        service.save(perfil);
    }

    @Override
    public Perfil update(Perfil perfil) {
        return service.update(perfil);
    }

    @Override
    public void delete(Long id) {
        service.delete(id);
    }

    @Override
    public Perfil findById(Long id) {
        return service.findById(id);
    }

    @Override
    public List<Perfil> findAll() {
        return service.findAll();
    }

    @Override
    public Perfil findByUsuarioId(long usuarioId) {
        return service.findByUsuarioId(usuarioId);
    }

    @Override
    public List<Perfil> buscarPorNomeUsuario(String nome) {
        return service.buscarPorNomeUsuario(nome);
    }
}
