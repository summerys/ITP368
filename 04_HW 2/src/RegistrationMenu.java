
public enum RegistrationMenu {
	NUM01("Search for a class"),
	NUM02("Edit courselist"),
	NUM03("View courselist"),
	NUM04("Cancel registration"),
	NUM05("Finish registration");

	private String displayString;
	private RegistrationMenu(String display){
		this.displayString = display;
	}
	
	public String getDisplayString(){
		return this.displayString;
	}
	

	

	public static String displayMenu(){
		String menu = "\n***** Select an option *****";
	
		for(RegistrationMenu m : RegistrationMenu.values()){
			menu += "\n" + (m.ordinal() + 1) + ": " + m.getDisplayString();
			
		}
		menu+="\n**********************************************\n";
		return menu;
	}
	
	

}
