
import Score.Highscore;
import Score.Score;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author simon
 */
public class HighscoreTest {
    public static void main(String args[]){
        Highscore hs = new Highscore("Tetris_Bestenliste");
        hs.addScore("mamazu", 5);
        hs.addScore("Han_Feizi", 4);
        hs.addScore("Fan_Heizi", 6);
        hs.addScore("Simon", 10);
        hs.addScore("Kyogre", -5);
        hs.addScore("Glumanda", 1);
        hs.addScore("Glurak", 11);
        hs.addScore("Okay", 3);
        hs.addScore("Groudon", -7);
        hs.addScore("Robball", 0);
        
        Score[] tp = hs.getTop(4);
        System.out.print(tp[0].getUsername() + " ");
        System.out.print(tp[0].getScore() + " ");
        System.out.println(tp[0].getFormattedDate());
        System.out.print(tp[1].getUsername() + " ");
        System.out.print(tp[1].getScore() + " ");
        System.out.println(tp[1].getFormattedDate());
        System.out.print(tp[2].getUsername() + " ");
        System.out.print(tp[2].getScore() + " ");
        System.out.println(tp[2].getFormattedDate());
        System.out.print(tp[3].getUsername() + " ");
        System.out.print(tp[3].getScore() + " ");
        System.out.println(tp[3].getFormattedDate());
        
        hs.save();
    }
}
