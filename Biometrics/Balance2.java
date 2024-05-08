package atmSimulator;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Balance2{

    JFrame frame_b2;
	int amount;
	String n;
    static String z;
    JLabel label_1;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Balance2 window = new Balance2(z);
					window.frame_b2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Balance2(String o) {
		n=o;
		initialize();
	}

	private void initialize() {
		frame_b2 = new JFrame();
		frame_b2.setBounds(100, 100, 960, 1080);
		frame_b2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_b2.getContentPane().setLayout(null);
		label_1 = new JLabel("");
	    Image img= new ImageIcon(this.getClass().getResource("/atm.jpg")).getImage();
	    
	    JLabel lblNewLabel = new JLabel("");
	    lblNewLabel.setForeground(new Color(255, 255, 255));
	    lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 19));
	    lblNewLabel.setBounds(204, 298, 315, 50);
	    frame_b2.getContentPane().add(lblNewLabel);
	    
	    
	    
	    try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
		Scanner scan=new Scanner(System.in);
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","teamosekire");
		
		String query="Select * from details where Biometrics=?";
		PreparedStatement s1= con.prepareStatement(query);
		s1.setString(1, n);
		ResultSet rs=s1.executeQuery();
		if(rs.next()) {
			 int amount= rs.getInt("Balance");
		     lblNewLabel.setText("The Current Account Balance is "+amount);
		     
		}
		s1.close();
		scan.close();
		rs.close();
		con.close();
	    }catch(ClassNotFoundException | SQLException e1){
            System.out.println(e1);
            JOptionPane.showMessageDialog(null, "Not Deposited");
        }
	    
	    
	    
	    JButton btnNewButton = new JButton("Exit");
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		JOptionPane.showMessageDialog(null, "Logging out..");
				frame_b2.dispose();
	    	}
	    });
	    btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
	    btnNewButton.setBackground(new Color(255, 255, 255));
	    btnNewButton.setForeground(new Color(0, 0, 0));
	    btnNewButton.setBounds(335, 490, 123, 37);
	    frame_b2.getContentPane().add(btnNewButton);
	    label_1.setIcon(new ImageIcon(img));
		label_1.setBounds(0, 10, 946, 845);
		frame_b2.getContentPane().add(label_1);
	}

}

