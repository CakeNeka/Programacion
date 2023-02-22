package ApartadoC;

public class Calificaciones {
    /**
     * Da una calificación según las notas obtenidas por un alumno en la teoría,
     prácticas y trabajos
     *
     * @param notaTeoria nota obtenida en exámenes
     * @param notaPracticas nota obtenidas en la realización de prácticas
     * @param notaTrabajos nota obtenida en los trabajos
     * @return nota final
     */
    public static String calificacion(double notaTeoria, double notaPracticas, double
            notaTrabajos) {
        double notaFinal;
        if (notaPracticas < 5) {
            notaFinal = 4;
        } else {
            if (notaTeoria < 4.5) {
                notaFinal = notaTeoria;
            } else {
                notaFinal = notaTeoria + notaTrabajos;
            }
            if (notaFinal > 9.9) {
                return "Matricula de Honor";
            }
        }
        return notaFinal + "";
    }
}
