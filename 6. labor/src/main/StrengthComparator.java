package main;
import java.util.Comparator;
public class StrengthComparator implements Comparator<Beer>{
	public int compare(Beer s1, Beer s2) {
		return ((int)s1.getStrength()-(int)s2.getStrength());
	}
}
