
public class Section {
	
	private String sectionNum;
	private int takenSeats;
	private int totalSeats;
	private String days;
	private int startTime;
	private int finishTime;
	private String professor;
	private String location;
	private SectionEnum sectionID;
	private CourseEnum courseID;
	private DepartmentEnum departmentID;
	private SchoolEnum schoolID;
	private TypeEnum typeID;
	
	 
	public Section(String sectionNum, int takenSeats, int totalSeats, String days, int startTime, int finishTime,
			String professor, String location, SectionEnum sectionID, CourseEnum courseID, 
			DepartmentEnum departmentID, SchoolEnum schoolID, TypeEnum typeID) {
		
		this.sectionNum = sectionNum;
		this.takenSeats = takenSeats;
		this.totalSeats = totalSeats;
		this.days = days;
		this.startTime = startTime;
		this.finishTime = finishTime;
		this.professor = professor;
		this.location = location;
		this.sectionID = sectionID;
		this.courseID = courseID;
		this.departmentID = departmentID;
		this.schoolID = schoolID;
		this.typeID = typeID;
	}

}
