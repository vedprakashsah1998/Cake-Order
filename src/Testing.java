import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;



public class Testing implements ActionListener
{
	
	JFrame jf;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
	JTable table;
	static int price1=0;
	static int order;
	static int id1;
	static String name;
	static String type;
	static String size;
	static int sellingprice;
	static String cname;
	static Connection con;

	JTable jtablestore;
	
	static int numrow=0,i=0,j=0;
	public Testing() 
	{	
		
		jtablestore=new JTable(7,7);
		JPanel Login=new JPanel();
		Login.setBackground(new Color(63, 88, 54));
		Login.setBounds(0,0,1366,80);	
		
		l1=new JLabel("Billing Portal");
		
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Serif",Font.BOLD,50));
		Login.add(l1);
		
	
		jf=new JFrame("Cake Ordering System");
		jf.setLayout(null);
		jf.setBackground(Color.WHITE);
		
		jf.setIconImage(new ImageIcon("img\\cake.png").getImage());
		jf.add(Login);
		
		
		 table=new JTable(25,6);
		
		jf.add(table);
		table.setBounds(300, 150, 800 ,400);
		
		table.setOpaque(false);
		
		table.setFont(new Font("Serif", Font.BOLD, 15));
		table.setBackground(new Color(0, 0, 0,10));
		table.setForeground(Color.BLACK);
	
		jf.add(l2=new JLabel("Cake Id"));
		l2.setBounds(300,110,100,50);
		l2.setForeground(Color.BLACK);
		l2.setFont(new Font("Serif", Font.BOLD, 20));
		
		jf.add(l3=new JLabel("Cake Name"));
		l3.setBounds(430,110,100,50);
		l3.setForeground(Color.BLACK);
		l3.setFont(new Font("Serif", Font.BOLD, 20));
		
		jf.add(l4=new JLabel("Cake Type"));
		l4.setBounds(570,110,100,50);
		l4.setForeground(Color.BLACK);
		l4.setFont(new Font("Serif", Font.BOLD, 20));
		
		jf.add(l5=new JLabel("Cake Size"));
		l5.setBounds(700,110,100,50);
		l5.setForeground(Color.BLACK);
		l5.setFont(new Font("Serif", Font.BOLD, 20));
		

		
		jf.add(l6=new JLabel("Price"));
		l6.setBounds(860,110,100,50);
		l6.setForeground(Color.BLACK);
		l6.setFont(new Font("Serif", Font.BOLD, 20));
		
		jf.add(l7=new JLabel("Company Name"));
		l7.setBounds(970,110,200,50);
		l7.setForeground(Color.BLACK);
		l7.setFont(new Font("Serif", Font.BOLD, 20));
		

		
		jf.add(b1=new JButton("Load Product"));
		b1.setBounds(900,600,250,50);
		b1.setOpaque(false);
		b1.setContentAreaFilled(false);
	
		b1.setForeground(Color.BLACK);
		b1.setFont(new Font("Times New Roman",Font.BOLD,25));
		
		
		
		
		jf.add(l8=new JLabel("Product Id"));
		l8.setBounds(300,600,150,30);
		l8.setForeground(Color.BLACK);
		l8.setFont(new Font("Times New Roman",Font.PLAIN,30));
		
		jf.add(t6=new JTextField());
		t6.setBounds(450,600,170,40);
		t6.setOpaque(false);
		t6.setForeground(Color.BLACK);
		t6.setFont(new Font("Times New Roman",Font.PLAIN,30));
		
		jf.add(b2=new JButton("Add to cart"));
		b2.setBounds(650,600,200,50);
		b2.setOpaque(false);
		b2.setContentAreaFilled(false);
		
		b2.setForeground(Color.BLACK);
		b2.setFont(new Font("Times New Roman",Font.BOLD,25));
		
		jf.add(l9=new JLabel("Quantity"));
		l9.setBounds(70,470,150,30);
		l9.setForeground(Color.BLACK);
		l9.setFont(new Font("Times New Roman",Font.PLAIN,30));
		
		jf.add(t1=new JTextField());
		t1.setBounds(70,530,170,40);
		t1.setOpaque(false);
		t1.setForeground(Color.BLACK);
		t1.setFont(new Font("Times New Roman",Font.PLAIN,25));
		
		jf.add(b3=new JButton("Checkout"));
		b3.setBounds(50,600,200,50);
		b3.setOpaque(false);
		b3.setContentAreaFilled(false);
		
		b3.setForeground(Color.BLACK);
		b3.setFont(new Font("Times New Roman",Font.BOLD,25));
		
		jf.add(l10=new JLabel("Total"));
		l10.setBounds(1150,460,150,30);
		l10.setForeground(Color.BLACK);
		l10.setFont(new Font("Times New Roman",Font.PLAIN,30));
		
		jf.add(t3=new JTextField());
		t3.setBounds(1150,500,170,40);
		t3.setOpaque(false);
		t3.setForeground(Color.BLACK);
		t3.setFont(new Font("Times New Roman",Font.PLAIN,30));
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		jf.setVisible(true);
		jf.setSize(1366,768);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(jf.DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) 
	{
		new Testing();

	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		try 
		{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cake","root","password");    
		}catch(Exception ex) {}
		if(e.getSource()==b1)
		{
			
			
			
			
			
			 
			try 
			{
//			Class.forName("com.mysql.jdbc.Driver");
//			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cake","root","password"); 
			PreparedStatement ps=con.prepareStatement("select * from reg");
			ResultSet rs=ps.executeQuery();
			JTableHeader head;
			table.setTableHeader(head=new JTableHeader());
			JScrollPane sp=new JScrollPane();
			
			int numrow=0;
			while(rs.next()==true)
			{	
				       
						table.setValueAt(rs.getString(1), numrow, 0);
						table.setValueAt(rs.getString(2), numrow, 1);
						table.setValueAt(rs.getString(3), numrow, 2);
						table.setValueAt(rs.getString(4), numrow, 3);
						table.setValueAt(rs.getString(6), numrow, 4);
						table.setValueAt(rs.getString(7), numrow, 5);
						numrow++;
						
						
			}
			
			
			}catch(Exception ex) {ex.printStackTrace();}
		}
		if(e.getSource()==b2)	
		{
			
//			if(t1.getText().length()==0 || t3.getText().length()==0 || t6.getText().length()==0)
//			{
//				JOptionPane.showMessageDialog(null, "Please Enter the apropriate data to proceed with billing");
//			}
			
			int id=Integer.parseInt(t6.getText());
			int qty=Integer.parseInt(t1.getText());
			
//			char ch=(Character) null;
//			char ch1=(Character) null;
//			if(id==ch)
//			{
//			
//			for(ch='A';ch<='Z';ch++)
//			{
//				
//				
//				JOptionPane.showMessageDialog(null,"Please Enter valid Id");
//				
//			}
//			}
//			if(id==ch1)
//			{
//			for(ch1='a';ch1<='z';ch1++)
//			{
//			
//				JOptionPane.showMessageDialog(null, "Please Enter valid id");
//				
//			}
//			}
			
			
			try 
			{
//			Class.forName("com.mysql.jdbc.Driver");
//			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cake","root","password"); 
			PreparedStatement ps=con.prepareStatement("select Selling_Price from reg where Cake_Id=? ");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
		
			
			if(rs.next()==true)
			{
				int price = rs.getInt("Selling_Price");
				
				order=price*qty;
				price1=price1+order;
			}
			
			t3.setText(""+price1);
			
		
			
			jtablestore.setCellSelectionEnabled(true);
			PreparedStatement ps1=con.prepareStatement("select * from reg where Cake_Id=? ");
			ps1.setInt(1,id);
			ResultSet rs1=ps1.executeQuery();
			if(rs1.next()==true)	
			{
			 id1=rs1.getInt("Cake_Id");
			 name =rs1.getString("Cake_Name");
			 type=rs1.getString("Cake_Type");
			 size=rs1.getString("Cake_Size");
			 sellingprice=rs1.getInt("Selling_Price");
			 cname=rs1.getString("Comp_Name");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Pllease Enter valid id");
			}
				
 			
		     jtablestore.setValueAt(id1,numrow, 0);
		     jtablestore.setValueAt(name,numrow, 1);
		     jtablestore.setValueAt(type,numrow, 2);
		     jtablestore.setValueAt(size,numrow, 3);
		     jtablestore.setValueAt(sellingprice,numrow, 4);
		     jtablestore.setValueAt(qty,numrow, 5);
		     jtablestore.setValueAt(order,numrow, 6);
		 
		     numrow++;
 			

			
			
			}
				
			
		catch (Exception e1) {
			e1.printStackTrace();
			
		}
		}
		if(e.getSource()==b3)
		{
			
			if(t1.getText().length()==0 || t3.getText().length()==0 || t6.getText().length()==0)
			{
				JOptionPane.showMessageDialog(null, "Please Enter the appropriate data to proceed with billing");
			}
			
			new BillPrint(jtablestore,price1);
			jf.dispose();

		}
	}
}
