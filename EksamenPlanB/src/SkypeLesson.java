public class SkypeLesson extends OnlineLesson
{

  private String link;

  public SkypeLesson(String topic, Date date, File[] resources, Time start,
      Time end, boolean screenSharing, String link)
  {
    super(topic, date, resources, start, end, screenSharing);
  this.link = link;
  }

  public String getInviteLink(){
    return link;
  }

  @Override public String nameOfSoftware()
  {
    return "Skype";
  }


  public String toString(){
    return super.toString() + "\nget invite link: " + getInviteLink();
  }
}
