public abstract class OnlineLesson extends Lesson
{

  private boolean screenSharing;

  public OnlineLesson(String topic, Date date, File[] resources, Time start,
      Time end, boolean screenSharing)
  {
    super(topic, date, resources, start, end);
    this.screenSharing = screenSharing;
  }

  public boolean teacherWillShareScreen(){
    return screenSharing;
  }


  public abstract String nameOfSoftware();

  public String toString(){

    return super.toString() + "\nlesson will be on " + nameOfSoftware()+ "\nWas teacher screen sharing " + screenSharing;
  }

}
