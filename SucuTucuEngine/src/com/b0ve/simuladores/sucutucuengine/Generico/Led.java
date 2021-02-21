package com.b0ve.simuladores.sucutucuengine.Generico;

import com.b0ve.simuladores.sucutucuengine.Componente;


public class Led extends Componente{
    
    public Led(long id){
        super(id, new String[]{"x1"}, new String[]{});
    }
    
    public Boolean getEstado(){
        return leer("x1");
    }

    @Override
    protected void generarSalidas() {
    }
    
}
