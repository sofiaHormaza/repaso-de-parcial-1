package main;

import processing.core.PApplet;

public class Figura {

	private int posX;
	private int posY;
	private String mensajes;
	private PApplet app;
	
	public Figura(PApplet app,int posX,int posY,String mensajes) {
		this.app=app;
		this.posX=posX;
		this.posY=posY;
		this.mensajes=mensajes;
	}
	
	public void pintar(PApplet app) {
		app.fill(255,0,0);
		app.ellipse(posX, posY, 50, 50);
		app.text(mensajes,posX,posY+50);
	}
}
