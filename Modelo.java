package mx.com.cursodia.jse18.mod2.semana1.tarea;

import java.util.ArrayList;

import recursos.TextEngine;


public class Modelo 
{

	//Objeto de libreria que se encarga del manejo de la base de datos
	Jugueteria J = new Jugueteria();

	
	public Modelo() 
	{
		//METODO Que recibe strings con los objetos del archivo de texto y los convierte en objetos juguetes
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
		J.recorrerRegistro();
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