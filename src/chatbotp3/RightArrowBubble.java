/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbotp3;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

public class RightArrowBubble extends JPanel {

  private int strokeThickness = 5;
        private int padding = strokeThickness / 2;
        private int arrowSize = 6;
        private int radius = 10;

        @Override
        protected void paintComponent(final Graphics g) {
            final Graphics2D graphics2D = (Graphics2D) g;
            graphics2D.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
            graphics2D.setColor(new Color(20, 130, 230));
            graphics2D.setStroke(new BasicStroke(strokeThickness));
            int width = getWidth() - arrowSize - (strokeThickness * 2);
            int height = getHeight() - strokeThickness;
            graphics2D.fillRect(padding, padding, width, height);
            RoundRectangle2D.Double rect = new RoundRectangle2D.Double(padding, padding, width, height, radius, radius);
            Polygon arrow = new Polygon();
            arrow.addPoint(width, 6);
            arrow.addPoint(width + arrowSize, 10);
            arrow.addPoint(width, 12);
            Area area = new Area(rect);
            area.add(new Area(arrow));
            graphics2D.draw(area);
//            RenderingHints qualityHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//            qualityHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            
            //graphics2D.dispose();
        }
    
    
}
