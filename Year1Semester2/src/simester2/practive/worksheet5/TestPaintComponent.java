package simester2.practive.worksheet5;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestPaintComponent extends JFrame 
{
  public TestPaintComponent()                          {
	System.out.println("enter TestPaintComponent");   
    add(new NewPanel());      
    System.out.println("leave TestPaintComponent");    }
  public static void main(String[] args)        {
	System.out.println("create frame");   
    TestPaintComponent frame = new TestPaintComponent();
    frame.setTitle("TestPaintComponent");
    frame.setSize(200, 100);
    frame.setLocationRelativeTo(null); //Center the frame   
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setAlwaysOnTop(true);
    frame.setVisible(true);             
    System.out.println("leave main"); }
}
class NewPanel extends JPanel 
{ 
  protected void paintComponent(Graphics g)               {
	System.out.println("enter NewPanel paintComponent");   
    super.paintComponent(g);
    g.drawLine(0, 0, 50, 50);
    g.drawString("Banner", 0, 40);          
    System.out.println("leave NewPanel paintComponent");  }
}