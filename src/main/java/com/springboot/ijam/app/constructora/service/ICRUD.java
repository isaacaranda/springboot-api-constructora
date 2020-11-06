package com.springboot.ijam.app.constructora.service;

import java.util.List;

public interface ICRUD<T> {
	T save(T obj);
	T update(T obj);
	List<T> all();
	T findById(Integer id);
	boolean deleteById(Integer id);
}
