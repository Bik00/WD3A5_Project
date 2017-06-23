package yjc.wdb.somebodyplace.bean;

import java.util.Date;

public class Member {
	private String member_email;
	private String member_pw;
	private String member_nickname;
	private String member_birth;
	private int member_code;
	private int distance;
	private String member_name;
	private Date request_date;
	private String product_img;
	private String product_name;
	private String amount;
	private int request_list_totalprice;
	private String request_status;
	
	
	public Date getRequest_date() {
		return request_date;
	}
	public void setRequest_date(Date request_date) {
		this.request_date = request_date;
	}
	public String getProduct_img() {
		return product_img;
	}
	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public int getRequest_list_totalprice() {
		return request_list_totalprice;
	}
	public void setRequest_list_totalprice(int request_list_totalprice) {
		this.request_list_totalprice = request_list_totalprice;
	}
	public String getRequest_status() {
		return request_status;
	}
	public void setRequest_status(String request_status) {
		this.request_status = request_status;
	}

	
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_addr() {
		return member_addr;
	}
	public void setMember_addr(String member_addr) {
		this.member_addr = member_addr;
	}
	public int getMember_phone() {
		return member_phone;
	}
	public void setMember_phone(int member_phone) {
		this.member_phone = member_phone;
	}
	private String member_addr;
	private int member_phone;
	
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