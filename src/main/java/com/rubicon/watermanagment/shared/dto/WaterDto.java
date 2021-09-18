package com.rubicon.watermanagment.shared.dto;

import java.util.Date;

public class WaterDto {
	private String orderName;
	private Date startingDate;
	private Date endingDate;
	private String status;
	private long id;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	private String duration;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
