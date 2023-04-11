package patrones.state;

public class Phone {

    private State state;

    public Phone() {
        state = new OffState(this);
    }

    public void setState(State state) {
        this.state = state;
    }

    public String lock() {
        return "The phone is being locked, and the screen is being turned off";
    }

    public String home() {
        return "Navigating to the home screen";
    }

    public String unlock() {
        return "Unlocking the phone to access the home screen";
    }

    public String turnOn() {
        return "Turning on the screen, although the device is still locked";
    }

    public String clickHome() {
        return state.onHome();
    }

    public String clickPower() {
        return state.onOffOn();
    }
}
