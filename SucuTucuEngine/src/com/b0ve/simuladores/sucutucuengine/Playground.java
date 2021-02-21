package com.b0ve.simuladores.sucutucuengine;

import java.util.ArrayList;

public class Playground {
    private final ArrayList<Componentable> componentes;
    public Playground(){
        componentes = new ArrayList<>();
    }
    
    public void agregarComponente(Componentable componente){
        componentes.add(componente);
    }
    
    public void eliminarComponente(Componentable componente){
        componentes.add(componente);
    }
    
    public void agregarConexion(Componentable componenteOrigen, String nombreOrigen, Componentable componenteDestino, String nombreDestino){
        componenteDestino.setEntrada(new Entrada(componenteOrigen, nombreOrigen), nombreDestino);
    }
    
    public void eliminarConexion(Componentable componenteDestino, String nombreDestino){
        componenteDestino.setEntrada(null, nombreDestino);
    }
    
    public void simular(){
        boolean[] calculado = new boolean[componentes.size()];
       boolean cambio;
        do{
            cambio = false;
            for (int i = 0; i < componentes.size(); i++) {
                if(!calculado[i] && componentes.get(i).calcular()){
                    cambio = true;
                    calculado[i] = true;
                }
            }
        }while(cambio);
    }
}
