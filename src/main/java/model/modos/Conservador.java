package model.modos;

import model.Premio;

import java.util.LinkedList;
import java.util.List;

public class Conservador implements Modo {
    @Override
    public boolean isAccepted(Premio premio, List<Premio> historico) {
        return !premio.isThisPremio((((LinkedList<Premio>) historico).getLast()).getCombinacion());
    }
}
