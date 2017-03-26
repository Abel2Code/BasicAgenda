package agenda;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class AgendaDriver {
	private static List<Week> weeks = new ArrayList<Week>(); 
	
	public static void main(String[] args) {	
		startGUI();
	}
	
	public static void startGUI(){
		int selection;
		String[] mainChoices = {"Quit","Create an Agenda", "View Past Weeks", "Copy a Past Week's Agenda"};

		do {

			selection = JOptionPane.showOptionDialog(null, "Would you like to deal with: ", "Main Menu", JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE, null, mainChoices, null);

			switch (selection) {
			case 1:
				
				break;
			case 2:
				;
				break;
			case 3:
				
			}

		} while (selection != 0 && selection != JOptionPane.CLOSED_OPTION);
	}

}
