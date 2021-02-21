package com.b0ve.simuladores.sucutucuengine;

import com.b0ve.simuladores.sucutucuengine.Generico.Interruptor;
import com.b0ve.simuladores.sucutucuengine.Generico.Led;
import com.b0ve.simuladores.sucutucuengine.Puertas.AND;

public class ComponenteFactory {
    private static long contador = 0;
    
    public enum Componentes {
        AND,
        INTERRUPTOR,
        LED
    }
    
    public static Componentable crearComponente(Componentes c){
        long id = contador++;
        switch(c){
            case AND: return new AND(id);
            case INTERRUPTOR: return new Interruptor(id);
            case LED: return new Led(id);
            default: return null;
        }
    }
}
