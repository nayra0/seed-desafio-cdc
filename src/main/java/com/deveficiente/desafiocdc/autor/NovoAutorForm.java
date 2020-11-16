package com.deveficiente.desafiocdc.autor;

import java.util.HashMap;
import java.util.function.Function;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.deveficiente.desafiocdc.compartilhado.UniqueProperties;

/**
 * Carga Intrínseca: 3
 *
 * 1
 */
public class NovoAutorForm implements UniqueProperties{

	@NotBlank
	private String nome;

	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	@Size(max = 400)
	private String descricao;

	public NovoAutorForm(@NotBlank String nome, @NotBlank @Email String email,
			@NotBlank @Size(max = 400) String descricao) {
		super();
		
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	/**
	 * Carga Intrínseca: 1
	 * 
	 */
	public Autor toModel() {
		return new Autor(this.nome, this.email, this.descricao);
	}
	
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * Carga Intrínseca: 1
	 * 
	 */
	@SuppressWarnings("unchecked")
	public HashMap<String, Function<NovoAutorForm, String>> obterPropriedadesUnicas() {
		HashMap<String, Function<NovoAutorForm, String>> propriedadesUnicas = new HashMap<>();
		propriedadesUnicas.put("email", NovoAutorForm::getEmail);
		return propriedadesUnicas;
	}

}
