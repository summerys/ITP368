import java.util.ArrayList;

public class School implements IDisplayable{
	String name;
	ArrayList<Department> departments;
	
	public School(String name, SchoolEnum SchoolID) {
		this.name = name;
		this.departments = new ArrayList<Department>();		
	}
	
	public void Display() {
		for (Department department: departments)
		{
			department.Display();
		}
	}
	
	public void AddDepartment(Department department) {
		departments.add(department);
	}
}
