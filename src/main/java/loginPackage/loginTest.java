package loginPackage;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.border.MatteBorder;

import home.HomePage;
import home.HomeTest;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class loginTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel logoMedicine;
	private JLabel lblPharamacySystem;
	private JLabel ImageLogo;
	private JLabel lblUser;
	private JLabel lblPass;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnLogin;
	private JLabel lblForget;
	private JLabel lblSignUp;
	private JLabel lblNewLabel;
	private JLabel lblPassword;
	private static loginTest instance;
	public static loginTest getInstance() {
		if(instance == null) {
			instance = new loginTest();
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
					loginTest frame = new loginTest();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public loginTest() {
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(176, 224, 230));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		logoMedicine = new JLabel("");
		logoMedicine.setBounds(70, 10, 64, 64);
		logoMedicine.setIcon(new ImageIcon(Login.class.getResource("/picture/icons8-pharmacy-shop-64.png")));
		contentPane.add(logoMedicine);
		
		lblPharamacySystem = new JLabel("PHARAMACY SYSTEM");
		lblPharamacySystem.setBounds(139, 23, 326, 37);
		lblPharamacySystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblPharamacySystem.setForeground(Color.BLACK);
		lblPharamacySystem.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(lblPharamacySystem);
		
		ImageLogo = new JLabel("");
		ImageLogo.setOpaque(true);
		
		ImageLogo.setBounds(121, 84, 292, 221);
		ImageLogo.setIcon(new ImageIcon(
				new ImageIcon(getClass().getResource("/picture/imageMed.png"))
				.getImage().getScaledInstance(292, 221, Image.SCALE_SMOOTH)
				));
		contentPane.add(ImageLogo);
		
		lblUser = new JLabel("");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUser.setBounds(70, 339, 60, 48);
		lblUser.setIcon(new ImageIcon(getClass().getResource("/picture/icons8-username-48.png")));
		contentPane.add(lblUser);
		
		lblPass = new JLabel("");
		lblPass.setHorizontalAlignment(SwingConstants.CENTER);
		lblPass.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPass.setIcon(new ImageIcon(getClass().getResource("/picture/icons8-password-48.png")));
		lblPass.setBounds(76, 420, 48, 48);
		contentPane.add(lblPass);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBorder(new EmptyBorder(0, 0, 0, 4));
		textField.setBounds(161, 343, 250, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setEchoChar('*');
		passwordField.setBounds(161, 424, 250, 40);
		contentPane.add(passwordField);
		
		btnLogin = new JButton("SignIn");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoginActionPerformed(e);
			}
		});
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBorder(null);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnLogin.setBounds(215, 480, 120, 30);
		btnLogin.setBackground(new Color(51, 153, 236));
		contentPane.add(btnLogin);
		
		lblForget = new JLabel("Forget Password ?");
		lblForget.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblForgetMouseClicked(e);
			}
		});
		lblForget.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblForget.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblForget.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblForget.setBounds(161, 526, 122, 20);
		contentPane.add(lblForget);
		
		lblSignUp = new JLabel("Sign up");
		lblSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblSignUpMouseClicked(e);
			}
		});
		lblSignUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSignUp.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblSignUp.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblSignUp.setBounds(291, 526, 50, 20);
		contentPane.add(lblSignUp);
		
		lblNewLabel = new JLabel("User name");
		lblNewLabel.setBounds(161, 315, 72, 18);
		contentPane.add(lblNewLabel);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(161, 396, 72, 18);
		contentPane.add(lblPassword);
	}
	protected void btnLoginActionPerformed(ActionEvent e) {
		var home = HomeTest.getInstance();
		if(!home.isVisible()) {
				home.setVisible(true);
				this.setVisible(false);
				home.setLocationRelativeTo(null);
		}
	}
	protected void lblForgetMouseClicked(MouseEvent e) {
		var forget = ForgetTest.getInstance();
		if(!forget.isVisible()) {
			forget.setVisible(true);
			this.setVisible(false);
			forget.setLocationRelativeTo(null);
		}
	}
	protected void lblSignUpMouseClicked(MouseEvent e) {
		var register = RegisterTest.getInstance();
		if(!register.isVisible()) {
			register.setVisible(true);
			this.setVisible(false);
			register.setLocationRelativeTo(null);
		}
	}
}
