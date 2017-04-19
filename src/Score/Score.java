package Score;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Score {
    private String username;
    private int score;
    private Date date;
    private SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH-mm-ss");

    public Score(String username, int score, String date) {
        this(username,score);
        setDate(date);
    }

    public Score(String username, int score) {
        this.username = username;
        this.score = score;
        date = new Date();
    }

    public String getUsername() {
        return username;
    }

    public int getScore() {
        return score;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(String date) {
        try {
            this.date = sdf.parse(date);
        } catch (ParseException e) {
            System.err.println("Please use the iso-format YYYY-MM-dd");
        }
    }

    public String getFormattedDate() {
        return sdf.format(date);
    }

    public int compareTo(Score o2) {
        if(score > o2.score) return 1;
        if(score < o2.score) return -1;
        return date.compareTo(o2.date);
    }

    @Override
    public String toString() {
        return username + ":" + score + ":" + getFormattedDate();
    }
}
