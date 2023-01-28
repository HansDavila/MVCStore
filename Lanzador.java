package mx.com.cursodia.jse18.mod2.semana1.tarea;

public class Lanzador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Modelo M = new Modelo();
		Vista V = new Vista();
		InsertarVista IV = new InsertarVista();		
		Controlador C = new Controlador(V,IV,M);

	}

}
