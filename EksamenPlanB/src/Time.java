public class Time
{
  private int hour;
  private int minute;
  private int second;



  public Time(int h, int m, int s){
    this.hour = h;
    this.minute = m;
    this.second = s;
  }


  public Time(int totalTimeInSeconds){

    this.hour = totalTimeInSeconds / 3600;
    this.minute = (totalTimeInSeconds % 3600) / 60;
    this.second = ((totalTimeInSeconds % 3600) % 60);

  }



  public void tic(){
    second++;
    if (second > 59)
    {
      minute++;
      second = 0;

      if (minute > 59)
      {
        hour++;
        minute = 0;
      }
    }
  }

  public void tic(int seconds){
    for (int i = 0; i < seconds; i++)
    {
      tic();
    }
  }


  public int convertToSeconds(){
    int counter = 0;

    counter += hour * 3600;
    counter += minute * 60;
    counter += second;

    return counter;
  }


  public boolean isBefore(Time time2){

    if (convertToSeconds() > time2.convertToSeconds())
    {
      return true;
    }
    return false;
  }

  public Time timeTo(Time time){
    int timeToSec = time.convertToSeconds() - convertToSeconds();

    Time other = new Time(timeToSec);
    return other;
  }

  public Time copy(){

    Time copy = new Time(convertToSeconds());
    return copy;
  }

  public boolean equals(Object obj){

    if (!(obj instanceof Time))
    {
      return false;
    }

    Time other = (Time) obj;
    return other.convertToSeconds() == convertToSeconds();
  }

  public String toString(){

    return hour + ":" + minute + ":" + second;
  }

  public int getHour()
  {
    return hour;
  }

  public int getMinute()
  {
    return minute;
  }

  public int getSecond()
  {
    return second;
  }
}
