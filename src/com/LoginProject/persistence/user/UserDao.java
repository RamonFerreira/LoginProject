package com.LoginProject.persistence.user;

import java.util.List;

import com.LoginProject.model.user.UserBean;
import com.LoginProject.persistence.DAO;
import com.LoginProject.persistence.IGenericDAO;

public class UserDao extends DAO implements IGenericDAO {
	private static final String INSERT = "insert into tb_user values(null,?,?,?,null,null,sysdate(),?,?,sysdate(),sysdate())";
	@Override
	public void insert(Object o) throws Exception {
		// TODO Auto-generated method stub
		
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

	
	@Override
	public Object insertByObject(Object o) throws Exception {
		// TODO Auto-generated method stub
		UserBean user = (UserBean) o;
		try{
			open();
			stmt = con.prepareStatement(INSERT);
			stmt.setString(1, user.getFirstName());
			stmt.setString(2, user.getLastName());
			stmt.setString(3, user.getUserMailForContact());
			stmt.setString(4,"U");
			stmt.setInt(5,user.getLogin().getId());
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			if(rs.next()){
				user.setId(rs.getInt(1));
			}
			stmt.close();
		}catch(Exception e){
			if(!stmt.equals(null)){
				stmt.close();
			}
		}finally{
			if(user.getId().equals(null)){
				user = null;
			}
		}
		return user;
	}

}
