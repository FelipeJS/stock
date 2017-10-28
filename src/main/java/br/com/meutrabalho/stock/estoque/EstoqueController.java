package br.com.meutrabalho.stock.estoque;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

	@Autowired
	private EstoqueRepository estoqueRepository;

	@RequestMapping("/listarEstoques")
	public Iterable<Estoque> listarEstoques() {
		return estoqueRepository.findAll();
	}

	@RequestMapping(value = "/salvarEstoque", method = POST)
	public Estoque salvarEstoque(@RequestBody Estoque estoque) {
		return estoqueRepository.save(estoque);
	}

	@RequestMapping(value = "/removerEstoque", method = DELETE)
	public void removerEstoque(@RequestParam Long idEstoque) {
		estoqueRepository.deleteById(idEstoque);
	}
	
	@RequestMapping(value = "/pesquisarEstoque", method = GET)
	public Estoque pesquisarEstoque(@RequestParam Long idEstoque) {
		return estoqueRepository.findEstoqueByIdEstoque(idEstoque);
	}
}