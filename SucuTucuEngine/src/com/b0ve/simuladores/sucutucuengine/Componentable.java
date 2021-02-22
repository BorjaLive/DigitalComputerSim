package com.b0ve.simuladores.sucutucuengine;

public interface Componentable {

    public long getId();

    public Pin getEntrada(String entrada);

    public Boolean getSalida(String salida);

    public void setEntrada(Pin entrada, String nombre);

    public String[] getNombreEntradas();

    public String[] getNombreSalidas();

    public boolean calcular();

    public void limpiar();
}
