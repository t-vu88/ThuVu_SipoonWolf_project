package com.example.thuvuFinalproject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName, lastName, role, address, email, phone, postcode;
	private int playerNumber;

	@ManyToOne
	@JoinColumn(name = "teamId")
	private Team team;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Member() {

	}
	

	public Member(String firstName, String lastName, String role, String email, String phone, int playerNumber,
			Team team) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.email = email;
		this.phone = phone;
		this.playerNumber = playerNumber;
		this.team = team;
	}

	public Member(String firstName, String lastName, String role, String email, String address, String postcode,
			String phone, int playerNumber, Team team) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.address = address;
		this.email = email;
		this.postcode = postcode;
		this.phone = phone;
		this.playerNumber = playerNumber;
		this.team = team;
	}

	public Member(String firstName, String lastName, String role, String email, String address, String postcode,
			String phone, Team team) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.address = address;
		this.email = email;
		this.postcode = postcode;
		this.phone = phone;
		this.team = team;
	}

	public Member(String firstName, String lastName, String role, String email, String phone, Team team) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.email = email;
		this.phone = phone;
		this.team = team;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", role=" + role
				+ ", address=" + address + ", email=" + email + ", phone=" + phone + ", postcode=" + postcode
				+ ", playerNumber=" + playerNumber + ", team=" + team + "]";
	}

}



