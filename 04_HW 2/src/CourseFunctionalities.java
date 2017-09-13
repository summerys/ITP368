import java.util.ArrayList;

public interface CourseFunctionalities {
	Course findCourse(String courseNumber); 
	ArrayList<Course> getCourses(); 
	void printCourses(); 
}
