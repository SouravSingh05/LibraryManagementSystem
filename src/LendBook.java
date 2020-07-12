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

import com.mysql.jdbc.ResultSet;
import com.toedter.calendar.JDateChooser;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LendBook extends JFrame {

	protected static final String Declare = null;
	private JPanel contentPane;
	private JTextField memberid;
	private JTextField membername;
	private JTextField bookid;
	private JTextField bookname;
	private JTextField stock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LendBook frame = new LendBook();
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
	public LendBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Central Library");
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 18));
		lblNewLabel.setBounds(123, 11, 202, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Member Id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(23, 58, 92, 28);
		contentPane.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(23, 37, 401, 2);
		contentPane.add(separator);
		
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
						}
						}
					catch(Exception x)
					{
						System.out.println(x);
					}
					bookid.requestFocus();
				}
			}
			
		});
		memberid.setBounds(155, 64, 250, 20);
		contentPane.add(memberid);
		memberid.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Member Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(23, 97, 109, 28);
		contentPane.add(lblNewLabel_2);
		
		membername = new JTextField();
		membername.setBounds(155, 103, 250, 20);
		contentPane.add(membername);
		membername.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Book Id");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(23, 148, 109, 14);
		contentPane.add(lblNewLabel_3);
		
		bookid = new JTextField();
		bookid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					try {
					
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
						
						String sql = "select * from book where Book_Id=?";
						PreparedStatement pst = con.prepareStatement(sql);
						pst.setString(1,bookid.getText());
						ResultSet rs = (ResultSet) pst.executeQuery();
						while(rs.next())
						{
							bookname.setText(rs.getString("Book_Name"));
							stock.setText(rs.getString("Stock"));
						}
						}
					catch(Exception x)
					{
						System.out.println(x);
					}
					if(Integer.parseInt(stock.getText())==0)
					{
						JOptionPane.showMessageDialog(null,"Book is unavailable right now!!!");
						dispose();
						Main obj = new Main();
						obj.setVisible(true);
					}
					
				}
			}
		});
		bookid.setBounds(155, 147, 250, 20);
		contentPane.add(bookid);
		bookid.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Book Name");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(23, 192, 109, 14);
		contentPane.add(lblNewLabel_4);
		
		bookname = new JTextField();
		bookname.setBounds(155, 191, 250, 20);
		contentPane.add(bookname);
		bookname.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Date Of Issue");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(23, 270, 92, 14);
		contentPane.add(lblNewLabel_5);
		JDateChooser dateofissue = new JDateChooser();
		dateofissue.setBounds(155, 264, 250, 20);
		contentPane.add(dateofissue);
		JDateChooser dateofreturn = new JDateChooser();
		dateofreturn.setBounds(155, 310, 250, 20);
		contentPane.add(dateofreturn);
		JButton btnNewButton = new JButton("Lend");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Date date = (Date) dateofissue. getDate();
					String strDate = DateFormat. getDateInstance(). format(date);
					Date date1 = (Date) dateofreturn. getDate();
					String strDate1 = DateFormat. getDateInstance(). format(date1);
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
					String sql = "insert into lendbook(Member_Id,Member_Name,Book_Id,Book_Name,Date_Of_Issue,Date_Of_Return) values (?,?,?,?,?,?)";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1,memberid.getText());
					pst.setString(2,membername.getText());
					pst.setString(3,bookid.getText());
					pst.setString(4,bookname.getText());
					pst.setString(5,strDate);
					pst.setString(6,strDate1);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Book Issued");
					con.close();
					
					}
				catch(Exception x)
				{
					System.out.println(x);
				}
				try {
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
						int c = b-1;
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
		btnNewButton.setBounds(107, 352, 89, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancle");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main obj = new Main();
				obj.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(248, 352, 89, 35);
		contentPane.add(btnNewButton_1);
	
		
		JLabel lblNewLabel_6 = new JLabel("Date Of Return");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(23, 316, 109, 14);
		contentPane.add(lblNewLabel_6);
		
		
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(23, 396, 401, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_7 = new JLabel("Stock");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(23, 228, 58, 14);
		contentPane.add(lblNewLabel_7);
		
		stock = new JTextField();
		stock.setBounds(155, 222, 250, 20);
		contentPane.add(stock);
		stock.setColumns(10);
	}
}
