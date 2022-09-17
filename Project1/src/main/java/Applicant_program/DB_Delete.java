package Applicant_program;

import java.sql.SQLException;
import java.util.Scanner;

public class DB_Delete extends DB_Menu {
	
public void dbDelete() {
	
		//데이터 삭제
		System.out.println();
		System.out.println("-----------------지원자 정보 삭제-----------------");
		do {
		do {
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
		
        String db_sql5 = "select DB_number, DB_name from Applicant where DB_number = " + input_number;
		
		try {
			pstmt = conn.prepareStatement(db_sql5);
			rs = pstmt.executeQuery();
			
			System.out.println("데이터 조회를 성공하였습니다.");
			break;
		} catch (SQLException e) {
			System.out.println("데이터 조회를 실패하였습니다.");
			sc = new Scanner(System.in);
		} }while(run);
		
		
		
		try {
			while(rs.next()) {
				appli_number3 = rs.getInt(1); //DB_number
			    appli_name3 = rs.getString(2); //DB_name
			    
			    System.out.println("데이터 가져오기를 성공하였습니다.");
			    System.out.println("--------------------------------------");
			    System.out.println("번호             이름");
			    System.out.println(appli_number3+"\t"+appli_name3);
			    System.out.println("--------------------------------------");
			}
			break;
      	} catch (SQLException e) {
			System.out.println("데이터 가져오기를 실패하였습니다.");
			sc = new Scanner(System.in);
			//e.printStackTrace();
		} } while(run);
		
		
		do {
			try {
		System.out.println("해당 데이터를 삭제하시겠습니까?");
		System.out.println("1. 삭제/2. 취소(전 메뉴로 돌아가기)");
		int DL_input = sc.nextInt();
		if(DL_input == 1) {	
			System.out.println("데이터를 삭제하겠습니다.");
			break;
		}else if(DL_input == 2) {
			System.out.println("메뉴로 돌아갑니다.");
			dbMenu();
			break;
		}else {
			System.out.println("잘못된 값입니다.");
		}}catch(Exception e) {
			System.out.println("데이터가 정수형이 아닙니다. 확인 바랍니다.");
			sc = new Scanner(System.in);
			} }while(run);
		
		//오라클의 데이터와 순서와 변수(이름)가 같아야함
		String db_sql6 = "delete from Applicant where DB_number ="+appli_number3;				
		
		try {
			pstmt = conn.prepareStatement(db_sql6);
	
			pstmt.executeUpdate(); 
			System.out.println("데이터 삭제를 성공하였습니다.");
		} catch (SQLException e) {
			System.out.println("데이터 삭제를 실패하였습니다.");
			//e.printStackTrace();
		}
			//5. 명령 실행
		try {
				pstmt = conn.prepareStatement(db_sql1);
				rs = pstmt.executeQuery();
				System.out.println("데이터 조회에 성공하였습니다.");
			} catch (SQLException e) {
				System.out.println("데이터 조회에 실패하였습니다.");
			}
			
			//6. 결과 출력
		System.out.println("===========================================================================");
		System.out.println("번호"+"\t"+"\t"+"이름"+"\t"+"성별"+"\t"+"학력"+"\t"+"거주지역"+"\t"+"경력점수"+"\t"+"자격증점수"+"\t"+"자기소개서점수");
		System.out.println("===========================================================================");
		
			try {
				while(rs.next()) {
					
					   appli_number2 = rs.getInt(1); 
					   appli_name2 = rs.getString(2); 
					   appli_gender2 = rs.getString(3); 
					   appli_academy2 = rs.getString(4); 
					   appli_address2 = rs.getString(5); 
					   appli_career2 = rs.getInt(6);  
					   appli_license2 = rs.getInt(7); 
					   appli_assay2 = rs.getInt(8);
					   
					   
					   System.out.println(appli_number2+"\t"+appli_name2+"\t"+appli_gender2+"\t"+appli_academy2+"\t"+appli_address2+"\t"+appli_career2+"\t"+appli_license2+"\t"+appli_assay2);
					   
				}
				System.out.println("========================================================================");
				
			} catch (SQLException e) {
				System.out.println("데이터 가져오기를 실패하였습니다.");
				//e.printStackTrace();
			} 
	
			MN_Exit mne = new MN_Exit();
			System.out.println();
			System.out.println("어떤 작업을 하시겠습니까?");
			System.out.println("1. 현재 작업 반복/2. 전 메뉴로 돌아가기/3. 프로그램 종료");
			
			do {
				try {
				int db_input4;
				db_input4 = sc.nextInt();
				
				
				if(db_input4==1) {
					sc = new Scanner(System.in);
					dbDelete();
					break;
					} else if(db_input4==2) {
				    dbMenu();
				    break;        
					} else if (db_input4==3) {
					mne.mnExit();
					} else {
						System.out.println("잘못된 값입니다. 다시 입력해 주십시오.");
					}}catch(Exception e) {
						System.out.println("데이터가 정수형이 아닙니다. 확인 바랍니다.");
						sc = new Scanner(System.in);
					}} while(run);
		

}
}

