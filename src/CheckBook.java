import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class CheckBook extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField name;
	private JTextField id;
	private JTextField author;
	private JTextField subject;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckBook frame = new CheckBook();
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
	public CheckBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Central Library");
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 18));
		lblNewLabel.setBounds(187, 11, 158, 24);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 33, 514, 2);
		contentPane.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 514, 256);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Show");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
					
					String sql = "select * from book";
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
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(83, 313, 89, 23);
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
		btnNewButton_1.setBounds(223, 313, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Search On The Basis Of Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 357, 177, 15);
		contentPane.add(lblNewLabel_1);
		
		name = new JTextField();
		name.setBounds(210, 355, 214, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
					
					String sql = "select * from book where Book_Name=?";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1,name.getText());
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
		btnNewButton_2.setBounds(434, 354, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("Search On The Basis Of Id");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 393, 157, 15);
		contentPane.add(lblNewLabel_2);
		
		id = new JTextField();
		id.setBounds(210, 391, 214, 20);
		contentPane.add(id);
		id.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Search");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
					
					String sql = "select * from book where Book_Id=?";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1,id.getText());
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
		btnNewButton_3.setBounds(434, 390, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_3 = new JLabel("Search On The Basis Of Author");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 428, 188, 15);
		contentPane.add(lblNewLabel_3);
		
		author = new JTextField();
		author.setBounds(210, 426, 214, 20);
		contentPane.add(author);
		author.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Search");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
					
					String sql = "select * from book where Author=?";
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
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_4.setBounds(434, 424, 89, 23);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_4 = new JLabel("Search On The Basis Of Subject");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(10, 465, 191, 15);
		contentPane.add(lblNewLabel_4);
		
		subject = new JTextField();
		subject.setBounds(210, 463, 214, 20);
		contentPane.add(subject);
		subject.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("Search");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
					
					String sql = "select * from book where Subject=?";
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
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_5.setBounds(434, 462, 89, 23);
		contentPane.add(btnNewButton_5);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 510, 514, 2);
		contentPane.add(separator_1);
		
		JButton btnNewButton_6 = new JButton("Export");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcelExporter exp = new ExcelExporter();
				try
				{
					exp.exportTable(table, new File("C:\\Users\\Sourav\\Desktop\\eclipse_project\\excelsheet\\book.xls"));
				}
				catch(Exception x)
				{
					JOptionPane.showMessageDialog(null, x);
				}
			}
		});
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_6.setBounds(357, 313, 89, 23);
		contentPane.add(btnNewButton_6);
	}

}
