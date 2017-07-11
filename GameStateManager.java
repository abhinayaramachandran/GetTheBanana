/*
 * Purpose: This class is the context class used to change states.
 * Pattern: State Pattern
 * */
public class GameStateManager {
	
	State_class st[]={new PlayState(),new GameoverState(),new WonState()};
	public static int PLAY=0;
	public static int GAMEOVER=1;
	public static int WON=2;
	
	public void setState(int state){
	st[state].show(this);
	}
	public void respond_to_input() {}
	public void show_banana() {}
	public void move() {}
	public void show(){}

}
