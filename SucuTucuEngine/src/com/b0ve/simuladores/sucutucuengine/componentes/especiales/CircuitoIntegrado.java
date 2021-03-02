package com.b0ve.simuladores.sucutucuengine.componentes.especiales;

import com.b0ve.simuladores.sucutucuengine.Componente;
import com.b0ve.simuladores.sucutucuengine.Pin;
import com.b0ve.simuladores.sucutucuengine.Playground;
import com.b0ve.simuladores.sucutucuengine.componentes.utilidades.Interruptor;
import java.util.HashMap;
import java.util.Map;

public class CircuitoIntegrado extends Componente{

    private final Playground circuito;
    private final Map<String, Interruptor> entradasVirtuales;
    private final Map<String, Pin> salidasVirtuales;
    
    public CircuitoIntegrado(long id, Map<String, Pin> entradas, Map<String, Pin> salidas, Playground circuito) {
        super(id, entradas.keySet().toArray(new String[0]), salidas.keySet().toArray(new String[0]));
        this.circuito = circuito;
        
        entradasVirtuales = new HashMap<>();
        for (Map.Entry<String, Pin> entrada : entradas.entrySet()) {
            String nombre = entrada.getKey();
            Pin pin = entrada.getValue();
            Interruptor virtual = (Interruptor) circuito.agregarComponente(Playground.Componentes.INTERRUPTOR);
            circuito.agregarConexion(virtual, "y1", pin.getComponente(), pin.getNombre());
            entradasVirtuales.put(nombre, virtual);
        }
        
        salidasVirtuales = salidas;
    }

    @Override
    protected void generarSalidas() {
        //Leo mis entradas y actualizo las entradas virtuales
        for (String entrada : nombreEntradas) {
            entradasVirtuales.get(entrada).setEstado(leer(entrada));
        }
        circuito.simular();
        //Leo las salidas virtuales y las escribo en mi
        for (String salida : nombreSalidas) {
            Boolean estado = salidasVirtuales.get(salida).leer();
            escribir(salida, estado != null && estado);
        }
    }
    
}
