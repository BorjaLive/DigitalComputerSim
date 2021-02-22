package com.b0ve.simuladores.sucutucuengine;

import com.b0ve.simuladores.sucutucuengine.componentes.especiales.CeldaFPGA;
import com.b0ve.simuladores.sucutucuengine.componentes.especiales.CircuitoIntegrado;
import com.b0ve.simuladores.sucutucuengine.componentes.puertas.*;
import com.b0ve.simuladores.sucutucuengine.componentes.utilidades.*;
import java.util.Map;

public class ComponenteFactory {
    private static long contador = 0;
    
    public enum Componentes {
        AND,
        OR,
        NOT,
        XOR,
        NAND,
        NOR,
        XNOR,
        INTERRUPTOR,
        LED
    }
    
    public static Componentable crearComponente(Componentes c){
        long id = contador++;
        switch(c){
            case AND: return new PuertaAND(id);
            case OR: return new PuertaOR(id);
            case NOT: return new PuertaNOT(id);
            case INTERRUPTOR: return new Interruptor(id);
            case LED: return new Led(id);
            default: return null;
        }
    }
    
    public static Componentable crearCircuitoIntegrado(Map<String, Pin> entradas, Map<String, Pin> salidas, Playground circuito){
        long id = contador++;
        return new CircuitoIntegrado(id, entradas, salidas, circuito);
    }
    
    public static Componentable crearCeldaFPGA(String[] entradas, String[] salidas, boolean[][] tabla){
        long id = contador++;
        return new CeldaFPGA(id, entradas, salidas, tabla);
    }
}
