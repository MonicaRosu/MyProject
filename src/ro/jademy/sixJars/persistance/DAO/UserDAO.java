package ro.jademy.sixJars.persistance.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ro.jademy.sixJars.business.entities.User;
import ro.jademy.sixJars.business.service.TransactionManager;

public class UserDAO {

	public User getUserByUsername(String nume) {

		String uname = null;
		String pass = null;
		
		Connection connect = new TransactionManager().getConnection();
		 String str= "select * from users WHERE name=?";
		
			PreparedStatement statement;
	
			try {
				statement = connect.prepareStatement(str);
				statement.setString(1, nume);
				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					uname = rs.getString("name");
					pass = rs.getString("password");
				}
			} catch (SQLException e) {
				 
				throw new RuntimeException("Cannot execute querry", e);
				
			}

			if (uname == null) {
				System.out.println("Inexistent user!");
				return null;
			}
			else {
				
				User user = new User(uname, pass);
				return user;
			}

		}
	
	public User registerUserDAO(String name, String password, String function) {
				String sql1 = "INSERT into users (name,password,function) values ('" + name + "'," + password + ",'" + function
						+ "')";
				Connection connection = new TransactionManager().getConnection();
            
				try {
					PreparedStatement ps = connection.prepareStatement(sql1);
					ps.execute();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
		
				User user = new User(name, password, function);
				return user;
			}
	
	public User changePasswordDAO(String newpassword, String nume) {
		
		String sql1 = "UPDATE users set password=" + newpassword + " WHERE name='" + nume + "'";
       User user=new User();
	
		Connection connection = new TransactionManager().getConnection();
      
		try {
			PreparedStatement ps = connection.prepareStatement(sql1);
			ps.executeUpdate();
			user.setName(nume);
			user.setPassword(newpassword);
        	return user;

            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return user;
		}
		
		
	
	
	
	}
}

	
	
	
	
	
		 
		 
		 
		 
		 
		 
	
