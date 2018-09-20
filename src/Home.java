import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Home implements ActionListener, MouseListener {
	JFrame jf;
	JLabel l1, l2, l3;
	JButton b1, b2, b3, b4, b5, b6, b7, b8;

	public Home() { // header
		JPanel Welcom = new JPanel();
		Welcom.setLayout(null);
		Welcom.setBackground(new Color(0, 0, 0, 150));
		Welcom.setBounds(100, 0, 300, 768);
		l1 = new JLabel("Welcome");
		l1.setBounds(60, 30, 200, 60);
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Monotype Corsiva", Font.PLAIN, 50));
		Welcom.add(l1);

		// Menubar
		JPanel menu = new JPanel();
		menu.setLayout(null);
		menu.setBackground(new Color(0, 0, 0, 100));
		// menu.setOpaque(false);
		menu.setBounds(740, 120, 600, 60);

		b2 = new JButton("Home");
		b2.setBounds(20, 15, 100, 30);
		b2.setForeground(Color.WHITE);
		b2.setBackground(new Color(0, 0, 0, 100));
		b2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		b2.setOpaque(false);
		b2.setContentAreaFilled(false);
		// b2.setBorderPainted(false);
		menu.add(b2);

		b3 = new JButton("Order");
		b3.setBounds(210, 15, 200, 30);
		b3.setForeground(Color.WHITE);
		b3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		b3.setOpaque(false);
		b3.setContentAreaFilled(false);
		b3.setBorderPainted(false);
		menu.add(b3);

		menu.add(b4 = new JButton("Booking"));
		b4.setBounds(400, 15, 200, 30);
		b4.setForeground(Color.WHITE);
		b4.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		b4.setOpaque(false);
		b4.setContentAreaFilled(false);
		b4.setBorderPainted(false);

		// menu.add(b5=new JButton("Edit-Order"));
		// b5.setBounds(300,15,150,30);
		// b5.setForeground(Color.WHITE);
		// b5.setFont(new Font("Times New Roman",Font.PLAIN,25));
		// b5.setOpaque(false);
		// b5.setContentAreaFilled(false);
		// b5.setBorderPainted(false);
		//
		//
		// menu.add(b6=new JButton("Cancel-Order"));
		// b6.setBounds(450,15,200,30);
		// b6.setForeground(Color.WHITE);
		// b6.setFont(new Font("Times New Roman",Font.PLAIN,25));
		// b6.setOpaque(false);
		// b6.setContentAreaFilled(false);
		// b6.setBorderPainted(false);
		//
		// menu.add(b7=new JButton("Add-Cake"));
		// b7.setBounds(640,15,150,30);
		// b7.setForeground(Color.WHITE);
		// b7.setFont(new Font("Times New Roman",Font.PLAIN,25));
		// b7.setOpaque(false);
		// b7.setContentAreaFilled(false);
		// b7.setBorderPainted(false);

		l2 = new JLabel("Date");
		l2.setBounds(60, 350, 200, 30);
		l2.setForeground(Color.white);
		l2.setFont(new Font("Serif", Font.BOLD, 30));
		Welcom.add(l2);

		String[] Date = { "29-5-2018", "29-5-2018", "30-5-2018", "31-5-2018", "1-6-2018", "2-6-2018", "3-6-2018" };
		JComboBox cb8 = new JComboBox(Date);
		cb8.setSelectedIndex(0);
		cb8.setBounds(50, 390, 200, 30);
		cb8.setOpaque(false);
		cb8.setBackground(new Color(0, 0, 0, 10));
		cb8.setForeground(Color.white);
		cb8.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Welcom.add(cb8);

		l3 = new JLabel("Time");
		l3.setBounds(60, 430, 200, 30);
		l3.setForeground(Color.white);
		l3.setFont(new Font("Serif", Font.BOLD, 30));
		Welcom.add(l3);

		String[] Time = { "Tommorow", "Yesterday", "Today", "Day after tommorow" };
		JComboBox cb9 = new JComboBox(Time);
		cb9.setSelectedIndex(0);
		cb9.setBounds(50, 470, 200, 30);
		cb9.setBackground(new Color(0, 0, 0, 10));
		cb9.setForeground(Color.white);
		cb9.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cb9.setOpaque(false);
		Welcom.add(cb9);

		l3 = new JLabel("Party Size");
		l3.setBounds(60, 500, 200, 30);
		l3.setForeground(Color.white);
		l3.setFont(new Font("Serif", Font.BOLD, 30));
		Welcom.add(l3);

		String[] PartySize = { "Family Size", "Couple-Size", "Birthday Party", "Friends Party" };
		JComboBox cb10 = new JComboBox(PartySize);
		cb10.setSelectedIndex(0);
		cb10.setBounds(50, 540, 200, 30);
		cb10.setBackground(new Color(0, 0, 0, 10));
		cb10.setForeground(Color.white);
		cb10.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cb10.setOpaque(false);
		Welcom.add(cb10);

		b1 = new JButton("Book Now");
		b1.setBounds(50, 600, 200, 40);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		b1.setOpaque(false);
		b1.setContentAreaFilled(false);
		// b1.setBorderPainted(false);
		Welcom.add(b1);

		jf = new JFrame("Cake Ordering System");
		jf.setLayout(null);
		jf.setContentPane(new JLabel(new ImageIcon("img\\Home.jpg")));
		jf.setIconImage(new ImageIcon("img\\cake.png").getImage());
		jf.add(Welcom);
		jf.add(menu);

		jf.add(b8 = new JButton("Logout"));
		b8.setBounds(1150, 590, 200, 50);
		b8.setFont(new Font("Times New Roman", Font.BOLD, 25));
		b8.setForeground(Color.WHITE);
		b8.setOpaque(false);
		b8.setContentAreaFilled(false);
		b8.setBorderPainted(false);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		// b5.addActionListener(this);
		// b6.addActionListener(this);
		// b7.addActionListener(this);
		b8.addActionListener(this);

		b1.addMouseListener(this);
		b2.addMouseListener(this);
		b3.addMouseListener(this);
		b4.addMouseListener(this);
		b8.addMouseListener(this);

		jf.setVisible(true);
		jf.setSize(1366, 768);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Home();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == b2) {
			new Home();
			jf.dispose();
		}
		if (ae.getSource() == b3) {
			new Customer_Inf2();

		}
		if (ae.getSource() == b4) {
			new Customer_Inf();
		}
		// if(ae.getSource()==b5)
		// {
		// new EditOreder();
		// }
		// if(ae.getSource()==b6)
		// {
		// new Cancel_Order();
		// }
		// if(ae.getSource()==b7)
		// {
		// new Add_Cake();
		// }
		if (ae.getSource() == b8) {
			new Choose();
			jf.dispose();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		Cursor s = new Cursor(Cursor.HAND_CURSOR);

		b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b8.setCursor(new Cursor(Cursor.HAND_CURSOR));

		if (e.getSource() == b8) {
			b8.setForeground(Color.red);
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == b8) {
			b8.setForeground(Color.WHITE);
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
