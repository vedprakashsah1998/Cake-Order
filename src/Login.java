import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.jdbc.PreparedStatement;

public class Login implements ActionListener, FocusListener, MouseListener {
	JFrame jf;
	JLabel l1, l2, l3, l4;
	JTextField tf1, tf3, tf4, tf5;
	JPasswordField tf2, tf6;
	JButton b1, b2, b3, b4;

	public Login() {
		// header
		JPanel Login = new JPanel();
		Login.setBackground(new Color(0, 0, 0, 80));
		Login.setBounds(0, 0, 1366, 100);

		l1 = new JLabel("Cake Parlour");
		// l1.setBounds(200,25,400,60);
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Serif", Font.BOLD, 30));
		Login.add(l1);

		// Login Panel
		JPanel lg = new JPanel();
		lg.setLayout(null);
		lg.setSize(400, 470);
		lg.setBackground(new Color(0, 0, 0, 60));
		lg.setBounds(750, 140, 400, 470);

		
		JPanel lg1 = new JPanel();
		lg1.setLayout(null);
		lg1.setSize(380, 500);
		lg1.setBackground(new Color(0, 0, 0, 60));
		lg1.setBounds(200, 140, 380, 470);

		l2 = new JLabel("Login");
		l2.setBounds(150, 15, 100, 50);
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("Serif", Font.BOLD, 30));
		lg.add(l2);

		l3 = new JLabel("Signup");
		l3.setBounds(130, 15, 100, 50);
		l3.setForeground(Color.WHITE);
		l3.setFont(new Font("Serif", Font.BOLD, 30));
		lg1.add(l3);

		tf1 = new JTextField("Enter Username");
		tf1.setBackground(new Color(210, 180, 140));
		tf1.setBounds(40, 70, 300, 50);

		tf1.setForeground(Color.WHITE);
		// tf1.setOpaque(false);
		tf1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lg.add(tf1);

		tf2 = new JPasswordField();
		tf2.setBackground(new Color(210, 180, 140));
		tf2.setBounds(40, 200, 300, 50);

		// tf2.setOpaque(false);
		// tf2.setText("dfkdjk");
		tf2.setEchoChar('*');
		tf2.setForeground(Color.BLACK);
		tf2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lg.add(tf2);

		b1 = new JButton("Login");
		b1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		b1.setForeground(Color.BLACK);
		b1.setBackground(new Color(193, 106, 85));
		b1.setBounds(40, 300, 100, 50);
		// b1.setOpaque(false);
		// b1.setContentAreaFilled(false);
		// b1.setBorderPainted(false);
		lg.add(b1);

		b2 = new JButton("Forget Password");
		b2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		b2.setForeground(Color.BLACK);
		b2.setBackground(new Color(193, 106, 85));
		b2.setBounds(200, 300, 168, 50);
		// b2.setOpaque(false);
		// b2.setContentAreaFilled(false);
		// b2.setBorderPainted(false);
		lg.add(b2);

		lg.add(l4 = new JLabel("Or"));
		l4.setBounds(170, 340, 80, 50);
		l4.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		l4.setForeground(Color.WHITE);

		lg.add(b4 = new JButton(new ImageIcon("img//google.png")));
		b4.setBounds(40, 400, 300, 50);
		b4.setOpaque(false);
		b4.setContentAreaFilled(false);
		b4.setBorderPainted(false);

		// Signup
		tf3 = new JTextField("First Name");
		tf3.setBackground(new Color(210, 180, 140));
		tf3.setBounds(40, 70, 300, 50);

		tf3.setForeground(Color.WHITE);
		// tf3.setOpaque(false);
		tf3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lg1.add(tf3);

		tf4 = new JTextField("Last Name");
		tf4.setBackground(new Color(210, 180, 140));
		tf4.setBounds(40, 150, 300, 50);

		tf4.setForeground(Color.WHITE);
		// tf4.setOpaque(false);
		tf4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lg1.add(tf4);

		tf5 = new JTextField("Email ID");
		tf5.setBackground(new Color(210, 180, 140));
		tf5.setBounds(40, 230, 300, 50);

		tf5.setForeground(Color.WHITE);
		// tf5.setOpaque(false);
		tf5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lg1.add(tf5);

		tf6 = new JPasswordField();
		tf6.setBackground(new Color(210, 180, 140));
		tf6.setBounds(40, 300, 300, 50);
		tf6.setEchoChar('*');
		tf6.setForeground(Color.BLACK);
		// tf6.setOpaque(false);
		tf6.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lg1.add(tf6);

		b3 = new JButton("Signup");
		b3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		b3.setForeground(Color.BLACK);
		b3.setBackground(new Color(193, 106, 85));
		b3.setBounds(40, 380, 100, 50);
		// b3.setOpaque(false);
		// b3.setContentAreaFilled(false);
		// b3.setBorderPainted(false);
		lg1.add(b3);

		jf = new JFrame("Cake Ordering System");
		jf.setLayout(null);
		jf.setContentPane(new JLabel(new ImageIcon("img\\Bg.jpg")));
		jf.setIconImage(new ImageIcon("img\\cake.png").getImage());
		jf.add(Login);
		jf.add(lg);
		jf.add(lg1);

		b1.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);

		tf1.addFocusListener(this);
		tf3.addFocusListener(this);
		tf4.addFocusListener(this);
		tf5.addFocusListener(this);

		b1.addMouseListener(this);
		b2.addMouseListener(this);
		b3.addMouseListener(this);
		b4.addMouseListener(this);

		jf.setVisible(true);
		jf.setSize(1366, 768);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(jf.DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Login();

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cake", "root", "password");
		} catch (Exception ex) {}

		// Login
		if (ae.getSource() == b1) {
			try {
				java.sql.PreparedStatement ps = con
						.prepareStatement("select * from login where email=? and password=?");
				ps.setString(1, tf1.getText());
				ps.setString(2, tf2.getText());
				ResultSet rs = ps.executeQuery();
				if (rs.next() == true) {
					// JOptionPane.showMessageDialog(null, "Successfully Login: ");
					new Home();
					jf.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Invalid User name or Password: ");
					// System.out.println("Invalid User name or Password");
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
			if (tf1.getText().length() == 0) {
				b1.disable();
				JOptionPane.showMessageDialog(null, "Please enter your details", "Alert",
						JOptionPane.INFORMATION_MESSAGE);
			}

		}
		
		//Signup
		if (ae.getSource() == b3) {
			try {
				
				java.sql.PreparedStatement ps1=con.prepareStatement("select * from login where fname=?");
				java.sql.PreparedStatement ps = con.prepareStatement("insert into login (fname) values(?)");
				ps1.setString(1, tf3.getText());
				ResultSet rs2=ps1.executeQuery();
				if(rs2.next()==true)
				{
					JOptionPane.showMessageDialog(null,"Already available Please choose other name or id and password");
				}
				else
				{
					ps.setString(1, tf3.getText());
					
				}
				java.sql.PreparedStatement ps2=con.prepareStatement("select * from login where lname=?");
				java.sql.PreparedStatement ps6 = con.prepareStatement("insert into login (lname) values(?)");
				ps2.setString(1, tf4.getText());
				ResultSet rs3=ps2.executeQuery();
				if(rs3.next()==true)
				{
					JOptionPane.showMessageDialog(null,"Already available Please choose other name or id and password");
				}
				else
				{
					ps6.setString(1, tf4.getText());
					
				}
				java.sql.PreparedStatement ps3=con.prepareStatement("select * from login where email=?");
				java.sql.PreparedStatement ps7 = con.prepareStatement("insert into login (email) values(?)");
				ps3.setString(1, tf5.getText());
				ResultSet rs4=ps3.executeQuery();
				if(rs4.next()==true)
				{
					JOptionPane.showMessageDialog(null,"Already available Please choose other name or id and password");
				}
				else
				{
					ps7.setString(1, tf5.getText());
					
				}
				java.sql.PreparedStatement ps4=con.prepareStatement("select * from login where password=?");
				java.sql.PreparedStatement ps8 = con.prepareStatement("insert into login (password) values(?)");
				ps4.setString(1, tf6.getText());
				ResultSet rs5=ps4.executeQuery();
				if(rs5.next()==true)
				{
					JOptionPane.showMessageDialog(null,"Already available Please choose other name or id and password");
				}
				else
				{
				ps8.setString(1, tf6.getText());
				
				}
				
				int i = ps.executeUpdate()+ps6.executeUpdate()+ ps7.executeUpdate()+ ps8.executeUpdate();
				JOptionPane.showMessageDialog(null, "successfully inserted: " + i);
				jf.dispose();
				new Home();
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			if (tf3.getText().length() == 0) {
				b3.disable();
				JOptionPane.showMessageDialog(null, "Please enter your details", "Alert",
						JOptionPane.INFORMATION_MESSAGE);
			}
			if (tf4.getText().length() == 0) {
				b3.disable();
				JOptionPane.showMessageDialog(null, "Please enter your details", "Alert",
						JOptionPane.INFORMATION_MESSAGE);
			}
			if (tf5.getText().length() == 0) {
				b3.disable();
				JOptionPane.showMessageDialog(null, "Please enter your details", "Alert",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}

		if (ae.getSource() == b4) {
			new GoogleLogin();
			jf.dispose();
		}

	}

	@Override
	public void focusGained(FocusEvent ae) {
		if (ae.getSource() == tf1) {
			tf1.setText("");
		}
		if (ae.getSource() == tf3) {
			tf3.setText("");
		}
		if (ae.getSource() == tf4) {
			tf4.setText("");
		}
		if (ae.getSource() == tf5) {
			tf5.setText("");
		}

	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		Cursor s = new Cursor(Cursor.HAND_CURSOR);

		b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b4.setCursor(new Cursor(Cursor.HAND_CURSOR));

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
