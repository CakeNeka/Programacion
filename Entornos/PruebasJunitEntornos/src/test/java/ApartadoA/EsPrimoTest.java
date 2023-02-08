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
}