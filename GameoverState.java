

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
/*
 * Purpose :This class is used to represent the game over state of the Monkey Banana Game
 * Pattern : State Pattern
 */

public class GameoverState extends State_class{

		
	JButton start_over;
	JButton  close;
	JFrame fr;
	State_class st;
	public GameStateManager gsm;
	public GameoverState() {}
	public State_class show(GameStateManager gm){
		fr=new JFrame();
		fr.getContentPane().setBackground(Color.getHSBColor(0.3f, 0.9f,0.5f));
		ImageIcon grass=new ImageIcon("trees-nature.jpg");
		JLabel jl=new JLabel(grass);
		JLabel j2=new JLabel();
		jl.setSize(fr.getWidth(), fr.getHeight());
		fr.setContentPane(jl);
		fr.setTitle("GAME OVER");
		j2.setFont(new Font("Serif",Font.BOLD,32));
		j2.setText("Time Up!!! Game Over!");
		j2.setForeground(Color.YELLOW);
		j2.setBounds(600,100,600,100);
		start_over=new JButton("Play Again!!");
		close=new JButton("Close");
		start_over.setBounds(600,250,150,100);
		close.setBounds(600,375,150,100);
		ImageIcon img=new ImageIcon("Happy_Bananas.gif");
		JLabel lb=new JLabel(img);
		ImageIcon mnky=new ImageIcon("crying_monkey.gif-c200");
		JLabel lb2=new JLabel(mnky);
		lb.setBounds(750,300,200,150);
		lb2.setBounds(400, 300,200 , 150);
		fr.add(lb);
		fr.add(lb2);
	    PlayState.ScoreLabel.setLocation(600, 450); 
	    fr.add(PlayState.ScoreLabel);
	    fr.add(start_over);
	    fr.add(close);
	    fr.add(j2);
	    fr.setVisible(true);
		st=respond_to_input(gsm);
		fr.setExtendedState(JFrame.MAXIMIZED_BOTH);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return st;
		
	}
	
	// The inherited method.
	public State_class  respond_to_input(GameStateManager gm){
		
		start_over.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Inside button Handler -start");
				gsm=new GameStateManager();
				gsm.setState(GameStateManager.PLAY);
		}
			
		});
	
		//Listener for exit button
		close.addActionListener(new ActionListener()

		{
			public void actionPerformed(ActionEvent e){
			System.exit(0);
		}});
return st;
	}

	
}
