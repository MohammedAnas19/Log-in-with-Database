import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.sql.*;

public class log {

	private JFrame frame;
	private JTextField t1;
	private JPasswordField t2;
	private JLabel l0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					log window = new log();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public log() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 387, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel l1 = new JLabel("Log In");
		l1.setFont(new Font("Arial", Font.BOLD, 35));
		l1.setBounds(131, 21, 119, 43);
		frame.getContentPane().add(l1);
		
		JLabel l2 = new JLabel("Username");
		l2.setFont(new Font("Arial", Font.BOLD, 22));
		l2.setBounds(10, 94, 105, 24);
		frame.getContentPane().add(l2);
		
		JLabel l3 = new JLabel("Password");
		l3.setFont(new Font("Arial", Font.BOLD, 22));
		l3.setBounds(10, 149, 105, 24);
		frame.getContentPane().add(l3);
		
		t1 = new JTextField();
		t1.setBounds(119, 94, 231, 24);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		JButton b1 = new JButton("Sign In");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s1,s2;
				s1=t1.getText();
				s2=String.valueOf(t2.getPassword());
				
				
				
				try {
				String un="root";
				String pd="toor";
				String s3="";
				Class.forName("com.mysql.jdbc.Driver");  
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/anu",un,pd);  
				Statement st= conn.createStatement();
				ResultSet rs= st.executeQuery("select pwd from log where uname='"+s1+"'");
				while(rs.next())
					s3=rs.getString(1);
				if(s2.equals(s3)) 
					l0.setText("You Are Logged In");
				else
					l0.setText("Wrong Username/Password");
					
					
			}
				catch(Exception e) {
					System.out.println(e);
		}}});
		b1.setFont(new Font("Arial", Font.BOLD, 16));
		b1.setBounds(261, 204, 89, 36);
		frame.getContentPane().add(b1);
		
		t2 = new JPasswordField();
		t2.setBounds(119, 149, 231, 24);
		frame.getContentPane().add(t2);
		
		l0 = new JLabel();
		l0.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		l0.setHorizontalAlignment(SwingConstants.CENTER);
		l0.setForeground(Color.GREEN);
		l0.setBackground(Color.LIGHT_GRAY);
		l0.setBounds(10, 0, 340, 20);
		frame.getContentPane().add(l0);
	}
}
