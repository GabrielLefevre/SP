import java.util.*;
class Rationnel 
{
    private int numerateur; //numerateur
    private int denominateur; //denominateur
    //----------------------------------------
    public Rationnel() //constructeur par defaut
    {
    	this (0,1);
    }
    //----------------------------------------
    public Rationnel(int n, int d) //constructeur
    {
       numerateur = n;
       setDenominateur(d);

    }
    //----------------------------------------
    public Rationnel(int n, int d, boolean optim) //constructeur
    {   // le rationnel est simplifié et normalisé
       this(n,d);
       if (optim) {
         normaliser(); 
         simplifier();
       }  
    }
    //----------------------------------------
    public void setNumerateur(int n)
    {
       numerateur = n;

    }
    //----------------------------------------
    //precondition : d>0
    public void setDenominateur (int d) throws  ArithmeticException 
    {
        if (d==0) throw new IllegalArgumentException("dénominateur nul"); 
        denominateur=d; 

    }
    //----------------------------------------
    public int getNumerateur()
    {
      return numerateur;
    }
    //----------------------------------------
    public int getDenominateur() 
    {
      return denominateur;
    }
    //----------------------------------------
    private int pgcd () {
      int a=Math.abs(numerateur),b=Math.abs(denominateur);
      if (a==0 || b==0) return 1;
  	  while(a!=b) {
 	    if(a>b) 
           a = a-b;
 	    else
 	       b = b-a;
 	  }
      return a;
    }
    //----------------------------------------
    public void simplifier () {
    	// TODO simplification à l'aide du pgcd
    	int pgcd = pgcd();
        if (pgcd > 1) { 
            numerateur = numerateur / pgcd;
            denominateur = denominateur / pgcd;
            System.out.print(numerateur + "/" + denominateur + "\n");
        }
    }
    //----------------------------------------   
    public void normaliser () 
	{
    	// TODO : Normaliser le format du rationnel 
    	// numerateur : entier relatif (négatif, positif ou nul)
    	// denominateur : entier positif non nul
    	// -3/-4 => 3/4
    	// 1/-6  => -1/6
    	
        if (denominateur < 0) {
            numerateur = -numerateur;
            denominateur = -denominateur;
        }
    	
	}
    //----------------------------------------
    
    public int comparer (Rationnel r) {
    	// TODO : retourne -1 si le courant est plus petit, 0 si égaux, 1 sinon
    	 if (r == null)
             return 1;
    	 
    	float resR =  (float) r.getNumerateur()/(float)r.getDenominateur();
    	float res=(float) numerateur/ (float)denominateur;
    	
    	if(resR==res) {
    		return 0;
    	}
    	
    	else if (resR > res) {
    		return -1;
    	}
    	return 1;
      }

   //----------------------------------------
   public String toString() {
	        if (numerateur == 0)
	            return "0"; 
	        else {
	            if (denominateur == 1)
	                return numerateur +"";
	            else {
	                return numerateur + "/" + denominateur;
	            	 }
	        	 }
   			}
   Rationnel addition (Rationnel r) {
	   // TODO  res = Ra + Rb
	   if (r==null) {
		   return this;
	   }
       int denominateurRes =  denominateur * r.getDenominateur();	   
       int numerateurRes = numerateur * r.getDenominateur() + r.getNumerateur() * denominateur;
       
	   Rationnel res = new Rationnel (numerateurRes, denominateurRes,true);
	   
	   return res;
	 }
   }//class Rationnel
