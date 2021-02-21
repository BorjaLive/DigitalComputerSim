package com.b0ve.simuladores.sucutucuengine.Generico;

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
        salidas.put("y1", estado);
    }
    
}
