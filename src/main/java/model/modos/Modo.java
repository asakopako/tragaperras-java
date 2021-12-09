package model.modos;

import model.Premio;

import java.util.List;

public interface Modo {
    boolean isAccepted(Premio premio, List<Premio> historico);
}
