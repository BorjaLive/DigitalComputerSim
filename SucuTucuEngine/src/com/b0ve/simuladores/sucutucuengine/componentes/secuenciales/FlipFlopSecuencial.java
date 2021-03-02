package com.b0ve.simuladores.sucutucuengine.componentes.secuenciales;

import com.b0ve.simuladores.sucutucuengine.Componente;

public abstract class FlipFlopSecuencial extends Componente {

    private boolean estado, ultimoClk;

    public FlipFlopSecuencial(long id, String[] entradas) {
        super(id, entradas, new String[]{"q", "!q"});
        addEntrada("clk");
        estado = false;
        ultimoClk = false;
    }

    @Override
    protected void generarSalidas() {
        boolean nuevoClk = leer("clk");
        
        if (nuevoClk && !ultimoClk) {
            generarEstado();
        }

        escribir("q", estado);
        escribir("!q", !estado);
        
        ultimoClk = nuevoClk;
    }

    protected void setEstado() {
        estado = true;
    }

    protected void resetEstado() {
        estado = false;
    }

    protected void toggleEstado() {
        estado = !estado;
    }

    abstract void generarEstado();
}
