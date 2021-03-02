package com.b0ve.simuladores.sucutucuengine.componentes.especiales;

import com.b0ve.simuladores.sucutucuengine.Componente;
import com.b0ve.simuladores.sucutucuengine.Pin;
import com.b0ve.simuladores.sucutucuengine.Playground;
import java.util.HashMap;
import java.util.Map;

class VirtualIO extends Componente{

    private boolean estado;
    
    public VirtualIO() {
        super(0, new String[]{}, new String[]{"y"});
        estado = false;
    }
    
    public void setEstado(boolean e){
        estado = e;
    }

    @Override
    protected void generarSalidas() {
        escribir("y", estado);
    }
    
}

public class CircuitoIntegrado extends Componente{

    private final Playground circuito;
    private final Map<String, VirtualIO> entradasVirtuales;
    private final Map<String, Pin> salidasVirtuales;
    
    public CircuitoIntegrado(long id, Map<String, Pin> entradas, Map<String, Pin> salidas, Playground circuito) {
        super(id, entradas.keySet().toArray(new String[0]), salidas.keySet().toArray(new String[0]));
        this.circuito = circuito;
        
        entradasVirtuales = new HashMap<>();
        for (Map.Entry<String, Pin> entrada : entradas.entrySet()) {
            String nombre = entrada.getKey();
            Pin pin = entrada.getValue();
            VirtualIO virtual = new VirtualIO();
            circuito.agregarComponente(virtual);
            circuito.agregarConexion(virtual, "y", pin.getComponente(), pin.getNombre());
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
