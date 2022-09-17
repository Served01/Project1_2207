package Applicant_program;

import java.sql.SQLException;
import java.util.Scanner;

public class IV_Update extends IV_Menu {
	

	public void ivUpdate() {
		
		do {
			System.out.println();
		System.out.println("-----------------지원자 데이터 입력-----------------");
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
		
		String iv_sql2 = "select DB_number, DB_name from Applicant where DB_number = "+input_number;
		
		try {
			pstmt = conn.prepareStatement(iv_sql2);
			rs = pstmt.executeQuery();
			
			System.out.println("데이터 조회를 성공하였습니다.");
		} catch (SQLException e) {
			System.out.println("데이터 조회를 실패하였습니다.");
			sc = new Scanner(System.in);
		}
		
		
		try {
			while(rs.next()) {
				appli_number3 = rs.getInt(1); //DB_number
			    appli_name3 = rs.getString(2); //DB_name
			    
			    System.out.println("데이터 가져오기를 성공하였습니다.");
			      
			}
			System.out.println("------------------------------------------------------------------------------------------------------------------");
		} catch (SQLException e) {
			System.out.println("데이터 가져오기를 실패하였습니다.");
			sc = new Scanner(System.in);
			//e.printStackTrace();
		} 
		
		
		if (appli_number3==0) {
			System.out.println("존재하지 않는 지원자번호입니다. 다시 확인해 주십시오.");
			
		} else {
			System.out.println("----------------------");
			System.out.println("번호             이름");
			System.out.println("----------------------");
			System.out.println(appli_number3+"\t"+appli_name3);
			break;
		}} while(run);
	

		
		
		
		do {
		try {
			System.out.println("태도 점수를 입력하십시오.");
			appli_attitude = sc.nextInt();
			
			if (appli_attitude <= 10 && appli_attitude >= 0) {
				System.out.println("태도 점수를 입력하였습니다.");
				break;
			} else if (appli_attitude > 10 || appli_attitude<0 )
			{System.out.println("태도 점수는 0점이상 10점이하의 범위의 값을 입력하실 수 있습니다. 다시 확인 바랍니다.");}
			}
		    catch (Exception e) {
			System.out.println("데이터가 정수형이 아닙니다. 확인 바랍니다.");
			sc = new Scanner (System.in);
		    }} while(run);
		   
	
			
		do {
		try {
			System.out.println("전문지식 점수를 입력하십시오.");
			appli_special = sc.nextInt();
			
			if (appli_special <= 10 && appli_special >= 0) {
				System.out.println("전문지식 점수를 입력하였습니다.");
				break;
			} else if (appli_special > 10 || appli_special<0 )
			{System.out.println("전문지식 점수는 0점이상 10점이하의 범위의 값을 입력하실 수 있습니다. 다시 확인 바랍니다.");}
			}
		
		catch (Exception e) {
			System.out.println("데이터가 정수형이 아닙니다. 확인 바랍니다.");
			sc = new Scanner (System.in);
		    }} while(run);
		
		do {
		try {
			System.out.println("문제해결능력 점수를 입력하십시오.");
			appli_solve = sc.nextInt();
			
			if (appli_solve <= 10 && appli_solve >= 0) {
				System.out.println("문제해결능력 점수를 입력하였습니다.");
				break;
			} else if (appli_solve > 10 || appli_solve<0 )
			{System.out.println("문제해결능력 점수는 0점이상 10점이하의 범위의 값을 입력하실 수 있습니다. 다시 확인 바랍니다.");}
			}
		
		catch (Exception e) {
			System.out.println("데이터가 정수형이 아닙니다. 확인 바랍니다.");
			sc = new Scanner (System.in);
		    } } while(run);
		    
					//오라클의 데이터와 순서와 변수(이름)가 같아야함
				String iv_sql3 = "update Applicant set DB_attitude = ?, DB_special = ?, DB_solve = ?"
						 + "where DB_number = ?";
							
								
				try {
					pstmt = conn.prepareStatement(iv_sql3);
					//DB에 저장하는 루틴
					pstmt.setInt(1, appli_attitude);
					pstmt.setInt(2, appli_special);
					pstmt.setInt(3, appli_solve);
					pstmt.setInt(4, appli_number3);
													
					pstmt.executeUpdate(); 
					System.out.println("데이터 수정에 성공하였습니다.");
				} catch (SQLException e) {
					System.out.println("데이터 수정에 실패하였습니다.");
					//e.printStackTrace();
				}
	
	
	//5.명령 실행
	
	//(20131026, '옥성우2', '컴퓨터정보', 2, 'B', 'F', 172.66, 63.55);
	try {
		pstmt = conn.prepareStatement(iv_sql1);
		rs = pstmt.executeQuery();
		System.out.println("데이터 조회를 성공하였습니다.");
	} catch (SQLException e) {
		System.out.println("데이터 조회를 실패하였습니다.");
	}

	//6.결과 출력
	System.out.println("=========================== 최종합격자 정보 시스템 ================");
	System.out.println("번호" + "\t" +  "\t" + "이름" + "\t" + "태도점수" + "\t" + "전문지식 점수" + "   " + "문제해결능력 점수" + "\t");
	System.out.println("==============================================================");
	 
	try {
		while(rs.next()) {

			appli_number2 = rs.getInt(1); //DB_number
		    appli_name2 = rs.getString(2); //DB_name
		    appli_attitude2= rs.getInt(9); //DB_attitude
		    appli_special2 = rs.getInt(10); //DB_special
		    appli_solve2 = rs.getInt(11); //DB_solve
		    		    
		    System.out.println(appli_number2+ "\t" + appli_name2 + "\t" + appli_attitude2 + "  \t  " + appli_special2 + "\t\t" +  appli_solve2); 
		}
		System.out.println("---------------------------------------------------------------");
	} catch (SQLException e) {
		System.out.println("데이터 가져오기를 실패하였습니다.");
		sc = new Scanner(System.in);
		//e.printStackTrace();
	} 
	
	
	 MN_Exit mne = new MN_Exit();
	 System.out.println();
	System.out.println("어떤 작업을 하시겠습니까?");
	System.out.println("1. 현재 작업 반복 / 2. 전 메뉴로 돌아가기 / 3. 프로그램 종료");
		
	do {
		try {
		int iv_input1 = 0;
		iv_input1 = sc.nextInt();
	   
		   if(iv_input1==1) {
			   sc = new Scanner(System.in);
			ivUpdate();
			break;
			} else if(iv_input1==2) {
		    ivMenu();
		    break;        
			} else if (iv_input1==3) {
				mne.mnExit();
			} else {
				System.out.println("잘못된 값입니다. 다시 입력해 주십시오.");
			}} catch(Exception e) {
				System.out.println("데이터가 정수형이 아닙니다. 확인 바랍니다.");
				sc = new Scanner(System.in);
			}}while(run);
	
}
}

