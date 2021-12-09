import java.util.LinkedList;

public class Inicio {
    public static void main(String [] args){
        LinkedList<Integer> lista = new LinkedList<>();
        for (int i = 0; i < 30; i++) {
            lista.add(i+1);
        }
        System.out.println(lista.getLast());
    }
}
