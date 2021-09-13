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
import classes.Funcionário;
import classes.Livro;

/**
 * Representa a conexão da classe livro com o banco de dados
 * @author Matheus
 */
public class LivroDAO {
    private static final LivroDAO instance = new LivroDAO();
    
    /**
     * Retorna instância singleton da classe
     * @return instância da classe
     */
    public static LivroDAO getInstance() {
        return instance;
    }
    
    /**
     * Adiciona livro no banco de dados
     * @param l livro a ser adicionado
     */
    public void adicionar(Livro l) {
        try {
            Connection conn = SQLConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into livro values (null,?,?,?,?,?)");
            ps.setInt(1, l.getCódigo());
            ps.setString(2, l.getTítulo());
            ps.setString(3, l.getAutor());
            ps.setString(4, l.getGenero());
            ps.setBoolean(5, l.isIsEmprestado());
            
            ps.execute();
            conn.close();
            System.out.printf("Livro %s inserido com sucesso\n", l.getTítulo());
        } catch (SQLException ex) {
            System.out.printf("Erro ao inserir livro %s\n%s\n\n", l.getTítulo(), ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    /**
     * Remove livro do banco de dados
     * @param l livro a ser removido
     */
    public void remover(Livro l) {
        try {
            Connection conn = SQLConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("delete from livro where id=?");
            ps.setInt(1, l.getId());
            ps.execute();
            conn.close();
            System.out.printf("Livro %s - %s removido com sucesso\n", l.getId(), l.getTítulo());
        } catch (SQLException ex) {
            System.out.printf("Erro ao remover %s\n%s\n\n", l.getTítulo(), ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    /**
     * Atualiza livro no banco de dados
     * @param l livro que receberá atualizações
     */
    public void alterar(Livro l) {
        try {
            Connection conn = SQLConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("update livro set codigo=?, titulo=?, autor=?, genero=?, isEmprestado=? where id=?");
            ps.setInt(1, l.getCódigo());
            ps.setString(2, l.getTítulo());
            ps.setString(3, l.getAutor());
            ps.setString(4, l.getGenero());
            ps.setBoolean(5, l.isIsEmprestado());
            
            ps.execute();
            conn.close();
            System.out.printf("Livro %s - %s atualizado com sucesso\n", l.getId(), l.getTítulo());
        } catch (SQLException ex) {
            System.out.printf("Erro ao alterar livro %s\n%s\n\n", l.getTítulo(), ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    public ArrayList<Livro> buscar(String titulo) {
    ArrayList<Livro> resultado = new ArrayList<>();
    try {

        Connection conn = SQLConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from livro where titulo like '%" + titulo + "%'");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Livro l = new Livro();
            l.setCódigo(rs.getInt(1));
            l.setTítulo(rs.getString(2));
            l.setAutor(rs.getString(3));
            l.setGenero(rs.getString(4));
            l.setIsEmprestado(rs.getBoolean(5));
            resultado.add(l);
        }

        conn.close();

        } catch (SQLException ex) {
            System.out.printf("Erro ao buscar pessoa por usuario %s\n%s\n\n", titulo, ex.getMessage());
            ex.printStackTrace();
        }
            return resultado;
    }
    
    public ArrayList<Livro> buscarTodos() {
    ArrayList<Livro> resultado = new ArrayList<>();
    try {

        Connection conn = SQLConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from livro");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Livro l = new Livro();
            l.setId(rs.getInt(1));
            l.setCódigo(rs.getInt(2));
            l.setTítulo(rs.getString(3));
            l.setAutor(rs.getString(4));
            l.setGenero(rs.getString(5));
            l.setIsEmprestado(rs.getBoolean(6));
            resultado.add(l);
        }

        conn.close();

        } catch (SQLException ex) {
            System.out.printf("Erro ao buscar: %s\n\n", ex.getMessage());
            ex.printStackTrace();
        }
            return resultado;
    }
    
    
}
