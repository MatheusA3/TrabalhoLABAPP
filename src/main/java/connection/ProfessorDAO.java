/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import classes.Aluno;
import classes.Professor;

/**
 * Classe que representa a conexão da classe Professor com o banco de dados
 * @author Matheus
 */
public class ProfessorDAO {
    private static final ProfessorDAO instance = new ProfessorDAO();
    
    /**
     * Retorna instância singleton da classe
     * @return instância da classe
     */
    public static ProfessorDAO getInstance() {
        return instance;
    }
    
    /**
     * Adiciona professores no banco de dados
     * @param p professor a ser adicionado
     */
    public void adicionar(Professor p) {
        try {
            Connection conn = SQLConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into professor values (null,?,?,?,?,?)");
            ps.setInt(1, p.getId());
            ps.setString(2, p.getNome());
            ps.setString(3, p.getTelefone());
            ps.setString(4, p.getSexo());
            ps.setInt(5, p.getIdade());
            
            ps.execute();
            conn.close();
            System.out.printf("Professor %s inserido com sucesso\n", p.getNome());
        } catch (SQLException ex) {
            System.out.printf("Erro ao inserir professor %s\n%s\n\n", p.getNome(), ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    /**
     * Remove professores do banco de dados
     * @param p professor a ser removido
     */
    public void remover(Professor p) {
        try {
            Connection conn = SQLConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("delete from professor where id=?");
            ps.setInt(1, p.getId_sql());
            ps.execute();
            conn.close();
            System.out.printf("Professor %s - %s removido com sucesso\n", p.getId_sql(), p.getNome());
        } catch (SQLException ex) {
            System.out.printf("Erro ao remover %s\n%s\n\n", p.getNome(), ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    /**
     * Atualiza professor no banco de dados
     * @param p professor que receberá alterações
     */
    public void alterar(Professor p) {
        try {
            Connection conn = SQLConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("update professor set identificacao=?, nome=?, telefone=?, sexo=?, idade=? where id=?");
            ps.setInt(1, p.getId());
            ps.setString(2, p.getNome());
            ps.setString(3, p.getTelefone());
            ps.setString(4, p.getSexo());
            ps.setInt(5, p.getIdade());
            
            ps.execute();
            conn.close();
            System.out.printf("Professor %s - %s atualizado com sucesso\n", p.getId_sql(), p.getNome());
        } catch (SQLException ex) {
            System.out.printf("Erro ao alterar professor %s\n%s\n\n", p.getNome(), ex.getMessage());
            ex.printStackTrace();
        }

    }
    
    public ArrayList<Professor> buscar(String nome) {
    ArrayList<Professor> resultado = new ArrayList<>();
    try {

        Connection conn = SQLConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from professor where nome like '%" + nome + "%'");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Professor p = new Professor();
            p.setId(rs.getInt(1));
            p.setNome(rs.getString(2));
            p.setTelefone(rs.getString(3));
            p.setSexo(rs.getString(4));
            p.setIdade(rs.getInt(5));
            resultado.add(p);
        }

        conn.close();
        
        } catch (SQLException ex) {
            System.out.printf("Erro ao buscar pessoa por usuario %s\n%s\n\n", nome, ex.getMessage());
            ex.printStackTrace();
        }
            return resultado;
    }
    
    public ArrayList<Professor> buscarID(int id) {
    ArrayList<Professor> resultado = new ArrayList<>();
    try {

        Connection conn = SQLConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from professor where id=" + id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Professor p = new Professor();
            p.setId(rs.getInt(1));
            p.setNome(rs.getString(2));
            p.setTelefone(rs.getString(3));
            p.setSexo(rs.getString(4));
            p.setIdade(rs.getInt(5));
            resultado.add(p);
        }

        conn.close();
        
        } catch (SQLException ex) {
            System.out.printf("Erro ao buscar pessoa por usuario %s\n%s\n\n", id, ex.getMessage());
            ex.printStackTrace();
        }
            return resultado;
    }
    
    public ArrayList<Professor> buscarTodos(){
        ArrayList<Professor> resultado = new ArrayList<>();
        try{
            Connection conn = SQLConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from professor");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Professor p = new Professor();
                p.setId_sql(rs.getInt(1));
                p.setId(rs.getInt(2));
                p.setNome(rs.getString(3));
                p.setTelefone(rs.getString(4));
                p.setSexo(rs.getString(5));
                p.setIdade(rs.getInt(6));
                resultado.add(p);
            }
        } catch (SQLException ex){
            System.out.printf("Erro ao buscar: %s\n\n", ex.getMessage());
            ex.printStackTrace();
        }
            return resultado;
    }
}
