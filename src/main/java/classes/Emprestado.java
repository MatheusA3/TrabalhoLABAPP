/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.ArrayList;
import connection.EmprestadoDAO;

/**
 * Classe que representa a relação de empréstimo de um livro para um usuário
 * @author Matheus
 */
public class Emprestado{
    private int id;
    private int aluno;
    private int professor;
    LocalDate DataDevolucao;
    private static ArrayList<Emprestado> emprestados = new ArrayList();
    
    /**
     * Retorna a lista de livros emprestados
     * @deprecated Utilizar conexão ao banco
     * @return livros emprestados
     */
    public static ArrayList<Emprestado> getEmprestados() {
        return emprestados;
    }
    
    /**
     * Popula a lista de livros emprestados
     * @deprecated Utilizar conexão ao banco
     * @param emprestados livros emprestados
     */
    public static void setEmprestados(ArrayList<Emprestado> emprestados) {
        Emprestado.emprestados = emprestados;
    }
    
    public Emprestado(){}
    
    /**
     * Relação de empréstimo com o usuário de tipo Professor
     * @param professor professor que realizou o empréstimo
     * @param DataDevolucao data de devolução do livro
     */
    public Emprestado(Professor p , int professor, LocalDate DataDevolucao) {
        this.professor = professor;
        this.DataDevolucao = DataDevolucao;
    }
    
    /**
     * Retorna id do empréstimo no banco de dados
     * @return id do empréstimo
     */
    public int getId() {
        return id;
    }
    
    /**
     * Atribui id do empréstimo no banco de dados
     * @param id id do empréstimo
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Retorna aluno do empréstimo 
     * @return aluno do empréstimo
     */
    public int getAluno() {
        return aluno;
    }
    
    /**
     * Atribui aluno do empréstimo
     * @param aluno aluno do empréstimo
     */
    public void setAluno(int aluno) {
        this.aluno = aluno;
    }
    
    /**
     * Retorna professor do empréstimo
     * @return professor do empréstimo
     */
    public int getProfessor() {
        return professor;
    }
    
    /**
     * Atribui professor ao empréstimo
     * @param professor professor a ser atríbuido
     */
    public void setProfessor(int professor) {
        this.professor = professor;
    }
    
    /**
     * Retorna data de devolução do livro
     * @return data de devolução do livro
     */
    public LocalDate getDataDevolucao() {
        return DataDevolucao;
    }

    
    /**
     * Atribui data de devolução do livro
     * @param DataDevolucao data de devolução do livro
     */
    public void setDataDevolucao(LocalDate DataDevolucao) {
        this.DataDevolucao = DataDevolucao;
    }
    
    /**
     * Relação de empréstimo com o usuário de tipo Aluno
     * @param aluno
     * @param DataDevolucao 
     */
    public Emprestado(Aluno a, int aluno, LocalDate DataDevolucao) {
        this.aluno = aluno;
        this.DataDevolucao = DataDevolucao;
    }
    
    /**
     * Cadastra o empréstimo
     * @param e relação de empréstimo
     */
    public void cadastrarEmprestado(Emprestado e){
        this.emprestados.add(e);
    }
    
    /**
     * Multa o usuário
     * @param user nome do usuário
     * @param tipo tipo do usuário
     * @param dataA data atual
     * @return resultado da multa
     */
    /*public long multar(String user, String tipo, LocalDate dataA){
        Professor p = new Professor();
        Aluno a = new Aluno();
        ArrayList<Emprestado> e = new ArrayList<>();
        EmprestadoDAO eDAO = new EmprestadoDAO();
        LocalDate dataD;
        long resultado = 0;
        if(tipo.equals("Aluno")){
            e = eDAO.buscarEmprestadoA();
            for(int i=0; i<e.size(); i++){
                if(e.get(i).getAluno().getNome()==user){
                    dataD = e.get(i).getDataDevolucao();
                    if(dataA.isAfter(dataD)){
                        long dias = DAYS.between(dataA, dataD);
                        resultado = 3*dias;
                    }
                }
            
            }
        }
        if(tipo.equals("Professor")){
            e = eDAO.buscarEmprestadoP();
            for(int i=0; i<e.size(); i++){
                if(e.get(i).getProfessor().getNome()==user){
                    dataD = e.get(i).getDataDevolucao();
                    if(dataA.isAfter(dataD)){
                        long dias = DAYS.between(dataA, dataD);
                        resultado = 3*dias;
                    }
                }
            
            }
        }
        return resultado;

    }*/
}
