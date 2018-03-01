package com.eec.spring.jdbc;

public class Student {
	private int stuNo;
	private String stuName;

	public Student() {
		super();
	}

	public Student(int stuNo, String stuName) {
		super();
		this.stuNo = stuNo;
		this.stuName = stuName;
	}

	@Override
	public String toString() {
		return "Student [stuNo=" + stuNo + ", stuName=" + stuName + "]";
	}

	public int getStuNo() {
		return stuNo;
	}

	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

}
