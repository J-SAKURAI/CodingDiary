package com.huihuan.gmp.entity;

/**
 * MeetingPlace entity. @author MyEclipse Persistence Tools
 */

public class MeetingPlace implements java.io.Serializable {

	// Fields

	private Long id;
	private Long activityId;
	private String placeName;

	// Constructors

	/** default constructor */
	public MeetingPlace() {
	}

	/** full constructor */
	public MeetingPlace(Long activityId, String placeName) {
		this.activityId = activityId;
		this.placeName = placeName;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getActivityId() {
		return this.activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public String getPlaceName() {
		return this.placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

}