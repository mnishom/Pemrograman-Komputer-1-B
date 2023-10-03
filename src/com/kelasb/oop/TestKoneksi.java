
package com.kelasb.oop;

import java.sql.Connection;

public class TestKoneksi {
    public static void main(String[] args) {
        Connection k = Koneksi.sambungDB();
    }
}
