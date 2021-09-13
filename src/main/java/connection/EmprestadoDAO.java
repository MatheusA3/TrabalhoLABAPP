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
import java.time.ZoneId;
import java.util.ArrayList;
import classes.Emprestado;
import classes.Funcionário;
import java.sql.Date;
import classes.Aluno;
import classes.Professor;

/**
 * Classe que representa a conexão da classe Emprestado com o banco de dados
 * @author Matheus
 */
public class EmprestadoDAO {
        private static final EmprestadoDAO instance = new EmprestadoDAO();

    /**
     * Retorna instância singleton da classe
     * @return instância da classe
     */
    public static EmprestadoDAO getInstance() {
        return instance;
    }
    
    /**
     * Adiciona relação de empréstimo para aluno no banco de dados
     * @param e relação a ser adicionada
     */
    public void adicionarEmprestadoA(Emprestado e) {
        try {
            Connection conn = SQLConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into emprestado_aluno values (null,?,?)");
            ps.setInt(1, e.getAluno());
            ps.setDate(2, Date.valueOf(e.getDataDevolucao()));
            ps.execute();
            conn.close();
            System.out.printf("Emprestado Aluno %s-%s inserido com sucesso\n", e.getAluno(), e.getDataDevolucao());
        } catch (SQLException ex) {
            System.out.printf("Erro ao inserir emprestado %s\n%s\n\n", e.getId(), ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    /**
     * Adiciona relação de empréstimo para professor no banco de dados
     * @param e relação a ser adicionada
     */
    public void adicionarEmprestadoP(Emprestado e) {
        try {
            Connection conn = SQLConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into emprestado_professor values (null,?,?)");
            ps.setInt(1, e.getProfessor());
            ps.setDate(2, Date.valueOf(e.getDataDevolucao()));
            ps.execute();
            conn.close();
            System.out.printf("Emprestado Professor %s-%s inserido com sucesso\n", e.getProfessor(), e.getDataDevolucao());
        } catch (SQLException ex) {
            System.out.printf("Erro ao inserir emprestado %s\n%s\n\n", e.getId(), ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    /**
     * Remove relação de empréstimo para aluno do banco de dados
     * @param e relação que será removida
     */
    public void removerEmprestadoA(Emprestado e) {
        try {
            Connection conn = SQLConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("delete from emprestado_aluno where id=?");
            ps.setInt(1, e.getId());
            ps.execute();
            conn.close();
            System.out.printf("Emprestado %s - %s removido com sucesso\n", e.getId(), e.getAluno());
        } catch (SQLException ex) {
            System.out.printf("Erro ao remover %s\n%s\n\n", e.getId(), ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    /**
     * Remove relação de empréstimo para professor do banco de dados
     * @param e relação que será removida
     */
    public void removerEmprestadoP(Emprestado e) {
        try {
            Connection conn = SQLConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("delete from emprestado_professor where id=?");
            ps.setInt(1, e.getId());
            ps.execute();
            conn.close();
            System.out.printf("Emprestado %s removido com sucesso\n", e.getId());
        } catch (SQLException ex) {
            System.out.printf("Erro ao remover %s\n%s\n\n", e.getId(), ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    /**
     * Atualiza relação de empréstimo para aluno no banco de dados
     * @param e relação que será atualizada
     */
    public void alterarEmprestadoA(Emprestado e) {
        try {
            Connection conn = SQLConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("update emprestado_aluno set aluno=?, devolucao=? where id=?");
            ps.setInt(1, e.getAluno());
            ps.setDate(2, Date.valueOf(e.getDataDevolucao()));
            ps.execute();
            conn.close();
            System.out.printf("Emprestado %s atualizado com sucesso\n", e.getId());
        } catch (SQLException ex) {
            System.out.printf("Erro ao alterar emprestado %s\n%s\n\n", e.getId(), ex.getMessage());
            ex.printStackTrace();
        }

    }
    
     /**
     * Atualiza relação de empréstimo para professor no banco de dados
     * @param e relação que será atualizada
     */
    public void alterarEmprestadoP(Emprestado e) {
        try {
            Connection conn = SQLConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("update emprestado_professor set professor=?, devolucao=? where id=?");
            ps.setInt(1, e.getProfessor());
            ps.setDate(2, Date.valueOf(e.getDataDevolucao()));
            ps.execute();
            conn.close();
            System.out.printf("Emprestado %s - %s atualizado com sucesso\n", e.getId(), e.getProfessor());
        } catch (SQLException ex) {
            System.out.printf("Erro ao alterar emprestado %s\n%s\n\n", e.getId(), ex.getMessage());
            ex.printStackTrace();
        }
    }
    
        /**
         * Realiza validação do login do funcionário
         * @param usuario user do funcionário
         * @param senha senha do funcionário
         * @return retorna resultado da validação
         */
    public ArrayList<Emprestado> buscarEmprestadoA() {
        ArrayList<Emprestado> resultado = new ArrayList<>();
        try {

            Connection conn = SQLConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from emprestado_aluno");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Emprestado e = new Emprestado();
                AlunoDAO ad = new AlunoDAO();
                Aluno a = new Aluno();
                e.setId(rs.getInt(1));
                e.setAluno(rs.getInt(2));
                resultado.add(e);
            }

            conn.close();

        } catch (SQLException ex) {
            System.out.printf("Erro ao buscar: %s\n", ex.getMessage());
            ex.printStackTrace();
        }
            return resultado;
    }
    
        public ArrayList<Emprestado> buscarEmprestadoP() {
        ArrayList<Emprestado> resultado = new ArrayList<>();
        try {

            Connection conn = SQLConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from emprestado_professor");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Emprestado e = new Emprestado();
                ProfessorDAO pd = new ProfessorDAO();
                Professor p = new Professor();
                e.setId(rs.getInt(1));
                e.setProfessor(rs.getInt(2));
                resultado.add(e);
            }

            conn.close();

        } catch (SQLException ex) {
            System.out.printf("Erro ao buscar: %s\n", ex.getMessage());
            ex.printStackTrace();
        }
            return resultado;
    }
}
