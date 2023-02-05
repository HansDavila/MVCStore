package mx.com.cursodia.jse18.mod2.semana1.tarea;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import mx.com.cursodia.jse18.mod1.diagnostico.pruebas.Archivero;

public class TextEngine 
{
	File f;
	FileWriter w;
	BufferedWriter bw;
	PrintWriter wr;
	Archivero A = new Archivero();
	
	String fileName = "Registros.txt";
	String route = "./Files/toyStore/";
	String folderRoute = "Files/toyStore";

	private int cont = 0;
	
	
	//CONSTRUCTOR
	
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
		route += fileName;
		
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
	
	void writeData(Juguete toy) 
	{
		System.out.println("Entrando en TE");
		try {
			
			
			f = new File(route);
			w = new FileWriter(f, true);
			bw = new BufferedWriter(w);
			wr = new PrintWriter(bw);
				
			
			wr.write(toy.getId_jug() + "," + toy.getNom_jug() + "," + toy.getPre_jug() + "," + toy.getMarc_jug() + "," + toy.getCatg_jug() + "," +  toy.getStock()  +"\n");
			
			
						
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