/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.exception;

/**
 *
 * @author edina
 */
public class DaoException extends RuntimeException{

    public DaoException(String mensagem) {
        super(mensagem);
    }

    public DaoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
   
}
