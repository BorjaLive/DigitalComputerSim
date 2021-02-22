package com.b0ve.simuladores.sucutucuengine.componentes.puertas;

import com.b0ve.simuladores.sucutucuengine.Componente;


public class PuertaAND extends Componente{

    public PuertaAND(long id){
        super(id, new String[]{"x1", "x2"}, new String[]{"y1"});
    }

    @Override
    protected void generarSalidas() {
        escribir("y1", leer("x1") && leer(("x2")));
    }
    
}
