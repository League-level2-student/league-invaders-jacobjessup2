import javax.swing.*;

public class LeagueInvaders {
	JFrame frame;
	
	
	final int width = 500;
	final int height = 800;
	
	
	
	public static void main(String[] args) {
		LeagueInvaders e = new LeagueInvaders();
		e.setup();
	}
	
	LeagueInvaders(){
		frame = new JFrame();
	}
	
	void setup() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(width, height);
	}
	
	 
	
	
	
	
}
