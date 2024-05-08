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
import java.sql.*;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Card {

	 JFrame frame1;
	 JTextField textField;
	 JTextField textField_1;
     int pin;
     String cardno;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Card window = new Card();
					window.frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Card() {
		
		initialize();
	}
	private void initialize() {
		frame1 = new JFrame();
		frame1.setBounds(100, 100, 450, 300);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CardNumber");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel.setBounds(34, 47, 126, 29);
		frame1.getContentPane().add(lblNewLabel);
		
		JLabel lblPincode = new JLabel("Pincode");
		lblPincode.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblPincode.setBounds(34, 103, 126, 29);
		frame1.getContentPane().add(lblPincode);
		
		textField = new JTextField();
		textField.setBounds(188, 46, 227, 35);
		frame1.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(188, 97, 227, 35);
		frame1.getContentPane().add(textField_1);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Scanner scan=new Scanner(System.in);
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","teamosekire");
				cardno=textField.getText();
				pin=Integer.parseInt(textField_1.getText());
				
				String query="Select * from details where card_no=? and Pincode=? ";
				PreparedStatement s1= con.prepareStatement(query);
				s1.setString(1,cardno);
				s1.setLong(2, pin);
				
				ResultSet rs=s1.executeQuery();
				if(rs.next())
				{
					 
						Mainwindow1 obj= new Mainwindow1(cardno);
						
						obj.MainFrame.setVisible(true);
						frame1.dispose();
				
				}
				s1.close();
				scan.close();
				rs.close();
				con.close();
				
			}catch(ClassNotFoundException | SQLException e1){
	            System.out.println(e1);
	            JOptionPane.showMessageDialog(null, "Invalid Card Number or Pincode");
            }
	        }
			
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnNewButton.setBounds(75, 178, 126, 57);
		frame1.getContentPane().add(btnNewButton);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
			}
		});
		btnClear.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnClear.setBounds(246, 178, 126, 57);
		frame1.getContentPane().add(btnClear);
	}
}
