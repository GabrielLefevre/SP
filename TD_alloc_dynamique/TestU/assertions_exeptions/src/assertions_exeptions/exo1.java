package assertions_exeptions;

public class exo1  {
    public void f(int a) {   //throws IllegalArgumentException {
    	if(a<2) throw new IllegalArgumentException("Probleme valeur param");
    	System.out.println("a = " +a);
    }


    public static void main(String[] a) {
    	exo1 e = new exo1();
    	try {
    		e.f(5);
    		e.f(1);
    	} catch(IllegalArgumentException ee) {
    		System.out.println("Erreur : " + ee);
    	}   
    }
}