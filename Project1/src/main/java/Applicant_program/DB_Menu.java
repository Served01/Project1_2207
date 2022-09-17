package Applicant_program;

import java.util.Scanner;

public class DB_Menu extends MN_Menu {
	
	String db_sql1 ="select*from Applicant order by DB_number";
	
	
	public void dbMenu() {
		
        int main_input1;
 	
		DB_Select dbs = new DB_Select();
		DB_Insert dbi = new DB_Insert();
		DB_Update dbu = new DB_Update();
		DB_Delete dbd = new DB_Delete();
		MN_Exit mne = new MN_Exit();
		 
		System.out.println();
		System.out.println("원하시는 작업번호를 누르세요");
		System.out.println("1. 데이터 조회 / 2. 데이터 입력 / 3. 데이터 수정 / 4. 데이터 삭제 / 5. 메인 메뉴로 돌아가기 / 6. 로그아웃 / 7. 종료");
		
		
		do {
			try {
				
			main_input1 = sc.nextInt();
			
			if(main_input1==1) {
			dbs.dbSelect();
			break;
			} else if(main_input1==2) {
		    dbi. dbInsert();
		    break;
			} else if(main_input1==3) {
	        dbu.dbUpdate();
	        break;
			} else if (main_input1==4) {
		    dbd.dbDelete();
		    break;
			} else if (main_input1==5) {
			mnMenu();
			break;
			} else if (main_input1==6) {
				try {
					if(rs != null) { rs.close(); }
					if(pstmt != null) { pstmt.close(); }
					if(conn != null) { conn.close(); }
					System.out.println("데이터베이스 객체를 닫는데 성공하였습니다.");
					
				}catch(Exception e) {
					System.out.println("데이터베이스 객체를 닫는데 실패하였습니다.");
				}
				getConn();
				mnMenu();
			}  else if (main_input1==7) {
			mne.mnExit();
			} else {
				System.out.println("잘못된 값입니다. 다시 입력해 주십시오.");
			}} catch(Exception e) {
				System.out.println("데이터가 정수형이 아닙니다. 확인 바랍니다.");
				sc = new Scanner(System.in);
			}}while(run);
		
	}

}
		
	


	

