
public class Monome {
	/**
	 * @param args
	 */
	private double coefficient; 
	private int exposant;
	public Monome () {
		this (0,0);
	}
	public  Monome(double c,int e){
		setCoefficient(c);
		setExposant(e);
	}
	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}
	public  double getCoefficient() {
		return coefficient;
	}

	public  void setExposant(int exposant) {
		
		// à compléter 
		this.exposant = exposant;  
	}
	
	public int getExposant() {
		return exposant;
	}
	public boolean comparerMonome (Monome m){
		// A faire 
		return true; 

	}
	public String toString () {
		String res="" ; 
       
		// à compléter ...
		
		return res;
	}
	public void afficheMonome (){
		System.out.println(this);
	}
}