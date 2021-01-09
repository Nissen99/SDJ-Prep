public class DiscordLesson extends OnlineLesson
{
  private String channelName;
  private boolean voiceChannel;

  public DiscordLesson(String topic, Date date, File[] resources, Time start,
      Time end, boolean screenSharing, String channelName, boolean voiceChannel)
  {
    super(topic, date, resources, start, end, screenSharing);
    this.channelName = channelName;
    this.voiceChannel = voiceChannel;
  }

  public String getChannelName()
  {
    return channelName;
  }

  public boolean usesVoiceChannel()
  {
    return voiceChannel;
  }

  @Override public String nameOfSoftware()
  {
    return "Discord";
  }

  public String toString(){
   return super.toString() + "\nChannel Name: " + channelName + " will we be using voice " + usesVoiceChannel();
  }
}
