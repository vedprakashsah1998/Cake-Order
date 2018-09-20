import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EditOreder implements ItemListener,ActionListener
{

	JFrame jf;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8;
	JButton b1,b2,b3,b4,b5;
	JComboBox cb,cb1,cb2,cb3,cb4,cb5,cb6,cb7;
	public EditOreder() 
	{
		//header
				JPanel Login=new JPanel();
				Login.setBackground(new Color(0,0, 0,80));
				Login.setBounds(0,0,1366,80);				
				l1=new JLabel("Edit Order");
				//l1.setBounds(200,25,400,60);
				l1.setForeground(Color.WHITE);
				l1.setFont(new Font("Serif",Font.BOLD,50));
				Login.add(l1);
		
		jf=new JFrame("Cake Ordering System");
		jf.setLayout(null);
		jf.setContentPane(new JLabel(new ImageIcon("img\\edit.jpg")));
		jf.setIconImage(new ImageIcon("img\\cake.png").getImage());
		jf.add(Login);
		
		jf.add(l1=new JLabel("Order No"));
		l1.setBounds(20,100,150,50);
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Times New Roman",Font.PLAIN,30));
		
		jf.add(tf1=new JTextField());
		tf1.setBounds(230,110,150,30);
		tf1.setOpaque(false);
		tf1.setForeground(Color.WHITE);
		tf1.setFont(new Font("Times New Roman",Font.PLAIN,25));
		
		jf.add(b1=new JButton("Show"));
		b1.setBounds(410,110,100,35);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Times New Roman",Font.PLAIN,25));
		b1.setOpaque(false);
		b1.setContentAreaFilled(false);
		//	b1.setBorderPainted(false);
		
		jf.add(l2=new JLabel("Customer Name"));
		l2.setBounds(20,150,210,50);
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("Times New Roman",Font.PLAIN,30));
		
		jf.add(tf2=new JTextField());
		tf2.setBounds(230,160,150,30);
		tf2.setOpaque(false);
		tf2.setForeground(Color.WHITE);
		tf2.setFont(new Font("Times New Roman",Font.PLAIN,25));
		
		jf.add(l3=new JLabel("Cake Theme"));
		l3.setBounds(20,200,210,50);
		l3.setForeground(Color.WHITE);
		l3.setFont(new Font("Times New Roman",Font.PLAIN,30));
		
		jf.add(tf3=new JTextField());
		tf3.setBounds(230,210,150,30);
		tf3.setOpaque(false);
		tf3.setForeground(Color.WHITE);
		tf3.setFont(new Font("Times New Roman",Font.PLAIN,25));
		
		String[] Theme= {"Regular Cake","Small Cake","BirthDay Cake","Aniversary Cake"};
	    cb=new JComboBox(Theme); 
	    cb.setSelectedIndex(0);
	    cb.setBounds(390,210,180,30); 
	    cb.setBackground(new Color(0, 0, 0,10));
		cb.setForeground(Color.white);
		cb.setFont(new Font("Times New Roman",Font.PLAIN,15));
	    cb.setOpaque(false);
	    jf.add(cb);
		
	    jf.add(l4=new JLabel("Flavour"));
		l4.setBounds(20,250,210,50);
		l4.setForeground(Color.WHITE);
		l4.setFont(new Font("Times New Roman",Font.PLAIN,30));
		
		jf.add(tf4=new JTextField());
		tf4.setBounds(230,260,150,30);
		tf4.setOpaque(false);
		tf4.setForeground(Color.WHITE);
		tf4.setFont(new Font("Times New Roman",Font.PLAIN,25));
		
		String[] Flavour= {"Vanilla","Choclate","ButterScoth","Pineapple","Fruit Cake","Black Forest","Dark Forest"};
	    cb1=new JComboBox(Flavour); 
	    cb1.setSelectedIndex(0);
	    cb1.setBounds(390,260,180,30); 
	    cb1.setBackground(new Color(0, 0, 0,10));
		cb1.setForeground(Color.white);
		cb1.setFont(new Font("Times New Roman",Font.PLAIN,15));
	    cb1.setOpaque(false);
	    jf.add(cb1);
	    
	    jf.add(l5=new JLabel("Mobile Number"));
		l5.setBounds(20,300,210,50);
		l5.setForeground(Color.WHITE);
		l5.setFont(new Font("Times New Roman",Font.PLAIN,30));
		
		jf.add(tf5=new JTextField());
		tf5.setBounds(230,310,150,30);
		tf5.setOpaque(false);
		tf5.setForeground(Color.WHITE);
		tf5.setFont(new Font("Times New Roman",Font.PLAIN,25));
	    
		 jf.add(l6=new JLabel("Delivery Location"));
		 l6.setBounds(20,350,230,50);
		 l6.setForeground(Color.WHITE);
		 l6.setFont(new Font("Times New Roman",Font.PLAIN,30));
			
		jf.add(tf6=new JTextField());
		tf6.setBounds(250,360,200,150);
		tf6.setOpaque(false);
		tf6.setForeground(Color.WHITE);
		tf6.setFont(new Font("Times New Roman",Font.PLAIN,25));
			
		jf.add(l7=new JLabel("Email Id"));
				l7.setBounds(800,100,230,50);
				l7.setForeground(Color.WHITE);
				l7.setFont(new Font("Times New Roman",Font.PLAIN,30));
				
				jf.add(tf7=new JTextField());
				tf7.setBounds(950,110,200,30);
				tf7.setOpaque(false);
				tf7.setForeground(Color.WHITE);
				tf7.setFont(new Font("Times New Roman",Font.PLAIN,25));	
			
				  l8=new JLabel("Delivery Date");
					l8.setBounds(800,140,200,50);
					l8.setForeground(Color.WHITE);
					l8.setFont(new Font("Serif",Font.PLAIN,30));
					jf.add(l8);
					
		String[] Date1={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
					
					
		cb2=new JComboBox(Date1); 
		cb2.setSelectedIndex(0);
		cb2.setBackground(new Color(0, 0, 0,10));
		cb2.setForeground(Color.white);
		cb2.setFont(new Font("Times New Roman",Font.PLAIN,15));
				    
				    
				    cb2.setBounds(980,150,40,30); 
				    cb2.setOpaque(false);

				    jf.add(cb2);
				    
				    String[] Month1= {"January","Feburary","March","April","May","June","July","August","September","October","November","December"};
				    cb3=new JComboBox(Month1); 
				    cb3.setSelectedIndex(0);
				    cb3.setBackground(new Color(0, 0, 0,10));
					cb3.setForeground(Color.white);
					cb3.setFont(new Font("Times New Roman",Font.PLAIN,15));
				    
				   
				    cb3.setBounds(1030,150,80,30); 
				    cb3.setOpaque(false);
				    jf.add(cb3);
				    
				    String[] Year1= {"2018","2019","2020","2021","2022","2023","2024"};
				    cb4=new JComboBox(Year1); 
				    cb4.setSelectedIndex(0);
				    cb4.setBackground(new Color(0, 0, 0,10));
					cb4.setForeground(Color.white);
					cb4.setFont(new Font("Times New Roman",Font.PLAIN,15));
				    
				    cb4.setBounds(1120,150,100,30); 
				    cb4.setOpaque(false);
				    jf.add(cb4);

				
			
				    jf.add(l9=new JLabel("Cake Name"));
					l9.setBounds(800,190,230,50);
					l9.setForeground(Color.WHITE);
					l9.setFont(new Font("Times New Roman",Font.PLAIN,30));
					
					jf.add(tf8=new JTextField());
					tf8.setBounds(950,200,200,30);
					tf8.setOpaque(false);
					tf8.setForeground(Color.WHITE);
					tf8.setFont(new Font("Times New Roman",Font.PLAIN,25));		
		
					 l8=new JLabel("Filling");
						l8.setBounds(800,240,200,50);
						l8.setForeground(Color.WHITE);
						l8.setFont(new Font("Serif",Font.PLAIN,30));
						jf.add(l8);
						
						String[] filling= {"Butter-Scotch","Strawberry","Choclate","Vanilla","Pineapple","cadbuary"};
					    cb5=new JComboBox(filling); 
					    cb5.setSelectedIndex(0);
					    cb5.setBackground(new Color(0, 0, 0,10));
						cb5.setForeground(Color.white);
						cb5.setFont(new Font("Times New Roman",Font.PLAIN,15)); 
					    cb5.setBounds(950,250,200,30); 
					    cb5.setOpaque(false);
					    jf.add(cb5);
					    
					    l9=new JLabel("Cake Size");
						l9.setBounds(800,280,200,50);
						l9.setForeground(Color.WHITE);
						l9.setFont(new Font("Serif",Font.PLAIN,30));
						jf.add(l9);
						
						String[] Size= {"1 Pond","2 Pond","3 Pond","4 Pond","5 Pond"};
					     cb6=new JComboBox(Size); 
					    cb6.setSelectedIndex(0);
					    cb6.setBackground(new Color(0, 0, 0,10));
						cb6.setForeground(Color.white);
						cb6.setFont(new Font("Times New Roman",Font.PLAIN,15));
					    cb6.setBounds(950,290,200,30); 
					    cb6.setOpaque(false);
					    jf.add(cb6);
					    
					    l9=new JLabel("Order Status");
						l9.setBounds(800,330,200,50);
						l9.setForeground(Color.WHITE);
						l9.setFont(new Font("Serif",Font.PLAIN,30));
						jf.add(l9);
									
						String[] Status= {"Delivered","Pending"};
					    cb7=new JComboBox(Status); 
					    cb7.setSelectedIndex(0);
					    cb7.setBackground(new Color(0, 0, 0,10));
						cb7.setForeground(Color.white);
						cb7.setFont(new Font("Times New Roman",Font.PLAIN,15));		   
					    cb7.setBounds(960,340,200,30); 
					    cb7.setOpaque(false);
					    jf.add(cb7);
					    
					    
				jf.add(b2=new JButton("Update"));
				b2.setBounds(550,550,200,50);
				b2.setForeground(Color.WHITE);
				b2.setFont(new Font("Times New Roman",Font.PLAIN,35));
				b2.setOpaque(false);
				b2.setContentAreaFilled(false);
				//	b2.setBorderPainted(false);
				
				jf.add(b3=new JButton("Cancel"));
				b3.setBounds(800,550,200,50);
				b3.setForeground(Color.WHITE);
				b3.setFont(new Font("Times New Roman",Font.PLAIN,35));
				b3.setOpaque(false);
				b3.setContentAreaFilled(false);
				//	b3.setBorderPainted(false);
				
		b1.addActionListener(this);		
		b2.addActionListener(this);				
		cb.addItemListener(this);
		cb1.addItemListener(this);
		jf.setVisible(true);
		jf.setSize(1366,768);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(jf.DISPOSE_ON_CLOSE);
		
		
		
	}

	public static void main(String[] args) 
	{
		new EditOreder();

	}
	
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		Connection con=null;
		try 
		{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cake","root","password");    
		}catch(Exception ex) {ex.printStackTrace();}
		
		if(ae.getSource()==b1)
		{
			try 
			{
				PreparedStatement ps=con.prepareStatement("select * from cake_order where order_id=?");
				ps.setInt(1,Integer.parseInt(tf1.getText()));
				
				ResultSet rs=ps.executeQuery();
				if(rs.next()==true)
				{
					tf2.setText(rs.getString("Customer_name"));
					tf3.setText(rs.getString("Cake_Theme"));
					tf4.setText(rs.getString("Flavour"));
					tf5.setText(rs.getString("Mobile_No"));
					tf6.setText(rs.getString("Address"));
					tf7.setText(rs.getString("Email_id"));
					tf8.setText(rs.getString("Cake_Name"));
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Data is not found");
				}
			}catch(Exception ex) {ex.printStackTrace();}
		}
		
		if(ae.getSource()==b2)
		{
			try 
			{
				
				PreparedStatement ps=con.prepareStatement("update cake_order set Customer_name=? where order_id=?");
				ps.setString(1, tf2.getText());
				ps.setInt(2,Integer.parseInt(tf1.getText()));
				
				PreparedStatement ps3=con.prepareStatement("update cake_order set Mobile_No=? where order_id=?");
				ps3.setInt(1, Integer.parseInt(tf5.getText()));
				ps3.setInt(2,Integer.parseInt(tf1.getText()));
				
				PreparedStatement ps5=con.prepareStatement("update cake_order set Email_id=? where order_id=?");
				ps5.setString(1, tf7.getText());
				ps5.setInt(2,Integer.parseInt(tf1.getText()));
				
				PreparedStatement ps7=con.prepareStatement("update cake_order set Delivery_Date=? where order_id=?");
				ps7.setString(1,(String) cb2.getSelectedItem()+cb3.getSelectedIndex()+cb4.getSelectedIndex());
				ps7.setInt(2,Integer.parseInt(tf1.getText()));
				
				PreparedStatement ps4=con.prepareStatement("update cake_order set Address=? where order_id=?");
				ps4.setString(1, tf6.getText());
				ps4.setInt(2,Integer.parseInt(tf1.getText()));
				
				PreparedStatement ps1=con.prepareStatement("update cake_order set Cake_Theme=? where order_id=?");
				ps1.setString(1, tf3.getText());
				ps1.setInt(2,Integer.parseInt(tf1.getText()));
				
				PreparedStatement ps2=con.prepareStatement("update cake_order set Flavour=? where order_id=?");
				ps2.setString(1, tf4.getText());
				ps2.setInt(2,Integer.parseInt(tf1.getText()));
				
				PreparedStatement ps9=con.prepareStatement("update cake_order set Cake_Size=? where order_id=?");
				ps9.setString(1, (String) cb6.getSelectedItem());
				ps9.setInt(2,Integer.parseInt(tf1.getText()));
				
				
				
				PreparedStatement ps6=con.prepareStatement("update cake_order set Cake_Name=? where order_id=?");
				ps6.setString(1, tf8.getText());
				ps6.setInt(2,Integer.parseInt(tf1.getText()));
				
				
				
				PreparedStatement ps8=con.prepareStatement("update cake_order set Filling=? where order_id=?");
				ps8.setString(1, (String) cb5.getSelectedItem());
				ps8.setInt(2,Integer.parseInt(tf1.getText()));
				
				
				
				
				
				int i=ps.executeUpdate()+ps1.executeUpdate()+ps2.executeUpdate()+ps3.executeUpdate()+ps4.executeUpdate()+ps5.executeUpdate()+ps6.executeUpdate()+ps7.executeUpdate()+ps8.executeUpdate()+ps9.executeUpdate();
				
				JOptionPane.showMessageDialog(null,"Successfully Updated"+i);
				new Home();
				jf.dispose();
			}catch (Exception e) {e.printStackTrace();}
			
			
		}
		
		
		
	}
	
	
	
	
	
	
	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		if(e.getSource()==cb) {
			if(e.getStateChange() == ItemEvent.SELECTED)
			{
	            tf3.setText((String) cb.getSelectedItem());
			
			}}
			if(e.getSource()==cb1) {
			
			if(e.getStateChange() == ItemEvent.SELECTED)
			{
	            tf4.setText((String) cb1.getSelectedItem());
			
			}}
		
	}

}
