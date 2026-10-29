/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.main;

import br.com.ifba.infrastructure.util.FlywayUtil;
import br.com.ifba.usuario.view.TelaUsuarioListar;

/**
 *
 * @author edina
 */
public class Main {
    
     public static void main(String[] args) {
        FlywayUtil.migrar();   // primeiro o banco, depois a tela

        java.awt.EventQueue.invokeLater(() -> new TelaUsuarioListar().setVisible(true));
    }
}
