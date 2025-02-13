package loginPackage;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.UserDAO;
import entity.User;
import home.HomePage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Login extends JFrame {
	private static Login instance;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnLogin;
	private JLabel lblNewLabel;
	private JLabel lblUser;
	private JLabel lblPass;
	private JTextField txtUser;
	private JPasswordField txtPass;
	private JButton btnNewButton;
	private JButton btnForgot;
	private JLabel lblNewLabel_1;
	public static Login getInstance() {
		if(instance == null) {
			instance = new Login();
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
					Login frame = new Login();
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
	public Login() {
		setVisible(true);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(320, 180, 800, 365);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		setUndecorated(true);//to remove frame out line
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(169, 280, 110, 33);
		btnLogin.setBorder(null);
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(100, 149, 237));
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoginActionPerformed(e);
			}
		});
		
		lblNewLabel = new JLabel("LOGIN PHARAMACY SYSTEM");
		lblNewLabel.setBounds(163, 63, 451, 79);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblUser = new JLabel("");
		lblUser.setBounds(99, 151, 60, 48);
		lblUser.setIcon(new ImageIcon(Login.class.getResource("/picture/icons8-username-48.png")));
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		lblPass = new JLabel("");
		lblPass.setBounds(113, 221, 48, 48);
		lblPass.setIcon(new ImageIcon(Login.class.getResource("/picture/icons8-password-48.png")));
		lblPass.setHorizontalAlignment(SwingConstants.CENTER);
		lblPass.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		txtUser = new JTextField();
		txtUser.setBounds(169, 151, 445, 50);
		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtUser.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(169, 221, 445, 48);
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		btnNewButton = new JButton("Register");
		btnNewButton.setBounds(289, 280, 131, 33);
		btnNewButton.setBorder(null);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(100, 149, 237));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButtonActionPerformed(e);
			}
		});
		
		btnForgot = new JButton("Forget password");
		btnForgot.setBounds(425, 280, 191, 33);
		btnForgot.setBorder(null);
		btnForgot.setForeground(new Color(255, 255, 255));
		btnForgot.setBackground(new Color(100, 149, 237));
		btnForgot.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		btnForgot.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnForgot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnForgotActionPerformed(e);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnLogin);
		contentPane.add(lblNewLabel);
		contentPane.add(lblUser);
		contentPane.add(lblPass);
		contentPane.add(txtUser);
		contentPane.add(txtPass);
		contentPane.add(btnNewButton);
		contentPane.add(btnForgot);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/picture/icons8-pharmacy-shop-64.png")));
		lblNewLabel_1.setBounds(101, 81, 60, 48);
		contentPane.add(lblNewLabel_1);
	}

	protected void btnLoginActionPerformed(ActionEvent e) {
		if(txtUser.getText().isEmpty()||new String(txtPass.getPassword()).isEmpty()) {
			JOptionPane.showMessageDialog(this,"Please fill in the blank");
			return;
		}
		var user = new User();
		user.setUserName(txtUser.getText());
		user.setPassword(new String(txtPass.getPassword()));
		var dao = new UserDAO();
		if(dao.login(user)) {
			JOptionPane.showMessageDialog(this, "Login successful");
			var home = HomePage.getInstance();
			if(!home.isVisible()) {
					home.setVisible(true);
					this.setVisible(false);
			}
			txtUser.setText("");
			txtPass.setText("");
		}else{
			JOptionPane.showMessageDialog(this, "Invalid username or password");
		}
		
	}
		
	protected void btnNewButtonActionPerformed(ActionEvent e) {
		var register = Register.getInstance();
		if(!register.isVisible()) {
			register.setVisible(true);
			this.setVisible(false);
			register.setLocationRelativeTo(null);
		}
		
	}
	protected void btnForgotActionPerformed(ActionEvent e) {
		var forget = ForgetPass.getInstance();
		if(!forget.isVisible()) {
			forget.setVisible(true);
			this.setVisible(false);
			forget.setLocationRelativeTo(null);
		}
	}
}
