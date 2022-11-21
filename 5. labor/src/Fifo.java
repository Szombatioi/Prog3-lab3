import java.util.LinkedList;

public class Fifo {
	private int max = 10;
	LinkedList<String> fifo;
	
	public Fifo() {
		fifo = new LinkedList<>();
	}
	
	synchronized public void put(String s) throws InterruptedException {
//		System.out.println("put - "+Thread.getId());
		if(fifo.size() < max) {
			this.notify();
			fifo.add(s);
		}
		else {
			try {
				this.wait();
			} catch(InterruptedException e) {
				throw e;
			}
		}
	}
	
	synchronized public String get() throws InterruptedException {
//		System.out.println("get - "+Thread.getId());
		if(fifo.size() == 0) {
			try {
				this.wait();
			} catch(InterruptedException e) {
				throw e;
			}
		}
		else this.notify();
		return fifo.removeFirst();
	}
}
