package com.b0ve.simuladores.sucutucuengine.componentes.utilidades;

import com.b0ve.simuladores.sucutucuengine.Componente;


public class Led extends Componente{
    
    private boolean estado;
    
    public Led(long id){
        super(id, new String[]{"x1"}, new String[]{});
        estado = false;
    }
    
    public boolean getEstado(){
        return estado;
    }

    @Override
    protected void generarSalidas() {
        estado = leer("x1");
    }
    
}
