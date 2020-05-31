package com.hackerrank.stackhack.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.StreamUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.stackhack.model.Task;
import com.hackerrank.stackhack.repository.TaskRepository;

@RestController
@RequestMapping(path = "todoList")
@CrossOrigin
public class TaskController {
	
	@Autowired
	TaskRepository taskRepository;
	
	@GetMapping(path = "healthcheck")
	public String healthCheck() {
		return "Application is up and Running";
	}
	
	@GetMapping(path="getTasks")
	public ResponseEntity<List<Task>> getTasks(){
		return new ResponseEntity<List<Task>>(StreamUtils.createStreamFromIterator(taskRepository.findAll().iterator()).collect(Collectors.toList()),HttpStatus.OK);
	}
	
	@GetMapping(path="getTask/{id}")
	public ResponseEntity<Task> getTasks(@PathVariable String id){
		return new ResponseEntity<Task>(taskRepository.findById(id).get(),HttpStatus.OK);
	}
	
	@PostMapping(path="addTask")
	public ResponseEntity<String> addTask(@RequestBody Task task){
		taskRepository.save(task);
		return new ResponseEntity<String>("Added",HttpStatus.OK); 
	}
	
	@PutMapping(path="setDueDate")
	public ResponseEntity<String> setDueDate(@RequestParam String idToUpdate, @RequestParam String dueDate) throws ParseException{
		Task taskToUpdate = taskRepository.findById(idToUpdate).get();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			taskToUpdate.setDueDate(formatter.parse(dueDate));
		taskRepository.save(taskToUpdate);
		return new ResponseEntity<String>("Due Date Changed",HttpStatus.OK); 
	}
	
}
