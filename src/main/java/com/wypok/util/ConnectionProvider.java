//package com.wypok.util;
//
//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.SQLException;
//
//public class ConnectionProvider {
//
//    private static DataSource dataSource;
//
//    public static Connection getConnection() throws SQLException{
//        return getDataSource().getConnection();
//    }
//
//    public static DataSource getDataSource() {
//        if (dataSource == null){
//            try{
//                Context initialContrxt = new InitialContext();
//                Context envContext = (Context) initialContrxt
//                        .lookup("java:comp");
//                DataSource ds = (DataSource) envContext.lookup("jdbc/weekop");
//                dataSource = ds;
//            } catch (NamingException e){
//                e.printStackTrace();
//            }
//        }
//            return dataSource;
//    }
//}
