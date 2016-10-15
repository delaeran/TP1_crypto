import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Contexte {
	int N; 					//nombre de mots
	int mot_taille_min;
	int mot_taille_max;
	int N_taille[];
	int nb_lettre;
	char lettres;

	public static void main(String[] args) {
		String test = hashmd5("aabbo");
		System.out.println("aabbo");
		System.out.println(test);
		
	}

	
public static String hashmd5(String password ) // hachage
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
	int indice = 0;
	//prendre les 8 premiers octets du tableau.
	//rajouter t 
	// faire mod N (voir sujet)
	return indice; // retourne l'indice
	
}

public String i2c(int idx,int taille) //index vers mot en clair
{
	String result = null;
	char tableauCaractere[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	//tableau de lettre d'alphabets.
	int idxactuel = idx;
	for(int i = 1; i < taille; i++)
	{
		if(i ==taille)
		{
			int dividx = (int) Math.floor(idxactuel/26);
			result=tableauCaractere[dividx-1]+result;
		}
		else{
			int modidx = idxactuel%26;
			result=tableauCaractere[modidx-1]+result;
			idxactuel = (int) Math.floor(idxactuel/26);
			
		}
	}
	return result;
}

public int i2i(int idx) // return l'index 'suivant' a partir d'un index (condense fonction precedente)
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
