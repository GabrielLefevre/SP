package assertions_exeptions;

import java.util.Scanner;

public class exo1  {
    public void f(int a) throws MonException {
    	if((a<2) || (a>10)) throw new MonException("a :"+a);
    	System.out.println(a);
    }
    
    public void g(int a) throws MonException {
        f(a);
    }


    public static void main(String[] args) {
        exo1 t = new exo1();
        Scanner sc = new Scanner(System.in);
        boolean nonfin = false;
        do {
            try {
                int val;
                nonfin = false;
                System.out.print("Entrer un nombre :");
                val = sc.nextInt();
                t.f(val);
            } catch (MonException ee) {
                System.out.println("Erreur : " + ee);
                nonfin = true;
            }
        } while (nonfin);
    }
}

