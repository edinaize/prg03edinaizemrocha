package br.com.ifba;


import br.com.ifba.infrastructure.util.FlywayUtil;
import br.com.ifba.login.view.TelaLogin;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author edina
 */
@SpringBootApplication
public class ProjetoApplication {

    public static void main(String[] args) {
        FlywayUtil.migrar();
        
        ConfigurableApplicationContext context =
                new SpringApplicationBuilder(ProjetoApplication.class)
                        .headless(false)
                        .run(args);

        TelaLogin tela = context.getBean(TelaLogin.class);
        tela.setVisible(true);
    }
}
