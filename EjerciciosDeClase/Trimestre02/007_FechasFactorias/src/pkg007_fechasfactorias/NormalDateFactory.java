package pkg007_fechasfactorias;

/**
 *
 * @author Diurno
 * Fecha:  11/01/2023
 */
public class NormalDateFactory implements DateFactory{

    @Override
    public Date generateDate() {
        return new Date(1,1,1970);
    }
    
    public Date generateDate(int dd, int mm, int yyyy){
        if (Date.dateIsCorrect(dd,mm,yyyy))
            return new Date(dd,mm,yyyy);
        else 
            return null;
    }

    
}
