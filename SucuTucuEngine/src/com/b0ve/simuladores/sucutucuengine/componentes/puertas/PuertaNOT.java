package com.b0ve.simuladores.sucutucuengine.componentes.puertas;

import com.b0ve.simuladores.sucutucuengine.Componente;


public class PuertaNOT extends Componente{

    public PuertaNOT(long id){
        super(id, new String[]{"x1"}, new String[]{"y1"});
    }

    @Override
    protected void generarSalidas() {
        escribir("y1", !leer("x1"));
    }
    
}
