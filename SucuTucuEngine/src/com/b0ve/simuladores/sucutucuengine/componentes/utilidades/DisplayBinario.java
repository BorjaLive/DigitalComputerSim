package com.b0ve.simuladores.sucutucuengine.componentes.utilidades;

import com.b0ve.simuladores.sucutucuengine.Componente;

public abstract class DisplayBinario extends Componente {
    
    private String numero;
    
    public DisplayBinario(long id, String[] entradas) {
        super(id, entradas, new String[]{});
    }
    
    public String getNumero() {
        return numero;
    }
    
    @Override
    protected void generarSalidas() {
        numero = "";
        for (String e : this.getNombreEntradas()) {
            String x = (leer(e)) ? "1" : "0";
            numero += x;
        }
    }
}
