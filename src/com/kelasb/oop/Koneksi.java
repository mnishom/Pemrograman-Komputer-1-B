package com.kelasb.oop;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Koneksi {
    
    public static Connection sambungDB(){
        try {
            //our code
            MysqlDataSource m = new MysqlDataSource();
            m.setUser("root"); 
            m.setPassword("");
            m.setDatabaseName("toko"); 
            m.setPortNumber(3306); 
            m.setServerName("localhost");
            m.setServerTimezone("Asia/Jakarta");
            
            Connection k = m.getConnection();
            System.out.println("Sukses terhung ke databse");
            return k;
        } catch (SQLException e) {
            //error handling
            System.err.println("GAGAL terhung ke databse");
            System.err.println("Error: "+e.getMessage());
        }    
        return null;
    }
}
