package mx.com.cursodia.jse18.mod2.semana1.tarea;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;



public class Controlador implements ActionListener {

	
	//QUITAR ESTE ARRAY Y MANEJARLO EN MODELO
	//ArrayList<Juguete> Registros = new ArrayList<Juguete>();
	Vista V;
	InsertarVista IV;
	VistaRegistro VR;
	Modelo M;
	Juguete Toy;
	
	
	int indexInicio = 0;
	int indexFin;
	int indexActual;
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
		
		M.createToys();
		
		Escuchadores();
		
		//Creacion del archivo de texto
		if(M.verifyFolder()) 
		{
			M.createFile();
		}
		
		
	}
	
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
		
		IV.setDefaultCloseOperation(IV.DO_NOTHING_ON_CLOSE);
		VR.setDefaultCloseOperation(VR.DO_NOTHING_ON_CLOSE);
		
		
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

		} 
		
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
										
				Toy = M.getJuguete(0);
				
				fillFieldsVR(M.getJuguete(pos));
			}
			
		}

		if(e.getSource() == V.btnEliminar) 
		{
			//JOptionPane.showMessageDialog(V, "presionaste el boton de eliminar juguete");
			int opc  = JOptionPane.showConfirmDialog(V, "Desea eliminar el juguete", "Eliminación de juguete", JOptionPane.YES_OPTION);
			
			if(opc == 0) 
			{
				System.out.println("Se presiono que si");	
				
				
			}else if(opc == 1) {
				System.out.println("Se presiono que no");
			}
			
		}
		
		if(e.getSource() == IV.btnCrear) 
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
				Toy = new Juguete(Id, Nombre, Precio, Marca, Categoria, Stock);				
				M.addToy(Toy);
				M.writeData(Toy);
				
				JOptionPane.showMessageDialog(IV, "Juguete Agregado");
				indexFin = M.getRegistrosSize() - 1;
				
				IV.dispose();				
			}
			
		}
		
		if(e.getSource() == IV.btnCerrarIV) 
		{
			IV.dispose();
			
		}
		
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
				System.out.println("false");
				Toy = M.getJuguete(0);
				fillFieldsVR(Toy);
				
			}
			
		}
		
		
		if(e.getSource() == VR.btnPrimer) 
		{
			Toy = M.getJuguete(0);
			fillFieldsVR(Toy);
		}
		
		
		if(e.getSource() == VR.btnUltimo) 
		{
			Toy = M.getLastToy();
			fillFieldsVR(Toy);
		}
		
		if(e.getSource() == VR.btnCerrarVR) 
		{
			if(band) {
				int opc  = JOptionPane.showConfirmDialog(VR, "¿Esta seguro que desea salir sin guardar cambios?", "AVISO", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
				if (opc == 0) 
				{
					VR.setVisible(false);
					VR.btnGuardar.setEnabled(false);
					turnedBlack(VR.btnGuardar);
					turnedOrange(VR.btnModificar);
					freeMoveButtonsVR();
					blockFieldsVR();
					band = false;
					VR.dispose();
				}
				
			}else {
				VR.dispose();
				System.out.println("Se presiono cerrar");
			}
			
			
		}
		
		
		if(e.getSource() == VR.btnModificar) 
		{
			if(!band) 
			{
				VR.btnGuardar.setEnabled(true);
				turnedGreen(VR.btnGuardar);
				turnedBlack(VR.btnModificar);
				blockMoveButtonsVR();
								
				freeFieldsVR();
				
				band = true;
				System.out.println("BAND -> " + band);
				
			}else if(band)
			{
				VR.btnGuardar.setEnabled(false);
				turnedBlack(VR.btnGuardar);
				turnedOrange(VR.btnModificar);
				freeMoveButtonsVR();
				blockFieldsVR();
				band = false;
				System.out.println("BAND -> " + band);
			}
			
		}
		
		
		if(e.getSource() == VR.btnGuardar) 
		{
			int id = Integer.parseInt(VR.txtId.getText());
			
			int posicion = M.getIndexByID(id);
			
			
			if(posicion != -1) 
			{					
				int Id = Integer.parseInt(VR.txtId.getText());
				String Nombre = VR.txtNombre.getText();
				float Precio = Float.parseFloat(VR.txtPrecio.getText());
				String Marca = VR.txtMarca.getText();
				String Categoria = VR.txtCategoria.getText();
				int Stock = Integer.parseInt(VR.txtStock.getText());
							
				//Aqui se modifica el juguete 
				Toy = new Juguete(Id, Nombre, Precio, Marca, Categoria, Stock);
				M.modifyToy(posicion, Toy);
				
				JOptionPane.showMessageDialog(IV, "Juguete Modificado");
				
				turnedBlack(VR.btnGuardar);
				VR.btnGuardar.setEnabled(false);
				
				freeMoveButtonsVR();
				blockFieldsVR();
				
				turnedOrange(VR.btnModificar);
			}else {
				JOptionPane.showMessageDialog(IV, "ERROR CON EL ID DEL JUGUETE");
			}
			
			
			band = false;
		}
		
		
		if(e.getSource() == VR.btnEliminar) 
		{
			int id = Integer.parseInt(VR.txtId.getText());
			
			int opc  = JOptionPane.showConfirmDialog(VR, "Desea eliminar el juguete", "Eliminación de juguete", JOptionPane.YES_OPTION);
			
			//Si la opcion fue si...
			if(opc == 0) 
			{
				
				M.deleteToy(M.getIndexByID(id));
				
				JOptionPane.showMessageDialog(IV, "Juguete Borrado");
										
				turnedBlack(VR.btnGuardar);
				VR.btnGuardar.setEnabled(false);
				
				freeMoveButtonsVR();
				blockFieldsVR();
				
				turnedOrange(VR.btnModificar);
				
				Toy = M.getJuguete(0);
				fillFieldsVR(M.getJuguete(0));
				indexActual = 0;
				indexFin = M.getRegistrosSize() - 1;
			} //Si la opcion fue no...
			else if(opc == 1) {
				//NO HACER NADA
				
			}
			
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
	
	
	
	
	
	public void turnedOrange(JButton boton) 
	{
		boton.setForeground(new Color(255, 255, 255));
		boton.setBackground(new Color(255, 128, 64));
	}
	
	public void turnedGreen(JButton boton) 
	{
		boton.setForeground(new Color(0, 0, 0));
		boton.setBackground(new Color(0, 255, 0));
	}
	public void turnedBlack(JButton boton) 
	{
		boton.setForeground(new Color(255, 255, 255));
		boton.setBackground(new Color(192, 192, 192));
	}
	
	public void freeFieldsVR() 
	{
		
		VR.txtNombre.setEditable(true);;
		VR.txtPrecio.setEditable(true);;
		VR.txtMarca.setEditable(true);
		VR.txtCategoria.setEditable(true);
		VR.txtStock.setEditable(true);
	}
	
	public void blockMoveButtonsVR() 
	{
		VR.btnAnterior.setEnabled(false);
		VR.btnSiguiente.setEnabled(false);
		VR.btnPrimer.setEnabled(false);
		VR.btnUltimo.setEnabled(false);
	}
	
	public void freeMoveButtonsVR() 
	{
		VR.btnAnterior.setEnabled(true);
		VR.btnSiguiente.setEnabled(true);
		VR.btnPrimer.setEnabled(true);
		VR.btnUltimo.setEnabled(true);
	}
	
	public void blockFieldsVR() 
	{
		VR.txtId.setEditable(false);;
		VR.txtNombre.setEditable(false);;
		VR.txtPrecio.setEditable(false);;
		VR.txtMarca.setEditable(false);
		VR.txtCategoria.setEditable(false);
		VR.txtStock.setEditable(false);
	}
	
	public void fillFieldsVR(Juguete Toy) 
	{
		VR.txtId.setText(""+ Toy.getId_jug());
		VR.txtNombre.setText(""+ Toy.getNom_jug());
		VR.txtPrecio.setText(""+ Toy.getPre_jug());
		VR.txtMarca.setText(""+ Toy.getMarc_jug());
		VR.txtCategoria.setText(""+ Toy.getCatg_jug());
		VR.txtStock.setText(""+ Toy.getStock());
	}
	
	public void vaciarCamposVR() 
	{
		VR.txtId.setText("");
		VR.txtNombre.setText("");
		VR.txtPrecio.setText("");
		VR.txtMarca.setText("");
		VR.txtCategoria.setText("");
		VR.txtStock.setText("");
	}
	
	
	
	
	
	

}
