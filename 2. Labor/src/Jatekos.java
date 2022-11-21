
abstract public class Jatekos {
	protected Asztal asztal;
	void lep() {
		System.out.println(asztal.getKor() + "-" + asztal.getTet());
	}
	void setAsztal(Asztal a) {
		this.asztal = a;
	}
	
}
