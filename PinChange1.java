package atmSimulator;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Scanner;
import java.awt.event.ActionEvent;

public class PinChange1 {

	 JFrame frame_p;
	 int npin1,npin2;
	 String n;
     static String z;
     JLabel label_1;
     private JTextField textField_1;
     private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PinChange1 window = new PinChange1(z);
					window.frame_p.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public PinChange1(String o) {
		n=o;
		initialize();
	}

	private void initialize() {
		frame_p = new JFrame();
		frame_p.setBounds(100, 100, 960, 1080);
		frame_p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_p.getContentPane().setLayout(null);
		label_1 = new JLabel("");
	    Image img= new ImageIcon(this.getClass().getResource("/atm.jpg")).getImage();
	    
	    JButton btnExit = new JButton("Exit");
	    btnExit.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		JOptionPane.showMessageDialog(null, "Logging out..");
				frame_p.dispose();
	    	}
	    });
	    btnExit.setFont(new Font("Times New Roman", Font.BOLD, 17));
	    btnExit.setBounds(404, 479, 142, 35);
	    frame_p.getContentPane().add(btnExit);
	    
	    JButton btnNewButton = new JButton("Confirm");
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
				npin1=Integer.parseInt(textField.getText());
				npin2=Integer.parseInt(textField_1.getText());
				if(rs.next()) {
					if(npin1==npin2) {
					String query2="Update details set Pincode = ? where card_no=?";
					PreparedStatement s2= con.prepareStatement(query2);
				    s2.setInt(1,npin1);
				    s2.setString(2, n);
				    s2.executeUpdate();
				    s2.close();
				    
				    frame_p.dispose();
					JOptionPane.showMessageDialog(null, "New Pin Has Been Set");
				
					}
					else {
						
						JOptionPane.showMessageDialog(null, "Incorrect Pin");
					}
				}
				s1.close();
				scan.close();
				rs.close();
				con.close();
				
			
				
			}catch(ClassNotFoundException | SQLException e1){
            System.out.println(e1);
            JOptionPane.showMessageDialog(null, "Not Changed");
        }
	    	}
	    });
	    btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 17));
	    btnNewButton.setBounds(404, 434, 142, 35);
	    frame_p.getContentPane().add(btnNewButton);
	    
	    textField = new JTextField();
	    textField.setColumns(10);
	    textField.setBounds(394, 325, 134, 35);
	    frame_p.getContentPane().add(textField);
	    
	    textField_1 = new JTextField();
	    textField_1.setColumns(10);
	    textField_1.setBounds(394, 383, 134, 35);
	    frame_p.getContentPane().add(textField_1);
	    
	    JLabel lblReenterNewPin = new JLabel("Re-Enter New Pin");
	    lblReenterNewPin.setForeground(Color.WHITE);
	    lblReenterNewPin.setFont(new Font("Times New Roman", Font.BOLD, 22));
	    lblReenterNewPin.setBounds(191, 370, 228, 54);
	    frame_p.getContentPane().add(lblReenterNewPin);
	    
	    JLabel lblNewPin = new JLabel("New Pin");
	    lblNewPin.setForeground(Color.WHITE);
	    lblNewPin.setFont(new Font("Times New Roman", Font.BOLD, 22));
	    lblNewPin.setBounds(191, 320, 228, 54);
	    frame_p.getContentPane().add(lblNewPin);
	    
	    JLabel lblNewLabel = new JLabel("Change Your Pin");
	    lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
	    lblNewLabel.setForeground(new Color(255, 255, 255));
	    lblNewLabel.setBounds(267, 256, 228, 54);
	    frame_p.getContentPane().add(lblNewLabel);
	    label_1.setIcon(new ImageIcon(img));
		label_1.setBounds(0, 0, 946, 845);
		frame_p.getContentPane().add(label_1);
		
		JLabel label = new JLabel("New label");
		label.setBounds(213, 342, 142, 45);
		frame_p.getContentPane().add(label);
	}

}
