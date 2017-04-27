package tools;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private ArrayList<String> content = new ArrayList<String>();
    private final String FILENAME;

    public FileHandler(String filename) {
        FILENAME = filename;
        load();
    }

    private void load() {
        File f = new File(FILENAME);
        if (!f.isFile()) {
            System.out.print("Created new file");
            writeToDisk();
        }
        Scanner scanner;
        try {
            scanner = new Scanner(new FileReader(f));
        } catch (FileNotFoundException e) {
            System.err.print("Could not open file");
            return;
        }catch (Exception e){
            return;
        }
        while (scanner.hasNext()) {
            content.add(scanner.nextLine());
        }
    }

    public String[] getContent() {
        return content.toArray(new String[getLineCount()]);
    }

    public void appendContent(String content) {
        this.content.add(content);
    }

    public int getLineCount() {
        return content.size();
    }

    public void writeToDisk() {
        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter(FILENAME));
            fw.write(toString());
            fw.close();
        } catch (IOException e) {
            System.err.println("IO Exception");
        }
    }

    @Override
    public String toString(){
        StringBuilder string = new StringBuilder();
        content.forEach((String s)-> string.append(s).append("\n"));
        return string.toString();
    }
}