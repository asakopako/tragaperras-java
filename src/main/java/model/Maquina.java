package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Maquina {
    private final Integer tamaño; // numero de casillas de la máquina
    private ArrayList<Fruta> casillas;
    private Double recaudacion;
    private final Double precio; // el costo de una jugada
    private Double credito = 0.0;
    private List<Premio> premios;

    public Maquina(Integer tamaño, Double recaudacion, Double precio){
        this.tamaño = tamaño;
        this.casillas = new ArrayList<>(tamaño);
        this.recaudacion = recaudacion;
        this.precio = precio;
        this.premios = new LinkedList<>();
    }

    public void altaPremio(Premio premio) {
        if (premio.getValor() > 0 && premio.getCombinacion().size() == tamaño)
            premios.add(premio);
    }

    public void insertarCredito(Double credito) {
        if (credito > 0) this.credito += credito;
    }
}
