package Codigos;

public class VerificarLinguagem {

    public static boolean pertenceLinguagem(String cadeia) {
        if (cadeia == null || cadeia.isEmpty()) {
            return false;
        }

        if (cadeia.charAt(0) == 'a') {
            return verificaA(cadeia, 1);
        } else if (cadeia.charAt(0) == 'b') {
            return verificaB(cadeia, 1);
        } else {
            return false;
        }
    }

    public static boolean verificaA(String cadeia, int pos) {
        if (pos == cadeia.length()) {
            return true;
        }
        if (cadeia.charAt(pos) == 'a') {
            return verificaA(cadeia, pos + 1);
        }
        return false;
    }

    public static boolean verificaB(String cadeia, int pos) {
        if (pos == cadeia.length()) {
            return true;
        }
        if (cadeia.charAt(pos) == 'b') {
            return verificaB(cadeia, pos + 1);
        }
        return false;
    }


    public static void main(String[] args) {

        System.out.println(pertenceLinguagem("a"));    // true
        System.out.println(pertenceLinguagem("aaa"));  // true
        System.out.println(pertenceLinguagem("b"));    // true
        System.out.println(pertenceLinguagem("bbb"));  // true
        System.out.println(pertenceLinguagem("ab"));   // false
        System.out.println(pertenceLinguagem("ba"));   // false
    }
}