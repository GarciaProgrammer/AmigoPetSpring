package br.com.amigopet.dto;

import java.util.Optional;


import br.com.amigopet.model.Usuario;

public class UsuarioDto {

	private Long id;
	private String nome;
	private String email;
	private String celular;
	
	public UsuarioDto(Long id, String nome,String email, String celular) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.celular = celular;
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

	public static UsuarioDto converter(Optional<Usuario> usuario) {
		UsuarioDto usuarioDto = new UsuarioDto(usuario.get().getId(),usuario.get().getNome(), usuario.get().getEmail(), usuario.get().getCelular());
		return usuarioDto;
	}
	
	
}
