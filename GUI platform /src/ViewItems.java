import java.awt.*;


import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;



public class ViewItems extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	JPanel panelAll, panelInput, panelAddButtons, panelDisplayArea;
	JTextArea areaTxt;
	JLabel labelItemName, labelItemType, labelExpieryDate, labelPrice;
	JTextField txtItemName, txtItemType, txtExpieryDate, txtPrice;
	JButton btnHome, btnAddStock, btnViewStock, btnOrders, btnExit, btnSuppliers, btnCustomers, btnDelete, btnPrint;
	JMenuBar bar;
	JMenu usersMenu;
	
	static List<String> lstProductsREF;
	
	
	public ViewItems(List<String> lstProducts) {
		super("View Items Page");
		
		lstProductsREF = lstProducts;
		
		this.setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panelAddButtons = new JPanel();
		panelDisplayArea = new JPanel(new BorderLayout());
		panelDisplayArea.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED), "Items: "));
		
		
		panelDisplayArea.setPreferredSize(new Dimension(550, 500));
		panelDisplayArea.setMaximumSize(new Dimension(10000, 200));
		panelDisplayArea.setMinimumSize(new Dimension(300, 200));
		
		this.add(panelAddButtons, "South");
		this.add(panelDisplayArea, "Center");
		
		
		btnPrint = new JButton("Print Items");
		btnHome = new JButton("Home");
		btnAddStock = new JButton("Add Stock");
		btnViewStock = new JButton("View Stock");
		btnOrders = new JButton("Orders");
		btnExit = new JButton("Exit");
		btnSuppliers = new JButton("Suppliers");
		btnCustomers = new JButton("Customers");
		
		txtItemName = new JTextField(20);
		txtItemType = new JTextField(20);
		txtExpieryDate = new JTextField(20);
		txtPrice = new JTextField(20);
		
		btnPrint.addActionListener(this);
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
		
		areaTxt = new JTextArea();
		panelDisplayArea.add(areaTxt);
		
		panelAddButtons.add(btnPrint);
		
		btnPrint.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) { 
			     
	 			lstProducts.add(txtItemName.getText()+"    "+txtItemType.getText().toString()+"     "+txtExpieryDate.getText()+"    "+txtPrice.getText());
	 			areaTxt.append(lstProducts.get(lstProducts.size()-1)+"\n");
	 		}
	 	} );
		
		
		bar = new JMenuBar();
		bar.add(btnHome);
		bar.add(usersMenu);
		bar.add(btnOrders);
		bar.add(btnSuppliers);
		bar.add(btnCustomers);
		bar.add(btnExit);
		
		
		panelAll = new JPanel(new BorderLayout());
		this.setTitle("View Items Page");
		this.setSize(600,400);
		this.setVisible(true);
		this.add(panelAll);
		this.setJMenuBar(bar);
			
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


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == btnHome) {
			System systemFrame = new System(lstProductsREF);
		}
		else if (e.getSource() == btnAddStock) {
			Stock stockFrame = new Stock();
		}
		else if (e.getSource() == btnViewStock) {
			ViewItems viewFrame = new ViewItems(lstProductsREF);
		}
		else if (e.getSource() == btnOrders) {
			Orders ordersFrame = new Orders(lstProductsREF);
		}
		else if (e.getSource() == btnSuppliers) {
			Suppliers suppliersFrame = new Suppliers();
		}
		else if (e.getSource() == btnCustomers) {
			Customers customerFrame = new Customers();
		}
		else if (e.getSource() == btnExit) {
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
		
	}
	
	public static void main(String[] args) {
        //Create and set up the window.
	System systemFrame = new System(lstProductsREF);
   
}

}