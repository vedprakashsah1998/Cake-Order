import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

public class Check_order 
{

	JFrame jf;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14;
	public Check_order() 
	{
		
		JPanel Order=new JPanel();
		Order.setBackground(new Color(0,0, 0,80));
		Order.setBounds(0,0,1366,100);	
		
		l1=new JLabel("Order");
		//l1.setBounds(200,25,400,60);
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Serif",Font.BOLD,50));
		Order.add(l1);
		
		jf=new JFrame("Cake Ordering System");
		jf.setLayout(null);
		jf.setContentPane(new JLabel(new ImageIcon("img\\pop.jpg")));
		jf.setIconImage(new ImageIcon("img\\cake.png").getImage());
		jf.add(Order);
		
		JTable table=new JTable(25,13);
		
		jf.add(table); 
		table.setBounds(15, 200, 1320 ,400);
		table.setOpaque(false);
		table.setFont(new Font("Serif", Font.BOLD, 15));
		table.setOpaque(false);
		table.setBackground(new Color(0, 0, 0,50));
		table.setForeground(Color.white);
		
		
		jf.add(l2=new JLabel("Name"));
		l2.setBounds(25,160,100,50);
		l2.setForeground(Color.DARK_GRAY);
		l2.setFont(new Font("Serif", Font.BOLD, 20));
		
		jf.add(l3=new JLabel("Mobile No"));
		l3.setBounds(120,160,100,50);
		l3.setForeground(Color.DARK_GRAY);
		l3.setFont(new Font("Serif", Font.BOLD, 20));
		
		jf.add(l4=new JLabel("Email"));
		l4.setBounds(225,160,100,50);
		l4.setForeground(Color.DARK_GRAY);
		l4.setFont(new Font("Serif", Font.BOLD, 20));
		
		jf.add(l5=new JLabel("Order Id"));
		l5.setBounds(330,160,150,50);
		l5.setForeground(Color.DARK_GRAY);
		l5.setFont(new Font("Serif", Font.BOLD, 20));
		
		jf.add(l6=new JLabel("Order date"));
		l6.setBounds(420,160,150,50);
		l6.setForeground(Color.DARK_GRAY);
		l6.setFont(new Font("Serif", Font.BOLD, 20));
		
		jf.add(l7=new JLabel("Delivery Date"));
		l7.setBounds(520,160,150,50);
		l7.setForeground(Color.DARK_GRAY);
		l7.setFont(new Font("Serif", Font.BOLD, 20));
		
		jf.add(l8=new JLabel("Address"));
		l8.setBounds(650,160,100,50);
		l8.setForeground(Color.DARK_GRAY);
		l8.setFont(new Font("Serif", Font.BOLD, 20));
		
		jf.add(l9=new JLabel("Theme"));
		l9.setBounds(740,160,150,50);
		l9.setForeground(Color.DARK_GRAY);
		l9.setFont(new Font("Serif", Font.BOLD, 20));
		
		jf.add(l10=new JLabel("Flavour"));
		l10.setBounds(840,160,150,50);
		l10.setForeground(Color.DARK_GRAY);
		l10.setFont(new Font("Serif", Font.BOLD, 20));
		
		jf.add(l11=new JLabel("Size"));
		l11.setBounds(940,160,100,50);
		l11.setForeground(Color.DARK_GRAY);
		l11.setFont(new Font("Serif", Font.BOLD, 20));
		
		jf.add(l12=new JLabel("Cake Name"));
		l12.setBounds(1000,160,150,50);
		l12.setForeground(Color.DARK_GRAY);
		l12.setFont(new Font("Serif", Font.BOLD, 20));
		
		jf.add(l13=new JLabel("Filling"));
		l13.setBounds(1150,160,150,50);
		l13.setForeground(Color.DARK_GRAY);
		l13.setFont(new Font("Serif", Font.BOLD, 20));
		
		jf.add(l14=new JLabel("Price"));
		l14.setBounds(1250,160,150,50);
		l14.setForeground(Color.DARK_GRAY);
		l14.setFont(new Font("Serif", Font.BOLD, 20));
		
		Connection con=null;
		try 
		{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cake","root","password"); 
		PreparedStatement ps=con.prepareStatement("select * from cake_order");
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
					table.setValueAt(rs.getString(5), numrow, 4);
					table.setValueAt(rs.getString(6), numrow, 5);
					table.setValueAt(rs.getString(7), numrow, 6);
					table.setValueAt(rs.getString(8), numrow, 7);
					table.setValueAt(rs.getString(9), numrow, 8);
					table.setValueAt(rs.getString(10), numrow, 9);
					table.setValueAt(rs.getString(11), numrow, 10);
					table.setValueAt(rs.getString(12), numrow, 11);
					table.setValueAt(rs.getString(13), numrow, 12);
					numrow++;
					
					
		}
		
		}catch(Exception ex) {ex.printStackTrace();}		
		
		
		
		
		jf.setVisible(true);
		jf.setSize(1366,768);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(jf.DISPOSE_ON_CLOSE);

		
	}

	public static void main(String[] args) 
	{
		new Check_order();

	}

}
