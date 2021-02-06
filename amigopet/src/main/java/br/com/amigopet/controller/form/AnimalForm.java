package br.com.amigopet.controller.form;



import br.com.amigopet.model.Animal;
import br.com.amigopet.model.Usuario;

public class AnimalForm {
	
	private String nome;
	private String tipo;
	private String raca;
	private int idade;
	private String sexo;
	private String descricao;
	private Byte imagem;
	private String cidade;
	private String estado;
	private Usuario usuario;
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
	public Animal converter() {
		return new Animal(nome, tipo, raca, idade, sexo, descricao, imagem, usuario, cidade, estado);
	}
	
	

}
