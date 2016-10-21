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
		
		// p,q premier (cachï¿½s)
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
	
	public static void chiffre(String nomclepub)
	{
		// chiffre le message sur l'entrï¿½e standard pour le
		// destinataire de de cle nom.pub
		// sortie du message sur la sortie standard
	}
	
	public static void dechiffre(String nomclepriv)
	{
		// déchiffre avec le fichier nom.priv
		// sort le message sur la sortie standard.
		
	}
	
	public static void signe(String nom)
	{
		// signe un message et en sort la signature avec nom.priv
	}

	public static void verifie(String nom)
	{
		// févirie fichier signature avec nom.pub
	}
}
