package Project;

import java.io.*;
import java.security.*;

public class digitalsignature {
	
	public void PrivKeySignature(){
	
	 try {  
         ObjectInputStream in = new ObjectInputStream(new FileInputStream("myprikey.dat"));  
         PrivateKey myprikey = (PrivateKey) in.readObject();  
         in.close();  
         
         // create my signature information
         String myinfo = "My signature"; 
         
         
         // use private key to create signature
         Signature signat = Signature.getInstance("DSA");  
         signat.initSign(myprikey);  
         signat.update(myinfo.getBytes());  
         // the created digital signature  
         byte[] signed = signat.sign(); 

         
         // saving my signature information and digital signature in the same file "myinfo.dat"
         ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("myinfo.dat"));  
         out.writeObject(myinfo);  
         out.writeObject(signed);  
         out.close();  
  
         
         System.out.println("successfully creating signature and saving in file ");  
     } catch (java.lang.Exception e) {  
         e.printStackTrace();  
         System.out.println("failed to create signature and save info in file");  
     }  
	}
	public void verify(){
		/*
		 * Other persons can use public key to verify the digital signature 
		 * if succeed, it means the information is sent by the user.
		 */
						 
		
	}
}
