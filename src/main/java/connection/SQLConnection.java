/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Classe responsável pela conexão com o banco de dados
 * @author Matheus
 */
public class SQLConnection {
    
    private static MysqlDataSource ds = new MysqlDataSource();

    static {
        ds.setServerName("localhost");
        ds.setUser("root");
        ds.setPassword("root");
        ds.setDatabaseName("trabalho_LAB");
        ds.setURL("jdbc:mysql://localhost/trabalho_LAB?useTimezone=true&serverTimezone=UTC");
    }
    
    /**
     * Retorna conexão com o banco de dados
     * @return conexão com o banco de dados
     * @throws SQLException 
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static void main(String[] args) {
        try {
            getConnection();
            System.out.println("ok");
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

