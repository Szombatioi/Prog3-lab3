import java.util.Random;

public class Asztal {
	private Jatekos[] jatekosok;
	private double tet;
	private double goal;
	private int kor;
	
	
	//TODO ez jó így??
	private int size;
	private boolean vege;
	public Asztal() {
		jatekosok = new Jatekos[10];
		size = 0;
		vege = false;
	}
	
	
	
	
	Random r = new Random();
	public void ujJatek() {
		tet = 0;
		kor = 0;
		goal = r.nextDouble(0,100);
	}
	public void addJatekos(Jatekos j) {
		if(size < jatekosok.length) {
			j.setAsztal(this);
			jatekosok[size++] = j;
		}
		else System.out.println("Megtelt az asztal!");
	}
	public void emel(double d) {
		tet += d;
	}
	public void kor() throws NincsJatekos{
		if(size==0) throw new NincsJatekos();
		
		for(int i = 0; i < size; i++) {
			jatekosok[i].lep();
		}
		kor++;
		System.out.println("Tét="+tet);
		
		//TODO HELP
		if(tet >= goal) {
			
		}
		
	}
	public int getKor() {return kor;}
	public double getTet() {return tet;}
}
