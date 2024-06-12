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
	private Integer adultNum;
	private Integer childNum;
	@Column(name = "total_price")
	private Integer totalPrice;
	@OneToOne
	@JoinColumn(name = "payment_id")
	private Payment payment;
	@Column(name = "in_date")
	private Date inDate;
	@Column(name = "out_date")
	private Date outDate;
	@Column(name = "booking_date")
	private Date bookingDate;

	public Book() {
	}

	public Book(User user, Inn inn, Plan plan, Integer adultNum, Integer childNum,
			Integer totalPrice, Payment payment, Date inDate, Date outDate, Date bookingDate) {
		this.inn = inn;
		this.user = user;
		this.plan = plan;
		this.adultNum = adultNum;
		this.childNum = childNum;
		this.totalPrice = totalPrice;
		this.payment = payment;
		this.inDate = inDate;
		this.outDate = outDate;
		this.bookingDate = bookingDate;
	}

	public Book(Integer id, User user, Inn inn, Plan plan, Integer adultNum, Integer childNum,
			Integer totalPrice, Payment payment, Date inDate, Date outDate, Date bookingDate) {
		this.id = id;
		this.inn = inn;
		this.user = user;
		this.plan = plan;
		this.adultNum = adultNum;
		this.childNum = childNum;
		this.totalPrice = totalPrice;
		this.payment = payment;
		this.inDate = inDate;
		this.outDate = outDate;
		this.bookingDate = bookingDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Inn getInn() {
		return inn;
	}

	public void setInn(Inn inn) {
		this.inn = inn;
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

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
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

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
}
