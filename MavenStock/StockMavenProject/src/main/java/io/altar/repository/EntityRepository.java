package io.altar.repository;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import io.altar.model.BaseEntity;


public abstract class EntityRepository <T extends BaseEntity> {

	
	
	@PersistenceContext
	private EntityManager entityManager;

		
	
	public T saveId(T entity) {
		return entityManager.merge(entity);
		
	}
	
	
	public void removeById (long id) {
	
		entityManager.remove(consultById(id));
	
	}
	
	
	public T editById (T entity) {
		return entityManager.merge(entity);
	}
	
	
//	public List<T> getAll(){
//		entityManager.createNativeQuery(sqlString, resultClass)
//	}
	
	
	public T  consultById (long id) {
		
		return entityManager.find(getEntityClass(),id);
		
	}
	
	protected abstract Class<T> getEntityClass();
	
	
	

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
