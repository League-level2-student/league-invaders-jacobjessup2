import javax.swing.*;

public class LeagueInvaders {
	JFrame frame = new JFrame();
	
	GamePanel gpanel = new GamePanel();
	
	static final int WIDTH = 500;
	static final int HEIGHT = 800;
	
	
	
		
	
	
	
	public static void main(String[] args) {
		LeagueInvaders e = new LeagueInvaders();
		e.setup();
	}
	
	
	
	
	void setup() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(WIDTH, HEIGHT);
		frame.add(gpanel);
		frame.addKeyListener(gpanel);
	}
	
	 
	
	
	
	
}
