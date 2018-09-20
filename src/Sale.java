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

public class Sale {
	JFrame jf;
	JLabel l1, l2,l3,l4,l5,l6,l7,l8,l9,l10;

	public Sale() {
		JPanel Login = new JPanel();
		Login.setBackground(new Color(0, 0, 0, 80));
		Login.setBounds(0, 0, 1366, 100);

		l1 = new JLabel("Sale");
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Serif", Font.BOLD, 50));
		Login.add(l1);

		jf = new JFrame("Cake Ordering System");
		jf.setLayout(null);
		jf.setContentPane(new JLabel(new ImageIcon("img\\Sale.jpg")));
		jf.setIconImage(new ImageIcon("img\\cake.png").getImage());
		jf.add(Login);
		
		jf.add(l2=new JLabel("Cake Id"));
		l2.setBounds(300,110,100,50);
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("Serif", Font.BOLD, 20));
		
		jf.add(l3=new JLabel("Cake Name"));
		l3.setBounds(410,110,100,50);
		l3.setForeground(Color.WHITE);
		l3.setFont(new Font("Serif", Font.BOLD, 20));
		
		jf.add(l4=new JLabel("Cake Type"));
		l4.setBounds(520,110,100,50);
		l4.setForeground(Color.WHITE);
		l4.setFont(new Font("Serif", Font.BOLD, 20));
		
		jf.add(l5=new JLabel("Cake Size"));
		l5.setBounds(640,110,100,50);
		l5.setForeground(Color.WHITE);
		l5.setFont(new Font("Serif", Font.BOLD, 20));
		
		jf.add(l6=new JLabel("Price"));
		l6.setBounds(750,110,100,50);
		l6.setForeground(Color.WHITE);
		l6.setFont(new Font("Serif", Font.BOLD, 20));
		
		jf.add(l7=new JLabel("Quantity"));
		l7.setBounds(860,110,100,50);
		l7.setForeground(Color.WHITE);
		l7.setFont(new Font("Serif", Font.BOLD, 20));
		
		jf.add(l8=new JLabel("Total"));
		l8.setBounds(970,110,100,50);
		l8.setForeground(Color.WHITE);
		l8.setFont(new Font("Serif", Font.BOLD, 20));
		
		jf.add(l9=new JLabel("Order"));
		l9.setBounds(1080,110,100,50);
		l9.setForeground(Color.WHITE);
		l9.setFont(new Font("Serif", Font.BOLD, 20));
		
		JTable table = new JTable(45, 8);
		jf.add(table);
		table.setBounds(300, 150, 900, 500);
		table.setOpaque(false);
		
		table.setFont(new Font("Serif", Font.BOLD, 15));
		table.setBackground(new Color(0, 0, 0,50));
		table.setForeground(Color.white);
		
		

		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cake", "root", "password");
			PreparedStatement ps = con.prepareStatement("select * from sale");
			ResultSet rs = ps.executeQuery();
			JTableHeader head;
			table.setTableHeader(head = new JTableHeader());
			 
			int numrow = 0;
			while (rs.next() == true) {

				table.setValueAt(rs.getString(1), numrow, 0);
				table.setValueAt(rs.getString(2), numrow, 1);
				table.setValueAt(rs.getString(3), numrow, 2);
				table.setValueAt(rs.getString(4), numrow, 3);
				table.setValueAt(rs.getString(5), numrow, 4);
				table.setValueAt(rs.getString(6), numrow, 5);
				table.setValueAt(rs.getString(7), numrow, 6);
				table.setValueAt(rs.getString(8), numrow, 7);
				// table.setValueAt(rs.getString(9), numrow, 8);
				numrow++;

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		jf.setVisible(true);
		jf.setSize(1366, 768);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(jf.DISPOSE_ON_CLOSE);

	}

	public static void main(String[] args) {
		new Sale();

	}

}
