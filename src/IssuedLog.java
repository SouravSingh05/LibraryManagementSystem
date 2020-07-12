import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import com.mysql.jdbc.ResultSet;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class IssuedLog extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField memberid;
	private JTextField bookid;
	private JTextField subject;
	private JTextField author;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IssuedLog frame = new IssuedLog();
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
	public IssuedLog() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Central Library");
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 18));
		lblNewLabel.setBounds(212, 11, 158, 24);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 52, 564, 247);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Show");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
					
					String sql = "select * from lendbook";
					PreparedStatement pst = con.prepareStatement(sql);
					ResultSet rs = (ResultSet) pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
						
					}
				catch(Exception x)
				{
					System.out.println(x);
			    }
			}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(76, 310, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main obj = new Main();
				obj.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(227, 310, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Search On The Basis Of Member Id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 355, 210, 15);
		contentPane.add(lblNewLabel_1);
		
		memberid = new JTextField();
		memberid.setBounds(251, 353, 156, 20);
		contentPane.add(memberid);
		memberid.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
					
					String sql = "select * from lendbook where Member_Id=?";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1,memberid.getText());
					ResultSet rs = (ResultSet) pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
						
					}
				catch(Exception x)
				{
					System.out.println(x);
			    }
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(435, 352, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("Search On The Basis Of Book Id");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 386, 192, 15);
		contentPane.add(lblNewLabel_2);
		
		bookid = new JTextField();
		bookid.setBounds(251, 384, 156, 20);
		contentPane.add(bookid);
		bookid.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Search");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
					
					String sql = "select * from lendbook where Book_Id=?";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1,bookid.getText());
					ResultSet rs = (ResultSet) pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
						
					}
				catch(Exception x)
				{
					System.out.println(x);
			    }
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.setBounds(435, 383, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_3 = new JLabel("Search On The Basis Of Subject");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 418, 191, 15);
		contentPane.add(lblNewLabel_3);
		
		subject = new JTextField();
		subject.setBounds(251, 415, 156, 20);
		contentPane.add(subject);
		subject.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Search");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
					
					String sql = "select lendbook.Member_Id,lendbook.Member_Name,book.Book_Id,book.Book_Name,lendbook.Date_Of_Issue,lendbook.Date_Of_Return from lendbook inner join book on book.Book_Id=lendbook.Book_Id where Subject=?";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1,subject.getText());
					ResultSet rs = (ResultSet) pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
						
					}
				catch(Exception x)
				{
					System.out.println(x);
			    }
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_4.setBounds(435, 414, 89, 23);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_4 = new JLabel("Search On The Basis Of Author");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(10, 444, 188, 15);
		contentPane.add(lblNewLabel_4);
		
		author = new JTextField();
		author.setBounds(251, 442, 156, 20);
		contentPane.add(author);
		author.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("Search");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
					
					String sql = "select lendbook.Member_Id,lendbook.Member_Name,book.Book_Id,book.Book_Name,lendbook.Date_Of_Issue,lendbook.Date_Of_Return from lendbook inner join book on book.Book_Id=lendbook.Book_Id where Author=?";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1,author.getText());
					ResultSet rs = (ResultSet) pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
						
					}
				catch(Exception x)
				{
					System.out.println(x);
			    }
			}
			
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_5.setBounds(435, 441, 89, 23);
		contentPane.add(btnNewButton_5);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 33, 564, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 478, 564, 2);
		contentPane.add(separator_1);
		
		JButton btnNewButton_6 = new JButton("Export");
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcelExporter exp = new ExcelExporter();
				try
				{
					exp.exportTable(table, new File("C:\\Users\\Sourav\\Desktop\\eclipse_project\\excelsheet\\issued.xls"));
				}
				catch(Exception x)
				{
					JOptionPane.showMessageDialog(null, x);
				}
			}
		});
		btnNewButton_6.setBounds(394, 310, 89, 23);
		contentPane.add(btnNewButton_6);
	}
}
