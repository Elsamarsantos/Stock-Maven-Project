package io.altar.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
		@NamedQuery(name=Shelf.QUERYALLSHELVES, query="SELECT s FROM Shelf s"),
		@NamedQuery(name=Shelf.QUERYALLSHELVESBYIDPRODUCT, query="SELECT s FROM Shelf s WHERE s.produtoAlberga.id= :id")
})

public class Shelf extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
	
	public static final String QUERYALLSHELVES = "findAllShelves";
	
	public static final String QUERYALLSHELVESBYIDPRODUCT = "findShelvesById";
	
	
	
	private int capacidade;
	
	@ManyToOne(cascade= {CascadeType.PERSIST})
	private Product produtoAlberga;
	private double precoAluguer;
	
	
	

	public int getCapacidade() {
		return capacidade;
	}


	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}


	public Product getProdutoAlberga() {
		return produtoAlberga;
	}


	public void setProdutoAlberga(Product produtoAlberga) {
		this.produtoAlberga = produtoAlberga;
	}


	public double getPrecoAluguer() {
		return precoAluguer;
	}


	public void setPrecoAluguer(double precoAluguer) {
		this.precoAluguer = precoAluguer;
	}


	@Override
	public String toString() {
		if(produtoAlberga!=null)
		return "Shelf id:"+ this.getId()+" [capacidade:" + capacidade + ", Id do produto que Alberga:" + produtoAlberga.getId() + " preco do Aluguer:"
				+ precoAluguer + "]";
		else
			return "Shelf id:"+ this.getId()+" [capacidade:" + capacidade + ", Id do produto que Alberga: nenhum,"  + " preco do Aluguer:"
			+ precoAluguer + "]";
	}


	
}
