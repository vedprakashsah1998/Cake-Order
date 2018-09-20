import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.CannotRealizeException;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Port;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.jdbc.log.Log;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import marytts.modules.synthesis.Voice;

public class Admin_Login implements ActionListener, MouseListener {

	JFrame jf;
	JTextField tf;
	JPasswordField tf1;
	JButton b, b1;
	JLabel l1, l2, l3;
	
	TextToSpeech textToSpeech	= new TextToSpeech();
	
	private Logger logger = Logger.getLogger(getClass().getName());

	// Variables
	private String result;

	// Threads
	Thread	speechThread;
	Thread	resourcesThread;

	// LiveRecognizer
	private LiveSpeechRecognizer recognizer;
	
	private volatile boolean recognizerStopped = true;

	public Admin_Login() {
		// header
		JPanel Login = new JPanel();
		Login.setLayout(null);
		Login.setBackground(new Color(0, 0, 0, 80));
		Login.setBounds(0, 0, 700, 70);

		l1 = new JLabel("Admin Panel");
		l1.setBounds(260, 5, 400, 60);
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Serif", Font.BOLD, 30));
		Login.add(l1);

		Login.add(b1 = new JButton(new ImageIcon("img\\close.png")));
		b1.setBounds(670, 10, 16, 16);
		b1.setOpaque(false);
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);

		// login
		JPanel lg = new JPanel();
		lg.setBackground(new Color(0, 0, 0, 120));
		lg.setLayout(null);
		lg.setBounds(110, 150, 420, 230);

		l2 = new JLabel("Email Id: ");
		l2.setForeground(Color.WHITE);
		l2.setBounds(30, 40, 120, 30);
		l2.setFont(new Font("Serif", Font.BOLD, 25));
		lg.add(l2);

		tf = new JTextField();
		tf.setBounds(160, 40, 200, 30);
		tf.setForeground(Color.WHITE);
		tf.setOpaque(false);
		tf.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lg.add(tf);

		l2 = new JLabel("Password:");
		l2.setForeground(Color.WHITE);
		l2.setBounds(30, 100, 120, 30);
		l2.setFont(new Font("Serif", Font.BOLD, 25));
		lg.add(l2);

		tf1 = new JPasswordField();
		tf1.setBounds(160, 100, 200, 30);
		tf1.setForeground(Color.WHITE);
		tf1.setOpaque(false);
		tf1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tf1.setEchoChar('*');
		// tf1.setForeground(Color.BLACK);
		// tf1.setOpaque(false);
		// tf1.setFont(new Font("Times New Roman",Font.PLAIN,30));
		lg.add(tf1);

		b = new JButton("Login");
		b.setBounds(250, 150, 100, 50);
		b.setForeground(Color.WHITE);
		b.setOpaque(false);
		b.setContentAreaFilled(false);
		b.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lg.add(b);

		jf = new JFrame("Admin Panel");
		jf.setLayout(null);
		jf.setContentPane(new JLabel(new ImageIcon("img\\Admin.jpg")));
		jf.setIconImage(new ImageIcon("img\\cake.png").getImage());
		jf.setUndecorated(true);
		jf.add(Login);
		jf.add(lg);
		
		
		logger.log(Level.INFO, "Loading..\n");

		// Configuration
		Configuration configuration = new Configuration();

		// Load model from the jar
		configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");

		// if you want to use LanguageModelPath disable the 3 lines after which
		// are setting a custom grammar->

		// configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin")

		// Grammar
		configuration.setGrammarPath("resource:/grammers");
		configuration.setGrammarName("grammar");
		configuration.setUseGrammar(true);

		try {
			recognizer = new LiveSpeechRecognizer(configuration);
		} catch (IOException ex) {
			logger.log(Level.SEVERE, null, ex);
		}
		
		Voice.getAvailableVoices().stream().forEach(voice -> System.out.println("Voice: " + voice));
		textToSpeech.setVoice("cmu-slt-hsmm");
		//textToSpeech.setVoice("dfki-poppy-hsmm");
		//textToSpeech.setVoice("cmu-rms-hsmm");


		// Start recognition process pruning previously cached data.
		recognizer.startRecognition(true);

		// Start the Thread
		//startSpeechThread();
		startResourcesThread();

		b.addMouseListener(this);
		b.addActionListener(this);
		b1.addActionListener(this);
		b1.addMouseListener(this);

		jf.setVisible(true);
		jf.setSize(700, 500);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new Admin_Login();

	}
	
	
	protected void startResourcesThread() {

		// alive?
		if (resourcesThread != null && resourcesThread.isAlive())
			return;

		resourcesThread = new Thread(() -> {
			try {

				// Detect if the microphone is available
				while (true) {
					if (AudioSystem.isLineSupported(Port.Info.MICROPHONE)) {
						// logger.log(Level.INFO, "Microphone is available.\n")
					} else {
						// logger.log(Level.INFO, "Microphone is not
						// available.\n")

					}

					// Sleep some period
					Thread.sleep(350);
				}

			} catch (InterruptedException ex) {
				logger.log(Level.WARNING, null, ex);
				resourcesThread.interrupt();
			}
		});

		// Start
		resourcesThread.start();
	}
	
	
//	protected void startSpeechThread() {
//
//		// alive?
//		if (speechThread != null && speechThread.isAlive())
//			return;
//
//		// initialise
//		speechThread = new Thread(() -> {
////			String str="Welcome To 5th Generation Computer";
////			l1.setText(str);
////			textToSpeech.speak(str, 1.5f, false, true);
//			
//			//System.out.println(str);
//			
//			logger.log(Level.INFO, "You can start to speak...\n");
//			//textToSpeech.speak("Voice command is active", 1.5f, false, true);
//			try {
//				while (true) {
//					/*
//					 * This method will return when the end of speech is
//					 * reached. Note that the end pointer will determine the end
//					 * of speech.
//					 */
//					SpeechResult speechResult = recognizer.getResult();
//					if (speechResult != null) {
//
//						result = speechResult.getHypothesis();
//						System.out.println("You said: [" + result + "]\n");
//						
//						
//						// logger.log(Level.INFO, "You said: " + result + "\n")
//
//					} else
//						logger.log(Level.INFO, "I can't understand what you said.\n");
//				
//				}
//			} catch (Exception ex) {
//				logger.log(Level.WARNING, null, ex);
//			}
//
//			logger.log(Level.INFO, "SpeechThread has exited...");
//		});
//
//		// Start
//		speechThread.start();
//
//	}
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cake", "root", "password");
		} catch (Exception ex) {}
		if (e.getSource() == b1)
		{
			jf.dispose();
		}
		if (e.getSource() == b) 
		{
			try {
				java.sql.PreparedStatement ps = con.prepareStatement("select * from admin where email=? and password=?");
				ps.setString(1, tf.getText());
				ps.setString(2, tf1.getText());
				ResultSet rs = ps.executeQuery();
				if (rs.next() == true) {
					// JOptionPane.showMessageDialog(null, "Successfully Login: ");
					new Admin_Panel();
					jf.dispose();
				} else {
					//JOptionPane.showMessageDialog(null, "Invalid User name or Password: ");
					textToSpeech.speak("Invalid!!,. Password!.. Please,., enter,.,. valid password!!,.,", 1.5f,false, true);
					
					// System.out.println("Invalid User name or Password");
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
			if (tf.getText().length() == 0 || tf1.getText().length()==0) 
			{
				b.disable();
				/*JOptionPane.showMessageDialog(null, "Please enter your details", "Alert",
						JOptionPane.INFORMATION_MESSAGE);*/
				textToSpeech.speak("Please Enter your Detail", 1.5f,false, true);
			}
			
//			new Admin_Panel();
//			jf.dispose();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		Cursor s = new Cursor(Cursor.HAND_CURSOR);

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
