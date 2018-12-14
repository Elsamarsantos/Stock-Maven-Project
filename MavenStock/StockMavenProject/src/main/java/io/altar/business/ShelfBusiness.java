package io.altar.business;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import io.altar.dto.ProductDto;
import io.altar.dto.ShelfDto;
import io.altar.model.Product;
import io.altar.model.Shelf;

import io.altar.repository.ShelfRepository;

public class ShelfBusiness {
	@Inject
	private ShelfRepository shelfRepository1;
	
	//@Inject
	//private  ProductRepository productRepository1;
	

	@Transactional
	public void createShelf1(Shelf shelf1) {

		shelfRepository1.saveId(shelf1);
	}

			

	@Transactional
	public List <ShelfDto> consultAllShelf(){
		
		
		List<Shelf> shelfList =  shelfRepository1.getAll() ;

		List<ShelfDto> shelfDtoList = new ArrayList();

		for(Shelf shelf1: shelfList) {

			if (shelf1.getProdutoAlberga()!= null) {
				shelfDtoList.add(new ShelfDto(shelf1.getId(),shelf1.getCapacidade(),shelf1.getProdutoAlberga().getId(),shelf1.getPrecoAluguer()));
			}
			else {
				shelfDtoList.add(new ShelfDto(shelf1.getId(),shelf1.getCapacidade(),shelf1.getPrecoAluguer()));
			}
		}

		return shelfDtoList;
	}
	
	@Transactional
	public List <ShelfDto> consultAllShelfByIdProduct(Long id){
		
		
		List<Shelf> shelfList =  shelfRepository1.getListShelfInProduct(id) ;
		
		List<ShelfDto> shelfDtoList = new ArrayList();
		
		for(Shelf shelf1: shelfList) {
			if (shelf1.getProdutoAlberga()!= null) {
				shelfDtoList.add(new ShelfDto(shelf1.getId(),shelf1.getCapacidade(),shelf1.getProdutoAlberga().getId(),shelf1.getPrecoAluguer()));
			}
			else {
				shelfDtoList.add(new ShelfDto(shelf1.getId(),shelf1.getCapacidade(),shelf1.getPrecoAluguer()));
			}	
		}
		

		return shelfDtoList ;
		
	}
	
	
	
	@Transactional
	public void toRemoveShelf(Long id) {
		
			shelfRepository1.removeById(id);
		
	}
	
	@Transactional
	public ShelfDto consultShelf(Long id) {
		
		Product product1 = shelfRepository1.consultById(id).getProdutoAlberga();
		
		ProductDto productDto = new ProductDto(product1.getId(),product1.getValorDesconto(),product1.getPvp(),product1.getPvp());
		Shelf shelf1=shelfRepository1.consultById(id);
		
		ShelfDto shelfDto= new ShelfDto(shelf1.getId(),shelf1.getCapacidade(),productDto.getId(),shelf1.getPrecoAluguer());

		return shelfDto;

	}
	
	@Transactional
	public void updateShelf(Shelf shelf1) {
		
		
		Product product1 = shelfRepository1.consultById(shelf1.getId()).getProdutoAlberga();		
		product1.addToListShelves(shelf1);  //vai colocar a prateleira na lista deste produto
		shelfRepository1.editById(shelf1);
		
	}
	
	
	
	
}