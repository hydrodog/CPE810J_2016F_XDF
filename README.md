# CPE810J_2016F_XDF_DigitalSignature
The group is working on digital signature.The demo is the DSA/src/DSATest.java.

The project included:

1.generate the public key and private key.

2.generate the signature by the Digital Signature Algorithm using the private key.

3.verify the signature using the public key.

The program will generate a key pair for the user first.If the user has already had the key pair,it can be skipped.The key pair consists of a public key and a private key.The private will be saved as a local file which can be used to generate digital signature.The public key will be sent to others with the signature as people can use public key to verify signature.Then the user can type information on the panel,it will be signed by using Digital Signature Algorithm('DSA') and generate the file myinfo.dat.

The receiver will get the public key and the file myinfo.After clicking the button 'Verify Signature',the signed information will be shown on the panel.If the public key is wrong or the information has been changed,the program will show 'verification failed'.

Some of the methods are imported from java.security.

Group member:
Fulong Wang,Xincan Wang,Yicong Wang
