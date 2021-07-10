package com.b0ve.simuladores.interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JComponent;

public class ReglaVentanaPrincipal extends JComponent {
    
    public static final int PULGADAS = Toolkit.getDefaultToolkit().getScreenResolution();
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    public static final int SIZE = 24;
    
    private final int orientacion;
    private boolean enSistemaMetrico;
    private int incremento;
    private int unidades;
    
    private Rectangle view;
    
    public ReglaVentanaPrincipal(final int orientacion, final boolean enSistemaMetrico) {
        this.orientacion = orientacion;
        this.enSistemaMetrico = enSistemaMetrico;
        setIncrementoUnidades();
        view = null;
    }
    
    public void setEnSistemaMetrico(final boolean enSistemaMetrico) {
        this.enSistemaMetrico = enSistemaMetrico;
        setIncrementoUnidades();
        repaint();
    }
    
    private void setIncrementoUnidades() {
        if (enSistemaMetrico) {
            // Puntos por centimetro en pantalla
            unidades = (int)((double) PULGADAS / (double)2.54);
            incremento = unidades;
            //System.out.println("Unidades: " + unidades);
        } else {
            unidades = PULGADAS;
            incremento = unidades / 2;
        }
    }
    
    public boolean enSistemaMetrico() {
        return this.enSistemaMetrico;
    }
    
    public int getIncremento() {
        return this.incremento;
    }
    
    public void setPreferredWidth(final int width) {
        setPreferredSize(new Dimension(width, SIZE));
    }
    
    public void setPreferredHeight(final int height) {
        setPreferredSize(new Dimension(SIZE, height));
    }
    
    public void setViewport(final Rectangle view) {
        this.view = view;
    }
    
    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        
        Rectangle dibujo = view;
        
        if (dibujo != null) {
            // Fondo
            g.setColor(Color.WHITE);
            g.fillRect(dibujo.x, dibujo.y, dibujo.width, dibujo.height);

            // Marcas de la regla
            g.setFont(new Font("Arial", Font.CENTER_BASELINE, 10));
            g.setColor(Color.BLACK);

            int ini, fin, espaciado;
            String texto;

            // Calcular la primera y última marca
            if (orientacion == HORIZONTAL) {
                ini = (dibujo.x / incremento) * incremento;
                fin = (((dibujo.x + dibujo.width) / incremento) + 1) * incremento;
            } else {
                ini = (dibujo.y / incremento) * incremento;
                fin = (((dibujo.y + dibujo.height) / incremento) + 1) * incremento;
            }

            // Dibujar el 0 debajo de la marca para que quepa
            if (ini == 0) {
                texto = "0" + (enSistemaMetrico ? "cm" : "in");
                espaciado = 10;
                if (orientacion == HORIZONTAL) {
                    g.drawLine(0, SIZE - 1, 0, SIZE - espaciado - 1);
                    g.drawString(texto, 4, 12);
                } else {
                    g.drawLine(SIZE - 1, 0, SIZE - espaciado - 1, 0);
                    g.drawString(texto, 2, 10);
                }
                ini = incremento;
            }

            // Resto de marcas
            for (int i = ini; i < fin; i+= incremento) {
                if (i % unidades == 0) {
                    espaciado = 6;
                    texto = "" + (i / unidades);
                } else {
                    espaciado = 3;
                    texto = null;
                }

                if (espaciado != 0) {
                    if (orientacion == HORIZONTAL) {
                        g.drawLine(i, SIZE - 1, i, SIZE - espaciado - 1);
                        if (texto != null) g.drawString(texto, i - (texto.length()*3), 12);
                    } else {
                        g.drawLine(SIZE - 1, i, SIZE - espaciado - 1, i);
                        if (texto != null) g.drawString(texto, 8 - (texto.length()-1)*2, i - 2);
                    }
                }
            }
        }
    }
}
