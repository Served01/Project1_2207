package Applicant_program;

import java.sql.SQLException;
import java.util.Scanner;

public class IV_Search extends IV_Menu {

	public void ivSearch() {
		
		
		do {
			System.out.println();
			System.out.println("----------------- 최종 합격 조회 -----------------");
		do {
		try {
			System.out.println("지원자 번호를 입력하세요.");
			input_number = sc.nextInt();
			int length = input_number;
			if((int)Math.log10(length)+1 == 8) {
				break;
			}else if((int)Math.log10(length)+1 != 8) {
				System.out.println("지원자 번호는 8자리입니다.");
				sc = new Scanner(System.in);
			}
		} catch(Exception e) {
			System.out.println("데이터가 정수형이 아닙니다. 확인 바랍니다.");
			sc = new Scanner(System.in);
		}}while(run);
		
		String iv_sql4 = "select DB_number, DB_name from Applicant where DB_number = "+input_number;
		
		try {
			pstmt = conn.prepareStatement(iv_sql4);
			rs = pstmt.executeQuery();
			
		} catch (SQLException e) {
			System.out.println("데이터 조회를 실패하였습니다.");
			sc = new Scanner(System.in);
		}
		
		try {
			while(rs.next()) {
				
				appli_number3 = rs.getInt(1); //DB_number
			
			}
			
			System.out.println("------------------------------------------------------------------------------------------------------------------");
		} catch (SQLException e) {
			System.out.println("데이터 확인을 실패하였습니다.");
			sc = new Scanner(System.in);
			//e.printStackTrace();
		} 
		
		
		if (appli_number3==0) {
			System.out.println("존재하지 않는 지원자번호입니다. 다시 확인해 주십시오.");
			
		} else {
			break;
		}} while(run);
		
		System.out.println();
		
		System.out.println("-------------------------------------------------");
		System.out.println("번호 \t\t이름 \t성별 \t합격 여부");
		System.out.println("-------------------------------------------------");
		
	
		
		
				try { 
					//3. sql 구문
					String iv_sql5 = "select * from Applicant where DB_number = ?";
					
					pstmt = conn.prepareStatement(iv_sql5);
					pstmt.setInt(1, appli_number3);
					
					rs = pstmt.executeQuery();
					
					while(rs.next()) {
						appli_number2 = rs.getInt(1); //DB_number
					    appli_name2 = rs.getString(2); //DB_name
					    appli_gender2 = rs.getString(3); //DB_gender
					    appli_career2 = rs.getInt(6); //DB_career
					    appli_license2 = rs.getInt(7); //DB_license
					    appli_assay2 = rs.getInt(8); //DB_assay
					    appli_attitude2= rs.getInt(9); //DB_attitude
					    appli_special2 = rs.getInt(10); //DB_special
					    appli_solve2 = rs.getInt(11); //DB_solve
					int sum2 = (appli_attitude2 + appli_special2 + appli_solve2);
					
					if(appli_career2 + appli_license2 + appli_assay2 < 20 || sum2 < 20 || appli_attitude2 < 5 || appli_special2< 5 || appli_solve2 < 5) {
						System.out.println(appli_number2 + "\t" + appli_name2 + "\t" + appli_gender2 + "\t" + "불합격");
						} else if(appli_career2 + appli_license2 + appli_assay2 >= 20 && sum2 >= 20 && appli_attitude2 >= 5 && appli_special2 >= 5 && appli_solve2 >= 5) {
							System.out.println(appli_number2 + "\t" + appli_name2 + "\t" + appli_gender2 + "\t" + "합격");
							} 
					}
					
				}
				
					catch (Exception e) {
						 System.out.println("가져온 데이터를 처리하는데 문제가 발생하였습니다.");
						//e.printStackTrace();
					} 
				
				MN_Exit mne = new MN_Exit();
				System.out.println();
				System.out.println("어떤 작업을 하시겠습니까?");
				System.out.println("1. 현재 작업 반복 / 2. 전 메뉴로 돌아가기 / 3. 프로그램 종료");
				
				do {
					try {
					int iv_input2 = 0;
					iv_input2 = sc.nextInt();
		      		
					   if(iv_input2==1) {
						   sc = new Scanner(System.in);
						ivSearch();
						break;
						} else if(iv_input2==2) {
					   ivMenu();
					    break;        
						} else if (iv_input2==3) {
							mne.mnExit();
						} else {
							System.out.println("잘못된 값입니다. 다시 입력해 주십시오.");
						}} catch(Exception e) {
							System.out.println("데이터가 정수형이 아닙니다. 확인 바랍니다.");
							sc = new Scanner(System.in);
						}}while(run);
	
}
}
