package com.dxc.DAO;

import java.util.List;

public interface DAO<E>{
	
	boolean update(E e);
	boolean insert(E e);
	boolean delete(int id);
	E find(int id);
	List<E> findAll();	

}
