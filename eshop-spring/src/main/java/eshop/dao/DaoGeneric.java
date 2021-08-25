package eshop.dao;

import java.util.List;

public interface DaoGeneric<T, K> {
	public T findById(K id);

	public List<T> findAll();

	public void insert(T o);

	public T update(T o);

	public void deleteByKey(K id);

	public void delete(T o);
}
