package tp2;

import java.math.BigInteger;
import java.util.Random;

public class testBigInt {

	public static void main(String[] args) {
		
		gencle(1024);
	
	}
	
	
	public static void gencle(int size){
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

	}
}
