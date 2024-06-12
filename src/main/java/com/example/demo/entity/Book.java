package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name = "inn_id")
	private Inn inn;
	@ManyToOne
	@JoinColumn(name = "plan_id")
	private Plan plan;
	@OneToOne
	@JoinColumn(name = "payment_id")
	private Payment payment;
	private Integer adultNum;
	private Integer childNum;
	@Column(name = "in_date")
	private Date inDate;
	@Column(name = "out_date")
	private Date outDate;
	@Column(name = "booking_date")
	private Date bookingDate;

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
