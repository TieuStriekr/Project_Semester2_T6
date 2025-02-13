package app;


import java.awt.EventQueue;
import java.time.LocalDate;

import java.time.ZoneId;



import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;



import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.GroupLayout;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;

import javax.swing.ScrollPaneConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;


import java.awt.Color;
import javax.swing.SwingConstants;

import javax.swing.JCheckBox;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;


import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

import java.awt.event.MouseEvent;


import javax.swing.border.EtchedBorder;
import com.toedter.calendar.JDateChooser;

import customerPackage.CustomerPage;
import dao.DrugDAO;
import dao.DrugTypeDAO;
import drugTypePackage.DrugTypePage;
import entity.Drug;
import entity.DrugType;
import home.HomePage;
import loginPackage.Login;
import orderPackage.OrderDetailForm;
import orderPackage.OrderForm;
import supplierPackage.SupplierManagement;

import java.awt.Font;


import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import javax.swing.ButtonGroup;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;


public class PhamarcyManagement extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblTitiel;
	
	private JLabel lblThuoc_Ten;
	private JTextField txtId;
	private JLabel lblTen;
	private JTextField txtName;
	private JTextField txtPrice;
	private JLabel lblThuoc_DonGia;
	private JLabel lblThuoc_SLN;
	private JTextField txtQuantity;
	private JLabel lblTrangThai;
	private JLabel lblType;
	private JPanel panelMedicine;
	private JPanel pnlChucNang;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JPanel panel;
	private JLabel lblEnterSearchInformation;
	private JLabel lblSearchBy;
	private JPanel pnlDsthuoc;
	private JPanel pnl_4_Thuoc;
	private JScrollPane scrollPaneThuoc;
	private JTextField txtSearch;
	private JTextField txtType;
	private Integer pageNumber =1;
	private Integer rowOfPage =10;
	private Integer totalCount =0;
	private Double totalPage =0.0;
	private static PhamarcyManagement instance;
	private JTable table;
	private JTextField txtPage;
	private JButton btnPrevious;
	private JButton btnNext;
	private JButton btnInsert;
	private JButton btnSearch;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtCheckExpire;
	private JLabel lblNewLabel;
	private JButton btnCheckExpire;
	private JButton btnRefresh;
	private JPanel panel_1;
	private JButton btnAdd;
	private JLabel lblUnit;
	private JTextField txtUnit;
	private JLabel lblUsage;
	private JTextField txtUsage;
	private JLabel lblManu;
	private JTextField txtManu;
	private JCheckBox checkStatus;
	private JLabel lblManuDay;
	private JDateChooser manuDay;
	private JLabel lblExpireDay;
	private JDateChooser expireDay;
	private JLabel lblTypeId;
	private JTextField txtTypeId;
	private JLabel lblTypeName;
	private JTextField txtTypeName;
	private JRadioButton cbDrugName;
	private JRadioButton cbDrugType;
	private JRadioButton cbDrugUsage;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mnHome;
	private JMenuItem mntmReceipt;
	private JMenuItem mntmStatistic;
	private JMenuItem mntmExit;
	private JMenu mnNewMenu_1;
	private JMenuItem mnMedicine;
	private JMenuItem mnMedicineType;
	private JMenuItem mnSupplier;
	private JMenuItem mnCustomer;
	private JMenuItem mnOrder;
	private JMenuItem mnOrderDetail;
	private JSeparator separator;
	private JSeparator separator_1;
	public static PhamarcyManagement getInstance() {
		if(instance == null) {
			instance = new PhamarcyManagement();
		}
		return instance;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhamarcyManagement frame = new PhamarcyManagement();
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
	public PhamarcyManagement() {
		setTitle("Pharmacy Store");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1351,800);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Open");
		menuBar.add(mnNewMenu);
		
		mnHome = new JMenuItem("Home");
		mnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mnHomeActionPerformed(e);
			}
		});
		mnNewMenu.add(mnHome);
		
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
		
		separator_1 = new JSeparator();
		mnNewMenu_1.add(separator_1);
		
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
		
		separator = new JSeparator();
		mnNewMenu_1.add(separator);
		
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
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		lblTitiel = new JLabel("MEDICINE MANAGEMENT");
		lblTitiel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitiel.setForeground(new Color(255, 0, 0));
		lblTitiel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblTitiel.setBackground(Color.BLACK);
		
		panelMedicine = new JPanel();
		panelMedicine.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(240,240,240)), "Medication information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		pnlChucNang = new JPanel();
		pnlChucNang.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Functions", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlChucNang.setBackground(new Color(255, 255, 255));
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleteActionPerformed(e);
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDelete.setBackground(new Color(192, 192, 192));
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdateActionPerformed(e);
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpdate.setBackground(Color.LIGHT_GRAY);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Search for medical bills", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(new Color(240, 240, 240));
		
		lblEnterSearchInformation = new JLabel("Enter search information:");
		lblEnterSearchInformation.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEnterSearchInformation.setBounds(10, 14, 172, 25);
		panel.add(lblEnterSearchInformation);
		
		lblSearchBy = new JLabel("Search by:");
		lblSearchBy.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSearchBy.setBounds(10, 49, 86, 25);
		panel.add(lblSearchBy);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(175, 15, 147, 25);
		panel.add(txtSearch);
		txtSearch.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSearchActionPerformed(e);
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSearch.setBackground(Color.LIGHT_GRAY);
		btnSearch.setBounds(339, 10, 147, 30);
		panel.add(btnSearch);
		
		txtCheckExpire = new JTextField();
		txtCheckExpire.setBounds(175, 87, 147, 25);
		panel.add(txtCheckExpire);
		txtCheckExpire.setColumns(10);
		
		lblNewLabel = new JLabel("Check expire date:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 84, 119, 30);
		panel.add(lblNewLabel);
		
		btnCheckExpire = new JButton("Check Month");
		btnCheckExpire.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCheckExpire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCheckExpireActionPerformed(e);
			}
		});
		btnCheckExpire.setBounds(339, 84, 151, 30);
		panel.add(btnCheckExpire);
		
		pnlDsthuoc = new JPanel();
		pnlDsthuoc.setLayout(null);
		pnlDsthuoc.setBackground(new Color(255, 255, 255));
		
		pnl_4_Thuoc = new JPanel();
		pnl_4_Thuoc.setBorder(new TitledBorder(null, "Medicine List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnl_4_Thuoc.setBounds(0, 0, 1303, 196);
		pnl_4_Thuoc.setBackground(new Color(176, 224, 230));
		pnlDsthuoc.add(pnl_4_Thuoc);
		
		scrollPaneThuoc = new JScrollPane();
		scrollPaneThuoc.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneThuoc.setToolTipText("qq\r\n");
		scrollPaneThuoc.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
			}
		});
		scrollPaneThuoc.setViewportView(table);
		table.setAutoCreateRowSorter(true);
		GroupLayout gl_pnl_4_Thuoc = new GroupLayout(pnl_4_Thuoc);
		gl_pnl_4_Thuoc.setHorizontalGroup(
			gl_pnl_4_Thuoc.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnl_4_Thuoc.createSequentialGroup()
					.addGap(4)
					.addComponent(scrollPaneThuoc, GroupLayout.PREFERRED_SIZE, 1273, GroupLayout.PREFERRED_SIZE))
		);
		gl_pnl_4_Thuoc.setVerticalGroup(
			gl_pnl_4_Thuoc.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPaneThuoc, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
		);
		pnl_4_Thuoc.setLayout(gl_pnl_4_Thuoc);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(pnlChucNang, GroupLayout.PREFERRED_SIZE, 1303, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTitiel, GroupLayout.DEFAULT_SIZE, 1315, Short.MAX_VALUE)
								.addComponent(pnlDsthuoc, GroupLayout.PREFERRED_SIZE, 1300, GroupLayout.PREFERRED_SIZE)))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGap(25)
							.addComponent(panelMedicine, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addComponent(lblTitiel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addComponent(panelMedicine, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnlDsthuoc, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(pnlChucNang, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
					.addGap(236))
		);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		
		lblTen = new JLabel("Name:\r\n");
		lblTen.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setColumns(10);
		
		lblThuoc_Ten = new JLabel("ID:");
		lblThuoc_Ten.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtQuantity = new JTextField();
		txtQuantity.setColumns(10);
		
		lblThuoc_SLN = new JLabel("Quantity:");
		lblThuoc_SLN.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		
		lblThuoc_DonGia = new JLabel("Price:");
		lblThuoc_DonGia.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtType = new JTextField();
		txtType.setColumns(10);
		
		lblType = new JLabel("Type ID:");
		lblType.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		lblTrangThai = new JLabel("Status:");
		lblTrangThai.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		lblUnit = new JLabel("Unit:");
		lblUnit.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtUnit = new JTextField();
		txtUnit.setColumns(10);
		
		lblUsage = new JLabel("Usage:");
		lblUsage.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtUsage = new JTextField();
		txtUsage.setColumns(10);
		
		lblManu = new JLabel("Manufacturers:");
		lblManu.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtManu = new JTextField();
		txtManu.setColumns(10);
		
		checkStatus = new JCheckBox("");
		checkStatus.setHorizontalAlignment(SwingConstants.CENTER);
		checkStatus.setBackground(new Color(255, 255, 255));
		
		lblManuDay = new JLabel("Manu Day:");
		lblManuDay.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		manuDay = new JDateChooser();
		
		lblExpireDay = new JLabel("Expire Day:");
		lblExpireDay.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		expireDay = new JDateChooser();
		GroupLayout gl_panelMedicine = new GroupLayout(panelMedicine);
		gl_panelMedicine.setHorizontalGroup(
			gl_panelMedicine.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMedicine.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_panelMedicine.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelMedicine.createSequentialGroup()
							.addComponent(lblThuoc_Ten, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(txtId, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
							.addGap(105)
							.addComponent(lblUnit, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addGap(47)
							.addComponent(txtUnit, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
							.addGap(89)
							.addComponent(lblManuDay, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(manuDay, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelMedicine.createSequentialGroup()
							.addComponent(lblType, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(txtType, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
							.addGap(105)
							.addComponent(lblThuoc_DonGia, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addGap(47)
							.addComponent(txtPrice, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
							.addGap(89)
							.addComponent(lblExpireDay, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(expireDay, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelMedicine.createSequentialGroup()
							.addComponent(lblTen, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
							.addGap(105)
							.addComponent(lblUsage, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addGap(47)
							.addComponent(txtUsage, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
							.addGap(89)
							.addComponent(lblTrangThai, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
							.addGap(47)
							.addComponent(checkStatus, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelMedicine.createSequentialGroup()
							.addComponent(lblThuoc_SLN, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(txtQuantity, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
							.addGap(106)
							.addComponent(lblManu, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addGap(17)
							.addComponent(txtManu, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))))
		);
		gl_panelMedicine.setVerticalGroup(
			gl_panelMedicine.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMedicine.createSequentialGroup()
					.addGap(9)
					.addGroup(gl_panelMedicine.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelMedicine.createSequentialGroup()
							.addGap(1)
							.addComponent(lblThuoc_Ten, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelMedicine.createSequentialGroup()
							.addGap(2)
							.addComponent(txtId, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblUnit, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelMedicine.createSequentialGroup()
							.addGap(1)
							.addComponent(txtUnit, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelMedicine.createSequentialGroup()
							.addGap(2)
							.addComponent(lblManuDay, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelMedicine.createSequentialGroup()
							.addGap(2)
							.addComponent(manuDay, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(10)
					.addGroup(gl_panelMedicine.createParallelGroup(Alignment.LEADING)
						.addComponent(lblType, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelMedicine.createSequentialGroup()
							.addGap(2)
							.addComponent(txtType, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblThuoc_DonGia, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelMedicine.createSequentialGroup()
							.addGap(1)
							.addComponent(txtPrice, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelMedicine.createSequentialGroup()
							.addGap(1)
							.addComponent(lblExpireDay, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelMedicine.createSequentialGroup()
							.addGap(1)
							.addComponent(expireDay, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(9)
					.addGroup(gl_panelMedicine.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTen, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelMedicine.createSequentialGroup()
							.addGap(1)
							.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblUsage, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelMedicine.createSequentialGroup()
							.addGap(1)
							.addComponent(txtUsage, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTrangThai, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelMedicine.createSequentialGroup()
							.addGap(5)
							.addComponent(checkStatus)))
					.addGap(9)
					.addGroup(gl_panelMedicine.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelMedicine.createSequentialGroup()
							.addGap(1)
							.addComponent(lblThuoc_SLN, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelMedicine.createSequentialGroup()
							.addGap(1)
							.addComponent(txtQuantity, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblManu, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelMedicine.createSequentialGroup()
							.addGap(1)
							.addComponent(txtManu, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))))
		);
		panelMedicine.setLayout(gl_panelMedicine);
		
		btnInsert = new JButton("Insert");
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnInsert.setBackground(new Color(192, 192, 192));
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnInsertActionPerformed(e);
			}
		});
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRefresh.setBackground(new Color(192, 192, 192));
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRefreshActionPerformed(e);
			}
		});
		
		btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPreviousActionPerformed(e);
			}
		});
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Categories information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(636, 18, 500, 100);
		panel_1.setBackground(new Color(240, 240, 240));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddActionPerformed(e);
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdd.setBackground(Color.LIGHT_GRAY);
		btnAdd.setBounds(354, 39, 102, 30);
		panel_1.add(btnAdd);
		
		lblTypeId = new JLabel("Type ID:");
		lblTypeId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTypeId.setBounds(10, 17, 62, 30);
		panel_1.add(lblTypeId);
		
		txtTypeId = new JTextField();
		txtTypeId.setColumns(10);
		txtTypeId.setBounds(119, 18, 220, 30);
		panel_1.add(txtTypeId);
		
		lblTypeName = new JLabel("Type Name:");
		lblTypeName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTypeName.setBounds(10, 59, 82, 30);
		panel_1.add(lblTypeName);
		
		txtTypeName = new JTextField();
		txtTypeName.setColumns(10);
		txtTypeName.setBounds(119, 60, 220, 30);
		panel_1.add(txtTypeName);
		
		cbDrugName = new JRadioButton("Name");
		cbDrugName.setSelected(true);
		buttonGroup.add(cbDrugName);
		cbDrugName.setHorizontalAlignment(SwingConstants.CENTER);
		cbDrugName.setBackground(new Color(255, 255, 255));
		cbDrugName.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbDrugName.setBounds(175, 52, 95, 25);
		panel.add(cbDrugName);
		
		cbDrugType = new JRadioButton("Type");
		buttonGroup.add(cbDrugType);
		cbDrugType.setHorizontalAlignment(SwingConstants.CENTER);
		cbDrugType.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbDrugType.setBackground(Color.WHITE);
		cbDrugType.setBounds(272, 52, 95, 25);
		panel.add(cbDrugType);
		
		cbDrugUsage = new JRadioButton("Usage");
		buttonGroup.add(cbDrugUsage);
		cbDrugUsage.setHorizontalAlignment(SwingConstants.CENTER);
		cbDrugUsage.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbDrugUsage.setBackground(Color.WHITE);
		cbDrugUsage.setBounds(369, 52, 118, 25);
		panel.add(cbDrugUsage);
		
		btnPrevious.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPrevious.setBackground(Color.LIGHT_GRAY);
		txtPage = new JTextField();
		txtPage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPage.setHorizontalAlignment(SwingConstants.CENTER);
		txtPage.setText("1");
		txtPage.setColumns(10);
		
		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNextActionPerformed(e);
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNext.setBackground(Color.LIGHT_GRAY);
		GroupLayout gl_pnlChucNang = new GroupLayout(pnlChucNang);
		gl_pnlChucNang.setHorizontalGroup(
			gl_pnlChucNang.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlChucNang.createSequentialGroup()
					.addGap(4)
					.addGroup(gl_pnlChucNang.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1283, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlChucNang.createSequentialGroup()
							.addComponent(btnInsert, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addComponent(btnRefresh, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
							.addGap(76)
							.addComponent(btnPrevious)
							.addGap(25)
							.addComponent(txtPage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(22)
							.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))))
		);
		gl_pnlChucNang.setVerticalGroup(
			gl_pnlChucNang.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlChucNang.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addGroup(gl_pnlChucNang.createParallelGroup(Alignment.LEADING)
						.addComponent(btnInsert, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRefresh, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPrevious, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlChucNang.createSequentialGroup()
							.addGap(3)
							.addComponent(txtPage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
		);
		pnlChucNang.setLayout(gl_pnlChucNang);
		contentPane.setLayout(gl_contentPane);
		loadProduct();
		refresh();
		
	}
	
	public void loadProduct() {
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
//		lblStatus.setText("page"+pageNumber+"of"+totalPage.intValue());
//		lblTotal.setText("Total product:"+totalCount);
		dao.selectDrug(pageNumber,rowOfPage).stream().forEach(drug-> model.addRow(new Object[] {
				drug.getId(),drug.getTypeId(),drug.getName(),drug.getQuantity(),drug.getUnit(),
				drug.getPrice(),drug.getUsage(),drug.getManufacturers()
				,drug.getManuDay(),drug.getExpire(),drug.isStatus()
			}));
		table.setModel(model);
	}
	protected void tableMouseClicked(MouseEvent e) {
		var dao = new DrugDAO();
		var indexRow = table.getSelectedRow();
		txtId.setText(table.getValueAt(indexRow, 0).toString());
		txtType.setText(table.getValueAt(indexRow, 1).toString());
		txtName.setText(table.getValueAt(indexRow, 2).toString());
		txtQuantity.setText(table.getValueAt(indexRow, 3).toString());
		txtUnit.setText(table.getValueAt(indexRow, 4).toString());
		txtPrice.setText(table.getValueAt(indexRow, 5).toString());
		txtUsage.setText(table.getValueAt(indexRow, 6).toString());
		
		txtManu.setText(dao.getManuIdByName(table.getValueAt(indexRow, 7).toString()));
		try {
			manuDay.setDate(
					new SimpleDateFormat("yyyy-MM-dd").parse(table.getValueAt(indexRow, 8).toString())
					);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		try {
			expireDay.setDate(
					new SimpleDateFormat("yyyy-MM-dd").parse(table.getValueAt(indexRow, 9).toString())
					);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		checkStatus.setSelected(table.getValueAt(indexRow,10).toString().equals("true")?true:false);
	}
	
	protected void btnUpdateActionPerformed(ActionEvent e) {
		if(
			txtName.getText().isEmpty()||txtQuantity.getText().isEmpty()
			||txtUnit.getText().isEmpty()||txtPrice.getText().isEmpty()||txtUsage.getText().isEmpty()
			||txtManu.getText().isEmpty()||manuDay.getDate()==null||expireDay.getDate()==null
			) {
			JOptionPane.showMessageDialog(this, "Please fill in the blank to complete updated");
			return;
		}
		var drug = new Drug();
		drug.setId(Integer.parseInt(txtId.getText()));
		drug.setTypeId(txtType.getText());
		drug.setName(txtName.getText());
		drug.setQuantity(Integer.parseInt(txtQuantity.getText()));
		drug.setUnit(txtUnit.getText());
		drug.setPrice(new BigDecimal(txtPrice.getText()));
		drug.setUsage(txtUsage.getText());
		drug.setManufacturers(txtManu.getText());
		drug.setManuDay(
				LocalDate.ofInstant(manuDay.getDate().toInstant(),
						ZoneId.systemDefault())
				);
		drug.setExpire(
				LocalDate.ofInstant(expireDay.getDate().toInstant(),
						ZoneId.systemDefault())
				);
		drug.setStatus(checkStatus.isSelected());
		var dao = new DrugDAO();
		dao.updateDrug(drug);
		loadProduct();
		refresh();
	}

	protected void btnInsertActionPerformed(ActionEvent e) {
		if(
				txtName.getText().isEmpty()||txtQuantity.getText().isEmpty()
				||txtUnit.getText().isEmpty()||txtPrice.getText().isEmpty()||txtUsage.getText().isEmpty()
				||txtManu.getText().isEmpty()||manuDay.getDate()==null||expireDay.getDate()==null
				) {
				JOptionPane.showMessageDialog(this, "Please fill in the blank to complete inserted");
				return;
			}
		var drug = new Drug();
		drug.setTypeId(txtType.getText());
		drug.setName(txtName.getText());
		drug.setQuantity(Integer.parseInt(txtQuantity.getText()));
		drug.setUnit(txtUnit.getText());
		drug.setPrice(new BigDecimal(txtPrice.getText()));
		drug.setUsage(txtUsage.getText());
		drug.setManufacturers(txtManu.getText());
		drug.setManuDay(
				LocalDate.ofInstant(manuDay.getDate().toInstant(),
						ZoneId.systemDefault())
				);
		drug.setExpire(
				LocalDate.ofInstant(expireDay.getDate().toInstant(),
						ZoneId.systemDefault())
				);
		drug.setStatus(checkStatus.isSelected());
		var dao = new DrugDAO();
		dao.insertDrug(drug);
		loadProduct();
		refresh();
	}
	
	private void refresh() {
		var model = ( DefaultTableModel)table.getModel();
		model.setRowCount(0);
		var dao = new DrugDAO();
		totalCount = dao.countDrug();
		totalPage = Math.ceil(totalCount.doubleValue()/rowOfPage);
//		lblStatus.setText("page"+pageNumber+"of"+totalPage.intValue());
//		lblTotal.setText("Total products:"+totalCount);
		dao.selectDrug(pageNumber,rowOfPage).stream().forEach(drug-> model.addRow(new Object[] {
				drug.getId(),drug.getTypeId(),drug.getName(),drug.getQuantity(),drug.getUnit(),
				drug.getPrice(),drug.getUsage(),drug.getManufacturers()
				,drug.getManuDay(),drug.getExpire(),drug.isStatus()
			}));
	}
	
	protected void btnDeleteActionPerformed(ActionEvent e) {
		var dao = new DrugDAO();
		dao.deleteDrug(Integer.parseInt(txtId.getText()));
		refresh();
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
	protected void btnCheckExpireActionPerformed(ActionEvent e) {
		if(txtCheckExpire.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill text in Check Month");
			return;
		}
		var model = ( DefaultTableModel)table.getModel();
		model.setRowCount(0);
		var dao = new DrugDAO();
		dao.checkExpire(Integer.parseInt(txtCheckExpire.getText())).stream().forEach(drug-> model.addRow(new Object[] {
				drug.getId(),drug.getTypeId(),drug.getName(),drug.getQuantity(),drug.getUnit(),
				drug.getPrice(),drug.getUsage(),drug.getManufacturers()
				,drug.getManuDay(),drug.getExpire(),drug.isStatus()
			}));
	}
	protected void btnRefreshActionPerformed(ActionEvent e) {
		refresh();
	}
	protected void btnAddActionPerformed(ActionEvent e) {
		if(txtTypeId.getText().isEmpty()||txtTypeName.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill in the blank to complete The Add Drug's Type");
			return;
		}
		var type = new DrugType(); 
		type.setId(txtTypeId.getText());
		type.setName(txtTypeName.getText());
		var dao = new DrugTypeDAO();
		dao.insertType(type);
	}
	//Menu
	
	protected void mnHomeActionPerformed(ActionEvent e) {
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
