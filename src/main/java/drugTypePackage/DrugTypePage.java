package drugTypePackage;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import app.PhamarcyManagement;
import app.Receipt;
import app.Statistic;
import customerPackage.CustomerPage;
import dao.DrugTypeDAO;
import entity.DrugType;
import home.HomePage;
import loginPackage.Login;
import orderPackage.OrderDetailForm;
import orderPackage.OrderForm;
import supplierPackage.SupplierManagement;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class DrugTypePage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblDrugTypesInformation;
	private JLabel lblId;
	private JTextField txtId;
	private JLabel lblName;
	private JTextField txtName;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panel_2;
	private JLabel lblSearchBy;
	private JTextField txtSearch;
	private JButton btnSearch;
	private JButton btnRefresh;
	private JButton btnPrevious;
	private JTextField txtPage;
	private JButton btnNext;
	private JRadioButton cbId;
	private JRadioButton cbName;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnInsert;
	private JButton btnUpdate;
	private JButton btnClear;
	private Integer pageNumber =1;
	private Integer rowOfPage =10;
	private Integer totalCount =0;
	private Double totalPage =0.0;
	private static DrugTypePage instance;
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
	public static DrugTypePage getInstance() {
		if(instance == null) {
			instance = new DrugTypePage();
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
					DrugTypePage frame = new DrugTypePage();
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
	public DrugTypePage() {
		setTitle("Pharmacy Store");
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
		
		panel = new JPanel();
		
		lblDrugTypesInformation = new JLabel("DRUG TYPE'S INFORMATION");
		lblDrugTypesInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblDrugTypesInformation.setForeground(Color.RED);
		lblDrugTypesInformation.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtId = new JTextField();
		txtId.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtId.setColumns(10);
		
		lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtName = new JTextField();
		txtName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtName.setColumns(10);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Type List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(new Color(176, 224, 230));
		panel_1.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 15, 1045, 147);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
			}
		});
		scrollPane.setViewportView(table);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Type List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(new Color(240, 240, 240));
		
		lblSearchBy = new JLabel("Search by:");
		lblSearchBy.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSearchBy.setBounds(10, 30, 90, 25);
		panel_2.add(lblSearchBy);
		
		txtSearch = new JTextField();
		txtSearch.setColumns(10);
		txtSearch.setBounds(110, 27, 180, 30);
		panel_2.add(txtSearch);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSearchActionPerformed(e);
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch.setBounds(330, 27, 120, 30);
		panel_2.add(btnSearch);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRefreshActionPerformed(e);
			}
		});
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRefresh.setBounds(330, 66, 120, 30);
		panel_2.add(btnRefresh);
		
		btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPreviousActionPerformed(e);
			}
		});
		btnPrevious.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPrevious.setBounds(600, 45, 120, 30);
		panel_2.add(btnPrevious);
		
		txtPage = new JTextField();
		txtPage.setText("1");
		txtPage.setHorizontalAlignment(SwingConstants.CENTER);
		txtPage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPage.setColumns(10);
		txtPage.setBounds(750, 45, 120, 30);
		panel_2.add(txtPage);
		
		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNextActionPerformed(e);
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNext.setBounds(900, 45, 120, 30);
		panel_2.add(btnNext);
		
		cbId = new JRadioButton("ID");
		buttonGroup.add(cbId);
		cbId.setBackground(new Color(255, 255, 255));
		cbId.setSelected(true);
		cbId.setHorizontalAlignment(SwingConstants.CENTER);
		cbId.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbId.setBounds(110, 73, 90, 21);
		panel_2.add(cbId);
		
		cbName = new JRadioButton("Name");
		buttonGroup.add(cbName);
		cbName.setBackground(new Color(255, 255, 255));
		cbName.setHorizontalAlignment(SwingConstants.CENTER);
		cbName.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbName.setBounds(200, 73, 90, 21);
		panel_2.add(cbName);
		
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
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClearActionPerformed(e);
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(60)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1200, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 648, GroupLayout.PREFERRED_SIZE))
		);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(300)
					.addComponent(lblDrugTypesInformation, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(62)
					.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addGap(25)
					.addComponent(txtId, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
					.addGap(225)
					.addComponent(btnInsert, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addGap(63)
					.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(62)
					.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
					.addGap(225)
					.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(62)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 1070, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(62)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 1070, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(15)
					.addComponent(lblDrugTypesInformation, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtId, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnInsert, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(9)
							.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(4)
							.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(53)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		loadDrugType();
	}
	private void loadDrugType() {
		var model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Name");
		var dao = new DrugTypeDAO();
		totalCount = dao.countDrugType();
		totalPage = Math.ceil(totalCount.doubleValue()/rowOfPage);
		dao.selectDrugType(pageNumber,rowOfPage).stream().forEach(type -> model.addRow(new Object[] {
				type.getId(),type.getName()
		}));
		table.setModel(model);
	}
	
	
	protected void tableMouseClicked(MouseEvent e) {
		var indexRow = table.getSelectedRow();
		txtId.setText(table.getValueAt(indexRow, 0).toString());
		txtName.setText(table.getValueAt(indexRow, 1).toString());
	}
	
	private void refresh() {
		var model = ( DefaultTableModel)table.getModel();
		model.setRowCount(0);
		var dao = new DrugTypeDAO();
		dao.selectDrugType(pageNumber,rowOfPage).stream().forEach(type -> model.addRow(new Object[] {
				type.getId(),type.getName()
		}));
	}
	
	protected void btnClearActionPerformed(ActionEvent e) {
		txtId.setText("");
		txtName.setText("");
	}
	
	
	protected void btnSearchActionPerformed(ActionEvent e) {
		if(txtSearch.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill text in Search");
			return;
		}
		
		var model = ( DefaultTableModel)table.getModel();
		model.setRowCount(0);
		var dao = new DrugTypeDAO();
		if(cbId.isSelected()) {
			dao.searchTypeId(txtSearch.getText()).stream().forEach(type -> model.addRow(new Object[] {
					type.getId(),type.getName()
			}));
		}else {
			dao.searchTypeName(txtSearch.getText()).stream().forEach(type -> model.addRow(new Object[] {
					type.getId(),type.getName()
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
	
	protected void btnInsertActionPerformed(ActionEvent e) {
		if(txtName.getText().isEmpty()|txtId.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill in the blank to complete inserted");
			return;
		}
		
		var type = new DrugType();
		type.setId(txtId.getText());
		type.setName(txtName.getText());
		var dao = new DrugTypeDAO();
		dao.insertType(type);
		
		loadDrugType();
		refresh();
	}
	
	protected void btnUpdateActionPerformed(ActionEvent e) {
		if(txtName.getText().isEmpty()|txtId.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill in the blank to complete inserted");
			return;
		}
		
		var type = new DrugType();
		type.setId(txtId.getText());
		type.setName(txtName.getText());
		var dao = new DrugTypeDAO();
		dao.updateType(type);
		
		loadDrugType();
		refresh();
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
