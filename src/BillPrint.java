import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class BillPrint implements ActionListener {

	JFrame jf;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
	JTextField t1, t2, t3, t4;
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9;
	JTable table;
	static int price1 = 0;
	static int order;
	static int id1;
	JTable jt;
	static int id = 0;
	static String name;
	static String type;
	static String size;
	static int price = 0;
	static int qty = 0;
	static int orderr = 0;

	int numrow = 0;
	public PreparedStatement ps;
	Connection con = Testing.con;

	MimeMessage message;
	Session session;

	public BillPrint(JTable jtablestore, int price1) {

		JPanel Login = new JPanel();
		Login.setBackground(new Color(63, 88, 54));
		Login.setBounds(0, 0, 1366, 80);

		l1 = new JLabel("Billing Portal");
		// l1.setBounds(200,25,400,60);
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Serif", Font.BOLD, 50));
		Login.add(l1);

		// tot1=Integer.parseInt(Testing.total);

		jf = new JFrame("Cake Ordering System");
		jf.setLayout(null);
		jf.setBackground(Color.WHITE);
		// jf.setContentPane(new JLabel(new ImageIcon("img\\Front.jpg")));
		jf.setIconImage(new ImageIcon("img\\cake.png").getImage());
		jf.add(Login);

		this.jt = jtablestore;

		id = (int) jt.getValueAt(numrow, 0);
		name = (String) jt.getValueAt(numrow, 1);
		type = (String) jt.getValueAt(numrow, 2);
		size = (String) jt.getValueAt(numrow, 3);
		price = (int) jt.getValueAt(numrow, 4);
		qty = (int) jt.getValueAt(numrow, 5);
		orderr = (int) jt.getValueAt(numrow, 6);

		jf.add(l2 = new JLabel("Total"));
		l2.setBounds(50, 350, 200, 50);
		l2.setForeground(Color.BLACK);
		l2.setFont(new Font("Times New Roman", Font.PLAIN, 30));

		jf.add(t1 = new JTextField());
		t1.setBounds(50, 400, 200, 50);
		t1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		t1.setText("" + Testing.price1);

		jf.add(b2 = new JButton("Delete"));
		b2.setBounds(50, 480, 200, 50);
		b2.setOpaque(false);
		b2.setContentAreaFilled(false);
		// b2.setBorderPainted(false);
		// b2.setBackground(Color.pink);
		b2.setForeground(Color.BLACK);
		b2.setFont(new Font("Serif", Font.PLAIN, 35));

		jf.add(b3 = new JButton("Update"));
		b3.setBounds(1130, 500, 200, 50);
		b3.setOpaque(false);
		b3.setContentAreaFilled(false);
		// b3.setBorderPainted(false);
		// b3.setBackground(Color.pink);
		b3.setForeground(Color.BLACK);
		b3.setFont(new Font("Serif", Font.PLAIN, 35));

		jf.add(b1 = new JButton("Purchase"));
		b1.setBounds(1120, 600, 200, 50);
		b1.setOpaque(false);
		b1.setContentAreaFilled(false);
		// b1.setBorderPainted(false);
		b1.setBackground(Color.pink);
		b1.setForeground(Color.BLACK);
		b1.setFont(new Font("Serif", Font.PLAIN, 35));

		jf.add(l3 = new JLabel("From"));
		l3.setBounds(50, 550, 200, 50);
		l3.setForeground(Color.BLACK);
		l3.setFont(new Font("Times New Roman", Font.PLAIN, 30));

		// From
		jf.add(t2 = new JTextField(GoogleLogin.str));
		t2.setBounds(50, 600, 250, 40);
		t2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		t2.disable();

		//To
		jf.add(l4 = new JLabel("To"));
		l4.setBounds(400, 600, 200, 50);
		l4.setForeground(Color.BLACK);
		l4.setFont(new Font("Times New Roman", Font.PLAIN, 30));

		jf.add(t3 = new JTextField(Customer_Inf2.mob));
		t3.setBounds(500, 600, 250, 40);
		t3.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		jf.add(l4 = new JLabel("Subject"));
		l4.setBounds(800, 600, 200, 40);
		l4.setForeground(Color.BLACK);
		l4.setFont(new Font("Times New Roman", Font.PLAIN, 30));

		jf.add(t4 = new JTextField());
		t4.setBounds(900, 600, 200, 40);
		t4.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		JTable table = new JTable(25, 7);

		jf.add(table);
		table.setBounds(300, 150, 800, 400);
		
		table.setFont(new Font("Serif", Font.BOLD, 15));
		table.setBackground(new Color(0, 0, 0,10));
		table.setForeground(Color.BLACK);
		
		jf.add(l2=new JLabel("Cake Id"));
		l2.setBounds(300,110,100,50);
		l2.setForeground(Color.BLACK);
		l2.setFont(new Font("Serif", Font.BOLD, 20));
		
		jf.add(l3=new JLabel("Cake Name"));
		l3.setBounds(410,110,100,50);
		l3.setForeground(Color.BLACK);
		l3.setFont(new Font("Serif", Font.BOLD, 20));
		
		jf.add(l4=new JLabel("Cake Type"));
		l4.setBounds(520,110,100,50);
		l4.setForeground(Color.BLACK);
		l4.setFont(new Font("Serif", Font.BOLD, 20));
		
		jf.add(l5=new JLabel("Cake Size"));
		l5.setBounds(640,110,100,50);
		l5.setForeground(Color.BLACK);
		l5.setFont(new Font("Serif", Font.BOLD, 20));
		
		jf.add(l6=new JLabel("Price"));
		l6.setBounds(750,110,100,50);
		l6.setForeground(Color.BLACK);
		l6.setFont(new Font("Serif", Font.BOLD, 20));
		
		jf.add(l7=new JLabel("Quantity"));
		l7.setBounds(860,110,100,50);
		l7.setForeground(Color.BLACK);
		l7.setFont(new Font("Serif", Font.BOLD, 20));
		
//		jf.add(l8=new JLabel("Total"));
//		l8.setBounds(970,110,100,50);
//		l8.setForeground(Color.BLACK);
//		l8.setFont(new Font("Serif", Font.BOLD, 20));
		
		jf.add(l9=new JLabel("Order"));
		l9.setBounds(1000,110,100,50);
		l9.setForeground(Color.BLACK);
		l9.setFont(new Font("Serif", Font.BOLD, 20));
		

		jt.setColumnSelectionAllowed(true);
		jt.getCellSelectionEnabled();

		while (numrow < 7) {

			table.setValueAt(jt.getValueAt(numrow, 0), numrow, 0);
			table.setValueAt(jt.getValueAt(numrow, 1), numrow, 1);
			table.setValueAt(jt.getValueAt(numrow, 2), numrow, 2);
			table.setValueAt(jt.getValueAt(numrow, 3), numrow, 3);
			table.setValueAt(jt.getValueAt(numrow, 4), numrow, 4);
			table.setValueAt(jt.getValueAt(numrow, 5), numrow, 5);
			table.setValueAt(jt.getValueAt(numrow, 6), numrow, 6);
			numrow++;

		}

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		jf.setVisible(true);
		jf.setSize(1366, 768);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

	}
	/*
	 * public static void main(String[] args) {
	 * 
	 * new BillPrint(); }
	 */

	@Override
	public void actionPerformed(ActionEvent ae) {

		try {

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if (ae.getSource() == b1) {

			Properties props = System.getProperties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");
			props.put("mail.smtp.EnableSSL.enable", "true");

			session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					PasswordAuthentication pa = new PasswordAuthentication(GoogleLogin.str, GoogleLogin.s1);
					return pa;
				}
			});
			session.setDebug(true);

			message = new MimeMessage(session);
			try {
				message.setFrom(new InternetAddress(t2.getText()));

				message.setSubject(t4.getText().trim());

				message.setContent(message, "text/html");
				message.setSentDate(new Date());
				String msg = "Thanks For Orderring";

				message.setText(id + name + type + size + price + qty + orderr + t1.getText() + msg);
				message.setRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse(t3.getText()));

				Transport transport = session.getTransport("smtp");
				Transport.send(message);
			} catch (AddressException e1) {
				e1.printStackTrace();
			} catch (MessagingException e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Message is sent");

			try {

				String query = "insert into sale values(?,?,?,?,?,?,?,?)";
				ps = con.prepareStatement(query);

				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setString(3, type);
				ps.setString(4, size);
				ps.setInt(5, price);
				ps.setInt(6, qty);

				ps.setInt(7, Integer.parseInt(t1.getText()));

				ps.setInt(8, orderr);

				int rs2 = ps.executeUpdate();

				if (rs2 != 0) {
					JOptionPane.showMessageDialog(null, "Prchased:" + rs2);
				}
			}

			catch (Exception e) {
				e.printStackTrace();
				System.out.println("error occured");
			}

		}
		if (ae.getSource() == b2) {
			new Delete_Cake();
			jf.dispose();
		}

		if (ae.getSource() == b3) {
			new Edit_Cake();
			jf.dispose();
		}

	}

}
