package atmSimulator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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

public class Biometrics {

   JFrame frame2;
   JTextField textField;
   JTextField textField_1;
   int pin;
   String bio;
   

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Biometrics window = new Biometrics();
					window.frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Biometrics() {
		initialize();
	}
	private void initialize() {
		frame2 = new JFrame();
		frame2.setBounds(100, 100, 450, 300);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		
		JLabel lblBiometrics = new JLabel("Biometrics");
		lblBiometrics.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblBiometrics.setBounds(40, 48, 126, 29);
		frame2.getContentPane().add(lblBiometrics);
		
		JLabel lblPincode = new JLabel("Pincode");
		lblPincode.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblPincode.setBounds(40, 105, 126, 29);
		frame2.getContentPane().add(lblPincode);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(188, 47, 227, 35);
		frame2.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(188, 104, 227, 35);
		frame2.getContentPane().add(textField_1);
		
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Scanner scan=new Scanner(System.in);
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","teamosekire");
					bio=textField.getText();
					pin=Integer.parseInt(textField_1.getText());
					String query="Select * from details where Biometrics=? and Pincode=? ";
					PreparedStatement s1= con.prepareStatement(query);
					s1.setString(1,bio);
					s1.setInt(2, pin);
					
					ResultSet rs=s1.executeQuery();
					if(rs.next())
					{
						 
						MainWindow2 obj= new MainWindow2(bio);
						obj.MainFrame2.setVisible(true);
						frame2.dispose();
					
					}
					s1.close();
					scan.close();
					rs.close();
					con.close();
					
				}catch(ClassNotFoundException | SQLException e1){
		            System.out.println(e1);
		            JOptionPane.showMessageDialog(null, "Invalid Biometrics or Pincode");
	            }
		        
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnNewButton.setBounds(75, 176, 126, 57);
		frame2.getContentPane().add(btnNewButton);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
			}
		});
		btnClear.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnClear.setBounds(247, 176, 126, 57);
		frame2.getContentPane().add(btnClear);
	}

}
