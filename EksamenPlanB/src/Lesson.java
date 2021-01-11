import java.util.ArrayList;
import java.util.Arrays;

public class Lesson
{
  private Date date;
  private ArrayList<File> resources;
  private Time start, end;
  private String topic;

  public Lesson(String topic, Date date, File[] resources, Time start, Time end)
  {

    if (hasValidTime(start, end) && start != null )
    {
      this.date = date.copy();
      this.start = start.copy();
      this.end = end.copy();
      this.topic = topic;
      this.resources = new ArrayList<>();
      this.resources.addAll(Arrays.asList(resources));
    }

  }


  public ArrayList<SlideshowFile> getSlideSHowsSmallerThan(int count){

    ArrayList<SlideshowFile> other = new ArrayList<>();

    for (int i = 0; i < resources.size(); i++)
    {
      if (resources.get(i) instanceof SlideshowFile){
        if (((SlideshowFile) resources.get(i)).getNumberOfSlides() < count){
          other.add((SlideshowFile) resources.get(i));
        }
      }

    }
    return other;

  }

  public String getTopic(){
    return topic;
  }

  public Date getDate(){
    return date.copy();
  }

  public File[] getResources(){
    File[] other = resources.toArray(new File[resources.size()]);
    return other;
  }

  public ArrayList<File> getAllPDFs(){
    ArrayList<File> other = new ArrayList<>();

    for (int i = 0; i < resources.size(); i++)
    {
      if (resources.get(i).isPDF()){
        other.add(resources.get(i));
      }
    }
    return other;
  }

  public Time getDuration(){
    return start.timeTo(end);
  }


  public static boolean hasValidTime(Time start, Time end){
  Time validStartTime = new Time(8,20,0);
  Time validEndTime = new Time(21,15,0);

    if (end.isBefore(start) ||start.isBefore(validStartTime) || validEndTime.isBefore(end)){
      return false;
    }
    return true;
  }



  public void delayBy(int minutes){

    if (minutes<=120 && minutes>=0)
    {
      Time startTester = new Time(start.convertToSeconds() + minutes * 60);
      Time endTester = new Time(end.convertToSeconds() + minutes * 60);

      if (hasValidTime(startTester, endTester))
      {
        start = startTester;
        end = endTester;
      }
    }
    else throw new IllegalArgumentException("Input must be between 0-120");
  }



  //%02d laver tal til mindst 2 langt, padder med 0 hvis det er under 10
  public String getDateTimeString(){

    String[] dateString = date.toString().split("-");
    String[] timeStartString = start.toString().split(":");
    String[] timeEndString = end.toString().split(":");


    String dateStringFormat =  String.format("%02d", Integer.parseInt(dateString[0])) + "/" +
        String.format("%02d", Integer.parseInt(dateString[1])) + "/" +
        String.format("%02d",Integer.parseInt(dateString[2]));

    String timeStartFormat = String.format("%02d", Integer.parseInt(timeStartString[0])) + ":" +
        String.format("%02d", Integer.parseInt(timeStartString[1])) + ":" +
        String.format("%02d", Integer.parseInt(timeStartString[2]));

    String timeEndFormat = String.format("%02d", Integer.parseInt(timeEndString[0])) + ":" +
        String.format("%02d", Integer.parseInt(timeEndString[1])) + ":" +
        String.format("%02d", Integer.parseInt(timeEndString[2]));

    return dateStringFormat + " " + timeStartFormat + " - " + timeEndFormat;


  }

  public String toString(){
    String fileNames = resources.get(0).toString();
    for (int i = 1; i < resources.size(); i++)
    {
      fileNames += ", " + resources.get(i).toString();
    }
    return "Topic: " + topic + "\nWhen it is: " + getDateTimeString() + "\nResources are files: " + fileNames;
  }



}
