public class Date
{
  private int day;
  private int month;
  private int year;

  public Date(int day, int month, int year)
  {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  public Date copy(){
    Date other = new Date(day, month, year);
    return other;
  }


  public boolean equals(Object obj){
    if (!(obj instanceof Date)){
      return false;
    }

    Date other = (Date) obj;
    return other.day == day && other.month == month && other.year == year;

  }


  public String toString(){

    return day + "-" + month + "-" + year;
  }
}
