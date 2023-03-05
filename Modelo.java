package mx.com.cursodia.jse18.mod2.semana1.tarea;


import interfacesEngine.FiltroEngineRoute;
import jugueteria.Juguete;
import jugueteria.Jugueteria;

public class Modelo 
{

	//Objeto de libreria que se encarga del manejo de la base de datos
	FiltroEngineRoute J = new Jugueteria();
	
	
	public Modelo() 
	{
		//METODO Que recibe strings con los objetos del archivo de texto y los convierte en objetos juguetes
		//J.imprimirURL();
		System.out.println("\nConectando...");
		J.readRegistrosFile();
		System.out.println("\nElementos leidos!");
		
		
	}
	
	Juguete getJuguete(int index) 
	{
		return J.getJuguete(index);
	}
	
	
	//Se devuelve el ultimo elemento de los registros	
	Juguete getLastToy() 
	{
		
		return J.getLastToy();
	}
	

	//Obtener el tamaño de Registros
	int getRegistrosSize() 
	{
		return J.getRegistrosSize();
	}
	
	
	//Obtener el index del juguete obtenido
	int getIndexOf(Juguete jug) 
	{
		return J.getIndexOf(jug);
	}
	
	
	//Obtener el index mediante el id
	int getIndexByID(int id) 
	{
		return J.getIndexByID(id);
	}
	
	
	//Verificar si el ArrayList Registros dentro de la libreria esta vacio
	boolean isRegistrosEmpty() 
	{
		return J.isRegistrosEmpty();
	}
	
	//Agregar juguetes del Arraylist Registros
	void addToy(Juguete toy) 
	{
		J.addToy(toy);
	}
	
	
	//Muestra impresion de los juguetes en consola
	void recorrerRegistro() 
	{	
		J.readToys();	
	}
	
	
	//Modificar juguetes del Arraylist Registros
	void modifyToy(int index, Juguete modifiedToy) 
	{
		J.modifyToy(index, modifiedToy);
	}
	
	
	//Eliminar juguetes del Arraylist Registros 
	void deleteToy(int index) 
	{
		J.deleteToy(index);
	}
	
	
	//Modifica el archivo de txt con los registros actuales
	public void updateRegistroFile() 
	{
		J.updateRegistroFile();
	}
	
}
	
