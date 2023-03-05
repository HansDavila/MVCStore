package mx.com.cursodia.jse18.mod2.semana1.tarea;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import jugueteria.Juguete;



public class Controlador implements ActionListener {

	//---------------------------CAMPOS DE CONTROLADOR---------------------------
	
	//Vistas
	Vista V;
	InsertarVista IV;
	VistaRegistro VR;
	
	//Modelo
	Modelo M;
	
	//Elemento juguete 
	Juguete Toy;
	
	//Variables para manejar la navegación de registros
	int indexInicio = 0;
	int indexFin;
	int indexActual;
	int pos = 0;
	boolean band = false;
	
	
	//---------------------------CONSTRUCTOR---------------------------
	public Controlador(Vista V, InsertarVista IV, VistaRegistro VR, Modelo M)
	{
		this.V = V;
		this.IV = IV;
		this.M = M;
		this.VR = VR;
		
		this.V.lanzarGUI();
		this.IV.lanzarGUI();
		this.VR.lanzarGUI();
		
		
		Escuchadores();

		
	}
	
	
	//---------------------------METODOS---------------------------
	
	//Metodo que agrega escuchadores a elementos de la vista
	private void Escuchadores() 
	{
	
		//Esperar a que todas las GUI's hayan finalizado de crearse
		while(V.ThreadV.isAlive() == true || VR.ThreadVR.isAlive() == true || IV.ThreadIV.isAlive() == true ) 
		{
			try {
				Thread.sleep(100);				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//Establecer que no se pueda cerrar la ventana a travez de los botones de la ventana
		IV.setDefaultCloseOperation(IV.DO_NOTHING_ON_CLOSE);
		VR.setDefaultCloseOperation(VR.DO_NOTHING_ON_CLOSE);
		
		
		//Agregando listeners a elementos de la vista
		V.btnNuevo.addActionListener(this);
		V.btnRegistros.addActionListener(this);
		V.btnEliminar.addActionListener(this);
		V.btnCerrarV.addActionListener(this);
		
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
		
		
	}

	
	//Metodo que manejara cuando se presione algun boton
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Si se preciona el boton para acceder a la vista Insertar...
		if(e.getSource() == V.btnNuevo) 
		{			
			vaciarCamposVI();
			IV.setVisible(true);

		} 
		
		
		//Si se preciona el boton para acceder a la vista registros...
		if(e.getSource() == V.btnRegistros)
		{
			//Si los registros estan vacios...
			if(M.isRegistrosEmpty()) 
			{
				JOptionPane.showMessageDialog(V, "No hay registros de juguetes");
				
			}else {
				//Se abre ventana VR y se muestra el primer registro
				VR.setVisible(true);
											
				indexFin = M.getRegistrosSize() - 1;
										
				//Se obtiene el primer juguete y se muestra en la vista
				Toy = M.getJuguete(0);				
				fillFieldsVR(M.getJuguete(pos));
			}
			
		}

		
		//Si se preciona el boton para acceder a la vista Eliminar... (Boton no funcional y oculto a la vista)
		if(e.getSource() == V.btnEliminar) 
		{
			
			int opc  = JOptionPane.showConfirmDialog(V, "Desea eliminar el juguete", "Eliminación de juguete", JOptionPane.YES_OPTION);
			
			if(opc == 0) 
			{
				System.out.println("Se presiono que si");					
				
			}else if(opc == 1) {
				System.out.println("Se presiono que no");
			}
			
		}
		
		
		//Si se presiona el boton crear Juguete dentro de la vista INSERTAR...
		if(e.getSource() == IV.btnCrear) 
		{
			//Se verifica que no se tengan campos vacios
			if(VerificarIV()) 
			{
				int Id = Integer.parseInt(IV.txtId.getText());
				String Nombre = IV.txtNombre.getText();
				float Precio = Float.parseFloat(IV.txtPrecio.getText());
				String Marca = IV.txtMarca.getText();
				int Categoria = Integer.parseInt(IV.txtCategoria.getText());
				int Proveedor = Integer.parseInt(IV.txtProveedor.getText());
				int Stock = Integer.parseInt(IV.txtStock.getText());
				
				//Se crea un juguete y se agrega en los registros
				Toy = new Juguete(Id, Nombre, Precio, Marca, Categoria, Proveedor, Stock);				
				M.addToy(Toy);
							
				JOptionPane.showMessageDialog(IV, "Juguete Agregado");
				
				indexFin = M.getRegistrosSize() - 1;
				
				//Se cierra la Vista INSERTAR
				IV.dispose();				
			}
			
		}
		
		
		//Si se presiona el boton Cerrar dentro de la vista INSERTAR...
		if(e.getSource() == IV.btnCerrarIV) 
		{
			//Se cierra la Vista INSERTAR
			IV.dispose();			
		}
		
		
		//Si se presiona el boton Cerrar dentro de la vista PRINCIPAL...
		if(e.getSource() == V.btnCerrarV) 
		{
			//Se actualizan los registros en el txt
			M.updateRegistroFile();
			
			System.out.println("Se presiono cerrar");
			
			//Se cierra el programa
			V.dispose();
			
		}
		
		
		//Si se presiona el boton Anterior dentro de la vista Registros...
		if(e.getSource() == VR.btnAnterior) 
		{			
			indexActual = M.getIndexOf(Toy);
			
			if(M.getRegistrosSize() > 0 && indexActual -1 > -1)
			{
				Toy = M.getJuguete(indexActual - 1);
				fillFieldsVR(Toy);
			}
			else 
			{
				Toy = M.getLastToy();
				fillFieldsVR(Toy);
				
			}
		}
		
		
		//Si se presiona el boton Siguiente dentro de la vista Registros...
		if(e.getSource() == VR.btnSiguiente) 
		{
			
			indexActual = M.getIndexOf(Toy);

			
			if(M.getRegistrosSize() > 0 && indexActual +1 < M.getRegistrosSize())
			{
				
				Toy = M.getJuguete(indexActual + 1);
				fillFieldsVR(Toy);
			}
			else 
			{
				
				Toy = M.getJuguete(0);
				fillFieldsVR(Toy);
				
			}			
		}
		
		//Si se presiona el boton "Primer Registro" dentro de la vista Registros...
		if(e.getSource() == VR.btnPrimer) 
		{
			Toy = M.getJuguete(0);
			fillFieldsVR(Toy);
		}
		
		
		//Si se presiona el boton "Ultimo Registro" dentro de la vista Registros...
		if(e.getSource() == VR.btnUltimo) 
		{
			Toy = M.getLastToy();
			fillFieldsVR(Toy);
		}
		
		
		//Si se presiona el boton "Cerrar" dentro de la vista Registros...
		if(e.getSource() == VR.btnCerrarVR) 
		{
			if(band) {
				
				int opc  = JOptionPane.showConfirmDialog(VR, "¿Esta seguro que desea salir sin guardar cambios?", "AVISO", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
				//En caso que se haya escogido si...
				if (opc == 0) 
				{
					VR.setVisible(false);
					VR.btnGuardar.setEnabled(false);
					turnBlack(VR.btnGuardar);
					turnOrange(VR.btnModificar);
					freeMoveButtonsVR();
					blockFieldsVR();
					band = false;
					VR.dispose();
				}
				
			}else { //En caso que haya escogido No...

				//Se guardan los cambios en el txt
				M.updateRegistroFile();
				VR.dispose();
				System.out.println("Se presiono cerrar");
			}
		}
		
		
		//Si se presiona el boton "Modificar" dentro de la vista Registros...
		if(e.getSource() == VR.btnModificar) 
		{
			//En caso que los campos esten bloqueados
			if(!band) 
			{
				//Permitir modificar los campos pero bloquear el movimiento y habilitar el boton gaurdar			
				VR.btnGuardar.setEnabled(true);
				turnGreen(VR.btnGuardar);
				turnBlack(VR.btnModificar);
				blockMoveButtonsVR();								
				freeFieldsVR();
				
				band = true;
				
				
			}else if(band) //En caso que los campos esten habilitados
			{
				//Bloquear campos y permitir movimiento
				VR.btnGuardar.setEnabled(false);
				turnBlack(VR.btnGuardar);
				turnOrange(VR.btnModificar);
				freeMoveButtonsVR();
				blockFieldsVR();
				
				band = false;
				
			}
			
		}
		
		
		//Si se presiona el boton "Guardar" dentro de la vista Registros...
		if(e.getSource() == VR.btnGuardar) 
		{
			int id = Integer.parseInt(VR.txtId.getText());			
			int posicion = M.getIndexByID(id);
			
			//Verificar ID
			if(posicion != -1) 
			{					
				int Id = Integer.parseInt(VR.txtId.getText());
				String Nombre = VR.txtNombre.getText();
				float Precio = Float.parseFloat(VR.txtPrecio.getText());
				String Marca = VR.txtMarca.getText();
				int Categoria = Integer.parseInt(VR.txtCategoria.getText());
				int Proveedor = Integer.parseInt(VR.txtProveedor.getText());
				int Stock = Integer.parseInt(VR.txtStock.getText());
							
				//Aqui se modifica el juguete 
				Toy = new Juguete(Id, Nombre, Precio, Marca, Categoria, Proveedor, Stock);
				
				M.modifyToy(posicion, Toy);

				JOptionPane.showMessageDialog(IV, "Juguete Modificado");
				
				turnBlack(VR.btnGuardar);
				VR.btnGuardar.setEnabled(false);
				
				freeMoveButtonsVR();
				blockFieldsVR();
				
				turnOrange(VR.btnModificar);
				
			}else {
				JOptionPane.showMessageDialog(IV, "ERROR CON EL ID DEL JUGUETE");
			}
			
			
			band = false;
		}
		
				
		//Si se presiona el boton "ELIMINAR" dentro de la vista Registros...
		if(e.getSource() == VR.btnEliminar) 
		{
			int id = Integer.parseInt(VR.txtId.getText());
			
			int opc  = JOptionPane.showConfirmDialog(VR, "Desea eliminar el juguete", "Eliminación de juguete", JOptionPane.YES_OPTION);
			
			//Si la opcion fue si...
			if(opc == 0) 
			{
				//Bloquear el boton guardar, bloquear campos y permitir el movimiento
				//Eliminar juguete
				M.deleteToy(M.getIndexByID(id));				
				JOptionPane.showMessageDialog(IV, "Juguete Borrado");
										
				turnBlack(VR.btnGuardar);
				VR.btnGuardar.setEnabled(false);
				
				freeMoveButtonsVR();
				blockFieldsVR();
				
				turnOrange(VR.btnModificar);
				
				//Si todavia quedan mas juguetes en los registros...
				if(!M.isRegistrosEmpty()) 
				{
					Toy = M.getJuguete(0);
					fillFieldsVR(M.getJuguete(0));
					indexActual = 0;
					indexFin = M.getRegistrosSize() - 1;
					
				}else { //Si ya no quedan mas juguetes y los registros estan vacios
					//Regresar a la vista principal
					JOptionPane.showMessageDialog(IV, "Registros vacios!!\nRegresando a la vista principal");
					VR.setVisible(false);
				}
				
			} //Si la opcion fue no...
			else if(opc == 1) {
				//NO HACER NADA				
			}
			
		}
		
	}
	
	
		
	//METODO PARA VERIFICAR QUE LOS CAMPOS NO ESTEN VACIOS EN LA LISTA INSERTAR
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
	
	
	
	
	//---------------------------METODOS DE VISTAS---------------------------
	
	//Metodo que cambia el color del boton a naranja
	public void turnOrange(JButton boton) 
	{
		boton.setForeground(new Color(255, 255, 255));
		boton.setBackground(new Color(255, 128, 64));
	}
	
	
	//Metodo que cambia el color del boton a verde
	public void turnGreen(JButton boton) 
	{
		boton.setForeground(new Color(0, 0, 0));
		boton.setBackground(new Color(0, 255, 0));
	}
	
	
	//Metodo que cambia el color del boton a negro
	public void turnBlack(JButton boton) 
	{
		boton.setForeground(new Color(255, 255, 255));
		boton.setBackground(new Color(192, 192, 192));
	}
	
	//Metodo que bloquea los botones de navegación de la vista INSERTAR
	public void blockMoveButtonsVR() 
	{
		VR.btnAnterior.setEnabled(false);
		VR.btnSiguiente.setEnabled(false);
		VR.btnPrimer.setEnabled(false);
		VR.btnUltimo.setEnabled(false);
	}
		
		
	//Metodo que libera los botones de navegación de la vista INSERTAR
	public void freeMoveButtonsVR() 
	{
		VR.btnAnterior.setEnabled(true);
		VR.btnSiguiente.setEnabled(true);
		VR.btnPrimer.setEnabled(true);
		VR.btnUltimo.setEnabled(true);
	}	
	
	//Metodo que libera los campos de la vista REGISTROS
	public void freeFieldsVR() 
	{
		
		VR.txtNombre.setEditable(true);;
		VR.txtPrecio.setEditable(true);;
		VR.txtMarca.setEditable(true);
		VR.txtCategoria.setEditable(true);
		VR.txtProveedor.setEditable(true);
		VR.txtStock.setEditable(true);
	}
	
	
	//Metodo que bloquea los Campos de la vista INSERTAR
	public void blockFieldsVR() 
	{
		VR.txtId.setEditable(false);;
		VR.txtNombre.setEditable(false);;
		VR.txtPrecio.setEditable(false);;
		VR.txtMarca.setEditable(false);
		VR.txtCategoria.setEditable(false);
		VR.txtProveedor.setEditable(false);
		VR.txtStock.setEditable(false);
	}
	

	//Metodo que habilita los campos de la vista INSERTAR
	public void fillFieldsVR(Juguete Toy) 
	{
		VR.txtId.setText(""+ Toy.getId_jug());
		VR.txtNombre.setText(""+ Toy.getNom_jug());
		VR.txtPrecio.setText(""+ Toy.getPre_jug());
		VR.txtMarca.setText(""+ Toy.getMarc_jug());
		VR.txtCategoria.setText(""+ Toy.getCatg_jug());
		VR.txtProveedor.setText(""+ Toy.getProv_jug());
		VR.txtStock.setText(""+ Toy.getStock_jug());
	}
	
	//Metodo que vacía campos de la vista REGISTROS
	public void vaciarCamposVR() 
	{
		VR.txtId.setText("");
		VR.txtNombre.setText("");
		VR.txtPrecio.setText("");
		VR.txtMarca.setText("");
		VR.txtCategoria.setText("");
		VR.txtStock.setText("");
	}
	
	//Metodo que vacía campos de la vista INSERTAR
	public void vaciarCamposVI() 
	{
		IV.txtId.setText("");
		IV.txtNombre.setText("");
		IV.txtPrecio.setText("");
		IV.txtMarca.setText("");
		IV.txtCategoria.setText("");
		IV.txtStock.setText("");
	}
	
}
