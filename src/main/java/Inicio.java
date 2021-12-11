import model.Fruta;
import model.Maquina;
import model.Premio;
import model.modos.Ganancia;

import java.util.ArrayList;

public class Inicio {
    public static void main(String [] args){
        Maquina maquina = new Maquina(3, 200.0, 0.25, new Ganancia(150.0));

        ArrayList<Fruta> combinacion = new ArrayList<>(3);
        combinacion.set(0, Fruta.FRESA);
        combinacion.set(1, Fruta.FRESA);
        combinacion.set(2, Fruta.FRESA);
        Premio premio = new Premio(combinacion,20.0);
        maquina.altaPremio(premio);

        combinacion = new ArrayList<>(3);
        combinacion.set(0, Fruta.SANDIA);
        combinacion.set(1, Fruta.FRESA);
        combinacion.set(2, Fruta.SANDIA);
        premio = new Premio(combinacion,10.0);
        maquina.altaPremio(premio);

        maquina.insertarCredito(30.0);


    }
}
