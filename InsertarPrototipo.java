package mx.com.cursodia.jse18.mod2.semana1.tarea;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;

public class InsertarPrototipo extends JFrame {

	//Campos de clase
		JPanel contentPane;
		JTextField txtId;
		JTextField txtNombre;
		JTextField txtPrecio;
		JTextField txtMarca;
		JTextField txtCategoria;
		JTextField txtStock;		
		JTextField txtProveedor;
		
		JButton btnCrear;
		JButton btnCerrarIV;
		
		
		

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertarPrototipo frame = new InsertarPrototipo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InsertarPrototipo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel id_label = new JLabel("Id Juguete:");
		id_label.setFont(new Font("Arial", Font.BOLD, 18));
		id_label.setBounds(201, 21, 137, 20);
		contentPane.add(id_label);

		txtId = new JTextField();
		txtId.setFont(new Font("Dialog", Font.PLAIN, 17));
		txtId.setBounds(345, 21, 163, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);

		JLabel nom_label = new JLabel("Nombre :");
		nom_label.setFont(new Font("Arial", Font.BOLD, 18));
		nom_label.setBounds(201, 55, 137, 20);
		contentPane.add(nom_label);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Dialog", Font.PLAIN, 17));
		txtNombre.setColumns(10);
		txtNombre.setBounds(345, 55, 163, 20);
		contentPane.add(txtNombre);

		JLabel pre_label = new JLabel("Precio :");
		pre_label.setFont(new Font("Arial", Font.BOLD, 18));
		pre_label.setBounds(201, 86, 137, 20);
		contentPane.add(pre_label);

		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Dialog", Font.PLAIN, 17));
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(345, 86, 163, 20);
		contentPane.add(txtPrecio);

		JLabel marc_label = new JLabel("Marca :");
		marc_label.setFont(new Font("Arial", Font.BOLD, 18));
		marc_label.setBounds(201, 117, 137, 20);
		contentPane.add(marc_label);

		txtMarca = new JTextField();
		txtMarca.setFont(new Font("Dialog", Font.PLAIN, 17));
		txtMarca.setColumns(10);
		txtMarca.setBounds(345, 117, 163, 20);
		contentPane.add(txtMarca);

		JLabel catg_label = new JLabel("Categoria :");
		catg_label.setFont(new Font("Arial", Font.BOLD, 18));
		catg_label.setBounds(201, 148, 137, 20);
		contentPane.add(catg_label);

		txtCategoria = new JTextField();
		txtCategoria.setFont(new Font("Dialog", Font.PLAIN, 17));
		txtCategoria.setColumns(10);
		txtCategoria.setBounds(345, 148, 163, 20);
		contentPane.add(txtCategoria);
		
		JLabel prov_label = new JLabel("Proveedor :");
		prov_label.setFont(new Font("Arial", Font.BOLD, 18));
		prov_label.setBounds(201, 178, 137, 20);
		contentPane.add(prov_label);
		
		txtProveedor = new JTextField();
		txtProveedor.setFont(new Font("Dialog", Font.PLAIN, 17));
		txtProveedor.setColumns(10);
		txtProveedor.setBounds(345, 178, 163, 20);
		contentPane.add(txtProveedor);
		

		JLabel stock_label = new JLabel("Stock :");
		stock_label.setFont(new Font("Arial", Font.BOLD, 18));
		stock_label.setBounds(201, 209, 137, 20);
		contentPane.add(stock_label);

		txtStock = new JTextField();
		txtStock.setFont(new Font("Dialog", Font.PLAIN, 17));
		txtStock.setColumns(10);
		txtStock.setBounds(345, 209, 163, 20);
		contentPane.add(txtStock);
		
		btnCrear = new JButton("CREAR JUGUETE");
		btnCrear.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnCrear.setBounds(237, 273, 225, 73);
		contentPane.add(btnCrear);
		
		btnCerrarIV = new JButton("CERRAR");
		btnCerrarIV.setForeground(Color.BLACK);
		btnCerrarIV.setBackground(new Color(192, 192, 192));
		btnCerrarIV.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCerrarIV.setBounds(286, 378, 128, 61);
		contentPane.add(btnCerrarIV);
		
		
		
	}
}
