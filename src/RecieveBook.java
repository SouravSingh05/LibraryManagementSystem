import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RecieveBook extends JFrame {

	private JPanel contentPane;
	private JTextField memberid;
	private JTextField bookid;
	private JTextField membername;
	private JTextField bookname;
	private JTextField dateofissue;
	private JTextField dateofreturn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecieveBook frame = new RecieveBook();
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
	public RecieveBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Central Library");
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 18));
		lblNewLabel.setBounds(136, 11, 172, 24);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 33, 414, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Member Id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(20, 47, 82, 14);
		contentPane.add(lblNewLabel_1);
		
		memberid = new JTextField();
		memberid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					bookid.requestFocus();
				}
			}
		});
		memberid.setBounds(146, 46, 251, 20);
		contentPane.add(memberid);
		memberid.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Book Id");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(20, 83, 82, 14);
		contentPane.add(lblNewLabel_2);
		
		bookid = new JTextField();
		bookid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					try {
					
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
						
						String sql = "select * from lendbook where Member_Id=? and Book_Id=?";
						PreparedStatement pst = con.prepareStatement(sql);
						pst.setString(1,memberid.getText());
						pst.setString(2,bookid.getText());
						ResultSet rs = (ResultSet) pst.executeQuery();
						while(rs.next())
						{
							membername.setText(rs.getString("Member_Name"));
							bookname.setText(rs.getString("Book_Name"));
							dateofissue.setText(rs.getString("Date_Of_Issue"));
							dateofreturn.setText(rs.getString("Date_Of_Return"));
						}
						}
					catch(Exception x)
					{
						System.out.println(x);
					}
					
				}
			}
		});
		bookid.setBounds(145, 82, 252, 20);
		contentPane.add(bookid);
		bookid.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Member Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(20, 124, 112, 14);
		contentPane.add(lblNewLabel_3);
		
		membername = new JTextField();
		membername.setBounds(146, 123, 251, 20);
		contentPane.add(membername);
		membername.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Book Name");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(20, 166, 103, 14);
		contentPane.add(lblNewLabel_4);
		
		bookname = new JTextField();
		bookname.setBounds(146, 165, 251, 20);
		contentPane.add(bookname);
		bookname.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Date Of Issue");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(20, 207, 112, 14);
		contentPane.add(lblNewLabel_5);
		
		dateofissue = new JTextField();
		dateofissue.setBounds(146, 206, 251, 20);
		contentPane.add(dateofissue);
		dateofissue.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Date Of Return");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(20, 250, 112, 14);
		contentPane.add(lblNewLabel_6);
		
		dateofreturn = new JTextField();
		dateofreturn.setBounds(146, 249, 251, 20);
		contentPane.add(dateofreturn);
		dateofreturn.setColumns(10);
		
		JButton btnNewButton = new JButton("Return");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
					
					String sql = "delete from lendbook where Member_Id=? and Book_Id=?";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1,memberid.getText());
					pst.setString(2,bookid.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "Returned");
					
					}
				catch(Exception x)
				{
					System.out.println(x);
			    }
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
					String sql1 = "select * from book where Book_Id=?";
					PreparedStatement pst1 = con.prepareStatement(sql1);
					pst1.setString(1, bookid.getText());
					ResultSet rs = (ResultSet) pst1.executeQuery();
					while(rs.next())
					{
						String a = rs.getString("Stock");
						int b = Integer.parseInt(a);
						int c = b+1;
						String d = String.valueOf(c);
						String sql2 = "update book set Stock=? where Book_Id=?";
						PreparedStatement pst2 = con.prepareStatement(sql2);
						pst2.setString(1,d);
						pst2.setString(2,bookid.getText());
						pst2.execute();
						dispose();
						Main obj = new Main();
						obj.setVisible(true);
					}
					
				}
				catch(Exception x)
				{
					System.out.println(x);
				}
				}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(89, 288, 112, 33);
		contentPane.add(btnNewButton);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 332, 414, 2);
		contentPane.add(separator_1);
		
		JButton btnNewButton_1 = new JButton("Cancle");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main obj  = new Main();
				obj.setVisible(true);
			}
			
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(223, 290, 103, 33);
		contentPane.add(btnNewButton_1);
	}
}
