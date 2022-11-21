package main;
//import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class PQueue<T extends Comparable<T>> implements Iterable<T> {
	public ArrayList<T> l;
	public PQueue() {
		l = new ArrayList<T>();
	}
	
	public void push(T t) {
		l.add(0, t);
	}
	
	public T pop() throws EmptyQueueException{
		if(l.size()==0) throw new EmptyQueueException("Empty Queue!");
		T max = Collections.max(l);
		l.remove(Collections.max(l));
		return max;
	}
	
	public T top() throws EmptyQueueException{
		if(l.size()==0) throw new EmptyQueueException("Empty Queue!");
		return Collections.max(l);
	}
	
	public int size() {
		return l.size();
	}
	
	public void clear() {
		l.clear();
	}
	
	//test
	public void list() {
		for(T x : l) System.out.println(x);
	}

	@Override
	public Iterator<T> iterator() {
		Collections.sort(l);
		Collections.reverse(l);
		return l.iterator();
	}
}