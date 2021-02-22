package sucutucuengine;

import com.b0ve.simuladores.sucutucuengine.Componentable;
import com.b0ve.simuladores.sucutucuengine.ComponenteFactory;
import com.b0ve.simuladores.sucutucuengine.Pin;
import com.b0ve.simuladores.sucutucuengine.componentes.utilidades.Interruptor;
import com.b0ve.simuladores.sucutucuengine.componentes.utilidades.Led;
import com.b0ve.simuladores.sucutucuengine.Playground;
import java.util.HashMap;
import java.util.Map;

public class SucuTucuEngine {

    public static void main(String[] args) {
        test4();
    }
    
    private static void test1(){
        Playground maqueta = new Playground();
        
        Interruptor btn1 = (Interruptor)ComponenteFactory.crearComponente(ComponenteFactory.Componentes.INTERRUPTOR);
        Interruptor btn2 = (Interruptor)ComponenteFactory.crearComponente(ComponenteFactory.Componentes.INTERRUPTOR);
        Componentable and1 = ComponenteFactory.crearComponente(ComponenteFactory.Componentes.AND);
        Led led1 = (Led)ComponenteFactory.crearComponente(ComponenteFactory.Componentes.LED);
        
        maqueta.agregarComponente(btn1);
        maqueta.agregarComponente(btn2);
        maqueta.agregarComponente(and1);
        maqueta.agregarComponente(led1);
        
        maqueta.agregarConexion(btn1, "y1", and1, "x1");
        maqueta.agregarConexion(btn2, "y1", and1, "x2");
        maqueta.agregarConexion(and1, "y1", led1, "x1");
        
        btn1.setEstado(false);
        btn2.setEstado(false);
        maqueta.simular();
        System.out.println(led1.getEstado());
        
        btn1.setEstado(false);
        btn2.setEstado(true);
        maqueta.simular();
        System.out.println(led1.getEstado());
        
        btn1.setEstado(true);
        btn2.setEstado(false);
        maqueta.simular();
        System.out.println(led1.getEstado());
        
        btn1.setEstado(true);
        btn2.setEstado(true);
        maqueta.simular();
        System.out.println(led1.getEstado());
    }
    
    private static void test2(){
        Playground maqueta = new Playground();
        
        Interruptor btn1 = (Interruptor)ComponenteFactory.crearComponente(ComponenteFactory.Componentes.INTERRUPTOR);
        Interruptor btn2 = (Interruptor)ComponenteFactory.crearComponente(ComponenteFactory.Componentes.INTERRUPTOR);
        Componentable and1 = ComponenteFactory.crearComponente(ComponenteFactory.Componentes.AND);
        Componentable and2 = ComponenteFactory.crearComponente(ComponenteFactory.Componentes.AND);
        Componentable or1 = ComponenteFactory.crearComponente(ComponenteFactory.Componentes.OR);
        Componentable not1 = ComponenteFactory.crearComponente(ComponenteFactory.Componentes.NOT);
        Led led1 = (Led)ComponenteFactory.crearComponente(ComponenteFactory.Componentes.LED);
        Led led2 = (Led)ComponenteFactory.crearComponente(ComponenteFactory.Componentes.LED);
        
        Playground integrado = new Playground();
        
        
        maqueta.agregarComponente(btn1);
        maqueta.agregarComponente(btn2);
        maqueta.agregarComponente(and1);
        maqueta.agregarComponente(and2);
        maqueta.agregarComponente(or1);
        maqueta.agregarComponente(not1);
        maqueta.agregarComponente(led1);
        maqueta.agregarComponente(led2);
        
        maqueta.agregarConexion(btn1, "y1", and2, "x1");
        maqueta.agregarConexion(btn1, "y1", and2, "x2");
        maqueta.agregarConexion(btn2, "y1", not1, "x1");
        maqueta.agregarConexion(and2, "y1", or1, "x1");
        maqueta.agregarConexion(not1, "y1", and1, "x2");
        maqueta.agregarConexion(or1, "y1", and1, "x1");
        maqueta.agregarConexion(or1, "y1", led1, "x1");
        maqueta.agregarConexion(and1, "y1", led2, "x1");
        
        btn1.setEstado(false);
        btn2.setEstado(false);
        maqueta.simular();
        System.out.println(led1.getEstado()+" "+led2.getEstado());
        
        btn1.setEstado(false);
        btn2.setEstado(true);
        maqueta.simular();
        System.out.println(led1.getEstado()+" "+led2.getEstado());
        
        btn1.setEstado(true);
        btn2.setEstado(false);
        maqueta.simular();
        System.out.println(led1.getEstado()+" "+led2.getEstado());
        
        btn1.setEstado(true);
        btn2.setEstado(true);
        maqueta.simular();
        System.out.println(led1.getEstado()+" "+led2.getEstado());
    }
    
    private static void test3(){
        Playground maqueta = new Playground();
        
        Interruptor btn1 = (Interruptor)ComponenteFactory.crearComponente(ComponenteFactory.Componentes.INTERRUPTOR);
        Interruptor btn2 = (Interruptor)ComponenteFactory.crearComponente(ComponenteFactory.Componentes.INTERRUPTOR);
        Componentable and1 = ComponenteFactory.crearComponente(ComponenteFactory.Componentes.AND);
        Componentable and2 = ComponenteFactory.crearComponente(ComponenteFactory.Componentes.AND);
        Componentable or1 = ComponenteFactory.crearComponente(ComponenteFactory.Componentes.OR);
        Componentable not1 = ComponenteFactory.crearComponente(ComponenteFactory.Componentes.NOT);
        Led led1 = (Led)ComponenteFactory.crearComponente(ComponenteFactory.Componentes.LED);
        Led led2 = (Led)ComponenteFactory.crearComponente(ComponenteFactory.Componentes.LED);
        
        Playground integrado = new Playground();
        
        integrado.agregarComponente(or1);
        integrado.agregarComponente(and1);
        integrado.agregarConexion(or1, "y1", and1, "x1");
        
        Map<String, Pin> entradas = new HashMap<>();
        Map<String, Pin> salidas = new HashMap<>();
        entradas.put("x1", new Pin(or1, "x1"));
        entradas.put("x2", new Pin(and1, "x2"));
        salidas.put("y1", new Pin(or1, "y1"));
        salidas.put("y2", new Pin(and1, "y1"));
        Componentable ic1 = ComponenteFactory.crearCircuitoIntegrado(entradas, salidas, integrado);
        
        maqueta.agregarComponente(btn1);
        maqueta.agregarComponente(btn2);
        maqueta.agregarComponente(and2);
        maqueta.agregarComponente(not1);
        maqueta.agregarComponente(ic1);
        maqueta.agregarComponente(led1);
        maqueta.agregarComponente(led2);
        
        maqueta.agregarConexion(btn1, "y1", and2, "x1");
        maqueta.agregarConexion(btn1, "y1", and2, "x2");
        maqueta.agregarConexion(btn2, "y1", not1, "x1");
        maqueta.agregarConexion(and2, "y1", ic1, "x1");
        maqueta.agregarConexion(not1, "y1", ic1, "x2");
        maqueta.agregarConexion(ic1, "y1", led1, "x1");
        maqueta.agregarConexion(ic1, "y2", led2, "x1");
        
        btn1.setEstado(false);
        btn2.setEstado(false);
        maqueta.simular();
        System.out.println(led1.getEstado()+" "+led2.getEstado());
        
        btn1.setEstado(false);
        btn2.setEstado(true);
        maqueta.simular();
        System.out.println(led1.getEstado()+" "+led2.getEstado());
        
        btn1.setEstado(true);
        btn2.setEstado(false);
        maqueta.simular();
        System.out.println(led1.getEstado()+" "+led2.getEstado());
        
        btn1.setEstado(true);
        btn2.setEstado(true);
        maqueta.simular();
        System.out.println(led1.getEstado()+" "+led2.getEstado());

    }
    
    private static void test4(){
        
        Playground maqueta = new Playground();
        
        Interruptor btn1 = (Interruptor)ComponenteFactory.crearComponente(ComponenteFactory.Componentes.INTERRUPTOR);
        Interruptor btn2 = (Interruptor)ComponenteFactory.crearComponente(ComponenteFactory.Componentes.INTERRUPTOR);
        Componentable c1 = ComponenteFactory.crearCeldaFPGA(
                new String[]{"x1", "x2"},
                new String[]{"y1"},
                new boolean[][]{
                    {false, false, true},
                    {false, true, false},
                    {true, false, false},
                    {true, true, true}
                }
        );
        Led led1 = (Led)ComponenteFactory.crearComponente(ComponenteFactory.Componentes.LED);
        
        maqueta.agregarComponente(btn1);
        maqueta.agregarComponente(btn2);
        maqueta.agregarComponente(c1);
        maqueta.agregarComponente(led1);
        
        maqueta.agregarConexion(btn1, "y1", c1, "x1");
        maqueta.agregarConexion(btn2, "y1", c1, "x2");
        maqueta.agregarConexion(c1, "y1", led1, "x1");
        
        btn1.setEstado(false);
        btn2.setEstado(false);
        maqueta.simular();
        System.out.println(led1.getEstado());
        
        btn1.setEstado(false);
        btn2.setEstado(true);
        maqueta.simular();
        System.out.println(led1.getEstado());
        
        btn1.setEstado(true);
        btn2.setEstado(false);
        maqueta.simular();
        System.out.println(led1.getEstado());
        
        btn1.setEstado(true);
        btn2.setEstado(true);
        maqueta.simular();
        System.out.println(led1.getEstado());
    }
}
