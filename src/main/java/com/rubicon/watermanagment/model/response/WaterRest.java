package com.rubicon.watermanagment.model.response;

import java.util.Date;

public class WaterRest {

	private String orderName;
	private Date startingDate;
	private Date endingDate;
	private String duration;
	private String status;
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
}
