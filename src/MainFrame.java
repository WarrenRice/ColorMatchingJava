import java.awt.EventQueue;											//import the library
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {
	public MainFrame() {
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void main(String[] args)
		*
		* Method parameters		:	args - the method permits String command line parameters to be entered
		*
		* Method return			:	void
		*
		* Synopsis				:	The method runs the application.
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
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MatchGame matchGame = new MatchGame();						//create game object as Game object to run the game
					matchGame.setVisible(true);						//display the game
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}