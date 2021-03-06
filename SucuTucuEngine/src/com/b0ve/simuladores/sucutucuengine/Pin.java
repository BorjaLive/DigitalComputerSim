package com.b0ve.simuladores.sucutucuengine;

import java.util.Objects;

public final class Pin {

    private final Componentable componente;
    private final String nombre;

    public Pin(Componentable componente, String nombre) {
        this.componente = componente;
        this.nombre = nombre;
    }

    public Componentable getComponente() {
        return componente;
    }

    public String getNombre() {
        return nombre;
    }
    
    public Boolean leer(){
        return componente.getSalida(nombre);
    }

    @Override
    public boolean equals(Object o) {
        if (o.getClass() == Pin.class) {
            Pin obj = (Pin)o;
            return componente.equals(obj.componente) && nombre.equals(obj.nombre);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.componente);
        hash = 53 * hash + Objects.hashCode(this.nombre);
        return hash;
    }
}
