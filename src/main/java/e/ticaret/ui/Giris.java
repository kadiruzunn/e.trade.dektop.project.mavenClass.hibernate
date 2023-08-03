package e.ticaret.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import e.ticaret.blo.MusteriBLO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Giris {

	private JFrame frame;
	private JTextField txtEmail;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	
	private MusteriBLO blo = new MusteriBLO();
	private JPasswordField txtSifre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Giris window = new Giris();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Giris() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[][][][][][grow]", "[][][][][]"));
		
		JLabel lblNewLabel = new JLabel("E-mail :");
		frame.getContentPane().add(lblNewLabel, "cell 3 2");
		
		txtEmail = new JTextField();
		frame.getContentPane().add(txtEmail, "cell 5 2");
		txtEmail.setColumns(10);
		
		lblNewLabel_1 = new JLabel("\u015Eifre");
		frame.getContentPane().add(lblNewLabel_1, "cell 3 3");
		
		btnNewButton = new JButton("Giri\u015F");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(blo.giris(txtEmail.getText(), txtSifre.getText())) {
					MusteriKaydet mk = new MusteriKaydet();
					mk.setVisible(true);
					frame.setVisible(false);
					
				}else {
					JOptionPane.showMessageDialog(btnNewButton, "Kullanýcý adý veya þifre hatalý");
				}
			}
		});
		
		txtSifre = new JPasswordField();
		txtSifre.setColumns(10);
		frame.getContentPane().add(txtSifre, "cell 5 3,alignx left");
		frame.getContentPane().add(btnNewButton, "cell 5 4");
		
		
	}
	
	private void basariliGiris() {
		MusteriKaydet mk = new MusteriKaydet();
		mk.setVisible(true);
		this.frame.setVisible(false);
	}

}
