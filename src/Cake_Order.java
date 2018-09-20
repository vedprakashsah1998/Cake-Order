import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Cake_Order implements ActionListener,FocusListener
{

	JFrame jf;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6;
	JButton b1,b2,b3;
	JComboBox cb,cb1,cb2,cb3,cb4,cb5,cb6,cb7,cb8,cb9,cb10,cb11;
	public Cake_Order(double mono) 
	{
		
		//header
			JPanel Login=new JPanel();
			Login.setBackground(new Color(0,0, 0,80));
			Login.setBounds(0,0,1366,100);	
			
			l1=new JLabel("Cake Order");
			//l1.setBounds(200,25,400,60);
			l1.setForeground(Color.WHITE);
			l1.setFont(new Font("Serif",Font.BOLD,50));
			Login.add(l1);
			
			//Customer Detail
			JPanel lg1=new JPanel();
			lg1.setLayout(null);
			lg1.setSize(380,550);
			lg1.setBackground(new Color(0,0, 0,200));
			lg1.setBounds(100,120,380,550);
			
			//Cake Detail
			JPanel lg=new JPanel();
			lg.setLayout(null);
			lg.setSize(380,550);
			lg.setBackground(new Color(0,0, 0,200));
			lg.setBounds(900,120,380,550);
		
			
			l2=new JLabel("Customer Details");
			l2.setBounds(70,15,300,50);
			l2.setForeground(Color.WHITE);
			l2.setFont(new Font("Pristina",Font.PLAIN,35));
			lg1.add(l2);
			
			l3=new JLabel("Customer Name");
			l3.setBounds(7,70,200,50);
			l3.setForeground(Color.WHITE);
			l3.setFont(new Font("Serif",Font.PLAIN,20));
			lg1.add(l3);
			
			tf1=new JTextField();
			tf1.setBackground(Color.DARK_GRAY);
			tf1.setBounds(150,80,200,30);
			tf1.setForeground(Color.WHITE);
			//tf1.setOpaque(false);
			tf1.setFont(new Font("Times New Roman",Font.PLAIN,20));
			lg1.add(tf1);
			
			l4=new JLabel("Mobile Number");
			l4.setBounds(7,115,200,50);
			l4.setForeground(Color.WHITE);
			l4.setFont(new Font("Serif",Font.PLAIN,20));
			lg1.add(l4);
			
			tf2=new JTextField("+91");
			tf2.setBackground(Color.DARK_GRAY);
			tf2.setBounds(150,125,200,30);
			tf2.setForeground(Color.WHITE);
			//tf2.setOpaque(false);
			tf2.setFont(new Font("Times New Roman",Font.PLAIN,20));
			lg1.add(tf2);
			
			l5=new JLabel("Email Id");
			l5.setBounds(7,160,200,50);
			l5.setForeground(Color.WHITE);
			l5.setFont(new Font("Serif",Font.PLAIN,20));
			lg1.add(l5);
			
			tf3=new JTextField();
			tf3.setBackground(Color.DARK_GRAY);
			tf3.setBounds(150,170,200,30);
			tf3.setForeground(Color.WHITE);
			//tf3.setOpaque(false);
			tf3.setFont(new Font("Times New Roman",Font.PLAIN,20));
			lg1.add(tf3);
			
			l6=new JLabel("Order Id");
			l6.setBounds(7,205,200,50);
			l6.setForeground(Color.WHITE);
			l6.setFont(new Font("Serif",Font.PLAIN,20));
			lg1.add(l6);
			
			tf4=new JTextField();
			tf4.setBackground(Color.DARK_GRAY);
			tf4.setBounds(150,215,200,30);
			tf4.setForeground(Color.WHITE);
			//tf4.setOpaque(false);
			tf4.setFont(new Font("Times New Roman",Font.PLAIN,20));
			lg1.add(tf4);
			
			l7=new JLabel("Order Date");
			l7.setBounds(7,245,200,50);
			l7.setForeground(Color.WHITE);
			l7.setFont(new Font("Serif",Font.PLAIN,20));
			lg1.add(l7);
			

			String[] Date={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
			
			
		    cb=new JComboBox(Date); 
		    cb.setSelectedIndex(0);
		   
		    
		    
		    cb.setBounds(130,255,40,30); 
//		    cb.setBackground(Color.DARK_GRAY);
//		    cb.setForeground(Color.WHITE);
		    cb.setOpaque(false);

		    lg1.add(cb);
		    
		    String[] Month= {"January","Feburary","March","April","May","June","July","August","September","October","November","December"};
		    cb1=new JComboBox(Month); 
		    cb1.setSelectedIndex(0);
		   
		    
		   
		    cb1.setBounds(180,255,80,30); 
		    cb1.setOpaque(false);
		    lg1.add(cb1);
		    
		    String[] Year= {"2018","2019","2020","2021","2022","2023","2024"};
		    cb2=new JComboBox(Year); 
		    cb2.setSelectedIndex(0);
		   
		    cb2.setBounds(270,255,100,30); 
		    cb2.setOpaque(false);
		    lg1.add(cb2);
		    
		    l8=new JLabel("Delivery Date");
			l8.setBounds(7,300,200,50);
			l8.setForeground(Color.WHITE);
			l8.setFont(new Font("Serif",Font.PLAIN,20));
			lg1.add(l8);
			
			String[] Date1={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
			
			
		    cb3=new JComboBox(Date1); 
		    cb3.setSelectedIndex(0);
		   
		    
		    
		    cb3.setBounds(130,310,40,30); 
		    cb3.setOpaque(false);

		    lg1.add(cb3);
		    
		    String[] Month1= {"January","Feburary","March","April","May","June","July","August","September","October","November","December"};
		    cb4=new JComboBox(Month1); 
		    cb4.setSelectedIndex(0);
		   
		    
		   
		    cb4.setBounds(180,310,80,30); 
		    cb4.setOpaque(false);
		    lg1.add(cb4);
		    
		    String[] Year1= {"2018","2019","2020","2021","2022","2023","2024"};
		    cb5=new JComboBox(Year1); 
		    cb5.setSelectedIndex(0);
		   
		    cb5.setBounds(270,310,100,30); 
		    cb5.setOpaque(false);
		    lg1.add(cb5);
		    
		    
		    l9=new JLabel("Address");
			l9.setBounds(7,360,200,50);
			l9.setForeground(Color.WHITE);
			l9.setFont(new Font("Serif",Font.PLAIN,20));
			lg1.add(l9);
			
			tf5=new JTextField();
			tf5.setBackground(Color.DARK_GRAY);
			tf5.setBounds(130,370,230,150);
			tf5.setForeground(Color.WHITE);
			//tf4.setOpaque(false);
			tf5.setFont(new Font("Times New Roman",Font.PLAIN,18));
			lg1.add(tf5);
		    

			l10=new JLabel("Cake Details");
			l10.setBounds(70,15,300,50);
			l10.setForeground(Color.WHITE);
			l10.setFont(new Font("Pristina",Font.PLAIN,35));
			lg.add(l10);
			
			l11=new JLabel("Cake Theme");
			l11.setBounds(7,70,200,50);
			l11.setForeground(Color.WHITE);
			l11.setFont(new Font("Serif",Font.PLAIN,20));
			lg.add(l11);
			
			String[] Theme= {"Regular Cake","Small Cake","BirthDay Cake","Aniversary Cake"};
		    cb6=new JComboBox(Theme); 
		    cb6.setSelectedIndex(0);
		   
		    cb6.setBounds(140,80,200,30); 
		    cb6.setOpaque(false);
		    lg.add(cb6);
		    
		    l12=new JLabel("Falavour");
			l12.setBounds(7,120,200,50);
			l12.setForeground(Color.WHITE);
			l12.setFont(new Font("Serif",Font.PLAIN,20));
			lg.add(l12);
			
			String[] Flavour= {"Vanilla","Choclate","ButterScoth","Pineapple","Fruit Cake","Black Forest","Dark Forest"};
		    cb7=new JComboBox(Flavour); 
		    cb7.setSelectedIndex(0);
		   
		    cb7.setBounds(140,130,200,30); 
		    cb7.setOpaque(false);
		    lg.add(cb7);
		    
		    l13=new JLabel("Cake Size");
			l13.setBounds(7,170,200,50);
			l13.setForeground(Color.WHITE);
			l13.setFont(new Font("Serif",Font.PLAIN,20));
			lg.add(l13);
			
			String[] Size= {"1 Pond","2 Pond","3 Pond","4 Pond","5 Pond"};
		    cb8=new JComboBox(Size); 
		    cb8.setSelectedIndex(0);
		   
		    cb8.setBounds(140,180,200,30); 
		    cb8.setOpaque(false);
		    lg.add(cb8);
		    
		    l14=new JLabel("Cake Name");
			l14.setBounds(7,220,200,50);
			l14.setForeground(Color.WHITE);
			l14.setFont(new Font("Serif",Font.PLAIN,20));
			lg.add(l14);
			
			String[] cakename= {"BirthDay Cake","Chota Bheem Cake","friendship cake","Special cake","Kids cake"};
		    cb9=new JComboBox(cakename); 
		    cb9.setSelectedIndex(0);
		   
		    cb9.setBounds(140,230,200,30); 
		    cb9.setOpaque(false);
		    lg.add(cb9);
		    
		    l15=new JLabel("Filling");
			l15.setBounds(7,270,200,50);
			l15.setForeground(Color.WHITE);
			l15.setFont(new Font("Serif",Font.PLAIN,20));
			lg.add(l15);
			
			String[] filling= {"Butter-Scotch","Strawberry","Choclate","Vanilla","Pineapple","cadbuary"};
		    cb10=new JComboBox(filling); 
		    cb10.setSelectedIndex(0);
			   
		    cb10.setBounds(140,280,200,30); 
		    cb10.setOpaque(false);
		    lg.add(cb10);
		    
		    l16=new JLabel("Price");
			l16.setBounds(7,320,200,50);
			l16.setForeground(Color.WHITE);
			l16.setFont(new Font("Serif",Font.PLAIN,20));
			lg.add(l16);
			
			tf6=new JTextField();
			tf6.setBackground(Color.DARK_GRAY);
			tf6.setBounds(140,330,200,40);
			tf6.setForeground(Color.WHITE);
			//tf6.setOpaque(false);
			tf6.setFont(new Font("Times New Roman",Font.PLAIN,18));
			lg.add(tf6);
			
			
	
			b1=new JButton("Book");
			b1.setBounds(20,400,120,40);
			b1.setOpaque(false);
			b1.setContentAreaFilled(false);
			//b1.setBorderPainted(false);
			//b1.setBackground(Color.pink);
			b1.setForeground(Color.WHITE);
			b1.setFont(new Font("Serif",Font.PLAIN,25));
			lg.add(b1);
			
			b2=new JButton("Reset");
			b2.setBounds(150,400,120,40);
			b2.setOpaque(false);
			b2.setContentAreaFilled(false);
			//b2.setBorderPainted(false);
			//b2.setBackground(Color.pink);
			b2.setForeground(Color.WHITE);
			b2.setFont(new Font("Serif",Font.PLAIN,25));
			lg.add(b2);
			
			b3=new JButton("Cancel");
			b3.setBounds(20,450,120,40);
			b3.setOpaque(false);
			b3.setContentAreaFilled(false);
			//b3.setBorderPainted(false);
			//b3.setBackground(Color.pink);
			b3.setForeground(Color.WHITE);
			b3.setFont(new Font("Serif",Font.PLAIN,25));
			lg.add(b3);
		    
			jf=new JFrame("Cake Ordering System");
			jf.setLayout(null);
			jf.setContentPane(new JLabel(new ImageIcon("img\\Front.jpg")));
			jf.setIconImage(new ImageIcon("img\\cake.png").getImage());
			jf.add(Login);
			jf.add(lg);
			jf.add(lg1);
			
			Connection con=null;
			try 
			{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cake","root","password");
			
			//first table mobile save
			//session,/Sharedpreference
			//Cust.mobileno
			PreparedStatement ps=con.prepareStatement("select * from cake_order where Mobile_No=?");
			
			
			//System.out.println("mono:"+Cake_Order.mono_user);
			System.out.println("user mobile no is:"+ mono);
			ps.setDouble(1, mono);
			java.sql.ResultSet rs=ps.executeQuery();
			System.out.println("Query chal gayi:");
			if(rs.next()==true)
			{
						tf1.setText(rs.getString("Customer_name"));
						tf2.setText(rs.getString("Mobile_No"));
						tf3.setText(rs.getString("Email_id"));
						tf4.setText(rs.getString("order_id"));
						cb.setToolTipText(rs.getString("Order_Date"));
						cb1.setToolTipText(rs.getString("Order_Date"));
						cb2.setToolTipText(rs.getString("Order_Date"));
						cb3.setToolTipText(rs.getString("Delivery_Date"));
						cb4.setToolTipText(rs.getString("Delivery_Date"));
						cb5.setToolTipText(rs.getString("Delivery_Date"));
						tf5.setText(rs.getString("Address"));
			}
			
			}catch(Exception ex) {ex.printStackTrace();}
			
			
			b1.addActionListener(this);
			tf2.addFocusListener(this);
			
			jf.setVisible(true);
			jf.setSize(1366,768);
			jf.setLocationRelativeTo(null);
			jf.setDefaultCloseOperation(jf.DISPOSE_ON_CLOSE);
			
		
	}

	/*public static void main(String[] args) 
	{
		new Cake_Order();

	}
*/
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
			try 
			{
				java.sql.PreparedStatement ps=con.prepareStatement("insert into Cake_Order values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1,tf1.getText());
				ps.setInt(2,Integer.parseInt(tf2.getText()));
				ps.setString(3, tf3.getText());
				ps.setInt(4,Integer.parseInt(tf4.getText()));
				
				
				ps.setString(5,(String)cb.getSelectedItem()+cb1.getSelectedItem()+cb2.getSelectedIndex());
//				ps.setString(8,(String) cb1.getSelectedItem());
//				ps.setString(9,(String) cb2.getSelectedItem());
				ps.setString(6,(String)cb3.getSelectedItem()+cb4.getSelectedItem()+cb5.getSelectedItem());
				ps.setString(7,tf5.getText());
//				ps.setString(11,(String) cb4.getSelectedItem());
//				ps.setString(12,(String) cb5.getSelectedItem());
				ps.setString(8,(String) cb6.getSelectedItem());
				ps.setString(9,(String) cb7.getSelectedItem());
				ps.setString(10,(String) cb8.getSelectedItem());
				ps.setString(11,(String) cb9.getSelectedItem());
				ps.setString(12,(String) cb10.getSelectedItem());
				ps.setInt(13,Integer.parseInt(tf6.getText()));
				//ps.setInt(5,cb.getToolkit());
			//	ps.setString(4,tf6.getText());
				
//				ResultSet rs=(ResultSet) ps.executeQuery("select * from Add_Cake");
//				while(rs.next())
//				{
//					cb.addItem(rs.getString(cb.getToolTipText()));
//				}
				
				
				int i=ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "successfully inserted: "+i);
				new Home();
				jf.dispose();
			}catch(Exception ex) {ex.printStackTrace();}
			  
			}
		
	}
	@Override
	public void focusGained(FocusEvent ae) 
	{
		if(ae.getSource()==tf2)
		{
			tf2.setText("");
		}
		
	}
	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
