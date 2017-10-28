package br.com.meutrabalho.stock.usuario;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.meutrabalho.stock.regra.Regra;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_USUARIO")
	private Long idUsuario;

	@Column(name = "EMAIL")
	@Email(message = "*Verifique seu email")
	@NotEmpty(message = "*Preencha o email")
	private String email;

	@Column(name = "SENHA")
	@Length(min = 5, message = "*Senha precisa ter pelo menos 5 caracteres")
	@NotEmpty(message = "*Preencha a senha")
	@JsonIgnore
	private String senha;

	@Column(name = "NOME")
	@NotEmpty(message = "*Preencha o nome")
	private String nome;

	@Column(name = "ATIVO")
	private int ativo;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "usuario_regra", joinColumns = @JoinColumn(name = "ID_USUARIO"), inverseJoinColumns = @JoinColumn(name = "id_regra"))
	private Set<Regra> regras;

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAtivo() {
		return ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}

	public Set<Regra> getRegras() {
		return regras;
	}

	public void setRegras(Set<Regra> regras) {
		this.regras = regras;
	}
}