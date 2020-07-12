import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;


import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class Library_Login {

	private JFrame frame1;
	private JTextField user;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Library_Login window = new Library_Login();
					window.frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Library_Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame1 = new JFrame();
		frame1.setBounds(100, 100, 450, 300);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Central Library");
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 18));
		lblNewLabel.setBounds(127, 11, 158, 29);
		frame1.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(22, 59, 89, 21);
		frame1.getContentPane().add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(22, 38, 402, 2);
		frame1.getContentPane().add(separator);
		
		user = new JTextField();
		user.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					password.requestFocus();
				}
			}
			
		});
		user.setBounds(150, 61, 225, 20);
		frame1.getContentPane().add(user);
		user.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(22, 100, 89, 21);
		frame1.getContentPane().add(lblNewLabel_2);
		
		password = new JPasswordField();
		password.setBounds(150, 102, 225, 20);
		frame1.getContentPane().add(password);
		
		JCheckBox cb = new JCheckBox("Show Password");
		cb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cb.isSelected())
				{
					password.setEchoChar((char)0);
				}
				else
				{
					password.setEchoChar('*');
				}
			}
		});
		cb.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cb.setBounds(149, 126, 124, 23);
		frame1.getContentPane().add(cb);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 186, 414, 2);
		frame1.getContentPane().add(separator_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
					String sql = "select * from login where UserId=? and Password=?";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1, user.getText());
					pst.setString(2, password.getText());
					 ResultSet rs = pst.executeQuery();
					if(rs.next())
					{
						frame1.dispose();
						Main obj = new Main();
						obj.setVisible(true);
					
						
					}
					else
					{
						JOptionPane.showMessageDialog(btnNewButton,"login unsuccessful");
					}
					con.close();
					}
				catch(Exception x)
				{
					System.out.print(x);
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(40, 195, 89, 40);
		frame1.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.setText(null);
				password.setText(null);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(173, 195, 89, 40);
		frame1.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(314, 195, 89, 40);
		frame1.getContentPane().add(btnNewButton_2);
	}
}
