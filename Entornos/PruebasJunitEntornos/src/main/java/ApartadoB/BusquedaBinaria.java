package ApartadoB;

public class BusquedaBinaria {
    public static int busquedaBinaria(int[] vector, int dato) {
        int inicio = 0;
        int fin = vector.length - 1;
        int pos;
        while (inicio <= fin) {
            pos = (inicio + fin) / 2;
            if (vector[pos] == dato) {
                return pos;
            } else if (vector[pos] < dato) {
                inicio = pos + 1;
            } else {
                fin = pos - 1;
            }
        }
        return -1;
    }
}
