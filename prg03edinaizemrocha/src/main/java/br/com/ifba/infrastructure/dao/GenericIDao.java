/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.infrastructure.dao;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import java.util.List;

/**
 *
 * @author edina
 * @param <Entity>
 */
public interface GenericIDao<Entity extends PersistenceEntity> {
     // Grava uma nova entidade
    void save(Entity entity);

    // Atualiza uma entidade existente
    Entity update(Entity entity);

    // Remove uma entidade
    void delete(Long id);

    // Busca pelo id 
    Entity findById(Long id);

    // Lista todas as entidades
    List<Entity> findAll();
}
