package com.deveficiente.desafiocdc.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorForm {

	@NotBlank
	private String nome;

	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	@Size(max = 400)
	private String descricao;

	public Autor toModel() {
		return new Autor(this.nome, this.email, this.descricao);
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
