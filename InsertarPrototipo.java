package mx.com.cursodia.jse18.mod2.semana1.tarea;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class InsertarPrototipo extends JFrame {

	private JPanel contentPane;

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

		JTextField id_txt = new JTextField();
		id_txt.setFont(new Font("Dialog", Font.PLAIN, 17));
		id_txt.setBounds(345, 21, 163, 20);
		contentPane.add(id_txt);
		id_txt.setColumns(10);

		JLabel nom_label = new JLabel("Nombre :");
		nom_label.setFont(new Font("Arial", Font.BOLD, 18));
		nom_label.setBounds(201, 55, 137, 20);
		contentPane.add(nom_label);

		JTextField nom_txt = new JTextField();
		nom_txt.setFont(new Font("Dialog", Font.PLAIN, 17));
		nom_txt.setColumns(10);
		nom_txt.setBounds(345, 55, 163, 20);
		contentPane.add(nom_txt);

		JLabel pre_label = new JLabel("Precio :");
		pre_label.setFont(new Font("Arial", Font.BOLD, 18));
		pre_label.setBounds(201, 86, 137, 20);
		contentPane.add(pre_label);

		JTextField pre_txt = new JTextField();
		pre_txt.setFont(new Font("Dialog", Font.PLAIN, 17));
		pre_txt.setColumns(10);
		pre_txt.setBounds(345, 86, 163, 20);
		contentPane.add(pre_txt);

		JLabel marc_label = new JLabel("Marca :");
		marc_label.setFont(new Font("Arial", Font.BOLD, 18));
		marc_label.setBounds(201, 117, 137, 20);
		contentPane.add(marc_label);

		JTextField marc_txt = new JTextField();
		marc_txt.setFont(new Font("Dialog", Font.PLAIN, 17));
		marc_txt.setColumns(10);
		marc_txt.setBounds(345, 117, 163, 20);
		contentPane.add(marc_txt);

		JLabel catg_label = new JLabel("Categoria :");
		catg_label.setFont(new Font("Arial", Font.BOLD, 18));
		catg_label.setBounds(201, 148, 137, 20);
		contentPane.add(catg_label);

		JTextField catg_txt = new JTextField();
		catg_txt.setFont(new Font("Dialog", Font.PLAIN, 17));
		catg_txt.setColumns(10);
		catg_txt.setBounds(345, 148, 163, 20);
		contentPane.add(catg_txt);

		JLabel stock_label = new JLabel("Stock :");
		stock_label.setFont(new Font("Arial", Font.BOLD, 18));
		stock_label.setBounds(201, 182, 137, 20);
		contentPane.add(stock_label);

		JTextField stock_txt = new JTextField();
		stock_txt.setFont(new Font("Dialog", Font.PLAIN, 17));
		stock_txt.setColumns(10);
		stock_txt.setBounds(345, 182, 163, 20);
		contentPane.add(stock_txt);
		
		JButton crearBtn = new JButton("CREAR JUGUETE");
		crearBtn.setFont(new Font("Tahoma", Font.BOLD, 21));
		crearBtn.setBounds(237, 250, 225, 73);
		contentPane.add(crearBtn);
		
		
	}
}
