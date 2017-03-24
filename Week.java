package agenda;

import java.util.ArrayList;
import java.util.List;

public class Week {
	private String date;
	private List<String> sunday = new ArrayList<String>();
	private List<String> monday = new ArrayList<String>();
	private List<String> tuesday = new ArrayList<String>();
	private List<String> wednesday = new ArrayList<String>();
	private List<String> thursday = new ArrayList<String>();
	private List<String> friday = new ArrayList<String>();
	private List<String> saturday = new ArrayList<String>();
	
	public Week(String date){
		this.date = date;
	}
	
	public static boolean validateDate(String date1, String date2){
		int tempMonth1 = Integer.parseInt(date1.substring(0, date1.indexOf('/')));
		int tempMonth2 = Integer.parseInt(date2.substring(0, date2.indexOf('/')));;
		int tempDay1 = Integer.parseInt(date1.substring(0, date1.indexOf('/')).substring(0, date1.indexOf('/')));
		int tempDay2 = Integer.parseInt(date2.substring(0, date2.indexOf('/')).substring(0, date2.indexOf('/')));;
		int tempYear1 = Integer.parseInt(date1.substring(0, date1.indexOf('/')).substring(0, date1.indexOf('/')).substring(date1.indexOf('/')));
		int tempYear2 = Integer.parseInt(date2.substring(0, date2.indexOf('/')).substring(0, date2.indexOf('/')).substring(date2.indexOf('/')));
		
		
		if(tempMonth1 > tempMonth2 || tempYear1 > tempYear2){
			//Get here if Month or Year (1) is greater than Month or Year (2)
			return false;
		} else if(tempMonth1 == tempMonth2){
			//Get here if same month 
			if(tempYear1 == tempYear2){
				// Get here if same month and year
			} else{
				//Get here if same month but different year
			} 
		} else if(tempMonth1 == tempMonth2 - 1 || (tempMonth1 == 12 && tempMonth2 == 1)){
			//Get here if valid Month to Month separation
		} else{
			return false;
		}
	}
}
