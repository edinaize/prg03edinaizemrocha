/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 *
 * @author edina
 */
public class JPAUtil {
    
    private static final EntityManagerFactory FACTORY = criarFactory();

    private JPAUtil() {
    }

    // Lê o banco do application.properties e entrega ao JPA
    private static EntityManagerFactory criarFactory() {
        Properties propriedades = new Properties();
        try (InputStream entrada = JPAUtil.class.getResourceAsStream("/application.properties")) {
            propriedades.load(entrada);
        } catch (IOException | NullPointerException e) {
            throw new IllegalStateException("Não foi possível ler o application.properties.", e);
        }

        Map<String, String> configuracao = new HashMap<>();
        configuracao.put("jakarta.persistence.jdbc.url", propriedades.getProperty("spring.datasource.url"));
        configuracao.put("jakarta.persistence.jdbc.user", propriedades.getProperty("spring.datasource.username"));
        configuracao.put("jakarta.persistence.jdbc.password", propriedades.getProperty("spring.datasource.password"));
        configuracao.put("jakarta.persistence.jdbc.driver", propriedades.getProperty("spring.datasource.driver-class-name"));

        String prefixo = "spring.jpa.properties.";
        for (String chave : propriedades.stringPropertyNames()) {
            if (chave.startsWith(prefixo)) {
                configuracao.put(chave.substring(prefixo.length()), propriedades.getProperty(chave));
            }
        }

        return Persistence.createEntityManagerFactory(
                "com.mycompany_prg03edinaizemrocha_jar_1.0-SNAPSHOTPU", configuracao);
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
