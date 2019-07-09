import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {

	Rocketship rock;
	ArrayList<Projectile> projectiles = new ArrayList <Projectile>();
	ArrayList<Alien> aliens = new ArrayList <Alien>();
	Random random = new Random();
	
	ObjectManager(Rocketship d){
		d = new Rocketship(250,700,50,50);
		rock = d;
	}
	
	
	void addProjectile(Projectile p){
		projectiles.add(p);
	}
	
	
	
	void addAlien(Alien a) {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
	}
	
	
	
	void update() {
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
				
			if (aliens.get(i).y > LeagueInvaders.HEIGHT || aliens.get(i).y < 0) {
					aliens.get(i).isActive = false;	
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
	
	
	
	
	void draw (Graphics g) {
		rock.draw(g);
		
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}
		
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
	}
	
	
	
	
	
	
	
	
	
}
