package com.b0ve.simuladores.sucutucuengine.componentes.especiales;

import com.b0ve.simuladores.sucutucuengine.Componente;

public class CeldaFPGA extends Componente{

    private boolean[][] tabla;

    public CeldaFPGA(long id, String[] entradas, String[] salidas, boolean[][] tabla) {
        super(id, entradas, salidas);
        this.tabla = tabla;
    }

    @Override
    protected void generarSalidas() {
        int i = 0;
        boolean encontrado = false;
        while (i < tabla.length && !encontrado) {
            int j = 0;
            boolean encaja = true;
            while (j < nombreEntradas.length && encaja) {
                if (tabla[i][j] != leer(nombreEntradas[j])) {
                    encaja = false;
                } else {
                    j++;
                }
            }
            if (encaja) {
                encontrado = true;
            } else {
                i++;
            }
        }
        if (encontrado) {
            for (int j = 0; j < nombreSalidas.length; j++) {
                escribir(nombreSalidas[j], tabla[i][nombreEntradas.length+j]);
            }
        }
    }
    
}
