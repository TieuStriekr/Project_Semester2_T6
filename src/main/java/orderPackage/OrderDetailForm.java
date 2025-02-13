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

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import app.PhamarcyManagement;
import app.Receipt;
import app.Statistic;
import customerPackage.CustomerPage;

import javax.swing.JTextField;


import dao.OrderDetailDAO;
import drugTypePackage.DrugTypePage;
import entity.OrderDetail;
import home.HomePage;
import loginPackage.Login;
import supplierPackage.SupplierManagement;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Rectangle;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;


public class OrderDetailForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JTextField txtDetailId;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField txtOrderId;
	private JLabel lblNewLabel_4;
	private JTextField txtQuantity;
	private JLabel lblNewLabel_5;
	private JTextField txtProId;
	private JButton btnInsert;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnClear;
	private JButton btnRefresh;
	private JTextField txtPriceEach;
	private JPanel panel_2;
	private JLabel lblNewLabel_6;
	private JTextField txtSearch;
	private JButton btnSearch;
	private JButton btnPrevious;
	private JTextField txtPage;
	private JButton btnNext;
	private Integer pageNumber =1;
	private Integer rowOfPage =10;
	private Integer totalCount =0;
	private Double totalPage =0.0;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JTable table;
	private static OrderDetailForm instance;
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
	public static OrderDetailForm getInstance() {
		if(instance == null) {
			instance = new OrderDetailForm();
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
					OrderDetailForm frame = new OrderDetailForm();
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
	public OrderDetailForm() {
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
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		lblNewLabel = new JLabel("ORDER DETAIL");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Order Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		lblNewLabel_1 = new JLabel("Order Detail ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtDetailId = new JTextField();
		txtDetailId.setEnabled(false);
		txtDetailId.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Price:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblNewLabel_3 = new JLabel("Order ID:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtOrderId = new JTextField();
		txtOrderId.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Quantity:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtQuantity = new JTextField();
		txtQuantity.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Product ID:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtProId = new JTextField();
		txtProId.setColumns(10);
		
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
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Order Function", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		lblNewLabel_6 = new JLabel("Search by:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		
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
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Order Detail List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		txtPriceEach = new JTextField();
		txtPriceEach.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(543)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(164)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 997, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(164)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 997, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(164)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 997, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
		);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(new Rectangle(150, 0, 400, 200));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(12)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 960, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(494, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(9)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(182, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
			}
		});
		scrollPane.setViewportView(table);
		panel_1.setLayout(gl_panel_1);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(21)
					.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addGap(95)
					.addComponent(btnPrevious, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtPage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(13)
					.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(15)
					.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(15)
					.addComponent(btnSearch))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(14)
					.addComponent(btnPrevious))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(14)
					.addComponent(txtPage, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(14)
					.addComponent(btnNext))
		);
		panel_2.setLayout(gl_panel_2);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(118)
									.addComponent(txtDetailId, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)))
							.addGap(109)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtPriceEach, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
							.addGap(33)
							.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(21)
							.addComponent(txtOrderId, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
							.addGap(109)
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtQuantity, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
							.addGap(33)
							.addComponent(btnRefresh, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txtProId, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
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
							.addComponent(txtDetailId, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(txtPriceEach, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(btnClear)))
					.addGap(17)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(txtOrderId, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(txtQuantity, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(5)
							.addComponent(btnRefresh)))
					.addGap(14)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(txtProId, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
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
		loadOrderDetail();
	}

	public void loadOrderDetail() {
		var model = new DefaultTableModel();
		model.addColumn("Order Detail ID");
		model.addColumn("Order ID");
		model.addColumn("Product");
		model.addColumn("Price");
		model.addColumn("Quantity");
		var dao = new OrderDetailDAO();
		totalCount = dao.countOrderDetail();
		totalPage = Math.ceil(totalCount.doubleValue()/rowOfPage);
		dao.selectOrderDetail(pageNumber,rowOfPage).stream().forEach(detail->model.addRow(new Object[] {
				detail.getOrderDetailId(),detail.getOrderId(),detail.getProductName(),detail.getPriceEach(),detail.getQuantity()
		}));
		table.setModel(model);
	}
	
	protected void tableMouseClicked(MouseEvent e) {
		var dao = new OrderDetailDAO();
		var indexRow = table.getSelectedRow();
		txtDetailId.setText(table.getValueAt(indexRow, 0).toString());
		txtOrderId.setText(table.getValueAt(indexRow, 1).toString());
		txtProId.setText(dao.getProIdByProName(table.getValueAt(indexRow, 2).toString()));
		txtPriceEach.setText(table.getValueAt(indexRow, 3).toString());
		txtQuantity.setText(table.getValueAt(indexRow, 4).toString());
	}
	protected void btnInsertActionPerformed(ActionEvent e) {
		if(txtOrderId.getText().isEmpty()||txtProId.getText().isEmpty()||txtPriceEach.getText().isEmpty()
				||txtQuantity.getText().isEmpty()
			) {
			JOptionPane.showMessageDialog(this, "Please fill in the blank to complete inserted");
			return;
		}
		var detail = new OrderDetail();
		var dao = new OrderDetailDAO();
		
		detail.setOrderId(Integer.parseInt(txtOrderId.getText()));
		detail.setProductName(txtProId.getText());
		detail.setPriceEach(new BigDecimal(txtPriceEach.getText()));
		detail.setQuantity(Integer.parseInt(txtQuantity.getText()));
		dao.insertOrderDetail(detail);
		
		loadOrderDetail();
		refresh();
	}

	
	protected void btnUpdateActionPerformed(ActionEvent e) {
		if(txtOrderId.getText().isEmpty()||txtProId.getText().isEmpty()||txtPriceEach.getText().isEmpty()
				||txtQuantity.getText().isEmpty()
			) {
			JOptionPane.showMessageDialog(this, "Please fill in the blank to complete updated");
			return;
		}
		var detail = new OrderDetail();
		var dao = new OrderDetailDAO();
		detail.setOrderDetailId(Integer.parseInt(txtDetailId.getText()));
		detail.setOrderId(Integer.parseInt(txtOrderId.getText()));
		detail.setProductName(txtProId.getText());
		detail.setPriceEach(new BigDecimal(txtPriceEach.getText()));
		detail.setQuantity(Integer.parseInt(txtQuantity.getText()));
		dao.updateOrderDetail(detail);
		loadOrderDetail();
		refresh();
	}
	
	private void refresh() {
		var model = ( DefaultTableModel)table.getModel();
		model.setRowCount(0);
		var dao = new OrderDetailDAO();
		dao.selectOrderDetail(pageNumber,rowOfPage).stream().forEach(detail-> model.addRow(
				new Object[] {
						detail.getOrderDetailId(),detail.getOrderId(),detail.getProductName(),
						detail.getPriceEach(),detail.getQuantity()
				}
				));
	}
	
	
	protected void btnDeleteActionPerformed(ActionEvent e) {
		if(txtDetailId.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill in the blank to complete deleted");
			return;
		}
		var dao = new OrderDetailDAO();
		dao.deleteOrderDetail(Integer.parseInt(txtDetailId.getText()));
		refresh();
	}
	
	
	protected void btnSearchActionPerformed(ActionEvent e) {
		if(txtSearch.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill Search's text");
			return;
		}
		var model = ( DefaultTableModel)table.getModel();
		model.setRowCount(0);
		var dao = new OrderDetailDAO();
		dao.searchOrderId(Integer.parseInt(txtSearch.getText())).stream().forEach(detail-> model.addRow(
				new Object[] {
						detail.getOrderDetailId(),detail.getOrderId(),detail.getProductName(),
						detail.getPriceEach(),detail.getQuantity()
				}
				));
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
		txtDetailId.setText("");
		txtOrderId.setText("");
		txtProId.setText("");
		txtPriceEach.setText("");
		txtQuantity.setText("");
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
