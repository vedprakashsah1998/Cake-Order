import java.awt.Color;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
public class Splash_Screen
{
	static JFrame jf;
	static JProgressBar jp;	
	Splash_Screen() 
	 {	 
	  jf=new JFrame("Cake Ordering System");
	  jf.setUndecorated(true);
	  jf.setLayout(null);
	  jf.setContentPane(new JLabel(new ImageIcon("img\\Cake.jpg")));
	  jf.setIconImage(new ImageIcon("img\\cake.png").getImage());
      jf.add(jp=new JProgressBar());
      jp.setForeground(Color.BLACK);
	  jp.setBounds(0, 400, 270, 10);     
      jp.setStringPainted(true);	
      jp.setOpaque(false);
      //jp.setContentAreaFilled(false);
      jp.setBorderPainted(false);   
      jf.setResizable(false);
	  jf.setSize(650,430);
      jf.setVisible(true);
	  jf.setDefaultCloseOperation(3);
	  jf.setLocationRelativeTo(null);		 
 	 }	
	
	public static void main(String[] args) throws IOException, URISyntaxException
	{			new Splash_Screen();
			      for(int i=0;i<=100;i++)
			      {  try 
			    	  {
			    		   jp.setValue(i);
			    	       Thread.sleep(10);
			    	      
			    	  }catch(Exception ex){}
			      }
			      new Choose();
			      jf.dispose();
	    	       
	}

}
