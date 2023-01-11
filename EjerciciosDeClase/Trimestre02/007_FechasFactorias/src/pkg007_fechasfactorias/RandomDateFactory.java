package pkg007_fechasfactorias;

public class RandomDateFactory implements DateFactory{
    
    @Override
    public Date generateDate() {
        return new Date(1, 1, 1);
    }

    
}
