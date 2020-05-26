package com.hackerrank.stackhack.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.StreamUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.stackhack.model.TaskModel;
import com.hackerrank.stackhack.repository.TaskRepository;

@RestController
@RequestMapping(path = "todoList")
public class TaskController {
	
	@Autowired
	TaskRepository taskRepository;
	
	@GetMapping(path = "healthcheck")
	public String healthCheck() {
		return "Application is up and Running";
	}
	
	@GetMapping(path="getTasks")
	public ResponseEntity<List<TaskModel>> getTasks(){
		return new ResponseEntity<List<TaskModel>>(StreamUtils.createStreamFromIterator(taskRepository.findAll().iterator()).collect(Collectors.toList()),HttpStatus.OK);
	}
	
	@PutMapping(path="addTask",consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> addTask(@RequestParam TaskModel taskModel){
		taskRepository.save(taskModel);
		return new ResponseEntity<String>("Added",HttpStatus.OK); 
	}
	
}