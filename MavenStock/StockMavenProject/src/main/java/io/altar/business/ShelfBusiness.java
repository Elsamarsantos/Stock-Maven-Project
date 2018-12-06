package io.altar.business;

import java.util.Collection;
import java.util.Iterator;

import io.altar.model.Product;
import io.altar.model.Shelf;

import io.altar.repository.ShelfRepository;

public class ShelfBusiness {
	private static final ShelfRepository shelfRepository1 = ShelfRepository.getInstance();
	ProductBusiness productBusiness1 = new ProductBusiness();

	
	public void createShelf(Shelf shelf1) {

		Product productInShelf=productBusiness1.consultByIdProduct(shelf1.getProdutoAlberga().getId());
		if (productInShelf !=null) {
			shelf1.setProdutoAlberga(productInShelf);						
			shelfRepository1.saveId(shelf1);
			productInShelf.addToListShelves(shelf1.getId());
		}else {

			Product productInShelf2= null;
			shelf1.setProdutoAlberga(productInShelf2);
			shelfRepository1.saveId(shelf1);

		}


	}
	
	public Collection <Shelf> consultAllShelf(){
		
		return shelfRepository1.consultAll();
		
	}
	
	public void toRemoveShelf(Long id) {
		
		Shelf shelf1 = shelfRepository1.consultById(id);
		if (shelf1!=null) {
		Product productToRemove = productBusiness1.consultByIdProduct(shelf1.getProdutoAlberga().getId());
		productToRemove.removeShelf(shelf1);
		
		shelfRepository1.removeById(id);
		}
}
	public Shelf consultShelf(Long id) {
		
		return shelfRepository1.consultById(id);
	
		}
	
	public void toeditShelf(Shelf shelf1) {
		
		
		if(shelf1.getId()!=0) { //verifica se existe a shelf
		
		
		Product productInShelf=productBusiness1.consultByIdProduct(shelf1.getProdutoAlberga().getId());//vai buscar o produto pelo id introduzido
		
		if (productInShelf !=null) { //se existir este produto entao vai editar a prateira
			
			shelf1.setProdutoAlberga(productInShelf);	//vai colocar o produto na prateleira					
			shelfRepository1.editById(shelf1);
			productInShelf.addToListShelves(shelf1.getId()); //vai colocar a prateleira no produto
		
		}else {

			Product productInShelf2= null;
			shelf1.setProdutoAlberga(productInShelf2);
			shelfRepository1.editById(shelf1);

		}
		
		}
		
	}
	
}