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
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegisterTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblRegister;
	private JLabel lblRegisterLogo;
	private JLabel lblUser;
	private JTextField txtUser;
	private JLabel lblPhone;
	private JTextField txtPhone;
	private JLabel lblNewLabel;
	private JLabel lblPhoneNumber;
	private JLabel lblPass;
	private JPasswordField txtPass;
	private JLabel lblPassword;
	private JLabel lblRePass;
	private JPasswordField txtRePass;
	private JLabel lblRePassword;
	private static RegisterTest instance;
	private JButton btnSignUp;
	private JButton btnSignIn;
	private JLabel lblText;
	private JLabel lblRed;
	private JLabel lblYellow;
	private JLabel lblGreen;
	private JLabel lblCheckStrongPass;
	private JLabel lblConfirmPass;
	private JLabel lblCheckPhone;
	public static RegisterTest getInstance() {
		if(instance == null) {
			instance = new RegisterTest();
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
					RegisterTest frame = new RegisterTest();
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
	public RegisterTest() {
		setResizable(false);
		setTitle("Sign Up");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(176, 224, 230));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblRegister = new JLabel("REGISTER");
		lblRegister.setBounds(224, 10, 156, 37);
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setForeground(Color.BLACK);
		lblRegister.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblRegister.setBackground(new Color(30, 144, 255));
		contentPane.add(lblRegister);
		
		lblRegisterLogo = new JLabel("");
		lblRegisterLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisterLogo.setBounds(159, 10, 55, 37);
		lblRegisterLogo.setIcon(new ImageIcon(Register.class.getResource("/picture/icons8-register-64.png")));
		contentPane.add(lblRegisterLogo);
		
		lblUser = new JLabel("");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUser.setIcon(new ImageIcon(getClass().getResource("/picture/icons8-username-48.png")));
		lblUser.setBounds(44, 104, 60, 48);
		contentPane.add(lblUser);
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUser.setColumns(10);
		txtUser.setBorder(new EmptyBorder(0, 0, 0, 4));
		txtUser.setBounds(140, 108, 250, 40);
		contentPane.add(txtUser);
		
		lblPhone = new JLabel("");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPhone.setBounds(47, 200, 55, 48);
		lblPhone.setIcon(new ImageIcon(
				new ImageIcon(getClass().getResource("/picture/phone-icon.png"))
				.getImage().getScaledInstance(60, 48, Image.SCALE_SMOOTH)
				));
		contentPane.add(lblPhone);
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPhone.setColumns(10);
		txtPhone.setBorder(new EmptyBorder(0, 0, 0, 4));
		txtPhone.setBounds(140, 204, 250, 40);
		contentPane.add(txtPhone);
		
		lblNewLabel = new JLabel("User name");
		lblNewLabel.setBounds(140, 80, 72, 18);
		contentPane.add(lblNewLabel);
		
		lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setBounds(140, 176, 98, 18);
		contentPane.add(lblPhoneNumber);
		
		lblPass = new JLabel("");
		lblPass.setHorizontalAlignment(SwingConstants.CENTER);
		lblPass.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPass.setIcon(new ImageIcon(getClass().getResource("/picture/icons8-password-48.png")));
		lblPass.setBounds(50, 298, 48, 48);
		contentPane.add(lblPass);
		
		txtPass = new JPasswordField();
		txtPass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				txtPassKeyTyped(e);
			}
		});
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPass.setEchoChar('*');
		txtPass.setBounds(140, 302, 250, 40);
		contentPane.add(txtPass);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(140, 274, 72, 18);
		contentPane.add(lblPassword);
		
		lblRePass = new JLabel("");
		lblRePass.setHorizontalAlignment(SwingConstants.CENTER);
		lblRePass.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRePass.setBounds(50, 406, 48, 48);
		lblRePass.setIcon(new ImageIcon(
				new ImageIcon(getClass().getResource("/picture/Repassword-icon.png"))
				.getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH)
				));
		contentPane.add(lblRePass);
		
		txtRePass = new JPasswordField();
		txtRePass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtRePass.setEchoChar('*');
		txtRePass.setBounds(140, 410, 250, 40);
		contentPane.add(txtRePass);
		
		lblRePassword = new JLabel("Re Password");
		lblRePassword.setBounds(142, 382, 85, 18);
		
		contentPane.add(lblRePassword);
		
		btnSignUp = new JButton("SignUp");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSignUpActionPerformed(e);
			}
		});
		btnSignUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSignUp.setBorder(null);
		btnSignUp.setBackground(new Color(51, 153, 236));
		btnSignUp.setBounds(140, 475, 120, 30);
		contentPane.add(btnSignUp);
		
		btnSignIn = new JButton("SignIn");
		btnSignIn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSignInActionPerformed(e);
			}
		});
		btnSignIn.setForeground(Color.WHITE);
		btnSignIn.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSignIn.setBorder(null);
		btnSignIn.setBackground(new Color(51, 153, 236));
		btnSignIn.setBounds(270, 475, 120, 30);
		contentPane.add(btnSignIn);
		
		lblText = new JLabel("<html>\r\n<p>Password must have</p>\r\n<p>8 -30 characters</p>\r\n<p>special charater @,#,...</p>\r\n<p>at least 1 upper character</p>\r\n</html>");
		lblText.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblText.setForeground(new Color(255, 0, 0));
		lblText.setVerticalAlignment(SwingConstants.TOP);
		lblText.setBounds(400, 297, 126, 62);
		contentPane.add(lblText);
		
		lblRed = new JLabel("");
		lblRed.setOpaque(true);
		lblRed.setBackground(new Color(255, 0, 0));
		lblRed.setBounds(279, 352, 34, 13);
		contentPane.add(lblRed);
		
		lblYellow = new JLabel("");
		lblYellow.setOpaque(true);
		lblYellow.setBackground(new Color(168, 172, 9));
		lblYellow.setBounds(312, 352, 34, 13);
		contentPane.add(lblYellow);
		
		lblGreen = new JLabel("");
		lblGreen.setOpaque(true);
		lblGreen.setBackground(new Color(0, 155, 0));
		lblGreen.setBounds(346, 352, 34, 13);
		contentPane.add(lblGreen);
		
		lblCheckStrongPass = new JLabel("Weak");
		lblCheckStrongPass.setBounds(400, 352, 45, 13);
		contentPane.add(lblCheckStrongPass);
		
		lblConfirmPass = new JLabel("");
		lblConfirmPass.setBounds(140, 352, 120, 13);
		contentPane.add(lblConfirmPass);
		
		lblCheckPhone = new JLabel("");
		lblCheckPhone.setBounds(140, 254, 140, 13);
		contentPane.add(lblCheckPhone);
	}

	protected void btnSignInActionPerformed(ActionEvent e) {
		var login =  loginTest.getInstance();
		if(!login.isVisible()) {
			login.setVisible(true);
			this.setVisible(false);
			login.setLocationRelativeTo(null);
		}
	}
	protected void btnSignUpActionPerformed(ActionEvent e) {
		// Check validation empty text field
		if(txtUser.getText().isEmpty()||txtPhone.getText().isEmpty()
				||new String(txtPass.getPassword()).isEmpty()
				||new String(txtRePass.getPassword()).isEmpty()) {
			JOptionPane.showMessageDialog(this,"Please fill in the blank");
			return;
		}
		
		var user = new User();
		
		user.setUserName(txtUser.getText());
		
		//Check phone number is digit and 9-13 numbers
		String phoneNumber = txtPhone.getText();
		if(phoneNumber.matches("\\d+")&&
				(txtPhone.getText().length()>9||txtPhone.getText().length()<13)
				) {
//			user.setPhone(txtPhone.getText());
		}else{
			lblCheckPhone.setText("Invalid Phone number");
			lblCheckPhone.setFont(new Font("Tahoma", Font.BOLD, 10));
			lblCheckPhone.setForeground(new Color(255, 0, 0));
			return;
		}

		
		// Check condition to insert password
		String password = new String(txtPass.getPassword());
		if(password.matches(".*[!@#$%^&*()].*") && password.matches(".*[A-Z].*")
				&&(new String(txtPass.getPassword()).length()<8
						||new String(txtPass.getPassword()).length()<30)
				) {
			// insert password
			
				// Check password and re password
				if(password != new String(txtRePass.getPassword())) {
					lblConfirmPass.setText("Wrong Re-enter password");
					lblConfirmPass.setFont(new Font("Tahoma", Font.BOLD, 10));
					lblConfirmPass.setForeground(new Color(255, 0, 0));
					return;
				}else {
					user.setPassword(password);
				}
			
		}else {
			lblText.setFont(new Font("Tahoma", Font.BOLD, 9));
			return;
		}
		
		
		//function register
		var dao = new UserDAO();
		int registerResult =dao.register(user);
		if(registerResult>0) {
			JOptionPane.showMessageDialog(this, "Register successful");
			txtUser.setText("");
			txtPhone.setText("");
			txtPass.setText("");
			txtRePass.setText("");
		}else {
			JOptionPane.showMessageDialog(this, "Username aldready existed");
			return;
		}
	}
	
	protected void txtPassKeyTyped(KeyEvent e) {
		String password = new String(txtPass.getPassword());
		
		if(password.length()<8&&
				!password.contains(".*[!@#$%^&*()].*")&&!password.contains(".*[A-Z].*")) {
			lblYellow.setBackground(new Color(168, 172, 9));
			lblGreen.setBackground(new Color(0, 155, 0));
			lblCheckStrongPass.setText("Weak");
		}
		
		if(password.length()>8
				&&password.matches(".*[!@#$%^&*()].*") && password.matches(".*[A-Z].*")
				) {
			lblYellow.setBackground(Color.YELLOW);
			lblCheckStrongPass.setText("Medium");
		}
		if(password.length()>11
				&&password.matches(".*[!@#$%^&*()].*") && password.matches(".*[A-Z].*")
				) {
			lblGreen.setBackground(Color.GREEN);
			lblCheckStrongPass.setText("Strong");
		}
	}
}
