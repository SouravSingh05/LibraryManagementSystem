import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Member extends JFrame {

	private JPanel contentPane;
	private JTextField membername;
	private JTextField memberid;
	private JTextField contact;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Member frame = new Member();
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
	public Member() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Central Library");
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 18));
		lblNewLabel.setBounds(136, 11, 171, 28);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 37, 414, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Member Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(20, 50, 116, 28);
		contentPane.add(lblNewLabel_1);
		
		membername = new JTextField();
		membername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					memberid.requestFocus();
				}
			}
			
		});
		membername.setBounds(146, 55, 253, 20);
		contentPane.add(membername);
		membername.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Member Id");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(20, 101, 99, 28);
		contentPane.add(lblNewLabel_2);
		
		memberid = new JTextField();
		memberid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					contact.requestFocus();
				}
			}
		});
		memberid.setBounds(146, 107, 253, 20);
		contentPane.add(memberid);
		memberid.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Contact");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(20, 152, 83, 28);
		contentPane.add(lblNewLabel_3);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 191, 414, 2);
		contentPane.add(separator_1);
		
		contact = new JTextField();
		contact.setBounds(146, 158, 253, 20);
		contentPane.add(contact);
		contact.setColumns(10);
		
		JButton btnNewButton = new JButton("ADD MEMBER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
					String sql = "insert into Member(Member_Name,Member_Id,Contact_Number) values (?,?,?)";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1,membername.getText());
					pst.setString(2,memberid.getText());
					pst.setString(3,contact.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "saved");
					dispose();
					Main obj = new Main();
					obj.setVisible(true);
					con.close();
					}
				catch(Exception x)
				{
					JOptionPane.showMessageDialog(null, "PLEASE CHECK THE FIELDS AGAIN");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(70, 203, 116, 46);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CANCLE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main obj = new Main();
				obj.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(245, 204, 126, 45);
		contentPane.add(btnNewButton_1);
	}
}
