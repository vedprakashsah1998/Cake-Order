import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Product_Register implements ActionListener, ItemListener {

	JFrame jf;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18;
	JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf10, tf11, tf12, tf13, tf14, tf15, tf16, tf17, tf18;
	JComboBox cb, cb1, cb2, cb3;
	JButton b1, b2, b3;

	public Product_Register() {
		// header
		JPanel product = new JPanel();
		product.setLayout(null);
		product.setBackground(new Color(0, 0, 0, 80));
		product.setBounds(0, 0, 1366, 80);

		l1 = new JLabel("Product Registration");
		l1.setBounds(550, 10, 400, 60);
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Serif", Font.BOLD, 40));
		product.add(l1);

		jf = new JFrame("Cake Ordering System");
		jf.setLayout(null);
		jf.setContentPane(new JLabel(new ImageIcon("img\\Cake1.jpg")));
		jf.setIconImage(new ImageIcon("img\\cake.png").getImage());
		jf.add(product);
		// jf.add(reg);

		// reg
		// JPanel reg=new JPanel();
		// reg.setLayout(null);
		// reg.setBackground(new Color(0,0, 0,40));
		// reg.setBounds(300,140,800,500);

		jf.add(l2 = new JLabel("Cake Id"));
		l2.setBounds(300, 100, 150, 30);
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("Serif", Font.BOLD, 30));

		jf.add(tf1 = new JTextField());
		tf1.setBounds(600, 100, 170, 30);
		tf1.setForeground(Color.WHITE);
		tf1.setBackground(new Color(0, 0, 0, 40));
		tf1.setFont(new Font("Serif", Font.PLAIN, 30));
		tf1.setOpaque(false);

		jf.add(l3 = new JLabel("Cake Name"));
		l3.setBounds(300, 150, 150, 30);
		l3.setForeground(Color.WHITE);
		l3.setFont(new Font("Serif", Font.BOLD, 30));

		jf.add(tf2 = new JTextField());
		tf2.setBounds(600, 150, 170, 30);
		tf2.setForeground(Color.WHITE);
		tf2.setBackground(new Color(0, 0, 0, 40));
		tf2.setFont(new Font("Serif", Font.PLAIN, 30));
		tf2.setOpaque(false);

		l4 = new JLabel("Cake type");
		l4.setBounds(300, 200, 150, 30);
		l4.setForeground(Color.WHITE);
		l4.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		jf.add(l4);

		tf3 = new JTextField();
		tf3.setBounds(600, 200, 170, 30);
		tf3.setOpaque(false);
		tf3.setForeground(Color.WHITE);
		tf3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		jf.add(tf3);

		String[] Theme = { "Tire cake", "Egg less cake", "Egg Cake", "Aniversary cake", "Birthday cake", "pastry" };
		cb = new JComboBox(Theme);
		cb.setSelectedIndex(0);
		cb.setBounds(780, 200, 150, 30);
		cb.setOpaque(false);
		jf.add(cb);
		cb.setBackground(new Color(0, 0, 0, 10));
		cb.setForeground(Color.white);
		cb.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		jf.add(l5 = new JLabel("Cake Size"));
		l5.setBounds(300, 250, 150, 30);
		l5.setForeground(Color.WHITE);
		l5.setFont(new Font("Times New Roman", Font.PLAIN, 30));

		jf.add(tf4 = new JTextField());
		tf4.setBounds(600, 250, 170, 30);
		tf4.setOpaque(false);
		tf4.setForeground(Color.WHITE);
		tf4.setFont(new Font("Times New Roman", Font.PLAIN, 25));

		String[] Size = { "1 Pond", "2 Pond", "3 Pond", "4 Pond", "5 Pond" };
		jf.add(cb1 = new JComboBox(Size));
		cb1.setSelectedIndex(0);
		cb1.setBounds(780, 250, 150, 30);
		cb1.setOpaque(false);
		cb1.setBackground(new Color(0, 0, 0, 10));
		cb1.setForeground(Color.white);
		cb1.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		jf.add(l7 = new JLabel("Cost Price"));
		l7.setBounds(300, 300, 150, 30);
		l7.setForeground(Color.WHITE);
		l7.setFont(new Font("Times New Roman", Font.PLAIN, 30));

		jf.add(tf7 = new JTextField());
		tf7.setBounds(600, 300, 170, 30);
		tf7.setOpaque(false);
		tf7.setForeground(Color.WHITE);
		tf7.setFont(new Font("Times New Roman", Font.PLAIN, 25));

		jf.add(l5 = new JLabel("Selling Price"));
		l5.setBounds(300, 350, 150, 30);
		l5.setForeground(Color.WHITE);
		l5.setFont(new Font("Times New Roman", Font.PLAIN, 30));

		jf.add(tf5 = new JTextField());
		tf5.setBounds(600, 350, 170, 30);
		tf5.setOpaque(false);
		tf5.setForeground(Color.WHITE);
		tf5.setFont(new Font("Times New Roman", Font.PLAIN, 25));

		jf.add(l6 = new JLabel("Company Dealer Name"));
		l6.setBounds(300, 400, 300, 30);
		l6.setForeground(Color.WHITE);
		l6.setFont(new Font("Times New Roman", Font.PLAIN, 30));

		jf.add(tf6 = new JTextField());
		tf6.setBounds(600, 400, 170, 30);
		tf6.setOpaque(false);
		tf6.setForeground(Color.WHITE);
		tf6.setFont(new Font("Times New Roman", Font.PLAIN, 25));

		jf.add(b1 = new JButton("Register"));
		b1.setBounds(400, 550, 150, 50);
		b1.setOpaque(false);
		b1.setContentAreaFilled(false);
		// b1.setBorderPainted(false);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Times New Roman", Font.BOLD, 25));

		jf.add(b2 = new JButton("Stock"));
		b2.setBounds(600, 550, 150, 50);
		b2.setOpaque(false);
		b2.setContentAreaFilled(false);
		// b2.setBorderPainted(false);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Times New Roman", Font.BOLD, 25));

		b1.addActionListener(this);
		cb.addItemListener(this);
		cb1.addItemListener(this);

		jf.setVisible(true);
		jf.setSize(1366, 768);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(jf.DISPOSE_ON_CLOSE);

	}

	public static void main(String[] args) {
		new Product_Register();

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
			if (tf1.getText().length() == 0 || tf2.getText().length() == 0 || tf3.getText().length() == 0
					|| tf4.getText().length() == 0 || tf5.getText().length() == 0 || tf6.getText().length() == 0
					|| tf7.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "Please Enter the data");
			} else {
				
				//java.sql.PreparedStatement ps = con.prepareStatement("insert into reg values(?,?,?,?,?,?,?)");
				
				
				

				try {
					java.sql.PreparedStatement ps1 = con.prepareStatement("select * from reg where Cake_Id=? and Cake_Name=? and Cost_Price=? and Selling_Price=? and Comp_Name=?");
					java.sql.PreparedStatement ps = con.prepareStatement("insert into reg values(?,?,?,?,?,?,?)");
					
					
					ps1.setInt(1, Integer.parseInt(tf1.getText()));
					ps1.setString(2, tf2.getText());
					ps1.setInt(3, Integer.parseInt(tf7.getText()));
					ps1.setInt(4, Integer.parseInt(tf5.getText()));
					ps1.setString(5, tf6.getText());
					ResultSet rs2=ps1.executeQuery();
					if(rs2.next()==true)
					{
						JOptionPane.showMessageDialog(null,"You have already register the same product please specify or enter another product which is not register");
					}
					else
					{
					ps.setInt(1, Integer.parseInt(tf1.getText()));
					ps.setString(2, tf2.getText());
					ps.setString(3, tf3.getText());
					ps.setString(4, tf4.getText());
					ps.setInt(5, Integer.parseInt(tf7.getText()));
					ps.setInt(6, Integer.parseInt(tf5.getText()));
					ps.setString(7, tf6.getText());
					int i = ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "successfully inserted: " + i);
					new Admin_Panel();
					jf.dispose();
					tf1.setText("");
					tf2.setText("");
					tf3.setText("");
					tf4.setText("");
					tf6.setText("");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cb) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				tf3.setText((String) cb.getSelectedItem());

			}
		}
		if (e.getSource() == cb1) {

			if (e.getStateChange() == ItemEvent.SELECTED) {
				tf4.setText((String) cb1.getSelectedItem());

			}
		}

	}

}
