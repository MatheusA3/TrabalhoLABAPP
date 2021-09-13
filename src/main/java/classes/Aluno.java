/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.ArrayList;

/**
 * Classe que representa o aluno, um dos usuários que pode realizar empréstimos
 * @author Matheus
 */
public class Aluno extends Usuário{
    private int id;
    int matricula;
    String curso;
    private static ArrayList<Aluno> alunos = new ArrayList();
    
    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public Aluno(){}
    
    /**
     * Usuário de tipo aluno
     * @param matricula matrícula do aluno
     * @param curso curso do aluno
     * @param nome nome do aluno
     * @param telefone telefone do aluno
     * @param sexo sexo do aluno
     * @param idade idade do aluno
     */
    public Aluno(int matricula, String curso, String nome, String telefone, String sexo, int idade) {
        super(nome, telefone, sexo, idade);
        this.matricula = matricula;
        this.curso = curso;
    }
    
    /**
     * Retorna o id do aluno registrado no banco de dados 
     * @return id do aluno
     */
    public int getId() {
        return id;
    }
    
    /**
     * Atribui o id do aluno no banco de dados
     * @param id id do aluno
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Retorna a matrícula do aluno
     * @return matrícula do aluno
     */
    public int getMatricula() {
        return matricula;
    }
    
    /**
     * Atribui a matrícula do aluno
     * @param matricula matrícula do aluno
     */
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    
    /**
     * Retorna o curso do aluno
     * @return curso do aluno
     */
    public String getCurso() {
        return curso;
    }
    
    /**
     * Atribui o curso do aluno
     * @param curso curso do aluno
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    
    /**
     * Cadastra aluno na lista
     * @deprecated Utilizar conexão ao banco
     * @param aluno aluno a ser cadastrado
     */
    public void cadastrarAluno(Aluno aluno){
        this.alunos.add(aluno);
    }

}
