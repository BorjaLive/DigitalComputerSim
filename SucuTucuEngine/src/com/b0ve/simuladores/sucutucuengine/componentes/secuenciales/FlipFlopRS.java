package com.b0ve.simuladores.sucutucuengine.componentes.secuenciales;

import com.b0ve.simuladores.sucutucuengine.Componente;


public class FlipFlopRS extends Componente{

    private boolean estado;
    
    public FlipFlopRS(long id){
        super(id, new String[]{"s", "r"}, new String[]{"q", "!q"});
        estado = false;
    }

    @Override
    protected void generarSalidas() {
        boolean s = leer("s"), r = leer("r");
        if(s){
            if(r){
                //Prohibido
            }else{
                //Set
                estado = true;
            }
        }else{
            if(r){
                //Reset
                estado = false;
            }else{
                //Latch
            }
        }
        escribir("q", estado);
        escribir("!q", !estado);
    }
}
