package com.b0ve.simuladores.sucutucuengine;

import javafx.util.Pair;

public interface Componentable {

    public long getId();

    public Entrada getEntrada(String entrada);

    public Boolean getSalida(String salida);

    public void setEntrada(Entrada entrada, String nombre);

    public String[] getNombreEntradas();

    public String[] getNombreSalidas();

    public boolean calcular();

    public void limpiar();
}
