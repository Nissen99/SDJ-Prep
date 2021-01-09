import java.text.SimpleDateFormat;
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

    if (hasValidTime(start, end))
    {
      this.date = date.copy();
      this.start = start.copy();
      this.end = end.copy();
      this.topic = topic;
      this.resources = new ArrayList<>();
      this.resources.addAll(Arrays.asList(resources));
    }

  }

  public String getTopic(){
    return topic;
  }

  public Date getDate(){
    return date.copy();
  }

  public File[] getResources(){
    File[] other = (File[]) resources.toArray();
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

    if (minutes<=120)
    {
      Time startTester = new Time(start.convertToSeconds() + minutes * 60);
      Time endTester = new Time(end.convertToSeconds() + minutes * 60);

      if (hasValidTime(startTester, endTester))
      {
        start = startTester;
        end = endTester;
      }
    }
  }



  //%02d laver tal til mindst 2 langt, padder med 0 hvis det er under 10
  public String getDateTimeString(){

    String[] dateString = date.toString().split("-");

    String dateStringFormat =  String.format("%02d", Integer.parseInt(dateString[0])) + "/" +
        String.format("%02d", Integer.parseInt(dateString[1])) + "/" +
        String.format("%02d",Integer.parseInt(dateString[2]));

    String timeStartFormat = String.format("%02d", start.getHour()) + ":" +
        String.format("%02d", start.getMinute()) + ":" +
        String.format("%02d", start.getSecond());

    String timeEndFormat = String.format("%02d", end.getHour()) + ":" +
        String.format("%02d", end.getMinute()) + ":" +
        String.format("%02d", end.getSecond());

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
