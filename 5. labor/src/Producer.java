public class Producer /*extends Thread*/implements Runnable{
	int sorszam;
	String text;
	Fifo f;
	int wait;
	public Producer(String in, Fifo f, int w) {
		this.f = f;
		text = in;
		sorszam = 0;
		wait = w;
	}
	public void run() {
		go();
	}
	public void go() {
		while(true) {
			//System.out.println(text+" "+(sorszam++)+" "+System.currentTimeMillis());
			try {
				f.put(text+" "+sorszam++);
				System.out.println("+produced "+text+" "+(sorszam-1)+" "+System.currentTimeMillis()%100000);
				Thread.sleep(wait);
			} catch(InterruptedException e) {
				System.out.println(e);
			}
		}
	}
}
