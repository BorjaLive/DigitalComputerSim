package com.b0ve.simuladores.interfaz;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public class EsquinaReglaVentanaPrincipal extends JComponent {
    
    @Override
    protected void paintComponent(final Graphics g) {
        g.setColor(new Color(0x7F8C8D));
        g.fillRect(0, 0, getWidth(), getHeight());
    }
    
}
