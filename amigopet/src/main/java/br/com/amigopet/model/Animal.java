package br.com.amigopet.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Animal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String tipo;
	private String raca;
	private int idade;
	private String sexo;
	private String descricao;
	private Byte imagem;
	@ManyToOne
	private Usuario usuario;
	private String cidade;
	private String estado;
	private String status;

	public Animal() {
		super();
	}

	public Animal(String nome, String tipo, String raca, int idade, String sexo, String descricao, Byte imagem,
			Usuario usuario, String cidade, String estado, String status) {
		super();
		this.nome = nome;
		this.tipo = tipo;
		this.raca = raca;
		this.idade = idade;
		this.sexo = sexo;
		this.descricao = descricao;
		this.imagem = imagem;
		this.usuario = usuario;
		this.cidade = cidade;
		this.estado = estado;
		this.status = status;
	}

	public Animal(Long id, String nome, String tipo, String raca, int idade, String sexo, String descricao, Byte imagem,
			Usuario usuario, String cidade, String estado, String status) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.raca = raca;
		this.idade = idade;
		this.sexo = sexo;
		this.descricao = descricao;
		this.imagem = imagem;
		this.usuario = usuario;
		this.cidade = cidade;
		this.estado = estado;
		this.status = status;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Byte getImagem() {
		return imagem;
	}

	public void setImagem(Byte imagem) {
		this.imagem = imagem;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
