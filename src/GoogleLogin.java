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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GoogleLogin implements ActionListener,MouseListener
{

	JFrame jf;
	JTextField tf;
	JPasswordField tf1;
	JButton b,b1;
	JLabel l1,l2,l3;
	static String str,s1;
	public GoogleLogin()
	{
		//header
		JPanel Login=new JPanel();
		Login.setLayout(null);
		Login.setBackground(new Color(0,0, 0,80));
		Login.setBounds(0,0,700,70);
				
		l1=new JLabel("Employee");
		l1.setBounds(260,5,400,60);
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Serif",Font.BOLD,30));
		Login.add(l1);
		
		Login.add(b1=new JButton(new ImageIcon("img\\close.png")));
		b1.setBounds(670,10,16,16);
		b1.setOpaque(false);
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
		
		//login
		JPanel lg=new JPanel();
		lg.setBackground(new Color(0,0, 0,120));
		lg.setLayout(null);
		lg.setBounds(110,150,420,230);
		
		
		l2=new JLabel("Email Id: ");
		l2.setForeground(Color.WHITE);
		l2.setBounds(20,40,120,30);
		l2.setFont(new Font("Serif",Font.BOLD,25));
		lg.add(l2);
		
		
		tf=new JTextField();
		tf.setBounds(160,40,200,30);
		tf.setForeground(Color.BLACK);
		//tf.setOpaque(false);
		tf.setFont(new Font("Times New Roman",Font.PLAIN,20));
		lg.add(tf);
		
		l2=new JLabel("Password:");
		l2.setForeground(Color.WHITE);
		l2.setBounds(20,100,120,30);
		l2.setFont(new Font("Serif",Font.BOLD,25));
		lg.add(l2);
		
		
		tf1=new JPasswordField();
		tf1.setBounds(160,100,200,30);
		tf1.setForeground(Color.BLACK);
	//	tf1.setOpaque(false);
		tf1.setFont(new Font("Times New Roman",Font.PLAIN,20));
		tf1.setEchoChar('*');
		//tf1.setForeground(Color.BLACK);
		//tf1.setOpaque(false);
		//tf1.setFont(new Font("Times New Roman",Font.PLAIN,30));
		lg.add(tf1);
		
		b=new JButton("Login");
		b.setBounds(250,150,100,50);
		b.setForeground(Color.WHITE);
		b.setOpaque(false);
		b.setContentAreaFilled(false);
		b.setFont(new Font("Times New Roman",Font.PLAIN,20));
		lg.add(b);
		
		
		jf=new JFrame("Admin Panel");
		jf.setLayout(null);
		jf.setContentPane(new JLabel(new ImageIcon("img\\Admin.jpg")));
		jf.setIconImage(new ImageIcon("img\\cake.png").getImage());
		jf.setUndecorated(true);
		jf.add(Login);
		jf.add(lg);
		
		b.addMouseListener(this);
		b.addActionListener(this);
		b1.addActionListener(this);
		b1.addMouseListener(this);
		
		jf.setVisible(true);
		jf.setSize(700,500);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(jf.DISPOSE_ON_CLOSE);
		
		
		
	}

	public static void main(String[] args) 
	{
		new GoogleLogin();

	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==b)
		{
			
			
			if(tf.getText().length()==0 || tf1.getText().length()==0)
			{
				JOptionPane.showMessageDialog(null, "Please enter the data");
			}
			else
			{
				
				str=tf.getText();
				s1=tf1.getText();
				new Home();
				jf.dispose();
			}
		}
		
		if(e.getSource()==b1)
		{
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
		Cursor s=new Cursor(Cursor.HAND_CURSOR);
		
		 b1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		 b.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		
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
