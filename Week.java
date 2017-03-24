package agenda;

import java.util.ArrayList;
import java.util.List;

public class Week {
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
}
