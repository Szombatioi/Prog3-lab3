
public class Main {

	public static void main(String[] args) {
		
//		//asztal és 3 játékos létrehozása
//		Asztal asztal = new Asztal();
//		Jatekos jatekos1 = new Kezdo("Péter");
//		Jatekos jatekos2 = new Kezdo("János");
//		Jatekos jatekos3 = new Robot();
//		
//		//játékosok hozzáadása
//		asztal.addJatekos(jatekos1);
//		asztal.addJatekos(jatekos2);
//		asztal.addJatekos(jatekos3);
//		
//		//3 léptetés
//		asztal.kor();
//		asztal.kor();
//		asztal.kor();
		
		Asztal a = new Asztal();
		try {
			a.kor();
		}catch(NincsJatekos n) {
			System.out.println("Kivétel elkapva!");
		}finally {
			System.out.println("Try vége");
		}
		
	}

}
