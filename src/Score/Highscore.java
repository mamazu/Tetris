package Score;

import Score.Score;
import tools.FileHandler;

import java.util.LinkedList;

public class Highscore {

    public FileHandler f;
    private LinkedList<Score> scores = new LinkedList<Score>();

    public Highscore(String name) {
        f = new FileHandler(name);
        load();
    }

    private void load() {
        for (String line : f.getContent()) {
            if (line.startsWith("#")) continue;
            String[] part = line.split(":", 3);
            if (part.length != 3) continue;
            Score score = new Score(part[0], Integer.parseInt(part[1]), part[2]);
            scores.push(score);
            System.out.println(line);
        }
        sort();
    }

    private void sort() {
        scores.sort((o1, o2) -> o2.compareTo(o1));
    }

    public void addScore(String username, int score) {
        Score newScore = new Score(username, score);
        scores.push(newScore);
        f.appendContent(newScore.toString());
        sort();
    }

    public Score[] getTop(int amount) {
        if (amount < 1) {
            return new Score[0];
        }
        Score[] result = new Score[amount];
        for (int i = 0; i < amount && i < scores.size(); i++) {
            result[i] = scores.get(i);
        }
        return result;
    }

    public Score[] getAll() {
        return getTop(scores.size());
    }

    public void save() {
        f.writeToDisk();
    }

}
