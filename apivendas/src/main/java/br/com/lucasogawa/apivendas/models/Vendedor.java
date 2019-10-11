package br.com.lucasogawa.apivendas.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_VENDEDOR")
public class Vendedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idVendedor")
	private long id;
	
	@Column(name = "nomeVendedor")
	@NotNull(message = "Campo Obrigatorio")
	private String nome;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "vendedor")
	private Set<Venda> vendas = new HashSet<Venda>();

	public Vendedor() {
		
	}

	public Vendedor(@NotNull(message = "Campo Obrigatorio") String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Vendedor [id=" + id + ", nome=" + nome + "]";
	}
}
