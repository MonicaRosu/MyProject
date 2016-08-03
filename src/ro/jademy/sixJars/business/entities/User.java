package ro.jademy.sixJars.business.entities;

public class User {
	
	private String name;
	private String password;
	private String function;
	
	
	public  User() { }
	
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public String getFunction() {
		return function;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setFunction(String function) {
		this.function = function;
	}

	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public User(String name, String password, String function) {
		super();
		this.name = name;
		this.password = password;
		this.function = function;
	}
	
	
	
	

}
