package com.b0ve.simuladores.sucutucuengine.componentes.secuenciales;

public class FlipFlopJK extends FlipFlopSecuencial{

    public FlipFlopJK(long id) {
        super(id, new String[]{"j", "k"});
    }

    @Override
    void generarEstado() {
            boolean j = leer("j"), k = leer("k");
        if(j){
            if(k){
                //Toggle
                toggleEstado();
            }else{
                //Set
                setEstado();
            }
        }else{
            if(k){
                //Reset
                resetEstado();
            }else{
                //Latch
            }
        }
    }
}
