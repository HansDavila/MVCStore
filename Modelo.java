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
		J.readRegistrosFile();
		
	}
	
	Juguete getJuguete(int index) 
	{
		return J.getJuguete(index);
	}
	
	Juguete getLastToy() 
	{
		//Se devuelve el ultimo elemento de los registros	
		return J.getLastToy();
	}
	
	int getRegistrosSize() 
	{
		return J.getRegistrosSize();
	}
	
	int getIndexOf(Juguete jug) 
	{
		return J.getIndexOf(jug);
	}
	
	int getIndexByID(int id) 
	{
		return J.getIndexByID(id);
	}
	
	boolean isRegistrosEmpty() 
	{
		return J.isRegistrosEmpty();
	}
	
	void recorrerRegistro() 
	{
		J.readToys();
	}
	
	void modifyToy(int index, Juguete modifiedToy) 
	{
		J.modifyToy(index, modifiedToy);
	}
	
	void deleteToy(int index) 
	{
		J.deleteToy(index);
	}
	
	void addToy(Juguete toy) 
	{
		J.addToy(toy);
	}
	
	public void updateRegistroFile() 
	{
		J.updateRegistroFile();
	}
	

	
	
}

