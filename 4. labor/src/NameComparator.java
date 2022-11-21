import java.util.Comparator;

public class NameComparator implements Comparator<Beer> {
	public int compare(Beer n1, Beer n2) {
		int length = n1.getName().length() > n2.getName().length() ? n1.getName().length() : n2.getName().length();
		for(int i = 0; i < length; i++) {
			int a = (int)n1.getName().charAt(i);
			int b = (int)n2.getName().charAt(i);
			
			if(a != b) return a-b;
		}
		
		if(n1.getName() != n2.getName()) return n1.getName().length()-n2.getName().length();
		return 0;
	}
}
