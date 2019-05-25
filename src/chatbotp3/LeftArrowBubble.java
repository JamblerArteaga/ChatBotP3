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

public class LeftArrowBubble extends JPanel {

    private int strokeThickness = 5;
    private int padding = strokeThickness / 2;
    private int radius = 10;
    private int arrowSize = 6;

    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        final Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setColor(new Color(0.5f, 0.8f, 1f));
        int x = padding + strokeThickness + arrowSize;
        int width = getWidth() - arrowSize - (strokeThickness * 2);
        int height = getHeight() - strokeThickness;
        graphics2D.fillRect(x, padding, width, height);
        graphics2D.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
        graphics2D.setStroke(new BasicStroke(strokeThickness));
        RoundRectangle2D.Double rect = new RoundRectangle2D.Double(x, padding, width, height, radius, radius);
        Polygon arrow = new Polygon();
        arrow.addPoint(14, 6);
        arrow.addPoint(arrowSize + 2, 10);
        arrow.addPoint(14, 12);
        Area area = new Area(rect);
        area.add(new Area(arrow));
        graphics2D.draw(area);

        RenderingHints qualityHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        qualityHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        //graphics2D.dispose();
    }

}
