/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Classe que representa os funcionários da biblioteca
 * @author Matheus
 */
public class Funcionário extends Usuário{
    private int id;
    String usuário, senha;
    private static ArrayList<Funcionário> funcionários = new ArrayList();
    
    /**
     * Retorna todos os funcionários da lista
     * @deprecated Utilizar conexão com banco
     * @return funcionários da lista
     */
    public ArrayList<Funcionário> getFuncionários() {
        return funcionários;
    }
    
    public Funcionário(){}
       
    /**
     * Usuário de tipo funcionário
     * @param usuário user do login
     * @param senha senha do login
     * @param nome nome do funcionário
     * @param telefone telefone do funcionário
     * @param sexo sexo do funcionário
     * @param idade idade do funcionário
     */
    public Funcionário(String usuário, String senha, String nome, String telefone, String sexo, int idade) {
        super(nome, telefone, sexo, idade);
        this.usuário = usuário;
        this.senha = senha;
    }
    
    /**
     * Retorna id do funcionário no banco de dados
     * @return 
     */
    public int getId() {
        return id;
    }
    
    /**
     * Atribui id do funcionário no banco de dados
     * @param id id do funcionário
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Retorna o user do funcionário
     * @return user do funcionário
     */
    public String getUsuário() {
        return usuário;
    }
    
    /**
     * Atribui o user do funcionário
     * @param usuário user do funcionário
     */
    public void setUsuário(String usuário) {
        this.usuário = usuário;
    }
    
    /**
     * Retorna a senha do funcionário
     * @return senha do funcionário
     */
    public String getSenha() {
        return senha;
    }
    
    /**
     * Atribui a senha do funcionário
     * @param senha senha do funcionário
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    /**
     * Cadastra funcionários na lista
     * @deprecated Utilizar conexão com banco
     * @param f funcionário
     */
    public void cadastrarFuncionário(Funcionário f){
        this.funcionários.add(f);
    }

    /*@Override
    public void realizarEmpréstimo(int codigo, Livro livro, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    /*@Override
    public void registrarDevolução(int codigo, Livro livro, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}
