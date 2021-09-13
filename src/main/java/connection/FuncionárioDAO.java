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

/**
 * Classe que representa a conexão da classe funcionário com o banco de dados
 * @author Matheus
 */
public class FuncionárioDAO {
    
    private static final FuncionárioDAO instance = new FuncionárioDAO();

    /**
     * Retorna instância singleton da classe
     * @return instância da classe
     */
    public static FuncionárioDAO getInstance() {
        return instance;
    }
    
    /**
     * Adiciona funcionário no banco de dados
     * @param f funcionário a ser adicionado
     */
    public void adicionar(Funcionário f) {
        try {
            Connection conn = SQLConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into funcionario values (null,?,?,?,?,?,?)");
            ps.setString(1, f.getNome());
            ps.setString(2, f.getTelefone());
            ps.setString(3, f.getSexo());
            ps.setInt(4, f.getIdade());
            ps.setString(5, f.getUsuário());
            ps.setString(6, f.getSenha());
            ps.execute();
            conn.close();
            System.out.printf("Funcionario %s inserido com sucesso\n", f.getNome());
        } catch (SQLException ex) {
            System.out.printf("Erro ao inserir funcionario %s\n%s\n\n", f.getNome(), ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    /**
     * Remove funcionário do banco de dados
     * @param f funcionário que será removido
     */
    public void remover(Funcionário f) {
        try {
            Connection conn = SQLConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("delete from funcionario where id=?");
            ps.setInt(1, f.getId());
            ps.execute();
            conn.close();
            System.out.printf("Funcionário %s - %s removido com sucesso\n", f.getId(), f.getNome());
        } catch (SQLException ex) {
            System.out.printf("Erro ao remover %s\n%s\n\n", f.getNome(), ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    /**
     * Atualiza funcionário no banco de dados
     * @param f funcionário que receberá alterações
     */
    public void alterar(Funcionário f) {
        try {
            Connection conn = SQLConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("update funcionario set nome=?, telefone=?, sexo=?, idade=?, usuario=?, senha=? where id=?");
            ps.setString(1, f.getNome());
            ps.setString(2, f.getTelefone());
            ps.setString(3, f.getSexo());
            ps.setInt(4, f.getIdade());
            ps.setString(5, f.getUsuário());
            ps.setString(6, f.getSenha());
            ps.execute();
            conn.close();
            System.out.printf("Funcionario %s - %s atualizado com sucesso\n", f.getId(), f.getNome());
        } catch (SQLException ex) {
            System.out.printf("Erro ao alterar funcionario %s\n%s\n\n", f.getNome(), ex.getMessage());
            ex.printStackTrace();
        }

    }
        /**
         * Realiza validação do login do funcionário
         * @param usuario user do funcionário
         * @param senha senha do funcionário
         * @return retorna resultado da validação
         */
    public ArrayList<Funcionário> buscar(String usuario, String senha) {
        ArrayList<Funcionário> resultado = new ArrayList<>();
        try {

            Connection conn = SQLConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from funcionario where usuario like '%" + usuario + "%' AND senha like '%" + senha +"%'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Funcionário f = new Funcionário();
                f.setId(rs.getInt(1));
                f.setNome(rs.getString(2));
                f.setTelefone(rs.getString(3));
                f.setSexo(rs.getString(4));
                f.setIdade(rs.getInt(5));
                f.setUsuário(rs.getString(5));
                f.setSenha(rs.getString(5));
                resultado.add(f);
            }

            conn.close();

        } catch (SQLException ex) {
            System.out.printf("Erro ao buscar pessoa por usuario %s\n%s\n\n", usuario, ex.getMessage());
            ex.printStackTrace();
        }
            return resultado;
    }
}
