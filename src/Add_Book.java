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
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Add_Book extends JFrame {

	private JPanel contentPane;
	private JTextField bookname;
	private JTextField bookid;
	private JTextField author;
	private JTextField subject;
	private JTextField stock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Book frame = new Add_Book();
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
	public Add_Book() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Central Library");
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 18));
		lblNewLabel.setBounds(135, 11, 173, 38);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 57, 414, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Book Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(26, 82, 90, 30);
		contentPane.add(lblNewLabel_1);
		
		bookname = new JTextField();
		bookname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					bookid.requestFocus();
				}
			}
		});
		bookname.setBounds(154, 89, 259, 20);
		contentPane.add(bookname);
		bookname.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Book Id");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(26, 134, 90, 30);
		contentPane.add(lblNewLabel_2);
		
		bookid = new JTextField();
		bookid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					author.requestFocus();
				}
			}
		});
		bookid.setBounds(154, 141, 259, 20);
		contentPane.add(bookid);
		bookid.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Author");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(26, 190, 90, 30);
		contentPane.add(lblNewLabel_3);
		
		author = new JTextField();
		author.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					subject.requestFocus();
				}
			}
		});
		author.setBounds(154, 197, 259, 20);
		contentPane.add(author);
		author.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Subject");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(26, 255, 90, 30);
		contentPane.add(lblNewLabel_4);
		
		subject = new JTextField();
		subject.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					stock.requestFocus();
				}
			}
		});
		subject.setBounds(154, 262, 259, 20);
		contentPane.add(subject);
		subject.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Stock");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(26, 317, 90, 30);
		contentPane.add(lblNewLabel_5);
		
		stock = new JTextField();
		stock.setBounds(154, 324, 259, 20);
		contentPane.add(stock);
		stock.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(28, 375, 385, 2);
		contentPane.add(separator_1);
		
		JButton btnNewButton = new JButton("ADD BOOK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
					String sql = "insert into book(Book_Name,Author,Book_Id,Stock,Subject) values (?,?,?,?,?)";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1,bookname.getText());
					pst.setString(2,author.getText());
					pst.setString(3,bookid.getText());
					pst.setString(4,stock.getText());
					pst.setString(5,subject.getText());
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
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(54, 388, 127, 38);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CANCLE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main obj = new Main();
				obj.setVisible(true);
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(228, 388, 127, 38);
		contentPane.add(btnNewButton_1);
	}

}
