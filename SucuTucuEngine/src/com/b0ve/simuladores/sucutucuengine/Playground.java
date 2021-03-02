package com.b0ve.simuladores.sucutucuengine;

import com.b0ve.simuladores.sucutucuengine.componentes.especiales.*;
import com.b0ve.simuladores.sucutucuengine.componentes.puertas.*;
import com.b0ve.simuladores.sucutucuengine.componentes.secuenciales.*;
import com.b0ve.simuladores.sucutucuengine.componentes.utilidades.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Clase que simula el comportamiento de un circuito. Está autocontenida.
 */
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
    
    /**
     * Crea un componente y lo agrega al circuito
     * @param c Tipo de componente a crear
     * @return Componente creado
     */
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
            componentes.add(componente);
        }
        return componente;
    }
    
    /**
     * Crea un IC y lo agrega al circuito
     * @param entradas Asociación de los nombres de las entradas del IC con las entradas libres de sus componentes
     * @param salidas Asociación de los nombres de las salidas del IC con las salidas libres de sus compoentes 
     * @param circuito Circuito del que se compone el IC
     * @return IC creado
     */
    public Componentable agregarIC(Map<String, Pin> entradas, Map<String, Pin> salidas, Playground circuito){
        long id = contador++;
        Componentable componente = new CircuitoIntegrado(id, entradas, salidas, circuito);
        componentes.add(componente);
        return componente;
    }
    
    /**
     * Crea una celda de FPGA y la agrega al circuito
     * @param entradas Nombre de las entradas de la celda
     * @param salidas Nombre de las salidas de la celda
     * @param tabla Tabla de verdad que define las salidas de la celda. Las columnas son las variables de entrada y las de salida, en ese orden y subordenadas. Las filas son las posibles combinaciones
     * @return Celda de FPGA creada
     */
    public Componentable agregarCeldaFPGA(String[] entradas, String[] salidas, boolean[][] tabla){
        long id = contador++;
        Componentable componente = new CeldaFPGA(id, entradas, salidas, tabla);
        componentes.add(componente);
        return componente;
    }
    
    /**
     * Elimina un componente del circuito
     * @param componente 
     */
    public void eliminarComponente(Componentable componente){
        componentes.remove(componente);
    }
    
    /**
     * Agrega una conexión entre componentes del circuito. Una salida puede estar conectadas a multiples entradas, pero una entrada solo se conecta a una salida o ninguna
     * @param componenteOrigen Componente del que se toma la salida
     * @param nombreOrigen Nombre de la salida
     * @param componenteDestino Componente a cuya entrada se conecta la salida
     * @param nombreDestino Nombre de la entrada del componente a conectar
     */
    public void agregarConexion(Componentable componenteOrigen, String nombreOrigen, Componentable componenteDestino, String nombreDestino){
        componenteDestino.setEntrada(new Pin(componenteOrigen, nombreOrigen), nombreDestino);
    }
    
    /**
     * Rompe una conexión entre compoentes
     * @param componenteDestino Circuito cuya entrada se va a desconectar
     * @param nombreDestino Nombre de la entrada a desconectar
     */
    public void eliminarConexion(Componentable componenteDestino, String nombreDestino){
        componenteDestino.setEntrada(null, nombreDestino);
    }
    
    /**
     * Intenta definir el estado de todos los componentes del circuito
     */
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
