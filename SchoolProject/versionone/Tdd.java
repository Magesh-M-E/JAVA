public class Tdd{
	public static void main(String[] args){
	System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<School Details>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	School school = new School();
	school.schoolName="ABC SCHOOL";
	school.printSchoolDetails();
	
	for(int i=0;i<4;i++){
	school.classrooms[i]= new Classroom();
	school.classrooms[i].divisionName = "1st"+i;
	school.classrooms[i].PrintClassroomDetails();}
	
	for(int i=0;i<4;i++){
	school.classrooms[i].teacher = new Teacher();
	school.classrooms[i].teacher.teacherName = "LATHA"+i;
	school.classrooms[i].teacher.gender="FEMALE"+i;
	school.classrooms[i].teacher.subject="Maths"+i;
	school.classrooms[i].teacher.printTeacherDetails();
	}
	
	for(int i=0;i<4;i++){
	
	school.classrooms[i].students[i] = new Student();
	school.classrooms[i].students[i].studentName = "RAJU";
	school.classrooms[i].students[i].studentAge = 18;
	school.classrooms[i].students[i].studentRollNo= 20;
	school.classrooms[i].students[i].printStudentDetails();
	}
	
	school.canteen = new Canteen();
	school.canteen.canteenName = "ABC";
	school.canteen.printCanteenDetails();
	
	}
	
}