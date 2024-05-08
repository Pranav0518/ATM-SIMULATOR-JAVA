package atmSimulator;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MainWindow2{

	JFrame MainFrame2;
	JLabel label1;
	String n;
	int tran=0;
	static String z;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow2 window = new MainWindow2(z);
					window.MainFrame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public MainWindow2(String o) {
		n=o;
		initialize();
	}


	private void initialize() {
		MainFrame2 = new JFrame();
		MainFrame2.setBounds(100, 100, 960, 1080);
		MainFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainFrame2.getContentPane().setLayout(null);
		
		label1 = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/atm.jpg")).getImage();
		System.out.println(n);
		JButton btnNewButton = new JButton("Deposit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Deposit2 obj = new Deposit2(n);
				obj.frame_d2.setVisible(true);
				MainFrame2.dispose();
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		btnNewButton.setBounds(163, 382, 144, 36);
		MainFrame2.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Fast Cash");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FastCash2 obj = new FastCash2(n);
				obj.frame_f2.setVisible(true);
				MainFrame2.dispose();
			}
		});
		btnNewButton_1.setBounds(163, 422, 144, 36);
		MainFrame2.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Balance");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Balance2 obj=new Balance2(n);
				obj.frame_b2.setVisible(true);
				MainFrame2.dispose();
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		btnNewButton_1_1_1.setBounds(411, 382, 144, 36);
		MainFrame2.getContentPane().add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Mini Statement");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Scanner scan=new Scanner(System.in);
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","teamosekire");
					String query="Select * from ministatement where Biometric=?";
					PreparedStatement s1= con.prepareStatement(query);
					s1.setString(1, n);
					ResultSet r1=s1.executeQuery();
					while(r1.next())
					{
						tran++;
					}
					MiniStatement2 obj=new MiniStatement2(n,tran);
					obj.frame_m2.setVisible(true);
					MainFrame2.dispose();
					r1.close();
					s1.close();
					scan.close();
					con.close();
				}
				catch(ClassNotFoundException | SQLException e1){
		            System.out.println(e1);
		            JOptionPane.showMessageDialog(null, "Error");
		            }
			
			
			}
		});
		btnNewButton_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		btnNewButton_1_1_1_1.setBounds(411, 422, 144, 36);
		MainFrame2.getContentPane().add(btnNewButton_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_1 = new JButton("Exit");
		btnNewButton_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    JOptionPane.showMessageDialog(null,"Logging Out");
				MainFrame2.dispose();
			}
		});
		btnNewButton_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		btnNewButton_1_1_1_1_1.setBounds(411, 464, 144, 36);
		MainFrame2.getContentPane().add(btnNewButton_1_1_1_1_1);
		label1.setIcon(new ImageIcon(img));
		label1.setBounds(0, 0, 946, 845);
		MainFrame2.getContentPane().add(label1);
	}
	}


