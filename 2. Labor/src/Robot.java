
public class Robot extends Jatekos {
	public static int azonosito = 0;
	private int id;
	
	public Robot() {
		id = azonosito++;
	}
	
	public void lep() {
		System.out.println(this.toString()+id+": "+asztal.getKor());
	}
	
	public String toString() {
		return "Robot";
	}
}
