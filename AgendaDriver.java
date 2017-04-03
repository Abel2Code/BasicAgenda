package agenda;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class AgendaDriver {
	private static List<Week> weeks = new ArrayList<Week>(); 

	public static void main(String[] args) {	
		startGUI();
	}

	public static void startGUI(){
		int selection;
		String[] mainChoices = {"Quit", "Create a New Week", "Add to a Week's Agenda", "View Past Weeks", "Copy a Past Week's Agenda", "Export Current Weeks to File", "Import weeks from File"};
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
				break;
			case 5:
				saveToFile();
				break;
			case 6:
				readFromFile();
			}
		} while (selection != 0 && selection != JOptionPane.CLOSED_OPTION);
	}

	public static void addToWeek(int selection, int index){
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

	private static void saveToFile(){
		try{
			File inFile = new File(JOptionPane.showInputDialog("Select a file you would like to save to."));
			BufferedWriter writer = new BufferedWriter(new FileWriter(inFile));
			writer.write("Week Title, Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday");
			writer.newLine();

			for(Week interval: weeks) {
				StringBuilder sb = new StringBuilder(interval.getWeekTitle() + ",");

				if(interval.getSunday().isEmpty()){
					sb.append("None");
				} else{
					for(String sundayInterval: interval.getSunday()){
						sb.append(sundayInterval + "-");
					}
					sb.deleteCharAt(sb.length() - 1);
				}
				sb.append(",");

				if(interval.getMonday().isEmpty()){
					sb.append("None");
				} else{
					for(String mondayInterval: interval.getSunday()){
						sb.append(mondayInterval + "-");
					}
					sb.deleteCharAt(sb.length() - 1);
				}
				sb.append(",");

				if(interval.getTuesday().isEmpty()){
					sb.append("None");
				} else{
					for(String tuesdayInterval: interval.getSunday()){
						sb.append(tuesdayInterval + "-");
					}
					sb.deleteCharAt(sb.length() - 1);
				}
				sb.append(",");

				if(interval.getWednesday().isEmpty()){
					sb.append("None");
				} else{
					for(String wednesdayInterval: interval.getSunday()){
						sb.append(wednesdayInterval + "-");
					}
					sb.deleteCharAt(sb.length() - 1);
				}
				sb.append(",");

				if(interval.getThursday().isEmpty()){
					sb.append("None");
				} else{
					for(String thursdayInterval: interval.getSunday()){
						sb.append(thursdayInterval + "-");
					}
					sb.deleteCharAt(sb.length() - 1);
				}
				sb.append(",");

				if(interval.getFriday().isEmpty()){
					sb.append("None");
				} else{
					for(String fridayInterval: interval.getSunday()){
						sb.append(fridayInterval + "-");
					}
					sb.deleteCharAt(sb.length() - 1);
				}
				sb.append(",");

				if(interval.getSaturday().isEmpty()){
					sb.append("None");
				} else{
					for(String saturdayInterval: interval.getSunday()){
						sb.append(saturdayInterval + "-");
					}
					sb.deleteCharAt(sb.length() - 1);
				}

				writer.write("" + sb);
				writer.newLine();
			}
			writer.close();
		} catch(Exception e){
			JOptionPane.showMessageDialog(null, "ERROR: Was unable to export.");
		}
	}
	
	public static void readFromFile(){
		try{
			File outFile = new File(JOptionPane.showInputDialog("Select a file you would like to import from."));
	        Scanner fileReader = new Scanner(outFile);
	        fileReader.nextLine();
	        String[] values;
	        String line;
	        weeks.clear();
	        List<String> sunday = new ArrayList<String>();
	        List<String> monday = new ArrayList<String>();
	        List<String> tuesday = new ArrayList<String>();
	        List<String> wednesday = new ArrayList<String>();
	        List<String> thursday = new ArrayList<String>();
	        List<String> friday = new ArrayList<String>();
	        List<String> saturday = new ArrayList<String>();
	        
	        while(fileReader.hasNextLine()){
	        	line = fileReader.nextLine();
	        	values = line.split(",");
	        	while(values[1].indexOf('-') != -1){
	        		//While next '-' is == value[1].length()
	        		sunday.add(values[1].substring(0, values[1].indexOf('-')));
	        		if(values[1].indexOf('-') + 1 != values[1].length()){
	        			values[1] = values[1].substring(values[1].indexOf('-') + 1);
	        			break;
	        		}	        		
	        	}
	        	
	        	while(values[2].indexOf('-') != -1){
	        		monday.add(values[2].substring(0, values[2].indexOf('-')));
	        		if(values[2].indexOf('-') + 1 != values[2].length()){
	        			values[2] = values[2].substring(values[2].indexOf('-') + 1);
	        			break;
	        		}	        		
	        	}
	        	
	        	while(values[3].indexOf('-') != -1){
	        		tuesday.add(values[3].substring(0, values[3].indexOf('-')));
	        		if(values[3].indexOf('-') + 1 != values[3].length()){
	        			values[3] = values[3].substring(values[3].indexOf('-') + 1);
	        			break;
	        		}	        		
	        	}
	        	
	        	while(values[4].indexOf('-') != -1){
	        		wednesday.add(values[4].substring(0, values[4].indexOf('-')));
	        		if(values[4].indexOf('-') + 1 != values[4].length()){
	        			values[4] = values[4].substring(values[4].indexOf('-') + 1);
	        			break;
	        		}	        		
	        	}
	        	
	        	while(values[5].indexOf('-') != -1){
	        		thursday.add(values[5].substring(0, values[5].indexOf('-')));
	        		if(values[5].indexOf('-') + 1 != values[5].length()){
	        			values[5] = values[5].substring(values[5].indexOf('-') + 1);
	        			break;
	        		}	        		
	        	}
	        	
	        	while(values[6].indexOf('-') != -1){
	        		friday.add(values[6].substring(0, values[6].indexOf('-')));
	        		if(values[6].indexOf('-') + 1 != values[6].length()){
	        			values[6] = values[6].substring(values[6].indexOf('-') + 1);
	        			break;
	        		}	        		
	        	}
	        	
	        	while(values[7].indexOf('-') != -1){
	        		saturday.add(values[7].substring(0, values[7].indexOf('-')));
	        		if(values[7].indexOf('-') + 1 != values[7].length()){
	        			values[7] = values[7].substring(values[7].indexOf('-') + 1);
	        			break;
	        		}	        		
	        	}
	        	weeks.add(new Week(values[0], sunday, monday, tuesday, wednesday, thursday, friday, saturday));
	        
	        }
			JOptionPane.showMessageDialog(null, "Success!");
			fileReader.close();
		} catch(Exception e){
			JOptionPane.showMessageDialog(null, "ERROR: Was unable to export.");
		}
	}
}
