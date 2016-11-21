import java.util.Scanner;
/**
 * <b>Polynome est une classe permettant de manipuler des polynômes</b>
 * <p>
 * Un Polynome est caractérisé par  :
 * <ul>
 * <li>le nombre de monômes</li>
 * <li>un tableau contenant les monômes : les monomes sont rangés par ordre décroissant de la valeur de l'exposant</li>
 * </ul>
 * </p>
 * <p>
 * Un polynôme implémente un ensemble de méthodes :
 * <li>ajouterMonome</li>
 * <li>lirePolynome</li>
 * <li>additionPolynome</li>
 * <li>multiplicationPolynome</li>
 * <li>deriverPolynome</li>
 * <li>comparerPolynome</li>
 * </p>
 * 
 * @author iut de lens
 * @version 1.0,Mai 2010
 */

public class Polynome {
    	/**
    	 * TAILLEMIN. une constante.
    	 * <p>
    	 * Le nombre d'emplacements libres lors de l'agrandissement du tableau 
    	 * </p>
    	 */
		private static final  int TAILLEMIN = 10; 
        /**
         * nbMonomes. Modifiable.
         * <p>
         * Le nombre de monomes contenus dans le polynome
         * </p>
         */
		private int nbMonomes;
        /**
         * tab. Modifiable.
         * <p>
         * Un tableau contenant les références des monômes contenus dans le polynome
         * </p>
         */
		private Monome [] tab; 
        /**
         * Constructeur polynome par défaut.
         * <p>
         * fait appel au constructeur Polynome(TAILLEMIN)
         * </p>
         * @see Polynome#Polynome(int)
         */		
		public Polynome () {
			this (TAILLEMIN);
		}
        /**
         * Constructeur polynome.
         * <p>
         * A la construction d'un objet polynome :
         *  <li>nbMonomes=0</li>
         *  <li>tab référence un tableau de n éléments de type Monome
         * </p>
         * 
         * @param n
         *            le nombre maximal de Monomes
         * @see Polynome#nbMonomes
         * @see Polynome#tab
         */	
	 public Polynome (int n){
             tab = new Monome[n]; 
             nbMonomes=0;
	 }
        /**
         * Retourne la position d'insertion du Monome m dans le polynome. 
         * c'est à dire l'indice de la case où le monome doit être rangé.
         * cette indice correspond à l'exposant du monome. La fonction retourne -1 
         * si l'exposant est supérieur à la capacité du tableau
         * @return la position d'insertion du Monome m dans le polynome.
         * @param m
         *            le monome destiné à être inserer 
         * @see Polynome
         * @see Polynome#nbMonomes
         */
		private int recherchePosition (Monome m) {
			if (m.getExposant()<tab.length) return m.getExposant();
			return -1;
		}

        /**
         * Ajoute TAILLEMIN emplacements libres au polynome 
         * @see Polynome#nbMonomes
         * @see Polynome#tab
         * @see Polynome#TAILLEMIN
         */	
		private void agrandirTab () {
			// On ajoute TAILLEMIN cases supplémentaies
			// A FAIRE
		}
        /**
         * Ajoute le monome m dans le polynome. Plusieurs cas possibles :
         *  <li> si le polynome ne contient pas de monome de même degré </li>
         *  <ul>
         *  <li> alors le monome m est rangé dans le polynome en respectant l'ordre  </li>
         *  <li> sinon (il existe un monome m' de même degré) </li>
         *  <ul>
         *  <li> suivant le résultat de la somme des coefficients m et m', on met à jour le coefficient de m' (somme!=0) ou on retire m' du polynome (somme=0)</li>
         *  </ul>
         *  </ul>
         * @param m
         *            le monome  à inserer 
         * @see Polynome
         * @see Polynome#nbMonomes
         * @see Polynome#tab
         * @see Polynome#recherchePosition(Monome)
         * @see Polynome#agrandirTab()
         */	
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
        /**
         * Cree un monome m de coefficient coef et de degré deg et l'ajoute dans le polynome
         * @param coef
         *             le coefficient du monome à inserer
         * @param deg
         * 				le degré du monome à ajouter 
         *  @see Polynome#ajouterMonome(Monome)
         */  
		public void ajouterMonome (double coef, int deg) {
			Monome m = new Monome (coef,deg);
			ajouterMonome(m);			
		}
        /**
         * Initialisation d'un polynome. Les monomes sont saisis au clavier.
         *  @see Polynome#ajouterMonome(Monome)
         */
		public void lirePolynome (){
			// A FAIRE ...
			
		}
        /**
         * additionDansPolynome  
         *  @return le polynome dupliqué
         */
	private void additionDansPolynome (Polynome p) {
           // A FAIRE            
	}
        /**
         * Faire une copie du polynome. 
         *  @return le polynome dupliqué
         */
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
        /**
         * Multiplie le polynome par un monome 
         * @return le polynome résultat de la multiplication par le monome m
         * @param m
         *            le monome multiplicateur  
         *  @see Polynome
         *  @see Polynome#nbMonomes
         *  @see Polynome#tab
         */
		private Polynome multiplierParMonome (Monome m) {
			// A FAIRE		
			return null;
		}
        /**
         * Effectue l'addition du polynome courant et du polynome p 
         * @return le polynome résultat de l'addition du polynome courant et du polynome p
         * @param p
         *         le polynome additionneur     
         *  @see Polynome
         *  @see Polynome#nbMonomes
         *  @see Polynome#tab
         */
		public Polynome additionPolynome (Polynome p) {
		
                        // A FAIRE
			return res; 
		}
	     /**
         * Effectue la multiplication du polynome courant et du polynome p 
         * @return le polynome résultat de la multiplication du polynome courant et du polynome p
         * @param p
         *         le polynome multiplicateur     
         *  @see Polynome
         *  @see Polynome#nbMonomes
         *  @see Polynome#tab
         *  @see Polynome#multiplierParMonome(Monome)
         *  @see Polynome#additionPolynome(Polynome)
         */		
		public Polynome multiplicationPolynome (Polynome p) {
			return null;
		}
	     /**
         * Dérive le polynome courant
         * @return le polynome dérivé
         *  @see Polynome
         *  @see Polynome#nbMonomes
         *  @see Polynome#tab
         */		
		public Polynome deriverPolynome () {
			// A FAIRE	
			return null;
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
	     /**
         * Compare le polynome courant avec le polynome p
         *  @return vrai si polynome courant et le polynome p sont identiques, faux sinon
         *  @param p
         *         le polynome comparateur
         *  @see Polynome
         *  @see Polynome#nbMonomes
         *  @see Polynome#tab
         */	
		public boolean comparerPolynome (Polynome p){

			// A FAIRE
			return true;
			
		}

}