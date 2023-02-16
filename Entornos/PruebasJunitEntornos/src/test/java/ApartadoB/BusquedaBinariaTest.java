package ApartadoB;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusquedaBinariaTest {

    /* Técnica del camino básico */
    @Test
    void casoDePrueba1(){
        int[] arr = new int[0];
        int dato = 42;
        int resultadoEsperado = -1;
        int resultado = BusquedaBinaria.busquedaBinaria(arr, dato);
        assertEquals(resultadoEsperado, resultado);
    }
    @Test
    void casoDePrueba2(){
        int[] arr = {1, 4, 9};
        int dato = 4;
        int resultadoEsperado = 1;
        int resultado = BusquedaBinaria.busquedaBinaria(arr, dato);
        assertEquals(resultadoEsperado, resultado);
    }
    @Test
    void casoDePrueba3(){
        int[] arr = {3, 8, 9};
        int dato = 12;
        int resultadoEsperado = -1;
        int resultado = BusquedaBinaria.busquedaBinaria(arr, dato);
        assertEquals(resultadoEsperado, resultado);
    }
    @Test
    void casoDePrueba4(){
        int[] arr = {1, 3, 6};
        int dato = -1;
        int resultadoEsperado = -1;
        int resultado = BusquedaBinaria.busquedaBinaria(arr, dato);
        assertEquals(resultadoEsperado, resultado);
    }

    /* Clases de equivalencia */
    @Test
    void vectorVacioTest() {
        int resultadoEsperado = -1;
        int resultado = BusquedaBinaria.busquedaBinaria(new int[]{}, 2);
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

    /* Técnicas de los valores límite */
    @Test
    void datoMaximoPosible1(){
        int[] arr = {1, 5, 7, 15};
        int dato = 16;
        int resultadoEsperado = -1;
        int resultado = BusquedaBinaria.busquedaBinaria(arr, dato);
        assertEquals(resultadoEsperado, resultado);
    }
    @Test
    void datoMaximoPosible2(){
        int[] arr = {1, 5, 7, 15};
        int dato = 15;
        int resultadoEsperado = 3;
        int resultado = BusquedaBinaria.busquedaBinaria(arr, dato);
        assertEquals(resultadoEsperado, resultado);
    }
    @Test
    void datoMinimoPosible1(){
        int[] arr = {1, 5, 7, 15};
        int dato = 0;
        int resultadoEsperado = -1;
        int resultado = BusquedaBinaria.busquedaBinaria(arr, dato);
        assertEquals(resultadoEsperado, resultado);
    }
    @Test
    void datoMinimoPosible2(){
        int[] arr = {1, 5, 7, 15};
        int dato = 1;
        int resultadoEsperado = 0;
        int resultado = BusquedaBinaria.busquedaBinaria(arr, dato);
        assertEquals(resultadoEsperado, resultado);
    }

}