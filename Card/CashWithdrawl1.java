package atmSimulator;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
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

public class CashWithdrawl1 {

	 JFrame frame_c;
	 int amt,amount;
	 String n,time,dup;
	 Instant t1;
     static String z;
     JLabel label_1;
      JTextField textField;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CashWithdrawl1 window = new CashWithdrawl1(z);
					window.frame_c.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public CashWithdrawl1(String o) {
		n=o;
		initialize();
	}

	private void initialize() {
		frame_c = new JFrame();
		frame_c.setBounds(100, 100, 960, 1080);
		frame_c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_c.getContentPane().setLayout(null);
		label_1 = new JLabel("");
	    Image img= new ImageIcon(this.getClass().getResource("/atm.jpg")).getImage();
	    
	    JButton btnExit = new JButton("Exit");
	    btnExit.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		JOptionPane.showMessageDialog(null, "Logging out..");
				frame_c.dispose();
	    	}
	    });
	    btnExit.setFont(new Font("Times New Roman", Font.BOLD, 20));
	    btnExit.setBounds(393, 455, 151, 45);
	    frame_c.getContentPane().add(btnExit);
	    
	    JButton btnNewButton = new JButton("Withdraw");
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
					amount=Integer.parseInt(textField.getText());
					if(rs.next()){
						if(amount<rs.getInt("Balance")) {
						amt=rs.getInt("Balance");
						amt-=amount;
						dup=rs.getString("Biometrics");
						String query2="Update details set Balance= ? where card_no= ?";
						PreparedStatement s2= con.prepareStatement(query2);
					    s2.setInt(1,amt);
					    s2.setString(2,n);
					    s2.executeUpdate();
					    s2.close();
					    t1=java.time.Clock.systemUTC().instant();
						time=t1.toString();
					    String mini="insert into ministatement values(?,?,?,?,?)";
					    PreparedStatement s3= con.prepareStatement(mini);
						s3.setString(1,"Debited");
						s3.setInt(2, amount);
						s3.setString(3, time);
						s3.setString(4, n);
						s3.setString(5, dup);
						s3.executeUpdate();
						s3.close();
					    
					    frame_c.dispose();
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
					
					
				}catch(ClassNotFoundException | SQLException e1){
	            System.out.println(e1);
	            JOptionPane.showMessageDialog(null, "Not Debited");
            }
	    	}
	    });
	    btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
	    btnNewButton.setBounds(393, 401, 151, 45);
	    frame_c.getContentPane().add(btnNewButton);
	    
	    textField = new JTextField();
	    textField.setForeground(new Color(0, 0, 0));
	    textField.setBounds(213, 307, 301, 40);
	    frame_c.getContentPane().add(textField);
	    textField.setColumns(10);
	    
	    JLabel lblNewLabel = new JLabel("Enter The Amount");
	    lblNewLabel.setForeground(new Color(255, 255, 255));
	    lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
	    lblNewLabel.setBounds(220, 251, 280, 40);
	    frame_c.getContentPane().add(lblNewLabel);
	    label_1.setIcon(new ImageIcon(img));
		label_1.setBounds(0, 0, 946, 845);
		frame_c.getContentPane().add(label_1);
	}

}
