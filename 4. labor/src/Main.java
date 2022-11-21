import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class Main {

	public static List<Beer> list; 
	
	protected static void add(String[] cmd) {
		list.add(new Beer(cmd[1], cmd[2], Double.parseDouble(cmd[3])));
	}
	
	protected static void list(String[] cmd) {
		if(cmd.length>1) {
			if(cmd[1].equals("name")) {
				Collections.sort(list, new NameComparator());
			}
			else if(cmd[1].equals("style")) {
				Collections.sort(list, new StyleComparator());
			}
			else if(cmd[1].equals("strength")) {
				Collections.sort(list, new StrengthComparator());
			}
		}
		
		
		for(Beer b : list) {
			System.out.println(b);
		}
	}
	
	protected static void save(String[] cmd) throws IOException {
		FileWriter fw = new FileWriter(cmd[1]);
		BufferedWriter bw = new BufferedWriter(fw);
		
		for(Beer b : list) {
			bw.write("- "+b.getName()+" "+b.getStyle()+" "+b.getStrength()+"\n");
		}
		bw.close();
		System.out.println("Saved");
	}
	
	protected static void load(String[] cmd) throws IOException{
		FileReader fr = new FileReader(cmd[1]);
		BufferedReader br = new BufferedReader(fr);
		
		String line = br.readLine();
		String[] temp;
		while(line != null) {
			temp = line.split(" ");
			add(temp);
			line = br.readLine();
		}
		
		br.close();
		System.out.println("Loaded");
	}
	
	protected static void search(String[] cmd) {
		if(cmd.length>2) {
			for(Beer b : list) {
				if((cmd[1].equals("name") && b.getName().equals(cmd[2])) ||
						(cmd[1].equals("style") && b.getStyle().equals(cmd[2])) ||
						(cmd[1].equals("strength") && b.getStrength() == Double.parseDouble(cmd[2]))) 
					System.out.println(b);
			}
			return;
		}
		for(Beer b : list) {
			if(b.getName().equals(cmd[1])) System.out.println(b);
		}
	}
	
	protected static void find(String[] cmd) {
		
		if(cmd.length > 2) {
			for(Beer b : list) {
				if((cmd[1].equals("name") && b.getName().contains(cmd[2])) ||
						(cmd[1].equals("style") && b.getStyle().contains(cmd[2])) ||	
						(cmd[1].equals("strength") && b.getStrength()>= Double.parseDouble(cmd[2])) ||
						(cmd[1].equals("weaker") && b.getStrength()<= Double.parseDouble(cmd[2]))) 
					System.out.println(b);
			}
			return;
		}
		
		for(Beer b : list) {
			if(b.getName().contains(cmd[1])) System.out.println(b);
		}
	}
	
	protected static void delete(String[] cmd) {
		Iterator<Beer> it = list.iterator();
		while(it.hasNext()) {
			Beer b = it.next();
			if(b.getName().equals(cmd[1])) {
				it.remove();
			}
		}
	}
	
	public static void main(String[] args) {
//		Beer sor1 = new Beer("Dreher", "Barna", 4.96);
//		Beer sor2 = new Beer("Borsodi", "Fehér", 3.14);
//		System.out.println(sor1+"\n"+sor2);
		
		
		list = new ArrayList<>();
		
		Scanner in = new Scanner(System.in);
		while(true) {
			String[] line = in.nextLine().split(" ");
			if(line[0].equals("exit")) break;
			else if(line[0].equals("add")) {
				add(line);
			}
			else if(line[0].equals("list")) {
				list(line);
			}
			else if("save".equals(line[0])) {
				try {
					save(line);
				}catch(IOException e) {
					System.out.println(e.toString());
				}
			}
			else if("load".equals(line[0])) {
				try {
					load(line);
				}catch(IOException e) {
					System.out.println(e.toString());
				}
			}
			else if("search".equals(line[0])) {
				search(line);
			}
			else if("find".equals(line[0])) {
				find(line);
			}
			else if("delete".equals(line[0])) {
				delete(line);
			}
//			System.out.println(line[0]+" - length: "+line.length);
		}
		in.close();
		
	}

}



/**
* 4. feladat
* 9. feladat
* 10. feladat
*/