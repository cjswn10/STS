package com.bit.vo;

public class OrdersVO {
	private int orderid;
	private int custid;
	private int bookid;
	private int saleprice;
	private String orderdate;

	public OrdersVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrdersVO(int orderid, int custid, int bookid, int saleprice, String orderdate) {
		super();
		this.orderid = orderid;
		this.custid = custid;
		this.bookid = bookid;
		this.saleprice = saleprice;
		this.orderdate = orderdate;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public int getSaleprice() {
		return saleprice;
	}

	public void setSaleprice(int saleprice) {
		this.saleprice = saleprice;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

}
