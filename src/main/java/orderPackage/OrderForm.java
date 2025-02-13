package orderPackage;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;

import java.awt.Component;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import app.PhamarcyManagement;
import app.Receipt;
import app.Statistic;
import customerPackage.CustomerPage;
import dao.OrderDAO;
import drugTypePackage.DrugTypePage;
import entity.Order;
import home.HomePage;
import loginPackage.Login;
import supplierPackage.SupplierManagement;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class OrderForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField txtId;
	private JTextField txtCustomer;
	private JTextField txtPay;
	private JPanel panel;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panel_2;
	private JLabel lblNewLabel_4;
	private JTextField txtSearch;
	private JButton btnSearch;
	private JLabel lblNewLabel_5;
	private JDateChooser dateChooser;
	private JLabel lblNewLabel_6;
	private JTextField txtAmount;
	private JButton btnInsert;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnPrevious;
	private JTextField txtPage;
	private JButton btnNext;
	private Integer pageNumber =1;
	private Integer rowOfPage =10;
	private Integer totalCount =0;
	private Double totalPage =0.0;
	private JButton btnClear;
	private JButton btnRefresh;
	private static OrderForm instance;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmHome;
	private JMenuItem mntmReceipt;
	private JMenuItem mntmStatistic;
	private JMenuItem mntmExit;
	private JMenu mnMedicine;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mnMedicineType;
	private JSeparator separator;
	private JMenuItem mnSupplier;
	private JMenuItem mnCustomer;
	private JSeparator separator_1;
	private JMenuItem mnOrder;
	private JMenuItem mnOrderDetail;
	public static OrderForm getInstance() {
		if(instance == null) {
			instance = new OrderForm();
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
					OrderForm frame = new OrderForm();
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
	public OrderForm() {
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
		
		mnMedicine = new JMenu("Management");
		menuBar.add(mnMedicine);
		
		mntmNewMenuItem_1 = new JMenuItem("Medicine");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmNewMenuItem_1ActionPerformed(e);
			}
		});
		mnMedicine.add(mntmNewMenuItem_1);
		
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
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		lblNewLabel = new JLabel("ORDER INFORMATION");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Order Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Order Detail List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		scrollPane = new JScrollPane();
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Order Function", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setSize(995, 10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(164)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 997, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 997, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 997, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(172, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(550, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 470, GroupLayout.PREFERRED_SIZE)
					.addGap(455))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(70, Short.MAX_VALUE))
		);
		
		lblNewLabel_4 = new JLabel("Search by:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtSearch = new JTextField();
		txtSearch.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButtonActionPerformed(e);
			}
		});
		
		btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPreviousActionPerformed(e);
			}
		});
		btnPrevious.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		txtPage = new JTextField();
		txtPage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPage.setText("1");
		txtPage.setHorizontalAlignment(SwingConstants.CENTER);
		txtPage.setColumns(10);
		
		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNextActionPerformed(e);
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 15));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
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
					.addContainerGap(96, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(13)
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(15)
							.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(15)
							.addComponent(btnSearch))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(14)
							.addComponent(btnPrevious, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(14)
							.addComponent(txtPage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(14)
							.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		gl_panel_2.linkSize(SwingConstants.VERTICAL, new Component[] {btnPrevious, txtPage});
		gl_panel_2.linkSize(SwingConstants.VERTICAL, new Component[] {txtSearch, btnSearch});
		panel_2.setLayout(gl_panel_2);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
			}
		});
		scrollPane.setViewportView(table);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(4)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 975, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
		);
		panel_1.setLayout(gl_panel_1);
		
		lblNewLabel_1 = new JLabel("Order ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Customer:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtCustomer = new JTextField();
		txtCustomer.setColumns(10);
		
		txtPay = new JTextField();
		txtPay.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Payment Type:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblNewLabel_5 = new JLabel("Order Date:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		dateChooser = new JDateChooser();
		
		lblNewLabel_6 = new JLabel("Amount:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtAmount = new JTextField();
		txtAmount.setColumns(10);
		
		btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnInsertActionPerformed(e);
			}
		});
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdateActionPerformed(e);
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleteActionPerformed(e);
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClearActionPerformed(e);
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRefreshActionPerformed(e);
			}
		});
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(21)
							.addComponent(txtId, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
							.addGap(109)
							.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
							.addGap(33)
							.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(21)
							.addComponent(txtCustomer, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
							.addGap(109)
							.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtAmount, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
							.addGap(33)
							.addComponent(btnRefresh, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addGap(10)
							.addComponent(txtPay, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
							.addGap(160)
							.addComponent(btnInsert, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
							.addGap(35)
							.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
							.addGap(35)
							.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(41)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(txtId, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(btnClear)))
					.addGap(17)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(txtCustomer, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(txtAmount, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(5)
							.addComponent(btnRefresh)))
					.addGap(14)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(txtPay, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(4)
							.addComponent(btnInsert))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(4)
							.addComponent(btnUpdate))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(4)
							.addComponent(btnDelete))))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		loadOrder();
	}
	public void loadOrder() {
		var model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Customer Name");
		model.addColumn("Pay Type");
		model.addColumn("Order Date");
		model.addColumn("Amount Paid");
		var dao = new OrderDAO();
		totalCount = dao.countOrder();
		totalPage = Math.ceil(totalCount.doubleValue()/rowOfPage);
		dao.selectOrder(pageNumber,rowOfPage).stream().forEach(order->model.addRow(new Object[] {
				order.getId(),order.getCusName(),order.getPayType(),order.getOrderDate(),order.getAmountPaid()
		}));
		table.setModel(model);
	}
	
	
	protected void tableMouseClicked(MouseEvent e) {
		var dao = new OrderDAO();
		var indexRow = table.getSelectedRow();
		txtId.setText(table.getValueAt(indexRow, 0).toString());
		txtCustomer.setText(dao.getCusIdByCusName(table.getValueAt(indexRow, 1).toString()));
		txtPay.setText(dao.getPayIdByPayMode(table.getValueAt(indexRow, 2).toString()));
		try {
			dateChooser.setDate(
					new SimpleDateFormat("yyyy-MM-dd").parse(table.getValueAt(indexRow, 3).toString())
					);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		txtAmount.setText(table.getValueAt(indexRow, 4).toString());
	}
	
	protected void btnInsertActionPerformed(ActionEvent e) {
		if(txtCustomer.getText().isEmpty()||txtPay.getText().isEmpty()
				||dateChooser.getDate()== null||txtAmount.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill in the blank to complete inserted");
			return;
		}
		var order = new Order();
		order.setCusName(txtCustomer.getText());
		order.setPayType(txtPay.getText());
		order.setOrderDate(LocalDate.ofInstant(
				dateChooser.getDate().toInstant(),ZoneId.systemDefault()
				));
		order.setAmountPaid(new BigDecimal(txtAmount.getText()));
		var dao = new OrderDAO();
		dao.insertOrder(order);
		
		loadOrder();
		refresh();
	}
	
	
	protected void btnUpdateActionPerformed(ActionEvent e) {
		if(txtCustomer.getText().isEmpty()||txtPay.getText().isEmpty()
				||dateChooser.getDate()== null||txtAmount.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill in the blank to complete inserted");
			return;
		}
		var order = new Order();
		order.setId(Integer.parseInt(txtId.getText()));
		order.setCusName(txtCustomer.getText());
		order.setPayType(txtPay.getText());
		order.setOrderDate(LocalDate.ofInstant(
				dateChooser.getDate().toInstant(),ZoneId.systemDefault()
				));
		order.setAmountPaid(new BigDecimal(txtAmount.getText()));
		var dao = new OrderDAO();
		dao.updateOrder(order);
		loadOrder();
		refresh();
	}
	
	private void refresh() {
		var model = ( DefaultTableModel)table.getModel();
		model.setRowCount(0);
		var dao = new OrderDAO();
		dao.selectOrder(pageNumber,rowOfPage).stream().forEach(order->model.addRow(new Object[] {
				order.getId(),order.getCusName(),order.getPayType(),order.getOrderDate(),order.getAmountPaid()
		}));
	}
	protected void btnDeleteActionPerformed(ActionEvent e) {
		if(txtId.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill in the blank to complete deleted");
			return;
		}
		var dao = new OrderDAO();
		dao.deleteOrder(Integer.parseInt(txtId.getText()));
		refresh();
	}
	protected void btnClearActionPerformed(ActionEvent e) {
		txtId.setText("");
		txtCustomer.setText("");
		txtPay.setText("");
		txtAmount.setText("");
	}
	
	protected void btnNewButtonActionPerformed(ActionEvent e) {
		var model = ( DefaultTableModel)table.getModel();
		model.setRowCount(0);
		var dao = new OrderDAO();
		dao.searchCusName(txtSearch.getText()).stream().forEach(order->model.addRow(new Object[] {
				order.getId(),order.getCusName(),order.getPayType(),order.getOrderDate(),order.getAmountPaid()
		}));
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
	
	protected void mntmNewMenuItem_1ActionPerformed(ActionEvent e) {
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
