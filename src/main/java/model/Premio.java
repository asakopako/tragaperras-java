package model;

import java.util.ArrayList;

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
}
