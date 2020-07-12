import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
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
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class CheckMember extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField name;
	private JTextField id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckMember frame = new CheckMember();
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
	public CheckMember() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Central Library");
		lblNewLabel.setBounds(183, 11, 177, 24);
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 18));
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 46, 489, 204);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Show");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
					
					String sql = "select * from member";
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
		btnNewButton.setBounds(74, 261, 89, 23);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Search On The Basis Of Name");
		lblNewLabel_1.setBounds(10, 307, 177, 15);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblNewLabel_1);
		
		name = new JTextField();
		name.setBounds(208, 305, 191, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 33, 514, 2);
		contentPane.add(separator);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
					
					String sql = "select * from member where Member_Name=?";
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
		btnNewButton_1.setBounds(420, 304, 89, 23);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Search On The Basis Of Id");
		lblNewLabel_2.setBounds(10, 350, 157, 15);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblNewLabel_2);
		
		id = new JTextField();
		id.setBounds(208, 348, 191, 20);
		contentPane.add(id);
		id.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
					
					String sql = "select * from member where Member_Id=?";
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
		btnNewButton_2.setBounds(420, 347, 89, 23);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnNewButton_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 383, 514, 2);
		contentPane.add(separator_1);
		
		JButton btnNewButton_3 = new JButton("Exit");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main obj = new Main();
				obj.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3.setBounds(228, 261, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Export");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcelExporter exp = new ExcelExporter();
				try
				{
					exp.exportTable(table, new File("C:\\Users\\Sourav\\Desktop\\eclipse_project\\excelsheet\\member.xls"));
				}
				catch(Exception x)
				{
					JOptionPane.showMessageDialog(null, x);
				}
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_4.setBounds(373, 263, 89, 23);
		contentPane.add(btnNewButton_4);
	}
}
