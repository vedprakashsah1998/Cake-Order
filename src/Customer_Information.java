import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Customer_Information implements ActionListener {

	JFrame jf;
	JTextField t1, t2, t3, t4;
	JTextArea ta;
	JLabel l1, l2, l3, l4, l5;
	JButton b1, b2;

	static String email;

	public Customer_Information() {
		// Add-Cake panel
		JPanel editcake = new JPanel();
		editcake.setLayout(null);
		editcake.setBackground(new Color(0, 0, 0, 80));
		editcake.setBounds(100, 50, 550, 600);

		editcake.add(l1 = new JLabel("Customer Information"));
		l1.setBounds(80, 30, 400, 50);
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Monotype Corsiva", Font.BOLD, 40));

		editcake.add(l2 = new JLabel("Name :"));
		l2.setBounds(20, 100, 100, 40);
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("Monotype Corsiva", Font.BOLD, 30));

		editcake.add(t1 = new JTextField());
		t1.setBounds(200, 100, 250, 40);
		t1.setOpaque(false);
		t1.setForeground(Color.WHITE);
		t1.setFont(new Font("Monotype Corsiva", Font.BOLD, 25));

		editcake.add(l3 = new JLabel("Email Id :"));
		l3.setBounds(20, 170, 150, 40);
		l3.setForeground(Color.WHITE);
		l3.setFont(new Font("Monotype Corsiva", Font.BOLD, 30));

		editcake.add(t2 = new JTextField(Customer_Inf2.mob));
		t2.setBounds(200, 170, 250, 40);
		// t2.setOpaque(false);
		t2.setForeground(Color.BLACK);
		t2.setFont(new Font("Monotype Corsiva", Font.BOLD, 25));

		editcake.add(l4 = new JLabel("Mobile No :"));
		l4.setBounds(20, 240, 180, 40);
		l4.setForeground(Color.WHITE);
		l4.setFont(new Font("Monotype Corsiva", Font.BOLD, 30));

		editcake.add(t3 = new JTextField());
		t3.setBounds(200, 240, 250, 40);
		t3.setOpaque(false);
		t3.setForeground(Color.WHITE);
		t3.setFont(new Font("Monotype Corsiva", Font.BOLD, 25));

		editcake.add(l5 = new JLabel("Address :"));
		l5.setBounds(20, 310, 180, 40);
		l5.setForeground(Color.WHITE);
		l5.setFont(new Font("Monotype Corsiva", Font.BOLD, 30));

		editcake.add(ta = new JTextArea());
		ta.setBounds(200, 310, 250, 180);
		// t2.setOpaque(false);
		ta.setForeground(Color.BLACK);
		ta.setFont(new Font("Arial", Font.PLAIN, 25));

		editcake.add(b1 = new JButton("Take Order"));
		b1.setBounds(100, 530, 200, 40);
		b1.setOpaque(false);
		b1.setContentAreaFilled(false);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Monotype Corsiva", Font.BOLD, 30));

		jf = new JFrame("Cake Ordering System");
		jf.setLayout(null);
		jf.setContentPane(new JLabel(new ImageIcon("img\\addcake.jpg")));
		jf.setIconImage(new ImageIcon("img\\cake.png").getImage());
		jf.add(editcake);

		b1.addActionListener(this);

		jf.setVisible(true);
		jf.setSize(800, 700);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(jf.DISPOSE_ON_CLOSE);

	}

	public static void main(String[] args) {
		new Customer_Information();

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cake", "root", "password");
		} catch (Exception ex) {
		}
		if (ae.getSource() == b1) {
			if (t1.getText().length() == 0 || t2.getText().length() == 0 || ta.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "Please Enter the data");
			}
			if (t3.getText().length() != 10) {
				JOptionPane.showMessageDialog(null, "Please Enter the Valid Number");
			} else {

				try {
					java.sql.PreparedStatement ps = con.prepareStatement("insert into cinf values(?,?,?,?)");
					ps.setString(1, t1.getText());
					ps.setString(2, t2.getText());
					ps.setDouble(3, Double.parseDouble(t3.getText().trim()));
					ps.setString(4, ta.getText());

					int i = ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "successfully inserted: " + i);
					email = t2.getText();
					new Testing();
					jf.dispose();
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}
		}

	}

}
