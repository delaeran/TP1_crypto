package tp2;

import java.math.BigInteger;
import java.util.Random;

public class testBigInt {

	public static void main(String[] args) {
		
		gencle("rien",1024);
	
	}
	
	
	public static void gencle(String nomcles,int size){
		BigInteger p = new BigInteger(2+(size/2),new Random()); // minimum size/2 maximum size/2 +16 en bits
		p = p.nextProbablePrime();
		while (p.bitLength()<(size/2))
			{
			p = new BigInteger(8+(size/2),new Random()); 
			p = p.nextProbablePrime();
			}
		System.out.println(p);
		BigInteger q = new BigInteger(8+(size/2),new Random());
		q= q.nextProbablePrime();
		while (q.bitLength()<(size/2))
			{
			q = new BigInteger(8+(size/2),new Random()); 
			q = q.nextProbablePrime();
			}

		BigInteger n = p.multiply(q);
		System.out.println("taille n = "+n.bitLength());

		
		// p,q premier (cachés)
		// n = p x q  (public)
		// fi(n) (p-1)(q-1)
		//
		// b = aléatoire entre 1 < b < fi(n)
		// choisir a tel que ab = 1( modulo fi(n))
		//					a = b puissance -1 (modulo fi(n))
		// pour que cela marche, il faut 
		// que PGCD (b,fi(n))=1
		
		// créer fichier de clé nom.pub
		// créer fichier de clé nom.priv
	}
	
	public static void chiffre(String nomclepub)
	{
		// chiffre le message sur l'entrée standard pour le
		// destinataire de de clé nom.pub
		// sortie du message sur la sortie standard
	}
}
