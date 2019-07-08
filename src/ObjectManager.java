import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {

	Rocketship rock;
	ArrayList<Projectile> projectiles = new ArrayList <Projectile>();
	ArrayList<Alien> aliens = new ArrayList <Alien>();
	Random random = new Random();
	
	ObjectManager(Rocketship d){
		
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
			if(aliens.get(i).x > LeagueInvaders.WIDTH-50) {
				aliens.get(i).isActive = false;
			}
			
			if(aliens.get(i).x < 50) {
				aliens.get(i).isActive = false;
			}
			
			if(aliens.get(i).y > LeagueInvaders.HEIGHT-50) {
				aliens.get(i).isActive = false;
			}

			if(aliens.get(i).y < 50) {
				aliens.get(i).isActive = false;
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
