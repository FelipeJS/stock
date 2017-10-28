package br.com.meutrabalho.stock.regra;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Regra {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_REGRA")
	private Long idRegra;

	@Column(name = "REGRA")
	private String regra;

	public Long getIdRegra() {
		return idRegra;
	}

	public void setIdRegra(Long idRegra) {
		this.idRegra = idRegra;
	}

	public String getRegra() {
		return regra;
	}

	public void setRegra(String regra) {
		this.regra = regra;
	}
}