/*
 * 5. feladat - tapasztalat: ha c.w < p.w --> megáll 
 */

public class Application {

	public static void main(String[] args) {
//		Producer p = new Producer("Elso");
//		Producer p2 = new Producer("Masodik");
//		
//		p.start();
//		try {
//			Thread.sleep(50);
//		}catch(InterruptedException e) {
//			System.out.println(e);
//		}
//		p2.start();
//		-----------------------------------------------------------
		Fifo f = new Fifo();
//		Producer p = new Producer("Elso", f, 50);
//		Consumer c = new Consumer(f, "", 150);
//		
//		Thread t = new Thread(p);
//		
////		p.start();
//		t.start();
//		try {
//			Thread.sleep(200);
//		}catch(InterruptedException e) {
//			
//		}
//		c.start();
		
		Producer p1 = new Producer("Elso", f, 1000);
		Thread t1 = new Thread(p1);
		
		Producer p2 = new Producer("Masodik", f, 1000);
		Thread t2 = new Thread(p2);
		
		Producer p3 = new Producer("Harmadik", f, 1000);
		Thread t3 = new Thread(p3);
		
		Consumer c1 = new Consumer(f, "", 400);
		Consumer c2 = new Consumer(f, "", 400);
		Consumer c3 = new Consumer(f, "", 400);
		Consumer c4 = new Consumer(f, "", 400);
		
		
		t1.start();
		t2.start();
		t3.start();
		c1.start();
		c2.start();
		c3.start();
		c4.start();

	}

}
