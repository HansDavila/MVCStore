package mx.com.cursodia.jse18.mod2.semana1.tarea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Controlador implements ActionListener {

	ArrayList<Juguete> Registros = new ArrayList<Juguete>();
	Vista V;
	InsertarVista IV;
	VistaRegistro VR;
	Modelo M;
	
	int indexInicio = 0;
	int indexFin;
	int pos = 0;
	
	
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
			vaciarCamposIV();
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
										
				fillFields(Registros.get(pos));
				
				
				
				
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
					fillFields(Registros.get(pos));
				}
			}else 
			{
				//Caso normal se cambia la posicion a la anterior
				pos--;
			
				fillFields(Registros.get(pos));
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
					fillFields(Registros.get(pos));
				}
			}else 
			{
				//Caso normal, solo se aumenta la posicion 
				pos++;
				
				fillFields(Registros.get(pos));
			}
			
		}else if(e.getSource() == VR.btnPrimer) 
		{
			pos = 0;
			fillFields(Registros.get(pos));
		}
		else if(e.getSource() == VR.btnUltimo) 
		{
			pos = indexFin;
			fillFields(Registros.get(pos));
		}
		
	}
	
	public void vaciarCamposIV() 
	{
		IV.txtId.setText("");
		IV.txtNombre.setText("");
		IV.txtPrecio.setText("");
		IV.txtMarca.setText("");
		IV.txtCategoria.setText("");
		IV.txtStock.setText("");
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
	
	public void fillFields(Juguete Toy) 
	{
		VR.txtId.setText(Toy.id_jug.toString());
		VR.txtNombre.setText(Toy.nom_jug.toString());
		VR.txtPrecio.setText(Toy.pre_jug.toString());
		VR.txtMarca.setText(Toy.marc_jug.toString());
		VR.txtCategoria.setText(Toy.catg_jug);
		VR.txtStock.setText(Toy.stock.toString());
	}
	
	public void createToys() 
	{
		Registros.add(new Juguete(1, "Pelota", 100, "MexiToys", "Basico", 100));
		Registros.add(new Juguete(2, "Transformer", 600, "Hasbro", "Accion", 20));
		Registros.add(new Juguete(3, "Barbie", 600, "Matel", "Muñeca", 40));
	}
	
	

}
