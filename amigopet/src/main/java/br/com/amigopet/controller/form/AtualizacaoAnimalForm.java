package br.com.amigopet.controller.form;

import br.com.amigopet.model.Animal;
import br.com.amigopet.repository.AnimalRepository;

public class AtualizacaoAnimalForm {
	
	private String nome;
	private String tipo;
	private String raca;
	private int idade;
	private String sexo;
	private String descricao;
	private Byte imagem;
	private String cidade;
	private String estado;
	
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
	public Animal atualizar(Long id, AnimalRepository animalRepository) {
		Animal animal = animalRepository.getOne(id);
		animal.setNome(this.nome);
		animal.setTipo(this.tipo);
		animal.setRaca(this.raca);
		animal.setIdade(this.idade);
		animal.setSexo(this.sexo);
		animal.setDescricao(this.descricao);
		animal.setImagem(this.imagem);
		animal.setCidade(this.cidade);
		animal.setEstado(this.estado);
		
		return animal;
	}
	
	

}
