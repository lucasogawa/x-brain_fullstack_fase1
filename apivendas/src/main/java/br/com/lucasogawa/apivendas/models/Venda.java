package br.com.lucasogawa.apivendas.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "TB_VENDA")
public class Venda{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idVenda")
	private long id;
	
	@Column(name = "dataVenda")
	@NotNull(message = "Campo Obrigatorio")
	private Date dataVenda;
	
	@Column(name = "valorVenda")
	@NotNull(message = "Campo Obrigatorio")
	private double valor;
	
	@ManyToOne
	@JoinColumn(name = "vendedorIdNome")
	@JsonBackReference
	@NotNull(message = "Campo Obrigatorio")
	private Vendedor vendedor;
	
	public Venda() {
		
	}	

	public Venda(@NotNull(message = "Campo Obrigatorio") Date dataVenda,
			@NotNull(message = "Campo Obrigatorio") double valor,
			@NotNull(message = "Campo Obrigatorio") Vendedor vendedor) {
		super();
		this.dataVenda = dataVenda;
		this.valor = valor;
		this.vendedor = vendedor;
	}

	public Date getDataVenda() {
		return dataVenda;
	}
	
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", dataVenda=" + dataVenda + ", valor=" + valor + ", vendedor=" + vendedor + "]";
	}
}
