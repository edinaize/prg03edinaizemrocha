/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.repository;

import br.com.ifba.usuario.entity.Usuario;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author edina
 */
public class RepositorioUsuarioEmMemoria {
    
    // Armazena os usuários em memória
    private final List<Usuario> usuarios = new ArrayList<>();
    private final Map<String, Usuario> porLogin = new HashMap<>();
    
    // Cadastra um usuário no repositório
    public void cadastrar(Usuario usuario) {
        
        // Evita indexar usuário ou login nulo no Map
         if (usuario == null || usuario.getLogin() == null) {
            throw new IllegalArgumentException("Usuário e login não podem ser nulos.");
        }
        // Impede o cadastro de login duplicado
        if (porLogin.containsKey(usuario.getLogin())) {
            throw new IllegalArgumentException("Já existe um usuário cadastrado com o login: " + usuario.getLogin());
        }
        
        usuarios.add(usuario);
        porLogin.put(usuario.getLogin(), usuario);
    }

    // Retorna todos os usuários cadastrados
    public List<Usuario> listarTodos() {
        return Collections.unmodifiableList(usuarios);
    }
    // Busca o usuário pelo Map
    public Usuario buscarPorLogin(String login) {
        return porLogin.get(login);
    }
    // Busca o usuário percorrendo a lista
    public Usuario buscarPorLoginComVarredura(String login) {
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login)) {
                return usuario;
            }
        }
        return null;
    }
}
