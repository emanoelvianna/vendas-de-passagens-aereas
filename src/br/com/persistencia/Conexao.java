package br.com.persistencia;

import java.sql.Connection;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.derby.jdbc.EmbeddedDataSource;

public class Conexao {
    public static String DB_NAME = "cadastro";
    public static String USER_NAME = "usuario";
    public static String PASSWORD = "senha";
    private static DataSource dataSource;

    private static DataSource criarDataSource() throws Exception {
        if (dataSource == null) {
            EmbeddedDataSource ds = new EmbeddedDataSource();
            ds.setDatabaseName(DB_NAME);
            ds.setCreateDatabase("create");
            ds.setUser(USER_NAME);
            ds.setPassword(PASSWORD);
            dataSource = ds;
        }
        return dataSource;
    }

    public static void criarBd() throws Exception {
        try (Connection con = criarDataSource().getConnection();
                Statement sta = con.createStatement()) {
        	String sqlCOMPANHIAS = "CREATE TABLE COMPANHIAS("
                    + "CODIGO varchar(100) PRIMARY KEY NOT NULL,"
                    + "NOME varchar(100) NOT NULL)";
            sta.executeUpdate(sqlCOMPANHIAS);
            
            String sqlROTAS = "CREATE TABLE ROTAS("
            		+ "CODIGO varchar(100) PRIMARY KEY NOT NULL,"
            		+ "ORIGEM varchar(100) NOT NULL,"
            		+ "DESTINO varchar(100) NOT NULL,"
            		+ "CODESHARE varchar(1),"
            		+ "PARADAS int,"
            		+ "EQUIPAMENTO varchar(30))";	
            sta.executeUpdate(sqlROTAS);
            
            String sqlUSUARIO = "CREATE TABLE USUARIO("
            		+ "CODIGO varchar(100) PRIMARY KEY NOT NULL,"
            		+ "LOGIN varchar(100) NOT NULL,"
            		+ "SENHA varchar(30))";
            sta.executeUpdate(sqlUSUARIO);
        }
    }

    public static Connection getConexao() throws Exception {
        return criarDataSource().getConnection();
    }

}
