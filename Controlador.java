package mx.com.cursodia.jse18.mod2.semana1.tarea;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import mx.com.cursodia.jse18.mod1.semana3.Articulo;

public class Controlador implements ActionListener {

	ArrayList<Juguete> Registros = new ArrayList<Juguete>();
	Vista V;
	InsertarVista IV;
	VistaRegistro VR;
	Modelo M;
	
	int indexInicio = 0;
	int indexFin;
	int pos = 0;
	boolean band = false;
	
	
	public Controlador(Vista V, InsertarVista IV, VistaRegistro VR, Modelo M)
	{
		this.V = V;
		this.IV = IV;
		this.M = M;
		this.VR = VR;
		
		this.V.lanzarGUI();
		this.IV.lanzarGUI();
		this.VR.lanzarGUI();
		
		createToys();
		
		Escuchadores();
	}
	
	private void Escuchadores() 
	{
		
		try {
			Thread.sleep(350);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		IV.setDefaultCloseOperation(IV.DISPOSE_ON_CLOSE);
		VR.setDefaultCloseOperation(VR.DISPOSE_ON_CLOSE);
		
		
		V.btnNuevo.addActionListener(this);
		V.btnRegistros.addActionListener(this);
		V.btnEliminar.addActionListener(this);
		
		IV.btnCrear.addActionListener(this);
		IV.btnCerrarIV.addActionListener(this);
		
		VR.btnPrimer.addActionListener(this);
		VR.btnSiguiente.addActionListener(this);
		VR.btnAnterior.addActionListener(this);
		VR.btnUltimo.addActionListener(this);
		VR.btnCerrarVR.addActionListener(this);
		
		VR.btnModificar.addActionListener(this);
		VR.btnGuardar.addActionListener(this);
		VR.btnEliminar.addActionListener(this);
		
		
		/*
		V1.btnLimpiar.addActionListener(this);
		V1.btnSalir.addActionListener(this);
		V1.btnVistaSumar.addActionListener(this);	
		*/	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == V.btnNuevo) 
		{
			//JOptionPane.showMessageDialog(V, "presionaste el boton de Nuevo Juguete");
			IV.vaciarCamposVI();
			IV.setVisible(true);

		}else if(e.getSource() == V.btnRegistros)
		{
			//Si los registros estan vacios...
			if(Registros.isEmpty()) 
			{
				JOptionPane.showMessageDialog(V, "No hay registros de juguetes");
				
			}else {
				//Se abre ventana VR y se muestra el primer registro
				VR.setVisible(true);
								
				indexFin = Registros.size() - 1;
										
				VR.fillFields(Registros.get(pos));
			}
			
		}else if(e.getSource() == V.btnEliminar) 
		{
			JOptionPane.showMessageDialog(V, "presionaste el boton de eliminar juguete");
			
		}else if(e.getSource() == IV.btnCrear) 
		{
			//Se verifica que no se tengan campos vacios
			if(VerificarIV()) 
			{
				int Id = Integer.parseInt(IV.txtId.getText());
				String Nombre = IV.txtNombre.getText();
				float Precio = Float.parseFloat(IV.txtPrecio.getText());
				String Marca = IV.txtMarca.getText();
				String Categoria = IV.txtCategoria.getText();
				int Stock = Integer.parseInt(IV.txtStock.getText());
												
				Registros.add(new Juguete(Id, Nombre, Precio, Marca, Categoria, Stock));
				
				JOptionPane.showMessageDialog(IV, "Juguete Agregado");
				indexFin = Registros.size() - 1;
				
				IV.dispose();				
			}
			
		}else if(e.getSource() == IV.btnCerrarIV) 
		{
			IV.dispose();
			
		}else if(e.getSource() == VR.btnAnterior) 
		{
			if(pos == 0) 
			{
				//Si la posicion es la unica que existe
				if (pos == indexFin) 
				{
					//No hacer nada
				}else 
				{
					//el elemento pasa a la ultima posicion
					pos = indexFin;					
					VR.fillFields(Registros.get(pos));
				}
			}else 
			{
				//Caso normal se cambia la posicion a la anterior
				pos--;
			
				VR.fillFields(Registros.get(pos));
			}
			
		}
		else if(e.getSource() == VR.btnSiguiente) 
		{
			if(pos == indexFin) 
			{
				//Si solo existe un elemento
				if (Registros.size() == 1) 
				{
					//No hacer nada
				}else 
				{
					//el elemento pasa a la ultima posicion
					pos = 0;					
					VR.fillFields(Registros.get(pos));
				}
			}else 
			{
				//Caso normal, solo se aumenta la posicion 
				pos++;
				
				VR.fillFields(Registros.get(pos));
			}
			
		}else if(e.getSource() == VR.btnPrimer) 
		{
			pos = 0;
			VR.fillFields(Registros.get(pos));
		}
		else if(e.getSource() == VR.btnUltimo) 
		{
			pos = indexFin;
			VR.fillFields(Registros.get(pos));
		}else if(e.getSource() == VR.btnCerrarVR) 
		{
			VR.dispose();
			System.out.println("Se presiono cerrar");
		}
		else if(e.getSource() == VR.btnModificar) 
		{
			if(!band) 
			{
				VR.btnGuardar.setEnabled(true);
				VR.turnedGreen(VR.btnGuardar);
				VR.turnedBlack(VR.btnModificar);
				VR.blockMoveButtons();
								
				VR.freeFields();
				
				band = true;
			}else if(band)
			{
				VR.btnGuardar.setEnabled(false);
				VR.turnedBlack(VR.btnGuardar);
				VR.turnedOrange(VR.btnModificar);
				VR.freeMoveButtons();
				band = false;
			}
			
		}
		else if(e.getSource() == VR.btnGuardar) 
		{
			int id = Integer.parseInt(VR.txtId.getText());
			int posicion = 0;			
			
			for (Juguete Toy : Registros) {

				if (Toy.getId_jug() == id) {
					posicion = Registros.indexOf(Toy);
				}
			}
			
			
			
			Juguete jug;
			
			int Id = Integer.parseInt(VR.txtId.getText());
			String Nombre = VR.txtNombre.getText();
			float Precio = Float.parseFloat(VR.txtPrecio.getText());
			String Marca = VR.txtMarca.getText();
			String Categoria = VR.txtCategoria.getText();
			int Stock = Integer.parseInt(VR.txtStock.getText());
										
			jug = new Juguete(Id, Nombre, Precio, Marca, Categoria, Stock);
			
			Registros.set(posicion, jug);
			
			JOptionPane.showMessageDialog(IV, "Juguete Modificado");
			
			VR.turnedBlack(VR.btnGuardar);
			VR.btnGuardar.setEnabled(false);
			
			VR.freeMoveButtons();
			VR.blockFields();
			
			VR.turnedOrange(VR.btnModificar);
		}
		else if(e.getSource() == VR.btnEliminar) 
		{
			int id = Integer.parseInt(VR.txtId.getText());
			int posicion = 0;			
			
			for (Juguete Toy : Registros) {

				if (Toy.getId_jug() == id) {
					posicion = Registros.indexOf(Toy);
				}
			}
			

			//QUEDA PENDIENTE BORRARLO
			//PENDIENTE CHECAR QUE BORRE
			//PENDIENTE QUE CAMBIEN LOS COLORES
			//PENDIENTE DE PONERLO EN LA PRIMERA POSICION
			Registros.remove(posicion);
			
			JOptionPane.showMessageDialog(IV, "Juguete Borrado");
			
			VR.turnedBlack(VR.btnGuardar);
			VR.btnGuardar.setEnabled(false);
			
			VR.freeMoveButtons();
			VR.blockFields();
			
			VR.turnedOrange(VR.btnModificar);
		}
		
	}
	
	
	
	public boolean VerificarIV() 
	{
		boolean bandera = true;
		if( IV.txtId.getText().isEmpty() ) 
		{
			System.out.println("Campo ID vacio");
			JOptionPane.showMessageDialog(IV, "Campo ID esta vacio");
			bandera = false;
			
		}else if( IV.txtNombre.getText().isEmpty() ) {
			System.out.println("Campo Nombre vacio");			
			JOptionPane.showMessageDialog(IV, "Campo Nombre esta vacio");
			bandera = false;
			
		}else if( IV.txtPrecio.getText().isEmpty()) 
		{
			System.out.println("Campo Precio vacio");			
			JOptionPane.showMessageDialog(IV, "Campo Precio esta vacio");
			bandera = false;
			
		}else if( IV.txtMarca.getText().isEmpty()) 
		{
			System.out.println("Campo Marca vacio");			
			JOptionPane.showMessageDialog(IV, "Campo Marca esta vacio");
			bandera = false;
			
		}
		else if( IV.txtCategoria.getText().isEmpty()) 
		{
			System.out.println("Campo Categoria vacio");			
			JOptionPane.showMessageDialog(IV, "Campo Categoria esta vacio");
			bandera = false;
			
		}else if( IV.txtStock.getText().isEmpty()) 
		{
			System.out.println("Campo Stock vacio");			
			JOptionPane.showMessageDialog(IV, "Campo Stock esta vacio");
			bandera = false;
		}
		
		return bandera;
	}
	
	
	
	public void createToys() 
	{
		Registros.add(new Juguete(1, "Pelota", 100, "MexiToys", "Basico", 100));
		Registros.add(new Juguete(2, "Transformer", 600, "Hasbro", "Accion", 20));
		Registros.add(new Juguete(3, "Barbie", 600, "Matel", "Muñeca", 40));
	}
	
	
	
	
	
	

}
