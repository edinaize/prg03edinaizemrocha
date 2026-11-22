/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.main;

import br.com.ifba.artista.controller.ArtistaController;
import br.com.ifba.artista.controller.ArtistaIController;
import br.com.ifba.artista.dao.ArtistaDao;
import br.com.ifba.artista.dao.ArtistaIDao;
import br.com.ifba.artista.service.ArtistaIService;
import br.com.ifba.artista.service.ArtistaService;
import br.com.ifba.infrastructure.util.FlywayUtil;
import br.com.ifba.obra.controller.ObraController;
import br.com.ifba.obra.dao.ObraDao;
import br.com.ifba.obra.service.ObraService;
import br.com.ifba.perfil.controller.PerfilController;
import br.com.ifba.perfil.dao.PerfilDao;
import br.com.ifba.perfil.service.PerfilService;
import br.com.ifba.usuario.controller.UsuarioController;
import br.com.ifba.usuario.controller.UsuarioIController;
import br.com.ifba.usuario.dao.UsuarioDao;
import br.com.ifba.usuario.dao.UsuarioIDao;
import br.com.ifba.usuario.service.UsuarioIService;
import br.com.ifba.usuario.service.UsuarioService;
import br.com.ifba.usuario.view.TelaUsuarioListar;

/**
 *
 * @author edina
 */
public class Main {
    
     public static void main(String[] args) {
        FlywayUtil.migrar();   // primeiro o banco, depois a tela

        // DAOs
        UsuarioIDao usuarioDao = new UsuarioDao();
        ArtistaIDao artistaDao = new ArtistaDao();

        // Services (recebem o DAO)
        UsuarioIService usuarioService = new UsuarioService(usuarioDao);
        ArtistaIService artistaService = new ArtistaService(artistaDao, usuarioService);

        // Controllers (recebem o Service)
        UsuarioIController usuarioController = new UsuarioController(usuarioService);
        ArtistaIController artistaController = new ArtistaController(artistaService);

        // Obra e Perfil ainda não têm tela, mas ficam montados do mesmo jeito
        new ObraController(new ObraService(new ObraDao()));
        new PerfilController(new PerfilService(new PerfilDao()));

        java.awt.EventQueue.invokeLater(() ->
            new TelaUsuarioListar(usuarioController, artistaController).setVisible(true));
    }
}
