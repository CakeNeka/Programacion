package ApartadoA;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EsPrimoTest {

    /* Clases de equivalencia */

    @Test
    void numerosNegativosTest() {
        assertFalse(EsPrimo.esPrimo(-1));
        assertTrue(EsPrimo.esPrimo(13));
    }

    @Test
    void numerosMenoresA2Test(){
        assertFalse(EsPrimo.esPrimo(1));
    }

    @Test
    void numerosPrimosTest(){
        assertTrue(EsPrimo.esPrimo(13));
    }

    @Test
    void numerosNoPrimosTest(){
        assertFalse(EsPrimo.esPrimo(54));
    }

    /* Técnica de los valores límite */
    @Test
    void valorMinimoPosibleTest(){
        assertTrue(EsPrimo.esPrimo(2));
    }

    @Test
    void valorMaximoPosibleTest(){
        assertTrue(EsPrimo.esPrimo(Integer.MAX_VALUE));
    }

    @Test
    void valorMinimoNoPermitidoTest(){
        assertFalse(EsPrimo.esPrimo(1));
    }

    @Test
    void numeroNoPrimoMuyGrandeTest() {
        assertFalse(EsPrimo.esPrimo(1_999_999_999));
    }

    @Test
    void numeroPrimoMuyGrandeTest() {
        assertTrue(EsPrimo.esPrimo(1_999_999_973));
    }
}