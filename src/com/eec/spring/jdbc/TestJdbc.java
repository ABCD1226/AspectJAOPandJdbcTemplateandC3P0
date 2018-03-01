package com.eec.spring.jdbc;

import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

class MyRowMaper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int index) throws SQLException {
		// 此处index是行的索引，查询多少行
		int stuNo = rs.getInt("stuNo");
		String stuName = rs.getString("stuName");
		Student student = new Student();
		student.setStuNo(stuNo);
		student.setStuName(stuName);
		return student;
	}

}

public class TestJdbc {

	// 查询返回list集合
	@Test
	public void searchList() {
		/*DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");*/
		
		ComboPooledDataSource dataSource=new ComboPooledDataSource();
		try {
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/test");
		dataSource.setUser("root");
		dataSource.setPassword("123456");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = " select * from student ";
		List<Student> list = jdbcTemplate.query(sql, new MyRowMaper());
		for (Student student : list) {
			System.out.println(student);
		}

	}

	// 查询一行记录，返回一个对象
	@Test
	public void searchObject() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = " select * from student where stuNo=? ";
		Student student = jdbcTemplate.queryForObject(sql, new MyRowMaper(),
				1109);
		System.out.println(student);
	}

	// 查询单行单列
	@Test
	public void searchVal() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		/*
		 * String sql = " select count(0) from student ";
		 * //这个queryForObject方法的返回值类型由第二个值决定 int rows =
		 * jdbcTemplate.queryForObject(sql, Integer.class);
		 */

		String sql = " select stuName from student where stuNo=? ";
		Object[] objs = { 1109 };
		String rows = jdbcTemplate.queryForObject(sql, objs, String.class);
		System.out.println("总行数是：" + rows);
	}

	// 删除
	@Test
	public void testDelete() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = " delete from student where stuNo=? ";
		Object[] objs = { 1108 };
		int rows = jdbcTemplate.update(sql, objs);
		System.out.println("受影响的行数：" + rows);
	}

	// 更新
	@Test
	public void testUpdate() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = " update student set stuName=? where stuNo=? ";
		Object[] objs = { "任我行", 1108 };
		int rows = jdbcTemplate.update(sql, objs);
		System.out.println("受影响的行数：" + rows);
	}

	// 新增
	@Test
	public void testInsert() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = " insert into student(stuNo,stuName) values (?,?) ";
		Object[] objs = { 1108, "雍正" };
		int rows = jdbcTemplate.update(sql, objs);
		System.out.println("受影响的行数：" + rows);
	}
}
