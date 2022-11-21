public class Consumer extends Thread{
	Fifo f;
	String s;
	int n;
	public Consumer(Fifo f, String s, int n) {
		this.f = f;
		this.s = s;
		this.n = n;
	}
	
	public void run() {
		while(true) {
			try {
				s = f.get();
			} catch(InterruptedException e) {
				System.out.println(e);
			}
			
			System.out.println("-consumed "+s+" "+System.currentTimeMillis()%100000);
			
			try {
				Thread.sleep(n);
			} catch(InterruptedException e) {
				System.out.println(e);
			}
			
		}
	}
	
	
}
