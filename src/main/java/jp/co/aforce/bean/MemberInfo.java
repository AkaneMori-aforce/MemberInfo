package jp.co.aforce.bean;

public class MemberInfo implements java.io.Serializable {
	
	private String member_id;
	private String last_name;
	private String first_name;
	private String gender;
	private String birth_year;
	private String birth_month;
	private String birth_day;
	private String phone_number;
	private String email_address;
	private String job;
	
	//get
	public String getMemberId() {
		return member_id;
	}
	
	public String getLastName() {
		return last_name;
	}

	public String getFirstName() {
		return first_name;
	}
	
	public String getGender() {
		return gender;
	}
	
	public String getBirthYear() {
		return birth_year;
	}
	
	public String getBirthMonth() {
		return birth_month;
	}
	
	public String getBirthDay() {
		return birth_day;
	}
	
	public String getPhoneNumber() {
		return phone_number;
	}
	
	public String getEmailAddress() {
		return email_address;
	}
	
	public String getJob() {
		return job;
	}

	//set
	public void setMemberId(String member_id) {
		this.member_id = member_id;
	}
	
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}
	
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void setBirthYear(String birth_year) {
		this.birth_year = birth_year;
	}
	
	public void setBirthMonth(String birth_month) {
		this.birth_month = birth_month;
	}
	
	public void setBirthDay(String birth_day) {
		this.birth_day = birth_day;
	}
	
	public void setPhoneNumber(String phone_number) {
		this.phone_number = phone_number;
	}
	
	public void setEmailAddress(String email_address) {
		this.email_address = email_address;
	}
	
	public void setJob(String job) {
		this.job = job;
	}
	
}
