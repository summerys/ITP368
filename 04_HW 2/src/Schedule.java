import java.util.ArrayList;

public class Schedule implements CourseFunctionalities {
	ArrayList<Course> addedCourses; 
	
	// Constructor 
	public Schedule(){
		addedCourses = new ArrayList<Course>(); 
	}
	
	// Add a class
	public void addCourse(Course c){
		addedCourses.add(c); 
	}
	
	// Delete a class
	public void deleteCourse(Course c){
		for(int i=0; i<addedCourses.size(); i++){
			if(addedCourses.get(i).equals(c)){
				addedCourses.remove(i);
				break; 
			}
		}
	}
	
	// delete
//	public ArrayList<Course> getAddedCourses(){
//		return addedCourses; 
//	}
	
	
	@Override
	// Finds course in your courselist
	public Course findCourse(String courseNumber){
		for(int i=0; i<addedCourses.size(); i++){
			Course c = addedCourses.get(i); 
			if(c.getCourseNumber().equals(courseNumber)){
				return c; 
			}
		}
		return null; 
	}
	

	@Override
	// Returns your current courselist
	public ArrayList<Course> getCourses() {
		return addedCourses; 
	}

	@Override
	// Prints courselist as a list
	public void printCourses() {
		for(int i=0; i<addedCourses.size(); i++){
			Course c = addedCourses.get(i); 
			System.out.println("   " + c.getCourseNumber() + "  " + c.getCourseName());
		}
	}
	

	
	// Displays weekly schedule
	// TODO: 
	public void display(){
		String scheduleStr = "Mon     Tue     Wed     Thu     Fri";
		System.out.println(scheduleStr);
	}


}
