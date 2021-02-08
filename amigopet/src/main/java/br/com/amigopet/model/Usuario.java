package br.com.amigopet.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private String celular;
	@OneToMany(mappedBy = "usuario")
	private List<Animal> animais = new ArrayList<>();
	@OneToMany(mappedBy = "usuario")
	private List<DadosBancarios> dadosBancarios = new ArrayList<>();
	private String cidade;
	private String estado;

	public Usuario() {
		super();
	}

	public Usuario(String nome, String email, String senha, String celular, List<Animal> animais,
			List<DadosBancarios> dadosBancarios, String cidade, String estado) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.celular = celular;
		this.animais = animais;
		this.dadosBancarios = dadosBancarios;
		this.cidade = cidade;
		this.estado = estado;
	}

	public Usuario(Long id, String nome, String email, String senha, String celular, List<Animal> animais,
			List<DadosBancarios> dadosBancarios, String cidade, String estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.celular = celular;
		this.animais = animais;
		this.dadosBancarios = dadosBancarios;
		this.cidade = cidade;
		this.estado = estado;
	}

	public Usuario(String nome, String email, String senha, String celular, String cidade, String estado) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.celular = celular;
		this.cidade = cidade;
		this.estado = estado;
	}

	public Usuario(Long id, String nome, String email, String senha, String celular, String cidade, String estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.celular = celular;
		this.cidade = cidade;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public List<Animal> getAnimais() {
		return animais;
	}

	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
	}

	public List<DadosBancarios> getDadosBancarios() {
		return dadosBancarios;
	}

	public void setDadosBancarios(List<DadosBancarios> dadosBancarios) {
		this.dadosBancarios = dadosBancarios;
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

}
