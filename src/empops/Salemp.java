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

public class Salemp extends JFrame {
	JMenu Employee, EmployeeDetail, Account, Utility;
	JMenuItem Add, Delete, Update, Show, Search, ShowSalary, Exit, Help;
	JMenuBar bar;
	JLabel jLabel, id;
	JTextField field;
	JButton button1, button2;

	public Salemp() {

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

		jLabel = new JLabel("Salary Record");
		id = new JLabel("Id");
		field = new JTextField(20);
		button1 = new JButton("Get salary");
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = field.getText();
				PreparedStatement ps;
				try {
					ps = db.Connec.getCon().prepareStatement("select salary from empdetail where id =?");
					ps.setString(1, id);
					ResultSet rs = ps.executeQuery();
					if (rs.next()) {
						JOptionPane.showMessageDialog(button1,
								"Employee s salary with Id " + id + " is " + rs.getString(1));
					} else {
						JOptionPane.showMessageDialog(button1, "Record not found");
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
				field.setText("");

			}
		});

		bar = new JMenuBar();
		bar.setBounds(0, 0, 25, 800);
		bar.add(Employee);
		bar.add(EmployeeDetail);
		bar.add(Account);
		bar.add(Utility);
		setLayout(null);
		jLabel.setBounds(150, 50, 150, 25);
		id.setBounds(50, 100, 100, 25);
		field.setBounds(150, 100, 200, 25);
		button1.setBounds(50, 150, 100, 25);
		button2.setBounds(170, 150, 100, 25);

		add(bar);
		add(jLabel);
		add(id);
		add(field);
		add(button1);
		add(button2);
		add(bar);
		setJMenuBar(bar);
		setVisible(true);
		setSize(400, 400);
	}
}
