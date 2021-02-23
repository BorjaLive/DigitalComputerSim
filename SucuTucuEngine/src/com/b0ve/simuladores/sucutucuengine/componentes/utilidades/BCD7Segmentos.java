package com.b0ve.simuladores.sucutucuengine.componentes.utilidades;

import com.b0ve.simuladores.sucutucuengine.Componente;
import java.util.HashMap;
import java.util.Map;

public class BCD7Segmentos extends Componente {
    
    // Estados en los que puede estar el 7 Segmentos.
    // Los booleanos del array representan, por orden, los
    // segmentos: arriba superior, izquierda superior, derecha superior,
    // central, izquierda inferior, derecha inferior, abajo inferior.
    private final boolean estados[][] = {
        {true, true, true, false, true, true, true},
        {true, true, true, true, true, true, true},
        {false, true, true, true, false, true, false},
        {false, true, true, true, false, false, false},
        {true, false, true, true, true, false, true},
        {false, false, false, true, true, false, true},
        {false, true, false, true, true, true, true},
        {false, true, false, true, true, false, true},
        {false, false, true, false, false, true, false},
        {true, true, true, true, false, true, false},
        {true, true, false, true, false, true, true},
        {true, true, false, true, false, false, true},
        {true, false, true, true, false, true, true},
        {false, false, false, true, false, true, true},
        {true, false, true, false, false, true, false},
        {false, false, false, false, false, false, false}
    };
    
    private final Map<String, Integer> queEstado;
    
    public BCD7Segmentos(long id) {
        super(id, new String[]{"x1","x2","x3","x4"},
                new String[]{"y1","y2","y3","y4","y5","y6","y7"});
        
        queEstado = new HashMap<>();
        queEstado.put("0000", 0); queEstado.put("0001", 1);
        queEstado.put("0010", 2); queEstado.put("0011", 3);
        queEstado.put("0100", 4); queEstado.put("0101", 5);
        queEstado.put("0110", 6); queEstado.put("0111", 7);
        queEstado.put("1000", 8); queEstado.put("1001", 9);
        queEstado.put("1010", 10); queEstado.put("1011", 11);
        queEstado.put("1100", 12); queEstado.put("1101", 13);
        queEstado.put("1110", 14); queEstado.put("1111", 15);
    }
    
    @Override
    protected void generarSalidas() {
        String input = "";
        for (String nombreEntrada : this.nombreEntradas) {
            String nuevo = leer(nombreEntrada) ? "1" : "0";
            input += nuevo;
        }
        
        final int sal = queEstado.get(input);
        boolean[] salidas = estados[sal];
        
        for (int i = 0; i < salidas.length; i++)
            escribir(this.nombreSalidas[i], salidas[i]);
    }
    
}
