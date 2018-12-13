package io.altar.repository;

import java.util.List;

import io.altar.model.Shelf;

public class ShelfRepository extends EntityRepository<Shelf>{
	private static final ShelfRepository INSTANCE = new ShelfRepository();

	private ShelfRepository() {}

	public static ShelfRepository getInstance() {

		return INSTANCE;
	}
	protected  Class<Shelf> getEntityClass(){
		return Shelf.class;
	}
	
	protected String getNamedQueryAll() {
		return Shelf.QUERYALLSHELVES;
	}
	
	public List<Shelf> getListShelfInProduct (Long id){
		
		return entityManager.createNamedQuery(Shelf.QUERYALLSHELVESBYIDPRODUCT, Shelf.class).setParameter("id", id).getResultList();
	}
	
	

}
