package masterpages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import empops.AddEmployee;
import empops.Deleteemp;
import empops.Searchemp;
import empops.Showemp;
import empops.Updateemp;

public class Account extends JFrame{
	JMenu Employee, EmployeeDetail, Account, Utility;
	JMenuItem Add, Delete, Update, Show, Search, ShowSalary, Exit, Help;
	JMenuBar bar;

	public Account() {

		Employee = new JMenu("Employee");
		Add=new JMenuItem("Add");
		Delete=new JMenuItem("Delete");
		Update=new JMenuItem("Update");
		
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
		Show=new JMenuItem("Show");
		Search=new JMenuItem("Search");
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
		ShowSalary=new JMenuItem("Employee salary");
		Account.add(ShowSalary);
		Utility = new JMenu("Utilty");
		Exit = new JMenuItem("Exit");
		Help = new JMenuItem("Help");
		Utility.add(Help);
		Utility.add(Exit);

		bar = new JMenuBar();
		bar.setBounds(0, 0, 25, 800);
		bar.add(Employee);
		bar.add(EmployeeDetail);
		bar.add(Account);
		bar.add(Utility);
		setLayout(null);
		add(bar);
		setJMenuBar(bar);
		setVisible(true);
		setSize(400, 400);

		
	}
	public static void main(String[] args) {
		new Account();
	}
}
