package supplierPackage;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
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
import dao.SupplierDAO;
import drugTypePackage.DrugTypePage;
import entity.Supplier;
import home.HomePage;
import loginPackage.Login;
import orderPackage.OrderDetailForm;
import orderPackage.OrderForm;

import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;


public class SupplierManagement extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblSuppliersInformation;
	private JLabel lblId;
	private JTextField txtId;
	private JLabel lblSupplierName;
	private JTextField txtName;
	private JLabel lblPhone;
	private JTextField txtPhone;
	private JLabel lblAddress;
	private JTextField txtAddress;
	private JPanel pnlKH1;
	private JScrollPane scrKH;
	private JPanel panel_1;
	private JRadioButton checkPhone;
	private JRadioButton checkName;
	private JLabel lblSearchSupplierBy;
	private JTextField txtSearch;
	private JButton btnSearch;
	private JButton btnPrevious;
	private JButton btnNext;
	private JTextField txtPage;
	private JButton btnRefresh;
	private JButton btnClear;
	private Integer pageNumber =1;
	private Integer rowOfPage =10;
	private Integer totalCount =0;
	private Double totalPage =0.0;
	private JTable table;
	private JButton btnInsert;
	private JButton btnUpdate;
	private JButton btnDelete;
	private static SupplierManagement instance;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmHome;
	private JMenuItem mntmReceipt;
	private JMenuItem mntmStatistic;
	private JMenuItem mntmExit;
	private JMenu mnMedicine;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mnMedicineType;
	private JSeparator separator;
	private JMenuItem mnSupplier;
	private JMenuItem mnCustomer;
	private JSeparator separator_1;
	private JMenuItem mnOrder;
	private JMenuItem mnOrderDetail;
	public static SupplierManagement getInstance() {
		if(instance == null) {
			instance = new SupplierManagement();
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
					SupplierManagement frame = new SupplierManagement();
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
	public SupplierManagement() {
		setTitle("Pharmacy Store");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1354, 720);
		
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
		
		mnMedicine = new JMenu("Management");
		menuBar.add(mnMedicine);
		
		mntmNewMenuItem = new JMenuItem("Medicine");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmNewMenuItemActionPerformed(e);
			}
		});
		mnMedicine.add(mntmNewMenuItem);
		
		mnMedicineType = new JMenuItem("Medicine Type");
		mnMedicineType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mnMedicineTypeActionPerformed(e);
			}
		});
		mnMedicine.add(mnMedicineType);
		
		separator = new JSeparator();
		mnMedicine.add(separator);
		
		mnSupplier = new JMenuItem("Supplier");
		mnSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mnSupplierActionPerformed(e);
			}
		});
		mnMedicine.add(mnSupplier);
		
		mnCustomer = new JMenuItem("Customer");
		mnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mnCustomerActionPerformed(e);
			}
		});
		mnMedicine.add(mnCustomer);
		
		separator_1 = new JSeparator();
		mnMedicine.add(separator_1);
		
		mnOrder = new JMenuItem("Order");
		mnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mnOrderActionPerformed(e);
			}
		});
		mnMedicine.add(mnOrder);
		
		mnOrderDetail = new JMenuItem("Order Detail");
		mnOrderDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mnOrderDetailActionPerformed(e);
			}
		});
		mnMedicine.add(mnOrderDetail);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(176, 224, 230));
		setContentPane(contentPane);
		
		panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1318, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 615, GroupLayout.PREFERRED_SIZE))
		);
		
		lblSuppliersInformation = new JLabel("SUPPLIER'S INFORMATION");
		lblSuppliersInformation.setBounds(10, 10, 1298, 54);
		lblSuppliersInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblSuppliersInformation.setForeground(Color.RED);
		lblSuppliersInformation.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		lblId = new JLabel("ID:");
		lblId.setBounds(86, 74, 64, 26);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtId = new JTextField();
		txtId.setBounds(237, 74, 225, 30);
		txtId.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtId.setEditable(false);
		txtId.setColumns(10);
		
		lblSupplierName = new JLabel("Supplier name:");
		lblSupplierName.setBounds(86, 133, 100, 21);
		lblSupplierName.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtName = new JTextField();
		txtName.setBounds(237, 129, 225, 30);
		txtName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtName.setColumns(10);
		
		lblPhone = new JLabel("Number Phone(+84):");
		lblPhone.setBounds(86, 186, 141, 26);
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtPhone = new JTextField();
		txtPhone.setBounds(237, 185, 225, 30);
		txtPhone.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtPhone.setColumns(10);
		panel.setLayout(null);
		panel.add(lblId);
		panel.add(txtId);
		panel.add(lblSupplierName);
		panel.add(txtName);
		panel.add(lblPhone);
		panel.add(txtPhone);
		panel.add(lblSuppliersInformation);
		
		lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAddress.setBounds(568, 78, 80, 21);
		panel.add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtAddress.setColumns(10);
		txtAddress.setBounds(719, 74, 225, 30);
		panel.add(txtAddress);
		
		pnlKH1 = new JPanel();
		pnlKH1.setLayout(null);
		pnlKH1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Supplier List", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlKH1.setBackground(new Color(176, 224, 230));
		pnlKH1.setBounds(10, 240, 1298, 236);
		panel.add(pnlKH1);
		
		scrKH = new JScrollPane();
		scrKH.setBounds(10, 22, 1278, 203);
		pnlKH1.add(scrKH);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
			}
		});
		scrKH.setViewportView(table);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(240, 240, 240), new Color(160, 160, 160)), "Search By:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 505, 1298, 100);
		panel.add(panel_1);
		
		checkPhone = new JRadioButton("Phone number");
		checkPhone.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkPhone.setBounds(298, 58, 120, 23);
		panel_1.add(checkPhone);
		
		checkName = new JRadioButton("Name");
		checkName.setSelected(true);
		checkName.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkName.setBounds(215, 58, 80, 23);
		panel_1.add(checkName);
		
		lblSearchSupplierBy = new JLabel("Search supplier by:");
		lblSearchSupplierBy.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSearchSupplierBy.setBounds(21, 24, 172, 25);
		panel_1.add(lblSearchSupplierBy);
		
		txtSearch = new JTextField();
		txtSearch.setColumns(10);
		txtSearch.setBounds(215, 21, 270, 30);
		panel_1.add(txtSearch);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSearchActionPerformed(e);
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch.setBounds(583, 21, 120, 30);
		panel_1.add(btnSearch);
		
		btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPreviousActionPerformed(e);
			}
		});
		btnPrevious.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPrevious.setBounds(810, 39, 120, 30);
		panel_1.add(btnPrevious);
		
		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNextActionPerformed(e);
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNext.setBounds(1122, 39, 120, 30);
		panel_1.add(btnNext);
		
		txtPage = new JTextField();
		txtPage.setText("1");
		txtPage.setHorizontalAlignment(SwingConstants.CENTER);
		txtPage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPage.setColumns(10);
		txtPage.setBounds(965, 39, 120, 30);
		panel_1.add(txtPage);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRefreshActionPerformed(e);
			}
		});
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRefresh.setBounds(583, 60, 120, 30);
		panel_1.add(btnRefresh);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClearActionPerformed(e);
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClear.setBounds(1114, 182, 120, 30);
		panel.add(btnClear);
		
		btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnInsertActionPerformed(e);
			}
		});
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnInsert.setBounds(568, 182, 120, 30);
		panel.add(btnInsert);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdateActionPerformed(e);
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(761, 182, 120, 30);
		panel.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleteActionPerformed(e);
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBounds(944, 182, 120, 30);
		panel.add(btnDelete);
		contentPane.setLayout(gl_contentPane);
		loadManu();
	}
	private void loadManu() {
		var model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Address");
		model.addColumn("Phone");
		var dao = new SupplierDAO();
		totalCount = dao.countManu();
		totalPage = Math.ceil(totalCount.doubleValue()/rowOfPage);
		dao.selectManu(pageNumber,rowOfPage).stream().forEach(manu -> model.addRow(new Object[] {
				manu.getId(),manu.getName(),manu.getAddress(),manu.getPhone()
		}));
		table.setModel(model);
	}
	
	protected void tableMouseClicked(MouseEvent e) {
		var indexRow = table.getSelectedRow();
		txtId.setText(table.getValueAt(indexRow, 0).toString());
		txtName.setText(table.getValueAt(indexRow, 1).toString());
		txtAddress.setText(table.getValueAt(indexRow, 2).toString());
		txtPhone.setText(table.getValueAt(indexRow, 3).toString());
	}
	private void refresh() {
		var model = ( DefaultTableModel)table.getModel();
		model.setRowCount(0);
		var dao = new SupplierDAO();
		dao.selectManu(pageNumber,rowOfPage).stream().forEach(manu -> model.addRow(new Object[] {
				manu.getId(),manu.getName(),manu.getAddress(),manu.getPhone()
		}));
	}
	protected void btnClearActionPerformed(ActionEvent e) {
		txtId.setText("");
		txtName.setText("");
		txtPhone.setText("");
		txtAddress.setText("");
	}
	
	protected void btnSearchActionPerformed(ActionEvent e) {
		if(txtSearch.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill text in Search");
			return;
		}

		var model = ( DefaultTableModel)table.getModel();
		model.setRowCount(0);
		var dao = new SupplierDAO();
		if(checkName.isSelected()) {
			dao.searchManuName(txtSearch.getText()).stream().forEach(manu -> model.addRow(new Object[] {
					manu.getId(),manu.getName(),manu.getAddress(),manu.getPhone()
			}));
		}else {
			dao.searchManuPhone(Integer.parseInt(txtSearch.getText())).stream().forEach(manu -> model.addRow(new Object[] {
					manu.getId(),manu.getName(),manu.getAddress(),manu.getPhone()
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
	protected void btnRefreshActionPerformed(ActionEvent e) {
		refresh();
	}
	protected void btnInsertActionPerformed(ActionEvent e) {
		if(txtName.getText().isEmpty()||txtPhone.getText().isEmpty()||txtAddress.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill in the blank to complete inserted");
			return;
		}
		var manu = new Supplier();
		manu.setName(txtName.getText());
		manu.setAddress(txtAddress.getText());
		manu.setPhone(Integer.parseInt(txtPhone.getText()));
		var dao = new SupplierDAO();
		dao.insertManu(manu);
		
		loadManu();
		refresh();
	}
	protected void btnUpdateActionPerformed(ActionEvent e) {
		if(txtName.getText().isEmpty()||txtPhone.getText().isEmpty()||txtAddress.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill in the blank to complete updated");
			return;
		}
		var manu = new Supplier();
		manu.setId(Integer.parseInt(txtId.getText()));
		manu.setName(txtName.getText());
		manu.setAddress(txtAddress.getText());
		manu.setPhone(Integer.parseInt(txtPhone.getText()));
		var dao = new SupplierDAO();
		dao.updateManu(manu);
		
		loadManu();
		refresh();
	}
	protected void btnDeleteActionPerformed(ActionEvent e) {
		if(txtId.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill in the blank to complete deleted");
			return;
		}
		var dao = new SupplierDAO();
		dao.deleteManu(Integer.parseInt(txtId.getText()));
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
	
	protected void mntmNewMenuItemActionPerformed(ActionEvent e) {
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
