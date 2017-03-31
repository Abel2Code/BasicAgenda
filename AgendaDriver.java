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
		String[] mainChoices = {"Quit", "Create an New Week", "Add to a Week's Agenda", "View Past Weeks", "Copy a Past Week's Agenda"};
		String[] daysOfWeek = {"Quit","Sunday","Monday", "Tuesday", "Wednesday","Thursday","Friday","Saturday"};

		do {

			selection = JOptionPane.showOptionDialog(null, "Would you like to deal with: ", "Main Menu", JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE, null, mainChoices, null);
			int latestWeek = weeks.size();

			switch (selection) {
			case 1:
				String nameOfWeek = JOptionPane.showInputDialog("What would you like to name this Week?");
				weeks.add(new Week(nameOfWeek));
				JOptionPane.showMessageDialog(null, "Success! " + nameOfWeek + " was created.");
				break;
			case 2:

				if(weeks.isEmpty()){
					JOptionPane.showMessageDialog(null, "ERROR: You must create a week first.");
				}else{
					displayWeeks();

					String tempWeekCopy = JOptionPane.showInputDialog(null, "Enter the name of the week you would like to copy.");
					int tempWeekCopyInterval = -1;
					for(int counter = 0; counter < latestWeek; counter++){
						if(weeks.get(counter).getWeekTitle().equals(tempWeekCopy)){
							tempWeekCopyInterval = counter;
							break;
						}
					}
					if(tempWeekCopyInterval != -1){	
						selection = JOptionPane.showOptionDialog(null, "What day would you like to add to " + weeks.get(latestWeek - 1), "Main Menu", JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE, null, daysOfWeek, null);
						addToWeek(selection, tempWeekCopyInterval);
					}
				}
				break;
			case 3:
				displayWeeks();

				String tempWeek = JOptionPane.showInputDialog(null, "Enter the name of the week you would like to view.");
				int tempWeekInterval = -1;
				for(int counter = 0; counter < latestWeek; counter++){
					if(weeks.get(counter).getWeekTitle().equals(tempWeek)){
						tempWeekInterval = counter;
						break;
					}
				}

				if(tempWeekInterval != -1){
					Week weekAgenda = weeks.get(tempWeekInterval);
					StringBuilder agenda = new StringBuilder(weekAgenda + ":");
					agenda.append("\n Sunday:");
					if(weekAgenda.getSunday().isEmpty()){
						agenda.append("\n     None");
					} else{
						for(String interval : weekAgenda.getSunday()){
							agenda.append("\n     " + interval);
						}
					}
					agenda.append("\n Monday:");
					if(weekAgenda.getMonday().isEmpty()){
						agenda.append("\n     None");
					} else{
						for(String interval : weekAgenda.getMonday()){
							agenda.append("\n     " + interval);
						}
					}
					agenda.append("\n Tuesday:");
					if(weekAgenda.getTuesday().isEmpty()){
						agenda.append("\n     None");
					} else{
						for(String interval : weekAgenda.getTuesday()){
							agenda.append("\n     " + interval);
						}
					}
					agenda.append("\n Wednesday:");
					if(weekAgenda.getWednesday().isEmpty()){
						agenda.append("\n     None");
					} else{
						for(String interval : weekAgenda.getWednesday()){
							agenda.append("\n     " + interval);
						}
					}
					agenda.append("\n Thursday:");
					if(weekAgenda.getThursday().isEmpty()){
						agenda.append("\n     None");
					} else{
						for(String interval : weekAgenda.getThursday()){
							agenda.append("\n     " + interval);
						}
					}
					agenda.append("\n Friday:");
					if(weekAgenda.getFriday().isEmpty()){
						agenda.append("\n     None");
					} else{
						for(String interval : weekAgenda.getFriday()){
							agenda.append("\n     " + interval);
						}
					}
					agenda.append("\n Saturday:");
					if(weekAgenda.getSaturday().isEmpty()){
						agenda.append("\n     None");
					} else{
						for(String interval : weekAgenda.getSaturday()){
							agenda.append("\n     " + interval);
						}
					}
					JOptionPane.showMessageDialog(null, agenda);
				} else{
					JOptionPane.showMessageDialog(null, "ERROR: That agenda does not exist");
				}
				break;
			case 4: 
				displayWeeks();

				String tempWeekCopy = JOptionPane.showInputDialog(null, "Enter the name of the week you would like to copy.");
				int tempWeekCopyInterval = -1;
				for(int counter = 0; counter < latestWeek; counter++){
					if(weeks.get(counter).getWeekTitle().equals(tempWeekCopy)){
						tempWeekCopyInterval = counter;
						break;
					}
				}
				if(tempWeekCopyInterval != -1){
					weeks.add(weeks.get(tempWeekCopyInterval).clone());
					if(weeks.get(latestWeek) == null){
						weeks.remove(latestWeek);
					} else{
						weeks.get(latestWeek).setWeekTitle(JOptionPane.showInputDialog("Enter the name for the new week"));
					}

				} else{
					JOptionPane.showMessageDialog(null, "ERROR: That week does not exist");
				}
			} 


		} while (selection != 0 && selection != JOptionPane.CLOSED_OPTION);
	}

	public static void addToWeek(int selection, int index){
		int latestWeek = weeks.size();
		switch (selection) {
		case 1:
			weeks.get(index).getSunday().add(JOptionPane.showInputDialog("What would you like to add to Sunday?"));
			break;
		case 2:
			weeks.get(index).getMonday().add(JOptionPane.showInputDialog("What would you like to add to Monday?"));
			break;
		case 3:
			weeks.get(index).getTuesday().add(JOptionPane.showInputDialog("What would you like to add to Tuesday?"));
			break;
		case 4: 
			weeks.get(index).getWednesday().add(JOptionPane.showInputDialog("What would you like to add to Wednesday?"));
			break;
		case 5:
			weeks.get(index).getThursday().add(JOptionPane.showInputDialog("What would you like to add to Thursday?"));
			break;
		case 6:
			weeks.get(index).getFriday().add(JOptionPane.showInputDialog("What would you like to add to Friday?"));
			break;
		case 7:
			weeks.get(index).getSaturday().add(JOptionPane.showInputDialog("What would you like to add to Saturday?"));
		}
	}

	public static void displayWeeks(){
		StringBuilder sb = new StringBuilder("Weeks:");

		if (weeks.isEmpty()) {
			sb.append("\n     None");
		} else {
			for (Week interval : weeks) {
				sb.append("\n     " + interval);
			}
		} 

		JOptionPane.showMessageDialog(null, sb);
	}
}
