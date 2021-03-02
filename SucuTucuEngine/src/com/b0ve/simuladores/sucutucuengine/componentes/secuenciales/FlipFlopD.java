package com.b0ve.simuladores.sucutucuengine.componentes.secuenciales;

public class FlipFlopD extends FlipFlopSecuencial{

    public FlipFlopD(long id) {
        super(id, new String[]{"d"});
    }

    @Override
    void generarEstado() {
        boolean d = leer("d");
        if(d){
            //Set
            setEstado();
        }else{
            //Reset
            resetEstado();
        }
    }
}
