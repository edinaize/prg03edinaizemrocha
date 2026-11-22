/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.service;

import br.com.ifba.usuario.dao.UsuarioDao;
import br.com.ifba.usuario.dao.UsuarioIDao;
import br.com.ifba.usuario.entity.Usuario;
import java.util.List;

/**
 *
 * @author edina
 */
public class UsuarioService implements UsuarioIService {
   
    private final UsuarioIDao dao = new UsuarioDao();

    @Override
    public void save(Usuario usuario) {
        dao.save(usuario);
    }

    @Override
    public Usuario update(Usuario usuario) {
        return dao.update(usuario);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public Usuario findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<Usuario> findAll() {
        return dao.findAll();
    }

    @Override
    public Usuario findByLogin(String login) {
        return dao.findByLogin(login);
    }

    @Override
    public List<Usuario> buscarPorNome(String nome) {
        return dao.buscarPorNome(nome);
    }
}
