/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.*;

public class clsConexion {

	Connection conn = null;

	public Connection sqlite() {
		try {
			// sqlite connection
			String url = "jdbc:sqlite:db/matricula.db";
			conn = DriverManager.getConnection(url);
			System.out.println("connection");
		} catch (SQLException e) {
			System.out.println("fail connection");
		}
		return conn;
	}

	public static void main(String[] args) {
		clsConexion tt = new clsConexion();
		tt.sqlite();
	}
}
