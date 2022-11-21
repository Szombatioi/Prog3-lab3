
public class Kezdo extends Jatekos {
	private String nev;
	public Kezdo(String nev) {
		this.nev = nev;
	}
	public String toString() {
		return nev;
	}
	
	@Override
	public void lep() {
		System.out.println(this.toString()+": "+asztal.getKor());
		if(asztal.getKor() % 2 == 0) asztal.emel(1);
	}
}
