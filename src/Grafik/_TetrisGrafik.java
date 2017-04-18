import java.awt.Font;

public class _TetrisGrafik{

	public static void init(Draw Grafik, int Modus){
		if(Modus == 0){
			//Var
			int MenueWahl = 0;
			//Hauptmenue

			double Breite = 0.25;
			double Hoehe = 0.025;

			//Fonts
			Font Ueberschrift = new Font("SANS_SERIF", 0, 64);

			//Erzeuge Menuepunkte
			Grafik.setFont(Ueberschrift);
			Grafik.text(0.5, 0.9, "Tetris", 0);		//x,y,Text,deg
			//Grafik.line(0.25, 0.25, 0.75, 0.75);
			Grafik.setPenColor(Draw.GREEN);
			Grafik.filledRectangle(0.5, 0.75, Breite, Hoehe);
			Grafik.setPenColor();
			Grafik.rectangle(0.5, 0.75, Breite, Hoehe);
			Grafik.setFont();
			Grafik.text(0.5, 0.75, "Spielen", 0);
			Grafik.rectangle(0.5, 0.65, Breite, Hoehe);
			Grafik.text(0.5, 0.65, "Bestenliste");
			Grafik.rectangle(0.5, 0.55, Breite, Hoehe);
			Grafik.text(0.5, 0.55, "Steuerung");
			Grafik.rectangle(0.5, 0.45, Breite, Hoehe);
			Grafik.text(0.5, 0.45, "Mitwirkende");
			Grafik.rectangle(0.5, 0.35, Breite, Hoehe);
			Grafik.text(0.5, 0.35, "Beenden");
			
			//
			while (true){
				if(Grafik.mouseX() > 0.5 - Breite && Grafik.mouseX() < 0.5 + Breite){
					if (Grafik.mouseY() < 0.75 + Hoehe && Grafik.mouseY() > 0.75 - Hoehe && MenueWahl != 0){
						// -> Spielen
						MenueWahl = 0;
						Grafik.setPenColor(Draw.GREEN);
						Grafik.filledRectangle(0.5, 0.75, Breite, Hoehe);
						Grafik.setPenColor(Draw.WHITE);
						Grafik.filledRectangle(0.5, 0.65, Breite, Hoehe);
						Grafik.filledRectangle(0.5, 0.55, Breite, Hoehe);
						Grafik.filledRectangle(0.5, 0.45, Breite, Hoehe);
						Grafik.filledRectangle(0.5, 0.35, Breite, Hoehe);

						Grafik.setPenColor();
						Grafik.rectangle(0.5, 0.75, Breite, Hoehe);
						Grafik.setFont();
						Grafik.text(0.5, 0.75, "Spielen", 0);
						Grafik.rectangle(0.5, 0.65, Breite, Hoehe);
						Grafik.text(0.5, 0.65, "Bestenliste");
						Grafik.rectangle(0.5, 0.55, Breite, Hoehe);
						Grafik.text(0.5, 0.55, "Steuerung");
						Grafik.rectangle(0.5, 0.45, Breite, Hoehe);
						Grafik.text(0.5, 0.45, "Mitwirkende");
						Grafik.rectangle(0.5, 0.35, Breite, Hoehe);
						Grafik.text(0.5, 0.35, "Beenden");
					}


					if (Grafik.mouseY() < 0.65 + Hoehe && Grafik.mouseY() > 0.65 - Hoehe && MenueWahl != 1){
						// -> Bestenliste
						MenueWahl = 1;
						Grafik.setPenColor(Draw.GREEN);
						Grafik.filledRectangle(0.5, 0.65, Breite, Hoehe);
						Grafik.setPenColor(Draw.WHITE);
						Grafik.filledRectangle(0.5, 0.75, Breite, Hoehe);
						Grafik.filledRectangle(0.5, 0.55, Breite, Hoehe);
						Grafik.filledRectangle(0.5, 0.45, Breite, Hoehe);
						Grafik.filledRectangle(0.5, 0.35, Breite, Hoehe);
						
						Grafik.setPenColor();
						Grafik.rectangle(0.5, 0.75, Breite, Hoehe);
						Grafik.setFont();
						Grafik.text(0.5, 0.75, "Spielen", 0);
						Grafik.rectangle(0.5, 0.65, Breite, Hoehe);
						Grafik.text(0.5, 0.65, "Bestenliste");
						Grafik.rectangle(0.5, 0.55, Breite, Hoehe);
						Grafik.text(0.5, 0.55, "Steuerung");
						Grafik.rectangle(0.5, 0.45, Breite, Hoehe);
						Grafik.text(0.5, 0.45, "Mitwirkende");
						Grafik.rectangle(0.5, 0.35, Breite, Hoehe);
						Grafik.text(0.5, 0.35, "Beenden");
					}
					if (Grafik.mouseY() < 0.55 + Hoehe && Grafik.mouseY() > 0.55 - Hoehe && MenueWahl != 2){
						// -> Steuerung
						MenueWahl = 2;
						Grafik.setPenColor(Draw.GREEN);
						Grafik.filledRectangle(0.5, 0.55, Breite, Hoehe);
						Grafik.setPenColor(Draw.WHITE);
						Grafik.filledRectangle(0.5, 0.65, Breite, Hoehe);
						Grafik.filledRectangle(0.5, 0.75, Breite, Hoehe);
						Grafik.filledRectangle(0.5, 0.45, Breite, Hoehe);
						Grafik.filledRectangle(0.5, 0.35, Breite, Hoehe);
						
						Grafik.setPenColor();
						Grafik.rectangle(0.5, 0.75, Breite, Hoehe);
						Grafik.setFont();
						Grafik.text(0.5, 0.75, "Spielen", 0);
						Grafik.rectangle(0.5, 0.65, Breite, Hoehe);
						Grafik.text(0.5, 0.65, "Bestenliste");
						Grafik.rectangle(0.5, 0.55, Breite, Hoehe);
						Grafik.text(0.5, 0.55, "Steuerung");
						Grafik.rectangle(0.5, 0.45, Breite, Hoehe);
						Grafik.text(0.5, 0.45, "Mitwirkende");
						Grafik.rectangle(0.5, 0.35, Breite, Hoehe);
						Grafik.text(0.5, 0.35, "Beenden");
					}
					if (Grafik.mouseY() < 0.45 + Hoehe && Grafik.mouseY() > 0.45 - Hoehe && MenueWahl != 3){
						// -> Mitwirkende
						MenueWahl = 3;
						Grafik.setPenColor(Draw.GREEN);
						Grafik.filledRectangle(0.5, 0.45, Breite, Hoehe);
						Grafik.setPenColor(Draw.WHITE);
						Grafik.filledRectangle(0.5, 0.65, Breite, Hoehe);
						Grafik.filledRectangle(0.5, 0.55, Breite, Hoehe);
						Grafik.filledRectangle(0.5, 0.75, Breite, Hoehe);
						Grafik.filledRectangle(0.5, 0.35, Breite, Hoehe);
						
						Grafik.setPenColor();
						Grafik.rectangle(0.5, 0.75, Breite, Hoehe);
						Grafik.setFont();
						Grafik.text(0.5, 0.75, "Spielen", 0);
						Grafik.rectangle(0.5, 0.65, Breite, Hoehe);
						Grafik.text(0.5, 0.65, "Bestenliste");
						Grafik.rectangle(0.5, 0.55, Breite, Hoehe);
						Grafik.text(0.5, 0.55, "Steuerung");
						Grafik.rectangle(0.5, 0.45, Breite, Hoehe);
						Grafik.text(0.5, 0.45, "Mitwirkende");
						Grafik.rectangle(0.5, 0.35, Breite, Hoehe);
						Grafik.text(0.5, 0.35, "Beenden");
					}
					if (Grafik.mouseY() < 0.35 + Hoehe && Grafik.mouseY() > 0.35 - Hoehe && MenueWahl != 4){
						// -> Beenden
						MenueWahl = 4;
						Grafik.setPenColor(Draw.GREEN);
						Grafik.filledRectangle(0.5, 0.35, Breite, Hoehe);
						Grafik.setPenColor(Draw.WHITE);
						Grafik.filledRectangle(0.5, 0.65, Breite, Hoehe);
						Grafik.filledRectangle(0.5, 0.55, Breite, Hoehe);
						Grafik.filledRectangle(0.5, 0.45, Breite, Hoehe);
						Grafik.filledRectangle(0.5, 0.75, Breite, Hoehe);
						
						Grafik.setPenColor();
						Grafik.rectangle(0.5, 0.75, Breite, Hoehe);
						Grafik.setFont();
						Grafik.text(0.5, 0.75, "Spielen", 0);
						Grafik.rectangle(0.5, 0.65, Breite, Hoehe);
						Grafik.text(0.5, 0.65, "Bestenliste");
						Grafik.rectangle(0.5, 0.55, Breite, Hoehe);
						Grafik.text(0.5, 0.55, "Steuerung");
						Grafik.rectangle(0.5, 0.45, Breite, Hoehe);
						Grafik.text(0.5, 0.45, "Mitwirkende");
						Grafik.rectangle(0.5, 0.35, Breite, Hoehe);
						Grafik.text(0.5, 0.35, "Geh nicht! :'(");
					}

					if(Grafik.mouseY() < 0.35 + Hoehe && Grafik.mouseY() > 0.35 - Hoehe && Grafik.mousePressed()){
						while(Grafik.mousePressed()){}

					}
				}
			}
		}
		else if(Modus == 1){
			//Spielen
		}
		else if(Modus == 2){
			//Bestenliste
		}
		else if(Modus == 3){
			//Steuerung
		}
		else if(Modus == 4){
			//Mitwirkende
		}
		else{
			System.out.println("unbekannter GUI-Modus");
		}

	}

	public static void main(String[] args){
		Draw Grafik = new Draw("Tetris");
		Grafik.setCanvasSize(400, 700);

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