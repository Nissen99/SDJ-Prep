public class File
{
  private String fileName;
  private String extension;

  public File(String fileName, String extension)
  {
    this.fileName = fileName;
    this.extension = extension;
  }


  public boolean isPDF(){
    if (extension.equals("PDF") || extension.equals("pdf")){
      return true;
    }
    return false;
  }

  public boolean equals(Object obj){
    if (!(obj instanceof File)){
    return false;
    }

    File other = new File(this.fileName, this.extension);
    return other.fileName.equals(this.fileName) && other.extension.equals(this.extension);
  }

  public String toString(){
    return fileName + "." + extension;
  }


}
