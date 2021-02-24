package com.b0ve.simuladores.sucutucuengine.componentes.utilidades;

import com.b0ve.simuladores.sucutucuengine.Componente;

public abstract class DisplayHexadecimal extends Componente {
    
    private String numero;
    
    public DisplayHexadecimal(long id, String[] entradas) {
        super(id, entradas, new String[]{});
    }
    
    public String getNumero() {
        return numero;
    }
    
    @Override
    public void generarSalidas() {
        String input = "";
        for (String e : this.nombreEntradas) {
            String x = (leer(e)) ? "1" : "0";
            input += x;
        }
        int n = Integer.parseInt(input, 2);
        numero = Integer.toString(n, 16);
    }
    
}
