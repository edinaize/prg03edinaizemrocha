package br.com.ifba.usuario.validar;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author edina
 */
public class ValidadorUsuario {

    // Verifica se todos os campos foram preenchidos
    public static boolean camposPreenchidos(String... campos) {
        if (campos == null) {
            return false;
        }
        for (String campo : campos) {
            if (campo == null || campo.trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }
 
    // Valida CPF
    public static boolean cpfValido(String cpf) {
      
        if (cpf == null) {
            return false;
        }

        // Remove pontos e traço, deixando só o que sobrou
        String digitos = cpf.replaceAll("[^0-9]", "");

        // Se o tamanho mudou depois de remover só pontuação, é porque tinha letra ou símbolo
        if (digitos.length() != cpf.replaceAll("[.\\-]", "").length()) {
            return false;
        }

        // CPF precisa ter exatamente 11 números
        if (digitos.length() != 11) {
            return false;
        }
        // CPF com todos os dígitos iguais não são válidos
        return digitos.chars().distinct().count() != 1;
    }
 
    // Verifica se a senha atinge o tamanho mínimo exigido
    public static boolean senhaForte(String senha) {
    
        return senha != null && senha.length() >= 6;
    }
 
    // Verifica se a senha e a confirmação de senha são iguais
    public static boolean senhasConferem(String senha, String confirmarSenha) {
        return senha != null && senha.equals(confirmarSenha);
    }
 
    // Verifica se o texto contém alguma palavra proibida
    public static boolean contemPalavraProibida(String texto) {
        if (texto == null) {
            return false;
        }
        
        String[] PALAVRAS_PROIBIDAS = {"admin", "teste", "root", "senha123"};
        
        for (String palavra : PALAVRAS_PROIBIDAS) {
            if (texto.toLowerCase().contains(palavra)) {
                return true;
            }
        }
        return false;
    }
}
