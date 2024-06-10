import java.util.ArrayList;											//import the library

public class Player {												//create Player class
			
	private int score;												//define score as an integer to store player's score
	private int selectTimes;										//define selectTimes as an integer to store to store how many time player have selected the color pattern
	private ArrayList<Integer> patterns;							//define patterns as an integer array to store player's pattern
	
	public Player() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	Player class constructor
		*
		* Method parameters		:	none
		*
		* Method return			:	Player
		*
		* Synopsis				:	This method creates Player object with initial data members and methods for player attributes.
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
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */
		
		this.score = 0;												//set score data member = 0
		this.selectTimes = 0;										//set selectTimes data member = 0
		this.patterns = new ArrayList<Integer>();					//instantiate patterns as a new Integer array

	}
	
	
	public void setScore(int input) {
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void setScore
		*
		* Method parameters		:	input - the method permits an integer parameter to be entered
		*
		* Method return			:	void
		*
		* Synopsis				:	This method sets the data member: score = input
		* 
		* Modifications			:
		*							Date			Developer				Notes
		*							----			---------				-----
		*							2023-04-29		W. Poomarin				Build UI layout
		*							2023-05-03		W. Poomarin				Finish first programming
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */
		this.score = input;											//set score = input
	}
	
	public int getScore() {
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	int getScore
		*
		* Method parameters		:	none
		*
		* Method return			:	int
		*
		* Synopsis				:	This method returns an integer data member: score
		* 
		* Modifications			:
		*							Date			Developer				Notes
		*							----			---------				-----
		*							2023-04-29		W. Poomarin				Build UI layout
		*							2023-05-03		W. Poomarin				Finish first programming
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */
		return this.score;											//return score as an integer
	}
	
	public String getScoreString() {
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	String getScoreString
		*
		* Method parameters		:	none
		*
		* Method return			:	String
		*
		* Synopsis				:	This method returns a string data member: score
		* 
		* Modifications			:
		*							Date			Developer				Notes
		*							----			---------				-----
		*							2023-04-29		W. Poomarin				Build UI layout
		*							2023-05-03		W. Poomarin				Finish first programming
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */
		return String.valueOf(this.score);							//return score as a string
	}
	
	public void resetPatterns() {
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void resetPatterns
		*
		* Method parameters		:	none
		*
		* Method return			:	void
		*
		* Synopsis				:	This method clears patterns array and create the new one
		* 
		* Modifications			:
		*							Date			Developer				Notes
		*							----			---------				-----
		*							2023-04-29		W. Poomarin				Build UI layout
		*							2023-05-03		W. Poomarin				Finish first programming
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */
		this.patterns = new ArrayList<Integer>();					//create new Integer array
	}
	
	public void addPatterns(int selection) {
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void addPatterns
		*
		* Method parameters		:	input - the method permits an integer parameter to be entered
		*
		* Method return			:	void
		*
		* Synopsis				:	This method adds a new Integer element to pattern array
		* 
		* Modifications			:
		*							Date			Developer				Notes
		*							----			---------				-----
		*							2023-04-29		W. Poomarin				Build UI layout
		*							2023-05-03		W. Poomarin				Finish first programming
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */		
		this.patterns.add(selection);								//call add() to add a new Integer element to pattern array
	}
	
	public void setSelectTimes(int times) {
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void setSelectTimes
		*
		* Method parameters		:	input - the method permits an integer parameter to be entered
		*
		* Method return			:	void
		*
		* Synopsis				:	This method sets selectTimes = times
		* 
		* Modifications			:
		*							Date			Developer				Notes
		*							----			---------				-----
		*							2023-04-29		W. Poomarin				Build UI layout
		*							2023-05-03		W. Poomarin				Finish first programming
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */
		this.selectTimes = times;									//set selectTimes = times
	}
	
	public int getSelectTimes() {
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	int getSelectTimes
		*
		* Method parameters		:	none
		*
		* Method return			:	int
		*
		* Synopsis				:	This method returns an integer data member: selectTimes
		* 
		* Modifications			:
		*							Date			Developer				Notes
		*							----			---------				-----
		*							2023-04-29		W. Poomarin				Build UI layout
		*							2023-05-03		W. Poomarin				Finish first programming
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */
		return this.selectTimes;									//return selectTimes
	}
	
	public ArrayList<Integer> getPatterns() {
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	ArrayList<Integer> getPatterns
		*
		* Method parameters		:	none
		*
		* Method return			:	ArrayList<Integer>
		*
		* Synopsis				:	This method returns player's patterns array
		* 
		* Modifications			:
		*							Date			Developer				Notes
		*							----			---------				-----
		*							2023-04-29		W. Poomarin				Build UI layout
		*							2023-05-03		W. Poomarin				Finish first programming
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */		
		return this.patterns;										//return patterns array
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
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */			
		return this.patterns.size();								//return patterns array's length
	}

}
