import java.util.*;


public class RegistrationMain {
	private Scanner sc;
	String username; 
	private CourseRegisteration currentRegistration;
	private Schedule schedule;
	private InputHelper inputHelper; 
	Search search;
	
	
	public RegistrationMain() {
		sc = new Scanner(System.in);		
	}
	
	public static void main(String[] args){
		RegistrationMain myCourseRegistration = new RegistrationMain();
		myCourseRegistration.beginRegistration();
		myCourseRegistration.displayMainMenu();
	}
	
	
	public void beginRegistration(){
		System.out.println("Welcome to USC Course Registration! Enter your USC username to begin your registration process.");
		username = sc.nextLine();
		// create new student
		currentRegistration = new CourseRegisteration(); 
		search = new Search();
		schedule = new Schedule(); 
		inputHelper = new InputHelper(); 	
	}
	
	public void displayMainMenu(){
		System.out.println("Hi " + this.username + "!");
		boolean finished = false;
		while (!finished){
			
			System.out.println(RegistrationMenu.displayMenu());
			
			String menuPrompt = "Choose from an option below.";  
			int choice = inputHelper.readPositiveInt(menuPrompt, 5); 
			switch(choice){
				case 1:
					System.out.println("Search");
					displaySearchMenu(); 
					break; 
				case 2: 
					System.out.println("Edit");
					displayEditMenu(); 
					break; 
				case 3: 
					System.out.println("View");
					displayViewMenu(); 
					break; 
				case 4: 
					System.out.println("Cancel");
					System.out.println("Your course registration has been canceled.");
					finished = true; 
					break; 
				case 5: 
					System.out.println("Finish");
					System.out.println("You session has been saved.");
					finished = true; 
					break; 
			}
		}
	}
	
	public void displaySearchMenu(){
		boolean finished = false;
		while (!finished){
			
			System.out.println(SearchMenu.displayMenu());
			String menuPrompt = "Select the category you would like to search by."; 
			int choice = inputHelper.readPositiveInt(menuPrompt, 4); 
			switch(choice){
				case 1:
					System.out.println(SearchMenu.NUM01.getDisplayString());
					// function for searching by school
					search.SearchByCategory(SearchMenu.NUM01);
					break; 
				case 2: 
					System.out.println(SearchMenu.NUM02.getDisplayString());
					search.SearchByCategory(SearchMenu.NUM02);
					break; 
				case 3: 
					System.out.println(SearchMenu.NUM03.getDisplayString());
					search.SearchByCategory(SearchMenu.NUM03);
					break; 
				case 4: 
					System.out.println(SearchMenu.NUM04.getDisplayString());
					search.SearchByCategory(SearchMenu.NUM04);
					finished = true; 
					break; 
			}
		}
	}
	
	public void displayEditMenu(){
		boolean finished = false;
		while (!finished){
			
			System.out.println(EditMenu.displayMenu());
			String menuPrompt = "Choose from an option below."; 
			int choice = inputHelper.readPositiveInt(menuPrompt, 3); 
			
			Course c;
			String courseNumber, prompt; 
			switch(choice){
				
				case 1: // Add a Class
					System.out.println("You chose: " + EditMenu.NUM01.getDisplayString());
					System.out.println("Offered courses: ");
					currentRegistration.printCourses();
					prompt = "Enter the courseID of the course you would like to add."; 
					courseNumber = inputHelper.readString(prompt); 
					// TODO: check if valid input
					c = currentRegistration.findCourse(courseNumber); 
					if(c == null){
						System.out.println(courseNumber + " does not exist");
					} else {  
						schedule.addCourse(c);
						System.out.println("Sucessfully added " + c.getCourseNumber() + " to your course list.");
					}
					break; 
				
				case 2: // Delete a Class
					System.out.println(EditMenu.NUM02.getDisplayString());
					if(schedule.getCourses().size() == 0){
						System.out.println("Your courselist is empty. Please add a class first");
						break; 
					}
					
					System.out.println("Your courselist: ");
					schedule.printCourses(); 
					prompt = "Enter the courseID of the course you would like to remove."; 
					courseNumber = inputHelper.readString(prompt); 
					// TODO: check if its valid class 
					c = schedule.findCourse(courseNumber); 
					if(c == null){
						System.out.println(courseNumber + " does not exist in your courselist");
					} else {  
						schedule.deleteCourse(c);
						System.out.println("Sucessfully deleted " + c.getCourseNumber() + " from your course list.");
					}
					break; 
				
				case 3: // Return to Main Menu
					System.out.println(EditMenu.NUM03.getDisplayString());
					finished = true; 
					break; 
			}
		}
	}
	
	public void displayViewMenu(){
		if(schedule.getCourses().size() == 0){
			System.out.println("Your courselist is empty. Please add a course first.");
			return; 
		}
		
		boolean finished = false;
		while (!finished){
			
			System.out.println(ViewMenu.displayMenu());
			String menuPrompt = "Choose from an option below."; 
			int choice = inputHelper.readPositiveInt(menuPrompt, 3); 
			
			switch(choice){
				case 1:
					System.out.println(ViewMenu.NUM01.getDisplayString());
					System.out.println("You have " + schedule.getCourses().size() + " class(es) in your courselist");
					schedule.printCourses();
					break; 
				case 2: 
					System.out.println(ViewMenu.NUM02.getDisplayString());
					schedule.display();
					break; 
				case 3: 
					System.out.println(ViewMenu.NUM03.getDisplayString());
					finished = true; 
					break; 
			}
		}
	}
	

}
