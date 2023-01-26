package mx.com.cursodia.jse18.mod2.semana1.tarea;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class prototipoVista extends JFrame {

	private JPanel contentPane;
	private JButton nuevoBtn_1;
	private JButton verBtn_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prototipoVista frame = new prototipoVista();
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
	public prototipoVista() {
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

/*
 * setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); setBounds(100, 100, 795,
 * 552); contentPane = new JPanel(); contentPane.setBorder(new EmptyBorder(5, 5,
 * 5, 5));
 * 
 * setContentPane(contentPane); contentPane.setLayout(null);
 * 
 * JLabel id_label = new JLabel("Id Juguete:"); id_label.setFont(new
 * Font("Arial", Font.BOLD, 18)); id_label.setBounds(228, 22, 137, 20);
 * contentPane.add(id_label);
 * 
 * id_txt = new JTextField(); id_txt.setFont(new Font("Dialog", Font.PLAIN,
 * 17)); id_txt.setBounds(372, 22, 163, 20); contentPane.add(id_txt);
 * id_txt.setColumns(10);
 * 
 * JLabel nom_label = new JLabel("Nombre :"); nom_label.setFont(new
 * Font("Arial", Font.BOLD, 18)); nom_label.setBounds(228, 56, 137, 20);
 * contentPane.add(nom_label);
 * 
 * nom_txt = new JTextField(); nom_txt.setFont(new Font("Dialog", Font.PLAIN,
 * 17)); nom_txt.setColumns(10); nom_txt.setBounds(372, 56, 163, 20);
 * contentPane.add(nom_txt);
 * 
 * JLabel pre_label = new JLabel("Precio :"); pre_label.setFont(new
 * Font("Arial", Font.BOLD, 18)); pre_label.setBounds(228, 87, 137, 20);
 * contentPane.add(pre_label);
 * 
 * pre_txt = new JTextField(); pre_txt.setFont(new Font("Dialog", Font.PLAIN,
 * 17)); pre_txt.setColumns(10); pre_txt.setBounds(372, 87, 163, 20);
 * contentPane.add(pre_txt);
 * 
 * JLabel marc_label = new JLabel("Marca :"); marc_label.setFont(new
 * Font("Arial", Font.BOLD, 18)); marc_label.setBounds(228, 118, 137, 20);
 * contentPane.add(marc_label);
 * 
 * marc_txt = new JTextField(); marc_txt.setFont(new Font("Dialog", Font.PLAIN,
 * 17)); marc_txt.setColumns(10); marc_txt.setBounds(372, 118, 163, 20);
 * contentPane.add(marc_txt);
 * 
 * JLabel catg_label = new JLabel("Categoria :"); catg_label.setFont(new
 * Font("Arial", Font.BOLD, 18)); catg_label.setBounds(228, 149, 137, 20);
 * contentPane.add(catg_label);
 * 
 * catg_txt = new JTextField(); catg_txt.setFont(new Font("Dialog", Font.PLAIN,
 * 17)); catg_txt.setColumns(10); catg_txt.setBounds(372, 149, 163, 20);
 * contentPane.add(catg_txt);
 * 
 * stock_label = new JLabel("Stock :"); stock_label.setFont(new Font("Arial",
 * Font.BOLD, 18)); stock_label.setBounds(228, 183, 137, 20);
 * contentPane.add(stock_label);
 * 
 * stock_txt = new JTextField(); stock_txt.setFont(new Font("Dialog",
 * Font.PLAIN, 17)); stock_txt.setColumns(10); stock_txt.setBounds(372, 183,
 * 163, 20); contentPane.add(stock_txt);
 */
