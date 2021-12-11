package model;

import model.modos.Modo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Maquina {
    private final Integer tamano; // numero de casillas de la máquina
    //private ArrayList<Fruta> casillas;
    private Double recaudacion;
    private final Double precio; // el costo de una jugada
    private Double credito = 0.0;
    private List<Premio> premios = new ArrayList<>();
    private List<Premio> historico = new ArrayList<>();
    private Modo modo;    // modo de aceptacion

    public Maquina(Integer tamano, Double recaudacion, Double precio, Modo modo){
        this.tamano = tamano;
        //this.casillas = new ArrayList<>(tamano);
        this.recaudacion = recaudacion;
        this.precio = precio;
        this.modo = modo;
    }

    public void altaPremio(Premio premio) {
        if (premio.getValor() > 0 && premio.getCombinacion().size() == tamano)
            premios.add(premio);
    }

    public void insertarCredito(Double credito) {
        if (credito > 0) this.credito += credito;
    }

    public void jugar() {
        if (credito >= precio) {
            List<Fruta> jugada = generarCombinacion();
            if(existPremio(jugada)) {
                Premio premio = getPremio(jugada);
                if (premio.getValor() <= recaudacion) {
                    if (modo.isAccepted(premio, historico)) {
                        historico.add(premio);
                        recaudacion -= premio.getValor();
                        credito += premio.getValor();
                        mostrarJugada(jugada);
                    }
                    else jugar();
                }
                else jugar();
            }
            else mostrarJugada(jugada);
        }
//        else throw new Exception("No hay credito suficiente");
    }

    private List<Fruta> generarCombinacion() {
        ArrayList<Fruta> resultado = new ArrayList<>(tamano);
        for(int i = 0; i < tamano; i++) {
            resultado.set(i, Fruta.values()[(int) (Math.random() * Fruta.values().length)]);
        }
        return resultado;
    }

    // método cobrar ¿qué devuelve? el crédito disponible

    private boolean existPremio(List<Fruta> jugada) {
        for (Premio premio : premios) {
            if(isPremio(jugada, premio)) return true;
        }
        return false;
    }

    private Premio getPremio(List<Fruta> jugada) {
        for (Premio premio : premios) {
            if(isPremio(jugada, premio)) return premio;
        }
        return null;
    }

    private boolean isPremio(List<Fruta> jugada, Premio premio) {
        for (int i = 0; i < tamano; i++) {
            if(jugada.get(i) != premio.getCombinacion().get(i))
                return false;
        }
        return true;
    }

    private void mostrarJugada(List<Fruta> jugada) {
        for (Fruta fruta : jugada) {
            if (fruta == Fruta.FRESA) System.out.print("FRESA ");
            if (fruta == Fruta.MELOCOTON) System.out.print("MELOCOTON ");
            if (fruta == Fruta.PERA) System.out.print("PERA ");
            if (fruta == Fruta.PLATANO) System.out.print("PLATANO ");
            if (fruta == Fruta.SANDIA) System.out.print("SANDIA ");
            if (fruta == Fruta.LIMON) System.out.print("LIMON ");
        }
        System.out.println();
    }
}
