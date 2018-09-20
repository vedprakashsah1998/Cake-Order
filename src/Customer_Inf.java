import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Customer_Inf implements ActionListener
{

	JFrame jf;
	JLabel l1,l2;
	JButton b1,b2;
	JTextField tf;
	static double mobileno=0; 
	double mono;
	static String mob;
	public Customer_Inf() 
	{
		//header
			JPanel Login=new JPanel();
			Login.setBackground(new Color(0,0, 0,80));
			Login.setBounds(0,0,650,60);
				
			l1=new JLabel("Cake Parlour");
			//l1.setBounds(200,15,200,50);
			l1.setForeground(Color.WHITE);
			l1.setFont(new Font("Serif",Font.BOLD,30));
			Login.add(l1);
			
		
		jf=new JFrame("Cake Ordering System");
		jf.setUndecorated(true);
		jf.setLayout(null);
		jf.setContentPane(new JLabel(new ImageIcon("img\\Customer.jpg")));
		jf.setIconImage(new ImageIcon("img\\cake.png").getImage());
		jf.add(Login);
		
		jf.add(l2=new JLabel("Cutomer Mobile No:"));
		l2.setBounds(30,190,300,50);
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("Serif",Font.BOLD,30));
	
		jf.add(tf=new JTextField("+91"));
		tf.setBounds(300,200,250,40);
		tf.setOpaque(false);
		tf.setForeground(Color.WHITE);
		tf.setFont(new Font("Times New Roman",Font.BOLD,20));
		
		jf.add(b1=new JButton("Proceed"));
		b1.setBounds(400,300,150,50);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Times New Roman",Font.BOLD,27));
		b1.setOpaque(false);
		b1.setContentAreaFilled(false);
	//	b1.setBorderPainted(false);
		
//		jf.add(b2=new JButton("New Customer"));
//		b2.setBounds(350,300,250,50);
//		b2.setForeground(Color.WHITE);
//		b2.setFont(new Font("Times New Roman",Font.BOLD,27));
//		b2.setOpaque(false);
//		b2.setContentAreaFilled(false);
	//	b2.setBorderPainted(false);
		
		
		
		b1.addActionListener(this);
		jf.setVisible(true);
		jf.setSize(650,430);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(jf.DISPOSE_ON_CLOSE);
		
	}

	public static void main(String[] args) 
	{
		new Customer_Inf();
	}

	@Override
	public void actionPerformed(ActionEvent ae)
	{
		Connection con=null;
		try 
		{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cake","root","password");    
		}catch(Exception ex) {}
		if(ae.getSource()==b1)
		{
			
//			if(tf.getText().length()!=10)
//			{
//				JOptionPane.showMessageDialog(null,"Please enter only 10 digit number");
//			}
//			else
//			{
			try 
			{
				java.sql.PreparedStatement ps=con.prepareStatement("select * from Cake_Order where Mobile_No=?");
				mono=Double.parseDouble(tf.getText());
			//	ps.setDouble(3, Double.parseDouble(t3.getText().trim()));
				ps.setDouble(1,mono);
				//ps.setString(2, tf2.getText());
				ResultSet rs=ps.executeQuery();
				if(rs.next()==true)
				{	
					
					
					JOptionPane.showMessageDialog(null, "Welcome customer:");
					new Cake_Order(mono);
					//Cake_Order.get(mono);
					jf.dispose();
					mobileno=mono;
				}
				else
				{
					mob=String.valueOf(tf.getText());
					JOptionPane.showMessageDialog(null, "New Customer: ");
					new Cake_Order2();
					jf.dispose();
					//System.out.println("Invalid User name or Password");
				}
			}catch(Exception ex) {ex.printStackTrace();}
			
			
			
		
		}
		
	}
	

}
