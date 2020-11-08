package com.deveficiente.desafiocdc.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Carga Intrínseca: 1
 * 
 * @author nayra
 *
 */
public class AutorForm {

	@NotBlank
	private String nome;

	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	@Size(max = 400)
	private String descricao;

	public AutorForm(@NotBlank String nome, @NotBlank @Email String email,
			@NotBlank @Size(max = 400) String descricao) {
		super();
		
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	/**
	 * Retorna um Autor baseado nos atributos
	 * 
	 * Carga Intrínseca: 1
	 * 
	 * @return
	 */
	public Autor toModel() {
		return new Autor(this.nome, this.email, this.descricao);
	}

}
