import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Choose implements ActionListener,MouseListener
{

	JFrame jf;
	JButton b1,b2;
	JLabel l1,l2,l3;
	//JComboBox cb;
	public Choose() 
	{
		
		//choose panel
		JPanel choose=new JPanel();
		choose.setLayout(null);
		choose.setBackground(new Color(0,0, 0,80));
		choose.setBounds(0,0,700,80);	
				
		l1=new JLabel("Select one to continue");
		l1.setBounds(150,30,500,60);
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Monotype Corsiva",Font.BOLD,50));
		choose.add(l1);
		
		jf=new JFrame("Cake Ordering System");
		jf.setUndecorated(true);
		jf.setLayout(null);
		jf.setContentPane(new JLabel(new ImageIcon("img\\choose.jpg")));
		jf.setIconImage(new ImageIcon("img\\cake.png").getImage());
		jf.add(choose);
		
//		String lang[]= {"Select language","English","Hindi"};
//		cb=new JComboBox(lang);
//		jf.add(cb);
//		cb.setBounds(50,150,150,30);
		
		
		jf.add(b1=new JButton(new ImageIcon("img\\Admin.png")));
		b1.setBounds(80,200,128,128);
		b1.setOpaque(false);
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
		
		jf.add(l2=new JLabel("Admin"));
		l2.setBounds(100,330,100,30);
		//l2.setForeground(new Color(210,180,140));
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("Times New Roman",Font.BOLD,25));
		
		
		jf.add(b2=new JButton(new ImageIcon("img\\Employee1.png")));
		b2.setBounds(450,200,128,128);
		b2.setOpaque(false);
		b2.setContentAreaFilled(false);
		b2.setBorderPainted(false);
		
		jf.add(l3=new JLabel("Employee"));
		l3.setBounds(450,330,130,30);
		//l3.setForeground(new Color(210,180,140));
		l3.setForeground(Color.WHITE);
		l3.setFont(new Font("Times New Roman",Font.BOLD,25));
		
		
		
		
		
		
		
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b1.addMouseListener(this);
		b2.addMouseListener(this);
		
		 jf.setResizable(false);
		  jf.setSize(700,500);
	      jf.setVisible(true);
		  jf.setDefaultCloseOperation(3);
		  jf.setLocationRelativeTo(null);	
//		  cb.addActionListener(this);
		
		
		
		
	}

	public static void main(String[] args) 
	{
		new Choose();

	}
	
//	public String CountryDate(Locale l)
//	{
//		DateFormat f=DateFormat.getDateInstance(DateFormat.DEFAULT,l);
//		Date c=new Date();
//		String date=f.format(c);
//		return date;
//		
//	}
//	
//	public String CountryTime(Locale l)
//	{
//		DateFormat f=DateFormat.getDateInstance(DateFormat.DEFAULT,l);
//		Date c=new Date();
//		String time=f.format(c);
//		return time;
//		
//	}
//	
//	void setLocale(Locale l)
//	{
//		ResourceBundle rs=ResourceBundle.getBundle("mybundls",l);
//		l1.setText(rs.getString("Selectonetocontinue"));
//		l2.setText(rs.getString("Admin"));
//		l3.setText(rs.getString("Employee"));
//		
//	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
//		int i=cb.getSelectedIndex();
//		if(i==0)
//		{
//			JOptionPane.showMessageDialog(null,"Invalid Selection");
//		}
//		if(i==1)
//		{
//			Locale l=new Locale("en","US");
//			setLocale(l);
//		}
//		
//		if(i==2)
//		{
//			Locale l=new Locale("hi","IN");
//			setLocale(l);
//		}
		
		if(ae.getSource()==b1)
		{
			new Admin_Login();
			//jf.dispose();
		}
		if(ae.getSource()==b2)
		{
			new Login();
			jf.dispose();
		}
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) 
	{
		b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
