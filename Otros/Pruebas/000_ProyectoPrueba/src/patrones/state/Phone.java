package patrones.state;

public class Phone {
    private State state;
    
    public Phone() {
        state = new OffState(this);
    }
}
