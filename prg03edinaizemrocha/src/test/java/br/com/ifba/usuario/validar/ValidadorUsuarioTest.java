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
 
    // CPF Valido
    @Test
    void cpfValido_cpfComFormatoCorreto_retornaTrue() {
        // CPF válido usado como referência (dígitos verificadores corretos)
        assertTrue(ValidadorUsuario.cpfValido("529.982.247-25"));
    }
 
    @Test
    void cpfValido_cpfVazio_retornaFalse() {
        assertFalse(ValidadorUsuario.cpfValido(""));
    }
 
    @Test
    void cpfValido_cpfComLetras_retornaFalse() {
        assertFalse(ValidadorUsuario.cpfValido("abc.def.ghi-jk"));
    }
 
    @Test
    void cpfValido_cpfComTamanhoErrado_retornaFalse() {
        assertFalse(ValidadorUsuario.cpfValido("123456789"));
    }
 
    @Test
    void cpfValido_cpfComTodosDigitosIguais_retornaFalse() {
        assertFalse(ValidadorUsuario.cpfValido("111.111.111-11"));
    }
 
    @Test
    void cpfValido_cpfNulo_retornaFalse() {
        assertFalse(ValidadorUsuario.cpfValido(null));
    }
 
    // Senha Forte
    @Test
    void senhaForte_senhaComTamanhoMinimo_retornaTrue() {
        assertTrue(ValidadorUsuario.senhaForte("123456"));
    }
 
    @Test
    void senhaForte_senhaMenorQueOMinimo_retornaFalse() {
        assertFalse(ValidadorUsuario.senhaForte("123"));
    }
 
    @Test
    void senhaForte_senhaVazia_retornaFalse() {
        assertFalse(ValidadorUsuario.senhaForte(""));
    }
 
    @Test
    void senhaForte_senhaNula_retornaFalse() {
        assertFalse(ValidadorUsuario.senhaForte(null));
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
