import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.security.PublicKey;
import java.security.Signature;

public class DSAVerify {     ////verify the digital signature
	String signedinfo=null;
	public void verify(){
		try {
			//load the public key and the digital signature file
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("mypubkey.dat"));
			PublicKey pubkey = (PublicKey) in.readObject();
			in.close();
			
			in = new ObjectInputStream(new FileInputStream("mysignature.dat"));
			String info = (String) in.readObject();
			byte[] signed = (byte[]) in.readObject();
			in.close();
			//use "DSA" algorithm to check if the key is true 
			Signature signetcheck = Signature.getInstance("DSA");
			signetcheck.initVerify(pubkey);
			signetcheck.update(info.getBytes());
			if (signetcheck.verify(signed)) {
				System.out.println("signed information = " + info);
				System.out.println("verification successful");
				signedinfo = info;
			} else
				System.out.println("verification failed");
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		};
	}
	public String getInfo(){
		return signedinfo;
	}
}
