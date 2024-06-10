import java.io.File;													//import the library
import java.util.ArrayList;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class Level {
	
	private int level;													//define level as an integer to store current level
	private int complete;												//define complete as an integer to store completion
	private int sequence;												//define sequence as an integer to store blink sequence
	private int levelFactor;											//define levelFactor as an integer for updating score
	private ArrayList<Integer> patterns;								//define patterns as an integer array to store level's pattern
	
	public Level() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	Level class constructor
		*
		* Method parameters		:	none
		*
		* Method return			:	Level
		*
		* Synopsis				:	This method creates Level object with initial data members and methods for game mechanics.
		* 
		* References			:	Audio files obtained from freesound.org library that has CC0 license.
		*								Fupicat. (n.d.) Gamey game Sounds Correct Bell. Retrieved May 8, 2023, 
		*								from https://freesound.org/people/Fupicat/sounds/538147/
		*								-Andreas. (n.d.) Default Wrong Answer. Retrieved May 8, 2023, 
		*								https://freesound.org/people/-Andreas/sounds/648462/								
		*								JarredGibb. (n.d.) Household Button 04.wav. Retrieved May 8, 2023, 
		*								from https://freesound.org/people/JarredGibb/sounds/219477/
		* 
		* Modifications			:
		*							Date			Developer				Notes
		*							----			---------				-----
		*							2023-04-29		W. Poomarin				Build UI layout
		*							2023-05-03		W. Poomarin				Finish first programming
		*							2023-05-05		W. Poomarin				Add button HiLight when clicked
		*							2023-05-07		W. Poomarin				Move calculation methods to Level class
		*							2023-05-08		W. Poomarin				Add sounds
		*							2023-05-09		W. Poomarin				Move buttons display methods and sound to Game class
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */
		
		this.level =1;													//set level data member = 1
		this.complete = 0;												//set complete data member = 0
		this.sequence = -1;												//set sequence data member = -1
		this.levelFactor = 1;											//set levelFactor data member = 1
		this.patterns = new ArrayList<Integer>();						//instantiate patterns as a new Integer array

	}
	

	
	public void levelUp() {
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void levelUp
		*
		* Method parameters		:	none
		*
		* Method return			:	void
		*
		* Synopsis				:	This method sets the data member: level = level + 1
		* 
		* Modifications			:
		*							Date			Developer				Notes
		*							----			---------				-----
		*							2023-04-29		W. Poomarin				Build UI layout
		*							2023-05-03		W. Poomarin				Finish first programming
		*							2023-05-05		W. Poomarin				Add button HiLight when clicked
		*							2023-05-07		W. Poomarin				Move calculation methods to Level class
		*							2023-05-08		W. Poomarin				Add sounds
		*							2023-05-09		W. Poomarin				Move buttons display methods and sound to Game class
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */
		this.level = this.level + 1;									//set level = level + 1
	}
	
	public int getLevel() {
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	int getLevel
		*
		* Method parameters		:	none
		*
		* Method return			:	int
		*
		* Synopsis				:	This method returns an integer data member: level as an integer
		* 
		* Modifications			:
		*							Date			Developer				Notes
		*							----			---------				-----
		*							2023-04-29		W. Poomarin				Build UI layout
		*							2023-05-03		W. Poomarin				Finish first programming
		*							2023-05-05		W. Poomarin				Add button HiLight when clicked
		*							2023-05-07		W. Poomarin				Move calculation methods to Level class
		*							2023-05-08		W. Poomarin				Add sounds
		*							2023-05-09		W. Poomarin				Move buttons display methods and sound to Game class
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */
		return this.level;												//return level as an integer
	}
	
	
	public String getLevelString() {
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	String getLevelString
		*
		* Method parameters		:	none
		*
		* Method return			:	String
		*
		* Synopsis				:	This method returns a string data member: level as a string
		* 
		* Modifications			:
		*							Date			Developer				Notes
		*							----			---------				-----
		*							2023-04-29		W. Poomarin				Build UI layout
		*							2023-05-03		W. Poomarin				Finish first programming
		*							2023-05-05		W. Poomarin				Add button HiLight when clicked
		*							2023-05-07		W. Poomarin				Move calculation methods to Level class
		*							2023-05-08		W. Poomarin				Add sounds
		*							2023-05-09		W. Poomarin				Move buttons display methods and sound to Game class
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */
		return String.valueOf(this.level);								//return level as a string
	}
	
	public void completeUP() {
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void completeUP
		*
		* Method parameters		:	none
		*
		* Method return			:	void
		*
		* Synopsis				:	This method sets the data member: complete = complete + 1
		* 
		* Modifications			:
		*							Date			Developer				Notes
		*							----			---------				-----
		*							2023-04-29		W. Poomarin				Build UI layout
		*							2023-05-03		W. Poomarin				Finish first programming
		*							2023-05-05		W. Poomarin				Add button HiLight when clicked
		*							2023-05-07		W. Poomarin				Move calculation methods to Level class
		*							2023-05-08		W. Poomarin				Add sounds
		*							2023-05-09		W. Poomarin				Move buttons display methods and sound to Game class
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */
		this.complete = this.complete + 1;								//set complete = complete + 1
	}
	
	public void resetComplete() {
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void completeUP
		*
		* Method parameters		:	none
		*
		* Method return			:	void
		*
		* Synopsis				:	This method sets the data member: complete = 0
		* 
		* Modifications			:
		*							Date			Developer				Notes
		*							----			---------				-----
		*							2023-04-29		W. Poomarin				Build UI layout
		*							2023-05-03		W. Poomarin				Finish first programming
		*							2023-05-05		W. Poomarin				Add button HiLight when clicked
		*							2023-05-07		W. Poomarin				Move calculation methods to Level class
		*							2023-05-08		W. Poomarin				Add sounds
		*							2023-05-09		W. Poomarin				Move buttons display methods and sound to Game class
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */
		this.complete = 0;												//set complete = 0
	}
	
	public int getComplete() {
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	int getComplete
		*
		* Method parameters		:	none
		*
		* Method return			:	int
		*
		* Synopsis				:	This method returns the data member: complete as an integer
		* 
		* Modifications			:
		*							Date			Developer				Notes
		*							----			---------				-----
		*							2023-04-29		W. Poomarin				Build UI layout
		*							2023-05-03		W. Poomarin				Finish first programming
		*							2023-05-05		W. Poomarin				Add button HiLight when clicked
		*							2023-05-07		W. Poomarin				Move calculation methods to Level class
		*							2023-05-08		W. Poomarin				Add sounds
		*							2023-05-09		W. Poomarin				Move buttons display methods and sound to Game class
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */
		return this.complete;											//return complete as an integer
	}
	
	public String getCompleteString() {
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	String getCompleteString
		*
		* Method parameters		:	none
		*
		* Method return			:	String
		*
		* Synopsis				:	This method returns the data member: complete as a String
		* 
		* Modifications			:
		*							Date			Developer				Notes
		*							----			---------				-----
		*							2023-04-29		W. Poomarin				Build UI layout
		*							2023-05-03		W. Poomarin				Finish first programming
		*							2023-05-05		W. Poomarin				Add button HiLight when clicked
		*							2023-05-07		W. Poomarin				Move calculation methods to Level class
		*							2023-05-08		W. Poomarin				Add sounds
		*							2023-05-09		W. Poomarin				Move buttons display methods and sound to Game class
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */		
		return String.valueOf(this.complete);							//return complete as a String
	}
	
	public void resetSequence() {
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void resetSequence
		*
		* Method parameters		:	none
		*
		* Method return			:	void
		*
		* Synopsis				:	This method sets the data member: sequence = -1
		* 
		* Modifications			:
		*							Date			Developer				Notes
		*							----			---------				-----
		*							2023-04-29		W. Poomarin				Build UI layout
		*							2023-05-03		W. Poomarin				Finish first programming
		*							2023-05-05		W. Poomarin				Add button HiLight when clicked
		*							2023-05-07		W. Poomarin				Move calculation methods to Level class
		*							2023-05-08		W. Poomarin				Add sounds
		*							2023-05-09		W. Poomarin				Move buttons display methods and sound to Game class
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */			
		this.sequence = -1;												//set sequence = -1
	}
	
	public void addSequence() {
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void addSequence
		*
		* Method parameters		:	none
		*
		* Method return			:	void
		*
		* Synopsis				:	This method sets the data member: sequence = sequence + 1
		* 
		* Modifications			:
		*							Date			Developer				Notes
		*							----			---------				-----
		*							2023-04-29		W. Poomarin				Build UI layout
		*							2023-05-03		W. Poomarin				Finish first programming
		*							2023-05-05		W. Poomarin				Add button HiLight when clicked
		*							2023-05-07		W. Poomarin				Move calculation methods to Level class
		*							2023-05-08		W. Poomarin				Add sounds
		*							2023-05-09		W. Poomarin				Move buttons display methods and sound to Game class
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */			
		this.sequence = this.sequence + 1;								//set sequence = sequence + 1
	}
	
	public void setSequence(int input) {
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void setSequence
		*
		* Method parameters		:	input - the method permits an integer parameters to be entered
		*
		* Method return			:	void
		*
		* Synopsis				:	This method sets the data member: sequence = input
		* 
		* Modifications			:
		*							Date			Developer				Notes
		*							----			---------				-----
		*							2023-04-29		W. Poomarin				Build UI layout
		*							2023-05-03		W. Poomarin				Finish first programming
		*							2023-05-05		W. Poomarin				Add button HiLight when clicked
		*							2023-05-07		W. Poomarin				Move calculation methods to Level class
		*							2023-05-08		W. Poomarin				Add sounds
		*							2023-05-09		W. Poomarin				Move buttons display methods and sound to Game class
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */	
		this.sequence = input;											//set sequence = input
	}
	
	public int getSequence() {
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	int getSequence
		*
		* Method parameters		:	none
		*
		* Method return			:	int
		*
		* Synopsis				:	This method sets the data member: sequence = input as an integer
		* 
		* Modifications			:
		*							Date			Developer				Notes
		*							----			---------				-----
		*							2023-04-29		W. Poomarin				Build UI layout
		*							2023-05-03		W. Poomarin				Finish first programming
		*							2023-05-05		W. Poomarin				Add button HiLight when clicked
		*							2023-05-07		W. Poomarin				Move calculation methods to Level class
		*							2023-05-08		W. Poomarin				Add sounds
		*							2023-05-09		W. Poomarin				Move buttons display methods and sound to Game class
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */			
		return this.sequence;											//return sequence as an integer
	}
	
	
	public void generatePatterns() {									
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void generatePatterns
		*
		* Method parameters		:	none
		*
		* Method return			:	void
		*
		* Synopsis				:	This method sets the data member: sequence = input as an integer
		* 
		* Modifications			:
		*							Date			Developer				Notes
		*							----			---------				-----
		*							2023-04-29		W. Poomarin				Build UI layout
		*							2023-05-03		W. Poomarin				Finish first programming
		*							2023-05-05		W. Poomarin				Add button HiLight when clicked
		*							2023-05-07		W. Poomarin				Move calculation methods to Level class
		*							2023-05-08		W. Poomarin				Add sounds
		*							2023-05-09		W. Poomarin				Move buttons display methods and sound to Game class
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */			
		Random rng = new Random();									//create rng as Random object
		this.patterns = new ArrayList<Integer>();					//create patterns as an Integer array
		int counter;												//define counter as an integer count number of pattern
		int randomNumber;											//define randomNumber as an integer to store random number
		for (counter = 0; counter < this.level+2; counter++) {		//loop level + 2 times
			randomNumber = rng.nextInt(4);							//set randomNumber = random number from (0,1,2,3)
			this.patterns.add(randomNumber);						//add random number to patterns array
		}
	}
	
	public ArrayList<Integer> getPatterns() {
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	ArrayList<Integer> getPatterns
		*
		* Method parameters		:	none
		*
		* Method return			:	ArrayList<Integer>
		*
		* Synopsis				:	This method returns level's patterns array
		* 
		* Modifications			:
		*							Date			Developer				Notes
		*							----			---------				-----
		*							2023-04-29		W. Poomarin				Build UI layout
		*							2023-05-03		W. Poomarin				Finish first programming
		*							2023-05-05		W. Poomarin				Add button HiLight when clicked
		*							2023-05-07		W. Poomarin				Move calculation methods to Level class
		*							2023-05-08		W. Poomarin				Add sounds
		*							2023-05-09		W. Poomarin				Move buttons display methods and sound to Game class
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */		
		return this.patterns;										//return patterns array
	}
	
	public boolean checkMatching(ArrayList<Integer> playerPatterns) {
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	boolean checkMatching
		*
		* Method parameters		:	input - the method permits an integer array parameters to be entered
		*
		* Method return			:	boolean
		*
		* Synopsis				:	This method returns boolean as true when the level's pattern and player's patern
		* 							are matched and  returns boolean as false when the level's pattern and player's 
		* 							patern are not matched.
		* 
		* Modifications			:
		*							Date			Developer				Notes
		*							----			---------				-----
		*							2023-04-29		W. Poomarin				Build UI layout
		*							2023-05-03		W. Poomarin				Finish first programming
		*							2023-05-05		W. Poomarin				Add button HiLight when clicked
		*							2023-05-07		W. Poomarin				Move calculation methods to Level class
		*							2023-05-08		W. Poomarin				Add sounds
		*							2023-05-09		W. Poomarin				Move buttons display methods and sound to Game class
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */
		int counter;
		for (counter = 0; counter < this.patterns.size() ; counter++) {			//loop and compare every element
			if (this.patterns.get(counter) != playerPatterns.get(counter)) {	//in level's and player's pattern array
				return false;													//return false
			}
		}
		return true;															//return true
	}
	
	public int getPatternLenght() {
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	int getPatternLenght
		*
		* Method parameters		:	none
		*
		* Method return			:	int
		*
		* Synopsis				:	This method returns patterns array's length
		* 
		* Modifications			:
		*							Date			Developer				Notes
		*							----			---------				-----
		*							2023-04-29		W. Poomarin				Build UI layout
		*							2023-05-03		W. Poomarin				Finish first programming
		*							2023-05-05		W. Poomarin				Add butten HiLight when clicked
		*							2023-05-07		W. Poomarin				Move calculation methods to Level class
		*							2023-05-08		W. Poomarin				Add sounds
		*							2023-05-09		W. Poomarin				Move buttons display methods and sound to Game class
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */		
		return this.patterns.size();										//return patterns array's length
	}
	
	public void upLevelFactor() {
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void upLevelFactor
		*
		* Method parameters		:	none
		*
		* Method return			:	void
		*
		* Synopsis				:	This method multiplies levelFactor by 2.
		* 
		* Modifications			:
		*							Date			Developer				Notes
		*							----			---------				-----
		*							2023-04-29		W. Poomarin				Build UI layout
		*							2023-05-03		W. Poomarin				Finish first programming
		*							2023-05-05		W. Poomarin				Add butten HiLight when clicked
		*							2023-05-07		W. Poomarin				Move calculation methods to Level class
		*							2023-05-08		W. Poomarin				Add sounds
		*							2023-05-09		W. Poomarin				Move buttons display methods and sound to Game class
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */
		this.levelFactor = this.levelFactor*2 ;
	}
	
	public int getLevelFactor() {
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void getLevelFactor
		*
		* Method parameters		:	none
		*
		* Method return			:	int
		*
		* Synopsis				:	This method return levelFactor.
		* 
		* Modifications			:
		*							Date			Developer				Notes
		*							----			---------				-----
		*							2023-04-29		W. Poomarin				Build UI layout
		*							2023-05-03		W. Poomarin				Finish first programming
		*							2023-05-05		W. Poomarin				Add butten HiLight when clicked
		*							2023-05-07		W. Poomarin				Move calculation methods to Level class
		*							2023-05-08		W. Poomarin				Add sounds
		*							2023-05-09		W. Poomarin				Move buttons display methods and sound to Game class
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */
		return this.levelFactor;
	}
	
	
	public int getAddScore(int input) {
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	int getAddScore
		*
		* Method parameters		:	input - the method permits an integer parameters to be entered
		*
		* Method return			:	int
		*
		* Synopsis				:	This method calculates and returns score increment or decrement.
		* 
		* Modifications			:
		*							Date			Developer				Notes
		*							----			---------				-----
		*							2023-04-29		W. Poomarin				Build UI layout
		*							2023-05-03		W. Poomarin				Finish first programming
		*							2023-05-05		W. Poomarin				Add butten HiLight when clicked
		*							2023-05-07		W. Poomarin				Move calculation methods to Level class
		*							2023-05-08		W. Poomarin				Add sounds
		*							2023-05-09		W. Poomarin				Move buttons display methods and sound to Game class
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */
		return this.levelFactor*input;
	}
	
	

}
