package atmSimulator;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Mainwindow1{

	JFrame MainFrame;
	JLabel label1;
	String n;
	int tran=0;
	static String y;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainwindow1 window = new Mainwindow1(y);
					window.MainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



	public Mainwindow1(	String o) {
		n=o;
		initialize();
	}


	private void initialize() {
		MainFrame = new JFrame();
		MainFrame.setBounds(100, 100, 960, 1080);
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainFrame.getContentPane().setLayout(null);
		
		label1 = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/atm.jpg")).getImage();
		JButton btnNewButton = new JButton("Deposit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Deposit1 obj = new Deposit1(n);
				obj.frame_d.setVisible(true);
				MainFrame.dispose();
				tran++;
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		btnNewButton.setBounds(163, 382, 144, 36);
		MainFrame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Fast Cash");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FastCash1 obj = new FastCash1(n);
				obj.frame_f.setVisible(true);
				MainFrame.dispose();
				tran++;
			}
		});
		btnNewButton_1.setBounds(163, 422, 144, 36);
		MainFrame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Pinchange");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PinChange1 obj= new PinChange1(n);
				obj.frame_p.setVisible(true);
				MainFrame.dispose();
				
			}
		});
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		btnNewButton_1_1.setBounds(163, 464, 144, 36);
		MainFrame.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Cash Withdrawl");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CashWithdrawl1 obj=new CashWithdrawl1(n);
				obj.frame_c.setVisible(true);
				MainFrame.dispose();
				tran++;
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		btnNewButton_1_1_1.setBounds(411, 382, 144, 36);
		MainFrame.getContentPane().add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Mini Statement");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Scanner scan=new Scanner(System.in);
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","teamosekire");
					String query="Select * from ministatement where card_no=?";
					PreparedStatement s1= con.prepareStatement(query);
					s1.setString(1, n);
					ResultSet r1=s1.executeQuery();
					while(r1.next())
					{
						tran++;
					}
					MiniStatement1 obj=new MiniStatement1(n,tran);
					obj.frame_m.setVisible(true);
					MainFrame.dispose();
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
		MainFrame.getContentPane().add(btnNewButton_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_1 = new JButton("Balance");
		btnNewButton_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Balance1 obj=new Balance1(n);
				obj.frame_b.setVisible(true);
				MainFrame.dispose();
			}
		});
		btnNewButton_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		btnNewButton_1_1_1_1_1.setBounds(411, 464, 144, 36);
		MainFrame.getContentPane().add(btnNewButton_1_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_2 = new JButton("Exit");
		btnNewButton_1_1_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Logging out..");
				MainFrame.dispose();
			}
		});
		btnNewButton_1_1_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		btnNewButton_1_1_1_1_2.setBounds(411, 504, 144, 36);
		MainFrame.getContentPane().add(btnNewButton_1_1_1_1_2);
		label1.setIcon(new ImageIcon(img));
		label1.setBounds(0, 0, 946, 845);
		MainFrame.getContentPane().add(label1);
	}

}
