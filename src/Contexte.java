import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Contexte {
	int N; 					//nombre de mots
	int mot_taille_min;
	int mot_taille_max;
	int N_taille[];
	int nb_lettre;
	char lettres;

	
public static String hashmd5(String password, byte[] condense ) // hachage
{
	byte[] uniqueKey = password.getBytes();
    byte[] hash      = null;

    try
    {
        hash = MessageDigest.getInstance("MD5").digest(uniqueKey);
    }
    catch (NoSuchAlgorithmException e)
    {
        throw new Error("No MD5 support in this VM.");
    }

    StringBuilder hashString = new StringBuilder();
    for (int i = 0; i < hash.length; i++)
    {
        String hex = Integer.toHexString(hash[i]);
        if (hex.length() == 1)
        {
            hashString.append('0');
            hashString.append(hex.charAt(hex.length() - 1));
        }
        else
            hashString.append(hex.substring(hex.length() - 2));
        
    }
    return hashString.toString();
}


public int h2i(int t, byte[] condense) // hash vers indice
{
	return t;
}

public String i2c(int idx,String c) //index vers mot en clair
{
	return c;
}

public int i2i(int idx) // return l'index 'suivant' � partir d'un index (condense fonction pr�c�dentes
{

	int indexsuiv = 0;
	return indexsuiv;
}

public int randIndex()
{
	int rand = 0;
	return rand;
}


}
