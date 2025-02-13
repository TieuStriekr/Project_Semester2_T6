package app;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

import customerPackage.CustomerPage;
import dao.StatisticDAO;
import drugTypePackage.DrugTypePage;
import home.HomePage;
import loginPackage.Login;
import orderPackage.OrderDetailForm;
import orderPackage.OrderForm;
import supplierPackage.SupplierManagement;

import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Statistic extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmHome;
	private JMenuItem mntmReceipt;
	private JMenuItem mntmStatistic;
	private JMenuItem mntmExit;
	private JMenu mnNewMenu_1;
	private JMenuItem mnMedicine;
	private JMenuItem mnMedicineType;
	private JSeparator separator;
	private JMenuItem mnSupplier;
	private JMenuItem mnCustomer;
	private JSeparator separator_1;
	private JMenuItem mnOrder;
	private JMenuItem mnOrderDetail;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JDateChooser dateChooser;
	private JLabel lblNewLabel_1;
	private JButton btnSearch;
	private JButton btnRefresh;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblNewLabel_2;
	private JLabel lblTotalAmount;
	private JLabel lblNewLabel_3;
	private JLabel lblDate;
	private JLabel lblNewLabel_4;
	private JLabel lblTotalQuantity;
	private static Statistic instance;
	public static Statistic getInstance() {
		if(instance == null) {
			instance = new Statistic();
		}
		return instance;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Statistic frame = new Statistic();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Statistic() {
		setTitle("Phamarcy Store");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1354, 740);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Open");
		menuBar.add(mnNewMenu);
		
		mntmHome = new JMenuItem("Home");
		mntmHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmHomeActionPerformed(e);
			}
		});
		mnNewMenu.add(mntmHome);
		
		mntmReceipt = new JMenuItem("Receipt");
		mntmReceipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmReceiptActionPerformed(e);
			}
		});
		mnNewMenu.add(mntmReceipt);
		
		mntmStatistic = new JMenuItem("Statistic");
		mntmStatistic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmStatisticActionPerformed(e);
			}
		});
		mnNewMenu.add(mntmStatistic);
		
		mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmExitActionPerformed(e);
			}
		});
		mnNewMenu.add(mntmExit);
		
		mnNewMenu_1 = new JMenu("Management");
		menuBar.add(mnNewMenu_1);
		
		mnMedicine = new JMenuItem("Medicine");
		mnMedicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mnMedicineActionPerformed(e);
			}
		});
		mnNewMenu_1.add(mnMedicine);
		
		mnMedicineType = new JMenuItem("Medicine Type");
		mnMedicineType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mnMedicineTypeActionPerformed(e);
			}
		});
		mnNewMenu_1.add(mnMedicineType);
		
		separator = new JSeparator();
		mnNewMenu_1.add(separator);
		
		mnSupplier = new JMenuItem("Supplier");
		mnSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mnSupplierActionPerformed(e);
			}
		});
		mnNewMenu_1.add(mnSupplier);
		
		mnCustomer = new JMenuItem("Customer");
		mnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mnCustomerActionPerformed(e);
			}
		});
		mnNewMenu_1.add(mnCustomer);
		
		separator_1 = new JSeparator();
		mnNewMenu_1.add(separator_1);
		
		mnOrder = new JMenuItem("Order");
		mnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mnOrderActionPerformed(e);
			}
		});
		mnNewMenu_1.add(mnOrder);
		
		mnOrderDetail = new JMenuItem("Order Detail");
		mnOrderDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mnOrderDetailActionPerformed(e);
			}
		});
		mnNewMenu_1.add(mnOrderDetail);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(176, 224, 230));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(70, 70, 1200, 550);
		contentPane.add(panel);
		panel.setLayout(null);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(47, 49, 152, 28);
		panel.add(dateChooser);
		
		lblNewLabel_1 = new JLabel("Find by date:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(48, 10, 107, 28);
		panel.add(lblNewLabel_1);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSearchActionPerformed(e);
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch.setBounds(250, 49, 107, 28);
		panel.add(btnSearch);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRefreshActionPerformed(e);
			}
		});
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRefresh.setBounds(402, 49, 107, 28);
		panel.add(btnRefresh);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Statistic List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(47, 112, 1100, 286);
		panel.add(panel_1);
		panel_1.setBackground(new Color(176, 224, 230));
		panel_1.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 20, 1055, 250);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		lblNewLabel_2 = new JLabel("Total Amount:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(834, 408, 107, 28);
		panel.add(lblNewLabel_2);
		
		lblTotalAmount = new JLabel("");
		lblTotalAmount.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotalAmount.setBounds(978, 408, 140, 28);
		panel.add(lblTotalAmount);
		
		lblNewLabel_3 = new JLabel("Date:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(834, 457, 107, 28);
		panel.add(lblNewLabel_3);
		
		lblDate = new JLabel("");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDate.setBounds(978, 457, 140, 28);
		panel.add(lblDate);
		
		lblNewLabel_4 = new JLabel("Total Quantity:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(834, 498, 110, 28);
		panel.add(lblNewLabel_4);
		
		lblTotalQuantity = new JLabel("");
		lblTotalQuantity.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotalQuantity.setBounds(978, 498, 140, 28);
		panel.add(lblTotalQuantity);
		
		lblNewLabel = new JLabel("STATISTIC");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(448, 10, 483, 36);
		contentPane.add(lblNewLabel);
	}
	
	protected void btnSearchActionPerformed(ActionEvent e) {
		if(dateChooser.getDate() == null) {
			JOptionPane.showMessageDialog(this, "Please enter date to search");
			return;
		}
		var model = new DefaultTableModel();
		model.addColumn("Date");
		model.addColumn("Drug Name");
		model.addColumn("Quantity");
		model.addColumn("Unit");
		model.addColumn("Price");
		var dao = new StatisticDAO();
		var orderDate = LocalDate.ofInstant(dateChooser.getDate().toInstant(),ZoneId.systemDefault());
		dao.selectReceipt(orderDate).stream().forEach(statistic-> model.addRow(new Object[] {
				statistic.getOrderDate(),statistic.getProductName(),statistic.getQuantity()
				,statistic.getUnit(),statistic.getPriceEach()
			}));
		table.setModel(model);
		var totalAmount = dao.amountStatistic(orderDate);
		var totalQuantity = dao.quantityStatistic(orderDate);
		if(totalAmount == null) {
			lblTotalAmount.setText("0 VND");
		}else {
			lblTotalAmount.setText(totalAmount + " VND");
		}
		lblDate.setText(orderDate.toString());
		lblTotalQuantity.setText(String.valueOf(totalQuantity));
		
	}
	protected void btnRefreshActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "Refresh");
		var model = ( DefaultTableModel)table.getModel();
		model.setRowCount(0);
		var dao = new StatisticDAO();
		var orderDate = LocalDate.ofInstant(dateChooser.getDate().toInstant(),ZoneId.systemDefault());
		dao.selectReceipt(orderDate).stream().forEach(statistic-> model.addRow(new Object[] {
				statistic.getOrderDate(),statistic.getProductName(),statistic.getQuantity()
				,statistic.getUnit(),statistic.getPriceEach()
			}));
	}
	
	//Menu
	protected void mntmHomeActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "Go to Home");
		var home = HomePage.getInstance();
		if(!home.isVisible()) {
			home.setVisible(true);
			this.setVisible(false);
			home.setLocationRelativeTo(null);
		}
	}
	
	protected void mntmReceiptActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "Go to Receipt");
		var receipt = Receipt.getInstance();
		if(!receipt.isVisible()) {
			receipt.setVisible(true);
			this.setVisible(false);
			receipt.setLocationRelativeTo(null);
		}
	}
	
	protected void mntmStatisticActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "Go to Statistic");
		var sta = Statistic.getInstance();
		if(!sta.isVisible()) {
			sta.setVisible(true);
			this.setVisible(false);
			sta.setLocationRelativeTo(null);
		}
	}
	
	protected void mntmExitActionPerformed(ActionEvent e) {
		var login = Login.getInstance();
		if(!login.isVisible()) {
			login.setVisible(true);
			this.setVisible(false);
			login.setLocationRelativeTo(null);
		}
		JOptionPane.showMessageDialog(this, "Log out successful");
	}
	
	protected void mnMedicineActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "Go to Medicine Management");
		var phamarcy = PhamarcyManagement.getInstance();
		if(!phamarcy.isVisible()) {
			phamarcy.setVisible(true);
			this.setVisible(false);
			phamarcy.setLocationRelativeTo(null);
		}
	}
	
	protected void mnMedicineTypeActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "Go to Medicine Type Management");
		var drugType = DrugTypePage.getInstance();
		if(!drugType.isVisible()) {
			drugType.setVisible(true);
			this.setVisible(false);
			drugType.setLocationRelativeTo(null);
		}
	}
	
	protected void mnSupplierActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "Go to Supplier Management");
		var manu = SupplierManagement.getInstance();
		if(!manu.isVisible()) {
			manu.setVisible(true);
			this.setVisible(false);
			manu.setLocationRelativeTo(null);
		}
	}
	
	protected void mnCustomerActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "Go to Customer Management");
		var customer = CustomerPage.getInstance();
		if(!customer.isVisible()) {
			customer.setVisible(true);
			this.setVisible(false);
			customer.setLocationRelativeTo(null);
		}
	}
	
	protected void mnOrderActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "Go to Order Management");
		var order = OrderForm.getInstance();
		if(!order.isVisible()) {
			order.setVisible(true);
			this.setVisible(false);
			order.setLocationRelativeTo(null);
		}
	}
	
	protected void mnOrderDetailActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "Go to Order Detail Management");
		var detail = OrderDetailForm.getInstance();
		if(!detail.isVisible()) {
			detail.setVisible(true);
			this.setVisible(false);
			detail.setLocationRelativeTo(null);
		}
	}
}
