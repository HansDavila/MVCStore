package mx.com.cursodia.jse18.mod2.semana1.tarea;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class PrototipoRegistros extends JFrame {

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
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrototipoRegistros frame = new PrototipoRegistros();
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
	public PrototipoRegistros() {
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
		txtId.setColumns(10);

		JLabel nom_label = new JLabel("Nombre :");
		nom_label.setFont(new Font("Arial", Font.BOLD, 25));
		nom_label.setBounds(228, 127, 137, 20);
		contentPane.add(nom_label);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Dialog", Font.ITALIC, 25));
		txtNombre.setColumns(10);
		txtNombre.setBounds(375, 122, 174, 27);
		contentPane.add(txtNombre);

		JLabel pre_label = new JLabel("Precio :");
		pre_label.setFont(new Font("Arial", Font.BOLD, 25));
		pre_label.setBounds(228, 170, 137, 20);
		contentPane.add(pre_label);

		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Dialog", Font.ITALIC, 25));
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(375, 165, 174, 27);
		contentPane.add(txtPrecio);

		JLabel marc_label = new JLabel("Marca :");
		marc_label.setFont(new Font("Arial", Font.BOLD, 25));
		marc_label.setBounds(228, 213, 137, 20);
		contentPane.add(marc_label);

		txtMarca = new JTextField();
		txtMarca.setFont(new Font("Dialog", Font.ITALIC, 25));
		txtMarca.setColumns(10);
		txtMarca.setBounds(375, 208, 174, 27);
		contentPane.add(txtMarca);

		JLabel catg_label = new JLabel("Categoria :");
		catg_label.setFont(new Font("Arial", Font.BOLD, 25));
		catg_label.setBounds(228, 249, 137, 30);
		contentPane.add(catg_label);

		txtCategoria = new JTextField();
		txtCategoria.setFont(new Font("Dialog", Font.ITALIC, 25));
		txtCategoria.setColumns(10);
		txtCategoria.setBounds(375, 249, 174, 27);
		contentPane.add(txtCategoria);

		JLabel stock_label = new JLabel("Stock :");
		stock_label.setFont(new Font("Arial", Font.BOLD, 25));
		stock_label.setBounds(228, 302, 137, 20);
		contentPane.add(stock_label);

		txtStock = new JTextField();
		txtStock.setFont(new Font("Dialog", Font.ITALIC, 25));
		txtStock.setColumns(10);
		txtStock.setBounds(375, 297, 174, 27);
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
	}
}
