package com.gsw.HMSDemoApp.Hospital.Management.System.doclogin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "appointments")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	private String age;

	private String systomps;

	private String number;

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appointment(long id, String name, String age, String systomps, String number) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.systomps = systomps;
		this.number = number;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", name=" + name + ", age=" + age + ", systomps=" + systomps + ", number="
				+ number + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSystomps() {
		return systomps;
	}

	public void setSystomps(String systomps) {
		this.systomps = systomps;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
