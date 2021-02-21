package sucutucuengine;

import com.b0ve.simuladores.sucutucuengine.Componentable;
import com.b0ve.simuladores.sucutucuengine.ComponenteFactory;
import com.b0ve.simuladores.sucutucuengine.Generico.Interruptor;
import com.b0ve.simuladores.sucutucuengine.Generico.Led;
import com.b0ve.simuladores.sucutucuengine.Playground;

public class SucuTucuEngine {

    public static void main(String[] args) {
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
        
        maqueta.simular();
        System.out.println(led1.getEstado());
        
        btn1.setEstado(true);
        btn2.setEstado(false);
        maqueta.simular();
        System.out.println(led1.getEstado());
        
        btn1.setEstado(false);
        btn2.setEstado(true);
        maqueta.simular();
        System.out.println(led1.getEstado());
        
        btn1.setEstado(true);
        btn2.setEstado(true);
        maqueta.simular();
        System.out.println(led1.getEstado());
    }
    
}
