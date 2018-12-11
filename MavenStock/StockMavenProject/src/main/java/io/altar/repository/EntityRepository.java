package io.altar.repository;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import io.altar.model.BaseEntity;


public class EntityRepository <T extends BaseEntity> {
	
	//private Map <Long,T> mapa = new LinkedHashMap<Long, T>(); ja nao e necessario no jpa
	
	
	@PersistenceContext
	private EntityManager entityManager;

	//criar novo id		
	//long novoId=0;	
	
	public T saveId(T entity) {
		return entityManager.merge(entity);
		
	}
	
	
//	public void removeById (long id) {
//	
//		entityManager.remove(entity);
//	}
//	
	
	public T editById (T entity) {
		return entityManager.merge(entity);
	}
	
	
//	public List<T> getAll(){
//		
//	}
//	public T consultById (long id) {
//		
//	}
	
	
//	public void saveId(T newId) {
//		newId.setId(novoId);
//		mapa.put(newId.getId(), newId);
//		novoId++;
//	}
//	
//	
//consultar todas as entidade	
//	public  Collection<T> consultAll() {
//		return mapa.values();
//		
//	}
//	
//	
////consultar atraves do ID	
//	public  T consultById(Long id) {
//	
//		return mapa.get(id);
//	}
//	
//// editar entidade
//	public void editById(T prodOrShel) {
//		mapa.replace(prodOrShel.getId(), prodOrShel);
//
//	}
//	
////remover entidades
//	public void removeById(long id) {
//		mapa.remove(id);
//		
//	}
//	
//	public Map<Long, T> getMap() {
//		return mapa;
//	}
//	
//	
}
