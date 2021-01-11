public class Time
{
  private int hour;
  private int minute;
  private int second;


//Overloading
  public Time(int h, int m, int s){
    this.hour = h;

    if (m >= 60){
      this.minute = m % 60;
      this.hour += m / 60;
    }
    else
    {
      this.minute = m;
    }
    if (s >= 60){
      this.second = s % 60;
      this.minute += s / 60;
      if (this.minute >= 60){
        this.hour += m / 60;
        this.minute = this.minute % 60;
      }
    }
    else {
    this.second = s;
  }

  }


  //Overloading
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


  public boolean isBefore(Time time2)
  {

    return (convertToSeconds() < time2.convertToSeconds());

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


}
