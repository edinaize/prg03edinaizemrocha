/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.usuario.controller;

import br.com.ifba.usuario.entity.Usuario;
import java.util.List;

/**
 *
 * @author edina
 */
public interface UsuarioIController {
    void save(Usuario usuario);
    Usuario update(Usuario usuario);
    void delete(Long id);
    Usuario findById(Long id);
    List<Usuario> findAll();
    Usuario findByLogin(String login);
    List<Usuario> buscarPorNome(String nome);
    // UsuarioIService e UsuarioIController
    void validar(Usuario usuario);
}
