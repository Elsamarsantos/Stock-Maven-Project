package io.altar.repository;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import io.altar.model.BaseEntity;


public abstract class EntityRepository <T extends BaseEntity> {

	
	
	@PersistenceContext
	protected EntityManager entityManager;

		
	
	public T saveId(T entity) {
		return entityManager.merge(entity);
		
	}
	
	
	public void removeById (long id) {
	
		entityManager.remove(consultById(id));
	
	}
	
	
	public T editById (T entity) {
		return entityManager.merge(entity);
	}
	
	
	
	public List<T> getAll(){
		return entityManager.createNamedQuery(getNamedQueryAll(),getEntityClass()).getResultList();
	}
	
	
	public T  consultById (long id) {
		
		return entityManager.find(getEntityClass(),id);
		
	}
	
	protected abstract Class<T> getEntityClass();
	
	protected abstract String getNamedQueryAll();
	


}
