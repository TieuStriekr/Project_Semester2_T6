package app;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import customerPackage.CustomerPage;
import dao.CustomerDAO;
import dao.DrugDAO;
import dao.OrderDAO;
import dao.OrderDetailDAO;
import dao.ReceiptDAO;
import drugTypePackage.DrugTypePage;
import entity.Customer;
import entity.Order;
import entity.OrderDetail;
import home.HomePage;
import loginPackage.Login;
import orderPackage.OrderDetailForm;
import orderPackage.OrderForm;
import supplierPackage.SupplierManagement;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

import javax.swing.border.EtchedBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import java.time.LocalDate;
import java.time.ZoneId;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Receipt extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelReceipt;
	private JLabel lblReceipt;
	private JPanel panel_ReceiptInfo;
	private JPanel panel_MedicineList;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panel_Function;
	private JLabel lblNewLabel;
	private JTextField txtSearch;
	private JButton btnSearch;
	private JButton btnPrevious;
	private JTextField txtPage;
	private JButton btnNext;
	private JLabel lblTypeSearch;
	private JRadioButton cbDrugName;
	private JRadioButton cbDrugType;
	private JRadioButton cbDrugUsage;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnInform;
	private JPanel panel_Medicine;
	private JButton btnForward;
	private JButton btnClear;
	private JButton btnFinish;
	private JLabel lblNewLabel_1;
	private JTextField txtMedicine;
	private JLabel lblNewLabel_2;
	private JTextField txtQuantity;
	private JLabel lblNewLabel_3;
	private JTextField txtPrice;
	private JLabel lblNewLabel_4;
	private JTextField txtPayment;
	private JLabel lblNewLabel_5;
	private JDateChooser dateChooser;
	private JPanel panel_Customer;
	private JLabel lblNewLabel_6;
	private JTextField txtCusName;
	private JLabel lblNewLabel_7;
	private JTextField txtPhone;
	private JLabel lblGender;
	private JRadioButton checkMale;
	private JRadioButton checkFemale;
	private Integer pageNumber =1;
	private Integer rowOfPage =10;
	private Integer totalCount =0;
	private Double totalPage =0.0;
	private JButton btnPrint;
	private JButton btnRefresh;
	private static Receipt instance;
	private JPanel panelPrintReceipt;
	private JLabel lblName;
	private JLabel lblPhone;
	private JLabel lblGenderInfo;
	private JLabel lblInputName;
	private JLabel lblInputPhone;
	private JLabel lblInputGender;
	private JLabel lblPay;
	private JLabel lblInputPay;
	private JPanel panel_1;
	private JScrollPane scrollPaneReceipt;
	private JTable tableReceipt;
	private JLabel lblNewLabel_16;
	private JLabel lblInputAmount;
	private JButton btnOk;
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
	public static Receipt getInstance() {
		if(instance == null) {
			instance = new Receipt();
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
					Receipt frame = new Receipt();
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
	public Receipt() {
		setTitle("Pharmacy Store");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1354, 772);
		
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(176, 224, 230));
		
		lblReceipt = new JLabel("RECEIPT");
		lblReceipt.setBounds(593, 10, 154, 43);
		lblReceipt.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceipt.setForeground(Color.RED);
		lblReceipt.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblReceipt.setBackground(Color.BLACK);
		
		panel_ReceiptInfo = new JPanel();
		panel_ReceiptInfo.setBounds(41, 83, 1225, 212);
		
		panel_MedicineList = new JPanel();
		panel_MedicineList.setBounds(41, 339, 1225, 212);
		panel_MedicineList.setBorder(new TitledBorder(null, "Medicine List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		panel_Function = new JPanel();
		panel_Function.setBounds(41, 598, 1225, 100);
		panel_Function.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Receipt Function", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		lblNewLabel = new JLabel("Search by:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtSearch = new JTextField();
		txtSearch.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSearchActionPerformed(e);
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPreviousActionPerformed(e);
			}
		});
		btnPrevious.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		txtPage = new JTextField();
		txtPage.setText("1");
		txtPage.setHorizontalAlignment(SwingConstants.CENTER);
		txtPage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPage.setColumns(10);
		
		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNextActionPerformed(e);
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		lblTypeSearch = new JLabel("Type Search:");
		lblTypeSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		cbDrugName = new JRadioButton("Name");
		cbDrugName.setSelected(true);
		buttonGroup.add(cbDrugName);
		cbDrugName.setBackground(new Color(255, 255, 255));
		cbDrugName.setHorizontalAlignment(SwingConstants.CENTER);
		cbDrugName.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		cbDrugType = new JRadioButton("Type");
		buttonGroup.add(cbDrugType);
		cbDrugType.setBackground(new Color(255, 255, 255));
		cbDrugType.setHorizontalAlignment(SwingConstants.CENTER);
		cbDrugType.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		cbDrugUsage = new JRadioButton("Usage");
		buttonGroup.add(cbDrugUsage);
		cbDrugUsage.setBackground(new Color(255, 255, 255));
		cbDrugUsage.setHorizontalAlignment(SwingConstants.CENTER);
		cbDrugUsage.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		scrollPane = new JScrollPane();
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
			}
		});
		scrollPane.setViewportView(table);
		
		btnInform = new JButton("Next");
		btnInform.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnInformActionPerformed(e);
			}
		});
		btnInform.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInform.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		panel_Medicine = new JPanel();
		panel_Medicine.setBorder(new TitledBorder(null, "Receipt Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Medicine.setBackground(new Color(255, 255, 255));
		panel_Medicine.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Medicine:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 30, 108, 27);
		panel_Medicine.add(lblNewLabel_1);
		
		txtMedicine = new JTextField();
		txtMedicine.setColumns(10);
		txtMedicine.setBounds(125, 31, 183, 25);
		panel_Medicine.add(txtMedicine);
		
		lblNewLabel_2 = new JLabel("Quantity:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 76, 97, 27);
		panel_Medicine.add(lblNewLabel_2);
		
		txtQuantity = new JTextField();
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(125, 79, 183, 25);
		panel_Medicine.add(txtQuantity);
		
		lblNewLabel_3 = new JLabel("Price:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 124, 97, 27);
		panel_Medicine.add(lblNewLabel_3);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(125, 125, 183, 25);
		panel_Medicine.add(txtPrice);
		
		lblNewLabel_4 = new JLabel("Payment Type:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(370, 30, 108, 27);
		panel_Medicine.add(lblNewLabel_4);
		
		txtPayment = new JTextField();
		txtPayment.setColumns(10);
		txtPayment.setBounds(488, 31, 183, 25);
		panel_Medicine.add(txtPayment);
		
		lblNewLabel_5 = new JLabel("Order Date:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(373, 76, 97, 27);
		panel_Medicine.add(lblNewLabel_5);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(488, 77, 183, 25);
		panel_Medicine.add(dateChooser);
		
		btnForward = new JButton("Forward");
		btnForward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnForwardActionPerformed(e);
			}
		});
		btnForward.setEnabled(false);
		btnForward.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClearActionPerformed(e);
			}
		});
		btnClear.setHorizontalTextPosition(SwingConstants.CENTER);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		btnFinish = new JButton("Finish");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFinishActionPerformed(e);
			}
		});
		btnFinish.setEnabled(false);
		btnFinish.setHorizontalTextPosition(SwingConstants.CENTER);
		btnFinish.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		panel_Customer = new JPanel();
		panel_Customer.setLayout(null);
		panel_Customer.setBorder(new TitledBorder(null, "Receipt Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Customer.setBackground(Color.WHITE);
		
		lblNewLabel_6 = new JLabel("Customer:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(10, 30, 108, 27);
		panel_Customer.add(lblNewLabel_6);
		
		txtCusName = new JTextField();
		txtCusName.setColumns(10);
		txtCusName.setBounds(125, 31, 183, 25);
		panel_Customer.add(txtCusName);
		
		lblNewLabel_7 = new JLabel("Phone:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(10, 91, 97, 27);
		panel_Customer.add(lblNewLabel_7);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(125, 92, 183, 25);
		panel_Customer.add(txtPhone);
		
		lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGender.setBounds(10, 142, 68, 26);
		panel_Customer.add(lblGender);
		
		checkMale = new JRadioButton("Male");
		buttonGroup.add(checkMale);
		checkMale.setEnabled(false);
		checkMale.setFont(new Font("Tahoma", Font.BOLD, 15));
		checkMale.setBackground(UIManager.getColor("Button.background"));
		checkMale.setBounds(125, 147, 63, 21);
		panel_Customer.add(checkMale);
		
		checkFemale = new JRadioButton("Female");
		buttonGroup.add(checkFemale);
		checkFemale.setEnabled(false);
		checkFemale.setSelected(false);
		checkFemale.setFont(new Font("Tahoma", Font.BOLD, 15));
		checkFemale.setBackground(UIManager.getColor("Button.background"));
		checkFemale.setBounds(203, 147, 80, 21);
		checkFemale.setSelected(false);
		panel_Customer.add(checkFemale);
		
		btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPrintActionPerformed(e);
			}
		});
		btnPrint.setEnabled(false);
		btnPrint.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRefreshActionPerformed(e);
			}
		});
		btnRefresh.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 15));
		GroupLayout gl_panel_Function = new GroupLayout(panel_Function);
		gl_panel_Function.setHorizontalGroup(
			gl_panel_Function.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Function.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel_Function.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_Function.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(21)
							.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
							.addGap(36)
							.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
							.addGap(95)
							.addComponent(btnPrevious, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtPage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
							.addComponent(btnRefresh, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
							.addGap(81))
						.addGroup(gl_panel_Function.createSequentialGroup()
							.addComponent(lblTypeSearch, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(21)
							.addComponent(cbDrugName, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(cbDrugType, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(cbDrugUsage, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(542, Short.MAX_VALUE))))
		);
		gl_panel_Function.setVerticalGroup(
			gl_panel_Function.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Function.createSequentialGroup()
					.addGap(13)
					.addGroup(gl_panel_Function.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_Function.createSequentialGroup()
							.addGap(2)
							.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_Function.createSequentialGroup()
							.addGap(2)
							.addComponent(btnSearch))
						.addGroup(gl_panel_Function.createSequentialGroup()
							.addGap(1)
							.addComponent(btnPrevious))
						.addGroup(gl_panel_Function.createSequentialGroup()
							.addGap(1)
							.addComponent(txtPage, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_Function.createSequentialGroup()
							.addGap(1)
							.addGroup(gl_panel_Function.createParallelGroup(Alignment.LEADING)
								.addComponent(btnRefresh, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNext))))
					.addGap(6)
					.addGroup(gl_panel_Function.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTypeSearch, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_Function.createSequentialGroup()
							.addGap(3)
							.addComponent(cbDrugName, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_Function.createSequentialGroup()
							.addGap(3)
							.addComponent(cbDrugType, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_Function.createSequentialGroup()
							.addGap(3)
							.addComponent(cbDrugUsage, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))))
		);
		panel_Function.setLayout(gl_panel_Function);
		contentPane.setLayout(null);
		contentPane.add(lblReceipt);
		contentPane.add(panel_ReceiptInfo);
		GroupLayout gl_panel_ReceiptInfo = new GroupLayout(panel_ReceiptInfo);
		gl_panel_ReceiptInfo.setHorizontalGroup(
			gl_panel_ReceiptInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_ReceiptInfo.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel_ReceiptInfo.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_Medicine, GroupLayout.PREFERRED_SIZE, 720, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_Customer, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE))
					.addGap(120)
					.addGroup(gl_panel_ReceiptInfo.createParallelGroup(Alignment.LEADING)
						.addComponent(btnForward, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnInform, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnFinish, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addComponent(btnPrint, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_ReceiptInfo.setVerticalGroup(
			gl_panel_ReceiptInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_ReceiptInfo.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel_ReceiptInfo.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_Medicine, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_Customer, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)))
				.addGroup(gl_panel_ReceiptInfo.createSequentialGroup()
					.addGap(20)
					.addComponent(btnForward)
					.addGap(18)
					.addComponent(btnInform)
					.addGap(18)
					.addComponent(btnClear)
					.addGap(18)
					.addComponent(btnFinish))
				.addGroup(gl_panel_ReceiptInfo.createSequentialGroup()
					.addGap(20)
					.addComponent(btnPrint))
		);
		panel_ReceiptInfo.setLayout(gl_panel_ReceiptInfo);
		contentPane.add(panel_MedicineList);
		GroupLayout gl_panel_MedicineList = new GroupLayout(panel_MedicineList);
		gl_panel_MedicineList.setHorizontalGroup(
			gl_panel_MedicineList.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_MedicineList.createSequentialGroup()
					.addGap(4)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 1195, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_MedicineList.setVerticalGroup(
			gl_panel_MedicineList.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_MedicineList.createSequentialGroup()
					.addGap(5)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
		);
		panel_MedicineList.setLayout(gl_panel_MedicineList);
		contentPane.add(panel_Function);
		
		panelPrintReceipt = new JPanel();
		panelPrintReceipt.setBounds(175, 92, 1000, 460);
		contentPane.add(panelPrintReceipt);
		panelPrintReceipt.setVisible(false);
		
		
		lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblPhone = new JLabel("Phone(+84):");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblGenderInfo = new JLabel("Gender:");
		lblGenderInfo.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblInputName = new JLabel("");
		lblInputName.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblInputPhone = new JLabel("");
		lblInputPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblInputGender = new JLabel("");
		lblInputGender.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblPay = new JLabel("Payment:");
		lblPay.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblInputPay = new JLabel("");
		lblInputPay.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Receipt List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setLayout(null);
		
		scrollPaneReceipt = new JScrollPane();
		scrollPaneReceipt.setBounds(20, 20, 900, 160);
		panel_1.add(scrollPaneReceipt);
		
		tableReceipt = new JTable();
		scrollPaneReceipt.setViewportView(tableReceipt);
		
		lblNewLabel_16 = new JLabel("Amount:");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblInputAmount = new JLabel("");
		lblInputAmount.setFont(new Font("Tahoma", Font.BOLD, 14));
		GroupLayout gl_panelPrintReceipt = new GroupLayout(panelPrintReceipt);
		gl_panelPrintReceipt.setHorizontalGroup(
			gl_panelPrintReceipt.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPrintReceipt.createSequentialGroup()
					.addGap(10)
					.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(50)
					.addComponent(lblInputName, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
					.addGap(92)
					.addComponent(lblPay, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addGap(19)
					.addComponent(lblInputPay, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelPrintReceipt.createSequentialGroup()
					.addGap(10)
					.addComponent(lblPhone, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addGap(19)
					.addComponent(lblInputPhone, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelPrintReceipt.createSequentialGroup()
					.addGap(10)
					.addComponent(lblGenderInfo, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(50)
					.addComponent(lblInputGender, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelPrintReceipt.createSequentialGroup()
					.addGap(20)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 950, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelPrintReceipt.createSequentialGroup()
					.addGap(700)
					.addComponent(lblNewLabel_16, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addComponent(lblInputAmount, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
		);
		gl_panelPrintReceipt.setVerticalGroup(
			gl_panelPrintReceipt.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPrintReceipt.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_panelPrintReceipt.createParallelGroup(Alignment.LEADING)
						.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblInputName, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPay, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblInputPay, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_panelPrintReceipt.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPhone, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblInputPhone, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(gl_panelPrintReceipt.createParallelGroup(Alignment.LEADING)
						.addComponent(lblGenderInfo, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblInputGender, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(61)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(gl_panelPrintReceipt.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_16, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblInputAmount, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
		);
		panelPrintReceipt.setLayout(gl_panelPrintReceipt);
		
		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnOkActionPerformed(e);
			}
		});
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnOk.setBounds(1070, 561, 105, 27);
		contentPane.add(btnOk);
		btnOk.setVisible(false);
		loadDrug();
		
	}
	
	private void loadDrug() {
		var model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Type ID");
		model.addColumn("Drug Name");
		model.addColumn("Quantity");
		model.addColumn("Unit");
		model.addColumn("Price");
		model.addColumn("Usage");
		model.addColumn("Manufacturer");
		model.addColumn("manu_Day");
		model.addColumn("expire_Day");
		model.addColumn("Status");
		var dao = new DrugDAO();
		totalCount = dao.countDrug();
		totalPage = Math.ceil(totalCount.doubleValue()/rowOfPage);
		dao.selectDrug(pageNumber,rowOfPage).stream().forEach(drug-> model.addRow(new Object[] {
				drug.getId(),drug.getTypeId(),drug.getName(),drug.getQuantity(),drug.getUnit(),
				drug.getPrice(),drug.getUsage(),drug.getManufacturers()
				,drug.getManuDay(),drug.getExpire(),drug.isStatus()
			}));
		table.setModel(model);
	}
	
	protected void btnInformActionPerformed(ActionEvent e) {
		if(
				txtMedicine.getText().isEmpty()||txtQuantity.getText().isEmpty()||txtPrice.getText().isEmpty()
				||dateChooser.getDate()== null||txtPayment.getText().isEmpty()
			) {
			JOptionPane.showMessageDialog(this,"Please fill in the blank that continue to move on");
			return;
		}
		checkMale.setEnabled(true);
		checkFemale.setEnabled(true);
		btnForward.setEnabled(true);
		panel_Customer.setVisible(true);
		panel_Medicine.setVisible(false);
		btnInform.setEnabled(false);
		btnFinish.setEnabled(true);
		btnPrint.setEnabled(true);
	}
	protected void btnForwardActionPerformed(ActionEvent e) {
		btnForward.setEnabled(false);
		panel_Medicine.setVisible(true);
		panel_Customer.setVisible(false);
		btnInform.setEnabled(true);
		btnFinish.setEnabled(false);
	}
	protected void btnFinishActionPerformed(ActionEvent e) {
		if(txtCusName.getText().isEmpty()||txtPhone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill in the blank to complete inserted");
			return;
		}
		//customer function
		
		var cus = new Customer();
		cus.setName(txtCusName.getText());
		if(checkMale.isSelected()) {
			cus.setGender(true);
		}else {
			cus.setGender(false);
		}
		cus.setPhone(Integer.parseInt(txtPhone.getText()));
		var daoReceipt = new ReceiptDAO();
		daoReceipt.insertCusCheck(cus);

		
		//order function
		
		var order = new Order();
		var daoOrder = new OrderDAO();
		order.setCusName(daoOrder.getCusIdByCusName(txtCusName.getText()));
		order.setPayType(daoOrder.getPayIdByPayMode(txtPayment.getText()));
		order.setOrderDate(LocalDate.ofInstant(
				dateChooser.getDate().toInstant(),ZoneId.systemDefault()
				));
		var amount = Integer.parseInt(txtPrice.getText())*Integer.parseInt(txtQuantity.getText());
		order.setAmountPaid(new BigDecimal(amount));
		daoOrder.insertOrder(order);
		
		//order detail function
		
		var detail = new OrderDetail();
				
		int cusId = Integer.parseInt(daoOrder.getCusIdByCusName(txtCusName.getText()));
		int payId = Integer.parseInt(daoOrder.getPayIdByPayMode(txtPayment.getText()));
		var orderDate = LocalDate.ofInstant(dateChooser.getDate().toInstant(),ZoneId.systemDefault());
		String orderId = daoReceipt.getOrderId(cusId,payId,orderDate ,new BigDecimal(amount));
		
		detail.setOrderId(Integer.parseInt(orderId));
		var daoDetail = new OrderDetailDAO();
		detail.setProductName(daoDetail.getProIdByProName(txtMedicine.getText()));
		detail.setPriceEach(new BigDecimal(txtPrice.getText()));
		detail.setQuantity(Integer.parseInt(txtQuantity.getText()));
		daoDetail.insertOrderDetail(detail);
		
		//Receipt function
		
		int drugId = Integer.parseInt(daoDetail.getProIdByProName(txtMedicine.getText()));
		daoReceipt.updateQuantityDrug(drugId, Integer.parseInt(txtQuantity.getText()));
		
		loadDrug();
		refresh();
		JOptionPane.showMessageDialog(this, "Finish Receipt");
	}
	protected void btnSearchActionPerformed(ActionEvent e) {
		if(txtSearch.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill Search's text");
			return;
		}
		var model = ( DefaultTableModel)table.getModel();
		model.setRowCount(0);
		var dao = new DrugDAO();
		if(cbDrugName.isSelected()) {
			dao.searchDrug(txtSearch.getText()).stream().forEach(drug-> model.addRow(new Object[] {
					drug.getId(),drug.getTypeId(),drug.getName(),drug.getQuantity(),drug.getUnit(),
					drug.getPrice(),drug.getUsage(),drug.getManufacturers()
					,drug.getManuDay(),drug.getExpire(),drug.isStatus()
				}));
		}else if(cbDrugType.isSelected()) {
			dao.searchType(txtSearch.getText()).stream().forEach(drug-> model.addRow(new Object[] {
					drug.getId(),drug.getTypeId(),drug.getName(),drug.getQuantity(),drug.getUnit(),
					drug.getPrice(),drug.getUsage(),drug.getManufacturers()
					,drug.getManuDay(),drug.getExpire(),drug.isStatus()
				}));
		}else {
			dao.searchUsage(txtSearch.getText()).stream().forEach(drug-> model.addRow(new Object[] {
					drug.getId(),drug.getTypeId(),drug.getName(),drug.getQuantity(),drug.getUnit(),
					drug.getPrice(),drug.getUsage(),drug.getManufacturers()
					,drug.getManuDay(),drug.getExpire(),drug.isStatus()
				}));
		}
	}
	protected void btnPreviousActionPerformed(ActionEvent e) {
		if(pageNumber>1) {
			pageNumber--;
			txtPage.setText(pageNumber.toString());
			refresh();
		}
	}
	
	protected void btnNextActionPerformed(ActionEvent e) {
		if(pageNumber<totalPage.intValue()) {
			pageNumber++;
			txtPage.setText(pageNumber.toString());
			
			refresh();
		}
	}
	
	private void refresh() {
		var model = ( DefaultTableModel)table.getModel();
		model.setRowCount(0);
		var dao = new DrugDAO();
		totalCount = dao.countDrug();
		totalPage = Math.ceil(totalCount.doubleValue()/rowOfPage);
		dao.selectDrug(pageNumber,rowOfPage).stream().forEach(drug-> model.addRow(new Object[] {
				drug.getId(),drug.getTypeId(),drug.getName(),drug.getQuantity(),drug.getUnit(),
				drug.getPrice(),drug.getUsage(),drug.getManufacturers()
				,drug.getManuDay(),drug.getExpire(),drug.isStatus()
			}));
	}
	protected void btnRefreshActionPerformed(ActionEvent e) {
		refresh();
	}
	protected void btnPrintActionPerformed(ActionEvent e) {
		panel_ReceiptInfo.setVisible(false);
		panel_MedicineList.setVisible(false);
		panel_Function.setVisible(false);
		panelPrintReceipt.setVisible(true);
		btnOk.setVisible(true);
		
		lblInputName.setText(txtCusName.getText());
		lblInputPhone.setText(txtPhone.getText());
		if(checkMale.isSelected()) {
			lblInputGender.setText("Male");
		}else {
			lblInputGender.setText("Female");
		}
		lblInputPay.setText(txtPayment.getText());
		
		
		var daoOrder = new OrderDAO();
		int cusId = Integer.parseInt(daoOrder.getCusIdByCusName(txtCusName.getText()));
		var orderDate = LocalDate.ofInstant(dateChooser.getDate().toInstant(),ZoneId.systemDefault());
		var dao = new ReceiptDAO();
		var amountPaid = dao.amountReceipt(cusId,orderDate);
		lblInputAmount.setText(amountPaid.toString()+" VND");
		loadReceipt();
	}
	
	public void loadReceipt() {
		var model = new DefaultTableModel();
		model.addColumn("Order Date");
		model.addColumn("Drug Name");
		model.addColumn("Quantity");
		model.addColumn("Unit");
		model.addColumn("Price");
		var dao = new ReceiptDAO();
		var daoOrder = new OrderDAO();
		int cusId = Integer.parseInt(daoOrder.getCusIdByCusName(txtCusName.getText()));
		var orderDate = LocalDate.ofInstant(dateChooser.getDate().toInstant(),ZoneId.systemDefault());
		dao.selectReceipt(cusId,orderDate).stream().forEach(re-> model.addRow(new Object[] {
				re.getOrderDate(),re.getProductName(),re.getQuantity(),re.getUnit(),
				re.getPriceEach()
			}));
		tableReceipt.setModel(model);
	}
	protected void btnOkActionPerformed(ActionEvent e) {
		panel_ReceiptInfo.setVisible(true);
		panel_MedicineList.setVisible(true);
		panel_Function.setVisible(true);
		panelPrintReceipt.setVisible(false);
		btnOk.setVisible(false);
	}
	protected void btnClearActionPerformed(ActionEvent e) {
		//Medicine Info
		txtMedicine.setText("");
		txtQuantity.setText("");
		txtPrice.setText("");
		txtPayment.setText("");
		dateChooser.setDate(null);
		//Customer Info
		txtCusName.setText("");
		txtPhone.setText("");
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
	protected void tableMouseClicked(MouseEvent e) {
		var indexRow = table.getSelectedRow();
		txtMedicine.setText(table.getValueAt(indexRow, 2).toString());
		txtQuantity.setText(table.getValueAt(indexRow, 3).toString());
	}
}
