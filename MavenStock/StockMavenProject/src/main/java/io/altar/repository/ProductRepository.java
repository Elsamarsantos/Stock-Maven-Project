package io.altar.repository;

import java.util.List;

import io.altar.model.Product;
import io.altar.model.Shelf;

public class ProductRepository extends EntityRepository<Product> {
	
	private static final ProductRepository INSTANCE = new ProductRepository();

	private ProductRepository() {}

	public static ProductRepository getInstance() {

		return INSTANCE;
	}
	protected  Class<Product> getEntityClass(){
		return Product.class;
	}
	
	protected  String getNamedQueryAll() {
		return Product.QUERYALL;
	}
	
	public List<Shelf> getListShelfInProduct (Long id){

		return  consultById(id).getListShelfIn();
	}
}
