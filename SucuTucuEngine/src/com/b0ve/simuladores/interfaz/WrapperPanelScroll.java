package com.b0ve.simuladores.interfaz;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class WrapperPanelScroll extends JScrollPane {
    
    private ReglaVentanaPrincipal reglaH, reglaV;
    private JScrollBar scrollH, scrollV;
    
    public WrapperPanelScroll(final Component view) {
        super(view);
        iniciar();
    }
   
    private void iniciar() {
        scrollH = this.getHorizontalScrollBar();
        scrollV = this.getVerticalScrollBar();
       
        AdjustmentListener al = (AdjustmentEvent e) -> {
            repaint();
        };
       
        scrollH.addAdjustmentListener(al);
        scrollV.addAdjustmentListener(al);
    }
    
    public void setReglas(final ReglaVentanaPrincipal reglaH,
            final ReglaVentanaPrincipal reglaV) {
        this.reglaH = reglaH;
        this.reglaV = reglaV;
    }
    
    @Override
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        actualizar(g.getClipBounds());
    }
   
    private void actualizar(final Rectangle r) {
        if (reglaH != null && reglaV != null) {
            Rectangle rv = r;
            rv.width = VentanaPrincipal.ANCHO_EDITOR;
            reglaH.setViewport(rv);
            rv = r;
            rv.height = VentanaPrincipal.ALTO_EDITOR;
            reglaV.setViewport(rv);
        }
    }
    
}
