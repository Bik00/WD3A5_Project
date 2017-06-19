package yjc.wdb.somebodyplace.bean;

public class Member {
	private String member_email;
	private String member_pw;
	private String member_nickname;
	private String member_birth;
	private int member_code;
	private int distance;
	
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	private double member_lat;
	private double member_lng;
	
	private int member_age;
	private String member_gender;
	
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public String getMember_pw() {
		return member_pw;
	}
	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}
	public String getMember_nickname() {
		return member_nickname;
	}
	public void setMember_nickname(String member_nickname) {
		this.member_nickname = member_nickname;
	}
	public String getMember_birth() {
		return member_birth;
	}
	public void setMember_birth(String member_birth) {
		this.member_birth = member_birth;
	}
	public double getMember_lat() {
		return member_lat;
	}
	public void setMember_lat(double member_lat) {
		this.member_lat = member_lat;
	}
	public double getMember_lng() {
		return member_lng;
	}
	public void setMember_lng(double member_lng) {
		this.member_lng = member_lng;
	}

	public int getMember_code() {
		return member_code;
	}
	public void setMember_code(int member_code) {
		this.member_code = member_code;
	}
	public int getMember_age() {
		return member_age;
	}
	public void setMember_age(int member_age) {
		this.member_age = member_age;
	}
	public String getMember_gender() {
		return member_gender;
	}
	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
	}
}