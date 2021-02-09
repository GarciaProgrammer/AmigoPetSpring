package br.com.amigopet.controller.form;

import br.com.amigopet.model.Usuario;
import br.com.amigopet.repository.UsuarioRepository;

public class AtualizacaoUsuarioForm {

	private String nome;
	private String email;
	private String senha;
	private String celular;
	private String cidade;
	private String estado;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Usuario atualizar(Long id, UsuarioRepository usuarioRepository) {
		Usuario usuario = usuarioRepository.getOne(id);
		usuario.setNome(this.nome);
		usuario.setEmail(this.email);
		usuario.setSenha(this.senha);
		usuario.setCelular(this.celular);
		usuario.setCidade(this.cidade);
		usuario.setEstado(this.estado);

		return usuario;
	}

}