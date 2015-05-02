package com.LoginProject.persistence;

import java.util.List;

public interface IGenericDAO {
	
	public abstract void insert(Object o)throws Exception;
	public abstract void update(Object o)throws Exception;
	public abstract void delete(Integer id)throws Exception;
	public abstract List<?> findAll()throws Exception;
	public abstract Object find(Integer id)throws Exception;
	public Object insertByObject(Object o) throws Exception;
	

}
