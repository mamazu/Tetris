import java.awt.Font;
import Score.*;
import java.awt.Dimension;

public class _TetrisGrafik{

	public static void hm_wahl(int w, Knopf spielen, Knopf bestenliste, Knopf steuerung, Knopf mitwirkende, Knopf beenden){
		switch(w){
			case 0: spielen.zeichneAn();	bestenliste.zeichneAus();	steuerung.zeichneAus();	mitwirkende.zeichneAus();	beenden.zeichneAus();	break;
			case 1: spielen.zeichneAus();	bestenliste.zeichneAn();	steuerung.zeichneAus();	mitwirkende.zeichneAus();	beenden.zeichneAus();	break;
			case 2:	spielen.zeichneAus();	bestenliste.zeichneAus();	steuerung.zeichneAn();	mitwirkende.zeichneAus();	beenden.zeichneAus();	break;
			case 3:	spielen.zeichneAus();	bestenliste.zeichneAus();	steuerung.zeichneAus();	mitwirkende.zeichneAn();	beenden.zeichneAus();	break;
			case 4:	spielen.zeichneAus();	bestenliste.zeichneAus();	steuerung.zeichneAus();	mitwirkende.zeichneAus();	beenden.zeichneAn("Geh nicht! :'(");	break;
		}
	}

	public static void zeichneRaster(Draw Grafik, int x, int y){	//400 585
		for(int i=0; i<y; i++){
			for(int j=0; j<x; j++){
				Grafik.square(100 + (200/2*x) + (j * (200/x)), (585 * 0.75) - ((585 * 0.6)/2*x) + (i * ((585 * 0.7)/y)), (200/2*x));	//x,y,r
			}
		}

	}

	public static void init(Draw Grafik, int Modus){
		
		//Fonts
		Font Ueberschrift = new Font("SANS_SERIF", 0, 64);
		
		if(Modus == 0){
			//Var
			int MenueWahl = 0;
			
			/*******************************/
			//Hauptmenü
			/*******************************/

			double Breite = 0.25;
			double Hoehe = 0.025;

			//Erzeuge Menuepunkte
			Knopf spielen = new Knopf("Spielen", 0.5, 0.75, Breite, Hoehe, Grafik);
			Knopf bestenliste = new Knopf("Bestenliste", 0.5, 0.65, Breite, Hoehe, Grafik);
			Knopf steuerung = new Knopf("Steuerung", 0.5, 0.55, Breite, Hoehe, Grafik);
			Knopf mitwirkende = new Knopf("Mitwirkende", 0.5, 0.45, Breite, Hoehe, Grafik);
			Knopf beenden = new Knopf("Beenden", 0.5, 0.35, Breite, Hoehe, Grafik);
			
			//System.out.println("1");


			//
			while (true){
				Grafik.clear();
	
				//Überschrift
				Grafik.setFont(Ueberschrift);
				Grafik.text(0.5, 0.9, "Tetris", 0);		//x,y,Text,deg
				Grafik.setFont();

				spielen.zeichneAus();
				bestenliste.zeichneAus();
				steuerung.zeichneAus();
				mitwirkende.zeichneAus();
				beenden.zeichneAus();
				
				Grafik.setFont( new Font("SANS_SERIF", 0, 8));
				Grafik.textLeft(0, 0.02, "v0.0.0.1 pre-alpha");
				Grafik.setFont();


				if(Grafik.mouseX() > 0.5 - Breite && Grafik.mouseX() < 0.5 + Breite){
					if ((Grafik.mouseY() < 0.75 + Hoehe && Grafik.mouseY() > 0.75 - Hoehe)){
						// -> Spielen
						MenueWahl = 0;
						hm_wahl(MenueWahl, spielen, bestenliste, steuerung, mitwirkende, beenden);
					}

					if (Grafik.mouseY() < 0.65 + Hoehe && Grafik.mouseY() > 0.65 - Hoehe){
						// -> Bestenliste
						MenueWahl = 1;
						hm_wahl(MenueWahl, spielen, bestenliste, steuerung, mitwirkende, beenden);
					}
					if (Grafik.mouseY() < 0.55 + Hoehe && Grafik.mouseY() > 0.55 - Hoehe){
						// -> Steuerung
						MenueWahl = 2;
						hm_wahl(MenueWahl, spielen, bestenliste, steuerung, mitwirkende, beenden);
					}
					if (Grafik.mouseY() < 0.45 + Hoehe && Grafik.mouseY() > 0.45 - Hoehe){
						// -> Mitwirkende
						MenueWahl = 3;
						hm_wahl(MenueWahl, spielen, bestenliste, steuerung, mitwirkende, beenden);
					}
					if (Grafik.mouseY() < 0.35 + Hoehe && Grafik.mouseY() > 0.35 - Hoehe){
						// -> Beenden
						MenueWahl = 4;
						hm_wahl(MenueWahl, spielen, bestenliste, steuerung, mitwirkende, beenden);
					}



					//Anklicken der Knoepfe
					if(Grafik.mouseY() < 0.35 + Hoehe && Grafik.mouseY() > 0.35 - Hoehe && Grafik.mousePressed()){
						while(Grafik.mousePressed()){}
						System.exit(1);		//Tschau

					}

					if(Grafik.mouseY() < 0.45 + Hoehe && Grafik.mouseY() > 0.45 - Hoehe && Grafik.mousePressed()){
						while(Grafik.mousePressed()){}
						init(Grafik, 4);	//Mitwirkende
					}

					if (Grafik.mouseY() < 0.55 + Hoehe && Grafik.mouseY() > 0.55 - Hoehe && Grafik.mousePressed()){
						while(Grafik.mousePressed()){}
							init(Grafik, 3);	//Steuerung
					}

					if (Grafik.mouseY() < 0.65 + Hoehe && Grafik.mouseY() > 0.65 - Hoehe && Grafik.mousePressed()){
						while(Grafik.mousePressed()){}
							init(Grafik, 2);	//Bestenliste
					}

					if (Grafik.mouseY() < 0.75 + Hoehe && Grafik.mouseY() > 0.75 - Hoehe && Grafik.mousePressed()){
						while(Grafik.mousePressed()){}
							init(Grafik, 1);	//Spielen
					}
				}

				//Tastensteuerung
				if(Grafik.isKeyPressed(40)){
					//runter
					if(MenueWahl >= 4) MenueWahl = 4;
						MenueWahl++;
						hm_wahl(MenueWahl, spielen, bestenliste, steuerung, mitwirkende, beenden);
						Grafik.show(20);
						while(Grafik.isKeyPressed(40)){}
					}

				if(Grafik.isKeyPressed(38)){
					//rauf
					if (MenueWahl <= 0) MenueWahl = 0;
					MenueWahl--;
					hm_wahl(MenueWahl, spielen, bestenliste, steuerung, mitwirkende, beenden);
					Grafik.show(20);
					while(Grafik.isKeyPressed(38)){};
				}
			
				//Enter	(13)
				if(Grafik.isKeyPressed(13)){
					System.out.println("Enter");
					switch(MenueWahl){
						case 0:	/* Spiel */ break;
						case 1:	/* */	break;
						case 2:		break;
						case 3:		break;
						case 4:	System.exit(1);	
					}
				}
				//Tab (9)
				if(Grafik.isKeyPressed(9) && (Grafik.isKeyPressed(16) == false)){
					System.out.println("Tab");
					MenueWahl++;
					if(MenueWahl > 4) MenueWahl = 0;
					hm_wahl(MenueWahl, spielen, bestenliste, steuerung, mitwirkende, beenden);
				}
				//Shift+Tab
				if(Grafik.isKeyPressed(16)){
					if(Grafik.isKeyPressed(9)){
						MenueWahl--;
						if(MenueWahl < 0) MenueWahl = 4;
						hm_wahl(MenueWahl, spielen, bestenliste, steuerung, mitwirkende, beenden);
					}
				}
				Grafik.show(20);

			}
		}
		else if(Modus == 1){
			//Spielen
			Grafik.clear();
			Grafik.setFont(Ueberschrift);
			Grafik.text(0.5, 0.9, "Tetris", 0);
			Grafik.setFont();
			Game Spiel = new Game();
			Board brett = Spiel.getBoard();
			Dimension dim = brett.getDimension();
			if (dim.getWidth() > dim.getHeight()) System.out.println("Breite groesser als Hoeher! Kann grapfische Fehler verursachen!");
			//setXscale	setYscale
			Grafik.setXscale(0, 400);
			Grafik.setYscale(0,585);
			zeichneRaster(Grafik, (int) dim.getWidth(), (int) dim.getHeight());
//			Grafik.square(200, 292.5, 50);
			Grafik.show(20);

			while(true){

			}
		}
		else if(Modus == 2){
			//Bestenliste
			Grafik.clear();
			Grafik.setFont(Ueberschrift);
			Grafik.text(0.5, 0.9, "Tetris", 0);
			Grafik.setFont(new Font("SANS_SERIF", 0, 20));
			Grafik.text(0.5, 0.7, "Bestenliste");
			Grafik.setFont();
			System.out.println("Highscore");
			Highscore hs = new Highscore("highscore.dat");
			Score[] hss = hs.getTop(10);
			for (int i=0; i<hss.length; i++){
				Grafik.text(0.25, (0.65-0.025*i), Integer.toString(i+1));
				Grafik.textLeft(0.3, (0.65-0.025*i), hss[i].getUsername());
				Grafik.textLeft(0.75, (0.65-0.025*i), Integer.toString(hss[i].getScore()));
			}
			Knopf hm3 = new Knopf("Hauptmenü", 0.5, 0.2, 0.25, 0.025, Grafik);
			hm3.zeichneAn();

			Grafik.show(20);

			while(true){
				if(Grafik.mouseX() > 0.25 && Grafik.mouseX() < 0.75 && Grafik.mouseY() > 0.175 && Grafik.mouseY() < 0.225 && Grafik.mousePressed()) break;
			}
		}
		else if(Modus == 3){
			//Steuerung
			Grafik.clear();
			Grafik.setFont(Ueberschrift);
			Grafik.text(0.5, 0.9, "Tetris", 0);
			Grafik.setFont(new Font("SANS_SERIF", 0, 20));
			Grafik.text(0.5, 0.7, "Steuerung");
			Grafik.setFont();
			Grafik.textLeft(0.1, 0.6, "Stein nach links");
			Grafik.textLeft(0.55, 0.6, "Pfeil links oder A");
			Grafik.textLeft(0.1, 0.575, "Stein nach rechts");
			Grafik.textLeft(0.55, 0.575, "Pfeil rechts oder D");
			Grafik.textLeft(0.1, 0.55, "Stein schneller");
			Grafik.textLeft(0.55, 0.55, "Pfeil runter oder S");
			Grafik.textLeft(0.1, 0.525, "Stein langsamer");
			Grafik.textLeft(0.55, 0.525, "Pfeil hoch oder W");
			Grafik.textLeft(0.1, 0.5, "Stein drehen");
			Grafik.textLeft(0.55, 0.5, "Leertaste");

			Knopf hm2 = new Knopf("Hauptmenü", 0.5, 0.2, 0.25, 0.025, Grafik);
			hm2.zeichneAn();

			Grafik.show(20);
			while(true){
				if(Grafik.mouseX() > 0.25 && Grafik.mouseX() < 0.75 && Grafik.mouseY() > 0.175 && Grafik.mouseY() < 0.225 && Grafik.mousePressed()) break;
			}
		}
		else if(Modus == 4){
			//Mitwirkende
			Grafik.clear();
			Grafik.setFont(Ueberschrift);
			Grafik.text(0.5, 0.9, "Tetris", 0);
			Grafik.setFont();

			Grafik.text(0.5, 0.6, "Tetris");
			Grafik.text(0.5, 0.55, "Erstellt von:");
			Grafik.text(0.5, 0.525, "mamazu1995");
			Grafik.text(0.5, 0.5, "Sigma5000");
			Grafik.text(0.5, 0.45, "Inhalte Dritter:");
			Grafik.text(0.5, 0.425, "stdlib: http://introcs.cs.princeton.edu/java/stdlib/");
			Grafik.text(0.5, 0.3, "Sieh dir den Quellcode an:");
			Grafik.text(0.5, 0.275, "https://github.com/mamazu/Tetris/");

			Knopf hm = new Knopf("Hauptmenü", 0.5, 0.2, 0.25, 0.025, Grafik);
			hm.zeichneAn();
			Grafik.show(20);

			while(true){
				if(Grafik.mouseX() > 0.25 && Grafik.mouseX() < 0.75 && Grafik.mouseY() > 0.175 && Grafik.mouseY() < 0.225 && Grafik.mousePressed()) break;
			}
		}
		else{
			throw new IllegalArgumentException("Unbekannter GUI-Modus");
		}

	}

	public static void main(String[] args){

		if (args.length == 1 && args[0].equals("cli")) {
			Game g = new Game();
            System.out.print(g.board);
            System.out.println("Next stone is: " + g.getNext());
            System.out.println("Next pattern is: \n" + g.getNext().getPatternString());
            return;
        }

        //Einrichten der grapfischen Ausgabe
		Draw Grafik = new Draw("Tetris");
		Grafik.setCanvasSize(400, 585);	//400 700

		//GUI-Modus
		int GUI = 0;

		init(Grafik, 0);

		//while true-Schleife

		/*
		while (true){
			if (Grafik.isKeyPressed(37)){
				System.out.println("Pfeil links");
			}

		}
		*/

	}
}