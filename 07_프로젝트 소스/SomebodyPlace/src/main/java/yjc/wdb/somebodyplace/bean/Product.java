package yjc.wdb.somebodyplace.bean;

public class Product {
	private int product_code;
	private int place_code;
	private String product_name = null;
	private String product_img;
	private int product_price = 0;
	private String product_explanation = null;
	private int dcate_code;
	private String dcate_name;
	private String place_name;
	private String place_logo;
	
	public int getProduct_code() {
		return product_code;
	}
	public void setProduct_code(int product_code) {
		this.product_code = product_code;
	}
	public int getPlace_code() {
		return place_code;
	}
	public void setPlace_code(int place_code) {
		this.place_code = place_code;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_img() {
		return product_img;
	}
	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public String getProduct_explanation() {
		return product_explanation;
	}
	public void setProduct_explanation(String product_explanation) {
		this.product_explanation = product_explanation;
	}
	public int getDcate_code() {
		return dcate_code;
	}
	public void setDcate_code(int dcate_code) {
		this.dcate_code = dcate_code;
	}
	public String getDcate_name() {
		return dcate_name;
	}
	public void setDcate_name(String dcate_name) {
		this.dcate_name = dcate_name;
	}
	public String getPlace_name() {
		return place_name;
	}
	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}
	public String getPlace_logo() {
		return place_logo;
	}
	public void setPlace_logo(String place_logo) {
		this.place_logo = place_logo;
	}
}
