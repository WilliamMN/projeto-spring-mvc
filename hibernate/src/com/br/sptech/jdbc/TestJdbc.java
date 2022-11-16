package com.br.sptech.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/udemy?useSSL=false";
		String jdbcUser = "hbs";
		String jdbcPwd = "123456";
		try {
			System.out.println("Conectando no "+jdbcUrl);
			
			Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPwd);
			
			System.out.println("Conectado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
