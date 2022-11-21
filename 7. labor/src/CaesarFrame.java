import javax.swing.*;

public class CaesarFrame extends JFrame{
	JFrame frame;
	public CaesarFrame(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("SwingLab");
		setSize(400,110);
		setVisible(true);
		JButton btn = new JButton("Click me");
		JPanel panel = new JPanel();
		panel.add(btn);
		add(panel);
	}
	
//	private String caesarCode(String input, char offset){
//		char[] upper = input.toUpperCase().toCharArray();
//		int off = offset-'A';
//		
//		String res = "";
//		char temp;
//		for(int i = 0; i < upper.length; i++) {
//			temp = (char)(upper[i] + off);
//			if(temp > 90) temp = (char)(64 + (temp-'Z'));
//			res += temp;
//		}
//		
//		return res;
//
//	}
}
