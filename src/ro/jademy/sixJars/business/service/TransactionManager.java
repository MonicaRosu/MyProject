package ro.jademy.sixJars.business.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TransactionManager {

	private static ThreadLocal<Connection> threadL = new ThreadLocal<>();

	public void beginTransaction() {
	
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e1) {
			e1.printStackTrace();
			throw new RuntimeException("Cannot load driver", e1);
		}
		
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root",
					"1929");
			
			connection.setAutoCommit(false);
			threadL.set(connection);
		} catch (SQLException e) {
			throw new RuntimeException("Cannot connect to DB", e);
		}
	}

	public void commit() {

		try {
			threadL.get().commit();
			threadL.get().close();
			threadL.remove();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Cannot commit", e);
		}
	}

	public void rollback() {

		try {
			threadL.get().rollback();
			threadL.get().close();
			threadL.remove();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Cannot rollback", e);
		}
	}

	public Connection getConnection() {

		return threadL.get();
	}
}
