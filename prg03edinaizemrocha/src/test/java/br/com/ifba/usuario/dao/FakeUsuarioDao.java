/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.dao;

import br.com.ifba.usuario.entity.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edina
 */
public class FakeUsuarioDao implements UsuarioIDao {
    private final List<Usuario> usuarios = new ArrayList<>();
    private long proximoId = 1;

    @Override
    public void save(Usuario usuario) {
        usuario.setId(proximoId++);
        usuarios.add(usuario);
    }

    @Override
    public Usuario update(Usuario usuario) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == usuario.getId()) {
                usuarios.set(i, usuario);
                return usuario;
            }
        }
        return usuario;
    }

    @Override
    public void delete(Long id) {
        usuarios.removeIf(u -> u.getId() == id);
    }

    @Override
    public Usuario findById(Long id) {
        return usuarios.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Usuario> findAll() {
        return new ArrayList<>(usuarios);
    }

    @Override
    public Usuario findByLogin(String login) {
        return usuarios.stream().filter(u -> u.getLogin().equals(login)).findFirst().orElse(null);
    }

    @Override
    public List<Usuario> buscarPorNome(String nome) {
        String termo = nome == null ? "" : nome.trim().toLowerCase();
        return usuarios.stream()
                .filter(u -> u.getNome().toLowerCase().contains(termo))
                .toList();
    }    
}
