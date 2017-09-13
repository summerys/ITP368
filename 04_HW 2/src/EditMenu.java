
public enum EditMenu {
	NUM01("Add a Class"),
	NUM02("Remove a Class"),
	NUM03("Return to Main Menu");

	private String displayString;
	private EditMenu(String display){
		this.displayString = display;
	}
	
	public String getDisplayString(){
		return this.displayString;
	}
	

	

	public static String displayMenu(){
		String menu = "\n***** Select an option *****";
	
		for(EditMenu m : EditMenu.values()){
			menu += "\n" + (m.ordinal() + 1) + ": " + m.getDisplayString();
			
		}
		menu+="\n**********************************************\n";
		return menu;
	}

}
