package pruebapdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.StyleConstants.FontConstants;

public class PruebaPdf {

    public static void main(String[] args) {

        /*
            try {
            String fileName = "\\test.pdf";
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(fileName));
            
            document.open();
            Paragraph par = new Paragraph("Probando :)");
            document.add(par);
            document.close();
            } catch (Exception ex) {
            System.err.println(ex);
            }
         */
        try {
            prueba2();
        } catch (DocumentException ex) {
            Logger.getLogger(PruebaPdf.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PruebaPdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void prueba() throws FileNotFoundException, DocumentException, IOException {
//      Create output PDF
        String fileName = "\\documentos\\cartaReyesMagos.pdf";
        Document document = new Document(PageSize.A4);
        OutputStream outputStream = new FileOutputStream(fileName);
        PdfWriter writer = PdfWriter.getInstance(document, outputStream);
        document.open();
        PdfContentByte cb = writer.getDirectContent();

//      Load existing PDF
        String templateInputStream = "\\documentos\\plantillaCarta.pdf";
        PdfReader reader = new PdfReader(templateInputStream);
        PdfImportedPage page = writer.getImportedPage(reader, 1);

//      Copy first page of existing PDF into output PDF
        document.newPage();
        cb.addTemplate(page, 0, 0);

//      Add your new data / text here
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("cartaReyesMagos.pdf"));

        PdfContentByte canvas = stamper.getOverContent(1);
        canvas.beginText();
        canvas.setFontAndSize(BaseFont.createFont(), 12);
        canvas.showTextAligned(PdfContentByte.ALIGN_LEFT, "Hello World", 100, 100, 0);
        canvas.endText();
        stamper.close();
        reader.close();

        document.close();
    }

    // FUNCIONA !!!!!
    static void prueba2() throws IOException, DocumentException {

        String fileName = "\\documentos\\plantillaCarta.pdf";
        PdfReader reader = new PdfReader(fileName);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("\\documentos\\cartaReyesMagos.pdf"));
        PdfContentByte canvas = stamper.getOverContent(1);
        canvas.beginText();
        canvas.setFontAndSize(BaseFont.createFont(), 12);
        int mod = 40;
        for (int i = 0; i < 15; i++) {
            canvas.showTextAligned(PdfContentByte.ALIGN_LEFT, "QUIERO LA PLAY", 100, 600 - mod * i, 0);
            
        }
        canvas.endText();
        stamper.close();
        reader.close();
    }

}
