package mx.com.cursodia.jse18.mod2.semana1.tarea;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VistaRegistro extends JFrame
{


	//Campos de clase
	private JPanel contentPane;
	JTextField txtId;
	JTextField txtNombre;
	JTextField txtPrecio;
	JTextField txtMarca;
	JTextField txtCategoria;
	JTextField txtStock;
	
	JButton btnCrear;
	JButton btnCerrarIV;
	
	JButton btnPrimer;
	JButton btnUltimo;
	JButton btnAnterior;
	JButton btnSiguiente;
	JButton btnCerrarVR;
	
	JButton btnModificar;
	JButton btnGuardar;
	JButton btnEliminar;
	
	void lanzarGUI()//Lanzar GUI en un hilo
	{//delimitador de package
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					crearRegistroGUI();
					setResizable(false);
					setVisible(false);
				
					
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	public void crearRegistroGUI() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 782, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel id_label = new JLabel("Id Juguete:");
		id_label.setFont(new Font("Arial", Font.BOLD, 25));
		id_label.setBounds(228, 76, 137, 30);
		contentPane.add(id_label);

		txtId = new JTextField();
		txtId.setFont(new Font("Dialog", Font.ITALIC, 25));
		txtId.setBounds(375, 76, 174, 27);
		contentPane.add(txtId);
		txtId.setEditable(false);
		txtId.setColumns(10);
		

		JLabel nom_label = new JLabel("Nombre :");
		nom_label.setFont(new Font("Arial", Font.BOLD, 25));
		nom_label.setBounds(228, 127, 137, 20);
		contentPane.add(nom_label);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Dialog", Font.ITALIC, 25));
		txtNombre.setColumns(10);
		txtNombre.setBounds(375, 122, 174, 27);
		txtNombre.setEditable(false);
		contentPane.add(txtNombre);
		

		JLabel pre_label = new JLabel("Precio :");
		pre_label.setFont(new Font("Arial", Font.BOLD, 25));
		pre_label.setBounds(228, 170, 137, 20);
		contentPane.add(pre_label);

		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Dialog", Font.ITALIC, 25));
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(375, 165, 174, 27);
		txtPrecio.setEditable(false);
		contentPane.add(txtPrecio);
		

		JLabel marc_label = new JLabel("Marca :");
		marc_label.setFont(new Font("Arial", Font.BOLD, 25));
		marc_label.setBounds(228, 213, 137, 20);
		contentPane.add(marc_label);

		txtMarca = new JTextField();
		txtMarca.setFont(new Font("Dialog", Font.ITALIC, 25));
		txtMarca.setColumns(10);
		txtMarca.setBounds(375, 208, 174, 27);
		txtMarca.setEditable(false);
		contentPane.add(txtMarca);

		JLabel catg_label = new JLabel("Categoria :");
		catg_label.setFont(new Font("Arial", Font.BOLD, 25));
		catg_label.setBounds(228, 249, 137, 30);
		contentPane.add(catg_label);

		txtCategoria = new JTextField();
		txtCategoria.setFont(new Font("Dialog", Font.ITALIC, 25));
		txtCategoria.setColumns(10);
		txtCategoria.setBounds(375, 249, 174, 27);
		txtCategoria.setEditable(false);
		contentPane.add(txtCategoria);

		JLabel stock_label = new JLabel("Stock :");
		stock_label.setFont(new Font("Arial", Font.BOLD, 25));
		stock_label.setBounds(228, 302, 137, 20);
		contentPane.add(stock_label);

		txtStock = new JTextField();
		txtStock.setFont(new Font("Dialog", Font.ITALIC, 25));
		txtStock.setColumns(10);
		txtStock.setBounds(375, 297, 174, 27);
		txtStock.setEditable(false);
		contentPane.add(txtStock);
		
		JLabel lblNewLabel = new JLabel("REGISTRO JUGUETES");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel.setBounds(183, 11, 473, 46);
		contentPane.add(lblNewLabel);
		
		btnPrimer = new JButton("Primer Registro");
		btnPrimer.setForeground(new Color(255, 255, 255));
		btnPrimer.setBackground(new Color(102, 102, 255));
		btnPrimer.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPrimer.setBounds(24, 363, 168, 30);
		contentPane.add(btnPrimer);
		
		btnUltimo = new JButton("Ultimo Registro");
		btnUltimo.setForeground(new Color(255, 255, 255));
		btnUltimo.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUltimo.setBackground(new Color(102, 102, 255));
		btnUltimo.setBounds(568, 363, 168, 30);
		contentPane.add(btnUltimo);
		
		btnAnterior = new JButton("Anterior");
		btnAnterior.setForeground(new Color(255, 255, 255));
		btnAnterior.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAnterior.setBackground(new Color(102, 102, 255));
		btnAnterior.setBounds(249, 363, 116, 30);
		contentPane.add(btnAnterior);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setForeground(new Color(255, 255, 255));
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSiguiente.setBackground(new Color(102, 102, 255));
		btnSiguiente.setBounds(405, 363, 116, 30);
		contentPane.add(btnSiguiente);
		
		btnCerrarVR = new JButton("CERRAR");
		btnCerrarVR.setForeground(new Color(0, 0, 0));
		btnCerrarVR.setBackground(new Color(192, 192, 192));
		btnCerrarVR.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCerrarVR.setBounds(642, 10, 116, 30);
		contentPane.add(btnCerrarVR);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.setForeground(new Color(255, 255, 255));
		btnModificar.setBackground(new Color(255, 128, 64));
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnModificar.setBounds(41, 434, 129, 46);
		contentPane.add(btnModificar);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setForeground(new Color(255, 255, 255));
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGuardar.setBackground(new Color(192, 192, 192));
		btnGuardar.setBounds(279, 434, 214, 46);
		btnGuardar.setEnabled(false);
		contentPane.add(btnGuardar);
		//btnGuardar.setForeground(new Color(0, 0, 0));
		//btnGuardar.setBackground(new Color(0, 255, 0));
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEliminar.setBackground(new Color(255, 0, 0));
		btnEliminar.setBounds(595, 434, 129, 46);
		contentPane.add(btnEliminar);

	}
	
	public void turnedBlack(JButton boton) 
	{
		
	}
	
	public void freeFields() 
	{
		txtId.setEditable(true);;
		txtNombre.setEditable(true);;
		txtPrecio.setEditable(true);;
		txtMarca.setEditable(true);
		txtCategoria.setEditable(true);
		txtStock.setEditable(true);
	}
	
	public void fillFields(Juguete Toy) 
	{
		txtId.setText(Toy.id_jug.toString());
		txtNombre.setText(Toy.nom_jug.toString());
		txtPrecio.setText(Toy.pre_jug.toString());
		txtMarca.setText(Toy.marc_jug.toString());
		txtCategoria.setText(Toy.catg_jug);
		txtStock.setText(Toy.stock.toString());
	}
	
	public void vaciarCamposIV() 
	{
		txtId.setText("");
		txtNombre.setText("");
		txtPrecio.setText("");
		txtMarca.setText("");
		txtCategoria.setText("");
		txtStock.setText("");
	}
}