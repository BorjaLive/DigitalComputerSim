package com.b0ve.simuladores.sucutucuengine;

public interface Componentable {

    public long getId();

    public void addEntrada(String entrada);

    public void removeEntrada(String entrada);

    public void addSalida(String salida);

    public void removeSalida(String salida);

    public Pin getEntrada(String entrada);

    public Boolean getSalida(String salida);

    public void setEntrada(Pin entrada, String nombre);

    public String[] getNombreEntradas();

    public String[] getNombreSalidas();

    public boolean calcular();

    public void limpiar();
}
