package model.modos;

import model.Premio;

import java.util.List;

public class Automatico implements Modo {
    @Override
    public boolean isAccepted(Premio premio, List<Premio> historico) {
        return true;
    }
}
