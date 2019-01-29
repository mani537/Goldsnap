import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import javax.imageio.ImageIO;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFPicture;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.util.IOUtils;

public class Screenshot
{
  HSSFSheet firstSheet;
  
  public boolean ScreenshotSaveFile(String excelFileNamefinal)
    throws IOException, AWTException
  {
    Robot robot = new Robot();
    
    boolean ReturnValue = false;
    
    BufferedImage screenShot = robot
      .createScreenCapture(new Rectangle(
      Toolkit.getDefaultToolkit().getScreenSize()));
    
    ImageIO.write(screenShot, "JPG", new File(
      "C:\\Autocapture\\Prerequisites\\GOLD.jpg"));
    
    System.out.println(excelFileNamefinal);
    
    FileInputStream inputStream = new FileInputStream(new File(excelFileNamefinal));
    
    HSSFWorkbook my_workbook = null;
    try
    {
      my_workbook = new HSSFWorkbook(inputStream);
    }
    catch (IOException e1)
    {
      e1.printStackTrace();
    }
    HSSFSheet firstSheet = my_workbook.getSheetAt(0);
    
    InputStream my_banner_image = null;
    try
    {
      my_banner_image = new FileInputStream(
        "C:\\Autocapture\\Prerequisites\\GOLD.jpg");
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }
    byte[] bytes = null;
    try
    {
      bytes = IOUtils.toByteArray(my_banner_image);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    int my_picture_id = my_workbook.addPicture(bytes, 
      5);
    try
    {
      my_banner_image.close();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    HSSFPatriarch drawing = firstSheet.createDrawingPatriarch();
    
    ClientAnchor my_anchor = new HSSFClientAnchor();
    
    my_anchor.setCol1(2);
    GlobalKeyListenerExample GlobalKeyListenerExample = new GlobalKeyListenerExample();
    
    int row = GlobalKeyListenerExample.getRow();
    my_anchor.setRow1(row);
    
    HSSFPicture my_picture = drawing.createPicture(my_anchor, 
      my_picture_id);
    
    my_picture.resize();
    
    FileOutputStream out = null;
    try
    {
      excelFileNamefinal = excelFileNamefinal;
      out = new FileOutputStream(new File(excelFileNamefinal));
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
      return true;
    }
    try
    {
      my_workbook.write(out);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    try
    {
      out.close();
      GlobalKeyListenerExample.setRow();
    }
    catch (IOException localIOException1) {}
    return ReturnValue;
  }
  
  public boolean ScreenshotQcScript(String excelFileNamefinal)
    throws IOException, AWTException
  {
    Robot robot = new Robot();
    boolean ReturnValue = false;
    
    BufferedImage screenShot = robot
      .createScreenCapture(new Rectangle(
      Toolkit.getDefaultToolkit().getScreenSize()));
    
    ImageIO.write(screenShot, "JPG", new File(
      "C:\\Autocapture\\Prerequisites\\GOLD.jpg"));
    
    System.out.println(excelFileNamefinal);
    
    FileInputStream inputStream = new FileInputStream(new File(excelFileNamefinal));
    
    HSSFWorkbook my_workbook = null;
    try
    {
      my_workbook = new HSSFWorkbook(inputStream);
    }
    catch (IOException e1)
    {
      e1.printStackTrace();
    }
    System.out.println(excelFileNamefinal);
    HSSFSheet firstSheet = my_workbook.getSheetAt(1);
    
    InputStream my_banner_image = null;
    try
    {
      my_banner_image = new FileInputStream(
        "C:\\Autocapture\\Prerequisites\\GOLD.jpg");
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }
    byte[] bytes = null;
    try
    {
      bytes = IOUtils.toByteArray(my_banner_image);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    int my_picture_id = my_workbook.addPicture(bytes, 
      5);
    try
    {
      my_banner_image.close();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    HSSFPatriarch drawing = firstSheet.createDrawingPatriarch();
    
    ClientAnchor my_anchor = new HSSFClientAnchor();
    
    my_anchor.setCol1(2);
    GlobalKeyListenerExample GlobalKeyListenerExample = new GlobalKeyListenerExample();
    
    int row = GlobalKeyListenerExample.getRow();
    my_anchor.setRow1(row);
    
    HSSFPicture my_picture = drawing.createPicture(my_anchor, 
      my_picture_id);
    
    my_picture.resize();
    
    FileOutputStream out = null;
    try
    {
      excelFileNamefinal = excelFileNamefinal;
      out = new FileOutputStream(new File(excelFileNamefinal));
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
      return true;
    }
    try
    {
      my_workbook.write(out);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    try
    {
      out.close();
      GlobalKeyListenerExample.setRow();
    }
    catch (IOException localIOException1) {}
    return ReturnValue;
  }
  
  public boolean InsertComment(String excelFileNamefinal, int rownum, String CommentText, String FileType)
    throws IOException, AWTException
  {
    Robot robot = new Robot();
    boolean ReturnValue = false;
    FileInputStream inputStream = new FileInputStream(new File(
      excelFileNamefinal));
    
    int column = 2;
    
    HSSFWorkbook my_workbook = null;
    try
    {
      my_workbook = new HSSFWorkbook(inputStream);
    }
    catch (IOException e1)
    {
      e1.printStackTrace();
    }
    System.out.println(excelFileNamefinal);
    if (FileType == "QcScript") {
      this.firstSheet = my_workbook.getSheetAt(1);
    }
    if (FileType == "SaveFile") {
      this.firstSheet = my_workbook.getSheetAt(0);
    }
    ClientAnchor my_anchor = new HSSFClientAnchor();
    
    my_anchor.setCol1(2);
    GlobalKeyListenerExample GlobalKeyListenerExample = new GlobalKeyListenerExample();
    
    int row = GlobalKeyListenerExample.getRow();
    
    HSSFRow rowobj = this.firstSheet.createRow(row);
    
    System.out.println("Row is" + row);
    Cell cell = rowobj.createCell(column);
    cell.setCellValue(CommentText);
    row += 2;
    FileOutputStream out = null;
    try
    {
      excelFileNamefinal = excelFileNamefinal;
      out = new FileOutputStream(new File(excelFileNamefinal));
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
      return true;
    }
    try
    {
      my_workbook.write(out);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    try
    {
      out.close();
      GlobalKeyListenerExample.setRowbyTwo();
    }
    catch (IOException localIOException1) {}
    return ReturnValue;
  }
}
