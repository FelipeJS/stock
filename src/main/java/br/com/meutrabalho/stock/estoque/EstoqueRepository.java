package br.com.meutrabalho.stock.estoque;

import org.springframework.data.repository.CrudRepository;

public interface EstoqueRepository extends CrudRepository<Estoque, Long> {

	public Estoque findEstoqueByIdEstoque(Long idEstoque);
}