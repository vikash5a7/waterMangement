package com.rubicon.watermanagment.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;


@Entity
@Table(name="water")
public class Water implements Serializable {
	private static final long serialVersionUID = -4136005847278048552L;

	@Id
	@GeneratedValue
	private long id;
	@Column(name = "created_at", nullable = false, updatable = false)
	@CreatedDate
	private Date createdAt;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	@Column(nullable=false)
	private String orderName;
	@Column(nullable=false)
	private Date startingDate;
	@Column(nullable=false)
	private Date endingDate;
	@Column(nullable=false)
	private String duration;

	@Column(nullable=false)
	private String status="Requested";
	@ManyToOne
	@JoinColumn(name="users_id")
	private UserEntity userDetails;
	
	public UserEntity getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserEntity userDetails) {
		this.userDetails = userDetails;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public Date getStartingDate() {
		return startingDate;
	}
	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}
	public Date getEndingDate() {
		return endingDate;
	}
	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Water [id=" + id + ", createdAt=" + createdAt + ", orderName=" + orderName + ", startingDate="
				+ startingDate + ", endingDate=" + endingDate + ", duration=" + duration + ", status=" + status
				+ ", userDetails=" + userDetails + "]";
	}
}
