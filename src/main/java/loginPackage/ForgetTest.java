package loginPackage;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.UserDAO;
import entity.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ForgetTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static ForgetTest instance;
	private JLabel lblForgetPassword;
	private JLabel lblForgetLogo;
	private JLabel lblUser;
	private JTextField txtUser;
	private JLabel lblNewLabel;
	private JLabel lblPhone;
	private JTextField txtPhone;
	private JLabel lblPhoneNumber;
	private JLabel lblRePass;
	private JLabel lblRePassword;
	private JButton btnSignIn;
	private JButton btnChange;
	private JLabel lblWarning;
	private JPasswordField txtPass;
	public static ForgetTest getInstance() {
		if(instance == null) {
			instance = new ForgetTest();
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
					ForgetTest frame = new ForgetTest();
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
	public ForgetTest() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(176, 224, 230));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblForgetPassword = new JLabel("FORGET PASSWORD");
		lblForgetPassword.setBounds(158, 18, 315, 37);
		lblForgetPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblForgetPassword.setForeground(Color.BLACK);
		lblForgetPassword.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblForgetPassword.setBackground(new Color(30, 144, 255));
		contentPane.add(lblForgetPassword);
		
		lblForgetLogo = new JLabel("");
		lblForgetLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblForgetLogo.setBounds(93, 10, 55, 52);
		lblForgetLogo.setIcon(new ImageIcon(ForgetPass.class.getResource("/picture/icons8-show-password-64.png")));
		contentPane.add(lblForgetLogo);
		
		lblUser = new JLabel("");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUser.setIcon(new ImageIcon(getClass().getResource("/picture/icons8-username-48.png")));
		lblUser.setBounds(53, 139, 60, 48);
		contentPane.add(lblUser);
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUser.setColumns(10);
		txtUser.setBorder(new EmptyBorder(0, 0, 0, 4));
		txtUser.setBounds(149, 143, 250, 40);
		contentPane.add(txtUser);
		
		lblNewLabel = new JLabel("User name");
		lblNewLabel.setBounds(149, 115, 72, 18);
		contentPane.add(lblNewLabel);
		
		lblPhone = new JLabel("");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPhone.setBounds(56, 229, 55, 48);
		lblPhone.setIcon(new ImageIcon(
				new ImageIcon(getClass().getResource("/picture/phone-icon.png"))
				.getImage().getScaledInstance(60, 48, Image.SCALE_SMOOTH)
				));
		contentPane.add(lblPhone);
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPhone.setColumns(10);
		txtPhone.setBorder(new EmptyBorder(0, 0, 0, 4));
		txtPhone.setBounds(149, 233, 250, 40);
		contentPane.add(txtPhone);
		
		lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setBounds(149, 205, 98, 18);
		contentPane.add(lblPhoneNumber);
		
		lblRePass = new JLabel("");
		lblRePass.setHorizontalAlignment(SwingConstants.CENTER);
		lblRePass.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRePass.setBounds(59, 322, 48, 48);
		lblRePass.setIcon(new ImageIcon(
				new ImageIcon(getClass().getResource("/picture/Repassword-icon.png"))
				.getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH)
				));
		contentPane.add(lblRePass);
		
		lblRePassword = new JLabel("Password");
		lblRePassword.setBounds(151, 298, 85, 18);
		contentPane.add(lblRePassword);
		
		btnSignIn = new JButton("SignIn");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSignInActionPerformed(e);
			}
		});
		btnSignIn.setForeground(Color.WHITE);
		btnSignIn.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSignIn.setBorder(null);
		btnSignIn.setBackground(new Color(51, 153, 236));
		btnSignIn.setBounds(251, 397, 120, 30);
		contentPane.add(btnSignIn);
		
		btnChange = new JButton("Confirm");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnChangeActionPerformed(e);
			}
		});
		btnChange.setForeground(Color.WHITE);
		btnChange.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnChange.setBorder(null);
		btnChange.setBackground(new Color(51, 153, 236));
		btnChange.setBounds(121, 397, 120, 30);
		contentPane.add(btnChange);
		
		lblWarning = new JLabel("<html>\r\n<p>Password must have</p>\r\n<p>8 -30 characters</p>\r\n<p>special charater @,#,...</p>\r\n<p>at least 1 upper character</p>\r\n</html>");
		lblWarning.setVerticalAlignment(SwingConstants.TOP);
		lblWarning.setForeground(Color.RED);
		lblWarning.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblWarning.setBounds(409, 322, 120, 62);
		contentPane.add(lblWarning);
		
		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPass.setEchoChar('*');
		txtPass.setBounds(149, 326, 250, 40);
		contentPane.add(txtPass);
	}

	protected void btnSignInActionPerformed(ActionEvent e) {
		var login =  loginTest.getInstance();
		if(!login.isVisible()) {
			login.setVisible(true);
			this.setVisible(false);
			login.setLocationRelativeTo(null);
		}
	}
	
	protected void btnChangeActionPerformed(ActionEvent e) {
		var dao = new UserDAO();
		String password = new String(txtPass.getPassword());
		if(txtUser.getText().isEmpty()||txtPhone.getText().isEmpty()
				||txtPass.getPassword().toString().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill in the blank");
			return;
		}
		
		// check user and phone number
		if(dao.checkUser(txtUser.getText(), Integer.parseInt(txtPhone.getText()))) {
			var user = new User();
			user.setUserName(txtUser.getText());
			user.setPhone(Integer.parseInt(txtPhone.getText()));
			
			// check condition to change pass
			if(password.matches(".*[!@#$%^&*()].*") && password.matches(".*[A-Z].*")
			&&(new String(txtPass.getPassword()).length()<8
			||new String(txtPass.getPassword()).length()<30)) {
				user.setPassword(new String(txtPass.getPassword()));
				dao.forgetPass(user);
				txtUser.setText("");
				txtPhone.setText("");
				txtPass.setText("");
			}
			else {
				lblWarning.setFont(new Font("Tahoma", Font.BOLD, 9));
			}
		}else {	
			JOptionPane.showMessageDialog(this, "Invalid Username or Phone Number");
		}
	}
}
