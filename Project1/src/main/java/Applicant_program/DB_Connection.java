package Applicant_program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DB_Connection extends MN_Start {
	
    static Scanner sc = new Scanner(System.in);
    
    static boolean run = true;
	
    static String sys_driver = "oracle.jdbc.OracleDriver"; //드라이버 주소
	static String sys_url = "jdbc:oracle:thin:@localhost:1521:xe"; //url 주소
	static Connection conn; //DB연결 클래스
	static PreparedStatement pstmt; //명령 클래스 (이 프로젝트에서는 SQL을 입력하여 명령함) => ex) insert, delete, select, update ...
	static ResultSet rs; //데이터 베이스에서 명령시킨 결과 저장  클래스
	static String sys_id;
	static String sys_pw;
	
	public static Connection getConn() {
		
		try {
			Class.forName(sys_driver); 
			System.out.println("드라이버 연결에 성공하였습니다.");
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			System.out.println("드라이버 연결에 실패하였습니다.");
		} 
		
		
		//3. 사용자 인증
		do {
		try {
			System.out.println("ID: ");
		    sys_id = sc.next();; //계정
			System.out.println("PW: ");
			sys_pw = sc.next(); //비밀번호
			conn= DriverManager.getConnection(sys_url, sys_id, sys_pw); //예외 처리하고 정해져 있는 것
			System.out.println("사용자 인증에 성공하였습니다.");
			break;
		} catch (SQLException e) {
			System.out.println("사용자 인증에 실패하였습니다.");	
			sc = new Scanner (System.in);
		}} while(run);
		
		return conn;
		
		
       }
	   
}
	
	



