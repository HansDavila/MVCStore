package mx.com.cursodia.jse18.mod2.semana1.tarea;

import java.util.ArrayList;


public class Modelo 
{

	//CAMPOS DE CLASE
	private ArrayList<Juguete> Registros = new ArrayList<Juguete>();
	
	private String fileName = "Registros.txt";
	private String route = "./Files/toyStore/";
	private String folderRoute = "Files/toyStore";
	
	private TextEngine TE = new TextEngine(folderRoute, route, fileName);
	
	
	public void createToys() 
	{
		Registros.add(new Juguete(1, "Pelota", 100, "MexiToys", "Basico", 100));
		Registros.add(new Juguete(2, "Transformer", 600, "Hasbro", "Accion", 20));
		Registros.add(new Juguete(3, "Barbie", 600, "Matel", "Muñeca", 40));
	}
	
	
	Juguete getJuguete(int index) 
	{
		return Registros.get(index);
	}
	
	Juguete getLastToy() 
	{
		//Se devuelve el ultimo elemento de los registros	
		return Registros.get(Registros.size() -1);
	}
	
	int getRegistrosSize() 
	{
		return Registros.size();
	}
	
	int getIndexOf(Juguete jug) 
	{
		return Registros.indexOf(jug);
	}
	
	int getIndexByID(int id) 
	{
		int posicion = -1;	
		
		for (Juguete Toy : Registros) {

			if (Toy.getId_jug() == id) {
				posicion = Registros.indexOf(Toy);
			}
		}
		
		return posicion;
	}
	
	boolean isRegistrosEmpty() 
	{
		if(Registros.isEmpty()) 
		{
			return true;
		}else {
			return false;
		}
	}
	
	void addToy(Juguete toy) 
	{
		Registros.add(toy);
		TE.writeData(toy);
	}
	
	void modifyToy(int index, Juguete modifiedToy) 
	{
		Registros.set(index, modifiedToy);
	}
	
	void deleteToy(int index) 
	{
		Registros.remove(index);
	}
	
	void recorrerRegistro() 
	{
		for(Juguete toy: Registros) 
		{
			int index = Registros.indexOf(toy);
			System.out.println("Index : " + index + "  -> Nombre: " + toy.getNom_jug());
		}
		System.out.println("\n");
	}
	
	void updateRegistroFile() 
	{
		TE.writeNewData("");
		for(Juguete toy: Registros) {
			TE.writeData(toy);
		}
	}
	
	
	
	//METODO Que recibe strings con los objetos del archivo de texto y los convierte en objetos juguetes
	void readRegistrosFile() {		
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
	
	void createFile() 
	{
		TE.createFile();
	}
	
	
	boolean verifyFolder() 
	{
		return TE.verifyFolder();
	}
	
	
	
}




/*
public static void main(String[] args) {
	ArrayList<Integer> list = new ArrayList<Integer>(5);
	 
    // using add() to initialize values
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);

    // printing initial value ArrayList
    System.out.print("ArrayList: " + list);

    // find first element
    int first = list.get(0);
    int second = list.get(1);
    int third = list.get(2);

    // find last element
    int last = list.get(list.size() - 1);

    // print first and last element of ArrayList
    System.out.println("\nFirst : " + first + " Second " + second + "Third" + third
                       + ", Last : " + last);
}



1,Pelota,100.0,MexiToys,Basico,100
2,Transformer,600.0,Hasbro,Accion,20
3,Barbie,600.0,Matel,Muñeca,40
4,Lego Batman,1200.0,Lego,Construccion,55

*/