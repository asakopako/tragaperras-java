package model;

import java.util.ArrayList;

public class Premio {
    private ArrayList<Fruta> combinacion;
    private Double valor;

    public Premio(ArrayList<Fruta> combinacion, Double valor) {
        this.combinacion = combinacion;
        this.valor = valor;
    }

//    public ArrayList<Fruta> getCombinacion() {
//        return new ArrayList<>(combinacion);
//    }
    public ArrayList<Fruta> getCombinacion() {
        return combinacion;
    }

    public Double getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Premio premio = (Premio) o;

        for(int i = 0; i < premio.getCombinacion().size(); i++){
            if(premio.getCombinacion().get(i) != this.getCombinacion().get(i)) return false;
        }
//        return combinacion.equals(premio.combinacion) && valor.equals(premio.valor);
        return valor.equals(premio.valor);
    }
}
