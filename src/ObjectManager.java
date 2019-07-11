import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener{

	Rocketship rock;
	ArrayList<Projectile> projectiles = new ArrayList <Projectile>();
	ArrayList<Alien> aliens = new ArrayList <Alien>();
	Random random = new Random();
	int score = 0;
	
	ObjectManager(Rocketship d){
		d = new Rocketship(250,700,50,50);
		rock = d;
	}
	
	
	void addProjectile(Projectile p){
		projectiles.add(p);
	}
	
	
	
	void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH-50),0,50,50));
	}
	
	
	
	void update() {
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
				
			if (aliens.get(i).y > LeagueInvaders.HEIGHT || aliens.get(i).y < 0) {
					aliens.get(i).isActive = false;	
			}
			rock.update();
		}
		
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
				
			if (projectiles.get(i).y > LeagueInvaders.HEIGHT || projectiles.get(i).y < 0) {
					projectiles.get(i).isActive = false;	
			}
			
		}
		
		checkCollision();
		purgeObjects();
	}
	
	
	
	void checkCollision() {
		for (int i = 0; i < aliens.size(); i++) {
			if(rock.collisionBox.intersects(aliens.get(i).collisionBox)) {
				rock.isActive = false;
			}
			for (int j = 0; j < projectiles.size(); j++) {
				
			
				if(aliens.get(i).collisionBox.intersects(projectiles.get(j).collisionBox)) {
				aliens.get(i).isActive = false;
				projectiles.get(j).isActive = false;
				score++;
				}
			}
		}
	
		
	
	
	}
	
	
	void purgeObjects() {
		
		for (int i = 0; i < aliens.size(); i++) {
			if (aliens.get(i).isActive == false) {
				aliens.remove(i);
			}
		}
		
		for (int i = 0; i < projectiles.size(); i++) {
			if (projectiles.get(i).isActive == false) {
				projectiles.remove(i);
			}
		}
		
	}
	
	
	int getScore() {
		return score;
	}
	
	
	
	
	void draw (Graphics g) {
		rock.draw(g);
		
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}
		
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
	}
	
	
	
	
	
	
	
	
	
}
