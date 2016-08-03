package mainTest;

import ro.jademy.sixJars.business.entities.User;
import ro.jademy.sixJars.business.service.LoginServiceTrans;

public class MainTest {


	
	public static void main(String[] args) {
	
	LoginServiceTrans loginservice=new LoginServiceTrans();

   User user=loginservice.doLogin("VasilescuK","333");
   
 if (user!=null)
 
 {  System.out.println(user.getName());}

 else {
	 System.out.println("aoleu");
 }
 
//   User user1=loginservice.registerUser("VasilescuL", "333", "sales");
   
   
   

}
}

		
	


