import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextPane;


public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtBenutzername;
	private JPasswordField pwdPasswort;
	private JPasswordField pwdPasswort1;
	private UseCases usecases = new UseCases();
	private JTextField txtEmpfaenger;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JButton btnRegistrieren = new JButton("Registrieren");
		btnRegistrieren.setBounds(50, 112, 133, 25);
		contentPane.add(btnRegistrieren);
		
		final JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(244, 112, 117, 25);
		contentPane.add(btnLogin);
		
		txtName = new JTextField();
		txtName.setText("Name");
		txtName.setBounds(94, 66, 114, 19);
		contentPane.add(txtName);
		txtName.setColumns(10);
		txtName.setVisible(false);
		
		final JButton btnLogin_1 = new JButton("Login");
		btnLogin_1.setBounds(220, 63, 117, 25);
		contentPane.add(btnLogin_1);
		btnLogin_1.setVisible(false);
		
		txtBenutzername = new JTextField();
		txtBenutzername.setText("Benutzername");
		txtBenutzername.setBounds(94, 66, 114, 19);
		contentPane.add(txtBenutzername);
		txtBenutzername.setColumns(10);
		txtBenutzername.setVisible(false);
		
		pwdPasswort = new JPasswordField();
		pwdPasswort.setText("Passwort");
		pwdPasswort.setBounds(94, 97, 114, 25);
		contentPane.add(pwdPasswort);
		pwdPasswort.setVisible(false);
		
		pwdPasswort1 = new JPasswordField();
		pwdPasswort1.setText("Passwort");
		pwdPasswort1.setBounds(94, 97, 114, 25);
		contentPane.add(pwdPasswort1);
		pwdPasswort1.setVisible(false);
		
		final JButton btnRegistrieren_1 = new JButton("Registrieren");
		btnRegistrieren_1.setBounds(94, 159, 133, 25);
		contentPane.add(btnRegistrieren_1);
		btnRegistrieren_1.setVisible(false);
		
		final JLabel lblFehler = new JLabel("Fehler!");
		lblFehler.setForeground(Color.RED);
		lblFehler.setBounds(143, 209, 171, 15);
		contentPane.add(lblFehler);
		lblFehler.setVisible(false);

		final JLabel lblSuccess = new JLabel("Erfolgreich angemeldet");
		lblSuccess.setForeground(Color.GREEN);
		lblSuccess.setBounds(143, 209, 171, 15);
		contentPane.add(lblSuccess);
		lblSuccess.setVisible(false);
		
		final JLabel lblName = new JLabel("Name bereits vergeben");
		lblName.setForeground(Color.RED);
		lblName.setBounds(143, 209, 194, 15);
		contentPane.add(lblName);
		lblName.setVisible(false);
		
		final JLabel lblBenutzer = new JLabel("Benutzer existiert nicht");
		lblBenutzer.setForeground(Color.RED);
		lblBenutzer.setBounds(143, 209, 194, 15);
		contentPane.add(lblBenutzer);
		lblBenutzer.setVisible(false);
		
		final JLabel lblSuccess1 = new JLabel("Login erfolgreich!");
		lblSuccess1.setForeground(Color.GREEN);
		lblSuccess1.setBounds(143, 245, 171, 15);
		contentPane.add(lblSuccess1);
		lblSuccess1.setVisible(false);
		
		txtEmpfaenger = new JTextField();
		txtEmpfaenger.setText("Empfänger");
		txtEmpfaenger.setBounds(50, 66, 114, 19);
		contentPane.add(txtEmpfaenger);
		txtEmpfaenger.setColumns(10);
		txtEmpfaenger.setVisible(false);
		
		final JTextPane txtpnNachricht = new JTextPane();
		txtpnNachricht.setText("Nachricht");
		txtpnNachricht.setBounds(50, 116, 158, 125);
		contentPane.add(txtpnNachricht);
		txtpnNachricht.setVisible(false);
		
		final JButton btnSend = new JButton("Send");
		btnSend.setBounds(244, 209, 117, 25);
		contentPane.add(btnSend);
		btnSend.setVisible(false);


		
		
		//ActionListener für btnRegistrieren
        btnRegistrieren.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                System.out.println("You clicked the button register");
                btnRegistrieren.setVisible(false);
                btnLogin.setVisible(false);
                txtBenutzername.setVisible(true);
                pwdPasswort.setVisible(true);
                btnRegistrieren_1.setVisible(true);
            }
        });
        
        //ActionListener für btnLogin
        btnLogin.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                System.out.println("You clicked the button login");
                btnRegistrieren.setVisible(false);
                btnLogin.setVisible(false);
                txtName.setVisible(true);
                btnLogin_1.setVisible(true);
        		pwdPasswort1.setVisible(true);
            }
        });    
        
        //ActionListener für btnLogin_1
        btnLogin_1.addActionListener(new ActionListener() {
        	 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                System.out.println("You clicked the button login1");
                int success = usecases.login(txtName.getText(),pwdPasswort1.getPassword());
                System.out.println(success);
                if (success == 1) {
            		lblSuccess1.setVisible(true);
            		txtEmpfaenger.setVisible(true);
            		txtpnNachricht.setVisible(true);
            		btnSend.setVisible(true);
            		txtName.setVisible(false);
                    btnLogin_1.setVisible(false);
            		pwdPasswort1.setVisible(false);
                    lblSuccess.setVisible(false);
                }
                if (success == 3) {
            		lblBenutzer.setVisible(true);
                }
                if (success == 2) {
                	lblFehler.setVisible(true);
                }
            }
        });    
        
		//ActionListener für btnRegistrieren_1
        btnRegistrieren_1.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                System.out.println("You clicked the button register1");
                int success = usecases.register(txtBenutzername.getText(),pwdPasswort.getPassword());
                //System.out.println(success);
                if (success == 1) {
                	txtBenutzername.setVisible(false);
                    pwdPasswort.setVisible(false);
                    btnRegistrieren_1.setVisible(false);
                    txtName.setVisible(true);
                    pwdPasswort1.setVisible(true);
                    btnLogin_1.setVisible(true);
                    lblSuccess.setVisible(true);
                    lblFehler.setVisible(false);
                    lblName.setVisible(false);
                }
                if (success == 3) {
                	lblName.setVisible(true);
                }
                if (success == 2) {
                	lblFehler.setVisible(true);
                }
            }
        });
		

	}
}
