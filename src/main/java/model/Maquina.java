package model;

import model.modos.Modo;

import java.util.ArrayList;
import java.util.List;

public class Maquina {
    private final Integer tamano; // numero de casillas de la maquina
    private List<Fruta> casillas;
    private Double recaudacion;
    private final Double precio; // el costo de una jugada
    private Double credito = 0.0;
    private List<Premio> premios = new ArrayList<>();
    private List<Premio> historico = new ArrayList<>();
    private Modo modo;    // modo de aceptacion

    public Maquina(Integer tamano, Double recaudacion, Double precio, Modo modo){
        this.tamano = tamano;
        this.recaudacion = recaudacion;
        this.precio = precio;
        this.modo = modo;
    }

    public void altaPremio(Premio premio) {
        if (premio.getValor() <= 0) throw new IllegalArgumentException("El premio tiene que ser de una cantidad positiva");
        if(premio.getCombinacion().size() != tamano) throw new IllegalArgumentException("El tamaño de la combinacion del premio debe ser " + tamano);
        premios.add(premio);
    }

    public void insertarCredito(Double credito) {
        if (credito <= 0) throw new IllegalArgumentException("El credito introducido tiene que ser una cantidad positiva");
        this.credito += credito;
    }

    public void jugar() {
        if (credito < precio) throw new IllegalStateException("No hay credito suficiente para jugar");
        casillas = generarCombinacion();
        if(existPremio()) {
            Premio premio = getPremio();
            if (premio.getValor() <= recaudacion) {
                if (modo.isAccepted(premio, historico)) {
                    historico.add(premio);
                    recaudacion -= premio.getValor();
                    credito += premio.getValor();
                    mostrarJugada();
                }
                else jugar();
            }
            else jugar();
        }
        else {
            mostrarJugada();
            credito -= precio;
            recaudacion += precio;
        }
    }

    private List<Fruta> generarCombinacion() {
        ArrayList<Fruta> resultado = new ArrayList<>(tamano);
        for(int i = 0; i < tamano; i++) {
            resultado.set(i, Fruta.values()[(int) (Math.random() * Fruta.values().length)]);
        }
        return resultado;
    }

    private boolean existPremio() {
        for (Premio premio : premios) {
            if(isPremio(premio)) return true;
        }
        return false;
    }

    private Premio getPremio() {
        for (Premio premio : premios) {
            if(isPremio(premio)) return premio;
        }
        return null;
    }

    private boolean isPremio(Premio premio) {
        for (int i = 0; i < tamano; i++) {
            if(casillas.get(i) != premio.getCombinacion().get(i))
                return false;
        }
        return true;
    }

    private void mostrarJugada() {
        for (Fruta fruta : casillas) {
            if (fruta == Fruta.FRESA) System.out.print("FRESA ");
            if (fruta == Fruta.SANDIA) System.out.print("SANDIA ");
            if (fruta == Fruta.PLATANO) System.out.print("PLATANO ");
            if (fruta == Fruta.MELOCOTON) System.out.print("MELOCOTON ");
            if (fruta == Fruta.PERA) System.out.print("PERA ");
            if (fruta == Fruta.LIMON) System.out.print("LIMON ");
        }
        System.out.println();
    }

    // método cobrar ¿qué devuelve? el crédito disponible
}
