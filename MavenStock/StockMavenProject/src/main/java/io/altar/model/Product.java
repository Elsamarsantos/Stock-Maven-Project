package io.altar.model;



import java.util.List;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;


@Entity
public class Product extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "produtoAlberga")
	private List<Shelf> listShelfIn;
	private double valorDesconto;
	private double iva;
	private double pvp;
	
	//Os construtores ja nao sao necessario. o jpa cria 

//	public Product(){}
//
//	public Product(List<Shelf> listShelfIn,double valorDesconto, double iva, double pvp) {
//		this.listShelfIn= listShelfIn;
//		this.valorDesconto = valorDesconto;
//		this.iva = iva;
//		this.pvp = pvp;
//	}

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
//	public void removeShelf(Long shelfId) {
//		listShelfIn.remove(shelfId);
//	}

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
