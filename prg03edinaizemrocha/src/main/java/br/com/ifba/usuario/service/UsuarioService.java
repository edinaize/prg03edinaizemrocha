/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.service;

import br.com.ifba.artista.entity.Artista;
import br.com.ifba.usuario.dao.UsuarioIDao;
import br.com.ifba.usuario.entity.TipoPerfil;
import br.com.ifba.usuario.entity.Usuario;
import br.com.ifba.usuario.exception.UsuarioInvalidoException;
import br.com.ifba.usuario.validar.ValidadorUsuario;
import java.util.List;

/**
 *
 * @author edina
 */
public class UsuarioService implements UsuarioIService {
   
    private final UsuarioIDao dao;

    public UsuarioService(UsuarioIDao dao) {
        this.dao = dao;
    }
    // Regras de negócio do usuário
    @Override
    public void validar(Usuario usuario) {
        if (!ValidadorUsuario.camposPreenchidos(
                usuario.getNome(), usuario.getDataNascimento(), usuario.getTelefone(),
                usuario.getEmail(), usuario.getLogin(), usuario.getSenha())) {
            throw new UsuarioInvalidoException("Preencha todos os campos.");
        }
        if (!ValidadorUsuario.senhaForte(usuario.getSenha())) {
            throw new UsuarioInvalidoException("Senha muito curta. Use pelo menos 6 caracteres.");
        }
        if (ValidadorUsuario.contemPalavraProibida(usuario.getLogin())) {
            throw new UsuarioInvalidoException("Login contém palavra não permitida.");
        }
    }
    
    @Override
    public void save(Usuario usuario) {
        validar(usuario);
        dao.save(usuario);
    }

    @Override
    public Usuario update(Usuario usuario) {
        validar(usuario);
        return dao.update(usuario);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public Usuario findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<Usuario> findAll() {
        return dao.findAll();
    }

    @Override
    public Usuario findByLogin(String login) {
        return dao.findByLogin(login);
    }

    @Override
    public List<Usuario> buscarPorNome(String nome) {
        return dao.buscarPorNome(nome);
    }

    @Override
    public Usuario criarUsuario(TipoPerfil tipo, String nome, String login, String senha) {
        if (tipo == TipoPerfil.ARTISTA) {
            return new Artista(nome, login, senha);
        }
        return new Usuario(nome, login, senha);
    }

    @Override
    public void preencherDadosPessoais(Usuario usuario, String genero,
        String dataNascimento, String telefone, String email) {
        
        usuario.setGenero(genero);
        usuario.setDataNascimento(dataNascimento);
        usuario.setTelefone(telefone);
        usuario.setEmail(email.trim().isEmpty() ? null : email.trim());
    }
}
