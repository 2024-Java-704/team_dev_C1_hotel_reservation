package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToOne
	@JoinColumn(name = "payment_id")
	private Payment payment;
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	@OneToOne
	@JoinColumn(name = "plan_id")
	private Plan plan;
	private Integer adultNum;
	private Integer childNum;
	private Date bookingDate;
	private Date inDate;
	private Date outDate;
	@OneToOne
	@JoinColumn(name = "inn_id")
	private Inn inn;

	public Book() {
	}

	public Book(Payment payment, User user, Plan plan, Integer adultNum, Integer childNum, Date bookingDate,
			Date inDate, Date outDate, Inn inn) {
		this.payment = payment;
		this.user = user;
		this.plan = plan;
		this.adultNum = adultNum;
		this.childNum = childNum;
		this.bookingDate = bookingDate;
		this.inDate = inDate;
		this.outDate = outDate;
		this.inn = inn;
	}

	public Book(Integer id, Payment payment, User user, Plan plan, Integer adultNum, Integer childNum,
			Date bookingDate,
			Date inDate, Date outDate, Inn inn) {
		this.id = id;
		this.payment = payment;
		this.user = user;
		this.plan = plan;
		this.adultNum = adultNum;
		this.childNum = childNum;
		this.bookingDate = bookingDate;
		this.inDate = inDate;
		this.outDate = outDate;
		this.inn = inn;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
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

	public Inn getInn() {
		return inn;
	}

	public void setInn(Inn inn) {
		this.inn = inn;
	}
}
