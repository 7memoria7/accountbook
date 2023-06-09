package dto;

public class AccountDto {

	private String date;		
	private String contents;
	private int income;		
	private int expense;
	private int sum;
	private String details;
	
	public AccountDto() {
	}

	public AccountDto(String date, String contents, int income, int expense, int sum, String details) {
		super();
		this.date = date;
		this.contents = contents;
		this.income = income;
		this.expense = expense;
		this.sum = sum;
		this.details = details;
	}
	
	public AccountDto(int income, int expense, int sum) {
		super();
		
		this.income = income;
		this.expense = expense;
		this.sum = sum;
		
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public int getExpense() {
		return expense;
	}

	public void setExpense(int expense) {
		this.expense = expense;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "날짜 = " + date + ", 내용 = " + contents + ", 수입 = " + income + ", 지출 = " + expense
				+ ", 금액 = " + sum + ", 내용 = " + details;
	}
	
	public String print() {
		return "날짜 = " + date + ", 내용 = " + contents + ", 수입 = " + income + ", 지출 = " + expense
				+ ", 금액 = " + sum + ", 내용 = " + details;
	}
	
}
