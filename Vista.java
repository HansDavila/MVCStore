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
	private JPanel contentPane;
	private JButton nuevoBtn_1;
	private JButton verBtn_1;
	

	void lanzarGUI()//Lanzar GUI en un hilo
	{//delimitador de package
		EventQueue.invokeLater(new Runnable() 
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

		JButton verBtn = new JButton("ELIMINAR JUGUETE");
		verBtn.setFont(new Font("Tahoma", Font.BOLD, 22));
		verBtn.setBounds(245, 257, 269, 57);
		contentPane.add(verBtn);

		nuevoBtn_1 = new JButton("NUEVO JUGUETE");
		nuevoBtn_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		nuevoBtn_1.setBounds(245, 101, 269, 57);
		contentPane.add(nuevoBtn_1);

		verBtn_1 = new JButton("VER REGISTROS");
		verBtn_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		verBtn_1.setBounds(245, 180, 269, 57);
		contentPane.add(verBtn_1);
	}
}
