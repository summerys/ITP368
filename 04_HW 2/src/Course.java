import java.util.ArrayList;

public class Course implements IDisplayable {
	private String courseName; 
	private String courseNumber;
	private DepartmentEnum departmentID;
	private SchoolEnum schoolID;
	private ArrayList<Section> sections;
	
	 // Course Name, CourseNumber, This CourseEnum, DepartmentEnum (for reference), SchoolEnum (for reference)
	public Course(String courseName, String courseNumber, DepartmentEnum departmentID, SchoolEnum schoolID) {
		this.courseName = courseName;
		this.courseNumber = courseNumber;
		this.departmentID = departmentID;
		this.schoolID = schoolID;
		this.sections = new ArrayList<Section>();
	}
	
	public void Display() {
		
		System.out.println(courseName + " " +courseNumber);
		for (Section section: sections)
		{
			section.Display();
		}
	}
	
	public DepartmentEnum getDepartmentEnum() {
		return departmentID;
	}
	
	public void AddSection(Section section) {
		sections.add(section);
	}
	
	public String getCourseName(){
		return this.courseName; 
	}
	
	public String getCourseNumber(){
		return this.courseNumber;
	}
	
}
