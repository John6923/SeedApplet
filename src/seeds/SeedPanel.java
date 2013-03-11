package seeds;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SeedPanel extends JPanel {
	private boolean display = false;
	private int seeds;
	private double angle;
	private Font font = new Font("Helvectica", Font.PLAIN, 12);
	private FontMetrics metr = getFontMetrics(font);
	private boolean modularColoring = false;
	private int modulo = 0;
	private Color[] colors;
	
	public SeedPanel(){
		setBackground(Color.white);
		genColors();
	}
	
	private void genColors(){
		colors = new Color[100];
		Random rand = new Random();
		for(int i = 0; i < 100; i++){
			Color color;
			while(true){
				color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
				if(!color.equals(Color.white) && !color.equals(Color.black)) break;
			}
			colors[i] = color;
		}
	}
	
	public void setSeeds(int numSeeds){
		if(numSeeds <= 0) display = false;
		else{
			display = true;
			seeds = numSeeds;
		}
	} 
	
	public void setAngle(double angle){
		if(angle == 0) display = false;
		else{
			display = true;
			this.angle = angle;
		}
	}
	
	public void setMod(int mod){
		if(mod <= 0) modularColoring = false;
		else{
			modularColoring = true;
			modulo = mod;
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(display){
			for(int i = 0; i < seeds; i++){
				drawCenteredTextAndCircle(g,getX(i),getY(i), i);
			}
		}
	}
	
	private void drawCenteredTextAndCircle(Graphics g, int x, int y, int i){
		g.setColor(getColor(i));
		g.fillOval(x-10, y - 10, 20, 20);
		g.setColor(Color.black);
		g.setFont(font);
		g.drawString(Integer.toString(i),x-metr.bytesWidth(Integer.toString(i).getBytes(), 0, Integer.toString(i).getBytes().length) / 2,y + 2);
	}
	
	private Color getColor(int i){
		if(modularColoring){
			return colors[i % modulo];
		}
		return Color.yellow;
	}
	
	private int getX(int i){
		return (int)((((double)i * (250 / (double) seeds)) * Math.cos(((((double)i * angle) % 1) * 2 * Math.PI))) + 250);
	}
	
	private int getY(int i){
		return (int)((((double)i * (250 / (double) seeds)) * Math.sin(((((double)i * angle) % 1) * 2 * Math.PI))) + 250);
	}

}
