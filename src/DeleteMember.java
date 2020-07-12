import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.ResultSet;

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

public class DeleteMember extends JFrame {

	private JPanel contentPane;
	private JTextField memberid;
	private JTextField membername;
	private JTextField contact;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteMember frame = new DeleteMember();
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
	public DeleteMember() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Central Library");
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 18));
		lblNewLabel.setBounds(131, 11, 158, 24);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 36, 414, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Member Id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(20, 49, 76, 17);
		contentPane.add(lblNewLabel_1);
		
		memberid = new JTextField();
		memberid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					try {
					
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
						
						String sql = "select * from member where Member_Id=?";
						PreparedStatement pst = con.prepareStatement(sql);
						pst.setString(1,memberid.getText());
						ResultSet rs = (ResultSet) pst.executeQuery();
						while(rs.next())
						{
							membername.setText(rs.getString("Member_Name"));
							contact.setText(rs.getString("Contact_Number"));
						}
						}
					catch(Exception x)
					{
						System.out.println(x);
					}
					}
			}
		});
		memberid.setBounds(141, 46, 253, 20);
		contentPane.add(memberid);
		memberid.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Member Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(20, 88, 100, 17);
		contentPane.add(lblNewLabel_2);
		
		membername = new JTextField();
		membername.setBounds(141, 88, 253, 20);
		contentPane.add(membername);
		membername.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Contact");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(20, 130, 76, 17);
		contentPane.add(lblNewLabel_3);
		
		contact = new JTextField();
		contact.setBounds(141, 130, 253, 20);
		contentPane.add(contact);
		contact.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
					
					String sql = "delete from member where Member_Id=?";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1,memberid.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null,"Deleted!!!");
					dispose();
					Main obj = new Main();
					obj.setVisible(true);
				}
				catch(Exception x)
				{
					System.out.println(x);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(98, 173, 89, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main obj = new Main();
				obj.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(226, 170, 89, 43);
		contentPane.add(btnNewButton_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 233, 414, 2);
		contentPane.add(separator_1);
	}

}
