package com.eec.service;

import com.eec.dao.StudentDao;

public class StudentService {
	private StudentDao studentDao;

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public void add() {
		studentDao.add();
	}
}
