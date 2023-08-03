package e.ticaret.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import e.ticaret.blo.MusteriBLO;
import e.ticaret.models.Musteri;

import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MusteriKaydet extends JFrame {

	private JPanel contentPane;
	private MusteriBLO blo = new MusteriBLO();
	private JTextField txtEmail;

	/**
	 * Create the frame.
	 */
	public MusteriKaydet() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[89px][][grow]", "[23px][][]"));
		
		JLabel lblNewLabel = new JLabel("E-mail");
		contentPane.add(lblNewLabel, "cell 0 0");
		
		txtEmail = new JTextField();
		contentPane.add(txtEmail, "cell 2 0,alignx left");
		txtEmail.setColumns(10);
		
		JButton btnNewButton = new JButton("Kaydet");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Musteri yeniMusteri = new Musteri(txtEmail.getText(), "Fatma","Þen", LocalDate.parse("2000-08-09"),"123");
				blo.kaydet(yeniMusteri);
			}
		});
		contentPane.add(btnNewButton, "cell 2 1,alignx left,aligny top");
	}

}
