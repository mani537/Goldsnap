import java.io.File;

public class Rename
{
  public void Rename(String text)
  {
    File sdcard = new File("C:\\Autocapture");
    File from = new File(sdcard, "QCScript.xls");
    File to = new File(sdcard, text + ".xls");
    from.renameTo(to);
    from.delete();
  }
}
