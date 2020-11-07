package com.manish;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;
import static spark.Spark.delete;
import static spark.Spark.port;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.manish.model.PersonModel;
import com.manish.service.TestService;

public class Main {
	
    public static void main(String[] args) {
    	
    	final Logger logger = LoggerFactory.getLogger(Main.class);
    	
    	final TestService service = new TestService();
    	
    	final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    	
    	port(8080);
        
        //Get single object
        get("/api/person/:id", (request, response) -> {
        	logger.info("Request received for id = :id");
            response.type("application/json");
            return gson.toJson(new StandardResponse(StatusResponse.SUCCESS,new Gson().toJsonTree(service.retrieve(request.params(":id")))));
        });
    
        //Get all
        get("/api/person", (request, response) -> {
        	logger.info("Request received for all");
            response.type("application/json");
            return gson.toJson(new StandardResponse(StatusResponse.SUCCESS,new Gson().toJsonTree(service.retrieveAll())));
        });
        
        //Create Person
        post("/api/person", (request, response) -> {
        	logger.info("Person add Request received");
        	PersonModel model = new PersonModel();
        	model.setFirstName(request.queryParams("firstName"));
        	model.setLastName(request.queryParams("lastName"));
        	model.setEmail(request.queryParams("email"));
        	model.setPhone(request.queryParams("phone"));
            service.create(model);
            response.type("application/json");
            return gson.toJson(new StandardResponse(StatusResponse.SUCCESS));
        });
        
        //Update person
        put("/api/person/:id", (request, response) -> {
            String id = request.params(":id");
            PersonModel model = service.retrieve(id);
            if (model != null) {
            	model.setFirstName(request.queryParams("firstName"));
            	model.setLastName(request.queryParams("lastName"));
            	model.setEmail(request.queryParams("email"));
            	model.setPhone(request.queryParams("phone"));
                service.update(model);
                response.type("application/json");
                return gson.toJson(new StandardResponse(StatusResponse.SUCCESS));
            } else {
            	response.type("application/json");
                response.status(404);
                return gson.toJson(new StandardResponse(StatusResponse.ERROR));
            }
        });
 
        // DELETE - delete person
        delete("/api/person/:id", (request, response) -> {
            String id = request.params(":id");
            PersonModel model = service.retrieve(id);
            if (model != null) {
            	service.delete(id);
            	response.type("application/json");
                return gson.toJson(new StandardResponse(StatusResponse.SUCCESS));
            } else {
            	response.type("application/json");
                response.status(404);
                return gson.toJson(new StandardResponse(StatusResponse.ERROR));
            }
        });
    }
}