package com.LoginProject.persistence.system;

import java.util.Date;
import java.util.List;

import com.LoginProject.model.system.LoginBean;
import com.LoginProject.persistence.DAO;
import com.LoginProject.persistence.IGenericDAO;

public class LoginDAO extends DAO implements IGenericDAO{
	private static final String INSERT = "INSERT INTO tb_login(id, username, usermail, password, keySecurity, registrationdate, updatedate)"+
										 "values(null,?,?,sha1(?),sha1(?),sysdate(),sysdate())";
	private static final String IS_LOGIN  = "SELECT COUNT(1) as cont FROM tb_login where usermail=?";
	
	@Override
	public void insert(Object o) throws Exception {
		LoginBean login = (LoginBean) o;
		try{
			open();
			    stmt = con.prepareStatement(INSERT);
				stmt.setString(1, login.getUserName());
				stmt.setString(2, login.getUserMail());
				stmt.setString(3, login.getPassword());
				stmt.setString(4, login.getPassword()+login.getUserMail()+login.getUserName()+new Date().toString());
				stmt.executeUpdate();
				stmt.close();
		}catch(Exception e){
			stmt.close();
			throw e;
			
		}finally{
			close();
		}
		
	}
	
	@Override
	public Object insertByObject(Object o) throws Exception {
		LoginBean login = (LoginBean) o;
		
		try{
			if(!isEmail(login.getUserMail())){
				open();
				    stmt = con.prepareStatement(INSERT);
					stmt.setString(1, login.getUserName());
					stmt.setString(2, login.getUserMail());
					stmt.setString(3, login.getPassword());
					stmt.setString(4, login.getPassword()+login.getUserMail()+login.getUserName()+new Date().toString());
					stmt.executeUpdate();
					rs = stmt.getGeneratedKeys();
					if (rs.next()){
					    login.setId(rs.getInt(1));
					}
					stmt.close();
			 }
		}catch(Exception e){
			if(stmt!=null){
				stmt.close();
			}
			throw e;
			
		}finally{
			close();
			if(login.getId().equals(null)){
				login = null;
			}
			
		}
		return login;
	}
	
	public boolean isEmail(String email){
		Boolean retrn = Boolean.TRUE;
		try{
			open();
				stmt = con.prepareStatement(IS_LOGIN);
				stmt.setString(1, email);
				rs = stmt.executeQuery();
				if(rs.next()){
					if(rs.getInt("cont")==0){
						 retrn = Boolean.FALSE;
					}
				}
			close();
		}catch(Exception e){
			
		}finally{
			
		}
		return retrn; 
	}
	@Override
	public void update(Object o) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<?> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object find(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	
}
