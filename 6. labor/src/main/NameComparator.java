package main;
import java.util.Comparator;

public class NameComparator implements Comparator<Beer> {
	public int compare(Beer n1, Beer n2) {
		return n1.getName().compareTo(n2.getName());
	}
}
