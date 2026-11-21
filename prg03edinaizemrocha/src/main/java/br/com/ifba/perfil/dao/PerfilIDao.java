/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.perfil.dao;

import br.com.ifba.infrastructure.dao.GenericIDao;
import br.com.ifba.perfil.entity.Perfil;
import java.util.List;

/**
 *
 * @author edina
 */
interface PerfilIDao extends GenericIDao<Perfil> {
    // Busca o perfil de um usuário (nulo se não existir)
    Perfil findByUsuarioId(long usuarioId);

    // Busca por parte do nome do usuário, em ordem alfabética
    List<Perfil> buscarPorNomeUsuario(String nome);
    
}
