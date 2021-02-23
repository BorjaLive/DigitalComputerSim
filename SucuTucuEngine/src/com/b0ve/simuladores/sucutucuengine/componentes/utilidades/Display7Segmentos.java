
package com.b0ve.simuladores.sucutucuengine.componentes.utilidades;

import com.b0ve.simuladores.sucutucuengine.Componente;

public class Display7Segmentos extends Componente {

    private boolean estado[];
    
    public Display7Segmentos(long id) {
        super(id, new String[]{"x1","x2","x3","x4","x5","x6","x7"}, new String[]{});
        estado = new boolean[7];
        for(int i = 0; i < 7; i++) estado[i] = false;
    }
    
    public boolean[] getEstado() {
        return estado;
    }
    
    @Override
    protected void generarSalidas() {
        for (int i = 0; i < 7; i++)
            estado[i] = leer(this.nombreEntradas[i]);
    }
    
}
