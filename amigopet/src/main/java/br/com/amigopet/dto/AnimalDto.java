package br.com.amigopet.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.amigopet.model.Animal;

public class AnimalDto {

	private Long id;
	private String nome;
	private String tipo;
	private String raca;
	private int idade;
	private String sexo;
	private String descricao;
	private String imagem;
	private Long usuario;
	private String cidade;
	private String estado;
	private String status;
	private String porte;

	public AnimalDto(Animal animal) {
		this.id = animal.getId();
		this.nome = animal.getNome();
		this.tipo = animal.getTipo();
		this.raca = animal.getRaca();
		this.idade = animal.getIdade();
		this.sexo = animal.getSexo();
		this.descricao = animal.getDescricao();
		this.imagem = animal.getImagem();
		this.usuario = animal.getUsuario().getId();
		this.cidade = animal.getCidade();
		this.estado = animal.getEstado();
		this.status = animal.getStatus();
		this.porte = animal.getPorte();

	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getTipo() {
		return tipo;
	}

	public String getRaca() {
		return raca;
	}

	public int getIdade() {
		return idade;
	}

	public String getSexo() {
		return sexo;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getImagem() {
		return imagem;
	}

	public Long getUsuario() {
		return usuario;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public String getStatus() {
		return status;
	}

	public String getPorte() {
		return porte;
	}

	public static List<AnimalDto> converterLista(List<Animal> animais) {
		return animais.stream().map(AnimalDto::new).collect(Collectors.toList());
	}

}
