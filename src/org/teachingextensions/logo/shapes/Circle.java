package org.teachingextensions.logo.shapes;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import org.teachingextensions.logo.Paintable;
import org.teachingextensions.logo.PenColors;
import org.teachingextensions.windows.ProgramWindow;

/**
 * <img src="http://www2.psd100.com/ppp/2013/11/2701/Blue-circle-1127210229.png" align="left" >
 * The Circle allows you to draw circles on the window
 */
public class Circle implements Paintable
{
  private final int   radius;
  private final Color mainColor;
  private int         x;
  private int         y;
  private int         percentTransparent;
  public Circle(int radius, Color color)
  {
    this.radius = radius;
    this.mainColor = color;
  }
  /**
   * Sets the center the circle
   * <div><b>Example:</b> {@code  circle.setCenter(8,10)}</div>
   * 
   * @param x
   *          The x value
   * @param y
   *          The y value
   */
  public void setCenter(int x, int y)
  {
    this.x = x;
    this.y = y;
  }
  /**
   * Adds a circle to the window
   * <div><b>Example:</b> {@code  circle.addTo(panel)}</div>
   * 
   * @param panel
   *          the ProgramWindow or panel
   */
  public void addTo(ProgramWindow panel)
  {
    panel.addPaintable(this);
  }
  /**
   * Paints a circle
   * <div><b>Example:</b> {@code  circle.paint(g,caller)}</div>
   * 
   * @param g
   *          the graphics object
   * @param caller
   *          the Program Window or panel
   */
  @Override
  public void paint(Graphics2D g, JPanel caller)
  {
    Color color2 = PenColors.getTransparentVersion(mainColor, percentTransparent);
    g.setColor(color2);
    g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
  }
  /**
   * Sets the transparency of the circle
   * <div><b>Example:</b> {@code  circle.setTransparency(80)}</div>
   * 
   * @param percentTransparent
   *          The percentage of transparency of the circle
   */
  public void setTransparency(int percentTransparent)
  {
    this.percentTransparent = percentTransparent;
  }
}
