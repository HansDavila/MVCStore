package mx.com.cursodia.jse18.mod2.semana1.tarea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import mx.com.cursodia.jse18.mod1.diagnostico.pruebas.Archivero;

public class TextEngine 
{
	File f;
	FileWriter w;
	BufferedWriter bw;
	PrintWriter wr;
	Archivero A = new Archivero();
	
	String fileName;
	String route ;
	String folderRoute;

	private int cont = 0;
	
	
	//CONSTRUCTOR
	public TextEngine(String folderRoute, String route, String fileName) {
		this.fileName = fileName;
		this.route = route + fileName;
		this.folderRoute = folderRoute;
		
		
	}

	public boolean verifyFolder() 
	{
		if(A.isFolderEmpty(folderRoute)) {
			System.out.println("Folder is empty");
			return true;
		}else {
			System.out.println("Folder is not empty");
			return false;
		}
	}
	public void createFile() 
	{

		//Se escribe secuencia de numeros en el archivo de texto
		try {
					
		f = new File(route);
		w = new FileWriter(f);
		bw = new BufferedWriter(w);
		wr = new PrintWriter(bw);
				
		wr.close();
		bw.close();
					
					
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Ha sucedido un error: " + e);
		}
		
	}
	
	void writeData(Object item) 
	{
		System.out.println("Entrando en TE");
		
		try {
			
			
			f = new File(route);
			w = new FileWriter(f, true);
			bw = new BufferedWriter(w);
			wr = new PrintWriter(bw);
				
			
			wr.write(item.toString());
			
			
						
			wr.close();
			bw.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	ArrayList<String> readData() 
	{
		Path ruta = Paths.get(route);
		int cont = 0;
		ArrayList<String> lectura = new ArrayList<String>();

		// Validar ruta
		if (Files.exists(ruta)) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(route), "utf-8"));
				String linea = null;
				int i = 1;
				while ((linea = br.readLine()) != null) {

					lectura.add(linea);
					System.out.println(linea);
					System.out.println("");
					
				}
					i++;

				
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			JOptionPane.showMessageDialog(null, "Error! el archivo o ruta no existen!");		
			
		}
		return lectura;		
	}
	
	void writeNewData(Object item) 
	{
		System.out.println("Entrando en TE");
		
		try {
			
			
			f = new File(route);
			w = new FileWriter(f);
			bw = new BufferedWriter(w);
			wr = new PrintWriter(bw);
				
			
			wr.write(item.toString());
			
			
						
			wr.close();
			bw.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


/*
FileWriter fw = new FileWriter(filename,true); //the true will append the new data
fw.write("add a line\n");//appends the string to the file
fw.close();
*/