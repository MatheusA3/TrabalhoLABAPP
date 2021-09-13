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
import classes.Livro;
import classes.Professor;

/**
 * Classe que representa a conexão da classe Aluno ao banco de dados
 * @author Matheus
 */
public class AlunoDAO{
    
    private static final AlunoDAO instance = new AlunoDAO();

    /**
     * Retorna instância singleton da classe
     * @return instância da classe
     */
    public static AlunoDAO getInstance() {
        return instance;
    }
    
    /**
     * Adiciona aluno no banco de dados
     * @param a aluno que será adicionado
     */
    public void adicionar(Aluno a) {
        try {
            Connection conn = SQLConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into aluno values (null,?,?,?,?,?,?)");
            ps.setInt(1, a.getMatricula());
            ps.setString(2, a.getCurso());
            ps.setString(3, a.getNome());
            ps.setString(4, a.getTelefone());
            ps.setString(5, a.getSexo());
            ps.setInt(6, a.getIdade());
            ps.execute();
            conn.close();
            System.out.printf("Aluno %s inserido com sucesso\n", a.getNome());
        } catch (SQLException ex) {
            System.out.printf("Erro ao inserir aluno %s\n%s\n\n", a.getNome(), ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    /**
     * Remove aluno do banco de dados
     * @param a aluno que será removido
     */
    public void remover(Aluno a) {
        try {
            Connection conn = SQLConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("delete from aluno where id=?");
            ps.setInt(1, a.getId());
            ps.execute();
            conn.close();
            System.out.printf("Aluno %s - %s removido com sucesso\n", a.getId(), a.getNome());
        } catch (SQLException ex) {
            System.out.printf("Erro ao remover %s\n%s\n\n", a.getNome(), ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    /**
     * Atualiza aluno no banco de dados
     * @param a aluno que receberá alterações
     */
    public void alterar(Aluno a) {
        try {
            Connection conn = SQLConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("update aluno set matricula=?, curso=?, nome=?, telefone=?, sexo=?, idade=? where id=?");
            ps.setInt(1, a.getMatricula());
            ps.setString(2, a.getCurso());
            ps.setString(3, a.getNome());
            ps.setString(4, a.getTelefone());
            ps.setString(5, a.getSexo());
            ps.setInt(6, a.getIdade());
            ps.setInt(7, a.getId());
            
            ps.execute();
            conn.close();
            System.out.printf("Aluno %s - %s atualizado com sucesso\n", a.getId(), a.getNome());
        } catch (SQLException ex) {
            System.out.printf("Erro ao alterar aluno %s\n%s\n\n", a.getNome(), ex.getMessage());
            ex.printStackTrace();
        }

    }
    
    public ArrayList<Aluno> buscar(String nome) {
    ArrayList<Aluno> resultado = new ArrayList<>();
    try {

        Connection conn = SQLConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from aluno where nome like '%" + nome + "%'");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Aluno a = new Aluno();
            a.setMatricula(rs.getInt(1));
            a.setCurso(rs.getString(2));
            a.setNome(rs.getString(3));
            a.setTelefone(rs.getString(4));
            a.setSexo(rs.getString(5));
            a.setIdade(rs.getInt(6));
            resultado.add(a);
        }

        conn.close();

        } catch (SQLException ex) {
            System.out.printf("Erro ao buscar pessoa por usuario %s\n%s\n\n", nome, ex.getMessage());
            ex.printStackTrace();
        }
            return resultado;
    }
    
    public ArrayList<Aluno> buscarID(int id) {
    ArrayList<Aluno> resultado = new ArrayList<>();
    try {

        Connection conn = SQLConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from professor where id=" + id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Aluno a = new Aluno();
            a.setId(rs.getInt(1));
            a.setNome(rs.getString(2));
            a.setTelefone(rs.getString(3));
            a.setSexo(rs.getString(4));
            a.setIdade(rs.getInt(5));
            resultado.add(a);
        }

        conn.close();
        
        } catch (SQLException ex) {
            System.out.printf("Erro ao buscar pessoa por usuario %s\n%s\n\n", id, ex.getMessage());
            ex.printStackTrace();
        }
            return resultado;
    }
    
    public ArrayList<Aluno> buscarTodos() {
    ArrayList<Aluno> resultado = new ArrayList<>();
    try {

        Connection conn = SQLConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from aluno");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Aluno a = new Aluno();
            a.setId(rs.getInt(1));
            a.setMatricula(rs.getInt(2));
            a.setCurso(rs.getString(3));
            a.setNome(rs.getString(4));
            a.setTelefone(rs.getString(5));
            a.setSexo(rs.getString(6));
            a.setIdade(rs.getInt(7));
            resultado.add(a);
        }

        conn.close();

        } catch (SQLException ex) {
            System.out.printf("Erro ao buscar: %s\n\n", ex.getMessage());
            ex.printStackTrace();
        }
            return resultado;
    }

}

 