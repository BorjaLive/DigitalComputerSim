package com.b0ve.simuladores.interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import javax.swing.Scrollable;
import javax.swing.SwingConstants;

public class PanelCentralScroll extends JPanel implements Scrollable, MouseMotionListener {

    private int incrementoMax = 4;
    
    public PanelCentralScroll(int incremento) {
        incrementoMax = incremento;
        iniciar();
    }
    
    private void iniciar() {
        setOpaque(true);
        setBackground(new Color(0xBDC3C7));
        setAutoscrolls(false);
        addMouseMotionListener(this);
    }
    
    @Override
    public void mouseMoved(MouseEvent e) {}
    
    @Override
    public void mouseDragged(MouseEvent e) {
        Rectangle r = new Rectangle(e.getX(), e.getY(), 1, 1);
        scrollRectToVisible(r);
    }
    
    @Override
    public Dimension getPreferredScrollableViewportSize() {
        return getPreferredSize();
    }
    
    @Override
    public Dimension getPreferredSize() {
        return super.getPreferredSize();
    }

    @Override
    public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
        int posActual;
        if (orientation == SwingConstants.HORIZONTAL)
            posActual = visibleRect.x;
        else posActual = visibleRect.y;
        
        if (direction < 0) {
            int posNueva = posActual - (posActual / incrementoMax) * incrementoMax;
            return (posNueva == 0) ? incrementoMax : posNueva;
        } else {
            return ((posActual / incrementoMax) + 1) * incrementoMax - posActual;
        }
    }

    @Override
    public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
        if (orientation == SwingConstants.HORIZONTAL)
            return visibleRect.width - incrementoMax;
        else return visibleRect.height - incrementoMax;
    }

    @Override
    public boolean getScrollableTracksViewportWidth() {
        return false;
    }

    @Override
    public boolean getScrollableTracksViewportHeight() {
        return false;
    }
    
    public void setIncrementoMax(final int incremento) {
        this.incrementoMax = incremento;
    }
    
}
