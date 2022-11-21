
public class Test {

	public static void main(String[] args) {
		System.err.println("Testing the PQueue of String");
		PQueue<String> q = new PQueue<>();
		q.push("Hello");
		q.push("World");
		q.push("!");
		q.push("VerylongString");
		System.out.println("Size of PQueue: "+q.size());
		
		System.out.println("-==Testing pop and top==-");
		try {
			System.out.println(q.pop());
			System.out.println(q.top());
			
		}catch(EmptyQueueException e) {
			System.out.println(e.toString());
		}
		
		q.clear();
		System.out.println("Listing empty queue: "); q.list();
		
		
		System.err.println("Testing the for-each for PQueue");
		PQueue<Integer> s = new PQueue<Integer>();
		s.push(4); s.push(1); s.push(2); s.push(3);  
		for (Integer i : s) {
		System.out.println(i);
		}
	}

}
