package br.com.persistencia.conexao;

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
        	String sqlCOMPANHIAS = "CREATE TABLE COMPANHIA("
                    + "CODIGO varchar(100) PRIMARY KEY NOT NULL,"
                    + "NOME varchar(100) NOT NULL)";
            sta.executeUpdate(sqlCOMPANHIAS);
            
            String sqlUSUARIO = "CREATE TABLE USUARIO("
            		+ "CODIGO varchar(100) PRIMARY KEY NOT NULL,"
            		+ "LOGIN varchar(100) NOT NULL,"
            		+ "SENHA varchar(30) NOT NULL)";
            sta.executeUpdate(sqlUSUARIO);
            
            String sqlAEROPORTO = "CREATE TABLE AEROPORTO("
            		+ "CODIGO varchar(100) PRIMARY KEY NOT NULL,"
            		+ "LATITUDE varchar(100) NOT NULL,"
            		+ "LONGITUDE varchar(100) NOT NULL,"
            		+ "NOME varchar(100) NOT NULL)";
            sta.executeUpdate(sqlAEROPORTO);
            
            String sqlVOO = "CREATE TABLE VOO("
            		+ "CODIGO varchar(100) PRIMARY KEY NOT NULL,"
            		+ "COMPANHIA varchar(100) NOT NULL,"
            		+ "CODIGOORIGEM varchar(100) NOT NULL,"
            		+ "CODIGODESTINO varchar(100) NOT NULL,"
            		+ "CODESHARE varchar(1),"
            		+ "PARADAS int,"
            		+ "EQUIPAMENTO varchar(100),"
            		+ "ASSENTOS int,"
            		+ "DATAHORA varchar(100) NOT NULL,"
            		+ "CONSTRAINT FK_VOO_COMPANHIA FOREIGN KEY (COMPANHIA) REFERENCES COMPANHIA(CODIGO),"
            		+ "CONSTRAINT FK_VOO_ORIGEM FOREIGN KEY (CODIGOORIGEM) REFERENCES AEROPORTO(CODIGO),"
            		+ "CONSTRAINT FK_VOO_DESTINO FOREIGN KEY (CODIGODESTINO) REFERENCES AEROPORTO(CODIGO))";
            sta.executeUpdate(sqlVOO); 
            
            String sqlPassagem = "CREATE TABLE PASSAGEM("
            		+ "CODIGO varchar(100) PRIMARY KEY NOT NULL,"
            		+ "CODIGOUSUARIO varchar(100) NOT NULL,"
            		+ "COMPANHIA varchar(100) NOT NULL,"
            		+ "NOMEPASSAGEIRO varchar(100) NOT NULL,"
            		+ "STATUS varchar(100) NOT NULL,"
            		+ "LIBERARCHECKIN int NOT NULL,"
            		+ "DATAHORA varchar(100) NOT NULL,"
            		+ "ASSENTO int NOT NULL,"
            		+ "DOCUMENTO varchar(100) NOT NULL,"
            		+ "LOCALIZADOR int NOT NULL,"
            		+ "VALOR DECIMAL(10,2) NOT NULL,"
            		+ "CONSTRAINT FK_PASSAGEM_USUARIO FOREIGN KEY (CODIGOUSUARIO) REFERENCES USUARIO(CODIGO),"
            		+ "CONSTRAINT FK_PASSAGEM_COMPANHIA FOREIGN KEY (COMPANHIA) REFERENCES COMPANHIA(CODIGO))";
            sta.executeUpdate(sqlPassagem);
        }
    }

    public static Connection getConexao() throws Exception {
        return criarDataSource().getConnection();
    }

}
