package yjc.wdb.somebodyplace.bean;

import java.sql.Date;

public class Request {
	
	private int request_code;
	private int member_code;
	private String member_nickname;
	private Date request_date ;
	private String request_status;
	private int product_code;
	private int request_list_code;
	private int detail_code;
	private int request_list_totalprice;
	private String product_name;
	private int amount;
	private String request_type;
	
	public String getRequest_type() {
		return request_type;
	}
	public void setRequest_type(String request_type) {
		this.request_type = request_type;
	}
	public int getRequest_code() {
		return request_code;
	}
	public void setRequest_code(int request_code) {
		this.request_code = request_code;
	}
	public int getMember_code() {
		return member_code;
	}
	public void setMember_code(int member_code) {
		this.member_code = member_code;
	}
	public Date getRequest_date() {
		return request_date;
	}
	public void setRequest_date(Date request_date) {
		this.request_date = request_date;
	}
	public String getRequest_status() {
		return request_status;
	}
	public void setRequest_status(String request_status) {
		this.request_status = request_status;
	}
	public int getProduct_code() {
		return product_code;
	}
	public void setProduct_code(int product_code) {
		this.product_code = product_code;
	}
	public int getRequest_list_code() {
		return request_list_code;
	}
	public void setRequest_list_code(int request_list_code) {
		this.request_list_code = request_list_code;
	}
	public int getDetail_code() {
		return detail_code;
	}
	public void setDetail_code(int detail_code) {
		this.detail_code = detail_code;
	}
	public int getRequest_list_totalprice() {
		return request_list_totalprice;
	}
	public void setRequest_list_totalprice(int request_list_totalprice) {
		this.request_list_totalprice = request_list_totalprice;
	}
	public String getMember_nickname() {
		return member_nickname;
	}
	public void setMember_nickname(String member_nickname) {
		this.member_nickname = member_nickname;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
