/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.usuario.dao;

import br.com.ifba.infrastructure.dao.GenericIDao;
import br.com.ifba.usuario.entity.Usuario;
import java.util.List;

/**
 *
 * @author edina
 */
public interface UsuarioIDao extends GenericIDao<Usuario> {
    // Busca pelo login
    Usuario findByLogin(String login);

    // Busca por parte do nome, em ordem alfabética
    List<Usuario> buscarPorNome(String nome);
}
