package com.intuit.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.intuit.entity.PersonsTable;

@Component
public class Persons {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<PersonsTable> getAllPeopleData(){
		String sql = "select id, name, age from Persons";
		List<PersonsTable> rows = jdbcTemplate.query(sql, new BeanPropertyRowMapper<PersonsTable>(PersonsTable.class));
		return rows;
	}
	
	public List<String> getStringNames(){
		List<String> names = jdbcTemplate.query("select name from persons", 
				(rs,rowIndex) -> rs.getString("name"));
		return names;
	}
	
	public void delete(int id) {
		String sql = "delete from Persons where id="+id;
		jdbcTemplate.update(sql);
	}
	
	public void insert(String name, int age) {
		jdbcTemplate.update("insert into persons(name,age) values(?,?)",name,age);
	}

}
