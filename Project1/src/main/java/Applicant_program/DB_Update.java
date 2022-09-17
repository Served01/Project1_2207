package Applicant_program;

import java.sql.SQLException;
import java.util.Scanner;

public class DB_Update extends DB_Menu {
	
public void dbUpdate() {
		
		//데이터 수정 루틴
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
		
		String db_sql3 = "select DB_number, DB_name from Applicant where DB_number = "+input_number;
		
		try {
			pstmt = conn.prepareStatement(db_sql3);
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
			System.out.println("   번호        이름");
			System.out.println("----------------------");
			System.out.println(appli_number3+"\t"+appli_name3);
			break;
		}} while(run);
				
				  do {
						try {
							System.out.println("경력 점수를 입력하십시오.");
							appli_career = sc.nextInt();
							
							if (appli_career <= 5 && appli_career >= 0) {
								System.out.println("경력 점수를 입력하였습니다.");
								break;
							} else if (appli_career > 5 || appli_career<0 )
							{System.out.println("경력 점수는 0점이상 5점이하의 범위의 값을 입력하실 수 있습니다. 다시 확인 바랍니다.");}
							}
						
						catch (Exception e) {
							System.out.println("데이터가 정수형이 아닙니다. 확인 바랍니다.");
							sc = new Scanner (System.in);
						    } } while(run);
				  
				  do {
						try {
							System.out.println("자격증 점수를 입력하십시오.");
							appli_license = sc.nextInt();
							
							if (appli_license <= 5 && appli_license >= 0) {
								System.out.println("자격증 점수를 입력하였습니다.");
								break;
							} else if (appli_license > 5 || appli_license<0 )
							{System.out.println("자격증 점수는 0점이상 5점이하의 범위의 값을 입력하실 수 있습니다. 다시 확인 바랍니다.");}
							}
						catch (Exception e) {
							System.out.println("데이터가 정수형이 아닙니다. 확인 바랍니다.");
							sc = new Scanner (System.in);
						    } } while(run);
				  
				  do {
						try {
							System.out.println("자기소개서 점수를 입력하십시오.");
							appli_assay = sc.nextInt();
							
							if (appli_assay <= 20 && appli_assay >= 0) {
								System.out.println("자기소개서 점수를 입력하였습니다.");
								break;
							} else if (appli_assay > 20 || appli_assay<0 )
							{System.out.println("자기소개서 점수는 0점이상 20점이하의 범위의 값을 입력하실 수 있습니다. 다시 확인 바랍니다.");}
							}
						
						catch (Exception e) {
							System.out.println("데이터가 정수형이 아닙니다. 확인 바랍니다.");
							sc = new Scanner (System.in);
						    } } while(run);
				  
							//오라클의 데이터와 순서와 변수(이름)가 같아야함
					String db_sql4 = "update Applicant set DB_career = ?, DB_license = ?, DB_assay = ?"
								+ "where DB_number = ?";
										
						try {
							pstmt = conn.prepareStatement(db_sql4);
							//DB에 저장하는 루틴
							
							pstmt.setInt(1, appli_career);
							pstmt.setInt(2, appli_license);
							pstmt.setInt(3, appli_assay);
							pstmt.setInt(4, appli_number3);
															
							pstmt.executeUpdate(); 
							System.out.println("데이터 수정에 성공하였습니다.");
						} catch (SQLException e) {
							System.out.println("데이터 수정에 실패하였습니다.");
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
						System.out.println("============================================================================");
						System.out.println("번호"+"\t"+"\t"+"이름"+"\t"+"성별"+"\t"+"학력"+"\t"+"거주지역"+"\t"+"경력점수"+"\t"+"자격증점수"+"  "+"자기소개서점수");
						System.out.println("============================================================================");
						
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
							int db_input3;
							db_input3 = sc.nextInt();
							
							   if(db_input3==1) {
								   sc = new Scanner(System.in);
								dbUpdate();
								break;
								} else if(db_input3==2) {
							    dbMenu();
							    break;        
								} else if (db_input3==3) {
								mne.mnExit();
								} else {
									System.out.println("잘못된 값입니다. 다시 입력해 주십시오.");
								}} catch(Exception e) {
									System.out.println("데이터가 정수형이 아닙니다. 확인 바랍니다.");
									sc = new Scanner(System.in);
								}}while(run);
					
		}

}
