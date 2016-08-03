package ro.jademy.sixJars.business.service;

import ro.jademy.sixJars.business.entities.User;
import ro.jademy.sixJars.persistance.DAO.UserDAO;

public class LoginServiceTrans {

	TransactionManager transMng = new TransactionManager();

	public User doLogin(String userName, String password) {

		try {
			transMng.beginTransaction();

			UserDAO userDAO = new UserDAO();
			User user = userDAO.getUserByUsername(userName);
		

			if (user == null) {
				return null;
			}
			if (!user.getPassword().equals(password)) {
				return null;

			}

			transMng.commit();
			return user;

		} catch (Exception e) {
			e.printStackTrace();
			transMng.rollback();
			return null;

		}

	}

	public User registerUser(String username, String password, String function) {
		
		TransactionManager transMng = new TransactionManager();
		try {
			transMng.beginTransaction();
			UserDAO userDAO = new UserDAO();
			if (userDAO.getUserByUsername(username) == null) {
				User userRegister = userDAO.registerUserDAO(username, password, function);
				transMng.commit();
				return userRegister;
			} else {
				System.out.println("user existent");
				transMng.rollback();
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			transMng.rollback();
			return null;

		}

	}

	public User changePassword(String name, String newpassword) {
		
		TransactionManager transMng = new TransactionManager();
		
		try {
			transMng.beginTransaction();
			UserDAO userDAO = new UserDAO();

			if (userDAO.getUserByUsername(name) != null) {
				User user = userDAO.changePasswordDAO(newpassword, name); 
				transMng.commit();
				return user;
				
			}
			else return null;
		} catch (Exception e) {
			e.printStackTrace();
			transMng.rollback();
			return null;

		}
	}
}
	
