package mx.com.cursodia.jse18.mod2.semana1.tarea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Controlador implements ActionListener {

	ArrayList<Juguete> nombreArrayList = new ArrayList<Juguete>();
	Vista V;
	InsertarVista IV;
	Modelo M;
	
	
	public Controlador(Vista V, InsertarVista IV, Modelo M )
	{
		this.V = V;
		this.IV = IV;
		this.M = M;
		
		this.V.lanzarGUI();
		this.IV.lanzarGUI();
		
		
		Escuchadores();
	}
	
	private void Escuchadores() 
	{
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		IV.setDefaultCloseOperation(IV.DISPOSE_ON_CLOSE);
		
		
		V.btnNuevo.addActionListener(this);
		V.btnRegistros.addActionListener(this);
		V.btnEliminar.addActionListener(this);
		IV.btnCrear.addActionListener(this);
		
		
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
			IV.setVisible(true);
			
			
		}else if(e.getSource() == V.btnRegistros)
		{
			JOptionPane.showMessageDialog(V, "presionaste el boton de ver registros");
		}else if(e.getSource() == V.btnEliminar) 
		{
			JOptionPane.showMessageDialog(V, "presionaste el boton de eliminar juguete");
		}else if(e.getSource() == IV.btnCrear) 
		{
			if(VerificarIV()) 
			{
				String Id = IV.txtId.getText();
				String Nombre = IV.txtNombre.getText();
				float Precio = Float.parseFloat(IV.txtPrecio.getText()) ;
				System.out.println(Id);
				System.out.println(Nombre);
				System.out.println(Precio);
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
	
	

}