import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Central Library");
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 18));
		lblNewLabel.setBounds(137, 11, 170, 30);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 39, 414, 2);
		contentPane.add(separator);
		
		JButton btnNewButton = new JButton("ADD BOOK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Add_Book obj = new Add_Book();
				obj.setVisible(true);
				
			}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(50, 52, 127, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CHECK BOOK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckBook obj = new CheckBook();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(247, 52, 127, 39);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("ADD MEMBER");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Member obj = new Member();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(50, 102, 127, 39);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("CHECK MEMBER");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CheckMember obj = new CheckMember();
				obj.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_3.setBounds(247, 102, 127, 39);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("ISSUE BOOK");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LendBook obj = new LendBook();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_4.setBounds(50, 152, 127, 39);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("RETURN BOOK");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				RecieveBook obj = new RecieveBook();
				obj.setVisible(true);
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_5.setBounds(247, 152, 127, 39);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("EXIT");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_6.setBounds(168, 270, 89, 39);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("ISSUED LOG");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				IssuedLog obj = new IssuedLog();
				obj.setVisible(true);
			}
		});
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_7.setBounds(50, 202, 127, 39);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("DELETE MEMBER");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				DeleteMember obj = new DeleteMember();
				obj.setVisible(true);
			}
		});
		btnNewButton_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_8.setBounds(247, 202, 127, 39);
		contentPane.add(btnNewButton_8);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 336, 414, 2);
		contentPane.add(separator_1);
	}
}
