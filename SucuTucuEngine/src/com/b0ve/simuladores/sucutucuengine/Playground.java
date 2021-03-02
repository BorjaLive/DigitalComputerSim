package com.b0ve.simuladores.sucutucuengine;

import com.b0ve.simuladores.sucutucuengine.componentes.especiales.*;
import com.b0ve.simuladores.sucutucuengine.componentes.puertas.*;
import com.b0ve.simuladores.sucutucuengine.componentes.secuenciales.*;
import com.b0ve.simuladores.sucutucuengine.componentes.utilidades.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Playground {
    public static enum Componentes {
        AND,
        OR,
        NOT,
        XOR,
        NAND,
        NOR,
        XNOR,
        FLIPFLOP_RS,
        FLIPFLOP_JK,
        FLIPFLOP_D,
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
    
    private final List<Componentable> componentes;
    private long contador;
    
    public Playground(){
        this(new ArrayList<>(), 0);
    }
    
    public Playground(List<Componentable> componentes, long contador){
        this.componentes = componentes;
        this.contador = contador;
    }
    
    public Componentable agregarComponente(Componentes c){
        long id = contador++;
        Componentable componente = null;
        switch(c){
            case AND: componente = new PuertaAND(id); break;
            case OR: componente = new PuertaOR(id); break;
            case NOT: componente = new PuertaNOT(id); break;
            case NAND: componente = new PuertaNAND(id); break;
            case NOR: componente = new PuertaNOR(id); break;
            case XOR: componente = new PuertaXOR(id); break;
            case XNOR: componente = new PuertaXNOR(id); break;
            case INTERRUPTOR: componente = new Interruptor(id); break;
            case LED: componente = new Led(id); break;
            case FLIPFLOP_RS: componente = new FlipFlopRS(id); break;
            case FLIPFLOP_JK: componente = new FlipFlopJK(id); break;
            case FLIPFLOP_D: componente = new FlipFlopD(id); break;
            case BCD_7SEGMENTOS: componente = new BCD7Segmentos(id); break;
            case DISPLAY_7SEGMENTOS: componente = new Display7Segmentos(id); break;
            case DISPLAY_BINARIO_X4: componente = new DisplayBinariox4(id); break;
            case DISPLAY_BINARIO_X8: componente = new DisplayBinariox8(id); break;
            case DISPLAY_BINARIO_X16: componente = new DisplayBinariox16(id); break;
            case DISPLAY_HEXADECIMAL_X4: componente = new DisplayHexadecimalx4(id); break;
            case DISPLAY_HEXADECIMAL_X8: componente = new DisplayHexadecimalx8(id); break;
            case DISPLAY_HEXADECIMAL_X16: componente = new DisplayHexadecimalx16(id); break;
            case DISPLAY_DECIMAL_X4: componente = new DisplayDecimalx4(id); break;
            case DISPLAY_DECIMAL_X8: componente = new DisplayDecimalx8(id); break;
            case DISPLAY_DECIMAL_X16: componente = new DisplayDecimalx16(id); break;
        }
        if(componente != null){
            agregarComponente(componente);
        }
        return componente;
    }
    
    public Componentable agregarCircuitoIntegrado(Map<String, Pin> entradas, Map<String, Pin> salidas, Playground circuito){
        long id = contador++;
        Componentable componente = new CircuitoIntegrado(id, entradas, salidas, circuito);
        agregarComponente(componente);
        return componente;
    }
    
    public Componentable agregarCeldaFPGA(String[] entradas, String[] salidas, boolean[][] tabla){
        long id = contador++;
        Componentable componente = new CeldaFPGA(id, entradas, salidas, tabla);
        agregarComponente(componente);
        return componente;
    }
    
    public void agregarComponente(Componentable componente){
        componentes.add(componente);
    }
    
    public void eliminarComponente(Componentable componente){
        componentes.add(componente);
    }
    
    public void agregarConexion(Componentable componenteOrigen, String nombreOrigen, Componentable componenteDestino, String nombreDestino){
        componenteDestino.setEntrada(new Pin(componenteOrigen, nombreOrigen), nombreDestino);
    }
    
    public void eliminarConexion(Componentable componenteDestino, String nombreDestino){
        componenteDestino.setEntrada(null, nombreDestino);
    }
    
    public void simular(){
        for (Componentable componente : componentes) {
            componente.limpiar();
        }
        boolean[] calculado = new boolean[componentes.size()];
        boolean cambio;
        do{
            cambio = false;
            for (int i = 0; i < componentes.size(); i++) {
                if(!calculado[i] && componentes.get(i).calcular()){
                    cambio = true;
                    calculado[i] = true;
                }
            }
        }while(cambio);
    }
    
    
}
