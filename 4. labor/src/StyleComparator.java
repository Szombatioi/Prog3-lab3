import java.util.Comparator;

public class StyleComparator implements Comparator<Beer> {
	public int compare(Beer s1, Beer s2) {
		int length = s1.getStyle().length() > s2.getStyle().length() ? s1.getStyle().length() : s2.getStyle().length();
		for(int i = 0; i < length; i++) {
			int a = (int)s1.getStyle().charAt(i);
			int b = (int)s2.getStyle().charAt(i);
			
			if(a != b) return a-b;
		}
		
		if(s1.getStyle() != s2.getStyle()) return s1.getStyle().length()-s2.getStyle().length();
		return 0;
	}
}
