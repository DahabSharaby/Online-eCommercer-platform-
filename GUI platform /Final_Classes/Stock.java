import java.awt.BorderLayout;


import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import java.text.ParseException;
import java.text.SimpleDateFormat; 
import java.util.Date;

public class Stock extends JFrame implements ActionListener{

	
	JPanel panelAll, panelInput, panelAddButtons, panelDisplayArea;
	JLabel labelItemName, labelItemType, labelExpieryDate, labelPrice;
	JTextField txtItemName, txtExpieryDate, txtPrice;
	JTextArea areaTxt, areaBlank;
	JButton btnHome, btnAddStock, btnViewStock, btnOrders, btnExit, btnSuppliers, btnCustomers;
	JButton btnAdd, btnClear , btnReturn;
	JMenuBar bar;
	JComboBox productLst , txtItemType;
	JMenu usersMenu;
	
	static List<String> lstProducts;
	
	
	public Stock() {
		super("Stock page");
		
		this.setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelInput = new JPanel(new GridLayout(0,1));
		panelAddButtons = new JPanel();
		panelDisplayArea = new JPanel(new BorderLayout());
		
		panelInput.setPreferredSize(new Dimension(200, 500));
		panelInput.setMaximumSize(new Dimension(10000, 200));
		
		panelDisplayArea.setPreferredSize(new Dimension(550, 500));
		panelDisplayArea.setMaximumSize(new Dimension(10000, 200));
		panelDisplayArea.setMinimumSize(new Dimension(300, 200));
		
		panelInput.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED), "Input Details"));
		panelDisplayArea.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED), "Items: "));
		
		lstProducts = new ArrayList<>();
		String[] products = {"Luxury" , "Essential" , "Gift"};
		
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
		this.add(panelAll);
		this.setJMenuBar(bar);
		
		this.add(panelInput, "West");
		this.add(panelAddButtons, "South");
		this.add(panelDisplayArea, "East");
		
		
		labelItemName = new JLabel("Item Name: ");
		labelItemType = new JLabel("Item Type: ");
		labelPrice = new JLabel("Item Quantity: ");
		labelExpieryDate = new JLabel("Item Expiery Date: ");
		
		txtItemName = new JTextField(20);
		txtItemType = new JComboBox(products);
		txtExpieryDate = new JTextField(20);
		txtPrice = new JTextField(20);
		
		panelInput.add(labelItemName);
		panelInput.add(txtItemName);
		panelInput.add(labelItemType);
		panelInput.add(txtItemType);
		panelInput.add(labelPrice);
		panelInput.add(txtPrice);
		panelInput.add(labelExpieryDate);
		panelInput.add(txtExpieryDate);
		
		
		
		String date = txtExpieryDate.getText();

		
		btnAdd = new JButton("Add");
		
		
		btnAdd.addActionListener(new ActionListener()  {
				public void actionPerformed(ActionEvent e) { 
					
					
		 			lstProducts.add(txtItemName.getText()+"    "+txtItemType.getSelectedItem().toString()+"     "+txtExpieryDate.getText()+"    "+txtPrice.getText());
		 			areaTxt.append(lstProducts.get(lstProducts.size()-1)+"\n");
		 		}
		 	} );
		
		
	   	
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				txtItemName.setText("");
				txtExpieryDate.setText("00/00/0000");
				txtPrice.setText("");
				areaTxt.setText("");
			}
			
		});
		
		btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				Stock.this.dispose();
	 			
	 		}
		});
		panelAddButtons.add(btnAdd);
		panelAddButtons.add(btnClear);
		panelAddButtons.add(btnReturn);
		
		
		areaTxt = new JTextArea();
		panelDisplayArea.add(areaTxt, "Center");
		
		
		this.setTitle("Add Stock Page");
		this.setSize(800,400);
		this.setVisible(true);
		
	}
	
	
	public JTextField getTxtItemName() {
		return txtItemName;
	}


	public void setTxtItemName(JTextField txtItemName) {
		this.txtItemName = txtItemName;
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


	public JComboBox getTxtItemType() {
		return txtItemType;
	}


	public void setTxtItemType(JComboBox txtItemType) {
		this.txtItemType = txtItemType;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnHome) {
			System systemFrame = new System(lstProducts);
		}
		else if (e.getSource() == btnAddStock) {
			Stock stockFrame = new Stock();
		}
		else if (e.getSource() == btnViewStock) {
			ViewItems viewFrame = new ViewItems(lstProducts);
		}
		else if (e.getSource() == btnOrders) {
			Orders ordersFrame = new Orders(lstProducts);
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
	System sys = new System(lstProducts);
   
}
	
	
}