/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patterns;

import exportações.ExportPDF;
import exportações.ExportTXT;
import java.util.ArrayList;

/**
 * Classe responsável por implementar o padrão Facade, usando uma fachada para os exportadores
 * @author Matheus
 */
public class ExportadorFacada {
    public static ExportadorFacada instance;
    
    public static ExportadorFacada getInstance(){
        if (instance == null){
            instance = new ExportadorFacada();
        }
        return instance;
    }
    
    /**
     * Exporta os relatórios para um arquivo TXT
     * @param o objeto com o conteúdo do relatório
     * @param tipo tipo do relatório
     */
    public void exportarTXT(Object o, String tipo){
        ExportTXT.exportarTXT(o.toString(), tipo);
    }
    
    /**
     * Exporta os relatórios para um arquivo PDF
     * @param o objeto com o conteúdo do relatório
     * @param tipo tipo do relatório
     */
    public void exportarPDF(Object o, String tipo){
        ExportPDF.exportarPDF(o.toString(), tipo);
    }
}
