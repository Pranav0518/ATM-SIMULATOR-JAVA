package atmSimulator;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;  
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	
	public Login() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Image img= new ImageIcon(this.getClass().getResource("/logo.jpg")).getImage();
		
		JLabel lblNewLabel_1 = new JLabel("ATM Machine Simulator");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(117, 10, 224, 65);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("ATM CARD");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Card obj = new Card();
				obj.frame1.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(140, 85, 166, 48);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnBiometrics = new JButton("BIOMETRICS");
		btnBiometrics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Biometrics obj = new Biometrics();
				obj.frame2.setVisible(true);
				frame.dispose();
			}
		});
		btnBiometrics.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnBiometrics.setBounds(140, 166, 166, 48);
		frame.getContentPane().add(btnBiometrics);
	}
}
