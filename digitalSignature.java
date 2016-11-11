/*
 * FULONG WANG
 *This class is trying to generate a pair of keys(public key and private key) using "DSA" algorithm.
 *And then the pair of keys can be attached with the object to create signature.
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
public class digitalSignature {
	public boolean generatekey() {        //generate the public key and private key
		try {
			KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance("DSA");
				//create keypair generator
			keyGenerator.initialize(1024,new SecureRandom());
				//initialize the generator
			KeyPair keys = keyGenerator.genKeyPair();
			PublicKey pubkey = keys.getPublic();
				//get the public key
			PrivateKey prikey = keys.getPrivate();
				//get the private key
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
	public void getSigContent(){      //get the content need to be signed 
	}
	public void digSignature(){      //attached the key pair onto the content
		
	}
}
