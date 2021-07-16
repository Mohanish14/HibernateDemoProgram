package com.hibernate.orm.demo;

public class Student {
	private int studId;
	private String studName;
	private int age;
	private double fees;
	private String email;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int studId, String studName, int age, double fees, String email) {
		super();
		this.studId = studId;
		this.studName = studName;
		this.age = age;
		this.fees = fees;
		this.email = email;
	}
	@Override
	public String toString() {
		return "Student [studId=" + studId + ", studName=" + studName + ", age=" + age + ", fees=" + fees + ", email="
				+ email + "]";
	}
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
