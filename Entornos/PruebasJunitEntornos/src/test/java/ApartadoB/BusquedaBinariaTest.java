package ApartadoB;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusquedaBinariaTest {

    /* Clases de equivalencia */
    @Test
    void vectorVacioTest(){
        int resultadoEsperado = -1;
        int resultado = BusquedaBinaria.busquedaBinaria(new int[]{}, 2);
        assertEquals(resultadoEsperado, resultado);
    }
    @Test
    void datoMaximoPosibleTest(){
        int[] arr = {1, 5, 7, Integer.MAX_VALUE};
        int dato = Integer.MAX_VALUE;

        int resultadoEsperado = 3;
        int resultado = BusquedaBinaria.busquedaBinaria(arr, dato);
        assertEquals(resultadoEsperado, resultado);
    }
    @Test
    void datoMinimoPosibleTest(){
        int[] arr = {Integer.MIN_VALUE, -45, 6, 7, 9};
        int dato = Integer.MIN_VALUE;

        int resultadoEsperado = 0;
        int resultado = BusquedaBinaria.busquedaBinaria(arr, dato);
        assertEquals(resultadoEsperado, resultado);
    }
    @Test
    void vectorContieneElDatoTest(){
        int[] arr = {-3, 1, 13, 98};
        int dato = 13;

        int resultadoEsperado = 2;
        int resultado = BusquedaBinaria.busquedaBinaria(arr, dato);
        assertEquals(resultadoEsperado, resultado);
    }
    @Test
    void vectorNoContieneElDatoTest(){
        int[] arr = {-3, 1, 13, 98, 101};
        int dato = 124;
        int resultadoEsperado = -1;
        int resultado = BusquedaBinaria.busquedaBinaria(arr, dato);
        assertEquals(resultadoEsperado, resultado);
    }
}