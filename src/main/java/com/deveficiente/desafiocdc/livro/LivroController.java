package com.deveficiente.desafiocdc.livro;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// CI: 4
@RestController
@RequestMapping("/livros")
public class LivroController {

	private EntityManager manager;

	public LivroController(EntityManager manager) {
		super();
		this.manager = manager;
	}

	// CI: 2
	@GetMapping
	public ResponseEntity<ItemLivroResponse> lista() {
		List<Livro> livros = obterLivrosCadastrados();
		return ResponseEntity.ok(new ItemLivroResponse(livros));
	}

	// CI: 2
	@GetMapping("{id}")
	public ResponseEntity<DetalheLivroResponse> detalhe(@PathVariable Long id) {
		Livro livro = this.manager.find(Livro.class, id);

		if (livro == null)
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(new DetalheLivroResponse(livro));
	}

	private List<Livro> obterLivrosCadastrados() {
		String hql = String.format("select livro from %s livro", Livro.class.getName());
		return this.manager.createQuery(hql, Livro.class).getResultList();
	}

}
