

public enum SearchMenu{
	NUM01("Search by School", "School"),
	NUM02("Search by Department", "Department"),
	NUM03("Search by Class", "Class"),
	NUM04("Return to Main Menu", "Menu");

	private String displayString;
	private String category;
	private SearchMenu(String display, String category){
		this.displayString = display;
		this.category = category;
	}
	
	public String getDisplayString(){
		return this.displayString;
	}
	
	public String getCategory(){
		return category;
	}

	public static String displayMenu(){
		String menu = "\n***** Select an option *****";
	
		for(SearchMenu m : SearchMenu.values()){
			menu += "\n" + (m.ordinal() + 1) + ": " + m.getDisplayString();
			
		}
		menu+="\n**********************************************\n";
		return menu;
	}

}
