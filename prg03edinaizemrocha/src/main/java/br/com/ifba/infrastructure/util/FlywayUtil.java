/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
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
        Properties propriedades = new Properties();
        try (InputStream entrada = FlywayUtil.class.getResourceAsStream("/application.properties")) {
            propriedades.load(entrada);
        } catch (IOException | NullPointerException e) {
            throw new IllegalStateException("Não foi possível ler o application.properties.", e);
        }

        Flyway flyway = Flyway.configure()
                .dataSource(
                        propriedades.getProperty("spring.datasource.url"),
                        propriedades.getProperty("spring.datasource.username"),
                        propriedades.getProperty("spring.datasource.password"))
                .locations("classpath:db/migration")
                .load();

        flyway.migrate();
    }
}
