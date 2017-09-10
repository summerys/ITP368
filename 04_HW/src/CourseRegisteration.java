import java.util.ArrayList;

public class CourseRegisteration {

	ArrayList<School> SchoolList;
	ArrayList<Department> DepartmentList;
	ArrayList<Course> CourseList;
	ArrayList<Section> SectionList;
	
	public CourseRegisteration() {
		SchoolList = new ArrayList<School>();
		DepartmentList = new ArrayList<Department>();
		CourseList = new ArrayList<Course>();
		SectionList = new ArrayList<Section>();
	}
	
	public static void main(String[] args) {
		CourseRegisteration myCourse = new CourseRegisteration();
		myCourse.initializeCourses();
		System.out.println("Welcome to USC course registration page!");
		
	}
	
	public void initializeCourses() {
		
		SchoolList.add(new School("Viterbi School of Engineering", SchoolEnum.Viterbi));
		SchoolList.add(new School("Roski School of Art and Design", SchoolEnum.Roski));
		SchoolList.add(new School("Marshall School of Business", SchoolEnum.Marshall));
		SchoolList.add(new School("Annenberg School for Communication and Journalism", SchoolEnum.Annenberg));
		
		 // Department Name, Department Abbreviation, This DepartmentEnum, SchoolEnum (for reference)
		DepartmentList.add(new Department("Chemical Engineering", "CHE", DepartmentEnum.CHE, SchoolEnum.Viterbi));
		DepartmentList.add(new Department("Computer Science", "CSCI", DepartmentEnum.CSCI, SchoolEnum.Viterbi));
		DepartmentList.add(new Department("Electrical Engineering", "EE", DepartmentEnum.EE, SchoolEnum.Viterbi));
		DepartmentList.add(new Department("Art", "ART", DepartmentEnum.ART, SchoolEnum.Roski));
		DepartmentList.add(new Department("Critical Studies", "CRIT", DepartmentEnum.CRIT, SchoolEnum.Roski));
		DepartmentList.add(new Department("Design", "DES", DepartmentEnum.DES, SchoolEnum.Roski));
		DepartmentList.add(new Department("Business Administration", "BUAD", DepartmentEnum.BUAD, SchoolEnum.Marshall));
		DepartmentList.add(new Department("Management and Organization", "MOR", DepartmentEnum.MOR, SchoolEnum.Marshall));
		DepartmentList.add(new Department("Marketing", "MKT", DepartmentEnum.MKT, SchoolEnum.Marshall));
		DepartmentList.add(new Department("Communication", "COMM", DepartmentEnum.COMM, SchoolEnum.Annenberg));
		DepartmentList.add(new Department("Journalism", "JOUR", DepartmentEnum.JOUR, SchoolEnum.Annenberg));
		DepartmentList.add(new Department("Public Relations", "PR", DepartmentEnum.PR, SchoolEnum.Annenberg));
		
		 // Course Name, CourseNumber, This CourseEnum, DepartmentEnum (for reference), SchoolEnum (for reference)
		CourseList.add(new Course("Introduction to Chemical Engineering", "CHE120", CourseEnum.CHE120, DepartmentEnum.CHE, SchoolEnum.Viterbi));
		CourseList.add(new Course("Numerical Methods in Chemical Engineering", "CHE205", CourseEnum.CHE205, DepartmentEnum.CHE, SchoolEnum.Viterbi));
		CourseList.add(new Course("Introduction to Engineering Biology", "CHE301g", CourseEnum.CHE301g, DepartmentEnum.CHE, SchoolEnum.Viterbi));
		CourseList.add(new Course("Data Structures and Object Orietned Design", "CSCI104L", CourseEnum.CSCI104L, DepartmentEnum.CSCI, SchoolEnum.Viterbi));
		CourseList.add(new Course("Introduction to Programming", "CSCI103L", CourseEnum.CSCI103L, DepartmentEnum.CSCI, SchoolEnum.Viterbi));
		CourseList.add(new Course("Principles of Software Development", "CSCI201", CourseEnum.CSCI201, DepartmentEnum.CSCI, SchoolEnum.Viterbi));
		CourseList.add(new Course("Introduction to Electrical Engineering", "EE105", CourseEnum.EE105, DepartmentEnum.EE , SchoolEnum.Viterbi));
		CourseList.add(new Course("Introduction to Embedded Systems", "EE109L", CourseEnum.EE109L, DepartmentEnum.EE, SchoolEnum.Viterbi));
		CourseList.add(new Course("Applied Linear Algebra for Engineering", "EE141L", CourseEnum.EE141L, DepartmentEnum.EE, SchoolEnum.Viterbi));
		CourseList.add(new Course("Art and Design StudioI", "ART105", CourseEnum.ART105, DepartmentEnum.ART, SchoolEnum.Roski));
		CourseList.add(new Course("Drawing for Art and Design", "ART110", CourseEnum.ART110, DepartmentEnum.ART, SchoolEnum.Roski));
		CourseList.add(new Course("Painting I", "ART120", CourseEnum.ART120, DepartmentEnum.ART, SchoolEnum.Roski));
		CourseList.add(new Course("Histories of Art, Design and Visual Culture", "CRIT150gp", CourseEnum.CRIT150gp, DepartmentEnum.CRIT, SchoolEnum.Roski));
		CourseList.add(new Course("Critical Theory in Art, esign and Visual Culture", "CRIT160g", CourseEnum.CRIT160g, DepartmentEnum.CRIT, SchoolEnum.Roski));
		CourseList.add(new Course("Global Art, Design and Visual Culture since 1960", "CRIT350gw", CourseEnum.CRIT350gw, DepartmentEnum.CRIT, SchoolEnum.Roski));
		CourseList.add(new Course("", "DES102", CourseEnum.DES102, DepartmentEnum.DES, SchoolEnum.Roski));
		CourseList.add(new Course("", "DES105", CourseEnum.DES105, DepartmentEnum.DES, SchoolEnum.Roski));
		CourseList.add(new Course("", "DES110", CourseEnum.DES110, DepartmentEnum.DES, SchoolEnum.Roski));
		CourseList.add(new Course("", "BUAD100x", CourseEnum.BUAD100x, DepartmentEnum.BUAD, SchoolEnum.Marshall));
		CourseList.add(new Course("", "BUAD101", CourseEnum.BUAD101, DepartmentEnum.BUAD, SchoolEnum.Marshall));
		CourseList.add(new Course("", "BUAD200x", CourseEnum.BUAD200x, DepartmentEnum.BUAD, SchoolEnum.Marshall));
		CourseList.add(new Course("", "MOR461", CourseEnum.MOR461, DepartmentEnum.MOR, SchoolEnum.Marshall));
		CourseList.add(new Course("", "MOR462", CourseEnum.MOR462, DepartmentEnum.MOR, SchoolEnum.Marshall));
		CourseList.add(new Course("", "MOR469", CourseEnum.MOR469, DepartmentEnum.MOR, SchoolEnum.Marshall));
		CourseList.add(new Course("", "MKT402", CourseEnum.MKT402, DepartmentEnum.MKT, SchoolEnum.Marshall));
		CourseList.add(new Course("", "MKT405", CourseEnum.MKT405, DepartmentEnum.MKT, SchoolEnum.Marshall));
		CourseList.add(new Course("", "MKT410", CourseEnum.MKT410, DepartmentEnum.MKT, SchoolEnum.Marshall));
		CourseList.add(new Course("", "COMM200", CourseEnum.COMM200, DepartmentEnum.COMM, SchoolEnum.Annenberg));
		CourseList.add(new Course("", "COMM204", CourseEnum.COMM204, DepartmentEnum.COMM, SchoolEnum.Annenberg));
		CourseList.add(new Course("", "COMM205x", CourseEnum.COMM205x, DepartmentEnum.COMM, SchoolEnum.Annenberg));
		CourseList.add(new Course("", "JOUR200w", CourseEnum.JOUR200w, DepartmentEnum.JOUR, SchoolEnum.Annenberg));
		CourseList.add(new Course("", "JOUR201", CourseEnum.JOUR201, DepartmentEnum.JOUR, SchoolEnum.Annenberg));
		CourseList.add(new Course("", "JOUR205", CourseEnum.JOUR205, DepartmentEnum.JOUR, SchoolEnum.Annenberg));
		CourseList.add(new Course("", "PR209", CourseEnum.PR209, DepartmentEnum.PR, SchoolEnum.Annenberg));
		CourseList.add(new Course("", "PR250", CourseEnum.PR250, DepartmentEnum.PR, SchoolEnum.Annenberg));
		CourseList.add(new Course("", "PR253", CourseEnum.PR253, DepartmentEnum.PR, SchoolEnum.Annenberg));

		// (String sectionNum, int takenSeats, int totalSeats, String days, int startTime, int finishTime,
		//String professor, String location, SectionEnum sectionID, CourseEnum courseID, 
		//DepartmentEnum departmentID, TypeEnum typeID)
		SectionList.add(new Section("29490", 20, 30, "MWF" , 12, 1, "Ted Lee",
				"VHE206", SectionEnum.S29490, CourseEnum.CHE120, DepartmentEnum.CHE, SchoolEnum.Viterbi, TypeEnum.Lecture));
	}
}
