package io.altar.business;

import java.util.Collection;
import java.util.Iterator;

import io.altar.model.Product;
import io.altar.model.Shelf;
import io.altar.repository.ProductRepository;

public class ProductBusiness {

	private static final ProductRepository productRepository1= ProductRepository.getInstance();
	
	
	public void createProduct(Product product1) {
		
		productRepository1.saveId(product1);
	}

	public Collection<Product> consultAllProduct() {
		
		return productRepository1.consultAll();
	}
	
	
	public void removeProduct(Long id) {
		
		Product productToRemove = productRepository1.consultById(id);
		
		Iterator<Long> shelfList = productToRemove.getListShelfIn().iterator(); 
		while (shelfList.hasNext()) {
			Shelf shelf1 = ShelfBusiness.consultShelf(shelfList.next());
			shelf1.setProdutoAlberga(null);
		}
		
		
		productRepository1.removeById(id);
		
		
	}
	public Product consultByIdProduct(Long id) {
		return productRepository1.consultById(id);
	}
	
	
	public void editProductByID(Product product1) {

		 productRepository1.editById(product1);
		 

	
	}
}
