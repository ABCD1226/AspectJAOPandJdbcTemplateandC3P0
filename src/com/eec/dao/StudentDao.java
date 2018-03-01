package com.eec.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void add() {
		String sql = " insert into student(stuNo,stuName) values (?,?) ";
		Object[] objs = { 1107, "乾隆" };
		int rows = jdbcTemplate.update(sql, objs);
		System.out.println("受影响的行数：" + rows);
	}
}
