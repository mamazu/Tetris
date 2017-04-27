import Score.Highscore;

public class HighscoreTest {
	public static void main (String[] args){
		Highscore hs = new Highscore("../test/testdata.dat");
		hs.addScore("Mamazu", 50);
		hs.addScore("Mamazu1995", 51);
		hs.addScore("Han", 40);
		hs.addScore("Han Feizi", 56);
		hs.addScore("Sigma", 55);
		hs.addScore("M", 57);
		hs.addScore("S", 51);
		hs.addScore("H", 49);
		hs.addScore("Feizi", 52);
		hs.addScore("F", 53);
		hs.addScore("fail", 20);
		hs.save();
	}
}