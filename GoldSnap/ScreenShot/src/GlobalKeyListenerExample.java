import java.awt.AWTException;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import org.apache.commons.io.FileUtils;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;

public class GlobalKeyListenerExample
  extends JFrame
  implements NativeKeyListener, ActionListener, NativeMouseInputListener
{
  public int ScreenshotController = 1;
  private JButton button;
  private JButton button2;
  private JButton Insertcomment;
  private JButton QcScript;
  private JTextField Textbox;
  private JTextField Comment;
  String text;
  boolean Returnvalue;
  Image bgimage = null;
  static String FileType;
  boolean Displaymessage = true;
  JLabel label1 = new JLabel("Your file is saved at Location\n ");
  JLabel label3 = new JLabel("Please minimize the Pop-up");
  JLabel label4 = new JLabel(
    "And Continue to press PrtSc to save screenshots");
  JLabel EmptyText = new JLabel("please enter the name of the Excel");
  JLabel DuplicateFil = new JLabel(
    "The file Already exists in the Location");
  JLabel CommentLabel = new JLabel("Comment");
  JLabel ExcelName = new JLabel("File Name");
  JLabel label2 = new JLabel(excelFileNamefinal);
  Rename Rename = new Rename();
  JOptionPane pane = new JOptionPane();
  static String excelFileNamefinal;
  static int intital = 1;
  static int i = 10;
  FolderScreation FolderScreation = new FolderScreation();
  Screenshot ScrnShot = new Screenshot();
  JPanel CreationPanel;
  static int mouseclicked = 1;
  
  public GlobalKeyListenerExample()
    throws IOException
  {
    if (intital == 1)
    {
      try
      {
        UIManager.LookAndFeelInfo[] arrayOfLookAndFeelInfo;
        int k = (arrayOfLookAndFeelInfo = UIManager.getInstalledLookAndFeels()).length;
        for (int j = 0; j < k; j++)
        {
          UIManager.LookAndFeelInfo info = arrayOfLookAndFeelInfo[j];
          if ("Nimbus".equals(info.getName()))
          {
            UIManager.setLookAndFeel(
              info.getClassName());
            break;
          }
        }
      }
      catch (Exception localException1) {}
      setSize(100, 100);
      
      setLocationRelativeTo(null);
      
      this.button2 = new JButton("Save As Excel");
      this.QcScript = new JButton("Save As Qcscript");
      this.Insertcomment = new JButton("Insertcomment");
      this.Textbox = new JTextField(10);
      
      this.Textbox.setSize(300, 100);
      this.Comment = new JTextField(10);
      this.Comment.setSize(300, 100);
      
      ClassLoader classLoader = getClass().getClassLoader();
      
      Image image = null;
      
      BufferedImage picture = null;
      BufferedImage Icon = null;
      try
      {
        picture = ImageIO.read(new FileInputStream("res/background.PNG"));
        Icon = ImageIO.read(new FileInputStream("res/Capture.PNG"));
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
      image = new ImageIcon(picture).getImage();
      
      setIconImage(Toolkit.getDefaultToolkit().getImage(
        "res/background.PNG"));
      
      setContentPane(new JLabel(new ImageIcon(picture)));
      setDefaultCloseOperation(3);
      setIconImage(Icon);
      setTitle("GOLD CAPTURE");
      setLayout(new FlowLayout());
      add(this.ExcelName);
      add(this.Textbox);
      add(this.button2);
      add(this.QcScript);
      add(this.CommentLabel);
      add(this.Comment);
      add(this.Insertcomment);
      this.ExcelName.setForeground(Color.white);
      this.CommentLabel.setForeground(Color.white);
      
      pack();
      
      setVisible(true);
      
      pack();
      this.Textbox.addActionListener(this);
      
      this.button2.addActionListener(this);
      this.QcScript.addActionListener(this);
      this.Insertcomment.addActionListener(this);
      intital += 1;
    }
  }
  
  public String getexcel()
  {
    return excelFileNamefinal;
  }
  
  public void setexcel(String text)
  {
    excelFileNamefinal = "C:\\Autocapture\\" + text + ".xls";
  }
  
  public boolean TextCheck(String text)
  {
    boolean TextCheck = false;
    if (text.equals(""))
    {
      add(this.EmptyText);
      this.EmptyText.setForeground(Color.white);
      setVisible(true);
      remove(this.label1);
      remove(this.label2);
      remove(this.label3);
      remove(this.label4);
      remove(this.DuplicateFil);
      
      repaint();
      TextCheck = true;
    }
    return TextCheck;
  }
  
  public void setRow()
  {
    i += 65;
  }
  
  public void setRowbyTwo()
  {
    i += 2;
  }
  
  public int getRow()
  {
    return i;
  }
  
  public void nativeKeyPressed(NativeKeyEvent ae)
  {
    System.out.println("Screencontroller and mouseclicked are" + 
      this.ScreenshotController + mouseclicked);
    
    shortfunc(ae, FileType);
  }
  
  public void nativeKeyReleased(NativeKeyEvent e) {}
  
  public void nativeKeyTyped(NativeKeyEvent e) {}
  
  public static void main(String[] args)
    throws IOException
  {
    Prerequisites Prerequisites = new Prerequisites();
    GlobalKeyListenerExample GlobalKeyListenerExample = new GlobalKeyListenerExample();
    try
    {
      GlobalScreen.registerNativeHook();
    }
    catch (NativeHookException ex)
    {
      System.err.println("There was a problem registering the native hook.");
      System.err.println(ex.getMessage());
      
      System.exit(1);
    }
    EventQueue.invokeLater(new Runnable()
    {
      public void run() {}
    });
    GlobalScreen.addNativeKeyListener(new GlobalKeyListenerExample());
    
    GlobalScreen.addNativeMouseListener(new GlobalKeyListenerExample());
  }
  
  public void actionPerformed(ActionEvent ae)
  {
    String action = ae.getActionCommand();
    if (action.equals("Save As Excel"))
    {
      System.out.println(FileType);
      this.text = this.Textbox.getText();
      
      boolean textCheck = TextCheck(this.text);
      if (textCheck) {
        return;
      }
      setexcel(this.text);
      
      boolean DuplicateFile = this.FolderScreation
        .DuplicateFile(this.text);
      
      System.out.println("Duplicate file is" + DuplicateFile);
      if (DuplicateFile)
      {
        remove(this.EmptyText);
        remove(this.label1);
        remove(this.label2);
        remove(this.label3);
        remove(this.label4);
        add(this.DuplicateFil);
        this.DuplicateFil.setForeground(Color.white);
        setVisible(true);
        repaint();
      }
      else
      {
        i = 10;
        
        remove(this.EmptyText);
        remove(this.DuplicateFil);
        remove(this.label2);
        
        this.label2 = new JLabel(excelFileNamefinal);
        add(this.label1);
        add(this.label2);
        add(this.label3);
        add(this.label4);
        
        this.label1.setForeground(Color.white);
        this.label2.setForeground(Color.white);
        this.label3.setForeground(Color.white);
        this.label4.setForeground(Color.white);
        this.EmptyText.setForeground(Color.white);
        this.DuplicateFil.setForeground(Color.white);
        
        setVisible(true);
        repaint();
        
        this.FolderScreation.FolderScreation(this.text);
        FileType = "SaveFile";
        
        System.out
          .println("Excelfilename in actionperformend" + 
          excelFileNamefinal);
      }
    }
    if (action.equals("Save As Qcscript"))
    {
      System.out.println("FileType is " + FileType);
      this.text = this.Textbox.getText();
      TextCheck(this.text);
      System.out.println(this.text);
      boolean textCheck = TextCheck(this.text);
      if (textCheck) {
        return;
      }
      setexcel(this.text);
      
      String source = "C:\\Autocapture\\Prerequisites\\QCScript.xls";
      
      String target = "C:\\Autocapture\\";
      
      File sourceFile = new File(source);
      String name = sourceFile.getName();
      System.out.println("Source file name is" + name);
      File targetFile = new File(target + name);
      System.out.println("Copying file : " + 
        sourceFile.getName() + " from Java Program");
      try
      {
        FileUtils.copyFile(sourceFile, targetFile);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
      System.out.println("copying of file from Java program is completed");
      boolean DuplicateFile = this.FolderScreation
        .DuplicateFile(this.text);
      if (DuplicateFile)
      {
        remove(this.EmptyText);
        remove(this.label1);
        remove(this.label2);
        remove(this.label3);
        remove(this.label4);
        
        add(this.DuplicateFil);
        setVisible(true);
        repaint();
      }
      else
      {
        i = 10;
        remove(this.EmptyText);
        remove(this.label2);
        this.label2 = new JLabel(excelFileNamefinal);
        remove(this.DuplicateFil);
        add(this.label1);
        add(this.label2);
        add(this.label3);
        add(this.label4);
        
        this.label1.setForeground(Color.white);
        this.label2.setForeground(Color.white);
        this.label3.setForeground(Color.white);
        this.label4.setForeground(Color.white);
        
        setVisible(true);
        repaint();
        this.Rename.Rename(this.text);
        FileType = "QcScript";
      }
      System.out.println("Duplicate file is" + DuplicateFile);
    }
    if (action.equals("Insertcomment"))
    {
      String CommentText = this.Comment.getText();
      try
      {
        this.Returnvalue = this.ScrnShot.InsertComment(excelFileNamefinal, i, 
          CommentText, FileType);
        if (this.Returnvalue)
        {
          this.pane.setMessage("Please close the Excel  " + 
            excelFileNamefinal);
          JDialog dialog = this.pane.createDialog(
            null, "GOLD CAPTURE");
          dialog.setAlwaysOnTop(true);
          dialog.show();
        }
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
      catch (AWTException e)
      {
        e.printStackTrace();
      }
    }
  }
  
  public void nativeMouseClicked(NativeMouseEvent e)
  {
    System.out.println("Mouse is clicked");
    mouseclicked = 1;
  }
  
  public void nativeMousePressed(NativeMouseEvent arg0) {}
  
  public void nativeMouseReleased(NativeMouseEvent arg0) {}
  
  public void nativeMouseDragged(NativeMouseEvent arg0) {}
  
  public void nativeMouseMoved(NativeMouseEvent arg0) {}
  
  public void shortfunc(NativeKeyEvent ae, String FileType)
  {
    if ((ae.getKeyCode() == 3639) && (
      (this.ScreenshotController == 1) || (mouseclicked == 1)))
    {
      System.out.println(FileType);
      try
      {
        excelFileNamefinal = getexcel();
        System.out
          .println("excelfilename in nativekeypressed" + 
          excelFileNamefinal);
        if (FileType == "QcScript") {
          this.Returnvalue = this.ScrnShot
            .ScreenshotQcScript(excelFileNamefinal);
        }
        if (FileType == "SaveFile") {
          this.Returnvalue = this.ScrnShot
            .ScreenshotSaveFile(excelFileNamefinal);
        }
        if (this.Returnvalue)
        {
          this.pane.setMessage("Please close the Excel  " + 
            excelFileNamefinal);
          JDialog dialog = this.pane.createDialog(
            null, "GOLD CAPTURE");
          dialog.setAlwaysOnTop(true);
          dialog.show();
        }
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
      catch (AWTException e)
      {
        e.printStackTrace();
      }
      this.ScreenshotController = 0;
      mouseclicked = 0;
      System.out.println("ScreenshotController" + 
        this.ScreenshotController);
    }
    else if ((ae.getKeyCode() != 3639) || 
      (this.ScreenshotController != 0))
    {
      this.ScreenshotController = 1;
      mouseclicked = 1;
    }
  }
}
