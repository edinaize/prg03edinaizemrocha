/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import java.lang.reflect.Proxy;

/**
 *
 * @author edina
 */
public class EntityManagerFalso {
    // Registram o que o DAO fez, para os testes conferirem
    boolean rollbackChamado = false;
    boolean fechado = false;

    EntityManager criar() {
        // Transação falsa aberta e registra se houve rollback
        EntityTransaction transacao = (EntityTransaction) Proxy.newProxyInstance(
                EntityTransaction.class.getClassLoader(),
                new Class<?>[]{EntityTransaction.class},
                (proxy, metodo, args) -> {
                    switch (metodo.getName()) {
                        case "isActive":
                            return true;
                        case "rollback":
                            rollbackChamado = true;
                            return null;
                        default:
                            return null;
                    }
                });

        // falha nas operações e registra o close
        return (EntityManager) Proxy.newProxyInstance(
                EntityManager.class.getClassLoader(),
                new Class<?>[]{EntityManager.class},
                (proxy, metodo, args) -> {
                    switch (metodo.getName()) {
                        case "getTransaction":
                            return transacao;
                        case "close":
                            fechado = true;
                            return null;
                        case "persist":
                        case "merge":
                        case "remove":
                        case "find":
                        case "createQuery":
                            throw new PersistenceException("falha simulada");
                        default:
                            return null;
                    }
                });
    }
}
