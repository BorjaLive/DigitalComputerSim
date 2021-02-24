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
        LED,
        BCD_7SEGMENTOS,
        DISPLAY_7SEGMENTOS,
        DISPLAY_BINARIO_X4,
        DISPLAY_BINARIO_X8,
        DISPLAY_BINARIO_X16,
        DISPLAY_HEXADECIMAL_X4,
        DISPLAY_HEXADECIMAL_X8,
        DISPLAY_HEXADECIMAL_X16,
        DISPLAY_DECIMAL_X4,
        DISPLAY_DECIMAL_X8,
        DISPLAY_DECIMAL_X16
    }
    
    public static Componentable crearComponente(Componentes c){
        long id = contador++;
        switch(c){
            case AND: return new PuertaAND(id);
            case OR: return new PuertaOR(id);
            case NOT: return new PuertaNOT(id);
            case INTERRUPTOR: return new Interruptor(id);
            case LED: return new Led(id);
            case BCD_7SEGMENTOS: return new BCD7Segmentos(id);
            case DISPLAY_7SEGMENTOS: return new Display7Segmentos(id);
            case DISPLAY_BINARIO_X4: return new DisplayBinariox4(id);
            case DISPLAY_BINARIO_X8: return new DisplayBinariox8(id);
            case DISPLAY_BINARIO_X16: return new DisplayBinariox16(id);
            case DISPLAY_HEXADECIMAL_X4: return new DisplayHexadecimalx4(id);
            case DISPLAY_HEXADECIMAL_X8: return new DisplayHexadecimalx8(id);
            case DISPLAY_HEXADECIMAL_X16: return new DisplayHexadecimalx16(id);
            case DISPLAY_DECIMAL_X4: return new DisplayDecimalx4(id);
            case DISPLAY_DECIMAL_X8: return new DisplayDecimalx8(id);
            case DISPLAY_DECIMAL_X16: return new DisplayDecimalx16(id);
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
