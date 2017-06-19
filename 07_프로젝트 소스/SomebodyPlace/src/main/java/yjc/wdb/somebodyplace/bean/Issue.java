package yjc.wdb.somebodyplace.bean;

import java.util.Date;

public class Issue {
	
	private int issue_code;
	private int member_code;
	private String issue_content;
	private String issue_img;
	private String address;
	private double lat;
	private double lng;
	private int radius;
	private String hashtag;
	private Date post_time;
	private String member_nickname;
	private String search_keyword;
	
	public String getSearch_keyword() {
		return search_keyword;
	}
	public void setSearch_keyword(String search_keyword) {
		this.search_keyword = search_keyword;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	private String keyword;
	
	public String getMember_nickname() {
		return member_nickname;
	}
	public void setMember_nickname(String member_nickname) {
		this.member_nickname = member_nickname;
	}
	public int getIssue_code() {
		return issue_code;
	}
	public void setIssue_code(int issue_code) {
		this.issue_code = issue_code;
	}
	public int getMember_code() {
		return member_code;
	}
	public void setMember_code(int member_code) {
		this.member_code = member_code;
	}
	public String getIssue_content() {
		return issue_content;
	}
	public void setIssue_content(String issue_content) {
		this.issue_content = issue_content;
	}
	public String getIssue_img() {
		return issue_img;
	}
	public void setIssue_img(String issue_img) {
		this.issue_img = issue_img;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public String getHashtag() {
		return hashtag;
	}
	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}
	public Date getPost_time() {
		return post_time;
	}
	public void setPost_time(Date post_time) {
		this.post_time = post_time;
	}
}