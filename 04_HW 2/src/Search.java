import java.util.Scanner;

public class Search {
	
	private Scanner sc;
	School school;
	Department department;
	Course course;
	SchoolEnum schoolEnum;
	DepartmentEnum departmentEnum;
	CourseEnum courseEnum;
	String category;
	
	public Search() {
		sc = new Scanner(System.in);
	}
	
	public void SearchByCategory(SearchMenu searchMenu) {	
		category = searchMenu.getCategory();
		String choice;
		System.out.println("Please choose " + category);
		
		if(category.equals("School")) { 
			for(SchoolEnum value: SchoolEnum.values()) {
				 System.out.println(value.ordinal() + ": " + value);
			}
			
			choice = sc.nextLine();
			if (isInt(choice))
			{
				DisplayCourse(SchoolEnum.values()[Integer.parseInt(choice)]);
			}
		}
		else if(category.equals("Department")) {
			for(DepartmentEnum value: DepartmentEnum.values()) {
				 System.out.println(value.ordinal() + ": " + value);
			}
			choice = sc.nextLine();
			if (isInt(choice))
			{
				DisplayCourse(DepartmentEnum.values()[Integer.parseInt(choice)]);
			}
			
		}
		else if(category.equals("Class")) {
			for(CourseEnum value: CourseEnum.values()) {
				 System.out.println(value.ordinal() + ": " + value);
			}
			 choice = sc.nextLine();
			 if (isInt(choice))
				{
					DisplayCourse(CourseEnum.values()[Integer.parseInt(choice)]);
				}
		}
	}
	
	Boolean isInt(String value) {  
	     try {  
	         Integer.parseInt(value);  
	         return true;  
	      } catch (NumberFormatException e) {  
	         return false;  
	      }  
	}
	
	public void DisplayCourse(SchoolEnum e) {
		School school = CourseRegisteration.SchoolMap.get(e);
		school.Display();
	}
	
	public void DisplayCourse(DepartmentEnum e) {
		Department department = CourseRegisteration.DepartmentMap.get(e);
		department.Display();
	}
	
	public void DisplayCourse(CourseEnum e) {
		Course course = CourseRegisteration.CourseMap.get(e);
		course.Display();
	}
	
	
	
	
}
