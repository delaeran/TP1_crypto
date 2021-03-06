package tp2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;

public class testBigInt {

	public static void main(String[] args) {
		
		gencle("rien",32);
	//	chiffre("rien");

		BigInteger[] test = string_to_ascii(" ABCZ",0);
		int i = 0;
		System.out.println(test.length);
		while (i<test.length)
		{
			System.out.println(test[i]);
			i++;
		}
		String text1 = "TEST";
		System.out.println("Plaintext: " + text1);
	    BigInteger plaintext = new BigInteger(text1.getBytes());
	    
		BigInteger texte_chiffrer=chiffre("rien",plaintext);
		System.out.println("cyphertext "+texte_chiffrer);
		plaintext=dechiffre("rien",texte_chiffrer);
		
		String text2= new String(plaintext.toByteArray());
		 System.out.println("Plaintext: " + text2);
		
	}
	
	
	public static void gencle(String nomcles,int size){
		BigInteger p = new BigInteger(2+(size/2),new Random()); // minimum size/2 maximum size/2 +16 en bits
		p = p.nextProbablePrime();
		while (p.bitLength()<(size/2))
			{
			p = new BigInteger(8+(size/2),new Random()); 
			p = p.nextProbablePrime();
			}
		//System.out.println(p);
		BigInteger q = new BigInteger(8+(size/2),new Random());
		q= q.nextProbablePrime();
		while (q.bitLength()<(size/2))
			{
			q = new BigInteger(8+(size/2),new Random()); 
			q = q.nextProbablePrime();
			}

		BigInteger n = p.multiply(q);
		
		BigInteger i= BigInteger.valueOf(1);
		BigInteger b= BigInteger.valueOf(65537);
		System.out.println(n);
		System.out.println("taille n = "+n.bitLength());
		BigInteger phi_n=p.subtract(i).multiply(q.subtract(i));
		BigInteger pgcd_b_phi= b.gcd(phi_n);
		System.out.println(phi_n);
		System.out.println(pgcd_b_phi);
		
		BigInteger a=b.modInverse(phi_n);
		System.out.println(a);
		

		String contentpriv = size + " " + n + " " + p + " " + q + " " + a + " " + b;
		String contentpub = size + " " + n + " " + b;
		
		try {
		
			File fpriv = new File(nomcles+".priv");
			FileWriter fwpriv = new FileWriter(fpriv.getAbsoluteFile());
			BufferedWriter bwpriv = new BufferedWriter(fwpriv); 

			bwpriv.write(contentpriv);
			bwpriv.close();
			
			// .pub d�j� pris par microsoft publisher
			File fpub = new File(nomcles+".publ");
			FileWriter fwpub = new FileWriter(fpub.getAbsoluteFile());
			BufferedWriter bwpub = new BufferedWriter(fwpub);
		
			bwpub.write(contentpub);
			bwpub.close();

		
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

		// p,q premier (cache)
		// n = p x q  (public)
		// fi(n) (p-1)(q-1)
		//
		// b = aleatoire entre 1 < b < fi(n)
		// choisir a tel que ab = 1( modulo fi(n))
		//					a = b puissance -1 (modulo fi(n))
		// pour que cela marche, il faut 
		// que PGCD (b,fi(n))=1
		
		// creer fichier de cle nom.pub
		// creer fichier de cle nom.priv
	}
	
	
	
	public static BigInteger chiffre(String nomclepub,BigInteger message)
	{
		// obtention du n et du b du fichier .publ
		File file = new File(nomclepub+".publ");
		BigInteger n = null;
		BigInteger b = null;
		if(file.exists())
		{
			BufferedReader reader = null;
			try {
			    reader = new BufferedReader(new FileReader(file));
			    String text = reader.readLine();
		    	String[] clepublique = text.split(" ");
		    	BigInteger size = new BigInteger(clepublique[0]);
		        BigInteger cle_n = new BigInteger(clepublique[1]);
		        BigInteger cle_b = new BigInteger(clepublique[2]);
		        n=cle_n;
		        b=cle_b;
			} catch (IOException e) {
			    e.printStackTrace();
			}
			
		}
		 
		//return(new BigInteger(message.getBytes())).modPow(b, n).toString();
		return message.modPow(b, n);
		// chiffre le message sur l'entr�e standard pour le
		// destinataire de de cle nom.pub
		// sortie du message sur la sortie standard
	}
	
	
	public static BigInteger[] string_to_ascii(String text_to_convert,int size)
	{
		int stringsize = text_to_convert.length();
		int actuel = 0;
		BigInteger[] tab = new BigInteger[stringsize];
		while(actuel<stringsize)
		{
			char c = text_to_convert.charAt(actuel);
			int ascii_c = (int)c;
			tab[actuel]= BigInteger.valueOf(ascii_c);
			actuel++;
		}
		return tab;
	}
	
	
	
	
	
	
	public static BigInteger dechiffre(String nomclepriv,BigInteger message)
	{
	// obtention du n et du a du fichier .publ
		File file = new File(nomclepriv+".priv");
		BigInteger n = null;
		BigInteger a = null;
		if(file.exists())
			{
			BufferedReader reader = null;
			try {
			    reader = new BufferedReader(new FileReader(file));
			    String text = reader.readLine();
		    	String[] cleprive = text.split(" ");
		    	BigInteger size = new BigInteger(cleprive[0]);
		        BigInteger cle_n = new BigInteger(cleprive[1]);
		        BigInteger cle_a = new BigInteger(cleprive[3]);
		        n=cle_n;
		        a=cle_a;
				} 
			catch (IOException e) {
			    e.printStackTrace();
				}
				
			}
	
		    //return new String((new BigInteger(message)).modPow(a, n).toByteArray());
		    return message.modPow(a, n);
		// clair = crypt^^a mod n
			
			// d�chiffre avec le fichier nom.priv
			// sort le message sur la sortie standard.
	}
	
	public static void signe(String nom)
	{
		// signe un message et en sort la signature avec nom.priv
	}

	public static void verifie(String nom)
	{
		// f�virie fichier signature avec nom.pub
	}
}
