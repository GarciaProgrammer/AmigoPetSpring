package br.com.amigopet.dto;

import br.com.amigopet.model.Usuario;

public class UsuarioDto {

	private Long id;
	private String nome;
	private String email;
	private String celular;
	private String cidade;
	private String estado;

	public UsuarioDto(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.celular = usuario.getCelular();
		this.cidade = usuario.getCidade();
		this.estado = usuario.getEstado();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getCelular() {
		return celular;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

}
