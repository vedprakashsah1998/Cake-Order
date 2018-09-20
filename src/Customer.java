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

public class Customer {
	JFrame jf;
	JLabel l1, l2,l3,l4,l5,l6,l7,l8;

	public Customer() {
		JPanel Login = new JPanel();
		Login.setBackground(new Color(0, 0, 0, 80));
		Login.setBounds(0, 0, 1366, 100);

		l1 = new JLabel("Customer Information");
		// l1.setBounds(200,25,400,60);
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Serif", Font.BOLD, 50));
		Login.add(l1);

		jf = new JFrame("Cake Ordering System");
		jf.setLayout(null);
		jf.setContentPane(new JLabel(new ImageIcon("img\\Kop.jpg")));
		jf.setIconImage(new ImageIcon("img\\cake.png").getImage());
		jf.add(Login);
		//String[] col = { "Cake Id", "Cake Name", "Flavour", "Cake Type", "Price" };

		JTable table = new JTable(25, 4);

		jf.add(table);
		table.setBounds(300, 150, 900, 400);
		table.setFont(new Font("Serif", Font.BOLD, 15));
		table.setOpaque(false);
		table.setBackground(new Color(0, 0, 0,50));
		table.setForeground(Color.white);
		
		jf.add(l2=new JLabel("Cake Id"));
		l2.setBounds(300,110,100,50);
		l2.setForeground(Color.BLACK);
		l2.setFont(new Font("Serif", Font.BOLD, 20));
		
		jf.add(l3=new JLabel("Cake Name"));
		l3.setBounds(530,110,100,50);
		l3.setForeground(Color.BLACK);
		l3.setFont(new Font("Serif", Font.BOLD, 20));
		
		jf.add(l4=new JLabel("Cake Type"));
		l4.setBounds(770,110,100,50);
		l4.setForeground(Color.BLACK);
		l4.setFont(new Font("Serif", Font.BOLD, 20));
		
		jf.add(l5=new JLabel("Cake Size"));
		l5.setBounds(1000,110,100,50);
		l5.setForeground(Color.BLACK);
		l5.setFont(new Font("Serif", Font.BOLD, 20));
		

		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cake", "root", "password");
			PreparedStatement ps = con.prepareStatement("select * from cinf");
			ResultSet rs = ps.executeQuery();
			JTableHeader head;
			table.setTableHeader(head = new JTableHeader());
			JScrollPane sp = new JScrollPane();
			int numrow = 0;
			while (rs.next() == true) {

				table.setValueAt(rs.getString(1), numrow, 0);
				table.setValueAt(rs.getString(2), numrow, 1);
				table.setValueAt(rs.getString(3), numrow, 2);
				table.setValueAt(rs.getString(4), numrow, 3);
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
		new Customer();

	}

}
