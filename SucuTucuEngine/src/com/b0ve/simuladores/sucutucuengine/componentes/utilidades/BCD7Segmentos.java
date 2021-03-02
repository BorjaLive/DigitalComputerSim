package com.b0ve.simuladores.sucutucuengine.componentes.utilidades;

import com.b0ve.simuladores.sucutucuengine.Componente;

public class BCD7Segmentos extends Componente {
    
    // Estados en los que puede estar el 7 Segmentos.
    // Los booleanos del array representan, por orden, los
    // segmentos: arriba superior, izquierda superior, derecha superior,
    // central, izquierda inferior, derecha inferior, abajo inferior.
    private final boolean estados[][] = {
        {true, true, true, false, true, true, true},
        {false, false, true, false, false, true, false},
        {true, false, true, true, true, false, true},
        {true, false, true, true, false, true, true},
        {false, true, true, true, false, true, false},
        {true, true, false, true, false, true, true},
        {false, true, false, true, true, true, true},
        {true, false, true, false, false, true, false},
        {true, true, true, true, true, true, true},
        {true, true, true, true, false, true, false},
        {false, false, false, true, true, false, true},
        {false, false, false, true, false, true, true},
        {false, true, true, true, false, false, false},
        {true, true, false, true, false, false, true},
        {false, true, false, true, true, false, true},
        {false, false, false, false, false, false, false}
    };
    
    public BCD7Segmentos(long id) {
        super(id, new String[]{"x1","x2","x3","x4"},
                new String[]{"y1","y2","y3","y4","y5","y6","y7"});
    }
    
    @Override
    protected void generarSalidas() {
        String input = "";
        for (String nombreEntrada : this.nombreEntradas) {
            String nuevo = leer(nombreEntrada) ? "1" : "0";
            input += nuevo;
        }
        
        final int sal = Integer.parseInt(input, 2);
        boolean[] salidas = estados[sal];
        
        for (int i = 0; i < salidas.length; i++)
            escribir(this.nombreSalidas.get(i), salidas[i]);
    }
    
}
