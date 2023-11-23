package com.example.thuvuFinalproject.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Activity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String activityType, arena, extraInfo;
	@DateTimeFormat ( pattern ="yyyy-MM-dd HH:mm")
	private LocalDateTime beginTime;
	@DateTimeFormat ( pattern ="yyyy-MM-dd HH:mm")
	private LocalDateTime finishTime;
	@ManyToOne
	@JoinColumn(name = "teamId")
	private Team team;

	public Activity() {

	}

	public Activity(String activityType, String arena, LocalDateTime beginTime, LocalDateTime finishTime, Team team) {
		super();
		this.activityType = activityType;
		this.arena = arena;
		this.beginTime = beginTime;
		this.finishTime = finishTime;
		this.team = team;
	}

	public Activity(String activityType, String arena, LocalDateTime beginTime, LocalDateTime finishTime, Team team,
			String extraInfo) {
		super();
		this.activityType = activityType;
		this.arena = arena;
		this.extraInfo = extraInfo;
		this.beginTime = beginTime;
		this.finishTime = finishTime;
		this.team = team;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public String getArena() {
		return arena;
	}

	public void setArena(String arena) {
		this.arena = arena;
	}

	public String getExtraInfo() {
		return extraInfo;
	}

	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}

	public LocalDateTime getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(LocalDateTime beginTime) {
		this.beginTime = beginTime;
	}

	public LocalDateTime getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(LocalDateTime finishTime) {
		this.finishTime = finishTime;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Activity [id=" + id + ", activityType=" + activityType + ", arena=" + arena + ", extraInfo=" + extraInfo
				+ ", beginTime=" + beginTime + ", finishTime=" + finishTime + ", team=" + team + "]";
	}

}


