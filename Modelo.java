package mx.com.cursodia.jse18.mod2.semana1.tarea;

public class Modelo 
{

	public void CrearJuguete(InsertarVista IV) 
	{
		String Id = IV.txtId.getText();
		String Nombre = IV.txtNombre.getText();
		String Precio = IV.txtPrecio.getText();
		System.out.println(Id);
		System.out.println(Nombre);
		System.out.println(Precio);
		
		
	}
}
