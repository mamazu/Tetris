public class StoneType extends Stone {

enum StoneTypes{
	// http://www.russlandjournal.de/unterhaltung/tetris/attachment/tetris-steine/
	BAR, // dark blue
	T, // light blue
	SQUARE, //green
	S, // orange
	Z, // pink
	L, // red
	J; // yellow
}

	public StoneType(int x){
		switch(x){
			case 0:		for(int i=0; i<4;i++)	Stein_[i][0] = true; break;
			case 1:		Stein_[0][0] = true;	for(int i=0; i<= 2; i++) Stein_[0][i] = true; break;
			case 2:		for(int i=0; i<=2; i++) Stein_[1][i] = true; Stein_[0][2] = true;	break;
			case 3:
				for(int i=0; i<=1;i++){
					Stein_[0][i] = true;
					Stein_[1][i] = true;
				}
				break;
			case 4:
				for(int i=0; i<=1;i++){
					Stein_[0][i+1] = true;
					Stein_[1][i] = true;
				}
				break;
			case 5: break;
			case 6:
			default:	System.out.println("Fehler mit unbekanntem Fehlercode :D");
		}
	}
}