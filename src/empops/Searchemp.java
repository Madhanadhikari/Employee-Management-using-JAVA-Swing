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

public class Searchemp extends JFrame {
	JMenu Employee, EmployeeDetail, Account, Utility;
    JMenuItem Add, Delete, Update, Show, Search, ShowSalary, Exit, Help;
    JMenuBar bar;
    JLabel jLabel, id, nameLabel, IDLabel, salLabel, emailLabel, departmentLabel, contactLabel;
    JLabel name, ID, sal, email, department, contact;
    JTextField field;
    JButton button1, button2;

    public Searchemp() {
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

        Utility = new JMenu("Utility");
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

        jLabel = new JLabel("Search Employee Record");
        id = new JLabel("Id");
        nameLabel = new JLabel("Name");
        IDLabel = new JLabel("ID");
        salLabel = new JLabel("Salary");
        emailLabel = new JLabel("Email");
        departmentLabel = new JLabel("Department");
        contactLabel = new JLabel("Contact");

        name = new JLabel();
        ID = new JLabel();
        sal = new JLabel();
        email = new JLabel();
        department = new JLabel();
        contact = new JLabel();

        field = new JTextField(20);
        button1 = new JButton("Search");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = field.getText();
                PreparedStatement ps;
                try {
                    ps = db.Connec.getCon().prepareStatement("select * from empdetail where id =?");
                    ps.setString(1, id);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        name.setText(rs.getString(1));
                        ID.setText(rs.getString(2));
                        sal.setText(rs.getString(3));
                        email.setText(rs.getString(4));
                        department.setText(rs.getString(5));
                        contact.setText(rs.getString(6));
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        button2 = new JButton("Reset");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText("");
                name.setText("");
                ID.setText("");
                sal.setText("");
                email.setText("");
                department.setText("");
                contact.setText("");
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

        nameLabel.setBounds(50, 200, 100, 25);
        name.setBounds(150, 200, 200, 25);
        IDLabel.setBounds(50, 230, 100, 25);
        ID.setBounds(150, 230, 200, 25);
        salLabel.setBounds(50, 260, 100, 25);
        sal.setBounds(150, 260, 200, 25);
        emailLabel.setBounds(50, 290, 100, 25);
        email.setBounds(150, 290, 200, 25);
        departmentLabel.setBounds(50, 320, 100, 25);
        department.setBounds(150, 320, 200, 25);
        contactLabel.setBounds(50, 350, 100, 25);
        contact.setBounds(150, 350, 200, 25);

        add(jLabel);
        add(id);
        add(field);
        add(button1);
        add(button2);
        add(nameLabel);
        add(name);
        add(IDLabel);
        add(ID);
        add(salLabel);
        add(sal);
        add(emailLabel);
        add(email);
        add(departmentLabel);
        add(department);
        add(contactLabel);
        add(contact);
        add(bar);

        setJMenuBar(bar);
        setVisible(true);
        setSize(600, 600);
	}
	public static void main(String[] args) {
		 new Searchemp();
	}
}
