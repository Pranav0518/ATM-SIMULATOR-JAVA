package atmSimulator;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.Instant;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class FastCash1 {

	 JFrame frame_f;
     int amount,amt;
     String n,time,dup;
     Instant t1;
     static String z;
     JLabel label_1;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FastCash1 window = new FastCash1(z);
					window.frame_f.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public FastCash1(String o) {
		n=o;
		initialize();
	}

	
	private void initialize() {
		frame_f = new JFrame();
		frame_f.setBounds(100, 100, 960, 1080);
		frame_f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_f.getContentPane().setLayout(null);
		
		label_1 = new JLabel("");
	    Image img= new ImageIcon(this.getClass().getResource("/atm.jpg")).getImage();
	    JButton btnNewButton = new JButton("Rs.500");
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		try {
	    			Class.forName("com.mysql.cj.jdbc.Driver");
					Scanner scan=new Scanner(System.in);
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","teamosekire");
					
					String query="Select * from details where card_no=?";
					PreparedStatement s1= con.prepareStatement(query);
					s1.setString(1, n);
					ResultSet rs=s1.executeQuery();
					amount=500;
					
					if(rs.next()) {
						if(amount<rs.getInt("Balance")) {
						amt=rs.getInt("Balance");
						amt-=amount;
						String query2="Update details set Balance= ? where card_no= ?";
						PreparedStatement s2= con.prepareStatement(query2);
					    s2.setInt(1,amt);
					    s2.setString(2,n);
					    s2.executeUpdate();
					    s2.close();
					    t1=java.time.Clock.systemUTC().instant();
						time=t1.toString();
						dup=rs.getString("Biometrics");
						String mini="insert into ministatement values(?,?,?,?,?)";
						PreparedStatement s3= con.prepareStatement(mini);
						s3.setString(1,"Debited");
						s3.setInt(2, amount);
						s3.setString(3, time);
						s3.setString(4, n);
						s3.setString(5, dup);
						s3.executeUpdate();
						s3.close();
						JOptionPane.showMessageDialog(null, "RS."+ amount +" Have been succesfully debited"+"\n\nThanks for using our ATM Service");
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Insufficient Balance");
						
						}
					}
					s1.close();
					scan.close();
					rs.close();
					con.close();
					frame_f.dispose();
					
					
				}catch(ClassNotFoundException | SQLException e1){
	            System.out.println(e1);
	            JOptionPane.showMessageDialog(null, "Not Debited");
            }
	    		}
	    	
	    });
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		btnNewButton.setBounds(163, 382, 144, 36);
		frame_f.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Rs.2000");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
	    			Class.forName("com.mysql.cj.jdbc.Driver");
					Scanner scan=new Scanner(System.in);
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","teamosekire");
					
					String query="Select * from details where card_no=?";
					PreparedStatement s1= con.prepareStatement(query);
					s1.setString(1, n);
					ResultSet rs=s1.executeQuery();
					amount=2000;
					
					if(rs.next()) {
						if(amount<rs.getInt("Balance")) {
						amt=rs.getInt("Balance");
						amt-=amount;
						String query2="Update details set Balance= ? where card_no= ?";
						PreparedStatement s2= con.prepareStatement(query2);
					    s2.setInt(1,amt);
					    s2.setString(2,n);
					    s2.executeUpdate();
					    s2.close();
					    t1=java.time.Clock.systemUTC().instant();
						time=t1.toString();
						dup=rs.getString("Biometrics");
						String mini="insert into ministatement values(?,?,?,?,?)";
						PreparedStatement s3= con.prepareStatement(mini);
						s3.setString(1,"Debited");
						s3.setInt(2, amount);
						s3.setString(3, time);
						s3.setString(4, n);
						s3.setString(5, dup);
						s3.executeUpdate();
						s3.close();
						JOptionPane.showMessageDialog(null, "RS."+ amount +" Have been succesfully debited"+"\n\nThanks for using our ATM Service");
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Insufficient Balance");
							
						}
					}
					s1.close();
					scan.close();
					rs.close();
					con.close();
					frame_f.dispose();
					
					
				}catch(ClassNotFoundException | SQLException e1){
	            System.out.println(e1);
	            JOptionPane.showMessageDialog(null, "Not Debited");
            }
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton_1.setBounds(163, 422, 144, 36);
		frame_f.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Rs.10000");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
	    			Class.forName("com.mysql.cj.jdbc.Driver");
					Scanner scan=new Scanner(System.in);
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","teamosekire");
					
					String query="Select * from details where card_no=?";
					PreparedStatement s1= con.prepareStatement(query);
					s1.setString(1, n);
					ResultSet rs=s1.executeQuery();
					amount=10000;
					
					if(rs.next()) {
						if(amount<rs.getInt("Balance")) {
						amt=rs.getInt("Balance");
						amt-=amount;
						String query2="Update details set Balance= ? where card_no= ?";
						PreparedStatement s2= con.prepareStatement(query2);
					    s2.setInt(1,amt);
					    s2.setString(2,n);
					    s2.executeUpdate();
					    s2.close();
					    t1=java.time.Clock.systemUTC().instant();
						time=t1.toString();
						dup=rs.getString("Biometrics");
						String mini="insert into ministatement values(?,?,?,?,?)";
						PreparedStatement s3= con.prepareStatement(mini);
						s3.setString(1,"Debited");
						s3.setInt(2, amount);
						s3.setString(3, time);
						s3.setString(4, n);
						s3.setString(5, dup);
						s3.executeUpdate();
						s3.close();
						JOptionPane.showMessageDialog(null, "RS."+ amount +" Have been succesfully debited"+"\n\nThanks for using our ATM Service");
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Insufficient Balance");
							
						}
					}
					s1.close();
					scan.close();
					rs.close();
					con.close();
					frame_f.dispose();
					
					
				}catch(ClassNotFoundException | SQLException e1){
	            System.out.println(e1);
	            JOptionPane.showMessageDialog(null, "Not Debited");
            }
				
			}
			
		});
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		btnNewButton_1_1.setBounds(163, 464, 144, 36);
		frame_f.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Rs.1000");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
	    			Class.forName("com.mysql.cj.jdbc.Driver");
					Scanner scan=new Scanner(System.in);
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","teamosekire");
					
					String query="Select * from details where card_no=?";
					PreparedStatement s1= con.prepareStatement(query);
					s1.setString(1, n);
					ResultSet rs=s1.executeQuery();
					amount=1000;
				
					if(rs.next()) {
						if(amount<rs.getInt("Balance")) {
						amt=rs.getInt("Balance");
						amt-=amount;
						String query2="Update details set Balance= ? where card_no= ?";
						PreparedStatement s2= con.prepareStatement(query2);
					    s2.setInt(1,amt);
					    s2.setString(2,n);
					    s2.executeUpdate();
					    s2.close();
					    t1=java.time.Clock.systemUTC().instant();
						time=t1.toString();
						dup=rs.getString("Biometrics");
						String mini="insert into ministatement values(?,?,?,?,?)";
						PreparedStatement s3= con.prepareStatement(mini);
						s3.setString(1,"Debited");
						s3.setInt(2, amount);
						s3.setString(3, time);
						s3.setString(4, n);
						s3.setString(5, dup);
						s3.executeUpdate();
						s3.close();
						JOptionPane.showMessageDialog(null, "RS."+ amount +" Have been succesfully debited"+"\n\nThanks for using our ATM Service");
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Insufficient Balance");
						
						}
					}
					s1.close();
					scan.close();
					rs.close();
					con.close();
					frame_f.dispose();
					
					
				}catch(ClassNotFoundException | SQLException e1){
	            System.out.println(e1);
	            JOptionPane.showMessageDialog(null, "Not Debited");
            }
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		btnNewButton_1_1_1.setBounds(411, 382, 144, 36);
		frame_f.getContentPane().add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Rs.5000");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
	    			Class.forName("com.mysql.cj.jdbc.Driver");
					Scanner scan=new Scanner(System.in);
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","teamosekire");
					
					String query="Select * from details where card_no=?";
					PreparedStatement s1= con.prepareStatement(query);
					s1.setString(1, n);
					ResultSet rs=s1.executeQuery();
					amount=5000;
				
					if(rs.next()) {
						if(amount<rs.getInt("Balance")) {
						amt=rs.getInt("Balance");
						amt-=amount;
						String query2="Update details set Balance= ? where card_no= ?";
						PreparedStatement s2= con.prepareStatement(query2);
					    s2.setInt(1,amt);
					    s2.setString(2,n);
					    s2.executeUpdate();
					    s2.close();
					    t1=java.time.Clock.systemUTC().instant();
						time=t1.toString();
						dup=rs.getString("Biometrics");
						String mini="insert into ministatement values(?,?,?,?,?)";
						PreparedStatement s3= con.prepareStatement(mini);
						s3.setString(1,"Debited");
						s3.setInt(2, amount);
						s3.setString(3, time);
						s3.setString(4, n);
						s3.setString(5, dup);
						s3.executeUpdate();
						s3.close();
						JOptionPane.showMessageDialog(null, "RS."+ amount +" Have been succesfully debited"+"\n\nThanks for using our ATM Service");
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Insufficient Balance");
							
						}
					}
					s1.close();
					scan.close();
					rs.close();
					con.close();
					frame_f.dispose();
					
					
				}catch(ClassNotFoundException | SQLException e1){
	            System.out.println(e1);
	            JOptionPane.showMessageDialog(null, "Not Debited");
            }
			}
		});
		btnNewButton_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		btnNewButton_1_1_1_1.setBounds(411, 422, 144, 36);
		frame_f.getContentPane().add(btnNewButton_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_1 = new JButton("Rs.15000");
		btnNewButton_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
	    			Class.forName("com.mysql.cj.jdbc.Driver");
					Scanner scan=new Scanner(System.in);
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","teamosekire");
					
					String query="Select * from details where card_no=?";
					PreparedStatement s1= con.prepareStatement(query);
					s1.setString(1, n);
					ResultSet rs=s1.executeQuery();
					amount=20000;
					
					if(rs.next()) {
						if(amount<rs.getInt("Balance")) {
						amt=rs.getInt("Balance");
						amt-=amount;
						String query2="Update details set Balance= ? where card_no= ?";
						PreparedStatement s2= con.prepareStatement(query2);
					    s2.setInt(1,amt);
					    s2.setString(2,n);
					    s2.executeUpdate();
					    s2.close();
					    t1=java.time.Clock.systemUTC().instant();
						time=t1.toString();
						dup=rs.getString("Biometrics");
						String mini="insert into ministatement values(?,?,?,?,?)";
						PreparedStatement s3= con.prepareStatement(mini);
						s3.setString(1,"Debited");
						s3.setInt(2, amount);
						s3.setString(3, time);
						s3.setString(4, n);
						s3.setString(5, dup);
						s3.executeUpdate();
						s3.close();
						JOptionPane.showMessageDialog(null, "RS."+ amount +" Have been succesfully debited"+"\n\nThanks for using our ATM Service");
					  
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Insufficient Balance");
							
						}
					}
					s1.close();
					scan.close();
					rs.close();
					con.close();
					frame_f.dispose();
					
					
				}catch(ClassNotFoundException | SQLException e1){
	            System.out.println(e1);
	            JOptionPane.showMessageDialog(null, "Not Debited");
            }
			}
		});
		btnNewButton_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		btnNewButton_1_1_1_1_1.setBounds(411, 464, 144, 36);
		frame_f.getContentPane().add(btnNewButton_1_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_2 = new JButton("Exit");
		btnNewButton_1_1_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Logging out..");
				frame_f.dispose();
			}
		});
		btnNewButton_1_1_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		btnNewButton_1_1_1_1_2.setBounds(411, 504, 144, 36);
		frame_f.getContentPane().add(btnNewButton_1_1_1_1_2);
	    
	    JLabel lblNewLabel = new JLabel("SELECT WITHDRAWL AMOUNT");
	    lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
	    lblNewLabel.setForeground(new Color(255, 255, 255));
	    lblNewLabel.setBounds(240, 259, 247, 51);
	    frame_f.getContentPane().add(lblNewLabel);
	    label_1.setIcon(new ImageIcon(img));
		label_1.setBounds(0, 0, 946, 845);
		frame_f.getContentPane().add(label_1);
	}

}
