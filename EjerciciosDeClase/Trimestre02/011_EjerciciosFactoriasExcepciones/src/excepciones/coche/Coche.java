package excepciones.coche;

public class Coche {
    String matricula;

    private Coche(String matricula) {
        this.matricula = matricula;
    }
    
    public Coche generaCoche(String matricula) throws MatriculaIncorrectaException {
        if (matriculaCorrecta(matricula)){
            return new Coche(matricula);
        } else {
            throw new MatriculaIncorrectaException();
        }
        
    }
    
    public boolean matriculaCorrecta(String matricula) {
        String nums = matricula.substring(0, 4);
        try {
            Integer.parseInt(nums);
        } catch (NumberFormatException e) {
            return false;
        }
        matricula = matricula.substring(4);
        boolean correct = true;
        for (char c : matricula.toCharArray()) {
            if (!Character.isAlphabetic(c))
                correct = false;
        }
        return correct;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) throws MatriculaIncorrectaException {
        if (matriculaCorrecta(matricula)){
            this.matricula = matricula;
        } else {
            throw new MatriculaIncorrectaException();
        }
    }
    
    
}
