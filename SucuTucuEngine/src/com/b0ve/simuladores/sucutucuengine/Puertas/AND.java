package com.b0ve.simuladores.sucutucuengine.Puertas;

import com.b0ve.simuladores.sucutucuengine.Componente;


public class AND extends Componente{

    public AND(long id){
        super(id, new String[]{"x1", "x2"}, new String[]{"y1"});
    }

    @Override
    protected void generarSalidas() {
        escribir("y1", leer("x1") && leer(("x2")));
    }
    
}
