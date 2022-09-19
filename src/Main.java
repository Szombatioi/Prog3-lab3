import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Main {

	protected static File wd = new File(System.getProperty("user.dir"));
	
	protected static void pwd() {//most akkor 2 féleképp írjam le?
		//System.out.print(System.getProperty("user.dir"));
		//File dir = new File(System.getProperty("user.dir"));
		//System.out.println(" - "+dir.listFiles().length+"db");
		try {
			System.out.println(wd.getCanonicalPath());
		} catch(IOException e) { System.out.println("Error."); }
	}
	
	protected static void cd(String dir) {
		if(dir.equals("..")) {
			wd = wd.getParentFile();
		}
		else {
			wd = new File(wd.toString()+"\\"+dir);
			if(!wd.isDirectory()) System.out.println("Error: non-existing folder!");
		}
		System.out.print("New folder: ");
		pwd();
	}
	
	protected static void ls(String[] cmd) { 
		boolean l = false;
		if(cmd.length>1) l = cmd[1].equals("-l");
		
		File[] files = wd.listFiles();
		for(int i = 0; i < files.length; i++) {
			System.out.print(files[i].getName() + " ");
			if(l) {
				System.out.print(files[i].length()+" byte ");
				System.out.print(files[i].isDirectory() ? "d" : "f");
			}
			System.out.println("");
		}
	}
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(true) {
			String[] cmd = input.nextLine().split(" ");
			if(cmd[0].equals("exit")) {
				System.exit(0);
			}
			else if(cmd[0].equals("pwd")) {
				pwd();
			}
			else if(cmd[0].equals("ls")) {
				ls(cmd);
			}
			else if(cmd[0].equals("cd")) {
				cd(cmd[1]);
			}
		}
	}

}
