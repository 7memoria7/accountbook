package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dto.AccountDto;
import singleton.Singleton;

// DAO(Data Access Object)
public class AccountDao {	
	
	private Scanner sc = new Scanner(System.in);
	
	public AccountDao() {		
	}
	
	public void insert() {
		// TODO: insert()
		System.out.println("데이터를 추가합니다");
		
		System.out.print("날짜 = ");
		String date = sc.next();
		
		System.out.print("내용 = ");
		String contents = sc.next();
		
		System.out.print("수입 = ");
		int income = sc.nextInt();
		
		System.out.print("지출 = ");
		int expense = sc.nextInt();
		
	//	System.out.print("금액 = ");
		int sum = income + expense;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		System.out.print("상세내용 = ");
		String details = "";
		try {
			details = br.readLine();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		Singleton s = Singleton.getInstance();
		s.accountList.add(new AccountDto(date, contents, income, expense, sum, details));		
	}
	
	public void delete() {	
		// TODO: delete() 함수
		System.out.print("삭제할 가계부의 내용 >> ");
		String contents = sc.next();
		
		// 검색
		int index = search(contents);
		
		if(index == -1) {
			System.out.println("내용을 찾을 수 없습니다");
		}else {
			
		// 삭제
			Singleton s = Singleton.getInstance();
			s.accountList.remove(index);
			
			System.out.println("내용을 삭제했습니다");
		}
	}
	
	public void select() {	
		// TODO:select() 
		
		System.out.print("검색할 내용 >> ");
		String contents = sc.next();
					
		Singleton s = Singleton.getInstance();
		
		List<AccountDto> findContentsList = new ArrayList<AccountDto>();
	
		for (int i = 0; i < s.accountList.size(); i++) {
			AccountDto dto = s.accountList.get(i);
				
				if(contents.equals(dto.getContents())) {
					findContentsList.add(dto);
			}
		}
		
		
		if(findContentsList.size() == 0) {
			System.out.println("입력하신 내용을 찾을 수 없습니다");
			return;
		}		
		
		System.out.println("검색된 내용입니다 --- ");
		for (int i = 0; i < findContentsList.size(); i++) {
			AccountDto dto = findContentsList.get(i);
			System.out.println(dto.toString());
		}			
	}
	
	public void select1() {	// 날짜 검색
		System.out.print("검색할 날짜 >> ");
		String date = sc.next();
					
		Singleton s = Singleton.getInstance();
		
		List<AccountDto> findDateList = new ArrayList<AccountDto>();
		
		for (int i = 0; i < s.accountList.size(); i++) {
			AccountDto dto = s.accountList.get(i);
				
				if(date.equals(dto.getDate())) {
					findDateList.add(dto);
			}
		}
		
		if(findDateList.size() == 0) {
			System.out.println("입력하신 내용을 찾을 수 없습니다");
			return;
		}		
		
		System.out.println("검색된 내용입니다 --- ");
		for (int i = 0; i < findDateList.size(); i++) {
			AccountDto dto = findDateList.get(i);
			System.out.println(dto.toString());
		}			
	}
	
	public void select2() {	//월별 결산
		System.out.println("몇 월인가요?");
		int month = sc.nextInt();
		
		int incomeSum; 
		int expenseSum;
	//	System.out.println("수입의 합계 = " + incomeSum + "지출의 합계 = " + expenseSum);
	}
	
	public void select3() {	//기간별 결산
		
	}
	
	public void update() {	
		// TODO: update
		System.out.print("수정할 내용 >> ");
		String contents = sc.next();
		
		// 검색
		int index = search(contents);
		if(index == -1) {
			System.out.println("수정할 내용을 찾을 수 없습니다");
			return;
		}
		
		// 수정
		System.out.print("수입 >> ");
		int income = sc.nextInt();
		
		System.out.print("지출 >> ");
		int expense = sc.nextInt();
		

		Singleton s = Singleton.getInstance();
		
		AccountDto dto = s.accountList.get(index);
		dto.setIncome(income);
		dto.setExpense(expense);
				
		System.out.println("수정을 완료했습니다");
	}
	
	public int search(String contents) {
		// TODO: search()
		Singleton s = Singleton.getInstance();
		
		int index = -1;
		for (int i = 0; i < s.accountList.size(); i++) {
			AccountDto dto = s.accountList.get(i);
			if(contents.equals(dto.getContents())) {
				index = i;
				break;
			}
		}		
		return index;
	}
	
	// 확인
	public void allDataPrint() {
		// TODO: allDataPrint
		Singleton s = Singleton.getInstance();
		
		if(s.accountList.isEmpty()) {
			System.out.println("데이터 없습니다");
			return;
		}
		
		for (int i = 0; i < s.accountList.size(); i++) {
			System.out.println(s.accountList.get(i).toString());
		}
	}
}










