package empops;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Updateemp extends JFrame {
	JMenu Employee, EmployeeDetail, Account, Utility;
	JMenuItem Add, Delete, Update, Show, Search, ShowSalary, Exit, Help;
	JMenuBar bar;
	JLabel jLabel, Name, Id, Sal, Email, Department, Contact;
	JTextField f1, f2, f3, f4, f5, f6;
	JButton button1, button2, button3;

	public Updateemp() {
		Employee = new JMenu("Employee");
		Add = new JMenuItem("Add");
		Delete = new JMenuItem("Delete");
		Update = new JMenuItem("Update");

		Add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new AddEmployee();
				dispose();

			}
		});

		Delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Deleteemp();
				dispose();

			}
		});

		Update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Updateemp();
				dispose();

			}
		});

		Employee.add(Add);
		Employee.add(Delete);
		Employee.add(Update);
		EmployeeDetail = new JMenu("Employee Details");
		Show = new JMenuItem("Show");
		Search = new JMenuItem("Search");
		Show.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Showemp();
				dispose();

			}
		});

		Search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Searchemp();
				dispose();

			}
		});
		EmployeeDetail.add(Search);
		EmployeeDetail.add(Show);
		Account = new JMenu("Account");
		ShowSalary = new JMenuItem("Employee salary");
		ShowSalary.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Salemp();
				dispose();

			}
		});
		Account.add(ShowSalary);
		Utility = new JMenu("Utilty");
		Exit = new JMenuItem("Exit");
		Help = new JMenuItem("Help");
		Utility.add(Help);
		Utility.add(Exit);
		Exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});

		jLabel = new JLabel("Add Employee");
		Name = new JLabel("Name");
		Id = new JLabel("Id");
		Sal = new JLabel("Salary");
		Email = new JLabel("Email");
		Department = new JLabel("Department");
		Contact = new JLabel("Contact");
		button1 = new JButton("Update");
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = f1.getText();
				String id = f2.getText();
				String sal = f3.getText();
				String email = f4.getText();
				String department = f5.getText();
				String contact = f6.getText();

				PreparedStatement ps;

				try {
					ps = db.Connec.getCon().prepareStatement(
							"update empdetail set name=?,salary=?,email=?,department=?,contact=? where id=?");
					ps.setString(1, name);
					ps.setString(2, sal);
					ps.setString(3, email);
					ps.setString(4, department);
					ps.setString(5, contact);
					ps.setString(6, id);
					ps.execute();
					JOptionPane.showMessageDialog(button1, "Data Updated");
					f1.setText("");
					f2.setText("");
					f3.setText("");
					f4.setText("");
					f5.setText("");
					f6.setText("");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		button2 = new JButton("Reset");
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				f1.setText("");
				f2.setText("");
				f3.setText("");
				f4.setText("");
				f5.setText("");
				f6.setText("");
			}
		});

		button3 = new JButton("Fetch");
		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = f2.getText();

				PreparedStatement ps;
				try {
					ps = db.Connec.getCon().prepareStatement("Select * from empdetail where id=?");
					ps.setString(1, id);
					ResultSet rs = ps.executeQuery();
					if (rs.next()) {
						f1.setText(rs.getString(1));
						f2.setText(rs.getString(2));
						f3.setText(rs.getString(3));
						f4.setText(rs.getString(4));
						f5.setText(rs.getString(5));
						f6.setText(rs.getString(6));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		f1 = new JTextField(20);
		f2 = new JTextField(20);
		f3 = new JTextField(20);
		f4 = new JTextField(20);
		f5 = new JTextField(20);
		f6 = new JTextField(20);

		bar = new JMenuBar();
		bar.setBounds(0, 0, 25, 800);
		bar.add(Employee);
		bar.add(EmployeeDetail);
		bar.add(Account);
		bar.add(Utility);
		setLayout(null);
		jLabel.setBounds(150, 50, 100, 25);
		Name.setBounds(50, 100, 100, 25);
		f1.setBounds(150, 100, 200, 25);
		Id.setBounds(50, 150, 100, 25);
		f2.setBounds(150, 150, 200, 25);
		Sal.setBounds(50, 200, 100, 25);
		f3.setBounds(150, 200, 200, 25);
		Email.setBounds(50, 250, 100, 25);
		f4.setBounds(150, 250, 200, 25);
		Department.setBounds(50, 300, 100, 25);
		f5.setBounds(150, 300, 200, 25);
		Contact.setBounds(50, 350, 100, 25);
		f6.setBounds(150, 350, 200, 25);
		button1.setBounds(100, 400, 100, 25);
		button2.setBounds(220, 400, 100, 25);
		button3.setBounds(350, 150, 100, 25);
		add(bar);
		add(jLabel);
		add(Name);
		add(f1);
		add(Id);
		add(f2);
		add(Sal);
		add(f3);
		add(Email);
		add(f4);
		add(Department);
		add(f5);
		add(Contact);
		add(f6);
		add(button1);
		add(button2);
		add(button3);

		add(bar);
		setJMenuBar(bar);
		setVisible(true);
		setSize(600, 600);

	}
}