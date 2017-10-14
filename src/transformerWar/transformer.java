package transformerWar;

import java.lang.*;
import java.util.*;


public class transformer {
	
	    private String name;
	    private String fight_type; // A - AutoBots  D - Deceptcons
		private int strength;
		private int intelligence;
		private int speed;
		private int endurance;
		private int rank;
		private int courage;
		private int firepower;
		private int skill;
		
	
		public transformer(
				String p_name,
				String p_fight_type,
				int p_strength,
				int p_intelligence, 
				int p_speed, 
				int p_endurance, 
				int p_rank, 
				int p_courage,
				int p_firepower, 
				int p_skill ){
			this.name = p_name;
			this.fight_type = p_fight_type;
			this.strength = p_strength;
			this.intelligence = p_intelligence;
			this.speed = p_speed;
			this.endurance = p_endurance;
			this.rank = p_rank;
			this.courage = p_courage;
			this.firepower = p_firepower;
			this.skill = p_skill;
			
					
		}	

		public String getName() {
			return name;
		}
		public String getFight_type() {
			return fight_type;
		}
		public int getStrength() {
			return strength;
		}
		public int getIntelligence() {
			return intelligence;		
		}
		public int getSpeed() {
			return speed;
		}
		public int getEndurance() {
			return endurance;
		}
		public int getRank() {
			return rank;
		}
		public int getCourage() {
			return courage;
		}
		public int getFirepower() {
			return firepower;
		}
		public int getSkill() {
			return skill;
		}
		
		public void setName(String p_name) {
			this.name = p_name;
		}
		
		public void setFight_type(String p_fight_type) {
			this.fight_type = p_fight_type;
		}
		public void setStrength(int p_strength) {
			this.strength = p_strength;
		}
		
		public void setIntelligence(int p_intelligence) {
			this.intelligence = p_intelligence;
		}
		
		public void setSpeed(int p_speed) {
			this.speed = p_speed;
		}
		
		public void setEndurance(int p_endurance) {
			this.endurance = p_endurance;
		}
		
		public void setRank(int p_rank) {
			this.rank = p_rank;
		}
		
		public void setCourage(int p_courage) {
			this.courage = p_courage;
		}
		
		public void setFirepower(int p_firepower) {
			this.firepower = p_firepower;
		}
		
		public void setSkill(int p_skill) {
			this.skill = p_skill;
		}
		
		
		public int overall() {	
			return this.getStrength() + this.getIntelligence() + this.getSpeed() + this.getEndurance() + this.getFirepower();
		}
		
		
}
