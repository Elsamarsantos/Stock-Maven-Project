package io.altar.model;



import java.util.List;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity
@NamedQuery(name=Product.QUERYALL, query="SELECT p FROM Product p") 
public class Product extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "produtoAlberga")
	private List<Shelf> listShelfIn;
	private double valorDesconto;
	private double iva;
	private double pvp;
	
	public static final String QUERYALL = "findAllProduct";

	public List<Shelf> getListShelfIn() {
		return listShelfIn;
	}

	public void setListShelfIn(List<Shelf> listShelfIn) {
		this.listShelfIn = listShelfIn;
	}
	
	public void addToListShelves(Shelf shelf) {
		listShelfIn.add(shelf);
	}
	
	public void removeShelf(Shelf shelf) {
		listShelfIn.remove(shelf);
	}


	public double getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(double valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public double getPvp() {
		return pvp;
	}

	public void setPvp(double pvp) {
		this.pvp = pvp;
	}
	
	private String getStringShelves() {
		String str = "";
		for(int i=0;i<listShelfIn.size();i++) {
			str+=listShelfIn.get(i);
			str+=", ";
		}
		return str;
	}

	@Override
	public String toString() {
		return "Product id:"+this.getId()+" [Lista de prateleiras:" +getStringShelves() + " valor do Desconto:" + valorDesconto + ", iva:"
				+ iva + ", pvp:" + pvp + "]";
	}
	
	


}
