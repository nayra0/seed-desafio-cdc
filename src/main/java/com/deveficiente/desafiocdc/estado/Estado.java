package com.deveficiente.desafiocdc.estado;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.deveficiente.desafiocdc.pais.Pais;

// CI: 1
@Entity
public class Estado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String nome;
	
	// CI: 1
	@NotNull
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_pais")
	private Pais pais;
	
	@Deprecated
	public Estado() {
		super();
	}

	public Estado(@NotBlank String nome, Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Pais getPais() {
		return pais;
	}

	public boolean pertenceAoPais(Pais pais) {
		return this.pais.equals(pais);
	}

}
