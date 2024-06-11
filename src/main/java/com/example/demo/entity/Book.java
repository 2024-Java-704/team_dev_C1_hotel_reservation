package com.example.demo.entity;

import java.util.Date;

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
	@JoinColumn(name = "payment_id")
	private Payment payment;
	//	@Column(name = "payment_id")
	//	private Integer paymentId;
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	//	@Column(name = "user_id")
	//	private Integer userId;
	@OneToOne
	@JoinColumn(name = "plan_id")
	private Plan plan;
	//		@Column(name = "plan_id")
	//	private Integer planId;
	private Integer adultNum;
	private Integer childNum;
	private Date bookingDate;
	private Date inDate;
	private Date outDate;
	@ManyToOne
	@JoinColumn(name = "inn_id")
	private Inn inn;
	//		@Column(name = "inn_id")
	//	private Integer innId;

	public Book() {
	}

	//	public Book(Integer payment, Integer user, Integer plan, Integer adultNum, Integer childNum, Date bookingDate,
	//			Date inDate, Date outDate, Integer inn) {
	//		this.paymentId = payment;
	//		this.userId = user;
	//		this.planId = plan;
	//		this.adultNum = adultNum;
	//		this.childNum = childNum;
	//		this.bookingDate = bookingDate;
	//		this.inDate = inDate;
	//		this.outDate = outDate;
	//		this.innId = inn;
	//	}
	//
	//	public Book(Integer id, Integer payment, Integer user, Integer plan, Integer adultNum, Integer childNum,
	//			Date bookingDate,
	//			Date inDate, Date outDate, Integer inn) {
	//		this.id = id;
	//		this.paymentId = payment;
	//		this.userId = user;
	//		this.planId = plan;
	//		this.adultNum = adultNum;
	//		this.childNum = childNum;
	//		this.bookingDate = bookingDate;
	//		this.inDate = inDate;
	//		this.outDate = outDate;
	//		this.innId = inn;
	//	}

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

	//	public Integer getUserId() {
	//		return userId;
	//	}
	//
	//	public Integer getPaymentId() {
	//		return paymentId;
	//	}
	//
	//	public void setPaymentId(Integer paymentId) {
	//		this.paymentId = paymentId;
	//	}
	//
	//	public void setUserId(Integer userId) {
	//		this.userId = userId;
	//	}
	//
	//	public Integer getPlanId() {
	//		return planId;
	//	}
	//
	//	public void setPlanId(Integer planId) {
	//		this.planId = planId;
	//	}
	//
	//	public Integer getInnId() {
	//		return innId;
	//	}
	//
	//	public void setInnId(Integer innId) {
	//		this.innId = innId;
	//	}

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
