package Codigos;

import java.util.ArrayList;
import java.util.List;

public class GerarCadeias {

    public static List<String> gerarCadeias(int N) {
        List<String> cadeias = new ArrayList<>();
        gerarCadeiasAux("", N, cadeias);
        return cadeias;
    }


    private static void gerarCadeiasAux(String prefixo, int N, List<String> cadeias) {

        if (prefixo.length() == N) {
            cadeias.add(prefixo);
            return;
        }


        gerarCadeiasAux(prefixo + "a", N, cadeias);


        gerarCadeiasAux(prefixo + "b", N, cadeias);


        if (prefixo.length() + 1 == N) {
            cadeias.add(prefixo + "c");
        }
    }

    public static void main(String[] args) {

        int N = 3;
        List<String> cadeias = gerarCadeias(N);
        System.out.println("Cadeias de comprimento " + N + ": " + cadeias);
    }
}