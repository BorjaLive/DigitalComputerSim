package sucutucuengine;

import com.b0ve.simuladores.sucutucuengine.Componentable;
import com.b0ve.simuladores.sucutucuengine.ComponenteFactory;
import com.b0ve.simuladores.sucutucuengine.Pin;
import com.b0ve.simuladores.sucutucuengine.componentes.utilidades.Interruptor;
import com.b0ve.simuladores.sucutucuengine.componentes.utilidades.Led;
import com.b0ve.simuladores.sucutucuengine.Playground;
import com.b0ve.simuladores.sucutucuengine.componentes.utilidades.BCD7Segmentos;
import com.b0ve.simuladores.sucutucuengine.componentes.utilidades.Display7Segmentos;
import com.b0ve.simuladores.sucutucuengine.componentes.utilidades.DisplayBinariox4;
import com.b0ve.simuladores.sucutucuengine.componentes.utilidades.DisplayDecimalx4;
import com.b0ve.simuladores.sucutucuengine.componentes.utilidades.DisplayHexadecimalx4;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SucuTucuEngine {

    public static void main(String[] args) {
        test5();
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
    
    private static void test5() {
        Playground maqueta = new Playground();
        
        Interruptor btn1 = (Interruptor) ComponenteFactory.crearComponente(ComponenteFactory.Componentes.INTERRUPTOR);
        Interruptor btn2 = (Interruptor) ComponenteFactory.crearComponente(ComponenteFactory.Componentes.INTERRUPTOR);
        Interruptor btn3 = (Interruptor) ComponenteFactory.crearComponente(ComponenteFactory.Componentes.INTERRUPTOR);
        Interruptor btn4 = (Interruptor) ComponenteFactory.crearComponente(ComponenteFactory.Componentes.INTERRUPTOR);
        
        BCD7Segmentos bcd = (BCD7Segmentos) ComponenteFactory.crearComponente(ComponenteFactory.Componentes.BCD_7SEGMENTOS);
        Display7Segmentos d7s = (Display7Segmentos) ComponenteFactory.crearComponente(ComponenteFactory.Componentes.DISPLAY_7SEGMENTOS);
        
        DisplayBinariox4 db = (DisplayBinariox4) ComponenteFactory.crearComponente(ComponenteFactory.Componentes.DISPLAY_BINARIO_X4);
        DisplayHexadecimalx4 dh = (DisplayHexadecimalx4) ComponenteFactory.crearComponente(ComponenteFactory.Componentes.DISPLAY_HEXADECIMAL_X4);
        DisplayDecimalx4 dd = (DisplayDecimalx4) ComponenteFactory.crearComponente(ComponenteFactory.Componentes.DISPLAY_DECIMAL_X4);
        
        maqueta.agregarComponente(btn1);
        maqueta.agregarComponente(btn2);
        maqueta.agregarComponente(btn3);
        maqueta.agregarComponente(btn4);
        maqueta.agregarComponente(bcd);
        maqueta.agregarComponente(d7s);
        maqueta.agregarComponente(db);
        maqueta.agregarComponente(dh);
        maqueta.agregarComponente(dd);
        
        maqueta.agregarConexion(btn1, "y1", bcd, "x1");
        maqueta.agregarConexion(btn2, "y1", bcd, "x2");
        maqueta.agregarConexion(btn3, "y1", bcd, "x3");
        maqueta.agregarConexion(btn4, "y1", bcd, "x4");
        
        maqueta.agregarConexion(bcd, "y1", d7s, "x1");
        maqueta.agregarConexion(bcd, "y2", d7s, "x2");
        maqueta.agregarConexion(bcd, "y3", d7s, "x3");
        maqueta.agregarConexion(bcd, "y4", d7s, "x4");
        maqueta.agregarConexion(bcd, "y5", d7s, "x5");
        maqueta.agregarConexion(bcd, "y6", d7s, "x6");
        maqueta.agregarConexion(bcd, "y7", d7s, "x7");
        
        maqueta.agregarConexion(btn1, "y1", db, "x1");
        maqueta.agregarConexion(btn2, "y1", db, "x2");
        maqueta.agregarConexion(btn3, "y1", db, "x3");
        maqueta.agregarConexion(btn4, "y1", db, "x4");
        
        maqueta.agregarConexion(btn1, "y1", dh, "x1");
        maqueta.agregarConexion(btn2, "y1", dh, "x2");
        maqueta.agregarConexion(btn3, "y1", dh, "x3");
        maqueta.agregarConexion(btn4, "y1", dh, "x4");
        
        maqueta.agregarConexion(btn1, "y1", dd, "x1");
        maqueta.agregarConexion(btn2, "y1", dd, "x2");
        maqueta.agregarConexion(btn3, "y1", dd, "x3");
        maqueta.agregarConexion(btn4, "y1", dd, "x4");        
        
        btn1.setEstado(true);
        btn2.setEstado(true);
        btn3.setEstado(false);
        btn4.setEstado(false);
        
        maqueta.simular();
        System.out.println("DISPLAY 7 SEGMENTOS:");
        System.out.println(Arrays.toString(d7s.getEstado()));
        System.out.print(d7s.mostrar());
        System.out.println("-----------------------------------------------------");
        System.out.println("DISPLAY BINARIO: " + db.getNumero());
        System.out.println("-----------------------------------------------------");
        System.out.println("DISPLAY HEXADECIMAL: " + dh.getNumero());
        System.out.println("-----------------------------------------------------");
        System.out.println("DISPLAY DECIMAL: " + dd.getNumero());
        System.out.println("-----------------------------------------------------");
    }
}
