package comm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import main.Figura;
import main.Main;
import processing.core.PApplet;


public class ComunicacionTCP extends Thread {

	private Socket socket;
	private BufferedReader reader;
	private BufferedWriter writer;
	private PApplet app;
	String line;
	Main main;
	
	public ComunicacionTCP(Main main) {
		this.main=main;
	}
	
	public void run() {
		try {
			ServerSocket server=new ServerSocket(5000);
			System.out.println("esperando");
			this.socket=server.accept();
			System.out.println("conexion aceptada");
			
			InputStream is=socket.getInputStream();
			InputStreamReader isr=new InputStreamReader(is);
			this.reader=new BufferedReader(isr);
			
			OutputStream os=socket.getOutputStream();
			OutputStreamWriter osw=new OutputStreamWriter(os);
			this.writer=new BufferedWriter(osw);
			
			while(true) {
				recibirMensaje();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void esperarConexion() {
		this.start();
	}
	
	public void mandarMensaje(String mensaje) {
		new Thread(
				()->{
					try {
						writer.write(mensaje+"\n");
						writer.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			).start();
	}
	
	public void recibirMensaje() throws IOException {
		line=reader.readLine();
		System.out.println(line);
		
		String[]info=line.split(":");
		int x=Integer.parseInt(info[0]);
		int y=Integer.parseInt(info[1]);
		String mensaj=info[2];
		
		main.getFigures().add(new Figura(app, x, y, mensaj));
	}
	
	
	
	public void cerrarConexion() {
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
