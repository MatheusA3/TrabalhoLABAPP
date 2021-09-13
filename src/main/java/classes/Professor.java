/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Classe que representa o usuário de tipo professor
 * @author Matheus
 */
public class Professor extends Usuário{
    private int id_sql;
    int id;
    private static ArrayList<Professor> professores = new ArrayList();
    
    /**
     * Retorna lista de professores
     * @deprecated Utilizar conexão com o banco
     * @return lista de professores
     */
    public ArrayList<Professor> getProfessores() {
        return professores;
    }
    
    public Professor(){}
    
    /**
     * Usuário do tipo professor
     * @param id identificação do professor
     * @param nome nome do professor
     * @param telefone telefone do professor
     * @param sexo sexo do professor
     * @param idade idade do professor
     */
    public Professor(int id, String nome, String telefone, String sexo, int idade) {
        super(nome, telefone, sexo, idade);
        this.id = id;
    }
    
    /**
     * Retorna id do professor no banco de dados
     * @return id do professor no banco de dados
     */
    public int getId_sql() {
        return id_sql;
    }
    
    /**
     * Retorna id do professor no banco de dados
     * @param id_sql id do professor no banco de dados
     */
    public void setId_sql(int id_sql) {
        this.id_sql = id_sql;
    }
    
    /**
     * Retorna identificação do professor
     * @return identificação do professor
     */
    public int getId() {
        return id;
    }
    
    /**
     * Atribui identificação do professor
     * @param id identificação do professor
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Cadastra professor na lista de professores
     * @deprecated Utilizar conexão com o banco
     * @param professor professor a ser cadastrado
     */
    public void cadastrarProfessor(Professor professor){
        this.professores.add(professor);
    }
}
