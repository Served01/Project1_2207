package Applicant_program;

import java.sql.SQLException;
import java.util.Scanner;

public class IV_PrintPass extends IV_Menu {

	public void ivPrintPass() {	

				try {
					pstmt = conn.prepareStatement(iv_sql1);
					rs = pstmt.executeQuery();
					System.out.println("데이터 조회를 성공하였습니다.");
				} catch (SQLException e) {
					System.out.println("데이터 조회를 실패하였습니다.");
					//e.printStackTrace();
				}
				

				System.out.println("=========================================== 최종 합격자 명단 ===================================================");
				System.out.println("번호\t   이름   성별   학력   거주 지역   경력 점수   자격증 점수   자기소개서 점수  태도 점수  전문지식 점수  문제해결능력 점수");
				System.out.println("=============================================================================================================");
				
				try {
					while(rs.next()) {
						appli_number2 = rs.getInt(1); //DB_number
					    appli_name2 = rs.getString(2); //DB_name
					    appli_gender2 = rs.getString(3); //DB_gender
					    appli_academy2 = rs.getString(4); //DB_academy
					    appli_address2 = rs.getString(5); //DB_address
					    appli_career2 = rs.getInt(6); //DB_career
					    appli_license2 = rs.getInt(7); //DB_license
					    appli_assay2 = rs.getInt(8); //DB_assay
					    appli_attitude2= rs.getInt(9); //DB_attitude
					    appli_special2 = rs.getInt(10); //DB_special
					    appli_solve2 = rs.getInt(11); //DB_solve
						
					    if(appli_career2 + appli_license2 + appli_assay2 >= 20 && appli_attitude2 >= 5 && appli_special2 >= 5 && appli_solve2 >= 5
					    		&& appli_attitude2 + appli_special2 + appli_solve2 >= 20) {
					    	System.out.println(appli_number2+"   "+appli_name2+"  "+appli_gender2+"    "+appli_academy2+"   "
			    					+appli_address2+"        "+appli_career2+"         "+appli_license2+"          "
			    					+appli_assay2+"\t\t"+appli_attitude2+"   \t   "+appli_special2+"\t\t"+appli_solve2);
					    }
					}
					System.out.println("최종 합격자 명단 출력에 성공하였습니다.");
				} catch (SQLException e) {
					System.out.println("최종 합격자 명단 출력에 실패하였습니다.");
					//e.printStackTrace();
				} 
				
				
			    MN_Exit mne = new MN_Exit();
			    System.out.println();
				System.out.println("어떤 작업을 하시겠습니까?");
				System.out.println("1. 현재 작업 반복 / 2. 전 메뉴로 돌아가기 / 3. 프로그램 종료");
				
				do {
					try {
					int iv_input3 = 0;
					iv_input3 = sc.nextInt();
	     		
					   if(iv_input3==1) {
						ivPrintPass();
						break;
						} else if(iv_input3==2) {
					    ivMenu();
					    break;        
						} else if (iv_input3==3) {
							mne.mnExit();
						} else {
							System.out.println("잘못된 값입니다. 다시 입력해 주십시오.");
						}}catch(Exception e) {
							System.out.println("데이터가 정수형이 아닙니다. 확인 바랍니다.");
							sc = new Scanner(System.in);
						}} while(run);
				
			}

}
