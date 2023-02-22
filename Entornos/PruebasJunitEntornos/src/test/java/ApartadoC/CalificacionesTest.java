package ApartadoC;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalificacionesTest {

    /* Técnica del camino básico */
    @Test
    @DisplayName("Camino básico - Caso de prueba 1")
    void casoDePrueba1(){
        double notaTeoria = 5;
        double notaPracticas = 4;
        double notaTrabajos = 5;


        String resultadoEsperado = "4.0";
        String resultado = Calificaciones.calificacion(notaTeoria, notaPracticas, notaTrabajos);
        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    @DisplayName("Camino básico - Caso de prueba 2")
    void casoDePrueba2(){
        double notaTeoria = 4.2;
        double notaPracticas = 5;
        double notaTrabajos = 5;


        String resultadoEsperado = "4.2";
        String resultado = Calificaciones.calificacion(notaTeoria, notaPracticas, notaTrabajos);
        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    @DisplayName("Camino básico - Caso de prueba 3")
    void casoDePrueba3(){
        double notaTeoria = 5;
        double notaPracticas = 5;
        double notaTrabajos = 5;

        String resultadoEsperado = "Matricula de Honor";
        String resultado = Calificaciones.calificacion(notaTeoria, notaPracticas, notaTrabajos);
        assertEquals(resultadoEsperado, resultado);
    }

    /* Técnica de las clases de equivalencia */

    @Test
    @DisplayName("Clases de equivalencia 1 - Valores negativos")
    void valoresNegativosTest(){
        double notaTeoria = -5;
        double notaPracticas = -1;
        double notaTrabajos = -10;

        String resultadoEsperado = "4.0";
        String resultado = Calificaciones.calificacion(notaTeoria, notaPracticas, notaTrabajos);
        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    @DisplayName("Clases de equivalencia 2 - Valores positivos menores o iguales a 10")
    void valoresPositivosMenoresOIgualesA10Test(){
        double notaTeoria = 3;
        double notaPracticas = 5;
        double notaTrabajos = 6;

        String resultadoEsperado = "3.0";
        String resultado = Calificaciones.calificacion(notaTeoria, notaPracticas, notaTrabajos);
        assertEquals(resultadoEsperado, resultado);
    }


    @Test
    @DisplayName("Clases de equivalencia 3 - Valores positivos mayores a 10")
    void valoresPositivosMayoresQue10Test(){
        double notaTeoria = 900;
        double notaPracticas = 1500;
        double notaTrabajos = 450;

        String resultadoEsperado = "Matricula de Honor";
        String resultado = Calificaciones.calificacion(notaTeoria, notaPracticas, notaTrabajos);
        assertEquals(resultadoEsperado, resultado);
    }

    /* Técnica de los valores límite */

    @Test
    @DisplayName("Valores Límite 1 - Valor Minimo posible")
    void valorMinimoPosibleTest(){
        double notaTeoria = 0;
        double notaPracticas = 0;
        double notaTrabajos = 0;

        String resultadoEsperado = "4.0";
        String resultado = Calificaciones.calificacion(notaTeoria, notaPracticas, notaTrabajos);
        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    @DisplayName("Valores Límite 2 - Valor Minimo No Permitido")
    void valorMinimoNoPermitidoTest(){
        double notaTeoria = -1;
        double notaPracticas = -1;
        double notaTrabajos = -1;

        String resultadoEsperado = "4.0";
        String resultado = Calificaciones.calificacion(notaTeoria, notaPracticas, notaTrabajos);
        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    @DisplayName("Valores Límite 3 - Valor Máximo Posible")
    void valorMaximoPosibleTest(){
        double notaTeoria = 10;
        double notaPracticas = 10;
        double notaTrabajos = 10;

        String resultadoEsperado = "Matricula de Honor";
        String resultado = Calificaciones.calificacion(notaTeoria, notaPracticas, notaTrabajos);
        assertEquals(resultadoEsperado, resultado);

    }

    @Test
    @DisplayName("Valores Límite 4 - Valor Máximo no permitido")
    void valorMaximoNoPermitidoTest(){
        double notaTeoria = 11;
        double notaPracticas = 11;
        double notaTrabajos = 11;

        String resultadoEsperado = "Matricula de Honor";
        String resultado = Calificaciones.calificacion(notaTeoria, notaPracticas, notaTrabajos);
        assertEquals(resultadoEsperado, resultado);
    }


}