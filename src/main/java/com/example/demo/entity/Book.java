package com.example.demo.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer paymentId;
	private Integer userId;
	private Integer planId;
	private Integer adultNum;
	private Integer childNum;
	private Date bookingDate;
	private Date inDate;
	private Date outDate;
	
	
	public Book() {
		
	}
	
	public Book(Integer id, Integer paymentId, Integer userId, Integer planId, 
			Integer adultNum, Integer childNum, Date bookingDate, Date inDate, Date outDate) {
		
		this.id = id;
		this.paymentId = paymentId;
		this.userId = userId;
		this.planId = planId;
		this.adultNum = adultNum;
		this.childNum = childNum;
		this.bookingDate = bookingDate;
		this.inDate = inDate;
		this.outDate = outDate;
	}
	
	public Book(Integer paymentId, Integer userId, Integer planId, 
			Integer adultNum, Integer childNum, Date bookingDate, Date inDate, Date outDate) {
		
		this.paymentId = paymentId;
		this.userId = userId;
		this.planId = planId;
		this.adultNum = adultNum;
		this.childNum = childNum;
		this.bookingDate = bookingDate;
		this.inDate = inDate;
		this.outDate = outDate;
	}
	
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getPaymentId() {
		return paymentId;
	}
	
	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Integer getPlanId() {
		return planId;
	}
	
	public void setPlanId(Integer planId) {
		this.planId = planId;
	}
	
	public Integer getAdultNum() {
		return adultNum;
	}
	
	public void setAdultNum(Integer adultNum) {
		this.adultNum = adultNum;
	}
	
	public Integer getChildNum() {
		return childNum;
	}
	
	public void setChildNum(Integer childNum) {
		this.childNum = childNum;
	}
	
	public Date getBookingDate() {
		return bookingDate;
	}
	
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	
	public Date getInDate() {
		return inDate;
	}
	
	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}
	
	public Date getOutDate() {
		return outDate;
	}
	
	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}
	

}
