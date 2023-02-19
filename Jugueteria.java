package mx.com.cursodia.jse18.mod2.semana1.tarea;

import java.util.ArrayList;


import recursos.TextEngine;

public class Jugueteria 
{
	
	//CAMPOS DE CLASE
	private ArrayList<Juguete> Registros = new ArrayList<Juguete>();
	
	/*
	private String fileName = "Registros.txt";
	private String route = "./BaseDeDatos";
	private String folderRoute = "BaseDeDatos";
	*/
	
	private String fileName = "Registros.txt";
	private String route = "./Files/toyStore/";
	private String folderRoute = "Files/toyStore";
	
	private TextEngine TE = new TextEngine(folderRoute, route, fileName);
	

	
	
	
	
	
	//--------------------METODOS--------------------//
	
	
	public Juguete getJuguete(int index) 
	{
		return Registros.get(index);
	}
	
	public Juguete getLastToy() 
	{
		//Se devuelve el ultimo elemento de los registros	
		return Registros.get(Registros.size() -1);
	}
	
	public int getRegistrosSize() 
	{
		return Registros.size();
	}
	
	public int getIndexOf(Juguete jug) 
	{
		return Registros.indexOf(jug);
	}
	
	public int getIndexByID(int id) 
	{
		int posicion = -1;	
		
		for (Juguete Toy : Registros) {

			if (Toy.getId_jug() == id) {
				posicion = Registros.indexOf(Toy);
			}
		}
		
		return posicion;
	}
	
	public boolean isRegistrosEmpty() 
	{
		if(Registros.isEmpty()) 
		{
			return true;
		}else {
			return false;
		}
	}
	
	public void recorrerRegistro() 
	{
		for(Juguete toy: Registros) 
		{
			int index = Registros.indexOf(toy);
			System.out.println("Index : " + index + "  -> Nombre: " + toy.getNom_jug());
		}
		System.out.println("\n");
	}
	
	public void modifyToy(int index, Juguete modifiedToy) 
	{
		Registros.set(index, modifiedToy);
		//updateRegistroFile();
	}
	
	public void deleteToy(int index) 
	{
		Registros.remove(index);
		//updateRegistroFile();
	}
	
	public void addToy(Juguete toy) 
	{
		Registros.add(toy);
		//TE.writeData(toy); //añadir juguete a jugueteria
	}
	

	//METODO Que recibe strings con los objetos del archivo de texto y los convierte en objetos juguetes
	public void readRegistrosFile() 
	{		
		ArrayList<String> lectura = TE.readData();
		int indexes[] = new int[lectura.size()];
		int i = 0;
			
		for(String line:lectura) {
			System.out.println("M -> " + line);
			if(line.equals("")) {
				
				i++;
			}
		}
			
						
		System.out.println(i);
						
			
		try {
				
			for(String item: lectura ) {
				if(i == 1) {
					i++;
				}else {
					String[] lineaActual = item.split(",");
					System.out.println("[A] -> " + item);
					//System.out.println("Añadido");
					Registros.add(new Juguete(Integer.parseInt(lineaActual[0]), lineaActual[1], Float.parseFloat(lineaActual[2]), lineaActual[3], lineaActual[4], Integer.parseInt(lineaActual[5])));
				}
					
			}
				
		} catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("File Vacio");
		}			
	}
	
	public void updateRegistroFile() 
	{
		TE.writeNewData("");
		for(Juguete toy: Registros) {
			TE.writeData(toy);
		}
	}
	
	
	public void createFile() 
	{
		TE.createFile();
	}
	
	//Checa si el folder esta vacio
	public boolean verifyFolder() 
	{
		return TE.verifyFolder();
	}

}