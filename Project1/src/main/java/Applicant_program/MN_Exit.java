package Applicant_program;

import java.util.Scanner;

public class MN_Exit extends MN_Menu{
	
	public void mnExit() {
		
		System.out.println("정말로 종료하시겠습니까?");
		System.out.println("(아니오 선택시 메인 메뉴로 돌아갑니다.)");
		System.out.println("1. 예/2. 아니오");
		
				do {
					try {
				int main_input00;
				main_input00 = sc.nextInt();
					
			    if(main_input00==1) {
					try {
						if(rs != null) { rs.close(); }
						if(pstmt != null) { pstmt.close(); }
						if(conn != null) { conn.close(); }
						System.out.println("데이터베이스 객체를 닫는데 성공하였습니다.");
						
					}catch(Exception e) {
						System.out.println("데이터베이스 객체를 닫는데 실패하였습니다.");
					}
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
				    break;
				} else if(main_input00==2) {
					MN_Menu mnm = new MN_Menu();
					mnm.mnMenu();
				break;
				}else {
					System.out.println("잘못된 값입니다. 다시 입력해 주십시오.");
				}}catch(Exception e) {
					System.out.println("데이터가 정수형이 아닙니다. 확인 바랍니다.");
					sc = new Scanner(System.in);
				}}while(run);
	}

}
