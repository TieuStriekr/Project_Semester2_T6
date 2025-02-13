package home;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import loginPackage.Login;
import loginPackage.loginTest;

import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomeTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnSystem;
	private JMenuItem mnExit;
	private JMenu mnManagerment;
	private JMenu mnSettle;
	private JMenuItem mnStatistic;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private static HomeTest instance;
	public static HomeTest getInstance() {
		if(instance == null) {
			instance = new HomeTest();
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
					HomeTest frame = new HomeTest();
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
	public HomeTest() {
		setTitle("Pharmacy store");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400,800);
		
		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(176, 224, 230));
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(176, 224, 230));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Medicine List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(40, 95, 1300, 250);
		contentPane.add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 25, 1250, 200);
		panel.add(scrollPane);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(40, 404, 1300, 250);
		contentPane.add(panel_1);
		
		lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 24, 70, 20);
		panel_1.add(lblNewLabel);
		
		mnSystem = new JMenu("SYSTEM");
		mnSystem.setIcon(new ImageIcon(getClass().getResource("/picture/icons8-system-64.png")));
		mnSystem.setFont(new Font("Tahoma", Font.BOLD, 12));
		mnSystem.setForeground(Color.BLACK);
		menuBar.add(mnSystem);
		
		mnExit = new JMenuItem("Log out");
		mnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mnExitActionPerformed(e);
			}
		});
		mnExit.setForeground(new Color(0, 0, 0));
		mnSystem.add(mnExit);
		
		mnManagerment = new JMenu("MANAGERMENT");
		mnManagerment.setIcon(new ImageIcon(getClass().getResource("/picture/icons8-management-64.png")));
		mnManagerment.setForeground(Color.BLACK);
		mnManagerment.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuBar.add(mnManagerment);
		
		mnSettle = new JMenu("SETTLE");
		mnSettle.setIcon(new ImageIcon(getClass().getResource("/picture/icons8-handle-with-care-64.png")));
		mnSettle.setForeground(Color.BLACK);
		mnSettle.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuBar.add(mnSettle);
		
		mnStatistic = new JMenu("STATISTIC");
		mnStatistic.setIcon(new ImageIcon(getClass().getResource("/picture/icons8-statistic-64.png")));
		mnStatistic.setFont(new Font("Tahoma", Font.BOLD, 12));
		mnStatistic.setForeground(Color.BLACK);
		menuBar.add(mnStatistic);
	}
	protected void mnExitActionPerformed(ActionEvent e) {
		var login = loginTest.getInstance();
		if(!login.isVisible()) {
			login.setVisible(true);
			this.setVisible(false);
			login.setLocationRelativeTo(null);
		}
		
	}
}
