import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class FolderScreation
{
  String excelFileNamefinal;
  String text = "Test";
  File theDir = new File("C:\\Autocapture");
  File theScrDir = new File("C:\\Autocapture");
  
  public void FolderScreation(String text)
  {
    this.excelFileNamefinal = ("C:\\Autocapture\\" + text + ".xls");
    if (!this.theScrDir.exists())
    {
      System.out.println("creating directory: " + 
        this.theScrDir.getName());
      boolean result = false;
      try
      {
        this.theScrDir.mkdir();
        result = true;
      }
      catch (SecurityException localSecurityException) {}
      if (result) {
        System.out.println("DIR created");
      }
    }
    if (!this.theDir.exists())
    {
      System.out.println("creating directory: " + 
        this.theDir.getName());
      boolean result = false;
      try
      {
        this.theDir.mkdir();
        result = true;
      }
      catch (SecurityException localSecurityException1) {}
      if (result) {
        System.out.println("DIR created");
      }
    }
    Workbook wb = null;
    
    BufferedReader br = new BufferedReader(new InputStreamReader(
      System.in));
    
    wb = new HSSFWorkbook();
    
    Sheet sheet = wb
      .createSheet("Sheet1");
    
    FileOutputStream fos = null;
    try
    {
      fos = new FileOutputStream(this.excelFileNamefinal);
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }
    try
    {
      wb.write(fos);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    try
    {
      fos.flush();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    try
    {
      fos.close();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    try
    {
      br.close();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    System.out.println("excelfilename in fc" + this.excelFileNamefinal);
  }
  
  public boolean DuplicateFile(String text)
  {
    boolean DuplicateFile = false;
    
    File newFile = new File(this.theDir, text + ".xls");
    if (newFile.exists())
    {
      DuplicateFile = true;
      return DuplicateFile;
    }
    return DuplicateFile;
  }
}
