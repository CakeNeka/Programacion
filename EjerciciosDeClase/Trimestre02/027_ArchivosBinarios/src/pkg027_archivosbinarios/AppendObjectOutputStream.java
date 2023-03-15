package pkg027_archivosbinarios;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AppendObjectOutputStream extends ObjectOutputStream {

    public AppendObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    public AppendObjectOutputStream() throws IOException, SecurityException {
    }

    /**
     * Al escribir objetos en un archivo, colocará la cabecera al inicio
     * y no en mitad
     * @throws IOException 
     */
    @Override
    protected void writeStreamHeader() throws IOException {
        reset();
    }
    
    
}
