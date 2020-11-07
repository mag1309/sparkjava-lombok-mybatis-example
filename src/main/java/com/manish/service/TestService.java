package com.manish.service;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.manish.mapper.TestMapper;
import com.manish.model.PersonModel;
import com.manish.session.DatabaseSession;

public class TestService { 
	
	public List<PersonModel> retrieveAll() throws IOException{
	      
		   SqlSession session =  null;
		   List<PersonModel> models = null;
		   TestMapper mapper = null;
		   try
		   {
	          session = DatabaseSession.getSession();   
	          mapper = session.getMapper(TestMapper.class);      
	         
	          //select a particular student  by  id	
	          models = (List<PersonModel>) mapper.retrieveAll(); 
	      } finally {

	          if (session != null) {
	              session.close();
	          }
	      }
		  return models;			
		}
	
	public void create(PersonModel model) throws IOException
	{	      
	   SqlSession session =  null;
	   TestMapper mapper = null;
	   try
	   {
          
		   if(model != null)
		   {
			   session = DatabaseSession.getSession();   
		       mapper = session.getMapper(TestMapper.class);      
		         
		       //select a particular student  by  id	
		       mapper.create(model); 
		   }
		     
	   } finally {

          if (session != null) {
              session.close();
          }
	   }
	}

	
	public PersonModel retrieve(String id) throws IOException{
      
	   SqlSession session =  null;
	   PersonModel model = null;
	   TestMapper mapper = null;
	   try
	   {
          session = DatabaseSession.getSession();   
          mapper = session.getMapper(TestMapper.class);      
         
          //select a particular student  by  id	
          model = (PersonModel) mapper.retrieve(id); 
      } finally {

          if (session != null) {
              session.close();
          }
      }
	  return model;			
	}
	
	public void update(PersonModel model) throws IOException
	{	      
	   SqlSession session =  null;
	   TestMapper mapper = null;
	   try
	   {
          
		   if(model != null)
		   {
			   session = DatabaseSession.getSession();   
		       mapper = session.getMapper(TestMapper.class);      
		         
		       //select a particular student  by  id	
		       mapper.update(model); 
		   }
		     
	   } finally {

          if (session != null) {
              session.close();
          }
	   }
	}
	
	public void delete(String id) throws IOException
	{	      
	   SqlSession session =  null;
	   TestMapper mapper = null;
	   try
	   {
          
		   if(id != null)
		   {
			   session = DatabaseSession.getSession();   
		       mapper = session.getMapper(TestMapper.class);      
		         
		       //select a particular student  by  id	
		       mapper.delete(id); 
		   }
		     
	   } finally {

          if (session != null) {
              session.close();
          }
	   }
	}


   
   public static void main(String[] args)
   {
	   TestService service = new TestService();
	   try {
		   
		service.retrieve("1");
		PersonModel model = new PersonModel();
		model.setFirstName("Test");
		model.setLastName("Test");
		model.setEmail("test@test.com");
		model.setPhone("1234567890");
		service.create(model);
		
		model = new PersonModel();
		model.setId("2");
		model.setFirstName("Test2");
		model.setLastName("Test2");
		model.setEmail("test2@test.com");
		model.setPhone("2234567890");
		service.update(model);
		
		service.delete("1");
		
		service.retrieveAll();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
}
