package io.altar.business;

import java.util.Collection;
import java.util.Iterator;

import io.altar.model.Product;
import io.altar.model.Shelf;
import io.altar.repository.ProductRepository;
import io.altar.repository.ShelfRepository;

public class ShelfBusiness {
	private static final ShelfRepository shelfRepository1 = ShelfRepository.getInstance();
	private static final ProductRepository productRepository1= ProductRepository.getInstance();
	

	
	public void createShelf(Shelf shelf1) {

		Product productInShelf=productRepository1.consultById(shelf1.getProdutoAlberga().getId());
				
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
			Product productToRemove = productRepository1.consultById(shelf1.getProdutoAlberga().getId());
			productToRemove.removeShelf(shelf1);

			shelfRepository1.removeById(id);
		}
	}
	public Shelf consultShelf(Long id) {

		return shelfRepository1.consultById(id);

	}
	
	public void toeditShelf(Shelf shelf1) {
		
		
		if(shelf1.getId()!=null) { //verifica se existe a shelf

			Product newProductInShelf=productRepository1.consultById(shelf1.getProdutoAlberga().getId());//vai buscar o produto pelo id introduzido

			Shelf shelfToEdit = shelfRepository1.consultById(shelf1.getId());
			Product oldProductInShelf = productRepository1.consultById(shelfToEdit.getProdutoAlberga().getId());
			
			
			if (newProductInShelf !=null) { //se existir este produto entao vai editar a prateleira
			
				oldProductInShelf.removeShelf(shelf1);

				shelf1.setProdutoAlberga(newProductInShelf);	//vai colocar o produto na prateleira	
				shelfRepository1.editById(shelf1);
				newProductInShelf.addToListShelves(shelf1.getId()); //vai colocar a prateleira no produto

				
				
			}else {

				shelf1.setProdutoAlberga(oldProductInShelf);
				shelfRepository1.editById(shelf1);

			}

		}

	}
	
}