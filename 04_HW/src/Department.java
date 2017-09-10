
public class Department {
	private String name;
	private String abbreviation;
	private DepartmentEnum departmentID;
	private SchoolEnum schoolID; 
	 // Department Name, Department Abbreviation, This DepartmentEnum, SchoolEnum (for reference)
	public Department(String name, String abbreviation, DepartmentEnum departmentID, SchoolEnum schoolID) {
		this.name = name;
		this.abbreviation = abbreviation;
		this.departmentID = departmentID;
		this.schoolID = schoolID;
	}
}
