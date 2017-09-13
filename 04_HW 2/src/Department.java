import java.util.ArrayList;

public class Department implements IDisplayable {
	private String name;
	private String abbreviation;
	private SchoolEnum schoolID; 
	private ArrayList<Course> courses;

	 // Department Name, Department Abbreviation, This DepartmentEnum, SchoolEnum (for reference)
	public Department(String name, String abbreviation, SchoolEnum schoolID) {
		this.name = name;
		this.abbreviation = abbreviation;
		this.schoolID = schoolID;
		this.courses = new ArrayList<Course>();
	}

	public void Display() {
		System.out.println(name);
		for (Course course: courses)
		{
			course.Display();
		}
	}
	
	public void AddCourse(Course course) {
		courses.add(course);
	}
	
	public SchoolEnum getSchoolEnum() {
		return schoolID;
	}
}
