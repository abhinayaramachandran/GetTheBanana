import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;


/*
 * Purpose: This class is used to represent the play state of the Monkey Banana Game
 * Pattern : State Pattern
 * */
public class PlayState extends State_class{
    
	private boolean inGame=false;
	private static int time_rem;
	int num_bananas=0;
	int total_bananas=15;
	JLabel lb;
	JLabel lb2;
	public static JLabel ScoreLabel;
	JLabel time_remaining;
	JLabel info;
	ImageIcon img;
	ImageIcon mnky;
	public int x=100;
	public int y=100;
	public int x_banana=100;
	public int y_banana=100;


	private boolean leftDirection = false;
    private boolean rightDirection = false;
    private boolean upDirection = false;
    private boolean downDirection = false;
    Timer timer, timer2;
    JFrame jf;
    State_class sc;
    GameStateManager gsm;
    
    
	//JPanel jp;
	public PlayState() {
		super();
		System.out.println("Inside playstate constructor");
	}
	public State_class show(GameStateManager gm){
		jf=new JFrame();
		time_rem=90;
		jf.setLayout(new GridLayout(7,7));//7*7= 49 squares
	    jf.addKeyListener(new TAdapter());
	    jf.setTitle("Eat the bananas!!");
	    jf.getContentPane().setBackground(Color.getHSBColor(0.3f, 0.9f,0.5f));
		init();
		//ImageIcon grass=new ImageIcon("greengrass.jpg");
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
		img=new ImageIcon("Dancing_banana.gif-c200");
		lb=new JLabel(img);
		mnky=new ImageIcon("monkey_cute.gif-c200");
		lb2=new JLabel(mnky);
		jf.add(lb2);
		jf.add(lb);
		return sc;
		
		
	}
	
	public void init()
	{
		inGame=true;
		time_remaining=new JLabel();
		time_remaining.setForeground(Color.WHITE);
		ScoreLabel=new JLabel("Score =  0");
		ScoreLabel.setForeground(Color.YELLOW);
		ScoreLabel.setFont(new Font("Serif", Font.BOLD, 32));
		ScoreLabel.setLocation(10, 500);
		jf.add(ScoreLabel);
		//add(time_remaining);
		sc=show_banana(gsm);
		
	}
	
	// The inherited method show_banana is used to to display the banana once every two seconds.
	public State_class show_banana(GameStateManager gsm)
	{
		if(num_bananas<total_bananas)
		{
			
			System.out.println("Inside show banana");
			timer=new Timer(2000,new My_ActionListener());
			timer.start();
		
			}
		return sc;	
	}	
	
	
	private class TAdapter extends KeyAdapter {
		
		// The handler for key board input

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
                rightDirection=false;
                System.out.println("Left");
               
            }

            if ((key == KeyEvent.VK_RIGHT)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
                leftDirection=false;
                System.out.println("Right");
                
            }

            if ((key == KeyEvent.VK_UP)) {
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
                downDirection=false;
                System.out.println("Up");
            }

            if ((key == KeyEvent.VK_DOWN)) {
                downDirection = true;
                rightDirection = false;
                leftDirection = false;
                upDirection=false;
                System.out.println("Down");
            }
            sc=move(gsm);
            check_banana();
        }
    }



	public void actionPerformed(ActionEvent arg0) {

		        if (inGame) {
		            
		            sc=move(gsm);
		            check_banana();
		        }

		        
		    }
	
	// The inherited method move() is used to move the monkey on the grid
	 public State_class move(GameStateManager gsm) {
		 
		 int height=jf.getHeight();
		 int width=jf.getWidth();
	        if(num_bananas<total_bananas){
	        if (leftDirection) {
	            x=(x-10)%(width-150);
	        }

	        if (rightDirection) {
	            x=(x+10)%(width-150);
	        }

	        if (upDirection) {
	            y=(y-10)%(height-150);
	        }

	        if (downDirection) {
	            y=(y+10)%(height-150);
	        }
	        lb2.setLocation(x,y);}
	        
	        return sc;
	    }
	 
	 private void check_banana()
	 {

		 if(Math.abs(x-x_banana)<30&& Math.abs(y-y_banana)<30){
			 if (num_bananas<total_bananas)
			 num_bananas++;
			 ScoreLabel.setText("Score  =  "+ Integer.toString(num_bananas));
			  System.out.println("One eaten!!!!!!!!!!!!");
		 }
		 else
			 System.out.println("Not eaten");
	 }
	 

	 
	 
	 class My_ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			
			if(num_bananas<total_bananas){
				Random r=new Random();
				x_banana=r.nextInt(jf.getWidth()-300);
				y_banana=r.nextInt(jf.getHeight()-300);
				lb.setLocation(x_banana,y_banana);
				time_rem=time_rem-2;
				//time_remaining.setText("Time remaining = "+Integer.toString(time_rem));
				}
				else {
					System.out.println("You Won!!!");
					timer.stop();
				    gsm=new GameStateManager();
				    gsm.setState(GameStateManager.WON);
				}
				if(time_rem<=0){
					System.out.println("Time up!!!");
					timer.stop();
					gsm=new GameStateManager();
					gsm.setState(GameStateManager.GAMEOVER);
				}
			
		}
	 }



	
	
}




