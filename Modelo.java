package mx.com.cursodia.jse18.mod2.semana1.tarea;

import java.util.ArrayList;


public class Modelo 
{

	private ArrayList<Juguete> Registros = new ArrayList<Juguete>();
	
	
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
	}
	
	void modifyToy(int index, Juguete modifiedToy) 
	{
		Registros.set(index, modifiedToy);
	}
	
	void deleteToy(int index) 
	{
		Registros.remove(index);
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
*/