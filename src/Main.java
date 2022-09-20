import java.util.Scanner;
import java.io.*;

public class Main {

	protected static File wd = new File(System.getProperty("user.dir"));
	private static Scanner input;
	
	protected static void pwd() {//most akkor 2 féleképp írjam le?
		//System.out.print(System.getProperty("user.dir"));
		//File dir = new File(System.getProperty("user.dir"));
		//System.out.println(" - "+dir.listFiles().length+"db");
		try {
			System.out.println(wd.getCanonicalPath());
		} catch(IOException e) { System.out.println("Error."); }
	}
	
	protected static void cd(String[] cmd) {
		String dir = cmd[1];
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
	
	protected static void rm(String[] cmd){
		File f = new File(wd+"\\"+cmd[1]);
		if(!f.delete()){
			System.out.println("Error on deleting file: "+cmd[1]);
		}
	}
	
	protected static void mkdir(String[] cmd){
//		cd(cmd);
		File f = new File(wd.toString()+"\\"+cmd[1]);
		if(f.exists()) System.out.println("Folder already exists!");
		else f.mkdir();
	}
	
	protected static void mv(String[] cmd){
		File f = new File(wd.toString()+"\\"+cmd[1]);
		if(!f.renameTo(new File(wd.toString()+"\\"+cmd[2]))) System.out.println("Error");
	}
	
	protected static void cp(String[] cmd) throws IOException {
		InputStream fis = new FileInputStream(cmd[1]);
		Reader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(cmd[2])));
		
		String line = br.readLine();
		while(line != null){
			pw.println(line);
			line = br.readLine();
		}
		
		br.close();
		pw.close();
	}
	
	protected static void cat(String[] cmd) throws IOException{
		InputStream fis = new FileInputStream(cmd[1]);
		Reader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		
		String line = br.readLine();
		while(line != null){
			System.out.println(line);
			line = br.readLine();
		}
		br.close();
	}
	
	protected static void head(String[] cmd) throws IOException{
		InputStream fis = new FileInputStream(cmd[1]);
		Reader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		
		int lines = 10;
		if(cmd.length>2) lines = Integer.parseInt(cmd[2]);
		
		String line = br.readLine();
		while(line != null && lines>0){
			System.out.println(line);
			line = br.readLine();
			lines--;
		}
		br.close();
	}
	
	public static void main(String[] args) {
		input = new Scanner(System.in);
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
				cd(cmd);
			}
			else if(cmd[0].equals("rm")){
				rm(cmd);
			}
			else if(cmd[0].equals("mkdir")){
				mkdir(cmd);
			}
			else if(cmd[0].equals("mv")){
				mv(cmd);
			}
			else if(cmd[0].equals("cp")){
				try{
					cp(cmd);
				}catch(IOException e){
					System.out.println("IO Exception!");
				}
			}
			else if(cmd[0].equals("cat")){
				try{
					cat(cmd);
				}catch(IOException e){
					System.out.println("IO Exception!");
				}
			}
			else if(cmd[0].equals("head")){
				try{
					head(cmd);
				}catch(IOException e){
					System.out.println("IO Exception!");
				}
			}
			else{
				System.out.println("Error. No function named -="+cmd[0]+"=-");
			}
		}
	}

}
