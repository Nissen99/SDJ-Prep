public class SlideshowFile extends File
{

  private int numberOfSlides;

  public SlideshowFile(String fileName, String extension, int numberOfSlides)
  {
    super(fileName, extension);
    this.numberOfSlides = numberOfSlides;
  }


  public int getNumberOfSlides()
  {
    return numberOfSlides;
  }
}
