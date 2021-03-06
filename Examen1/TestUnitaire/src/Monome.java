
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
		 if (exposant < 0) {
	            this.exposant = -exposant;
	        } else {
	            this.exposant = exposant;
	        }  
	}
	
	public int getExposant() {
		return exposant;
	}
	public boolean comparerMonome (Monome m){
        return coefficient == m.getCoefficient() && exposant == m.getExposant(); 

	}
	public String toString () {
        String res = "";
        if (coefficient == 0) res = "0";
        else if (exposant == 0) res = "" + coefficient;
        else {
            if (coefficient != 1) {
                if (coefficient == -1)
                    res = "-";
                else res += coefficient;
            }
            res += "x";
            if (exposant != 1) res += "^" + exposant;
        }
        return res;
	}
	public void afficheMonome (){
		System.out.println(this);
	}
}