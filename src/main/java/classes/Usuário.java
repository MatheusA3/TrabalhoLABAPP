/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.time.LocalDate;

/**
 * Classe abstrata que representa os usuários da aplicação
 * @author Matheus
 */
public abstract class Usuário {
    String nome, telefone, sexo;
    int idade;

    public Usuário(){};
    
    /**
     * Informações dos usuários
     * @param nome nome do usuário
     * @param telefone telefone do usuário
     * @param sexo sexo do usuário
     * @param idade idade do usuário
     */
    public Usuário(String nome, String telefone, String sexo, int idade) {
        this.nome = nome;
        this.telefone = telefone;
        this.sexo = sexo;
        this.idade = idade;
    }
    
    /**
     * Retorna nome do usuário
     * @return nome do usuário
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Atribui nome do usuário
     * @param nome nome do usuário
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * Retorna telefone do usuário
     * @return telefone do usuário
     */
    public String getTelefone() {
        return telefone;
    }
    
    /**
     * Atribui telefone do usuário
     * @param telefone telefone do usuário
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    /**
     * Retorna sexo do usuário
     * @return sexo do usuário
     */
    public String getSexo() {
        return sexo;
    }
    
    /**
     * Atribui sexo do usuário
     * @param sexo sexo do usuário
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    /**
     * Retorna idade do usuário
     * @return idade do usuário
     */
    public int getIdade() {
        return idade;
    }
    
    /**
     * Atribui idade do usuário
     * @param idade idade do usuário
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
}
