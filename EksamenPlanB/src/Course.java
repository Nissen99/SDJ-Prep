import java.util.ArrayList;
import java.util.Arrays;

public class Course
{
  private ArrayList<Lesson> schedule;
  private String name;

  public Course(String name)
  {
    this.name = name;
    schedule = new ArrayList<>();
  }

  public String getName()
  {
    return name;
  }

  public int getNumberOfLessons()
  {
    return schedule.size();
  }

  public void addLesson(Lesson lesson)
  {
    schedule.add(lesson);
  }

  public void removeLesson(Lesson lesson)
  {

    //    for (int i = 0; i < schedule.size(); i++)
    //    {
    //      if (schedule.get(i).equals(lesson)){
    //        schedule.remove(i);
    //      }
    //    }

    for (int i = 0; i < schedule.size(); i++)
    {

      //Vi har ikke equals så vi tjekker alt en Lesson består af

      boolean dateTester = schedule.get(i).getDate().equals(lesson.getDate());
      boolean topicTester = schedule.get(i).getTopic().equals(lesson.getTopic());

      String timeString[] = schedule.get(i).getDateTimeString().split(" ");
      String timeStringArgument[] = lesson.getDateTimeString().split(" ");

      boolean timeStartTester = timeString[1].equals(timeStringArgument[1]);
      boolean timeEndTester = timeString[3].equals(timeStringArgument[3]);

      boolean resourceTester = true;
      for (int j = 0; j < schedule.get(i).getResources().length; j++)
      {
        if (!(schedule.get(j).getResources()[j]
            .equals(lesson.getResources()[j])))
        {
          resourceTester = false;
          break;
        }
      }


      //Test for ONLINE LESSONS
      boolean onlineTester = true;
      if ((schedule.get(i) instanceof OnlineLesson
          && !(lesson instanceof OnlineLesson))
          || !(schedule.get(i) instanceof OnlineLesson)
          && lesson instanceof OnlineLesson)
      {
        onlineTester = false;
      }

      else if (schedule.get(i) instanceof OnlineLesson
          && lesson instanceof OnlineLesson)
      {

        OnlineLesson other = (OnlineLesson) schedule.get(i);
        OnlineLesson argument = (OnlineLesson) lesson;


        if ( !(other.nameOfSoftware().equals(argument.nameOfSoftware())) ||
            (!(other.teacherWillShareScreen() == argument.teacherWillShareScreen())))
        {
          onlineTester = false;
        }

        else if (other.nameOfSoftware().equals("Discord"))
        {

          DiscordLesson otherDiscord = (DiscordLesson) other;
          DiscordLesson argumentDiscord = (DiscordLesson) argument;

          if (!otherDiscord.getChannelName()
              .equals(argumentDiscord.getChannelName())
              || !otherDiscord.usesVoiceChannel() == argumentDiscord
              .usesVoiceChannel())
          {
            onlineTester = false;
          }
        }

        else if (other.nameOfSoftware().equals("Skype"))
        {
          SkypeLesson otherSkype = (SkypeLesson) other;
          SkypeLesson argumentSkype = (SkypeLesson) argument;

          if (!otherSkype.getInviteLink().equals(argumentSkype.getInviteLink()))
          {
            onlineTester = false;
          }
        }
      }

      if (dateTester && topicTester && timeStartTester && timeEndTester &&
      resourceTester && onlineTester){
        schedule.remove(i);
        return;
      }

    }
  }


  public boolean hasLessonOnDate ( Date date){

    for (int i = 0; i < schedule.size(); i++)
    {
      if (schedule.get(i).getDate().equals(date)){
        return true;
      }
    }
    return false;
  }


  public ArrayList<Lesson> getAllLessons(){
    return schedule;
  }

  public ArrayList<String> getAllTopics()
  {

    ArrayList<String> topics = new ArrayList<>();

    for (int i = 0; i < schedule.size(); i++)
    {

      topics.add(schedule.get(i).getTopic());
    }
    return topics;
  }


  public ArrayList<OnlineLesson> getOnlineLessons(){
    ArrayList<OnlineLesson> onlineLessons = new ArrayList<>();

    for (int i = 0; i < schedule.size(); i++)
    {
      if (schedule.get(i) instanceof OnlineLesson){
        onlineLessons.add((OnlineLesson) schedule.get(i));
      }
    }

    return onlineLessons;

  }

  public ArrayList<SkypeLesson> getSkypeLessons(){
    ArrayList<SkypeLesson> skypeLessons = new ArrayList<>();

    for (int i = 0; i < getOnlineLessons().size(); i++)
    {

      if (getOnlineLessons().get(i) instanceof SkypeLesson){
        skypeLessons.add((SkypeLesson) getOnlineLessons().get(i));
      }
    }
    return skypeLessons;
  }


  public ArrayList<DiscordLesson> getDiscordLessonsWithVoice(){
    ArrayList<DiscordLesson> discordLessonsWithVoice = new ArrayList<>();

    for (int i = 0; i < getOnlineLessons().size(); i++)
    {
      if (getOnlineLessons().get(i) instanceof DiscordLesson){

        if (((DiscordLesson) getOnlineLessons().get(i)).usesVoiceChannel()){
          discordLessonsWithVoice.add((DiscordLesson) getOnlineLessons().get(i));
        }

      }
    }
    return discordLessonsWithVoice;
  }


  public ArrayList<File> getAllResources(){
    ArrayList<File> allResources = new ArrayList<>();

    for (int i = 0; i < schedule.size(); i++)
    {
      allResources.addAll(Arrays.asList(schedule.get(i).getResources()));

    }

    return allResources;

  }


  public String toString(){

    String courseToString = name + " has: " + getNumberOfLessons() + " lessons. They are as follows";

    for (int i = 0; i < schedule.size(); i++)
    {
      courseToString += "\n" + schedule.get(i).toString() + "\n";
    }

    return courseToString;
  }



}
