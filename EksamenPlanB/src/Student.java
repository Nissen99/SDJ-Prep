import java.util.ArrayList;

public class Student
{

  private int studentNumber;
  private String name;
  private ArrayList<Course> courses;
  private ArrayList<Grade> grades;

  public Student(int studentNumber, String name)
  {
    this.studentNumber = studentNumber;
    this.name = name;
    courses = new ArrayList<>();
    grades = new ArrayList<>();
  }

  public void addCourse(Course course){
    courses.add(course);
  }

  public void addGrade(int grade, Course course){

   if (courses.contains(course))
   {
     grades.add(new Grade(grade, course));
   }

  }

  public double getGradeAverage(){

    double counter = 0;

    for (int i = 0; i < grades.size(); i++)
    {
      counter += grades.get(i).getGrade();
    }

    return counter/grades.size();

  }

  public Grade[] getAllGrades(){
    Grade[] gradesArray = new Grade[grades.size()];

    for (int i = 0; i < grades.size(); i++)
    {
      gradesArray[i] = grades.get(i).copy();
    }

    return gradesArray;
  }

  public Course[] getAllCourses(){

    Course[] courseArray = courses.toArray(new Course[courses.size()]);

    return courseArray;
  }





  public int getStudentNumber()
  {
    return studentNumber;
  }

  public String getName()
  {
    return name;
  }
}
