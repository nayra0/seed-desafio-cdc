package com.deveficiente.desafiocdc.autor;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.util.Assert;

import com.sun.istack.NotNull;

/**
 * Carga Intrínseca: 0
 * 
 * @author nayra
 *
 */
@Entity
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	@Size(max = 400)
	private String descricao;
	
	@NotNull
	private LocalDateTime dataCriacao = LocalDateTime.now();

	public Autor(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max = 400) String descricao) {
		super();
		
		Assert.hasText(nome, "O nome precisa ser informado.");
		Assert.hasText(email, "O email precisa ser informado.");
		Assert.hasText(descricao, "A descrição precisa ser informada.");
		
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nome=" + nome + ", email=" + email + ", descricao=" + descricao + ", dataCriacao="
				+ dataCriacao + "]";
	}
	
}
