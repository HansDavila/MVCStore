package mx.com.cursodia.jse18.mod2.semana1.tarea;



import interfaces_apoyo.EngineRouteFilter;
import jugueteria.Juguete;
import tienda.TIENDA;


public class Modelo 
{

	//Objeto de libreria que se encarga del manejo de la base de datos
	
	EngineRouteFilter<Juguete> ER = new TIENDA<Juguete>(Juguete.class);
	
	
	public Modelo() 
	{
		//METODO Que recibe strings con los objetos del archivo de texto y los convierte en objetos juguetes
		//J.imprimirURL();
		System.out.println("\nConectando...");
		ER.readRegistrosFile();
		System.out.println("\nElementos leidos!");
		
		
	}
	
	Juguete getJuguete(int index) 
	{
		return ER.getItem(index);
	}
	
	
	//Se devuelve el ultimo elemento de los registros	
	Juguete getLastToy() 
	{
		
		return ER.getLastItem();
	}
	

	//Obtener el tamaño de Registros
	int getRegistrosSize() 
	{
		return ER.getRegistrosSize();
	}
	
	
	//Obtener el index del juguete obtenido
	int getIndexOf(Juguete jug) 
	{
		return ER.getIndexOf(jug);
	}
	
	
	//Obtener el index mediante el id
	int getIndexByID(int id) 
	{
		return ER.getIndexByID(id);
	}
	
	
	//Verificar si el ArrayList Registros dentro de la libreria esta vacio
	boolean isRegistrosEmpty() 
	{
		return ER.isRegistrosEmpty();
	}
	
	//Agregar juguetes del Arraylist Registros
	void addToy(Juguete toy) 
	{
		ER.addItem(toy);
	}
	
	
	//Muestra impresion de los juguetes en consola
	void recorrerRegistro() 
	{	
		ER.readItems();	
	}
	
	
	//Modificar juguetes del Arraylist Registros
	void modifyToy(int index, Juguete modifiedToy) 
	{
		ER.modifyItem(index, modifiedToy);
	}
	
	
	//Eliminar juguetes del Arraylist Registros 
	void deleteToy(int index) 
	{
		ER.deleteItem(index);
	}
	
	
	//Modifica el archivo de txt con los registros actuales
	public void updateRegistroFile() 
	{
		ER.updateRegistroFile();
	}
	
}
	
