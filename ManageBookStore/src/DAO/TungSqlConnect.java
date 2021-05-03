/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author tungk
 */

import java.sql.*;

public class TungSqlConnect {
	String Host = "";
	String UserName = "";
	String Password = "";
	String Database = "";
	
	Connection conn = null;
	Statement statement = null;
	ResultSet result = null;
	
	public TungSqlConnect(String Host, 
			String UserName, 
			String Password, 
			String Database) {
		this.Host = Host;
		this.UserName = UserName;
		this.Password = Password;
		this.Database = Database;
	}
	
	protected void testDriver () throws Exception{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(Exception ex){
			throw new Exception("Driver not found");
		}
	}
	
	protected Connection getConnection() throws Exception{
		//neu chua khoi tao 'conn'
		if(this.conn == null) {
			//kiem tra driver
			testDriver();
			
			//tao url ket noi database
			String url = String.format("jdbc:mysql://%s:3306/%s", this.Host, this.Database);
			try {
				this.conn = DriverManager.getConnection(url, this.UserName, this.Password);
			} catch (Exception ex) {
				throw new Exception("Cannot connect to database: " + url);
			}
		}
		//tra lai connection
		return this.conn;
	}
	
	protected Statement getStatement() throws Exception{
		//kiem tra statement
		if(statement == null || statement.isClosed()) {
			this.statement = getConnection().createStatement();
		}
		return this.statement;
	}
	
	public ResultSet executeQuery(String Query) throws Exception{
		
		try {
			result = getStatement().executeQuery(Query);
		} catch(Exception ex){
			throw new Exception("Cannot execute query: " + Query);
		}
		
		return result;
	}
	
	public int executeUpdate(String Query) throws Exception {
		//luu trang thai khi thuc thi query
		int res = Integer.MIN_VALUE;
		try {
			res = getStatement().executeUpdate(Query);
		} catch (Exception ex) {
			throw new Exception("Cannot excute query: " + Query);
		} finally {this.Close();}
		
		return res;
	}
	
	public void Close() throws SQLException {
		if(result != null && !result.isClosed()) {
			result.close();
			result = null;
		}
		
		if(statement != null && !statement.isClosed()) {
			statement.close();
			statement = null;
		}
		
		if(conn != null && !conn.isClosed()) {
			conn.close();
			conn = null;
		}
	}
}

