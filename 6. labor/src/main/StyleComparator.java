package main;
import java.util.Comparator;

public class StyleComparator implements Comparator<Beer> {
	public int compare(Beer s1, Beer s2) {
		return s1.getName().compareTo(s2.getName());
	}
}
