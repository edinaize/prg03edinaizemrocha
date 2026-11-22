/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.controller;

import br.com.ifba.usuario.entity.Usuario;
import br.com.ifba.usuario.service.UsuarioIService;
import br.com.ifba.usuario.service.UsuarioService;
import java.util.List;

/**
 *
 * @author edina
 */
public class UsuarioController implements UsuarioIController {
    private final UsuarioIService service = new UsuarioService();

@Override
    public void save(Usuario usuario) {
        service.save(usuario);
    }

    @Override
    public Usuario update(Usuario usuario) {
        return service.update(usuario);
    }

    @Override
    public void delete(Long id) {
        service.delete(id);
    }

    @Override
    public Usuario findById(Long id) {
        return service.findById(id);
    }

    @Override
    public List<Usuario> findAll() {
        return service.findAll();
    }

    @Override
    public Usuario findByLogin(String login) {
        return service.findByLogin(login);
    }

    @Override
    public List<Usuario> buscarPorNome(String nome) {
        return service.buscarPorNome(nome);
    }
    
    @Override
    public void validar(Usuario usuario) {
        service.validar(usuario);
    }
}
