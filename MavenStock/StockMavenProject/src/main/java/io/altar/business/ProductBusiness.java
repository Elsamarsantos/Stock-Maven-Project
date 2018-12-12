package io.altar.business;



import javax.inject.Inject;
import javax.transaction.Transactional;

import io.altar.dto.ProductDto;

import io.altar.model.Product;

import io.altar.repository.ProductRepository;


public class ProductBusiness {
	@Inject
	private ProductRepository productRepository1;
	

	
	@Transactional
	public void createProduct1(Product product1) {

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


			productRepository1.editById(product1);
		}

	

	
	
//	public List <ProductDto> consultAllProduct() {
//		
//		Collection<Product> allProducts = productRepository1.consultAll();
//		
//		
//		List <ProductDto> allProductsDto = new ArrayList();
//		
//		for(Product product1: allProducts ) {
//			
//			ProductDto productDto = new ProductDto(product1.getId(),product1.getValorDesconto(),product1.getIva(),product1.getPvp());
//			allProductsDto.add(productDto);
//		}
//		
//		
//		return allProductsDto;
//				
//	
//		
//	}
//	
	



//
//	public void editProductByID(Product product1) {
//
//
//		if(productRepository1.consultById(product1.getId())!=null) {
//
//			Product oldProduct =productRepository1.consultById(product1.getId()); //este � o id do produto
//
//			//vai eliminar as prateleiras que tiverem respectivo este id producto 
//			Iterator<Shelf> listShelfInProductToRemove = oldProduct.getListShelfIn().iterator();
//
//			while (listShelfInProductToRemove.hasNext()) {
//
//				shelfRepository1.consultById(listShelfInProductToRemove.next().getId()).setProdutoAlberga(null);
//
//			}
//
//
//			//editar a lista das prateliras onde o produto esta
//			Iterator<Shelf> listShelfInProduct = product1.getListShelfIn().iterator();
//
//			Shelf shelfToAdd;
//
//			while (listShelfInProduct.hasNext()) {
//				Shelf shelf1=listShelfInProduct.next();
//				shelfToAdd = shelfRepository1.consultById(shelf1.getId());
//				if (shelfToAdd != null && shelfToAdd.getProdutoAlberga() == null) {
//					shelfToAdd.setProdutoAlberga(product1);
//				} else  {
//					product1.removeShelf(shelf1);
//					listShelfInProduct = product1.getListShelfIn().iterator();
//				}
//			}
//			productRepository1.editById(product1);
//		}
//	}
//	
//	public List<ShelfDto> listShelfInProduct(Long id){
//
//		Product product1 = productRepository1.consultById(id);
//
//		List<Shelf> listShelfInProduct = product1.getListShelfIn();
//
//
//		List<ShelfDto> lst = new ArrayList();
//
//		for(Shelf shelf1:listShelfInProduct) {
//			
//			lst.add(new ShelfDto(shelf1.getId(),shelf1.getCapacidade(),shelf1.getPrecoAluguer()));
//
//
//		}
//
//		return lst;
//
//
//		
		
	//}
	
	
}
