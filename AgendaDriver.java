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
		String[] mainChoices = {"Quit","Create an New Week", "View Past Weeks", "Copy a Past Week's Agenda"};
		String[] daysOfWeek = {"Quit","Sunday","Monday", "Tuesday", "Wednesday","Thursday","Friday","Saturday"};

		do {

			selection = JOptionPane.showOptionDialog(null, "Would you like to deal with: ", "Main Menu", JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE, null, mainChoices, null);

			switch (selection) {
			case 1:
				weeks.add(new Week(JOptionPane.showInputDialog("What would you like to name this Week?")));
				selection = JOptionPane.showOptionDialog(null, "Would you like to deal with: ", "Main Menu", JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE, null, mainChoices, null);
				addToWeek(selection);
				break;
			case 2:
				;
				break;
			case 3:
				
			}

		} while (selection != 0 && selection != JOptionPane.CLOSED_OPTION);
	}

	public static void addToWeek(int selection){
		int latestWeek = weeks.size();
		switch (selection) {
		case 1:
			weeks.get(latestWeek).getSunday().add(JOptionPane.showInputDialog("What would you like to add to Sunday?"));
			break;
		case 2:
			weeks.get(latestWeek).getMonday().add(JOptionPane.showInputDialog("What would you like to add to Monday?"));
			break;
		case 3:
			weeks.get(latestWeek).getTuesday().add(JOptionPane.showInputDialog("What would you like to add to Tuesday?"));
			break;
		case 4: 
			weeks.get(latestWeek).getWednesday().add(JOptionPane.showInputDialog("What would you like to add to Wednesday?"));
			break;
		case 5:
			weeks.get(latestWeek).getThursday().add(JOptionPane.showInputDialog("What would you like to add to Thursday?"));
			break;
		case 6:
			weeks.get(latestWeek).getFriday().add(JOptionPane.showInputDialog("What would you like to add to Friday?"));
			break;
		case 7:
			weeks.get(latestWeek).getSaturday().add(JOptionPane.showInputDialog("What would you like to add to Saturday?"));
		}
	}
}
