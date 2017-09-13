
public enum ViewMenu {
	NUM01("View my courselist"),
	NUM02("View my weekly schedule"),
	NUM03("Return to Main Menu");

	private String displayString;
	private ViewMenu(String display){
		this.displayString = display;
	}
	
	public String getDisplayString(){
		return this.displayString;
	}
	
	public void display(){
		
	}
	
	

	public static String displayMenu(){
		String menu = "\n***** Select an option *****";
	
		for(ViewMenu m : ViewMenu.values()){
			menu += "\n" + (m.ordinal() + 1) + ": " + m.getDisplayString();
			
		}
		menu+="\n**********************************************\n";
		return menu;
	}

}
