/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KetNoiNhanh;

import java.sql.*;
import java.util.*;
/**
 *
 * @author Admin
 */
public class Faster {
    public static Connection ketNoi(String dtb, String tk, String mk) {
        Connection con = null;
        try {
            String url = "jdbc:sqlserver://localhost:1433;databaseName="+dtb;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url, tk, mk);
            return con;
        } catch (Exception e) {
            return null;
        }
    }
}
