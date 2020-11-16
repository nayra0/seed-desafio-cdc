package com.deveficiente.desafiocdc.categoria;

import java.util.HashMap;
import java.util.function.Function;

import javax.validation.constraints.NotBlank;

import com.deveficiente.desafiocdc.compartilhado.UniqueProperties;
import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Carga Intrínseca: 3
 * 
 * 1
 */
public class NovaCategoriaForm implements UniqueProperties{

	@NotBlank
	private String nome;
	
	@JsonCreator
	public NovaCategoriaForm(@NotBlank String nome) {
		super();
		this.nome = nome;
	}
	
	/**
	 * Carga Intrínseca: 1
	 * 
	 */
	public Categoria toModel() {
		return new Categoria(nome);
	}
	
	/**
	 * Carga Intrínseca: 1
	 * 
	 */
	@SuppressWarnings("unchecked")
	public HashMap<String, Function<NovaCategoriaForm, String>> obterPropriedadesUnicas() {
		HashMap<String, Function<NovaCategoriaForm, String>> propriedadesUnicas = new HashMap<>();
		propriedadesUnicas.put("nome", NovaCategoriaForm::getNome);
		return propriedadesUnicas;
	}
	
	public String getNome() {
		return nome;
	}
	
}
