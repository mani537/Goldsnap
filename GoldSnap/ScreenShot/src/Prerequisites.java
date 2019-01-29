import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class Prerequisites
{
  public Prerequisites()
  {
    String targetroot = "C:\\Autocapture";
    String targetchild = "C:\\Autocapture\\Prerequisites\\";
    File theDirroot = new File(targetroot);
    File theDirchild = new File(targetchild);
    if (!theDirroot.exists())
    {
      System.out.println("creating directory: " + theDirroot.getName());
      boolean result = false;
      try
      {
        theDirroot.mkdir();
        result = true;
      }
      catch (SecurityException localSecurityException) {}
      if (result) {
        System.out.println("DIR created");
      }
    }
    if (!theDirchild.exists())
    {
      System.out.println("creating directory: " + theDirchild.getName());
      boolean result = false;
      try
      {
        theDirchild.mkdir();
        result = true;
      }
      catch (SecurityException localSecurityException1) {}
      if (result) {
        System.out.println("Child DIR created");
      }
      InputStream stream = null;
      OutputStream resStreamOut = null;
      try
      {
        ClassLoader classLoader = getClass().getClassLoader();
        stream = classLoader.getResourceAsStream("res/QCScript.xls");
        if (stream == null) {
          throw new Exception("Cannot get resource ");
        }
        byte[] buffer = new byte['?'];
        
        resStreamOut = new FileOutputStream("C:\\Autocapture\\Prerequisites\\QCScript.xls");
        int readBytes;
        while ((readBytes = stream.read(buffer)) > 0)
        {
    //      int readBytes;
          resStreamOut.write(buffer, 0, readBytes);
        }
      }
      catch (Exception ex)
      {
        System.out.println(ex);
      }
      System.out.println("copying of file from Java program is completed");
    }
  }
}
