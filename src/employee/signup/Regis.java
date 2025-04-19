package employee.signup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

class Regis extends JFrame {
	JLabel Signup, name, email, contact, password;
	JTextField field1, field2, field3;
	JPasswordField field4;
	JButton button, button2, button3;

	public Regis() {
	

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

		Signup = new JLabel("Signup");
		name = new JLabel("Name");
		field1 = new JTextField(20);
		email = new JLabel("Email");
		field2 = new JTextField(20);
		contact = new JLabel("Contact");
		field3 = new JTextField(20);
		password = new JLabel("Password");
		field4 = new JPasswordField(20);
		button = new JButton("Signup");

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = field1.getText();
				String email = field2.getText();
				String contact = field3.getText();
				String password = new String(field4.getPassword());
				try {
					PreparedStatement ps = db.Connec.getCon()
							.prepareStatement("insert into signup values (?, ?, ?, ?)");
					ps.setString(1, name);
					ps.setString(2, email);
					ps.setString(3, contact);
					ps.setString(4, password);
					ps.executeUpdate();

				} catch (SQLException e1) {

				}
				new Login();
				dispose();
			}
		});
		button2 = new JButton("Reset");
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				field1.setText("");
				field2.setText("");
				field3.setText("");
				field4.setText("");

			}
		});
		button3 = new JButton("Login");
		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Login();
				dispose();

			}
		});
		setLayout(null);
		Signup.setBounds(150, 50, 100, 25);
		name.setBounds(50, 100, 100, 25);
		field1.setBounds(150, 100, 200, 25);
		email.setBounds(50, 150, 100, 25);
		field2.setBounds(150, 150, 200, 25);
		contact.setBounds(50, 200, 100, 25);
		field3.setBounds(150, 200, 200, 25);
		password.setBounds(50, 250, 100, 25);
		field4.setBounds(150, 250, 200, 25);
		button.setBounds(100, 300, 100, 25);
		button2.setBounds(250, 300, 100, 25);
		button3.setBounds(100, 350, 100, 25);

		add(Signup);
		add(name);
		add(field1);
		add(email);
		add(field2);
		add(contact);
		add(field3);
		add(password);
		add(field4);
		add(button);
		add(button2);
		add(button3);
		setVisible(true);
		setSize(600, 600);
	}

	public static void main(String[] args) {
		new Regis();
	}
}
