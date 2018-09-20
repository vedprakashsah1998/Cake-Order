import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Admin_Panel implements ActionListener, MouseListener {

	JFrame jf;
	JLabel l1, l2, l3, l4, l5, l6;
	JButton b1, b2, b3, b4, b5;

	public Admin_Panel() {
		JPanel Login = new JPanel();
		Login.setBackground(new Color(0, 0, 0, 80));
		Login.setBounds(0, 0, 1366, 80);

		l1 = new JLabel("Admin Panel");
		// l1.setBounds(200,25,400,60);
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Serif", Font.BOLD, 50));
		Login.add(l1);

		jf = new JFrame("Cake Ordering System");
		jf.setLayout(null);
		jf.setContentPane(new JLabel(new ImageIcon("img\\Admin1.jpg")));
		jf.setIconImage(new ImageIcon("img\\cake.png").getImage());
		jf.add(Login);

		jf.add(b1 = new JButton(new ImageIcon("img\\Sale44.jpg")));
		b1.setBounds(50, 150, 250, 256);
		b1.setOpaque(false);
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);

		jf.add(l2 = new JLabel("Sale"));
		l2.setBounds(120, 400, 200, 40);
		l2.setForeground(new Color(229, 178, 146));
		l2.setFont(new Font("Serif", Font.BOLD, 30));

		jf.add(b2 = new JButton(new ImageIcon("img\\Reg13.jpg")));
		b2.setBounds(550, 150, 256, 256);
		b2.setOpaque(false);
		b2.setContentAreaFilled(false);
		b2.setBorderPainted(false);

		jf.add(l3 = new JLabel("Product Registration"));
		l3.setBounds(550, 400, 400, 40);
		l3.setForeground(new Color(229, 178, 146));
		l3.setFont(new Font("Serif", Font.BOLD, 30));

		jf.add(b3 = new JButton(new ImageIcon("img\\Check.jpg")));
		b3.setBounds(1100, 150, 256, 256);
		b3.setOpaque(false);
		b3.setContentAreaFilled(false);
		b3.setBorderPainted(false);

		jf.add(l4 = new JLabel("Check Order"));
		l4.setBounds(1150, 400, 400, 40);
		l4.setForeground(new Color(229, 178, 146));
		l4.setFont(new Font("Serif", Font.BOLD, 30));

		jf.add(b4 = new JButton(new ImageIcon("img\\Cust.jpg")));
		b4.setBounds(270, 390, 250, 256);
		b4.setOpaque(false);
		b4.setContentAreaFilled(false);
		b4.setBorderPainted(false);

		jf.add(l5 = new JLabel("Customer Information"));
		l5.setBounds(260, 650, 400, 40);
		l5.setForeground(new Color(229, 178, 146));
		l5.setFont(new Font("Serif", Font.BOLD, 30));

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);

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
		new Admin_Panel();

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == b1) {
			new Sale();

		}

		if (ae.getSource() == b2) {
			new Product_Register();

		}

		if (ae.getSource() == b3) {
			new Check_order();

		}

		if (ae.getSource() == b4) {
			new Customer();

		}

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
