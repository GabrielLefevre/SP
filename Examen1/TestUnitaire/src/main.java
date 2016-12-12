
public class main {

	public static void main(String[] args) {
		Polynome p1 = new Polynome(2);
		Polynome p2 = new Polynome(5);
		Monome m1 = new Monome(3,5);
		Monome m2 = new Monome(1,2);
		Monome m3 = new Monome(4,2);
		
		p1.ajouterMonome(m1);
		p1.ajouterMonome(m2);
		p1.toString();
		p2.ajouterMonome(m3);
		p1.additionPolynome(p2);
		p1.toString();
		System.out.println(p1.getNbMonomes());

	}

}
