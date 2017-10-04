import java.awt.*;
import java.awt.Component.*;
import javax.swing.*;
import java.awt.image.*;

public class Fenster_test extends Canvas{
	private int scale = 3;
	private int width = 300;
	private int height = width / 16 * 9;
	private JFrame frame;


	public Fenster_test(){
		Dimension size = new Dimension(width*scale, height*scale);
		setPreferredSize(size);
	}

	public int getWidth(){
		return width * scale;
	}

	public int getHeight(){
		return height * scale;
	}

	public void render(){
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());

		g.dispose();
		bs.show();
	}

	public static void main(String[] args){	
		Fenster_test x = new Fenster_test();

		x.frame = new JFrame();
		x.frame.setResizable(false);
		x.frame.setTitle("Test");
		x.frame.add(x);
		x.frame.pack();
		x.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		x.frame.setLocationRelativeTo(null);
		x.frame.setVisible(true);


		while(true){
			x.render();
			System.out.println("Jay.....");
		}
	}
} 
