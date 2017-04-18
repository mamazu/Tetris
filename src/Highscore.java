import tools.FileHandler;

public class Highscore {
    private FileHandler f;

    public Highscore(String name){
        f = new FileHandler(name);
        for(String line : f.getContent()){
            System.out.println(line);
        }
    }

    public static void main(String[]args){
        Highscore h = new Highscore("C:\\Users\\mamazu\\Desktop\\Tetris\\.gitignore");

    }
}
