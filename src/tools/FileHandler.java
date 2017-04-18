package tools;

import java.io.*;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler{
	private ArrayList<String> content = new ArrayList<String>();
	private final String FILENAME;

	public FileHandler(String filename){
		FILENAME = filename;
		load();
	}

	private void load(){
		File f = new File(FILENAME);
		if(!f.isFile())
			writeToDisk();
		Scanner scanner;
		try {
			scanner = new Scanner(new FileReader(f));
		} catch (FileNotFoundException e) {
			return;
		}
		while(scanner.hasNext()){
			content.add(scanner.nextLine());
		}
	}

	public String[] getContent() {
		return content.toArray(new String[getLineCount()]);
	}

	public void appendContent(String content){
		this.content.add(content);
	}

	public int getLineCount(){ return content.size(); }

	public boolean writeToDisk(){
		StringBuilder string = new StringBuilder();
		for(String s : content) string.append(s).append("\n");
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter(FILENAME));
			fw.write(string.toString());
			fw.close();
		} catch (IOException e) {
			System.err.println("IO Exception");
			return false;
		}
		return true;
	}
}