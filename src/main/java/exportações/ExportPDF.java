/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exportações;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 * Classe responsável por exportar as informações para um arquivo PDF
 * @author Matheus
 */
public class ExportPDF {
    /**
     * Exporta os relatórios para um arquivo PDF
     * @param texto conteúdo do relatório
     * @param tipo tipo do relatório
     */
    public static void exportarPDF(String texto, String tipo){
        try{   
            PDDocument doc = new PDDocument();
            PDPage pg = new PDPage();
            doc.addPage(pg);
            PDPageContentStream cs = new PDPageContentStream(doc, pg);
            
            cs.beginText();
            
            cs.setFont(PDType1Font.COURIER, 13);
            
            cs.setLeading(14.5f);
            
            cs.newLineAtOffset(25, 725);
            String rows[] = texto.split("\n");
            
            for (String row : rows){
                cs.showText(row);
                cs.newLine();
            }
            
            cs.endText();
            
            cs.close();
            
            doc.save(new File(String.format(tipo + "-%s.pdf", Calendar.getInstance().getTimeInMillis())));

            doc.close();
            
            System.out.println("PDF Salvo!");
        }catch(IOException e){
            Logger.getLogger(ExportPDF.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
