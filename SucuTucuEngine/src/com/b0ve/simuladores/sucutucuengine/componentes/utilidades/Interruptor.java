package com.b0ve.simuladores.sucutucuengine.componentes.utilidades;

import com.b0ve.simuladores.sucutucuengine.Componente;
import com.b0ve.simuladores.sucutucuengine.Componente;


public class Interruptor extends Componente{

    boolean estado;
    
    public Interruptor(long id){
        super(id, new String[]{}, new String[]{"y1"});
        estado = false;
    }
    
    public void setEstado(boolean e){
        this.estado = e;
    }

    @Override
    protected void generarSalidas() {
        escribir("y1", estado);
    }
    
}
