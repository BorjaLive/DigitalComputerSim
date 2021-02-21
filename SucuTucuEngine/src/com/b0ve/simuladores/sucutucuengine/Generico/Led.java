package com.b0ve.simuladores.sucutucuengine.Generico;

import com.b0ve.simuladores.sucutucuengine.Componente;


public class Led extends Componente{
    
    public Led(long id){
        super(id, new String[]{"x1"}, new String[]{});
    }
    
    public Boolean getEstado(){
        Boolean estado =  entradas.get("x1").leer();
        return estado != null && estado;
    }

    @Override
    protected void generarSalidas() {
    }
    
}
