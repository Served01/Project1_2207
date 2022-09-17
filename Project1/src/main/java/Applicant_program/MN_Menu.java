package Applicant_program;

import java.util.Scanner;

public class MN_Menu extends DB_Connection{
	
	// 새로 입력하는 값들
			int appli_number; 
			String appli_name;
			String appli_gender;
			String appli_academy;
			String appli_address;
			int appli_career;
			int appli_license;
			int appli_assay;
			int appli_attitude;
			int appli_special;
			int appli_solve;
			
			// 조회를 통해 가져오는 값들
			int appli_number2; 
			String appli_name2;
			String appli_gender2;
			String appli_academy2; 
			String appli_address2;  
			int appli_career2;   
		    int appli_license2;  
			int appli_assay2; 
			int appli_attitude2;
		    int appli_special2;
		    int appli_solve2;
			
		    // 조회를 제외한 이유로 가져오는 값들
			int appli_number3;
			String appli_name3;
			
			// 원하는 데이터를 가져오기 위한 pk 입력값
			int input_number;
	
	public void mnMenu() {
			
	
				DB_Menu dbm =new DB_Menu();
				DM_Menu dmm = new DM_Menu();
				IV_Menu ivm = new IV_Menu();
				MN_Exit mne = new MN_Exit();
				System.out.println("원하시는 작업번호를 누르세요");
				System.out.println("1. 데이터 조회 및 수정 / 2. 서류 합격자 / 3. 최종 합격자 / 4. 로그아웃 / 5. 종료");
				
				do {
					try {
			    int main_input0 = 0;
				main_input0 = sc.nextInt();
					
				if(main_input0==1) {
				dbm.dbMenu();
				} else if(main_input0==2) {
			    dmm.dmMenu();
				} else if(main_input0==3) {
				ivm.ivMenu();
				} else if (main_input0==4) {
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
				} else if (main_input0==5) {
					mne.mnExit();
				} else {
					System.out.println("잘못된 값입니다. 다시 입력해 주십시오.");
				}} catch(Exception e) {
					System.out.println("데이터가 정수형이 아닙니다. 확인 바랍니다.");
					sc = new Scanner(System.in);
				}}while (run);
		
	}
}
	


		
	

	