
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Random;


/*
 * Purpose : This class is used to represent the initial state of the Monkey Banana Game
 * Pattern : State Pattern
 */

class Start_Class extends State_class
{
		
	State_class sc;
	Random r;
	static int COUNT=0;
	GameStateManager gm;
	JButton start;
	JButton  exit;
	GameStateManager gsm;
	BufferedImage bb=null;
	public Start_Class() 
	{
		
		JFrame fm=new JFrame();
		fm.setTitle("Monkey and Bananas");
		fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fm.setVisible(true);
		
		fm.getContentPane().setBackground(Color.getHSBColor(0.3f, 0.9f,0.5f));
		//setting Background
		ImageIcon grass=new ImageIcon("trees-nature.jpg");
		
		JLabel jl=new JLabel(grass);
		
		JLabel j2=new JLabel("Welcome!!!");
		fm.setContentPane(jl);
		//Initialize buttons
		start=new JButton("Start Eating!!!");
		exit=new JButton("Not Hungry!!!");
		
		start.setBounds(600,250,150,100);
		exit.setBounds(600,375,150,100);
		fm.add(start);
		fm.add(exit);
		sc=respond_to_input(gsm);
		
		// The monkey and Banana Images
	    
		ImageIcon img=new ImageIcon("Dancing_banana.gif-c200");
		JLabel lb=new JLabel(img);
		ImageIcon mnky=new ImageIcon("monkey_cute.gif-c200");
		JLabel lb2=new JLabel(mnky);
		j2.setFont(new Font("Serif",Font.BOLD,32));
		j2.setForeground(Color.YELLOW);
		j2.setBounds(600,100,600,100);
		lb.setBounds(700,300,200,150);
		lb2.setBounds(400,300,200,150);
		fm.add(j2);
		fm.add(lb2);
		fm.add(lb);
		fm.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	
		
	
	
	// The inherited method.
	public State_class respond_to_input(GameStateManager gsm){
	
		start.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Inside button Handler -start");
				gm=new GameStateManager();
				gm.setState(GameStateManager.PLAY);

			}

		});


		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				System.exit(0);
		}}
		);
		return sc;

	}

	// Start point
	public static void main(String args[])
	{	
		new Start_Class();
	}
	
}


