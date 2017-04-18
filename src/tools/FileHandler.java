package tools;

import java.io.File;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileHandler{
	private ArrayList<String> content = new ArrayList<String>();

	public FileHandler(String filename){
		Path filepath = new File(filename).toPath();
		try{
			Files.lines(filepath).forEach(s -> content.add(s));
		} catch (AccessDeniedException e) {
			System.err.println("Could not access file: " + filepath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String[] getContent() {
		return content.toArray(new String[content.size()]);
	}

	public void appendContent(String content){
		this.content.add(content);
	}

	public int getLineCount(){ return content.size(); }
}
