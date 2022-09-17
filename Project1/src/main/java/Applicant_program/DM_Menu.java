package Applicant_program;

import java.util.Scanner;

public class DM_Menu extends MN_Menu{
	
	 String dm_sql1 = "select * from Applicant order by DB_number";

	
    public void dmMenu() {
    	 
        DM_Search dms = new DM_Search();
        DM_PrintPass dmpp = new DM_PrintPass();
        DM_PrintFail dmpf = new DM_PrintFail();
        MN_Menu mnm2 = new MN_Menu();
        MN_Exit mne = new MN_Exit();
        
        System.out.println("원하시는 작업 번호를 누르십시오.");
		System.out.println("1. 서류 합격 여부출력 / 2. 서류 합격자 명단출력 / 3. 서류 불합격자 명단출력 / 4. 메인 메뉴로 돌아가기 / 5. 로그아웃 / 6. 종료");
		
		
        do {
        	try {
        	int main_input2;
        	main_input2 = sc.nextInt();
    		
		   if(main_input2==1) {
			dms.dmSearch();
			break;
			} else if(main_input2==2) {
		    dmpp.dmPrintPass();
		    break;
			} else if(main_input2==3) {
	        dmpf.dmPrintFail();
	        break;
			} else if(main_input2==4) {
			mnm2.mnMenu();
		    break;
			} else if (main_input2==5) {
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
			} else if (main_input2==6) {
				mne.mnExit();
			}  else {
				System.out.println("잘못된 값입니다. 다시 입력해 주십시오.");
			}} catch(Exception e) {
				System.out.println("데이터가 정수형이 아닙니다. 확인 바랍니다.");
				sc = new Scanner(System.in);
			}}while(run);
    }

}
