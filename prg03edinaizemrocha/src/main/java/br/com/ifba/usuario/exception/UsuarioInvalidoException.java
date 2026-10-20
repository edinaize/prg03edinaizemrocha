/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.exception;

/**
 *
 * @author edina
 */
public class UsuarioInvalidoException extends RuntimeException{
    // Representa erros nos dados informados do usuário
    public UsuarioInvalidoException(String mensagem) {
        super(mensagem);
    } 
}
