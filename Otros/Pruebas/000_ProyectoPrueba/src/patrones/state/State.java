package patrones.state;

public abstract class State {
    private Phone phone;
    public State(Phone phone) {
        this.phone = phone;
    }
    
    public abstract String onHome();
    public abstract String onOffOn();
}
