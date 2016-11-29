import java.util.Scanner;


public class Polynome {
		private static final  int TAILLEMIN = 10; 
		private int nbMonomes;
		protected Monome [] tab; 
		
		public Polynome () {
			this (TAILLEMIN);
		}

	 public Polynome (int n){
             tab = new Monome[n]; 
             nbMonomes=0;
	 }
	 
	 public int getTaillemin() {
		 return TAILLEMIN;
	 }
	 
	 public int getNbMonomes() {
		 return nbMonomes;
	 }
	 
        
		private int recherchePosition (Monome m) {
			if (m.getExposant()<tab.length) return m.getExposant();
			return -1;
		}


		private void agrandirTab () {
		    int size = tab.length;
	        tab = new Monome[size + TAILLEMIN];
		}
        
		public void ajouterMonome (Monome m) {
			int position = recherchePosition(m);
			if (position >= 0 ) {
				// sauvegarder le Monome 
				if (tab[position]==null) { 
					tab[position]=m;
					nbMonomes++;
				} else {
					double coef = m.getCoefficient()+tab[position].getCoefficient();
					if (coef == 0.0) {
						if (position>0){
							  tab[position]=null;
							  nbMonomes--;
						} else tab[0].setCoefficient(0.0);
						if (nbMonomes==0) {
							   tab[0]=new Monome(0,0); 
							   nbMonomes++;
						}
					} else {
						tab[position].setCoefficient(coef);
					}
				}
			}
			
		}
        
		public void ajouterMonome (double coef, int deg) {
			Monome m = new Monome (coef,deg);
			ajouterMonome(m);			
		}
       
		public void lirePolynome (){
	        int next = 1;
	        while (next == 1) {
	            Scanner sc1 = new Scanner(System.in);
	            System.out.println("Coef :");
	            int coef = Integer.parseInt(sc1.nextLine());
	            Scanner sc2 = new Scanner(System.in);
	            System.out.println("Exposant :");
	            int deg = Integer.parseInt(sc2.nextLine());
	            ajouterMonome(coef, deg);

	            Scanner sc = new Scanner(System.in);
	            System.out.println("Voulez vous ajouter un monome (1/0) :");
	            next = Integer.parseInt(sc.nextLine());
	        }
			
		}
        /**
         * additionDansPolynome  
         *  @return le polynome dupliqué
         */
	private void additionDansPolynome (Polynome p) {
           // A FAIRE            
	}
     

		private Polynome dupliquerPolynome () {
			Polynome res = new Polynome(tab.length);
			int i = 0, nbMonomesCopies = 0; 
			while (i<tab.length && nbMonomesCopies<nbMonomes) {
				if (tab[i]!=null) {
					res.tab[i]=new Monome(tab[i].getCoefficient(),tab[i].getExposant());
					nbMonomesCopies++;
				}
				i++;
			}
			return res;
		}
		
		private Polynome multiplierParMonome (Monome m) {
	        System.out.println("Multiplication par monome...");
	        Polynome res = new Polynome();
	        int i = 0;
	        while (i < tab.length) {
	            if (tab[i] != null) {
	                double coef = tab[i].getCoefficient() * m.getCoefficient();
	                int exp = tab[i].getExposant() + m.getExposant();
	                res.ajouterMonome(new Monome(coef, exp));
	            }
	            i++;
	        }
	        return res;
		}
       
		public Polynome additionPolynome (Polynome p) {
	        System.out.println("Addition de polynome...");
	        Polynome res = new Polynome(tab.length);
	        int i = 0;
	        while (i < tab.length) {
	            if (tab[i] != null) {
	                if (tab[i].getExposant() == p.tab[i].getExposant()) {
	                    res.ajouterMonome(new Monome(tab[i].getCoefficient() + p.tab[i].getCoefficient(), tab[i].getExposant()));
	                }
	            }
	            i++;
	        }
	        System.out.println(res);
	        return res; 
		}
	
		public Polynome multiplicationPolynome (Polynome p) {
	        Polynome poly = new Polynome(tab.length);
	        for (int i = 0; i < this.tab.length; i++) {
	            for (int j = 0; j < p.tab.length; j++) {
	                if (tab[i] != null) {
	                    if (p.tab[j] != null) {
	                        poly.ajouterMonome(new Monome(p.tab[j].getCoefficient() * this.tab[i].getCoefficient(), p.tab[j].getExposant() + this.tab[i].getExposant()));
	                    }
	                }
	            }
	        }
	        System.out.println(poly);
	        return poly;
		}

		public Polynome deriverPolynome () {
			System.out.println("Dérivation de polynome...");
	        Polynome res = new Polynome(tab.length);
	        int i = 0;
	        while (i < tab.length) {
	            if (tab[i] != null) {
	                res.ajouterMonome(new Monome(tab[i].getCoefficient() * tab[i].getExposant(), tab[i].getExposant() - 1));
	            }
	            i++;
	        }
	        return res;
		}
		public String toString () {
			String res = "";
			int indice=tab.length-1, nbAffiches = 0;
			if (nbMonomes==0) return  "null"; 
			while (indice >= 0 && tab[indice]==null) indice--;
			res = tab[indice--].toString();
			nbAffiches++;
		
			while (indice >= 0 && nbAffiches<nbMonomes) {
				if (tab[indice]!=null){
			       nbAffiches ++;
				   if (tab[indice].getCoefficient()>0) res += "+";
				   res += tab[indice].toString();
				}
				indice --;
			}	 
			System.out.println(">"+res+"<");
			return res;	
		}

		public boolean comparerPolynome (Polynome p){
	        return this.toString() == p.toString();
			
		}

}

 