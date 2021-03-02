package com.b0ve.simuladores.sucutucuengine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Componente implements Componentable {

    private final long id;
    private final Map<String, Pin> entradas;
    private final Map<String, Boolean> salidas;
    protected final List<String> nombreEntradas;
    protected final List<String> nombreSalidas;

    public Componente(long id, String[] nombreEntradas, String[] nombreSalidas) {
        this.id = id;
        entradas = new HashMap<>();
        salidas = new HashMap<>();
        this.nombreEntradas = new ArrayList<>(Arrays.asList(nombreEntradas));
        this.nombreSalidas = new ArrayList<>(Arrays.asList(nombreSalidas));
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void addEntrada(String entrada){
        nombreEntradas.add(entrada);
    }

    @Override
    public void removeEntrada(String entrada){
        nombreEntradas.remove(entrada);
    }

    @Override
    public void addSalida(String salida){
        nombreSalidas.add(salida);
    }

    @Override
    public void removeSalida(String salida){
        nombreSalidas.remove(salida);
    }

    @Override
    public Pin getEntrada(String entrada) {
        return entradas.get(entrada);
    }

    @Override
    public Boolean getSalida(String salida) {
        return salidas.get(salida);
    }

    @Override
    public void setEntrada(Pin salida, String nombreEntrada) {
        entradas.put(nombreEntrada, salida);
    }

    @Override
    public String[] getNombreEntradas() {
        return nombreEntradas.toArray(new String[0]);
    }

    @Override
    public String[] getNombreSalidas() {
        return nombreSalidas.toArray(new String[0]);
    }

    @Override
    public boolean calcular() {
        boolean definido = true;
        int i = 0;
        while (i < nombreEntradas.size() && definido) {
            if (entradas.get(nombreEntradas.get(i)) != null && entradas.get(nombreEntradas.get(i)).leer() == null) {
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

    /**
     * Lee el pin de salida que está conectado a una entrada del componente
     * @param nombre Nombre de la entrada
     * @return El valor al que está la entrada
     */
    protected boolean leer(String nombre) {
        Pin entrada = entradas.get(nombre);
        return entrada != null && entrada.leer();
    }

    /**
     * Establece el valor de una salida del componte
     * @param nombre Nombre de la salida
     * @param valor Valor al que se establece
     */
    protected void escribir(String nombre, boolean valor) {
        salidas.put(nombre, valor);
    }

    /**
     * Establece el valor de las salidas del componente. Solo debe llamarse cuando todas las entradas esten definidas o desconectadas.
     */
    protected abstract void generarSalidas();

    @Override
    public void limpiar() {
        salidas.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (o.getClass() == Componente.class) {
            Componente obj = (Componente) o;
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
