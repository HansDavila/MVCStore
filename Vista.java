package mx.com.cursodia.jse18.mod2.semana1.tarea;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mx.com.cursodia.jse18.mod2.semana1.FormulaGeneral;

public class Vista extends JFrame
{
	JPanel contentPane;
	JButton btnNuevo;
	JButton btnRegistros;
	JButton btnEliminar;
	Thread ThreadV;
	

	void lanzarGUI()//Lanzar GUI en un hilo
	{//delimitador de package
		ThreadV = new Thread(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					crearGUI();
					setResizable(false);
					setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		
		ThreadV.start();
	}
	
	
	
	public void crearGUI() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel titulo = new JLabel("JUGUETERIA");
		titulo.setFont(new Font("Bahnschrift", Font.BOLD, 38));
		titulo.setBounds(257, 11, 269, 50);
		contentPane.add(titulo);

		btnEliminar = new JButton("ELIMINAR JUGUETE");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnEliminar.setBounds(245, 257, 269, 57);
		//contentPane.add(btnEliminar);

		btnNuevo = new JButton("NUEVO JUGUETE");
		btnNuevo.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNuevo.setBounds(245, 101, 269, 57);
		contentPane.add(btnNuevo);

		btnRegistros = new JButton("VER REGISTROS");
		btnRegistros.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnRegistros.setBounds(245, 180, 269, 57);
		contentPane.add(btnRegistros);
	}
	
	
	
}

