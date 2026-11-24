/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.validar;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author edina
 */
public class ValidadorUsuarioTest {
 
    // Campos Preenchidos
    @Test
    void camposPreenchidos_todosPreenchidos_retornaTrue() {
        assertTrue(ValidadorUsuario.camposPreenchidos("Ana", "12345678900", "email@teste.com"));
    }
 
    @Test
    void camposPreenchidos_campoVazio_retornaFalse() {
        assertFalse(ValidadorUsuario.camposPreenchidos("Ana", "", "email@teste.com"));
    }
 
    @Test
    void camposPreenchidos_campoComEspacosEmBranco_retornaFalse() {
        assertFalse(ValidadorUsuario.camposPreenchidos("Ana", "   ", "email@teste.com"));
    }
 
    @Test
    void camposPreenchidos_campoNulo_retornaFalse() {
        assertFalse(ValidadorUsuario.camposPreenchidos("Ana", null, "email@teste.com"));
    }
 
    // Senha Forte
    @Test
    void senhaForte_senhaComTamanhoMinimo_retornaTrue() {
        assertTrue(ValidadorUsuario.senhaTemTamanhoMinimo("123456"));
    }
 
    @Test
    void senhaForte_senhaMenorQueOMinimo_retornaFalse() {
        assertFalse(ValidadorUsuario.senhaTemTamanhoMinimo("123"));
    }
 
    @Test
    void senhaForte_senhaVazia_retornaFalse() {
        assertFalse(ValidadorUsuario.senhaTemTamanhoMinimo(""));
    }
 
    @Test
    void senhaForte_senhaNula_retornaFalse() {
        assertFalse(ValidadorUsuario.senhaTemTamanhoMinimo(null));
    }
 
    // Senhas Conferem
    @Test
    void senhasConferem_senhasIguais_retornaTrue() {
        assertTrue(ValidadorUsuario.senhasConferem("123456", "123456"));
    }
 
    @Test
    void senhasConferem_senhasDiferentes_retornaFalse() {
        assertFalse(ValidadorUsuario.senhasConferem("123456", "654321"));
    }
 
    @Test
    void senhasConferem_senhaNula_retornaFalse() {
        assertFalse(ValidadorUsuario.senhasConferem(null, "123456"));
    }
 
    // Contem Palavra Proibida
    @Test
    void contemPalavraProibida_loginComPalavraProibida_retornaTrue() {
        assertTrue(ValidadorUsuario.contemPalavraProibida("admin123"));
    }
 
    @Test
    void contemPalavraProibida_loginSemPalavraProibida_retornaFalse() {
        assertFalse(ValidadorUsuario.contemPalavraProibida("edinaize"));
    }
 
    @Test
    void contemPalavraProibida_loginNulo_retornaFalse() {
        assertFalse(ValidadorUsuario.contemPalavraProibida(null));
    }
}
