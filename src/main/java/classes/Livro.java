/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Classe que representa o livro a ser emprestado
 * @author Matheus
 */
public class Livro {
    private int id;
    int código;
    String título, autor, genero;
    boolean isEmprestado;
    private static ArrayList<Livro> livros = new ArrayList();
    private static ArrayList<Livro> emprestados = new ArrayList();
    
    /**
     * Retorna lista de livros
     * @deprecated Utilizar conexão com banco
     * @return retorna lista de livros
     */
    public ArrayList<Livro> getLivros() {
        return livros;
    }
    
    /**
     * Retorna lista de livros emprestados
     * @deprecated Utilizar conexão com banco
     * @return livros emprestados
     */
    public static ArrayList<Livro> getEmprestados() {
        return emprestados;
    }
    
    public Livro(){
        
    }
    
    /**
     * Livro que será emprestado
     * @param código código do livro
     * @param título título do livro
     * @param autor autor do livro
     * @param genero gênero do livro
     * @param isEmprestado disponibilidade para empréstimo
     */
    public Livro(int código, String título, String autor, String genero, boolean isEmprestado) {
        this.código = código;
        this.título = título;
        this.autor = autor;
        this.genero = genero;
        this.isEmprestado = isEmprestado;
    }
    
    /**
     * Retorna id do livro no banco
     * @return id do livro
     */
    public int getId() {
        return id;
    }

    /**
     * Atribui id do livro no banco
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Retorna código do livro
     * @return código do livro
     */
    public int getCódigo() {
        return código;
    }
    
    /**
     * Atribui código do livro
     * @param código código do livro
     */
    public void setCódigo(int código) {
        this.código = código;
    }
    
    /**
     * Retorna título do livro
     * @return título do livro
     */
    public String getTítulo() {
        return título;
    }
    
    /**
     * Atribui título do livro
     * @param título título do livro
     */
    public void setTítulo(String título) {
        this.título = título;
    }
    
    /**
     * Retorna autor do livro
     * @return autor do livro
     */
    public String getAutor() {
        return autor;
    }
    
    /**
     * Atribui autor do livro
     * @param autor autor do livro
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    /**
     * Retorna gênero do livro
     * @return gênero
     */
    public String getGenero() {
        return genero;
    }
    
    /**
     * Atribui gênero do livro
     * @param genero gênero do livro
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    /**
     * Retorna a disponibilidade de empréstimo do livro
     * @return disponibilidade de empréstimo do livro
     */
    public boolean isIsEmprestado() {
        return isEmprestado;
    }
    
    /**
     * Atribui a disponibilidade de empréstimo do livro
     * @param isEmprestado disponibilidade de empréstimo do livro
     */
    public void setIsEmprestado(boolean isEmprestado) {
        this.isEmprestado = isEmprestado;
    }
    
    /**
     * Cadastra o livro na lista de livros
     * @deprecated utilizar conexão com o banco
     * @param livro livro a ser cadastrado
     */
    public void cadastrarLivro(Livro livro){
        this.livros.add(livro);
    }
    
    
    /**
     * Realiza e cadastra o empréstimo
     * @param codigo código do livro
     * @param user usuário que irá realizar o empréstimo
     * @param livro livro a ser emprestado
     * @param dataE data de empréstimo
     * @param dataD data de devolução
     */
    public void realizarEmpréstimo(int codigo, String user, String livro, LocalDate dataE, LocalDate dataD){
        for(int i=0; i<this.livros.size(); i++){
            if(livro.equals(livros.get(i).getTítulo())){
                livros.get(i).isEmprestado = true;
                this.emprestados.add(livros.get(i));
                this.livros.remove(livros.get(i));
            }
        }
    }
    
    /**
     * Realiza a devolução do livro
     * @param código código do livr
     * @param user usuário que realizou a devolução
     * @param livro livro a ser devolvido
     * @param dataD data de devolução
     * @param dataA data atual
     */
    public void realizarDevolução(int código, String user, String livro, LocalDate dataD, LocalDate dataA){
        for(int i=0; i<this.emprestados.size(); i++){
            if(livro.equals(emprestados.get(i).getTítulo())){
                emprestados.get(i).isEmprestado = false;
                this.livros.add(emprestados.get(i));
                this.emprestados.remove(emprestados.get(i));
            }
        }
    }
}
