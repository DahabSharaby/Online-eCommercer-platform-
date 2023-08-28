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
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

public class Orders extends JFrame implements ActionListener{


	private String itemType;
	private int total;
	private Date expDate;
	private int total1;
	private int total2;
	private int total3;
	JPanel panelAll, panelInput, panelAddButtons, panelDisplayArea;
	JLabel labelItemName, labelItemType, labelExpieryDate, labelPrice;
	JTextField txtItemName, txtExpieryDate, txtPrice;
	JTextArea areaTxt, areaBlank;
	JButton btnHome, btnStock, btnOrders, btnExit, btnSuppliers, btnCustomers;
	JButton btnAdd, btnClear , btnReturn;
	JMenuBar bar;
	JComboBox productLst , txtItemType;
	
	static List<String> lstProductsREF;

	public Orders(List<String> lstProducts) {
		super("Stock page");
		
		lstProductsREF = lstProducts;

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

		String[] products = {"Luxury" , "Essential" , "Gift"};
		;
		btnHome = new JButton("Home");
		btnStock = new JButton("Stock");
		btnOrders = new JButton("Orders");
		btnExit = new JButton("Exit");
		btnSuppliers = new JButton("Suppliers");
		btnCustomers = new JButton("Customers");

		btnHome.addActionListener(this);
		btnStock.addActionListener(this);
		btnOrders.addActionListener(this);
		btnExit.addActionListener(this);
		btnSuppliers.addActionListener(this);
		btnCustomers.addActionListener(this);

		bar = new JMenuBar();
		bar.add(btnHome);
		bar.add(btnStock);
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


		labelItemType = new JLabel("Item Type: ");
		labelPrice = new JLabel("Item Quantity: ");



		txtItemType = new JComboBox(products);
		txtItemType.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				areaTxt.append("\nLuxury @20%\n" + "Essential @10%\n"+ "Gift @5%");
			}
		}              
		);

		txtPrice = new JTextField(20);



		panelInput.add(labelItemType);
		panelInput.add(txtItemType);
		panelInput.add(labelPrice);
		panelInput.add(txtPrice);


		btnAdd = new JButton("Add To Basket");


		btnAdd.addActionListener(new ActionListener()  {
				public void actionPerformed(ActionEvent e) { 
					total = total1 + total2 +total3;
		 			lstProducts.add(txtItemType.getSelectedItem()+"    "+txtPrice.getText());
		 			areaTxt.append('\n'+lstProducts.get(lstProducts.size()-1)+"\n" + "The total basket cost: "+total);
		 			txtPrice.setText(" ");

		 		}


		 	} );

		btnClear = new JButton("Calculate");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(txtItemType.getSelectedItem().equals("Luxury")){
					int quantity = Integer.parseInt(txtPrice.getText().trim());

					total1 = quantity * 60;



				}


			if(txtItemType.getSelectedItem().equals("Essential")){
				int quantity = Integer.parseInt(txtPrice.getText().trim());

				total2 = quantity * 33;


			}


		if(txtItemType.getSelectedItem().equals("Gift")){
			int quantity = Integer.parseInt(txtPrice.getText().trim());

			total3 = quantity * 21;


		}
	}



		});

		btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				Orders.this.dispose();

	 		}
		});
		panelAddButtons.add(btnAdd);
		panelAddButtons.add(btnClear);
		panelAddButtons.add(btnReturn);


		areaTxt = new JTextArea();
		panelDisplayArea.add(areaTxt, "Center");


		this.setTitle("Shopping Basket");
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
			System systemFrame = new System(lstProductsREF);
		}
		else if (e.getSource() == btnStock) {
			Stock stockFrame = new Stock();
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
	System sys = new System(lstProductsREF);

}


}