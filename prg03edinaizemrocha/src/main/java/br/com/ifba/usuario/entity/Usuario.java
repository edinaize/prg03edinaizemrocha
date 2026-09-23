/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.entity;

import br.com.ifba.perfil.entity.Perfil;
import br.com.ifba.usuario.interfaces.Autenticavel;

/**
 *
 * @author edina
 */
public class Usuario implements Autenticavel {
    
    private String nome;
    private String cpf;
    private String genero;
    private String dataNascimento;
    private String telefone;
    private String email;
    private String login;
    private String senha;
    
    // Perfil associado ao usuário
    private Perfil perfil;

    // Construtor vazio
    public Usuario() {
    }
    
    // Construtor com os atributos principais
    public Usuario(String nome, String cpf, String login, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.login = login;
        this.senha = senha;
    }

    // Getters e setters dos atributos
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Retorna o perfil do usuário
    public Perfil getPerfil() {
        return perfil;
    }

    // Define o perfil do usuário
    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    

    @Override 
    // Recebe o login e a senha informados
    public boolean autenticar(String login, String senha) {
        // Compara os dados informados com os dados do usuário
        return this.login.equals(login) && this.senha.equals(senha);
    }
    
}
