package patrones.state;

public class OffState extends State {

    public OffState(Phone phone) {
        super(phone);
    }
    
    @Override
    public String onHome() {
        return ":)";
    }

    @Override
    public String onOffOn() {
        return ":(";
    }
    
}
