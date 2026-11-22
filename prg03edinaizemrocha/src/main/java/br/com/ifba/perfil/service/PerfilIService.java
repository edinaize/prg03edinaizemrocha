/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.perfil.service;

import br.com.ifba.perfil.entity.Perfil;
import java.util.List;

/**
 *
 * @author edina
 */
public interface PerfilIService {
    void save(Perfil perfil);
    Perfil update(Perfil perfil);
    void delete(Long id);
    Perfil findById(Long id);
    List<Perfil> findAll();
    Perfil findByUsuarioId(long usuarioId);
    List<Perfil> buscarPorNomeUsuario(String nome);
}
