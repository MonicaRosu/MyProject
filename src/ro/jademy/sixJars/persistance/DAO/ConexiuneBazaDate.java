package ro.jademy.sixJars.persistance.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class ConexiuneBazaDate {
	
	private static final ConexiuneBazaDate oneInstance = new ConexiuneBazaDate();
	
	public  boolean  verificare(String nume,String password)  {
		boolean flag=false;
		
		try {Class.forName("com.mysql.jdbc.Driver");}
		catch(ClassNotFoundException e1){
			
			e1.printStackTrace();
			return false;
		}
		
	try (
	
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","1929");
	Statement statement =conn.createStatement();){
	ResultSet rs=statement.executeQuery("select password from users WHERE name='"+nume + "'");
	  while (rs.next()){
		String parola =rs.getString("password");
	
		if (parola.equalsIgnoreCase(password)){
			flag=true;
		}
		
	} 
	return flag;
	}
	catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
	 
	
	}

	public static ConexiuneBazaDate getOneInstance() {
		return oneInstance;
	}
	
	
	

}
	

