import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class GamePanel  extends JPanel implements ActionListener, KeyListener{
	static final int MENU = 0;
	static final int GAME = 1;
	static final int END = 2;
	int currentState = MENU;
	Font titleFont1 = new Font("Arial", Font.PLAIN, 48);
	Font titleFont2 = new Font("Arial", Font.PLAIN, 20);
	int time = 0;
	Timer frameDraw;
	Rocketship rocket = new Rocketship(250,700,50,50);
	ObjectManager OM = new ObjectManager(rocket);
	
	
	
	GamePanel(){
		frameDraw = new Timer(1000/60,this);
		frameDraw.start();
	}
	
	
	void boundaries() {
		if(OM.rock.x > LeagueInvaders.WIDTH-50) {
			OM.rock.left();
		}
		
		if(OM.rock.x < 50) {
			OM.rock.right();
		}
		
		if(OM.rock.y > LeagueInvaders.HEIGHT-50) {
			OM.rock.up();
		}

		if(OM.rock.y < 50) {
			OM.rock.down();
		}
	}
	
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}
	
	
	
	void updateMenuState() {
		
	}
	
	void updateGameState() {
		OM.update();
	}
	
	void updateEndState() {
		
	}
	
	void drawMenuState(Graphics g) { 
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont1);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 22, 100);
		g.setFont(titleFont2);
		g.drawString("Press ENTER to start", 150, 350);
		g.drawString("Press SPACE for insturctions", 115, 500);
	}
	
	void drawGameState(Graphics g) { 
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		OM.draw(g);
		boundaries();
	}
	
	void drawEndState(Graphics g) { 
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont1);
		g.setColor(Color.YELLOW);
		g.drawString("GAME OVER", 100, 100);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
	
	repaint();

	
	}
	
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } else {
		    	System.out.println("enter");
		        currentState++;
		    }
		}   
		
		if (arg0.getKeyCode()==KeyEvent.VK_UP) {
		    System.out.println("UP");
		    OM.rock.up();
		  
		}
		
		if (arg0.getKeyCode()==KeyEvent.VK_DOWN) {
		    System.out.println("DOWN");
		    OM.rock.down();
		}
		
		if (arg0.getKeyCode()==KeyEvent.VK_LEFT) {
		    System.out.println("LEFT");
		    OM.rock.left();
		}
		
		if (arg0.getKeyCode()==KeyEvent.VK_RIGHT) {
		    System.out.println("RIGHT");
		    OM.rock.right();
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
}
