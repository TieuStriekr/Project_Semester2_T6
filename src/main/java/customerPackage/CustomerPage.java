package customerPackage;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import app.PhamarcyManagement;
import app.Receipt;
import app.Statistic;
import dao.CustomerDAO;
import drugTypePackage.DrugTypePage;
import entity.Customer;
import home.HomePage;
import loginPackage.Login;
import orderPackage.OrderDetailForm;
import orderPackage.OrderForm;
import supplierPackage.SupplierManagement;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;


public class CustomerPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTable table;
	private JTextField txtSearch;
	private JButton btnSearch;
	private JRadioButton checkMale;
	private JRadioButton checkFemale;
	private JRadioButton checkPhone;
	private JRadioButton checkName;
	private DefaultTableModel model;
	
	private ButtonGroup btnGender;
	private ButtonGroup btnFind;
	private JButton btnInsert;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnPrevious;
	private JButton btnNext;
	private JTextField txtPage;
	private Integer pageNumber =1;
	private Integer rowOfPage =10;
	private Integer totalCount =0;
	private Double totalPage =0.0;
	private JButton btnRefresh;
	private JButton btnClear;
	private static CustomerPage instance;
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
	public static CustomerPage getInstance() {
		if(instance == null) {
			instance = new CustomerPage();
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
					CustomerPage frame = new CustomerPage();
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
	public CustomerPage() {
		setTitle("Pharmacy Store");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1354, 701);
		setLocationRelativeTo(null);
		
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
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel pnlKH = new JPanel();
		pnlKH.setBackground(new Color(240, 240, 240));

		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtId.setColumns(10);

		JLabel lblName = new JLabel("Full name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 13));

		txtName = new JTextField();
		txtName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtName.setColumns(10);

		JLabel lblPhone = new JLabel("Number Phone(+84):");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 13));

		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtPhone.setColumns(10);

		JPanel pnlKH1 = new JPanel();
		pnlKH1.setBackground(new Color(176, 224, 230));
		pnlKH1.setBorder(
				new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Customer List", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		JScrollPane scrKH = new JScrollPane();
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
			}
		});
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		scrKH.setViewportView(table);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 14));

		checkMale = new JRadioButton("Male");
		checkMale.setFont(new Font("Tahoma", Font.BOLD, 15));
		checkMale.setBackground(new Color(240, 240, 240));
		checkMale.setSelected(true);

		checkFemale = new JRadioButton("Female");
		checkFemale.setFont(new Font("Tahoma", Font.BOLD, 15));
		checkFemale.setBackground(new Color(240, 240, 240));
		checkFemale.setSelected(false);

		btnGender = new ButtonGroup();
		btnGender.add(checkMale);
		btnGender.add(checkFemale);

		JLabel lblNewLabel = new JLabel("CUSTOMER'S INFORMATION");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(240, 240, 240), new Color(160, 160, 160)), "Search By:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		checkPhone = new JRadioButton("Phone number");
		checkPhone.setFont(new Font("Tahoma", Font.BOLD, 13));

		checkName = new JRadioButton("Name");
		checkName.setSelected(true);
		checkName.setFont(new Font("Tahoma", Font.BOLD, 13));

		btnFind = new ButtonGroup();
		btnFind.add(checkPhone);
		btnFind.add(checkName);

		JLabel lblNhpThngTin = new JLabel("Search customer by:");
		lblNhpThngTin.setFont(new Font("Tahoma", Font.BOLD, 13));

		txtSearch = new JTextField();
		txtSearch.setColumns(10);

		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSearchActionPerformed(e);
			}
		});
		btnSearch.setIcon(new ImageIcon("Hinh\\search.png"));
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPreviousActionPerformed(e);
			}
		});
		btnPrevious.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNextActionPerformed(e);
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtPage = new JTextField();
		txtPage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPage.setHorizontalAlignment(SwingConstants.CENTER);
		txtPage.setText("1");
		txtPage.setColumns(10);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRefreshActionPerformed(e);
			}
		});
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnInsertActionPerformed(e);
			}
		});
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdateActionPerformed(e);
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleteActionPerformed(e);
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClearActionPerformed(e);
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 14));
		GroupLayout gl_pnlKH = new GroupLayout(pnlKH);
		gl_pnlKH.setHorizontalGroup(
			gl_pnlKH.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlKH.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 1298, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnlKH.createSequentialGroup()
					.addGap(57)
					.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addGap(87)
					.addComponent(txtId, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
					.addGap(119)
					.addComponent(lblGender, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(checkMale, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(checkFemale, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnlKH.createSequentialGroup()
					.addGap(57)
					.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(71)
					.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnlKH.createSequentialGroup()
					.addGap(57)
					.addComponent(lblPhone, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
					.addGap(119)
					.addComponent(btnInsert, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addGap(63)
					.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addGap(61)
					.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addGap(62)
					.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnlKH.createSequentialGroup()
					.addGap(10)
					.addComponent(pnlKH1, GroupLayout.PREFERRED_SIZE, 1298, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnlKH.createSequentialGroup()
					.addGap(10)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1298, GroupLayout.PREFERRED_SIZE))
		);
		gl_pnlKH.setVerticalGroup(
			gl_pnlKH.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlKH.createSequentialGroup()
					.addGap(11)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addGroup(gl_pnlKH.createParallelGroup(Alignment.LEADING)
						.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtId, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGender, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlKH.createSequentialGroup()
							.addGap(3)
							.addComponent(checkMale, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlKH.createSequentialGroup()
							.addGap(3)
							.addComponent(checkFemale, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addGap(25)
					.addGroup(gl_pnlKH.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlKH.createSequentialGroup()
							.addGap(4)
							.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_pnlKH.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlKH.createSequentialGroup()
							.addGap(1)
							.addComponent(lblPhone, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlKH.createSequentialGroup()
							.addGap(5)
							.addComponent(btnInsert, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlKH.createSequentialGroup()
							.addGap(5)
							.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlKH.createSequentialGroup()
							.addGap(5)
							.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlKH.createSequentialGroup()
							.addGap(5)
							.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(36)
					.addComponent(pnlKH1, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
		);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(15)
					.addComponent(lblNhpThngTin, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
					.addGap(22)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(checkName, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addGap(3)
							.addComponent(checkPhone, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
					.addGap(98)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRefresh, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
					.addGap(107)
					.addComponent(btnPrevious, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(txtPage, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(9)
					.addComponent(lblNhpThngTin, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(6)
					.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(checkName, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkPhone, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(6)
					.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(btnRefresh, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(24)
					.addComponent(btnPrevious, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(24)
					.addComponent(txtPage, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(24)
					.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(gl_panel);
		GroupLayout gl_pnlKH1 = new GroupLayout(pnlKH1);
		gl_pnlKH1.setHorizontalGroup(
			gl_pnlKH1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlKH1.createSequentialGroup()
					.addGap(4)
					.addComponent(scrKH, GroupLayout.PREFERRED_SIZE, 1278, GroupLayout.PREFERRED_SIZE))
		);
		gl_pnlKH1.setVerticalGroup(
			gl_pnlKH1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlKH1.createSequentialGroup()
					.addGap(7)
					.addComponent(scrKH, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))
		);
		pnlKH1.setLayout(gl_pnlKH1);
		pnlKH.setLayout(gl_pnlKH);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(pnlKH, GroupLayout.PREFERRED_SIZE, 1318, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(pnlKH, GroupLayout.PREFERRED_SIZE, 615, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
		
		loadCustomer();
	}

	private void loadCustomer() {
		var model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Gender");
		model.addColumn("Phone");
		var dao = new CustomerDAO();
		totalCount = dao.countCus();
		totalPage = Math.ceil(totalCount.doubleValue()/rowOfPage);
		dao.selectCus(pageNumber,rowOfPage).stream().forEach(cus -> model.addRow(new Object[] {
				cus.getId(),cus.getName(),cus.getGender()?"Male":"Female",cus.getPhone()
		}));
		table.setModel(model);
	}
	
	
	protected void tableMouseClicked(MouseEvent e) {
		var indexRow = table.getSelectedRow();
		txtId.setText(table.getValueAt(indexRow, 0).toString());
		txtName.setText(table.getValueAt(indexRow, 1).toString());
		String gender = table.getValueAt(indexRow,2).toString();
		if (gender.equals("Male")) {
			checkMale.setSelected(true);
			checkFemale.setSelected(false);
		}else {
			checkMale.setSelected(false);
			checkFemale.setSelected(true);
		}
		txtPhone.setText(table.getValueAt(indexRow, 3).toString());
	}
	
	
	protected void btnInsertActionPerformed(ActionEvent e) {
		if(txtName.getText().isEmpty()||txtPhone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill in the blank to complete inserted");
			return;
		}
		var cus = new Customer();
		cus.setName(txtName.getText());
		if(checkMale.isSelected()) {
			cus.setGender(true);
		}else {
			cus.setGender(false);
		}
		cus.setPhone(Integer.parseInt(txtPhone.getText()));
		var dao = new CustomerDAO();
		dao.insertCus(cus);
		
		loadCustomer();
		refresh();
	}
	
	protected void btnUpdateActionPerformed(ActionEvent e) {
		if(txtName.getText().isEmpty()||txtPhone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill in the blank to complete updated");
			return;
		}
		var cus = new Customer();
		cus.setId(Integer.parseInt(txtId.getText()));
		cus.setName(txtName.getText());
		if(checkMale.isSelected()) {
			cus.setGender(true);
		}else {
			cus.setGender(false);
		}
		cus.setPhone(Integer.parseInt(txtPhone.getText()));
		var dao = new CustomerDAO();
		dao.updateCus(cus);
		
		loadCustomer();
		refresh();
	}
	
	private void refresh() {
		var model = ( DefaultTableModel)table.getModel();
		model.setRowCount(0);
		var dao = new CustomerDAO();
		dao.selectCus(pageNumber,rowOfPage).stream().forEach(cus -> model.addRow(new Object[] {
				cus.getId(),cus.getName(),cus.getGender()?"Male":"Female",cus.getPhone()
		}));
	}
	protected void btnDeleteActionPerformed(ActionEvent e) {
		if(txtId.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill in the blank to complete deleted");
			return;
		}
		var dao = new CustomerDAO();
		dao.deleteCus(Integer.parseInt(txtId.getText()));
		refresh();
	}
	protected void btnSearchActionPerformed(ActionEvent e) {
		if(txtSearch.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill text in Search");
			return;
		}

		var model = ( DefaultTableModel)table.getModel();
		model.setRowCount(0);
		var dao = new CustomerDAO();
		if(checkName.isSelected()) {
			dao.searchCusName(txtSearch.getText()).stream().forEach(cus -> model.addRow(new Object[] {
					cus.getId(),cus.getName(),cus.getGender()?"Male":"Female",cus.getPhone()
			}));
		}else {
			dao.searchCusPhone(Integer.parseInt(txtSearch.getText())).stream().forEach(cus -> model.addRow(new Object[] {
					cus.getId(),cus.getName(),cus.getGender()?"Male":"Female",cus.getPhone()
			}));
		}
	}
	protected void btnRefreshActionPerformed(ActionEvent e) {
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
	protected void btnClearActionPerformed(ActionEvent e) {
		txtId.setText("");
		txtName.setText("");
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
}
