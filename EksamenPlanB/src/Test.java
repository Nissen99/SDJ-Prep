import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Test
{
  public static void main(String[] args)
  {

    System.out.println("--------Time Test--------");

  Time time = new Time(1, 20,180);

    System.out.println(time);


    time.tic(180);

    System.out.println(time);

    File[] newFiles = new File[2];
    File whatever3= new File("Yo", "he");
    File whatever1= new File("Yo", "he");
    File whatever2= new File("Yeet", "pdf");

    newFiles[0] = whatever1;
    newFiles[1] = whatever2;

    Time start = new Time(8,22,34);
    Time end = new Time(19,20,43);

    System.out.println(start);
    System.out.println(end);

    Lesson lesson = new Lesson("math", new Date(3,4,2000),newFiles, start, end);
    lesson.delayBy(0);



    OnlineLesson online = new DiscordLesson("math", new Date(3,4,2000),newFiles, start, end, true, "Hygge rum", true);


    Course course = new Course("Math");

    course.addLesson(online);
    course.addLesson(lesson);


    System.out.println("--------Course PRINT--------");

    System.out.println(course);

    System.out.println("--------Course PRINT2--------");

    course.removeLesson(online);

    System.out.println(course);


    System.out.println("--------Student Test--------");

    Lesson philosophyLesson1 = new Lesson("Platon", new Date(19, 4, 2089),newFiles, new Time(17,29,4), new Time(18,0,0));
    Lesson philosophyLesson2 = new Lesson("Sokrates", new Date(19, 4, 2089),newFiles, new Time(17,29,4), new Time(18,0,0));
    Lesson philosophyLesson3 = new Lesson("John Locke", new Date(19, 4, 2089),newFiles, new Time(17,29,4), new Time(18,0,0));
    Lesson philosophyLesson4 = new Lesson("David Humme", new Date(19, 4, 2089),newFiles, new Time(17,29,4), new Time(18,0,0));
    Lesson philosophyLesson5 = new Lesson("Platon", new Date(19, 4, 2089),newFiles, new Time(17,29,4), new Time(18,0,0));

    Course philosophy = new Course("philosophy");
    philosophy.addLesson(philosophyLesson1);
    philosophy.addLesson(philosophyLesson2);
    philosophy.addLesson(philosophyLesson3);
    philosophy.addLesson(philosophyLesson4);
    philosophy.addLesson(philosophyLesson5);

    Course rwd = new Course("RWD");



    Grade philosophyGrade = new Grade(10, philosophy);
    Student mikkel = new Student(304077, "Mikkel");
    mikkel.addCourse(course);
    mikkel.addCourse(philosophy);
    mikkel.addGrade(10, philosophy);
    mikkel.addGrade(12, rwd);


    System.out.println("------------");
    System.out.println(mikkel.getAllGrades()[0]);

    System.out.println(mikkel.getAllCourses()[0]);

    System.out.println(mikkel.getAllCourses()[1]);

    System.out.println(mikkel.getAllGrades()[0]);



  }}
