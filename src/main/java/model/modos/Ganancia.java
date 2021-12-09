package model.modos;

import model.Premio;

import java.util.LinkedList;
import java.util.List;

public class Ganancia implements Modo {
    Double limite;

    public Ganancia(Double limite) {
        this.limite = limite;
    }

    @Override
    public boolean isAccepted(Premio premio, List<Premio> historico) {
        List<Premio> ultimos = new LinkedList<>();
        Double cantidad = premio.getValor();
        for(int i = 0; i < 9; i++) {
            cantidad += ((LinkedList<Premio>) historico).getLast().getValor();
        }

        return !(cantidad > limite);
    }
}
