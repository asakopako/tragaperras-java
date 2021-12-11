package model.modos;

import model.Premio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Ganancia implements Modo {
    Double limite;

    public Ganancia(Double limite) {
        this.limite = limite;
    }

    @Override
    public boolean isAccepted(Premio premio, List<Premio> historico) {
        Double cantidad = premio.getValor();

        //historico = historico.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        //historico.stream().sorted(Comparator::reversed);

        for(int i = 0; i < 9; i++) {
            cantidad += historico.get(historico.size()-1-i).getValor();
        }

        return !(cantidad > limite);
    }
}
