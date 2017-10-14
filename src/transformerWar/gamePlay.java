package transformerWar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.io.*;

public class gamePlay {
	
	
	private ArrayList<transformer> fighterList, autobotList, deceptonList;
	private transformer loser, winner;
	boolean tied;
	
	public gamePlay(){
		this.fighterList = new ArrayList<transformer>(); 
		this.autobotList = new ArrayList<transformer>();
		this.deceptonList = new ArrayList<transformer>();
		this.loser=null;
		this.winner=null;
		this.tied = false;
		
	}
	
	
	private ArrayList<transformer> search(ArrayList<transformer> dataList, int searchType, String searchValue) {
		
		ArrayList<transformer> tmplist = new ArrayList<transformer>();
		
				
		for (transformer fighter:dataList) {
			switch(searchType) {
			case 1: 
				if (fighter.getName().equals(searchValue)) {				  
				   tmplist.add(fighter);			  
				};
				break;
			case 2: 
				if (fighter.getFight_type().equals(searchValue)) {				  
					tmplist.add(fighter);			  
				};
				break;	
			case 3: 
				if (fighter.getStrength() ==  Integer.parseInt(searchValue)) {				  
					tmplist.add(fighter);			  
				};
				break;
			case 4: 
				if (fighter.getIntelligence() ==  Integer.parseInt(searchValue)) {
					tmplist.add(fighter);			  
				};	
				break;
			case 5: 
				if (fighter.getSpeed() ==  Integer.parseInt(searchValue)) {
					tmplist.add(fighter);			  
				};	
				break;
			case 6: 
				if (fighter.getEndurance() ==  Integer.parseInt(searchValue)) {
					tmplist.add(fighter);			  
				};	
				break;
			case 7: 
				if (fighter.getRank() ==  Integer.parseInt(searchValue)) {
					tmplist.add(fighter);			  
				};	
				break;
			case 8: 
				if (fighter.getCourage() ==  Integer.parseInt(searchValue)) {
					tmplist.add(fighter);			  
				};	
				break;
			case 9: 
				if (fighter.getFirepower() ==  Integer.parseInt(searchValue)) {
					tmplist.add(fighter);			  
				};	
				break;
			case 10: 
				if (fighter.getSkill() ==  Integer.parseInt(searchValue)) {
					tmplist.add(fighter);			  
				};	
				break;
			
			default: 
				break;
			}	
		}		
		return tmplist;
		
	}
	
	private void addData(){
		
		String[] inputStr = null;			
		String s;
					
		// Input data to fighter database
		
		
		System.out.printf("Please Input the data \n\n");
		try {
			
			BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
			while ((s=buffer.readLine()) != null ) {
				if ("".equals(s)) {
					break;
				} else {
			      inputStr = s.split(",");
			      try {
			           if (valid_data(fighterList,inputStr)) {
			    	 
				          fighterList.add( new transformer(
						    inputStr[0],
						    inputStr[1],
						    Integer.parseInt(inputStr[2]),
						    Integer.parseInt(inputStr[3]),
						    Integer.parseInt(inputStr[4]),
						    Integer.parseInt(inputStr[5]),
						    Integer.parseInt(inputStr[6]),
						    Integer.parseInt(inputStr[7]),		 
						    Integer.parseInt(inputStr[8]),
						    Integer.parseInt(inputStr[9])) );
				          switch (inputStr[1]) {
				    	    case "A": 
				    		   autobotList.add( new transformer(
									 inputStr[0],
									 inputStr[1],
									 Integer.parseInt(inputStr[2]),
									 Integer.parseInt(inputStr[3]),
									 Integer.parseInt(inputStr[4]),
									 Integer.parseInt(inputStr[5]),
									 Integer.parseInt(inputStr[6]),
									 Integer.parseInt(inputStr[7]),		 
									 Integer.parseInt(inputStr[8]),
									 Integer.parseInt(inputStr[9])) );
				    		   break;
				    	     case "D":
				    		    deceptonList.add( new transformer(
									 inputStr[0],
									 inputStr[1],
									 Integer.parseInt(inputStr[2]),
									 Integer.parseInt(inputStr[3]),
									 Integer.parseInt(inputStr[4]),
									 Integer.parseInt(inputStr[5]),
									 Integer.parseInt(inputStr[6]),
									 Integer.parseInt(inputStr[7]),		 
									 Integer.parseInt(inputStr[8]),
									 Integer.parseInt(inputStr[9])) );
				    		    break;
				    	     default:
				          }				          				          
			          } 					     
			     } catch( NumberFormatException e) {
			    	 System.out.println("Invalid Integer value, input the data again");
			     }
				}
				System.out.printf("Please Input Next Data \n\n");
			}
			printout(autobotList,"Autobot");
			printout(deceptonList,"Decepticon");
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			
		    	System.out.println(sw.toString());
		    }

		return ;
	}
	
	private void printout(ArrayList<transformer> datalist, String team) {
		System.out.println("*-----------------------------------------------------*");
		System.out.printf("      Input Data Listing for %10s \n",team);		
		System.out.println("*                                                     *");
		for (transformer f:datalist) {
			System.out.println(f.getName() + "," + f.getFight_type()
			    +","+f.getStrength()+","+f.getIntelligence()+","+f.getSpeed()
			    +","+f.getEndurance()+","+f.getRank()+","+f.getCourage()+","+f.getFirepower()+","+f.getSkill());
		}
		System.out.println("*                                                     *");
		System.out.println("*                                                     *");
		System.out.println("*-----------------------------------------------------*");
	}
	
	private boolean valid_data(ArrayList<transformer> datalist,String[] inputLine) {
		ArrayList<transformer> t = new ArrayList<transformer>();
		
		try {
		if (inputLine[0].trim().equals("")) {
			
	    	System.out.println("Name cannot be blanked !, this line of data is skipped");
	    	return false;
	    }
		
		// check Transformer type "A" or "D"
        if (!(inputLine[1].trim().equals("D")) && !(inputLine[1].trim().equals("A"))) {
        	
        	System.out.println("Type must be either 'A' or 'D' !, this line of data is skipped");
    	    return false;
        }
        
	    // check duplication by name
        
	       t = search(datalist,1,inputLine[0]);		    		 	
           if (t.size() > 0) {
    	      System.out.println("Transformer already existed !, this line of data is skipped");
    	      return false;
           }
	    
    	
        // check Strength
        if (inputLine[2].trim().equals(""))  {
        	
    	    System.out.println("Strength cannot be blank, this line of data is skipped");
    	    return false;
        }	        
        // check Intelligence
        if (inputLine[3].trim().equals(""))  {
        	
    	    System.out.println("Intelligence cannot be blank, this line of data is skipped");
    	    return false;
        }
        // check Speed
        if (inputLine[4].trim().equals(""))  {
        	
    	    System.out.println("Speed cannot be blank, this line of data is skipped");
    	    return false;
        }
        // check Endurance
        if (inputLine[5].trim().equals(""))  {
        	
    	    System.out.println("Endurance cannot be blank, this line of data is skipped");
    	    return false;
        }
        // check Rank
        if (inputLine[6].trim().equals(""))  {
        	
    	    System.out.println("Rank cannot be blank, this line of data is skipped");
    	    return false;
        }
        // check Courage
        if (inputLine[7].trim().equals(""))  {
        	
    	    System.out.println("Courage cannot be blank, this line of data is skipped");
    	    
        }
        // check Firepower
        if (inputLine[8].trim().equals(""))  {
        	
    	    System.out.println("Firepower cannot be blank, this line of data is skipped");
    	    return false;
        }	        
        // check Skill
        if (inputLine[9].trim().equals(""))  {
        	
    	    System.out.println("Skill cannot be blank, this line of data is skipped");
    	    return false;
        }	        
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Input Data incomplete, some fields are missing, try again");
			return false;
		}
		return true;
	}
	
	
	private boolean check_rule_courage_strength(transformer curr, transformer oppo) {
		// check courage and strength
		
		int courage_val = curr.getCourage()-oppo.getCourage();
		int strengthen_val = curr.getStrength()-oppo.getStrength();
		int skill_val = curr.getSkill() - oppo.getSkill();
		
		//System.out.printf("Strength = %d,  Courage = %d \n", strengthen_val,courage_val);
		if (((courage_val >= -4) && (strengthen_val >= -3)) ||  ((courage_val >= 4)  && (strengthen_val >= 3)) ) {		
		    if ((courage_val >= 4) && (strengthen_val >= 3))  {			    
			    winner = curr;
			    loser = oppo;
			    tied = false;
			    
		    } 
		    if ((courage_val >= -4) && (strengthen_val >= -3))  {			    
			    winner = oppo;
			    loser = curr;
			    tied = false;
			   
		    }	
		    
		} else {   		    	
			if (Math.abs(skill_val) >= 3) { 
		      if (curr.getSkill() > oppo.getSkill()) {					  		    	  
		    	  winner = curr;
		    	  loser = oppo ;
		    	  tied = false;
		    	  System.out.println("point3");
		    	 
		      } else {				      		  		    	  
		    	  winner = oppo;
		    	  loser = oppo;
		    	  tied = false;
		    	  System.out.println("point4");
		    	 
			  } 
		    } else {			     
			   if (curr.overall() == oppo.overall()) {
				   winner = null;
				   loser = null;
				   tied = true;
				   System.out.println("point5");
				   return false;
				   
			   } else {
				   if (curr.overall() > oppo.overall()) {
					   loser = oppo;
					   winner = curr;					   
					   tied = false;
					   System.out.println("point6");
					   
				   } else {
					   loser = curr;
					   winner = oppo;
					   tied = false;
					   System.out.println("point7");
					  
				   }
			   }
		    }
		  }
		
		
		 if (!tied) {
			 display_result();			 
	     } 		 
		 return true;
	}
	
	private void display_result() {
		String loser_team;
		StringBuilder alist = new StringBuilder() ;
		
	    System.out.printf("    Winning Team (");		 
        if (winner.getFight_type().equals("A")){			   
	        System.out.printf("Autobots) : ");
	        loser_team = "Decepticons" ;
        } else {			   
	        System.out.printf("Decepticons) : ");
	        loser_team = "Autobots" ;
        }
        System.out.printf("%s \n",winner.getName());		
    
        System.out.println("*                                                     *");
        if (winner.getFight_type().equals("A")){	
           for (int i=1; i<deceptonList.size(); i++){
			  alist.append(deceptonList.get(i).getName());
			  if (i < deceptonList.size()-1) {
			     alist.append(",");
		      }
           }           
        } else {
        	for (int i=1; i<autobotList.size(); i++){
  			  alist.append(autobotList.get(i).getName());
  			  if (i < autobotList.size()-1) {
  			     alist.append(",");
  		      }
             }
        }
        if (alist.length() > 0) {
            System.out.printf("Survivors from the losing team (%10s) : %s\n", loser_team, alist.toString() );        
  	        System.out.println("*                                                     *");				             
        }
        
	    System.out.println("*-----------------------------------------------------*");
	}
	
	private void check_special_rule(transformer curr, transformer oppo) {		
		String[] res = {"Optimus Prime","Predaking" };
		boolean case1 = Arrays.asList(res).contains(curr.getName());
		boolean case2 = Arrays.asList(res).contains(oppo.getName());
		
		if (((case1 && case2)) && (curr.getName().equals(oppo.getName()))) {
				loser = null;
				winner = null;
				tied = true;						
				System.out.println("*----------------------------------------------------*");
				System.out.println(" Battle terminated due to duplication of each other! ");
				System.out.println("*----------------------------------------------------*");
		} else {
			if (!case1 && !case2) {				
				if (!check_rule_courage_strength(autobotList.get(0),deceptonList.get(0))) {
					System.out.println("*----------------------------------------------------*");
					System.out.println(" Battle Ended where both side are destroyed! ");
					System.out.println("*----------------------------------------------------*");
					
				};
				return;
			}
		    if (case1 && !case2) {
				loser = oppo;
				winner = curr;
				display_result();
		    } else {
				if (!case1 && case2) {
					loser = curr;
					winner = oppo;
					tied = false;
                    display_result();
				} 
		    }
		}
		
	}
	
	private boolean eligible_for_play()
	{
		
		if ((autobotList.size() == 0) || (deceptonList.size() == 0)){
			System.out.println("*---------------------------------------------------------------------*");
			System.out.println("*                                                                     *");
			System.out.println("*   Battle terminated due to Only One team show up                    *");
			System.out.println("*                                                                     *");
		    System.out.println("*---------------------------------------------------------------------*");
			return false;
		} else {
		// sorting by rank in descending order, player with highest rank will get into the battle
		   Collections.sort(
			                autobotList,
			                (auto1, auto2) -> auto2.getRank()
			                        - auto1.getRank());
					
		   Collections.sort(
			                deceptonList,
			                (decep1, decep2) -> decep2.getRank()
			                        - decep1.getRank());
		
		
		  System.out.println("*--------------------------------------------------------------------*");
		  System.out.println("*                     Player for the battle                          *");		
		  System.out.println("*                                                                    *");
		  System.out.printf("    %10s  of Autobot VS  %10s of Decepticon \n",autobotList.get(0).getName(),
				  deceptonList.get(0).getName());
	      System.out.println("*                                                                    *");
		  System.out.println("*                                                                    *");
		  System.out.println("*--------------------------------------------------------------------*");
		  return true;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		gamePlay battle = new gamePlay();
		battle.runBattle();
		
		
	}
	
	private void runBattle() {
		
		
		addData();
		
		if (!eligible_for_play()) {
			return;
		};
		
		System.out.println("*-----------------------------------------------------*");
		System.out.println("*      Result for the battle                          *");		
	    System.out.println("*                                                     *");
	    
		check_special_rule(autobotList.get(0),deceptonList.get(0));			
		   		   					  
		   	
	}
}
