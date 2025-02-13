package loginPackage;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.UserDAO;
import entity.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class ForgetPass extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static ForgetPass instance;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtUser;
	private JTextField txtPhone;
	private JButton btnConfirm;
	private JButton btnSignIn;
	private JLabel lblForgetPassword;
	private JLabel Password;
	private JPasswordField passwordField;
	public static ForgetPass getInstance() {
		if(instance == null) {
			instance = new ForgetPass();
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
					ForgetPass frame = new ForgetPass();
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
	public ForgetPass() {
		setTitle("Forget password");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(320, 180, 800, 365);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(27, 102, 111, 35);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Number Phone");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2.setBounds(27, 162, 133, 35);
		contentPane.add(lblNewLabel_2);
		
		btnConfirm = new JButton("Confirm");
		btnConfirm.setForeground(new Color(255, 255, 255));
		btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnConfirm.setBackground(new Color(100, 149, 237));
		btnConfirm.setBorder(null);
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConfirmActionPerformed(e);
			}
		});
		btnConfirm.setBounds(289, 283, 99, 35);
		contentPane.add(btnConfirm);
		
		btnSignIn = new JButton("Sign In");
		btnSignIn.setForeground(new Color(255, 255, 255));
		btnSignIn.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSignIn.setBackground(new Color(100, 149, 237));
		btnSignIn.setBorder(null);
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSignInActionPerformed(e);
			}
		});
		btnSignIn.setBounds(414, 283, 99, 35);
		contentPane.add(btnSignIn);
		
		lblForgetPassword = new JLabel("FORGET PASSWORD");
		lblForgetPassword.setIcon(new ImageIcon(ForgetPass.class.getResource("/picture/icons8-show-password-64.png")));
		lblForgetPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblForgetPassword.setForeground(Color.BLACK);
		lblForgetPassword.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblForgetPassword.setBackground(new Color(30, 144, 255));
		lblForgetPassword.setBounds(182, 10, 445, 73);
		contentPane.add(lblForgetPassword);
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtUser.setColumns(10);
		txtUser.setBounds(182, 94, 445, 50);
		contentPane.add(txtUser);
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPhone.setColumns(10);
		txtPhone.setBounds(182, 154, 445, 50);
		contentPane.add(txtPhone);
		
		Password = new JLabel("Password");
		Password.setForeground(Color.BLACK);
		Password.setFont(new Font("Tahoma", Font.BOLD, 17));
		Password.setBounds(27, 222, 133, 35);
		contentPane.add(Password);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setBounds(183, 214, 445, 50);
		contentPane.add(passwordField);
	}
	protected void btnConfirmActionPerformed(ActionEvent e) {
		
		var dao = new UserDAO();
		if(txtUser.getText().isEmpty()||txtPhone.getText().isEmpty()
				||passwordField.getPassword().toString().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill in the blank");
			return;
		}
		if(dao.checkUser(txtUser.getText(), Integer.parseInt(txtPhone.getText()))) {
			var user = new User();
			user.setUserName(txtUser.getText());
			user.setPhone(Integer.parseInt(txtPhone.getText()));
			if(new String(passwordField.getPassword()).length()>=8 &&
					new String(passwordField.getPassword()).length() <= 30) {
				user.setPassword(new String(passwordField.getPassword()));
				dao.forgetPass(user);
				txtUser.setText("");
				txtPhone.setText("");
				passwordField.setText("");
			}else {
				JOptionPane.showMessageDialog(this, "Password must be between 8 to 30 characters");
			}
		}else {	
			JOptionPane.showMessageDialog(this, "Invalid Username or Phone Number");
		}
		
	}
	protected void btnSignInActionPerformed(ActionEvent e) {
		var login =  Login.getInstance();
		if(!login.isVisible()) {
			login.setVisible(true);
			this.setVisible(false);
			login.setLocationRelativeTo(null);
		}
		txtUser.setText("");
		txtPhone.setText("");
		passwordField.setText("");
	}
}
