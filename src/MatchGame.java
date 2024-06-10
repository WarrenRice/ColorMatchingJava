import java.awt.event.ActionEvent;														//import the library
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;


public class MatchGame extends JFrame implements ActionListener {
	
	private JPanel contentPane;															// create contentPane as a JPanel for main content pane
	
	private JButtonPlus[] colorButtons;													// create colorButtons as a JButtonPlus[] array for color buttons
	
	private JButton btnPlay;															// create btnPlay as a JButton for player to start the game
	
	private JLabel lblScore;															// create lblScore as a JLabel to player's score
	private JLabel lblLv;																// create lblLv as a JLabel to show current level
	private JLabel lblComplete;															// create lblComplete as a JLabel to show turn completion
	private JLabel lblGameState;														// create lblGameState as a JLabel to show game status
		
	private Level level;																// create level as a Level object
	private Player player1;																// create player1 as a Player object
	
	private static final Integer FRAMETIME = 1000;										// set a final data member for the timer																			
	private static Boolean hiBlink;														// create hiBlink as a boolean to cycle between icons
	private static Boolean finishSequence;												// create finishSequence as a boolean to stop the blink sequence
	private Timer timeRun = new Timer(FRAMETIME,this);									// instantiate a timer object
	
	private static final String rightSoundFile = "Audio/right.wav";						//define rightSoundFile as a string to right.wav sound location
	private static final String wrongSoundFile = "Audio/wrong.wav";						//define rightSoundFile as a string to wrong.wav sound location
	private static final String pressSoundFile = "Audio/press.wav";						//define rightSoundFile as a string to press.wav sound location
	
	private Clip theRightSoundClip;														//create Clips so audio data can be loaded prior to play back,
	private Clip theWrongSoundClip;														//instead of being streamed in real time. 
	private Clip thePressSoundClip;

	
	public MatchGame() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	Game class constructor
		*
		* Method parameters		:	none
		*
		* Method return			:	Game
		*
		* Synopsis				:	Constructor of the class Game. Creates an instance of the game's window frame. 
		* 								This class initializes and runs JFrame, contentPane, buttons, labels, 
		* 								player, level and sounds.
		* 								
		* 
		*
		*References				:	Audio files obtained from freesound.org library that has CC0 license.
		*								Fupicat. (n.d.) Gamey game Sounds Correct Bell. Retrieved May 8, 2023, 
		*								from https://freesound.org/people/Fupicat/sounds/538147/
		*								-Andreas. (n.d.) Default Wrong Answer. Retrieved May 8, 2023, 
		*								https://freesound.org/people/-Andreas/sounds/648462/								
		*								JarredGibb. (n.d.) Household Button 04.wav. Retrieved May 8, 2023, 
		*								from https://freesound.org/people/JarredGibb/sounds/219477/
		*
		*						:   Oracle. (n.d.). Java Sound Technology. Package javax.sound.sampled. Retrieved May 8, 2023, 
		* 								from https://docs.oracle.com/javase/8/docs/api/javax/sound/sampled/package-summary.html
		*		
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
		*							2023-05-09		W. Poomarin				fix delay after the last blink
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */
		
		setTitle("Matching Game");
		
		level = new Level();															// instantiate level as new Level
		player1 = new Player();															// instantiate player1 as new Level
		
		hiBlink = false;																// set hiBlink = false
		finishSequence = false;															// set finishSequence = false
		
		colorButtons = new JButtonPlus[4];												// instantiate colorButtons as new JButtonPlus with 4 elements
		
		initializeSounds();																// call initializeSounds() method to load sound files
															
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);									// setup window
		setBounds(640, 250, 450, 450);													// set window size and postions
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		colorButtons[0] = new JButtonPlus("Images/redHi.png", "Images/redLo.png");		// instantiate colorButtons[0] and set image icons
		colorButtons[0].setBounds(37, 70, 88, 88);										// set location
		colorButtons[0].addActionListener(new ActionListener() {						// call playSound() and select() methods when it's clicked
			public void actionPerformed(ActionEvent e) {
				select(0);
			}
		});
		contentPane.add(colorButtons[0]);												// add it to the pane
		
		
		colorButtons[1] = new JButtonPlus("Images/greenHi.png", "Images/greenLo.png");	// instantiate colorButtons[1] and set image icons 
		colorButtons[1].setBounds(146, 70, 88, 88);										// set location
		colorButtons[1].addActionListener(new ActionListener() {						// call playSound() and select() methods when it's clicked
			public void actionPerformed(ActionEvent e) {
				select(1);
			}
		});
		contentPane.add(colorButtons[1]);												// add it to the pane
		
		
		colorButtons[2] = new JButtonPlus("Images/yellowHi.png", "Images/yellowLo.png");	// instantiate colorButtons[2] and set image icons 
		colorButtons[2].setBounds(37, 179, 88, 88);										// set location
		colorButtons[2].addActionListener(new ActionListener() {						// call playSound() and select() methods when it's clicked
			public void actionPerformed(ActionEvent e) {
				select(2);
			}
		});
		contentPane.add(colorButtons[2]);												// add it to the pane
		
		colorButtons[3] = new JButtonPlus("Images/blueHi.png", "Images/blueLo.png");	// instantiate colorButtons[3] and set image icons 
		colorButtons[3].setBounds(146, 179, 88, 88);									// set location
		colorButtons[3].addActionListener(new ActionListener() {						// call playSound() and select() methods when it's clicked
			public void actionPerformed(ActionEvent e) {
				select(3);
			}
		});
		contentPane.add(colorButtons[3]);												// add it to the pane
		
		
		lblScore = new JLabel("Score: ");												// set lblScore label to "Score: "
		lblScore.setFont(new Font("Tahoma", Font.BOLD, 16));							// set font size and style
		lblScore.setBounds(272, 70, 152, 14);											// set location
		contentPane.add(lblScore);														// add it to the pane
		
		lblLv = new JLabel("Level: ");													// set lblLv label to "Level: "
		lblLv.setFont(new Font("Tahoma", Font.BOLD, 16));								// set font size and style
		lblLv.setBounds(272, 179, 152, 14);												// set location
		contentPane.add(lblLv);															// add it to the pane
		

		
		btnPlay = new JButton("Play");													// set btnPlay button's label to "Level: "									
		btnPlay.addActionListener(new ActionListener() {								// call play() when it's clicked
			public void actionPerformed(ActionEvent e) {
				play();
			}
		});
		btnPlay.setFont(new Font("Tahoma", Font.BOLD, 12));								// set font size and style
		btnPlay.setBounds(37, 296, 198, 23);											// set location
		contentPane.add(btnPlay);														// add it to the pane
		
		lblComplete = new JLabel("Completed: ");										// set lblComplete label to "Completed: "
		lblComplete.setFont(new Font("Tahoma", Font.BOLD, 12));							// set font size and style
		lblComplete.setBounds(272, 216, 152, 14);										// set location
		contentPane.add(lblComplete);													// add it to the pane
		
		lblGameState = new JLabel("");													// set lblGameOver label to ""
		lblGameState.setForeground(new Color(0, 0, 0));									// set color
		lblGameState.setHorizontalAlignment(SwingConstants.CENTER);						// set Alignment to center
		lblGameState.setFont(new Font("Tahoma", Font.BOLD, 14));						// set font size and style	
		lblGameState.setBounds(140, 358, 152, 14);										// set location
		contentPane.add(lblGameState);													// add it to the pane
		
		updateDisplay();																// call updateDisplay() to update UI
		
		timeRun.start();																// run timer
		
	}
	
	public void initializeSounds() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	Void initialSounds
		*
		* Method parameters		:	none
		*
		* Method return			:	void
		*
		* Synopsis				:	This method initializes the sound files and feedbacks when the error occurs.
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
		
		try {

			File theRightSoundFile = new File(rightSoundFile);						//create and instantiate File object
			File theWrongSoundFile = new File(wrongSoundFile);						//to load sound file from the paths 	
			File thePressSoundFile = new File(pressSoundFile);						//and store them in the objects	
			
			
			AudioInputStream theRightSoundAudio = AudioSystem.getAudioInputStream(theRightSoundFile);	//create and instantiate audioInputStream objects 
			AudioInputStream theWrongSoundAudio = AudioSystem.getAudioInputStream(theWrongSoundFile);	//from sound file objects.
			AudioInputStream thePressSoundAudio = AudioSystem.getAudioInputStream(thePressSoundFile);	
			
			
			theRightSoundClip = AudioSystem.getClip();								//instantiate of Clip so audio data can be loaded prior to play back,
			theWrongSoundClip = AudioSystem.getClip();								//instead of being streamed in real time. 
			thePressSoundClip = AudioSystem.getClip();			
			

			theRightSoundClip.open(theRightSoundAudio);								// open the clips with the AudioInputStream
			theWrongSoundClip.open(theWrongSoundAudio);
			thePressSoundClip.open(thePressSoundAudio);
			
		} catch (Exception e) {														//if there is an error with sound file
			JOptionPane.showMessageDialog(null, "Problem playing sound file");		//display when error occurs
		}

	}
	
	public void play() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void play
		*
		* Method parameters		:	none
		*
		* Method return			:	void
		*
		* Synopsis				:	This method will clean and create player's pattern, generate level's pattern,
		* 								sets level's sequence to 0 to play blink patterns, and disable buttons
		*  
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

		player1.resetPatterns();														// call resetPatterns() to reset player1's patterns array
		level.generatePatterns();														// call generatePatterns() to create level's patterns array
		
		level.setSequence(0);															// set blink sequence to 0
		
		btnPlay.setEnabled(false);														// disable btnPlay button
		enableColorBtns(colorButtons,false);											// disable every color buttons
		
		lblGameState.setText("Wait...");												// display "Wait..." label
		
	}
	
	
	public void select(int buttonNumber) {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void setColorBtns
		*
		* Method parameters		:	input - the method permits a boolean parameter to be entered
		*
		* Method return			:	void
		*
		* Synopsis				:	This method enables or disables the color buttons
		*  
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
		
		int numberSelection = player1.getSelectTimes();									// create number_Selection as an integer 
																						// to store how many time player has selected
		
		int limitSelection = level.getPatternLenght();									// create limit_Selection as an integer
																						// to selecting limitation
		
		
		player1.addPatterns(buttonNumber);												// add new selection to player's pattern
		
		numberSelection++;																// set number_Selection = number_Selection + 1
		
		player1.setSelectTimes(numberSelection);										// set player1's selectTimes = number_Selection 
		
		playPressSound();																// play press sound
		
		if (numberSelection == limitSelection) {										// check when player1's selectTimes == limit_Selection then
			
			check();																	// call check() to check the answer pattern
			enableColorBtns(colorButtons,false);										// call enableColorBtns to disable color buttons
			
		} 
		
	}
	
	
	public void check() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void check
		*
		* Method parameters		:	none
		*
		* Method return			:	void
		*
		* Synopsis				:	This method determines whether player's answer is right or wrong, update player's score, 
		* 								and also determines player will go to the next level or lose the game.
		*
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
		
		int scoreNow;																	// create scoreNow as an integer to current score
		int addScore;																	// create addScore as an integer to score that will be add
		boolean correct;
		
		scoreNow = player1.getScore();													// set scoreNow = player1's current score
		
		correct = level.checkMatching(player1.getPatterns());							// set correct = return value of level.checkMatching() 
																						// to check level's pattern and player's pattern
		
		if (correct) {																	// if correct == true then

			addScore = level.getAddScore(10);											// set addScore = level.getAddScore(10)
			
			playRightSound();															// play right sound
			
			lblGameState.setText("Correct!");											// display "Correct!" label
			JOptionPane.showMessageDialog(null, "Correct! +" + addScore);				// display correct message
			
			level.completeUP();															// set level.complete = level.complete + 1
			if (level.getComplete() == 4) {												// if level.complete == 4 then
				level.levelUp();														// set level.level = level.level + 1
				level.resetComplete();													// set level.complete = 0
				level.upLevelFactor();													// set levelFactor = levelFactor*2
			}

		} else {																		// if correct == false then
			
			addScore = level.getAddScore(-20);											// set addScore = level.getAddScore(-20)
			
			playWrongSound();															// play wrong sound
			
			lblGameState.setText("NOT Correct!");										// display "NOT Correct!" label
			JOptionPane.showMessageDialog(null, "NOT Correct! " + addScore);			// display incorrect message
			
		}
		
		player1.setScore(scoreNow + addScore);											// set player1.score = scoreNow + addScore
		scoreNow = player1.getScore();													// set scoreNow = player1's current score
		
		updateDisplay();																// call updateDisplay() to update UI
		
		if (scoreNow < 0) {																// if scoreNow <= 0 then
			btnPlay.setEnabled(false);													// disable btnPlay button
			lblGameState.setForeground(new Color(255, 0, 0));							// set label color
			lblGameState.setText("GAME OVER!!");										// display "GAME OVER!!" label
			JOptionPane.showMessageDialog(null, "GAME OVER!!");							// display "GAME OVER!!" text
			
		} else {																		// else then
			btnPlay.setEnabled(true);													// enable btnPlay button
		}

		player1.setSelectTimes(0);														// set player1.selectTimes = 0
		enableColorBtns(colorButtons,false);											// disable every color buttons
		
		
	}
	
	public void updateDisplay() {														
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void updateDisplay
		*
		* Method parameters		:	none
		*
		* Method return			:	void
		*
		* Synopsis				:	This method updates the UI labels.
		*
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
		
		lblScore.setText("Score: " + player1.getScoreString());							// set lblScore label to "Score: " + player1's current score
		lblLv.setText("Level: " + level.getLevelString());								// set lblLv label to " " + current level
		lblComplete.setText("Complete: " + level.getCompleteString());					// set lblComplete label to " " + level.complete
	}
	
	public void enableColorBtns(JButtonPlus[] buttons, boolean on) {
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void enableColorBtns
		*
		* Method parameters		:	input - the method permits a JButtonPlus array parameters to be entered
		*
		* Method return			:	void
		*
		* Synopsis				:	This method enables or disables buttons.
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
		int count;																		// create count as an integer
		for (count = 0; count < buttons.length; count++) {								// set every colorButtons 
			buttons[count].setEnabled(on);												// on = true is enable, on = false is disable
		}	
	}
	
	public void playRightSound() {
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void playRightSound
		*
		* Method parameters		:	none
		*
		* Method return			:	void
		*
		* Synopsis				:	This method plays sound.
		* 
		* References			:	Audio files obtained from freesound.org library that has CC0 license.
		*								Fupicat. (n.d.) Gamey game Sounds Correct Bell. Retrieved May 8, 2023, 
		*								from https://freesound.org/people/Fupicat/sounds/538147/
		* 
		* Modifications			:
		*							Date			Developer				Notes
		*							----			---------				-----
		*							2023-04-29		W. Poomarin				Build UI layout
		*							2023-05-03		W. Poomarin				Finish first programming
		*							2023-05-05		W. Poomarin				Add button HiLight when clicked
		*							2023-05-07		W. Poomarin				Move calculation mechanic to Level class
		*							2023-05-08		W. Poomarin				Add sounds
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */	
		theRightSoundClip.setFramePosition(0);								//reset sound streaming position
		theRightSoundClip.start();											//play sound
	}
	
	public void playWrongSound() {
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void playWrongSound
		*
		* Method parameters		:	none
		*
		* Method return			:	void
		*
		* Synopsis				:	This method plays sound.
		* 
		* References			:	Audio files obtained from freesound.org library that has CC0 license.
		*								-Andreas. (n.d.) Default Wrong Answer. Retrieved May 8, 2023, 
		*								https://freesound.org/people/-Andreas/sounds/648462/								
		* 
		* Modifications			:
		*							Date			Developer				Notes
		*							----			---------				-----
		*							2023-04-29		W. Poomarin				Build UI layout
		*							2023-05-03		W. Poomarin				Finish first programming
		*							2023-05-05		W. Poomarin				Add button HiLight when clicked
		*							2023-05-07		W. Poomarin				Move calculation mechanic to Level class
		*							2023-05-08		W. Poomarin				Add sounds
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */	
		theWrongSoundClip.setFramePosition(0);								//reset sound streaming position
		theWrongSoundClip.start();											//play sound
	}
	
	
	public void playPressSound() {
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void playRightSound
		*
		* Method parameters		:	none
		*
		* Method return			:	void
		* 
		* References			:	Audio files obtained from freesound.org library that has CC0 license.							
		*								JarredGibb. (n.d.) Household Button 04.wav. Retrieved May 8, 2023, 
		*								from https://freesound.org/people/JarredGibb/sounds/219477/
		*
		* Synopsis				:	This method plays sound.
		* Modifications			:
		*							Date			Developer				Notes
		*							----			---------				-----
		*							2023-04-29		W. Poomarin				Build UI layout
		*							2023-05-03		W. Poomarin				Finish first programming
		*							2023-05-05		W. Poomarin				Add button HiLight when clicked
		*							2023-05-07		W. Poomarin				Move calculation mechanic to Level class
		*							2023-05-08		W. Poomarin				Add sounds
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */	
		thePressSoundClip.setFramePosition(0);								//reset sound streaming position
		thePressSoundClip.start();											//play sound
	}
	
	public void setAllButtonToLow() {
		for (int count = 0; count < colorButtons.length; count++) {						// set every button hilight to low
			colorButtons[count].blinkHi(false);									
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {										// create blink event
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void actionPerformed
		*
		* Method parameters		:	input - the method permits an ActionEvent object parameters to be entered
		*
		* Method return			:	void
		*
		* Synopsis				:	This method make the buttons blink.
		*
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
		*							2023-05-09		W. Poomarin				fix delay after the last blink
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */
		
		int count;																			// create count as an integer to store blink sequence
		count = level.getSequence();														// set count = number of level's current sequence (blink)
		
		
		if (count ==  level.getPatternLenght()) {
			level.resetSequence();															// set level.sequence = -1
			if (finishSequence) {															// if finishSequence == true then
				enableColorBtns(colorButtons,true);											// enable every color buttons
				finishSequence = !finishSequence;											// set finishSequence = false
				lblGameState.setText("GO!!");												// display "GO!!" label
			}
		} else if (count >= 0 && count < level.getPatternLenght()) {
			
			if (hiBlink) {
				if (count >= 0 && count < level.getPatternLenght()) {						// if count >= 0 and count < level.patterns Length
					
					int positionHi;															// create positionHi as an integer to store button position that will be hilight
					positionHi = level.getPatterns().get(count);							// set positionHi = element in level's pattern at count index
					
					colorButtons[positionHi].blinkHi(true);									// display colorButtons at positionHi to hi
					
					level.addSequence();													// set level.sequence = level.sequence + 1
					
					finishSequence = true;													// set finishSequence = true		
					
				}
			}else{
				setAllButtonToLow();														// set every button hilight to low during blinking
			}
		} else {
			setAllButtonToLow();															// set every button hilight back to low
		}

		hiBlink = !hiBlink;																	// reverse the boolean to toggle the
	}
}