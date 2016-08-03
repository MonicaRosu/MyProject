package ro.jademy.sixJars.business.service;



import ro.jademy.sixJars.persistance.DAO.ConexiuneBazaDate;




public class UserService {
	
	private static final UserService soleInstance = new UserService();
	ConexiuneBazaDate conexiuneBazaDate;
	
	
 public boolean autentificare(String username,String password ) {
	 
	 return ConexiuneBazaDate.getOneInstance().verificare(username, password);
	 
 }

public static UserService getSoleinstance() {
	return soleInstance;
}

}
 





 


 
	
	
	
	

	
	
	
	
	
	
				
	


