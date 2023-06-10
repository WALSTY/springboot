package com.example.demo;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo1ApplicationTests {

	@Autowired
	private DataSource dataSource;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void getConnection() throws SQLException {
		System.out.println(dataSource.getConnection());
	}


}
