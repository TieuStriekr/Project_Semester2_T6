package home;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import app.PhamarcyManagement;
import app.Receipt;
import app.Statistic;
import customerPackage.CustomerPage;
import drugTypePackage.DrugTypePage;
import loginPackage.Login;
import orderPackage.OrderDetailForm;
import orderPackage.OrderForm;
import supplierPackage.SupplierManagement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class HomePage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static HomePage instance;
	private JMenuBar menuBar;
	private JMenu mnSystem;
	private JMenu mnManagerment;
	private JMenu mnSettle;
	private JMenu mnStatistic;
	private JPanel pnCenterN;
	private JLabel lblPharmacySystemManagerment;
	private JPanel pnCenterC;
	private JPanel pnSouth;
	private JLabel lbImage_1;
	private JPanel pnCenterS;
	private Box b;
	private Box b1;
	private Component horizontalStrut;
	private Component horizontalStrut_1;
	private Box b2;
	private Component horizontalStrut_2;
	private Component horizontalStrut_3;
	private Box b3;
	private Component horizontalStrut_5;
	private Box b4;
	private Component horizontalStrut_7;
	private Box b5;
	private Component horizontalStrut_9;
	private JMenuItem mntmExit;
	private JMenuItem mntmMedicine;
	private JMenuItem mntmCustomers;
	private JMenuItem mntmSupplier;
	private JMenuItem mntmMedicine_type;
	private JMenuItem mntmSelling_medicine;
	private JMenuItem mntmSold_day;
	private JMenuItem mntmOrder;
	private JSeparator separator;
	private JMenuItem mntmOrderDetail;
	private JSeparator separator_1;
	public static HomePage getInstance() {
		if(instance == null) {
			instance = new HomePage();
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
					HomePage frame = new HomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomePage() {
		setTitle("Pharmacy Store");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200,700);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnSystem = new JMenu("SYSTEM");
		mnSystem.setIcon(new ImageIcon(HomePage.class.getResource("/picture/icons8-system-64.png")));
		mnSystem.setFont(new Font("Tahoma", Font.BOLD, 12));
		mnSystem.setForeground(Color.BLACK);
		menuBar.add(mnSystem);
		
		mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmExitActionPerformed(e);
			}
		});
		mntmExit.setBackground(Color.WHITE);
		mntmExit.setFont(new Font("Tahoma", Font.BOLD, 12));
		mnSystem.add(mntmExit);
		
		mnManagerment = new JMenu("MANAGERMENT");
		mnManagerment.setIcon(new ImageIcon(HomePage.class.getResource("/picture/icons8-management-64.png")));
		mnManagerment.setForeground(Color.BLACK);
		mnManagerment.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuBar.add(mnManagerment);
		
		mntmMedicine = new JMenuItem("Medicine");
		mntmMedicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmMedicineActionPerformed(e);
			}
		});
		mntmMedicine.setFont(new Font("Tahoma", Font.BOLD, 12));
		mnManagerment.add(mntmMedicine);
		
		mntmMedicine_type = new JMenuItem("Medicine type");
		mntmMedicine_type.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmMedicine_typeActionPerformed(e);
			}
		});
		mntmMedicine_type.setFont(new Font("Tahoma", Font.BOLD, 12));
		mnManagerment.add(mntmMedicine_type);
		
		separator = new JSeparator();
		mnManagerment.add(separator);
		
		mntmSupplier = new JMenuItem("Supplier");
		mntmSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmSupplierActionPerformed(e);
			}
		});
		mntmSupplier.setFont(new Font("Tahoma", Font.BOLD, 12));
		mnManagerment.add(mntmSupplier);
		
		mntmCustomers = new JMenuItem("Customers");
		mntmCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmCustomersActionPerformed(e);
			}
		});
		mntmCustomers.setFont(new Font("Tahoma", Font.BOLD, 12));
		mnManagerment.add(mntmCustomers);
		
		separator_1 = new JSeparator();
		mnManagerment.add(separator_1);
		
		mntmOrder = new JMenuItem("Order");
		mntmOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmOrderActionPerformed(e);
			}
		});
		mntmOrder.setFont(new Font("Tahoma", Font.BOLD, 12));
		mnManagerment.add(mntmOrder);
		
		mntmOrderDetail = new JMenuItem("Order Detail");
		mntmOrderDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmOrderDetailActionPerformed(e);
			}
		});
		mntmOrderDetail.setFont(new Font("Tahoma", Font.BOLD, 12));
		mnManagerment.add(mntmOrderDetail);
		
		mnSettle = new JMenu("SETTLE");
		mnSettle.setIcon(new ImageIcon(HomePage.class.getResource("/picture/icons8-handle-with-care-64.png")));
		mnSettle.setForeground(Color.BLACK);
		mnSettle.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuBar.add(mnSettle);
		
		mntmSelling_medicine = new JMenuItem("Selling medicine");
		mntmSelling_medicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmSelling_medicineActionPerformed(e);
			}
		});
		mntmSelling_medicine.setFont(new Font("Tahoma", Font.BOLD, 12));
		mnSettle.add(mntmSelling_medicine);
		
		mnStatistic = new JMenu("STATISTIC");
		mnStatistic.setIcon(new ImageIcon(HomePage.class.getResource("/picture/icons8-statistic-64.png")));
		mnStatistic.setFont(new Font("Tahoma", Font.BOLD, 12));
		mnStatistic.setForeground(Color.BLACK);
		menuBar.add(mnStatistic);
		
		mntmSold_day = new JMenuItem("Medicines sold during the day");
		mntmSold_day.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmSold_dayActionPerformed(e);
			}
		});
		mntmSold_day.setFont(new Font("Tahoma", Font.BOLD, 12));
		mnStatistic.add(mntmSold_day);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pnCenterN = new JPanel();
		pnCenterN.setBackground(new Color(100, 149, 237));
		pnCenterN.setPreferredSize(new Dimension(1000, 60));
		contentPane.add(pnCenterN, BorderLayout.NORTH);
        pnCenterN.setLayout(null);
		
		
		lblPharmacySystemManagerment = new JLabel("PHARMACY SYSTEM MANAGERMENT");
		lblPharmacySystemManagerment.setHorizontalAlignment(SwingConstants.CENTER);
		lblPharmacySystemManagerment.setBounds(358, 5, 468, 28);
		lblPharmacySystemManagerment.setForeground(new Color(255, 255, 255));
		lblPharmacySystemManagerment.setFont(new Font("Arial", Font.BOLD, 24));
		pnCenterN.add(lblPharmacySystemManagerment);
		
		pnCenterC = new JPanel();
		pnCenterC.setBackground(new Color(176, 224, 230));
		pnCenterC.setBounds(0, 60, 1184, 259);
		contentPane.add(pnCenterC);
		
		// Sử dụng FlowLayout cho pnCenterC để có kích thước tự động
        pnCenterC.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER, 0, 0));

		
		lbImage_1 = new JLabel();
		lbImage_1.setIcon(new ImageIcon(HomePage.class.getResource("/picture/bannerbg.png")));
	
		pnCenterC.add(lbImage_1);
		
		pnSouth = new JPanel();
		pnSouth.setPreferredSize(new Dimension(0, 50));
		pnSouth.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		pnSouth.setBackground(new Color(100, 149, 237));
		pnSouth.setBounds(0, 541, 1184, 50);
		contentPane.add(pnSouth);
		
		pnCenterS = new JPanel();
		pnCenterS.setBackground(new Color(176, 224, 230));
		pnCenterS.setBounds(0, 315, 1184, 254);
		contentPane.add(pnCenterS);
		
		b = Box.createVerticalBox();
		pnCenterS.add(b);
		
		b1 = Box.createHorizontalBox();
		b.add(b1);
		
		horizontalStrut = Box.createHorizontalStrut(200);
		b1.add(horizontalStrut);
		
		horizontalStrut_1 = Box.createHorizontalStrut(30);
		b1.add(horizontalStrut_1);
		
		b2 = Box.createHorizontalBox();
		b.add(b2);
		
		horizontalStrut_2 = Box.createHorizontalStrut(200);
		b2.add(horizontalStrut_2);
		
		horizontalStrut_3 = Box.createHorizontalStrut(30);
		b2.add(horizontalStrut_3);
		
		b3 = Box.createHorizontalBox();
		b.add(b3);
		
		horizontalStrut_5 = Box.createHorizontalStrut(30);
		b3.add(horizontalStrut_5);
		
		b4 = Box.createHorizontalBox();
		b.add(b4);
		
		horizontalStrut_7 = Box.createHorizontalStrut(30);
		b4.add(horizontalStrut_7);
		
		b5 = Box.createHorizontalBox();
		b.add(b5);
		
		horizontalStrut_9 = Box.createHorizontalStrut(30);
		b5.add(horizontalStrut_9);
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
	
	
	
	protected void mntmMedicineActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "Go to Medicine Management");
		var phamarcy = PhamarcyManagement.getInstance();
		if(!phamarcy.isVisible()) {
			phamarcy.setVisible(true);
			this.setVisible(false);
			phamarcy.setLocationRelativeTo(null);
		}
	}
	
	protected void mntmCustomersActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "Go to Customer Management");
		var customer = CustomerPage.getInstance();
		if(!customer.isVisible()) {
			customer.setVisible(true);
			this.setVisible(false);
			customer.setLocationRelativeTo(null);
		}
	}
	protected void mntmOrderActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "Go to Order Management");
		var order = OrderForm.getInstance();
		if(!order.isVisible()) {
			order.setVisible(true);
			this.setVisible(false);
			order.setLocationRelativeTo(null);
		}
	}
	protected void mntmOrderDetailActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "Go to Order Detail Management");
		var detail = OrderDetailForm.getInstance();
		if(!detail.isVisible()) {
			detail.setVisible(true);
			this.setVisible(false);
			detail.setLocationRelativeTo(null);
		}
		
	}
	protected void mntmSelling_medicineActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "Go to Receipt");
		var receipt = Receipt.getInstance();
		if(!receipt.isVisible()) {
			receipt.setVisible(true);
			this.setVisible(false);
			receipt.setLocationRelativeTo(null);
		}
	}
	protected void mntmMedicine_typeActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "Go to Medicine Type Management");
		var drugType = DrugTypePage.getInstance();
		if(!drugType.isVisible()) {
			drugType.setVisible(true);
			this.setVisible(false);
			drugType.setLocationRelativeTo(null);
		}
	}
	protected void mntmSupplierActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "Go to Supplier Management");
		var manu = SupplierManagement.getInstance();
		if(!manu.isVisible()) {
			manu.setVisible(true);
			this.setVisible(false);
			manu.setLocationRelativeTo(null);
		}
	}
	protected void mntmSold_dayActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "Go to Statistic");
		var sta = Statistic.getInstance();
		if(!sta.isVisible()) {
			sta.setVisible(true);
			this.setVisible(false);
			sta.setLocationRelativeTo(null);
		}
	}
}
