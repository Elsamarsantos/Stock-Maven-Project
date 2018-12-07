package io.altar.business;

import java.util.Collection;
import java.util.Iterator;

import io.altar.model.Product;
import io.altar.model.Shelf;
import io.altar.repository.ProductRepository;
import io.altar.repository.ShelfRepository;

public class ProductBusiness {

	private static final ProductRepository productRepository1 = ProductRepository.getInstance();
	private static final ShelfRepository shelfRepository1 = ShelfRepository.getInstance();

	public void createProduct(Product product1) {

		Iterator<Long> listShelfInProduct = product1.getListShelfIn().iterator();

		Shelf shelfToAdd;

		while (listShelfInProduct.hasNext()) {
			Long idShelf=listShelfInProduct.next();
			shelfToAdd = shelfRepository1.consultById(idShelf);
			if (shelfToAdd != null && shelfToAdd.getProdutoAlberga() == null) {
				shelfToAdd.setProdutoAlberga(product1);
			} else  {
				product1.removeShelf(idShelf);
				listShelfInProduct = product1.getListShelfIn().iterator();
			}
		}

		productRepository1.saveId(product1);
	}

	public Collection<Product> consultAllProduct() {

		return productRepository1.consultAll();
	}

	public void removeProduct(Long id) {

		Product productToRemove = productRepository1.consultById(id);

		if (productToRemove != null) {
			Iterator<Long> shelfList = productToRemove.getListShelfIn().iterator();
			while (shelfList.hasNext()) {
				Shelf shelf1 = shelfRepository1.consultById(shelfList.next());
				shelf1.setProdutoAlberga(null);

			}
			productRepository1.removeById(id);
		}

	}

	public Product consultByIdProduct(Long id) {
		return productRepository1.consultById(id);
	}

	public void editProductByID(Product product1) {
		
		
		if(productRepository1.consultById(product1.getId())!=null) {
			
			Product oldProduct =productRepository1.consultById(product1.getId()); //este é o id do produto
			
			//vai eliminar as prateleiras que tiverem respectivo este id producto 
			Iterator<Long> listShelfInProductToRemove = oldProduct.getListShelfIn().iterator();

			while (listShelfInProductToRemove.hasNext()) {
				
				shelfRepository1.consultById(listShelfInProductToRemove.next()).setProdutoAlberga(null);
				
			}
			
			
			//editar a lista das prateliras onde o produto esta
			Iterator<Long> listShelfInProduct = product1.getListShelfIn().iterator();

			Shelf shelfToAdd;

			while (listShelfInProduct.hasNext()) {
				Long idShelf=listShelfInProduct.next();
				shelfToAdd = shelfRepository1.consultById(idShelf);
				if (shelfToAdd != null && shelfToAdd.getProdutoAlberga() == null) {
					shelfToAdd.setProdutoAlberga(product1);
				} else  {
					product1.removeShelf(idShelf);
					listShelfInProduct = product1.getListShelfIn().iterator();
				}
			}


			productRepository1.editById(product1);

		}
		

	}
}
