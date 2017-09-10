
public class Course {
	private String courseName; 
	private String courseNumber;
	private CourseEnum courseID;
	private DepartmentEnum departmentID;
	private SchoolEnum schoolID;
	
	 // Course Name, CourseNumber, This CourseEnum, DepartmentEnum (for reference), SchoolEnum (for reference)
	public Course(String courseName, String courseNumber, CourseEnum courseID, DepartmentEnum departmentID, SchoolEnum schoolID) {
		this.courseName = courseName;
		this.courseNumber = courseNumber;
		this.courseID = courseID;
		this.departmentID = departmentID;
		this.schoolID = schoolID;
	}
}
