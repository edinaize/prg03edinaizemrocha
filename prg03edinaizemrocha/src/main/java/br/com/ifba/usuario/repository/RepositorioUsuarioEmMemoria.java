/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.repository;

import br.com.ifba.usuario.entity.Usuario;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author edina
 */
public class RepositorioUsuarioEmMemoria {
    
    // Armazena os usuários em memória
    private final List<Usuario> usuarios = new ArrayList<>();

    // Cadastra um usuário no repositório
    public void cadastrar(Usuario usuario) {
        usuarios.add(usuario);
    }

    // Retorna todos os usuários cadastrados
    public List<Usuario> listarTodos() {
        return Collections.unmodifiableList(usuarios);
    }
}
