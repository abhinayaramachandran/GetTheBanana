import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/* Purpose: This class is used to represent the win state of the Monkey Banana Game
 * Pattern : State Pattern
 * 
 */


public class WonState extends State_class{
	
	public GameStateManager gsm;
	JButton start_over;
	JButton  close;
	JLabel msg;
	JPanel jp;
	JFrame jf;
	State_class st;

	public WonState() {
	}
	public State_class show(GameStateManager gm){
		
		jf=new JFrame();
		jf.getContentPane().setBackground(Color.getHSBColor(0.3f, 0.9f,0.5f));
		ImageIcon grass=new ImageIcon("trees-nature.jpg");
		JLabel jl=new JLabel(grass);
		jl.setSize(jf.getWidth(), jf.getHeight());
		jf.setContentPane(jl);
		jf.setTitle("YOU WON");
		
		start_over=new JButton("Play Again!!");
		close=new JButton("Close");
		start_over.setBounds(600,250,150,100);
		close.setBounds(600,375,150,100);
		ImageIcon img=new ImageIcon("Dancing_banana.gif-c200");
		JLabel lb=new JLabel(img);
		ImageIcon mnky=new ImageIcon("success_mon.gif");
		JLabel lb2=new JLabel(mnky);
		msg=new JLabel("Congratulations!!! You Won!!!");
		msg.setBounds(550,100,600,100);
		msg.setForeground(Color.YELLOW);
		msg.setFont(new Font("Serif",Font.BOLD,32));
		lb.setBounds(750,300,200,150);
		lb2.setBounds(400, 300,200 , 150);
		PlayState.ScoreLabel.setLocation(600, 450);
		//music();
		jf.add(lb);
		jf.add(lb2);
		jf.add(msg);
		jf.add(PlayState.ScoreLabel);
		jf.add(start_over);
		jf.add(close);
		jf.setVisible(true);
		st=respond_to_input(gsm);
		jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return st;
			}
	
	
	//The inherited method.
	public State_class respond_to_input(GameStateManager gm){
		start_over.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Inside button Handler -start");
				gsm=new GameStateManager();
				gsm.setState(GameStateManager.PLAY);
				
			}
			
		});
	
	
		close.addActionListener(new ActionListener()

		{public void actionPerformed(ActionEvent e){
			System.exit(0);
		}});
		return st;
	}
	
	}

