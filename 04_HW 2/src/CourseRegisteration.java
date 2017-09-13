import java.util.ArrayList;
import java.util.HashMap;

public class CourseRegisteration implements CourseFunctionalities {

	static HashMap<SchoolEnum, School> SchoolMap;
	static HashMap<DepartmentEnum, Department> DepartmentMap;
	static HashMap<CourseEnum, Course> CourseMap;
	static HashMap<SectionEnum, Section> SectionMap;

	public CourseRegisteration() {
		SchoolMap = new HashMap<SchoolEnum, School>();
		DepartmentMap = new HashMap<DepartmentEnum, Department>();
		CourseMap = new HashMap<CourseEnum, Course>();
		SectionMap = new HashMap<SectionEnum, Section>();
		initializeCourses();
		initializeHierarchies();
	}

	public void initializeCourses() {

		SchoolMap.put(SchoolEnum.Viterbi, new School("Viterbi School of Engineering", SchoolEnum.Viterbi));
		SchoolMap.put(SchoolEnum.Roski, new School("Roski School of Art and Design", SchoolEnum.Roski));
		SchoolMap.put(SchoolEnum.Marshall, new School("Marshall School of Business", SchoolEnum.Marshall));
		SchoolMap.put(SchoolEnum.Annenberg,
				new School("Annenberg School for Communication and Journalism", SchoolEnum.Annenberg));

		// Department Name, Department Abbreviation, This DepartmentEnum, SchoolEnum
		// (for reference)
		DepartmentMap.put(DepartmentEnum.CHE, new Department("Chemical Engineering", "CHE", SchoolEnum.Viterbi));
		DepartmentMap.put(DepartmentEnum.CSCI, new Department("Computer Science", "CSCI", SchoolEnum.Viterbi));
		DepartmentMap.put(DepartmentEnum.EE, new Department("Electrical Engineering", "EE", SchoolEnum.Viterbi));
		DepartmentMap.put(DepartmentEnum.ART, new Department("Art", "ART", SchoolEnum.Roski));
		DepartmentMap.put(DepartmentEnum.CRIT, new Department("Critical Studies", "CRIT", SchoolEnum.Roski));
		DepartmentMap.put(DepartmentEnum.DES, new Department("Design", "DES", SchoolEnum.Roski));
		DepartmentMap.put(DepartmentEnum.BUAD, new Department("Business Administration", "BUAD", SchoolEnum.Marshall));
		DepartmentMap.put(DepartmentEnum.MOR,
				new Department("Management and Organization", "MOR", SchoolEnum.Marshall));
		DepartmentMap.put(DepartmentEnum.MKT, new Department("Marketing", "MKT", SchoolEnum.Marshall));
		DepartmentMap.put(DepartmentEnum.COMM, new Department("Communication", "COMM", SchoolEnum.Annenberg));
		DepartmentMap.put(DepartmentEnum.JOUR, new Department("Journalism", "JOUR", SchoolEnum.Annenberg));
		DepartmentMap.put(DepartmentEnum.PR, new Department("Public Relations", "PR", SchoolEnum.Annenberg));


		// Course Name, CourseNumber, This CourseEnum, DepartmentEnum (for reference),
		// SchoolEnum (for reference)
		CourseMap.put(CourseEnum.CHE120,
				new Course("Introduction to Chemical Engineering", "CHE120", DepartmentEnum.CHE, SchoolEnum.Viterbi));
		CourseMap.put(CourseEnum.CHE205, new Course("Numerical Methods in Chemical Engineering", "CHE205",
				DepartmentEnum.CHE, SchoolEnum.Viterbi));
		CourseMap.put(CourseEnum.CHE301g,
				new Course("Introduction to Engineering Biology", "CHE301g", DepartmentEnum.CHE, SchoolEnum.Viterbi));
		CourseMap.put(CourseEnum.CSCI104L, new Course("Data Structures and Object Orietned Design", "CSCI104L",
				DepartmentEnum.CSCI, SchoolEnum.Viterbi));
		CourseMap.put(CourseEnum.CSCI103L,
				new Course("Introduction to Programming", "CSCI103L", DepartmentEnum.CSCI, SchoolEnum.Viterbi));
		CourseMap.put(CourseEnum.CSCI201,
				new Course("Principles of Software Development", "CSCI201", DepartmentEnum.CSCI, SchoolEnum.Viterbi));
		CourseMap.put(CourseEnum.EE105,
				new Course("Introduction to Electrical Engineering", "EE105", DepartmentEnum.EE, SchoolEnum.Viterbi));
		CourseMap.put(CourseEnum.EE109L,
				new Course("Introduction to Embedded Systems", "EE109L", DepartmentEnum.EE, SchoolEnum.Viterbi));
		CourseMap.put(CourseEnum.EE141L,
				new Course("Applied Linear Algebra for Engineering", "EE141L", DepartmentEnum.EE, SchoolEnum.Viterbi));
		CourseMap.put(CourseEnum.ART105,
				new Course("Art and Design StudioI", "ART105", DepartmentEnum.ART, SchoolEnum.Roski));
		CourseMap.put(CourseEnum.ART110,
				new Course("Drawing for Art and Design", "ART110", DepartmentEnum.ART, SchoolEnum.Roski));
		CourseMap.put(CourseEnum.ART120, new Course("Painting I", "ART120", DepartmentEnum.ART, SchoolEnum.Roski));
		CourseMap.put(CourseEnum.CRIT150gp, new Course("Histories of Art, Design and Visual Culture", "CRIT150gp",
				DepartmentEnum.CRIT, SchoolEnum.Roski));
		CourseMap.put(CourseEnum.CRIT160g, new Course("Critical Theory in Art, esign and Visual Culture", "CRIT160g",
				DepartmentEnum.CRIT, SchoolEnum.Roski));
		CourseMap.put(CourseEnum.CRIT350gw, new Course("Global Art, Design and Visual Culture since 1960", "CRIT350gw",
				DepartmentEnum.CRIT, SchoolEnum.Roski));
		CourseMap.put(CourseEnum.DES102, new Course("", "DES102", DepartmentEnum.DES, SchoolEnum.Roski));
		CourseMap.put(CourseEnum.DES105, new Course("", "DES105", DepartmentEnum.DES, SchoolEnum.Roski));
		CourseMap.put(CourseEnum.DES110, new Course("", "DES110", DepartmentEnum.DES, SchoolEnum.Roski));
		CourseMap.put(CourseEnum.BUAD100x, new Course("", "BUAD100x", DepartmentEnum.BUAD, SchoolEnum.Marshall));
		CourseMap.put(CourseEnum.BUAD101, new Course("", "BUAD101", DepartmentEnum.BUAD, SchoolEnum.Marshall));
		CourseMap.put(CourseEnum.BUAD200x, new Course("", "BUAD200x", DepartmentEnum.BUAD, SchoolEnum.Marshall));
		CourseMap.put(CourseEnum.MOR461, new Course("", "MOR461", DepartmentEnum.MOR, SchoolEnum.Marshall));
		CourseMap.put(CourseEnum.MOR462, new Course("", "MOR462", DepartmentEnum.MOR, SchoolEnum.Marshall));
		CourseMap.put(CourseEnum.MOR469, new Course("", "MOR469", DepartmentEnum.MOR, SchoolEnum.Marshall));
		CourseMap.put(CourseEnum.MKT402, new Course("", "MKT402", DepartmentEnum.MKT, SchoolEnum.Marshall));
		CourseMap.put(CourseEnum.MKT405, new Course("", "MKT405", DepartmentEnum.MKT, SchoolEnum.Marshall));
		CourseMap.put(CourseEnum.MKT410, new Course("", "MKT410", DepartmentEnum.MKT, SchoolEnum.Marshall));
		CourseMap.put(CourseEnum.COMM200, new Course("", "COMM200", DepartmentEnum.COMM, SchoolEnum.Annenberg));
		CourseMap.put(CourseEnum.COMM204, new Course("", "COMM204", DepartmentEnum.COMM, SchoolEnum.Annenberg));
		CourseMap.put(CourseEnum.COMM205x, new Course("", "COMM205x", DepartmentEnum.COMM, SchoolEnum.Annenberg));
		CourseMap.put(CourseEnum.JOUR200w, new Course("", "JOUR200w", DepartmentEnum.JOUR, SchoolEnum.Annenberg));
		CourseMap.put(CourseEnum.JOUR201, new Course("", "JOUR201", DepartmentEnum.JOUR, SchoolEnum.Annenberg));
		CourseMap.put(CourseEnum.JOUR205, new Course("", "JOUR205", DepartmentEnum.JOUR, SchoolEnum.Annenberg));
		CourseMap.put(CourseEnum.PR209, new Course("", "PR209", DepartmentEnum.PR, SchoolEnum.Annenberg));
		CourseMap.put(CourseEnum.PR250, new Course("", "PR250", DepartmentEnum.PR, SchoolEnum.Annenberg));
		CourseMap.put(CourseEnum.PR253, new Course("", "PR253", DepartmentEnum.PR, SchoolEnum.Annenberg));

		// for all courses with
		
		// (String sectionNum, int takenSeats, int totalSeats, String days, int
		// startTime, int finishTime,
		// String professor, String location, SectionEnum sectionID, CourseEnum
		// courseID,
		// DepartmentEnum departmentID, TypeEnum typeID)
		SectionMap.put(SectionEnum.S29490, new Section("29490", 20, 30, "MWF", 12, 1, "Ted Lee", "VHE206",
				CourseEnum.CHE120, DepartmentEnum.CHE, SchoolEnum.Viterbi, TypeEnum.Lecture));
	}
	
	public void initializeHierarchies() {
		// Create hierarchy for each school
		for (SchoolEnum schoolEnum: SchoolMap.keySet())
		{
			for (Department department: DepartmentMap.values())
			{
				if (department.getSchoolEnum().equals(schoolEnum))
				{
					School school = SchoolMap.get(schoolEnum);
					school.AddDepartment(department);
				}
			}
		}
		
		// Create hierarchy for each department
		for (DepartmentEnum departmentEnum: DepartmentMap.keySet())
		{
			for (Course course: CourseMap.values())
			{
				if (course.getDepartmentEnum().equals(departmentEnum))
				{
					Department department = DepartmentMap.get(departmentEnum);
					department.AddCourse(course);
				}
			}
		}
		
		// Create hierarchy for each course
		for (SchoolEnum schoolEnum: SchoolMap.keySet())
		{
			for (Department department: DepartmentMap.values())
			{
				if (department.getSchoolEnum().equals(schoolEnum))
				{
					School school = SchoolMap.get(schoolEnum);
					school.AddDepartment(department);
				}
			}
		}
	}

	@Override
	public Course findCourse(String courseNumber) {
		for (int i = 0; i < CourseMap.size(); i++) {
			Course c = CourseMap.get(i);
			if (c.getCourseNumber().equals(courseNumber)) {
				return c;
			}
		}
		return null;
	}

	@Override
	public ArrayList<Course> getCourses() {
		ArrayList<Course> courseList = new ArrayList<Course>(CourseMap.values());
		return courseList;
	}

	@Override
	public void printCourses() {
		for (int i = 0; i < CourseMap.size(); i++) {
			Course c = CourseMap.get(i);
			System.out.println("   " + c.getCourseNumber() + "  " + c.getCourseName());
		}
	}

}
