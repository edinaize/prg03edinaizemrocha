/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author edina
 */
public class JPAUtil {
    
    private static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("com.mycompany_prg03edinaizemrocha_jar_1.0-SNAPSHOTPU");

    private JPAUtil() {
    }

    // Cria um EntityManager para acessar o banco
    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }

    // Fecha quando não for mais necessário
    public static void fecharFactory() {
        if (FACTORY.isOpen()) {
            FACTORY.close();
        }
    }
}
