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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Edit_Cake implements ActionListener {

	JFrame jf;
	JLabel l1, l2, l3, l4, l5, l6, l7;
	JTextField tf1, tf2, tf3, tf4, tf5;
	JButton b1, b2, b3;

	public Edit_Cake() {
		// header
		JPanel editcake = new JPanel();
		editcake.setLayout(null);
		editcake.setBackground(new Color(0, 0, 0, 80));
		editcake.setBounds(400, 50, 600, 600);

		l1 = new JLabel("Edit-Cake");
		l1.setBounds(150, 30, 300, 60);
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Monotype Corsiva", Font.BOLD, 50));
		editcake.add(l1);

		l2 = new JLabel("Cake Id");
		l2.setBounds(10, 80, 150, 50);
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		editcake.add(l2);

		tf1 = new JTextField();
		tf1.setBounds(160, 90, 200, 30);
		tf1.setOpaque(false);
		tf1.setForeground(Color.WHITE);
		tf1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		editcake.add(tf1);

		b1 = new JButton("Show");
		b1.setBounds(380, 90, 100, 35);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		b1.setOpaque(false);
		b1.setContentAreaFilled(false);
		// b1.setBorderPainted(false);
		editcake.add(b1);

		l3 = new JLabel("Cake Name");
		l3.setBounds(10, 130, 150, 50);
		l3.setForeground(Color.WHITE);
		l3.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		editcake.add(l3);

		tf2 = new JTextField();
		tf2.setBounds(160, 140, 200, 30);
		tf2.setOpaque(false);
		tf2.setForeground(Color.WHITE);
		tf2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		editcake.add(tf2);

		l4 = new JLabel("Cake Size");
		l4.setBounds(10, 180, 150, 50);
		l4.setForeground(Color.WHITE);
		l4.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		editcake.add(l4);

		String[] Size = { "1 Pond", "2 Pond", "3 Pond", "4 Pond", "5 Pond" };
		JComboBox cb1 = new JComboBox(Size);
		cb1.setSelectedIndex(0);
		cb1.setBackground(new Color(0, 0, 0, 10));
		cb1.setForeground(Color.white);
		cb1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cb1.setBounds(365, 190, 200, 30);
		cb1.setOpaque(false);
		editcake.add(cb1);

		tf3 = new JTextField();
		tf3.setBounds(160, 190, 200, 30);
		tf3.setOpaque(false);
		tf3.setForeground(Color.WHITE);
		tf3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		editcake.add(tf3);

		l5 = new JLabel("Cake type");
		l5.setBounds(10, 240, 150, 50);
		l5.setForeground(Color.WHITE);
		l5.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		editcake.add(l5);

		tf4 = new JTextField();
		tf4.setBounds(160, 250, 200, 30);
		tf4.setOpaque(false);
		tf4.setForeground(Color.WHITE);
		tf4.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		editcake.add(tf4);

		String[] Theme = { "Tire cake", "Egg less cake", "Egg Cake", "aniversary cake", "birthday cake", "pastry" };
		JComboBox cb = new JComboBox(Theme);
		cb.setSelectedIndex(0);
		cb.setBackground(new Color(0, 0, 0, 10));
		cb.setBounds(365, 250, 180, 30);
		cb.setForeground(Color.WHITE);
		cb.setOpaque(false);
		editcake.add(cb);

		l6 = new JLabel("Price");
		l6.setBounds(10, 290, 150, 50);
		l6.setForeground(Color.WHITE);
		l6.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		editcake.add(l6);

		tf5 = new JTextField();
		tf5.setBounds(160, 300, 200, 30);
		tf5.setOpaque(false);
		tf5.setForeground(Color.WHITE);
		tf5.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		editcake.add(tf5);

		l7 = new JLabel("Per Pond");
		l7.setBounds(370, 300, 150, 40);
		l7.setForeground(Color.WHITE);
		l7.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		editcake.add(l7);

		b2 = new JButton("Update");
		b2.setBounds(80, 450, 200, 50);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		b2.setOpaque(false);
		b2.setContentAreaFilled(false);
		// b2.setBorderPainted(false);
		editcake.add(b2);

		b3 = new JButton("Cancel");
		b3.setBounds(300, 450, 200, 50);
		b3.setForeground(Color.WHITE);
		b3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		b3.setOpaque(false);
		b3.setContentAreaFilled(false);
		// b3.setBorderPainted(false);
		editcake.add(b3);

		jf = new JFrame("Cake Ordering System");
		jf.setLayout(null);
		jf.setContentPane(new JLabel(new ImageIcon("img\\edit1.jpg")));
		jf.setIconImage(new ImageIcon("img\\cake.png").getImage());
		jf.add(editcake);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		jf.setVisible(true);
		jf.setSize(1366, 768);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(jf.DISPOSE_ON_CLOSE);

	}

	public static void main(String[] args) {
		new Edit_Cake();

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cake", "root", "password");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if (ae.getSource() == b1) {
			try {
				PreparedStatement ps = con.prepareStatement("select * from sale where id=?");
				ps.setInt(1, Integer.parseInt(tf1.getText()));

				ResultSet rs = ps.executeQuery();
				if (rs.next() == true) {
					tf2.setText(rs.getString("name"));
					tf3.setText(rs.getString("size"));
					tf4.setText(rs.getString("Type"));
					tf5.setText(rs.getString("price"));
				} else {
					JOptionPane.showMessageDialog(null, "Data is not found");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		if (ae.getSource() == b2) {
			try {
				// System.out.println("chla..");
				PreparedStatement ps = con.prepareStatement("update sale set name=? where id=?");
				ps.setString(1, tf2.getText());
				ps.setInt(2, Integer.parseInt(tf1.getText()));

				PreparedStatement ps1 = con.prepareStatement("update sale set size=? where id=?");
				ps1.setString(1, tf3.getText());
				ps1.setInt(2, Integer.parseInt(tf1.getText()));

				PreparedStatement ps2 = con.prepareStatement("update sale set type=? where id=?");
				ps2.setString(1, tf4.getText());
				ps2.setInt(2, Integer.parseInt(tf1.getText()));

				PreparedStatement ps3 = con.prepareStatement("update sale set price=? where id=?");
				ps3.setInt(1, Integer.parseInt(tf5.getText()));
				ps3.setInt(2, Integer.parseInt(tf1.getText()));

				// ps.setString(2,tf3.getText());
				// ps.setString(3,tf4.getText());
				// ps.setInt(4,Integer.parseInt(tf5.getText()));

				int i = ps.executeUpdate() + ps1.executeUpdate();

				JOptionPane.showMessageDialog(null, "Successfully Updated" + i);
				new Home();
				jf.dispose();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		if (ae.getSource() == b3) {
			new BillPrint(null, 0);
			jf.dispose();
		}

	}
}
