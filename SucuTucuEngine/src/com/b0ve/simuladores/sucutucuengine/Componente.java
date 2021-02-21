package com.b0ve.simuladores.sucutucuengine;

import java.util.HashMap;
import java.util.Map;
import javafx.util.Pair;

public abstract class Componente implements Componentable {

    private final long id;
    protected final Map<String, Entrada> entradas;
    protected final Map<String, Boolean> salidas;
    private final String[] nombreEntradas;
    private final String[] nombreSalidas;

    public Componente(long id, String[] nombreEntradas, String[] nombreSalidas) {
        this.id = id;
        entradas = new HashMap<>();
        salidas = new HashMap<>();
        this.nombreEntradas = nombreEntradas;
        this.nombreSalidas = nombreSalidas;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public Entrada getEntrada(String entrada) {
        return entradas.get(entrada);
    }

    @Override
    public Boolean getSalida(String salida) {
        return salidas.get(salida);
    }

    @Override
    public void setEntrada(Entrada entrada, String nombre) {
        entradas.put(nombre, entrada);
    }

    @Override
    public String[] getNombreEntradas() {
        return nombreEntradas;
    }

    @Override
    public String[] getNombreSalidas() {
        return nombreSalidas;
    }

    @Override
    public boolean calcular() {
        boolean definido = true;
        int i = 0;
        while (i < nombreEntradas.length && definido) {
            if (entradas.get(nombreEntradas[i]) == null || entradas.get(nombreEntradas[i]).leer() == null) {
                definido = false;
            } else {
                i++;
            }
        }

        if (definido) {
            generarSalidas();
        }
        return definido;
    }

    protected abstract void generarSalidas();

    @Override
    public void limpiar() {
        salidas.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (o.getClass() == Componente.class) {
            Componente obj = (Componente)o;
            return id == obj.id;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }
}
