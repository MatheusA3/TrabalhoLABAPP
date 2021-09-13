/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exportações;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe responsável por exportar as informações para um arquivo TXT
 * @author Matheus
 */
public class ExportTXT {
     /**
     * Exporta os relatórios para um arquivo txt
     * @param texto conteúdo da venda em forma textual para a exportação
     */
    public static void exportarTXT(String texto, String tipo){
        try{
            FileWriter fw = new FileWriter(new File(String.format(tipo + "-%s.txt", Calendar.getInstance().getTimeInMillis())));
            fw.write(texto);
            fw.flush();
            fw.close();
            System.out.println("TXT salvo!");
        }catch(IOException e){
            Logger.getLogger(ExportTXT.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
