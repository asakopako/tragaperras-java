package model;

import java.util.ArrayList;
import java.util.List;

public class Premio {
    private ArrayList<Fruta> combinacion;
    private Double valor;

    public Premio(ArrayList<Fruta> combinacion, Double valor) {
        this.combinacion = combinacion;
        this.valor = valor;
    }

    public ArrayList<Fruta> getCombinacion() {
        return new ArrayList<>(combinacion);
    }

    public Double getValor() {
        return valor;
    }

    public boolean isThisPremio(List<Fruta> jugada) {
        for(int i = 0; i < combinacion.size(); i++) {
            if(jugada.get(i) != combinacion.get(i))
                return false;
        }
        return true;
    }
}
