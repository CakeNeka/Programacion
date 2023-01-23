package pkg012_;

public class VATOutOfRangeException extends Exception{

    public VATOutOfRangeException() {
        super("The value given for VAT is out of range");
    }
    
}
