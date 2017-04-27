import Score.Highscore;
import Score.Score;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HighscoreTest {

	@Test
	void testBest(){
		Highscore hs = new Highscore("test/res/testdata.dat");
		Score best = hs.getTop(1)[0];
		assertEquals(best.getUsername(), "Feizi");
	}

	@Test
	void testAddingScore(){
		Highscore hs = new Highscore("test/res/testdata.dat");
		hs.addScore("Someone", 20);
		System.out.print(hs.toString());
		assertEquals(hs.toString().contains("Someone"), true);
	}

	@Test
	void savingAndLoading(){
		Highscore hs = new Highscore("test/res/testdata.dat");
		String before = hs.toString();
		hs.save();
		hs = new Highscore("test/res/testdata.dat");
		assertEquals(before, hs.toString());
	}

}