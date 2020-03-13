package main;

import java.util.ArrayList;

import comm.ComunicacionTCP;
import processing.core.PApplet;

public class Main extends PApplet{
	
	ComunicacionTCP comm;
	ArrayList<Figura>figures;

	public static void main(String[] args) {
		PApplet.main("main.Main");

	}
	
	public void settings() {
		size(500,500);
	}
	
	public void setup() {
		comm= new ComunicacionTCP(this);
		comm.esperarConexion();
		figures=new ArrayList<Figura>();
	}
	
	public void draw() {
		background(255);
		
			for (int i = 0; i < figures.size(); i++) {
					figures.get(i).pintar(this);
			}
		
	}

	public ArrayList<Figura> getFigures() {
		return figures;
	}

	public void setFigures(ArrayList<Figura> figures) {
		this.figures = figures;
	}
	
	

}
