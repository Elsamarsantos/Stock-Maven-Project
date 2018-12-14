package io.altar.dto;




public class ShelfDto {
	//private static final long serialVersionUID = 1L;
	private Long id;
	
	private int capacidade;
	//private ProductDto produtoAlberga;
	private double precoAluguer;
	private long produtoAlbergaId = -1;
	
	
//	public ShelfDto(Long id, int capacidade, ProductDto produtoAlberga, double precoAluguer) {
//		this.id= id;
//		this.capacidade = capacidade;
//		this.precoAluguer = precoAluguer;
//	}
//	
	public long getProdutoAlbergaId() {
		return produtoAlbergaId;
	}

	public void setProdutoAlbergaId(long produtoAlbergaId) {
		this.produtoAlbergaId = produtoAlbergaId;
	}

	public ShelfDto(Long id, int capacidade, long produtoAlbergaId , double precoAluguer) {
		this.id= id;
		this.capacidade = capacidade;
		this.produtoAlbergaId = produtoAlbergaId;
		this.precoAluguer = precoAluguer;
	}
	
	public ShelfDto(Long id, int capacidade, double precoAluguer) {
		this.id= id;
		this.capacidade = capacidade;
		this.precoAluguer = precoAluguer;
	}
	
	public ShelfDto() {}
	
	
	public long getId() {
		return id;
	}

	
	public int getCapacidade() {
		return capacidade;
	}
	
	
	
	public double getPrecoAluguer() {
		return precoAluguer;
	}
	
	

}
