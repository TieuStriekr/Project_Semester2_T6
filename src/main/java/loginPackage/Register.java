package loginPackage;

import java.awt.Color;
import java.awt.Cursor;
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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblRegister;
	private JLabel lblNewLabel;
	private JLabel user;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JButton btnSign;
	private JTextField txtUser;
	private JTextField txtPhone;
	private JPasswordField txtPass;
	private static Register instance;
	private JButton btnSignIn;
	public static Register getInstance() {
		if(instance == null) {
			instance = new Register();
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
					Register frame = new Register();
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
	public Register() {
		setTitle("Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 794, 429);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		user = new JLabel("User Name");
		user.setForeground(Color.BLACK);
		user.setIcon(null);
		user.setHorizontalAlignment(SwingConstants.CENTER);
		user.setFont(new Font("Tahoma", Font.BOLD, 19));
		user.setBounds(43, 101, 116, 46);
		contentPane.add(user);
		
		lblNewLabel_2 = new JLabel("Number Phone");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_2.setBounds(43, 185, 156, 33);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("New Password");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setIcon(null);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_3.setBounds(43, 259, 156, 46);
		contentPane.add(lblNewLabel_3);
		
		btnSign = new JButton("SIGN UP");
		btnSign.setBorder(null);
		btnSign.setBackground(new Color(100, 149, 237));
		btnSign.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSign.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		btnSign.setForeground(new Color(255, 255, 255));
		btnSign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSignActionPerformed(e);
			}
		});
		btnSign.setBounds(275, 337, 116, 23);
		contentPane.add(btnSign);
		
		btnSignIn = new JButton("SIGN IN");
		btnSignIn.setBorder(null);
		btnSignIn.setBackground(new Color(100, 149, 237));
		btnSignIn.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSignIn.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		btnSignIn.setForeground(new Color(255, 255, 255));
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSignInActionPerformed(e);
			}
		});
		btnSignIn.setBounds(461, 337, 116, 23);
		contentPane.add(btnSignIn);
		
		lblRegister = new JLabel("REGISTER");
		lblRegister.setBackground(new Color(30, 144, 255));
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setForeground(Color.BLACK);
		lblRegister.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblRegister.setBounds(209, 23, 445, 73);
		contentPane.add(lblRegister);
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtUser.setColumns(10);
		txtUser.setBounds(209, 97, 445, 50);
		contentPane.add(txtUser);
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPhone.setColumns(10);
		txtPhone.setBounds(209, 177, 445, 50);
		contentPane.add(txtPhone);
		
		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPass.setBounds(209, 259, 445, 48);
		contentPane.add(txtPass);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Register.class.getResource("/picture/icons8-register-64.png")));
		lblNewLabel.setBounds(275, 35, 71, 50);
		contentPane.add(lblNewLabel);	
	}

	protected void btnSignActionPerformed(ActionEvent e) {
		if(txtUser.getText().isEmpty()||txtPhone.getText().isEmpty()||new String(txtPass.getPassword()).isEmpty()) {
			JOptionPane.showMessageDialog(this,"Please fill in the blank");
			return;
		}
		if(new String(txtPass.getPassword()).length()<8||new String(txtPass.getPassword()).length()>30) {
			JOptionPane.showMessageDialog(this, "password at least 8 to 30 characters");
			return;
		}
		if(txtPhone.getText().length()<8||txtPhone.getText().length()>12) {
			JOptionPane.showMessageDialog(this, "phone number must 8 to 12 numbers");
			return;
		}
		var user = new User();
		user.setUserName(txtUser.getText());
		user.setPhone(Integer.parseInt(txtPhone.getText()));
		user.setPassword(new String(txtPass.getPassword()));
		var dao = new UserDAO();
		int registerResult =dao.register(user);
		
		if(registerResult>0) {
			JOptionPane.showMessageDialog(this, "Register successful");
			var login =  Login.getInstance();
			if(!login.isVisible()) {
				login.setVisible(true);
				this.setVisible(false);
			}
			txtUser.setText("");
			txtPhone.setText("");
			txtPass.setText("");
		}else {
			JOptionPane.showMessageDialog(this, "Username aldready existed");
		}	
	}
	protected void btnSignInActionPerformed(ActionEvent e) {
		var login =  Login.getInstance();
		if(!login.isVisible()) {
			login.setVisible(true);
			this.setVisible(false);
			login.setLocationRelativeTo(null);
		}
	}
}
