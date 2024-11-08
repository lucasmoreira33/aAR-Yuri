package Codigos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VerificarCadeias {


    public static boolean verificarCadeia(Map<String, List<String>> gramatica, String cadeia) {
        return verificarRecursivo(gramatica, "S", cadeia, 0);
    }


    private static boolean verificarRecursivo(Map<String, List<String>> gramatica, String simbolo, String cadeia, int pos) {

        if (pos == cadeia.length()) {
            return gramatica.getOrDefault(simbolo, List.of()).contains("");
        }


        if (simbolo.equals(Character.toString(cadeia.charAt(pos)))) {
            return true;
        }


        List<String> producoes = gramatica.get(simbolo);
        if (producoes == null) {
            return false;
        }


        for (String producao : producoes) {

            if (producao.isEmpty()) {
                if (verificarRecursivo(gramatica, "", cadeia, pos)) {
                    return true;
                }
            } else {

                int i = 0;
                while (i < producao.length() && pos + i < cadeia.length() &&
                        producao.charAt(i) == cadeia.charAt(pos + i)) {
                    i++;
                }

                if (i == producao.length() && verificarRecursivo(gramatica, producao.substring(i), cadeia, pos + i)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Map<String, List<String>> gramatica = new HashMap<>();
        gramatica.put("S", List.of("aA", "bB", "c"));
        gramatica.put("A", List.of("aA", ""));
        gramatica.put("B", List.of("bB", ""));


        System.out.println(verificarCadeia(gramatica, "aaa")); // true
        System.out.println(verificarCadeia(gramatica, "bbb")); // true
        System.out.println(verificarCadeia(gramatica, "c"));   // true
        System.out.println(verificarCadeia(gramatica, "ab"));  // false
    }
}