package org.teachingextensions.windows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.teachingextensions.logo.Colors;
import org.teachingextensions.logo.ImageBackground;
import org.teachingextensions.logo.Paintable;
import org.teachingextensions.logo.VirtualProctorWeb;

import com.spun.util.FrameCloser;
import com.spun.util.WindowUtils;

/**
 * <img src="http://ftpmirror.your.org/pub/wikimedia/images/wikibooks/de/2/2c/JPanel_Add_JButton_PAGE_END.JPG" align="left" >
 * Program Window allows you to change the color of the background and more...
 */
@SuppressWarnings({"serial", "deprecation"})
public class ProgramWindow extends JPanel
{
  private ArrayList<Paintable> additional = new ArrayList<Paintable>();
  public ProgramWindow(String title)
  {
    this();
    JFrame frame = new JFrame(title);
    frame.getContentPane().add(this);
    ProgramWindow.createStandardFrame(frame);
  }
  public ProgramWindow()
  {
    setPreferredSize(new Dimension(627, 442));
    setColor(Colors.Whites.White);
  }
  public static void createStandardFrame(JFrame frame)
  {
    WindowUtils.testFrame(frame, new VirtualProctorWeb(), new FrameCloser());
  }
  @Override
  public void paint(Graphics g)
  {
    super.paint(g);
    for (Paintable p : additional)
    {
      p.paint((Graphics2D) g, this);
    }
  }
  public void setColor(Color backgroundColor)
  {
    setBackground(backgroundColor);
  }
  public void addPaintable(Paintable additional)
  {
    this.additional.add(additional);
    repaint();
  }
  public void removePaintable()
  {
    additional.clear();
    repaint();
  }
  public void addMouseRightClickListener(MouseRightClickListener listener)
  {
    addMouseListener(new RightClickMouseAdapter(listener));
  }
  public void addMouseLeftClickListener(MouseLeftClickListener listener)
  {
    addMouseListener(new LeftClickMouseAdapter(listener));
  }
  public void setBackgroundImage(String url)
  {
    addPaintable(new ImageBackground(url));
  }
}
