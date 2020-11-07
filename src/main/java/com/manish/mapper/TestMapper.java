package com.manish.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.manish.model.PersonModel;


public interface TestMapper {
	
	@Select("SELECT p.id, p.first_name, p.last_name, p.email, p.phone FROM test.person p ")
	@Results(value = {
			@Result(property = "id", column = "id"),
			@Result(property = "firstName", column = "first_name"),
			@Result(property = "lastName", column = "last_name"),
			@Result(property = "email", column = "email"),       
			@Result(property = "phone", column = "phone")
	})
	public List<PersonModel> retrieveAll();

	
	@Select("INSERT INTO test.person(id, first_name, last_name, email, phone) values(#{id}, #{firstName}, #{lastName}, #{email}, #{phone})")
	public void create(PersonModel model);
	
	@Select("SELECT p.id, p.first_name, p.last_name, p.email, p.phone FROM test.person p WHERE p.id = #{id}")
	@Results(value = {
			@Result(property = "id", column = "id"),
			@Result(property = "firstName", column = "first_name"),
			@Result(property = "lastName", column = "last_name"),
			@Result(property = "email", column = "email"),       
			@Result(property = "phone", column = "phone")
	})
	public PersonModel retrieve(String id);

	@Select("UPDATE test.person SET first_name = #{firstName}, last_name = #{lastName}, email = #{email}, phone = #{phone} WHERE ID = #{id} ")
	public void update(PersonModel model);
	
	@Select("DELETE FROM test.person WHERE ID  = #{id}")
	public void delete(String id);
}