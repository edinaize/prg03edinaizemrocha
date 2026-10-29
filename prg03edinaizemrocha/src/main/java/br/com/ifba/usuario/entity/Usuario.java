/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.entity;

import br.com.ifba.perfil.entity.Perfil;
import br.com.ifba.usuario.interfaces.Autenticavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.util.Objects;

/**
 *
 * @author edina
 */
@Entity
@Table(name = "usuarios")
public class Usuario implements Autenticavel {
    // Chave primária
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false, unique = true, length = 14)
    private String cpf;
    
    private String genero;
    @Column(name = "data_nascimento")
    private String dataNascimento;
    
    private String telefone;
    
    @Column(unique = true)
    private String email;
    
    // Login é a identidade do usuário
    @Column(nullable = false, unique = true)
    private String login;
    
    @Column(nullable = false)
    private String senha;
    
    // Tipo de perfil: USUARIO ou ARTISTA
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_perfil", nullable = false, length = 20)
    private TipoPerfil tipoPerfil = TipoPerfil.USUARIO;
    
    // Perfil associado ao usuário
    @Transient
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

    // Construtor com todos os campos
    public Usuario(String nome, String cpf, String genero, String dataNascimento, String telefone, String email, String login, String senha, Perfil perfil) {
        this.nome = nome;
        this.cpf = cpf;
        this.genero = genero;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.perfil = perfil;
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

    public TipoPerfil getTipoPerfil() {
        return tipoPerfil;
    }

    public void setTipoPerfil(TipoPerfil tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }

    // Retorna o perfil do usuário
    public Perfil getPerfil() {
        return perfil;
    }

    // Define o perfil do usuário
    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    // Retorna o identificador do usuário
    public long getId() {
        return id;
    }
    // Define o identificador do usuário
    public void setId(long id) {
        this.id = id;
    }

    @Override 
    // Recebe o login e a senha informados
    public boolean autenticar(String login, String senha) {
        // Compara os dados informados com os dados do usuário
        return this.login.equals(login) && this.senha.equals(senha);
    }
    
    // Descreve o perfil do usuário
    public String descreverPerfil() {
        return "Usuario: " + nome;
    }
    
    // Usa o login como identificador único do usuário
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Usuario)) {
            return false;
        }

        Usuario usuario = (Usuario) o;
        return login != null && login.equals(usuario.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }
}