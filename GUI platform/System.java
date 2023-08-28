import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.GridLayout;


import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

public class System extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	JPanel panelAll, panelInput, panelAddButtons, panelDisplayArea;
	JLabel labelItemName, labelItemType, labelExpieryDate, labelPrice;
	JTextField txtItemName, txtItemType, txtExpieryDate, txtPrice;
	JButton btnHome, btnAddStock, btnViewStock, btnOrders, btnExit, btnSuppliers, btnCustomers;
	JMenuBar bar;
	JMenu usersMenu;
	
	
	
	public System() {
		super("Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnHome = new JButton("Home");
		btnAddStock = new JButton("Add Stock");
		btnViewStock = new JButton("View Stock");
		btnOrders = new JButton("Orders");
		btnExit = new JButton("Exit");
		btnSuppliers = new JButton("Suppliers");
		btnCustomers = new JButton("Customers");
		
		btnHome.addActionListener(this);
		btnAddStock.addActionListener(this);
		btnViewStock.addActionListener(this);
		btnOrders.addActionListener(this);
		btnExit.addActionListener(this);
		btnSuppliers.addActionListener(this);
		btnCustomers.addActionListener(this);
		
		
		usersMenu = new JMenu("Stock");
		usersMenu.add(btnAddStock);
		usersMenu.add(btnViewStock);
		
		
		bar = new JMenuBar();
		bar.add(btnHome);
		bar.add(usersMenu);
		bar.add(btnOrders);
		bar.add(btnSuppliers);
		bar.add(btnCustomers);
		bar.add(btnExit);
		
		
		panelAll = new JPanel(new BorderLayout());
		this.setTitle("Home Page");
		this.setSize(600,400);
		this.setVisible(true);
		this.add(panelAll);
		this.setJMenuBar(bar);
			
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == btnHome) {
			System systemFrame = new System();
		}
		else if (e.getSource() == btnAddStock) {
			Stock stockFrame = new Stock();
		}
		else if (e.getSource() == btnViewStock) {
			ViewItems viewFrame = new ViewItems();
		}
		else if (e.getSource() == btnOrders) {
			Orders ordersFrame = new Orders();
		}
		else if (e.getSource() == btnSuppliers) {
			Suppliers suppliersFrame = new Suppliers();
		}
		else if (e.getSource() == btnCustomers) {
			Customers customerFrame = new Customers();
		}
		else if (e.getSource() == btnOrders) {
			Orders ordersFrame = new Orders();
		}
		else if (e.getSource() == btnExit) {
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
		
	}
	
	public static void main(String[] args) {
        //Create and set up the window.
	System systemFrame = new System();
   
}


	public JTextField getTxtItemName() {
		return txtItemName;
	}


	public void setTxtItemName(JTextField txtItemName) {
		this.txtItemName = txtItemName;
	}


	public JTextField getTxtItemType() {
		return txtItemType;
	}


	public void setTxtItemType(JTextField txtItemType) {
		this.txtItemType = txtItemType;
	}


	public JTextField getTxtExpieryDate() {
		return txtExpieryDate;
	}


	public void setTxtExpieryDate(JTextField txtExpieryDate) {
		this.txtExpieryDate = txtExpieryDate;
	}


	public JTextField getTxtPrice() {
		return txtPrice;
	}


	public void setTxtPrice(JTextField txtPrice) {
		this.txtPrice = txtPrice;
	}

}