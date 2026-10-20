/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.exception;

/**
 *
 * @author edina
 */
public class UsuarioNaoEncontradoException extends RuntimeException{
    // Representa buscas por usuários inexistentes
    public UsuarioNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
