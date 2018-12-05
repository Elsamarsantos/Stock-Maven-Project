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
		shelf1.setProdutoAlberga(productInShelf);						
		
		
		
		
		shelfRepository1.saveId(shelf1);
		
		productInShelf.addToListShelves(shelf1.getId());
		
			
		
	}
	
	public Collection <Shelf> consultAllShelf(){
		
		return shelfRepository1.consultAll();
		
	}
	
	public void toRemoveShelf(Long id) {
		shelfRepository1.removeById(id);
	
}
	public Shelf consultShelf(Long id) {
		return shelfRepository1.consultById(id);
	}
	
	public void toeditShelf(Shelf shelf1) {
		
		shelfRepository1.editById(shelf1);
		
	}
	
}