import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
public class DSAGenerate {   //generate the digital signature
	public void generate(String information) {
		//if there is no key pair in local file,create it
		if ((new java.io.File("myprikey.dat")).exists() == false) {
			if (generatekey() == false) {
				return;
			}
		}
		
		// load private key from local file and do the digital signature save as mysignature.dat	
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("myprikey.dat"));
			PrivateKey myprikey = (PrivateKey) in.readObject();
			in.close();
			String myinfo = information; // get the information to sign
			// use private key to generate digital signature
			Signature signet = Signature.getInstance("DSA");
			signet.initSign(myprikey);
			signet.update(myinfo.getBytes());
			byte[] signed = signet.sign(); // sign for information
			System.out.println("signed( "+ myinfo +" )=" + byte2hex(signed));
			// save the information and signature into a single file
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("mysignature.dat"));
			out.writeObject(myinfo);
			out.writeObject(signed);
			out.close();
			System.out.println("signature generated successfully");
		} catch (java.lang.Exception e) {
			e.printStackTrace();
			System.out.println("fail to generate digital signature");
		}

	}
	
	
	//generate a pair of keys(public key and private key) using "DSA" algorithm.
	public boolean generatekey() {
		try {
			KeyPairGenerator keygen = KeyPairGenerator.getInstance("DSA");
					//create keypair generator
			keygen.initialize(512);
					//initialize the generator
			KeyPair keys = keygen.genKeyPair();
			PublicKey pubkey = keys.getPublic();
					//get the public key which could be sent to others
			PrivateKey prikey = keys.getPrivate();
					//get the private key which should be saved as local file
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("myprikey.dat"));
			out.writeObject(prikey);
			out.close();
			System.out.println("prikeys successfully written in");
			out = new ObjectOutputStream(new FileOutputStream("mypubkey.dat"));
			out.writeObject(pubkey);
			out.close();
			System.out.println("pubkeys successfully written in");
			System.out.println("keypair successfully written in");
			return true;
		} catch (java.lang.Exception e) {
			e.printStackTrace();
			System.out.println("keypair written failed");
			return false;
		}
	}
	public String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
			if (n < b.length - 1)
				hs = hs + ":";
		}
		return hs.toUpperCase();
	}
}