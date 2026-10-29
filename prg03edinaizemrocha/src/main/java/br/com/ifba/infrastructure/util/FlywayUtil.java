/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.util;

import org.flywaydb.core.Flyway;
/**
 *
 * @author edina
 */
public class FlywayUtil {
    
    private FlywayUtil() {
    }

    // Aplica as migrations pendentes no banco
    public static void migrar() {
        String url = System.getenv("DB_URL");
        String usuario = System.getenv("DB_USER");
        String senha = System.getenv("DB_PASSWORD");

        if (url == null || usuario == null || senha == null) {
            throw new IllegalStateException(
                "Defina as variáveis de ambiente DB_URL, DB_USER e DB_PASSWORD.");
        }

        Flyway flyway = Flyway.configure()
                .dataSource(url, usuario, senha)
                .locations("classpath:db/migration")
                .load();

        flyway.migrate();
    }
}
