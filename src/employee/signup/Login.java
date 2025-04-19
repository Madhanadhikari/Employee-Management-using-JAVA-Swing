package employee.signup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import masterpages.Home;

public class Login extends JFrame {
	JLabel Login, email, password;
	JTextField field1;
	JPasswordField field2;
	JButton button, button2,button3;

	public Login() {
		

		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem exitItem = new JMenuItem("Exit");

		exitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		fileMenu.add(exitItem);
		menuBar.add(fileMenu);
		setJMenuBar(menuBar);

		Login = new JLabel("Login");
		email = new JLabel("Email");
		password = new JLabel("Password");
		field1 = new JTextField(20);
		field2 = new JPasswordField(20);
		button = new JButton("Login");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String email=field1.getText();
				String password= new String(field2.getPassword());
				
				PreparedStatement ps;
				try {
					ps=db.Connec.getCon().prepareStatement("select *  from signup where email=? and password=?");
					ps.setString(1, email);
					ps.setString(2, password);
					ResultSet rs=ps.executeQuery();
					if(rs.next()){
						new Home();
						dispose();
					}else {
						new Regis();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		button2 = new JButton("Reset");
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				email.setText("");
				password.setText("");

			}
		});
		button3=new JButton("Signup");
		button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
                     new Regis();
                     dispose();
				
			}
		});
		setLayout(null);
		Login.setBounds(150, 50, 100, 25);
		email.setBounds(50, 100, 100, 25);
		field1.setBounds(150, 100, 200, 25);
		password.setBounds(50, 150, 100, 25);
		field2.setBounds(150, 150, 200, 25);
        button.setBounds(100, 200, 100, 25);
        button2.setBounds(250, 200, 100, 25);
        button3.setBounds(100, 250, 100,25);
		add(Login);
		add(email);
		add(field1);
		add(password);
		add(field2);
		add(button);
		add(button2);
		add(button3);
		setVisible(true);
		setSize(400, 400);
		

	}

	public static void main(String[] args) {
		new Login();
	}
}
