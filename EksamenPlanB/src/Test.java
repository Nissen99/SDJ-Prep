public class Test
{
  public static void main(String[] args)
  {


  Time time = new Time(3665);

    System.out.println(time);


    time.tic(180);

    System.out.println(time);

    File[] newFiles = new File[2];
    File whatever3= new File("Yo", "he");
    File whatever1= new File("Yo", "he");
    File whatever2= new File("Yo", "he");

    newFiles[0] = whatever1;
    newFiles[1] = whatever2;

    Time start = new Time(8,22,34);
    Time end = new Time(19,20,43);

    System.out.println(start);
    System.out.println(end);

    Lesson lesson = new Lesson("math", new Date(3,4,2000),newFiles, start, end);

    System.out.println(lesson);

}}
