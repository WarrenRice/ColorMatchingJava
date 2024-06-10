import java.awt.event.ActionEvent;											//import the library
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class JButtonPlus extends JButton {									//create JButtonPlus class 
																			//as inheritance from JButton class  
	
	private ImageIcon hiIcon;												//create hiIcon as ImageIcon object
	private ImageIcon loIcon;												//create loIcon as ImageIcon object
	
	
	public JButtonPlus(String hiImageLocation, String loImageLocation) {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	JButtonPlus class constructor
		*
		* Method parameters		:	input - the method permits two String parameters to be entered
		*
		* Method return			:	JButtonPlus
		*
		* Synopsis				:	This method creates JButtonPlus object with initial data members.
		* 
		*						:   Oracle. (n.d.). javax.swing. Class JButton. Retrieved May 8, 2023, 
		* 								from https://docs.oracle.com/javase/8/docs/api/javax/swing/JButton.html
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
		
		this.hiIcon = new ImageIcon(hiImageLocation);						//instantiate hiIcon as new ImageIcon with hiImageLocation icon
		this.loIcon = new ImageIcon(loImageLocation);						//instantiate loIcon as new ImageIcon with loImageLocation icon
		this.setPressedIcon(hiIcon);										//set the button's icon when it is clicked
		this.setDisabledIcon(loIcon);										//set the button's disabled icon to loIcon 
		this.setIcon(loIcon);												//set enable icon to loIcon 
		this.setEnabled(false);												//disable this button
	}
	
	
	public void blinkHi(boolean hi) {
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void blinkHi
		*
		* Method parameters		:	input - the method permits a boolean parameter to be entered
		*
		* Method return			:	void
		*
		* Synopsis				:	This method changes disabled icon to hiIcon and loIcon
		* 
		* Modifications			:
		*							Date			Developer				Notes
		*							----			---------				-----
		*							2023-04-29		W. Poomarin				Build UI layout
		*							2023-05-03		W. Poomarin				Finish first programming
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */		
		if (hi) {															//if hi == true
			this.setDisabledIcon(hiIcon);									//set button's DisabledIcon to hiIcon
		} else {															//else
			this.setDisabledIcon(loIcon);									//set button's DisabledIcon to loIcon
		}
	}
	
}