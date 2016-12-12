import java.util.Scanner;

public class MonVoyage {
    String [] CapitalesEuropeennes = {"Tirana","Berlin","Andorre-la-Vieille","Erevan","Vienne","Bakou","Bruxelles","Minsk","Sarajevo","Sofia","Nicosie","Zagreb","Copenhague","Madrid","Tallinn","Helsinki","Paris","Tbilissi","Athènes","Budapest","Dublin","Reykjavik","Rome","Astana","Pristina","Riga","Vaduz","Vilnius","Luxembourg","Skopje","La","Valette","Chisinau","Monaco","Podgorica","Oslo","Amsterdam","Varsovie","Lisbonne","Bucarest","Londres","Moscou","Saint-Marin","Belgrade","Bratislava","Ljubljana","Berne","Stockholm","Prague","Kiev","Vatican"};
    
    public boolean appartient (String nom) {
    	 for (int i=0;i<CapitalesEuropeennes.length;i++) {
             if (nom.toLowerCase().equals(CapitalesEuropeennes[i].toLowerCase()))
                 return true;
         }
         return false;
    }
    
    public void destination(String dest) throws CapitalCityMismatchException {
        if (!appartient(dest)) {
            throw new CapitalCityMismatchException();
        } else {
            System.out.println("Bon voyage à " + dest);
        }
    }

    /*  
      destination(String dest)  : la méthode doit lancer l'exception si dest n'est pas une capitale
    */

	public static void main(String[] args) {
			// 
	     Scanner lecture = new Scanner(System.in); 
	     System.out.print("Entrez votre destination : ");
	     String ville=lecture.next();  // lit une chaine de caractères 
	     
	     MonVoyage m = new MonVoyage();
	     try {
	    	 m.destination(ville);
	     } catch (CapitalCityMismatchException e) {
	    	 System.out.println("CapitalCityMismatchException : " + ville);
	     }
		    
	}

}