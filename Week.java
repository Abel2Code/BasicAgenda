package agenda;

import java.util.ArrayList;
import java.util.List;

public class Week implements Cloneable{
	private String weekTitle;
	private List<String> sunday = new ArrayList<String>();
	private List<String> monday = new ArrayList<String>();
	private List<String> tuesday = new ArrayList<String>();
	private List<String> wednesday = new ArrayList<String>();
	private List<String> thursday = new ArrayList<String>();
	private List<String> friday = new ArrayList<String>();
	private List<String> saturday = new ArrayList<String>();
	
	public Week(String weekTitle){
		this.weekTitle = weekTitle;
	}

	public List<String> getSunday() {
		return sunday;
	}

	public void setSunday(List<String> sunday) {
		this.sunday = sunday;
	}

	public List<String> getMonday() {
		return monday;
	}

	public void setMonday(List<String> monday) {
		this.monday = monday;
	}

	public List<String> getTuesday() {
		return tuesday;
	}

	public void setTuesday(List<String> tuesday) {
		this.tuesday = tuesday;
	}

	public List<String> getWednesday() {
		return wednesday;
	}

	public void setWednesday(List<String> wednesday) {
		this.wednesday = wednesday;
	}

	public List<String> getThursday() {
		return thursday;
	}

	public void setThursday(List<String> thursday) {
		this.thursday = thursday;
	}

	public List<String> getFriday() {
		return friday;
	}

	public void setFriday(List<String> friday) {
		this.friday = friday;
	}

	public List<String> getSaturday() {
		return saturday;
	}

	public void setSaturday(List<String> saturday) {
		this.saturday = saturday;
	}
	
	public String getWeekTitle(){
		return weekTitle;
	}
	
	public void setWeekTitle(String weekTitle){
		this.weekTitle = weekTitle;
	}
	
	public String toString(){
		return weekTitle;
	}
	
	public Week clone(){
		Week newWeek;
		try{
			newWeek = (Week) super.clone();
			newWeek.setSunday(makeDeepCopy(sunday));
			newWeek.setMonday(makeDeepCopy(monday));
			newWeek.setTuesday(makeDeepCopy(tuesday));
			newWeek.setWednesday(makeDeepCopy(wednesday));
			newWeek.setThursday(makeDeepCopy(thursday));
			newWeek.setFriday(makeDeepCopy(friday));
			newWeek.setSaturday(makeDeepCopy(saturday));			
		} catch(CloneNotSupportedException e){
			e.printStackTrace();
			return null;
		}
		return newWeek;
	}
	
	public static List<String> makeDeepCopy(List<String> toCopy){
		List<String> tempList = new ArrayList<String>();
		
		for(String interval: toCopy){
			tempList.add(interval);
		}
		
		return tempList;
	}
}
