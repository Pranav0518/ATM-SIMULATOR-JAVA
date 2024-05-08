package atmSimulator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Scanner;


public class MiniStatement2 {

	 JFrame frame_m2;
	 int fr=0,no;
	String n;
	static String y1;
	static int y2;
	static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MiniStatement2 window = new MiniStatement2(y1,y2);
					window.frame_m2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public MiniStatement2(String o,int k) {
		n=o;
		no=k;
		initialize();
	}

	private void initialize() {
		frame_m2 = new JFrame();
		frame_m2.setBounds(100, 100, 526, 671);
		frame_m2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_m2.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CANARA BANK");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(152, 26, 199, 57);
		frame_m2.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Card Number");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(20, 130, 122, 31);
		frame_m2.getContentPane().add(lblNewLabel_1);
		
		JLabel label0 = new JLabel("");
		label0.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label0.setBounds(177, 130, 254, 31);
		frame_m2.getContentPane().add(label0);
		
		JLabel lblNewLabel_1_2 = new JLabel("Last 5 Transactions");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(20, 200, 186, 31);
		frame_m2.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("The Current Account Balance is");
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2_1.setBounds(20, 478, 397, 31);
		frame_m2.getContentPane().add(lblNewLabel_1_2_1);
		
		JLabel label1 = new JLabel("");
		label1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label1.setBounds(20, 241, 143, 31);
		frame_m2.getContentPane().add(label1);
		
		JLabel label2 = new JLabel("");
		label2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label2.setBounds(20, 288, 143, 31);
		frame_m2.getContentPane().add(label2);
		
		JLabel label3 = new JLabel("");
		label3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label3.setBounds(20, 337, 143, 31);
		frame_m2.getContentPane().add(label3);
		
		JLabel label4 = new JLabel("");
		label4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label4.setBounds(20, 378, 143, 31);
		frame_m2.getContentPane().add(label4);
		
		JLabel label5 = new JLabel("");
		label5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label5.setBounds(20, 419, 143, 31);
		frame_m2.getContentPane().add(label5);
		
		JLabel label6 = new JLabel("");
		label6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label6.setBounds(20, 519, 143, 31);
		frame_m2.getContentPane().add(label6);
		
		JLabel label1_1 = new JLabel("");
		label1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label1_1.setBounds(177, 241, 143, 31);
		frame_m2.getContentPane().add(label1_1);
		
		JLabel label1_2 = new JLabel("");
		label1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label1_2.setBounds(285, 241, 217, 31);
		frame_m2.getContentPane().add(label1_2);
		
		JLabel label2_1 = new JLabel("");
		label2_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label2_1.setBounds(177, 288, 143, 31);
		frame_m2.getContentPane().add(label2_1);
		
		JLabel label2_1_1 = new JLabel("");
		label2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label2_1_1.setBounds(285, 288, 217, 31);
		frame_m2.getContentPane().add(label2_1_1);
		
		JLabel label3_1 = new JLabel("");
		label3_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label3_1.setBounds(177, 337, 143, 31);
		frame_m2.getContentPane().add(label3_1);
		
		JLabel label3_2 = new JLabel("");
		label3_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label3_2.setBounds(285, 337, 217, 31);
		frame_m2.getContentPane().add(label3_2);
		
		JLabel label4_1 = new JLabel("");
		label4_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label4_1.setBounds(177, 378, 143, 31);
		frame_m2.getContentPane().add(label4_1);
		
		JLabel label4_2 = new JLabel("");
		label4_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label4_2.setBounds(285, 378, 217, 31);
		frame_m2.getContentPane().add(label4_2);
		
		JLabel label5_1 = new JLabel("");
		label5_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label5_1.setBounds(177, 419, 143, 31);
		frame_m2.getContentPane().add(label5_1);
		
		JLabel label5_2 = new JLabel("");
		label5_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label5_2.setBounds(285, 419, 217, 31);
		frame_m2.getContentPane().add(label5_2);
		try {
			int i=1;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Scanner scan=new Scanner(System.in);
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","teamosekire");
			String query="Select * from ministatement where Biometric=?";
			PreparedStatement s1= con.prepareStatement(query);
			s1.setString(1, n);
			String query1="Select * from details where Biometrics=?";
			PreparedStatement s2= con.prepareStatement(query1);
			s2.setString(1, n);
			ResultSet rs1=s2.executeQuery();
			ResultSet rs=s1.executeQuery();
			if(no>=5)
			   fr=no-5;
			while(rs.next())
			{
			
			if(i==fr+1) {
				label1.setText(rs.getString("Transaction"));
				label1_1.setText(String.valueOf(rs.getInt("Amount")));
				label1_2.setText(rs.getString("Time"));
				
			}
			else if(i==fr+2) {
				label2.setText(rs.getString("Transaction"));
				label2_1.setText(String.valueOf(rs.getInt("Amount")));
				label2_1_1.setText(rs.getString("Time"));
				
			}
			else if(i==fr+3) {
				label3.setText(rs.getString("Transaction"));
				label3_1.setText(String.valueOf(rs.getInt("Amount")));
				label3_2.setText(rs.getString("Time"));
				
			}
			else if(i==fr+4) {
				label4.setText(rs.getString("Transaction"));
				label4_1.setText(String.valueOf(rs.getInt("Amount")));
				label4_2.setText(rs.getString("Time"));
				
			}
			else if(i==fr+5 && rs1.next()) {
				label0.setText(rs1.getString("card_no"));
				label5.setText(rs.getString("Transaction"));
				label5_1.setText(String.valueOf(rs.getInt("Amount")));
				label5_2.setText(rs.getString("Time"));
				label6.setText(String.valueOf(rs1.getInt("Balance")));
				break;
				
			}
			i++;
			}
			rs1.close();
			s1.close();
			scan.close();
			rs.close();
			con.close();
		}
		catch(ClassNotFoundException | SQLException e1){
            System.out.println(e1);
            JOptionPane.showMessageDialog(null, "Not Changed");}
		
		
	}
}
