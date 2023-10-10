package com.kelasb.week4;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Koneksi {
    public static Connection hubungkan(){
        try {
            MysqlDataSource m = new MysqlDataSource();
            m.setDatabaseName("toko"); 
            m.setUser("root"); 
            m.setPassword(""); 
            m.setPortNumber(3306); 
            m.setServerName("localhost"); 
            m.setServerTimezone("Asia/Jakarta"); 
            Connection c = m.getConnection();
            System.out.println("Sukses terhubung!");
            return c;            
        } catch (SQLException e) {
            System.out.println("Gagal terhubung!");
            System.err.println("Error: "+e.getMessage());
        }
        return null;
    }
}
