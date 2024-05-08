package atmSimulator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Deposit2{

	 JFrame frame_d2;
	 JTextField textField;
	 JLabel label_1;
	 int amount;
     static String z;
     String n,time,dup;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deposit2 window = new Deposit2(z);
					window.frame_d2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Deposit2(String o) {
		n=o;
		initialize();
	}


	private void initialize() {
		frame_d2 = new JFrame();
		frame_d2.getContentPane().setBackground(new Color(255, 255, 255));
		frame_d2.setBounds(100, 100, 960, 1080);
		frame_d2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_d2.getContentPane().setLayout(null);
		label_1 = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/atm.jpg")).getImage();
		
			JButton btnNewButton = new JButton("Deposit");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
					int amt;
					Class.forName("com.mysql.cj.jdbc.Driver");
					Scanner scan=new Scanner(System.in);
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","teamosekire");
					
					String query="Select * from details where Biometrics= ?";
					PreparedStatement s1= con.prepareStatement(query);
					s1.setString(1, n);
					ResultSet rs=s1.executeQuery();
					amount=Integer.parseInt(textField.getText());
					frame_d2.dispose();
					JOptionPane.showMessageDialog(null, "RS."+ amount +" Have been succesfully deposited"+"\n\nThanks for using our ATM Service");
					if(rs.next()) {
						dup=rs.getString("card_no");
						amt=rs.getInt("Balance");
						amt+=amount; 
						String query2="Update details set Balance= ? where Biometrics= ?";
						PreparedStatement s2= con.prepareStatement(query2);
					    s2.setInt(1,amt);
					    s2.setString(2,n);
					    s2.executeUpdate();
					    s2.close();
					}
					Instant t1=java.time.Clock.systemUTC().instant();
					time=t1.toString();
					String mini="insert into ministatement values(?,?,?,?,?)";
					PreparedStatement s3= con.prepareStatement(mini);
					s3.setString(1,"Credited");
					s3.setInt(2, amount);
					s3.setString(3, time);
					s3.setString(4,dup);
					s3.setString(5, n);
					s3.executeUpdate();
					s3.close();
					s1.close();
					scan.close();
					rs.close();
					con.close();
				
					
				}catch(ClassNotFoundException | SQLException e1){
	            System.out.println(e1);
	            JOptionPane.showMessageDialog(null, "Not Deposited");
            }
				}
			});

			
			JButton btnExit = new JButton("Exit");
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Logging out..");
					frame_d2.dispose();
				}
			});
			JLabel lblNewLabel = new JLabel("Enter the amount you want to deposit");
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 19));
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setBounds(190, 242, 363, 28);
			frame_d2.getContentPane().add(lblNewLabel);
			btnExit.setFont(new Font("Times New Roman", Font.BOLD, 20));
			btnExit.setBounds(393, 450, 145, 40);
			frame_d2.getContentPane().add(btnExit);
			btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
			btnNewButton.setBounds(393, 400, 145, 40);
			frame_d2.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(189, 287, 339, 40);
		frame_d2.getContentPane().add(textField);
		textField.setColumns(10);
		label_1.setIcon(new ImageIcon(img));
		label_1.setBounds(0, 0, 946, 845);
		frame_d2.getContentPane().add(label_1);
		
	}
	 
}

