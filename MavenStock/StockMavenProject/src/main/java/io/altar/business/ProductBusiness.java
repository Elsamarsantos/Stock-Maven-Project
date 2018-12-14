package io.altar.business;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import io.altar.dto.ProductDto;
import io.altar.dto.ShelfDto;
import io.altar.model.Product;
import io.altar.model.Shelf;
import io.altar.repository.ProductRepository;
import io.altar.repository.ShelfRepository;


public class ProductBusiness {
	@Inject
	private ProductRepository productRepository1;
	
	@Inject
	private ShelfRepository shelfRepository1;
	
	
	@Transactional
	public void createProduct1(Product product1) {
		Iterator<Shelf> listShelfInProduct = product1.getListShelfIn().iterator();

		Shelf shelfToAdd;

		while (listShelfInProduct.hasNext()) {
			Shelf shelf1=listShelfInProduct.next();
			shelfToAdd = shelfRepository1.consultById(shelf1.getId());
			if (shelfToAdd != null && shelfToAdd.getProdutoAlberga() == null) {
				shelfToAdd.setProdutoAlberga(product1);
			} else  {
				product1.removeShelf(shelf1);
				listShelfInProduct = product1.getListShelfIn().iterator();
			}
		}

		productRepository1.saveId(product1);
	}

	
	@Transactional
	public ProductDto consultProduct(Long id) {
		
		Product product1= productRepository1.consultById(id);
		ProductDto productDto = new ProductDto(product1.getId(),product1.getValorDesconto(),product1.getIva(),product1.getPvp());
		return productDto;
	}

	
	@Transactional
	public void removeProduct(Long id) {


			productRepository1.removeById(id);
		}

	
	@Transactional
	public void updateProduct(Product product1) {
		Product oldProduct =productRepository1.consultById(product1.getId()); //este e o id do produto
		Iterator<Shelf> listShelfInProductToRemove = oldProduct.getListShelfIn().iterator();

		while (listShelfInProductToRemove.hasNext()) {
			shelfRepository1.consultById(listShelfInProductToRemove.next().getId()).setProdutoAlberga(null);
			
			Iterator<Shelf> listShelfInProduct = product1.getListShelfIn().iterator();
			Shelf shelfToAdd;

			while (listShelfInProduct.hasNext()) {
				Shelf shelf1=listShelfInProduct.next();
				shelfToAdd = shelfRepository1.consultById(shelf1.getId());
				if (shelfToAdd != null && shelfToAdd.getProdutoAlberga() == null) {
					shelfToAdd.setProdutoAlberga(product1);
				} else  {
					product1.removeShelf(shelf1);
					listShelfInProduct = product1.getListShelfIn().iterator();
				}
			}


			productRepository1.editById(product1);
		}

	

	}
	
	
	@Transactional
	public List<ProductDto> consultAllProduct(){
		
		List<Product> productList = productRepository1.getAll();
		
		List<ProductDto> productDtoList = new ArrayList();
		
		for(Product product1: productList) {
			productDtoList.add(new ProductDto(product1.getId(),product1.getValorDesconto(),product1.getIva(),product1.getPvp()));
		}
		

		return productDtoList ;
	}
	
	@Transactional
	public List<ShelfDto> consultShelfInProduct(Long id){

		List<Shelf> shelfList =  productRepository1.getListShelfInProduct(id);
		
		List<ShelfDto> shelfDtoList = new ArrayList();
		
		for(Shelf shelf1: shelfList) {
			
			shelfDtoList.add(new ShelfDto(shelf1.getId(),shelf1.getCapacidade(),shelf1.getProdutoAlberga().getId(),shelf1.getPrecoAluguer()));
		}
		

		return shelfDtoList ;
	}

	





	
}
