package com.myexperiments.ward;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public class JpaRepository<T, ID> implements AutoCloseable {
	private final Class<T> typeParameterClass;
	protected EntityManager entityManager;

	public JpaRepository(Class<T> typeParameterClass) {
		JpaEntityManager dbEntityManager = new JpaEntityManager();
		entityManager = dbEntityManager.getEntityManager();
		this.typeParameterClass = typeParameterClass;
	}

	/**
	 * Save an entity.
	 * 
	 * @param entity
	 * @return the saved entity
	 * 
	 *         public <S extends T> S save(S entity) {
	 *         entityManager.getTransaction().begin();
	 *         entityManager.persist(entity);
	 *         entityManager.getTransaction().commit(); return entity; }
	 * 
	 *         /** merge an entity.
	 *
	 * @param entity
	 * @return the saved entity
	 */
	public <S extends T> S merge(S entity) {
		entityManager.getTransaction().begin();
		entityManager.merge(entity);
		entityManager.getTransaction().commit();
		return entity;
	}

	/**
	 * Delete an entity
	 * 
	 * @param id
	 */
	public void delete(ID id) {
		entityManager.remove(id);
	}

	/**
	 * Returns a reference to the entity with the given identifier.
	 * 
	 * @param id
	 * @return
	 */
	public T findById(ID id) {
		T t = entityManager.find(typeParameterClass, id);
		return t;
	}

	/**
	 * get single result
	 * 
	 * @param q
	 * @return
	 */
	public Optional<T> getSingleResult(CriteriaQuery<T> q) {
		/*
		 * try {
		 * 
		 * return Optional.ofNullable(entityManager.createQuery(q).getSingleResult()); }
		 * catch (RuntimeException e) { return Optional.empty(); }
		 */
		return Optional.empty();
	}

	/**
	 * get single result
	 * 
	 * @param q
	 * @return
	 */
	public Optional<List<T>> getResultList(CriteriaQuery<T> q) {
		/*
		 * try { return
		 * Optional.ofNullable(entityManager.createQuery(q).getResultList()); } catch
		 * (RuntimeException e) { return Optional.empty(); }
		 */
		return Optional.empty();
	}

	/**
	 * used to close entity manager obj
	 */
	public void close() {
		entityManager.clear();
		entityManager.close();
	}

}