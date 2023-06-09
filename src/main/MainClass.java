package main;

import java.util.Scanner;

import dao.AccountDao;
import file.FileProc;

public class MainClass {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		AccountDao dao = new AccountDao(); 
		FileProc fp = new FileProc("AccountBook");
		
		// file read 호출
		fp.read();
		
		// 메뉴 
		while(true ) {
			System.out.println("Account Book menu---------------------------------");
			System.out.println("1. 추가");
			System.out.println("2. 삭제");
			System.out.println("3. 이름검색");
			System.out.println("4. 날짜검색");
			System.out.println("5. 월별결산");
			System.out.println("6. 기간별결산");
			System.out.println("7. 수정");
			System.out.println("8. 모두출력");
			System.out.println("9. 파일저장");
			System.out.println("10. 종료");
			
			System.out.print("menu number >> ");
			int menuNumber = sc.nextInt();
			
			switch(menuNumber) {	
			
				case 1:
					dao.insert();
					break;
				case 2:
					dao.delete();
					break;
				case 3:
					dao.select();
					break;
				case 4:
					dao.select1();	//날짜검색
					break;
				case 5:
					dao.select2();	//월별결산
					break;
				case 6:
					dao.select3();	//기간별결산
					break;
				case 7:
					dao.update();
					break;
				case 8:
					dao.allDataPrint();
					break;
				case 9:
					fp.write();
					break;	
					
			}		
		}
	}
}

