package Applicant_program;

import java.util.Scanner;

public class IV_Menu extends MN_Menu {
	
	String iv_sql1 = "select * from Applicant order by DB_number";
	
	public void ivMenu() {
		
		
		    IV_Update ivu = new IV_Update();
		    IV_Search ivs = new IV_Search();
		    IV_PrintPass ivpp = new IV_PrintPass();
		    IV_PrintFail ivpf = new IV_PrintFail();
		    MN_Menu mnm2 = new MN_Menu();
		    MN_Exit mne = new MN_Exit();
		    
		    System.out.println("원하시는 작업 번호를 누르십시오");
		    System.out.println("1. 점수 입력 및 수정 / 2. 최종 합격 여부 검색 / 3. 최종 합격자 명단 출력 / 4. 최종 불합격자 명단 출력 / 5. 메인 메뉴로 돌아가기 / 6. 로그아웃 / 7. 종료");
		    
			
		    do {
		    	try {
		    	 int main_input3 = 0;
			    main_input3 = sc.nextInt();
				    
			    if(main_input3==1) {
				ivu.ivUpdate();
				break;
				} else if(main_input3==2) {
				ivs.ivSearch();
				break;
				} else if(main_input3==3) {
				ivpp.ivPrintPass();
				break;
				} else if (main_input3==4) {
				ivpf.ivPrintFail();
				break;
				} else if (main_input3==5) {
				mnm2.mnMenu();
				break;
				} else if (main_input3==6) {
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
				} else if (main_input3==7) {
				mne.mnExit();
				} else {
				System.out.println("잘못된 값입니다. 다시 입력해 주십시오.");
				}}catch(Exception e) {
					System.out.println("데이터가 정수형이 아닙니다. 확인 바랍니다.");
					sc = new Scanner(System.in);
				}}while(run);
	    }
		

}
