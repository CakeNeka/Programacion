package ApartadoA;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EsPrimoTest {

    /* Técnica del camino básico */
    @DisplayName("Camino Básico - Caso de Prueba 1")
    @Test
    void CP1Test(){
        assertFalse(EsPrimo.esPrimo(1));
    }

    @DisplayName("Camino Básico - Caso de Prueba 2")
    @Test
    void CP2Test(){
        assertTrue(EsPrimo.esPrimo(2));
    }

    @DisplayName("Camino Básico - Caso de Prueba 3")
    @Test
    void CP3Test(){
        assertTrue(EsPrimo.esPrimo(3));
    }

    @DisplayName("Camino Básico - Caso de Prueba 4")
    @Test
    void CP4Test(){
        assertFalse(EsPrimo.esPrimo(4));
    }

    @DisplayName("Camino Básico - Caso de Prueba 5")
    @Test
    void CP5Test(){
        assertFalse(EsPrimo.esPrimo(9));
    }

    @DisplayName("Camino Básico - Caso de Prueba 7")
    @Test
    void CP6Test(){
        assertTrue(EsPrimo.esPrimo(7));
    }

    @DisplayName("Camino Básico - Caso de Prueba 7")
    @Test
    void CP7Test(){
        assertFalse(EsPrimo.esPrimo(25));
    }

    @DisplayName("Camino Básico - Caso de Prueba 8")
    @Test
    void CP8Test(){
        assertFalse(EsPrimo.esPrimo(49));
    }

    @DisplayName("Camino Básico - Caso de Prueba 9")
    @Test
    void CP9Test(){
        assertTrue(EsPrimo.esPrimo(997));
    }

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
    void NumeroNoPrimoMuyGrandeTest(){
        assertFalse(EsPrimo.esPrimo(1_999_999_999 ));
    }
    @Test
    void NumeroPrimoMuyGrandeTest(){
        assertTrue(EsPrimo.esPrimo(1_999_999_973));
    }
}
